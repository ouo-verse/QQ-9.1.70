package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observers.SerializedSubscriber;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeConcatMap<T, R> implements Observable.OnSubscribe<R> {
    public static final int BOUNDARY = 1;
    public static final int END = 2;
    public static final int IMMEDIATE = 0;
    final int delayErrorMode;
    final Func1<? super T, ? extends Observable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ConcatMapInnerScalarProducer<T, R> implements Producer {
        boolean once;
        final ConcatMapSubscriber<T, R> parent;
        final R value;

        public ConcatMapInnerScalarProducer(R r16, ConcatMapSubscriber<T, R> concatMapSubscriber) {
            this.value = r16;
            this.parent = concatMapSubscriber;
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (!this.once && j3 > 0) {
                this.once = true;
                ConcatMapSubscriber<T, R> concatMapSubscriber = this.parent;
                concatMapSubscriber.innerNext(this.value);
                concatMapSubscriber.innerCompleted(1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ConcatMapInnerSubscriber<T, R> extends Subscriber<R> {
        final ConcatMapSubscriber<T, R> parent;
        long produced;

        public ConcatMapInnerSubscriber(ConcatMapSubscriber<T, R> concatMapSubscriber) {
            this.parent = concatMapSubscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.innerCompleted(this.produced);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.parent.innerError(th5, this.produced);
        }

        @Override // rx.Observer
        public void onNext(R r16) {
            this.produced++;
            this.parent.innerNext(r16);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.parent.arbiter.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ConcatMapSubscriber<T, R> extends Subscriber<T> {
        volatile boolean active;
        final Subscriber<? super R> actual;
        final int delayErrorMode;
        volatile boolean done;
        final SerialSubscription inner;
        final Func1<? super T, ? extends Observable<? extends R>> mapper;
        final Queue<Object> queue;
        final ProducerArbiter arbiter = new ProducerArbiter();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicReference<Throwable> error = new AtomicReference<>();

        public ConcatMapSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Observable<? extends R>> func1, int i3, int i16) {
            Queue<Object> spscAtomicArrayQueue;
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrorMode = i16;
            if (UnsafeAccess.isUnsafeAvailable()) {
                spscAtomicArrayQueue = new SpscArrayQueue<>(i3);
            } else {
                spscAtomicArrayQueue = new SpscAtomicArrayQueue<>(i3);
            }
            this.queue = spscAtomicArrayQueue;
            this.inner = new SerialSubscription();
            request(i3);
        }

        void drain() {
            boolean z16;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            int i3 = this.delayErrorMode;
            while (!this.actual.isUnsubscribed()) {
                if (!this.active) {
                    if (i3 == 1 && this.error.get() != null) {
                        Throwable terminate = ExceptionsUtils.terminate(this.error);
                        if (!ExceptionsUtils.isTerminated(terminate)) {
                            this.actual.onError(terminate);
                            return;
                        }
                        return;
                    }
                    boolean z17 = this.done;
                    Object poll = this.queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z17 && z16) {
                        Throwable terminate2 = ExceptionsUtils.terminate(this.error);
                        if (terminate2 == null) {
                            this.actual.onCompleted();
                            return;
                        } else {
                            if (!ExceptionsUtils.isTerminated(terminate2)) {
                                this.actual.onError(terminate2);
                                return;
                            }
                            return;
                        }
                    }
                    if (!z16) {
                        try {
                            Observable<? extends R> call = this.mapper.call((Object) NotificationLite.instance().getValue(poll));
                            if (call == null) {
                                drainError(new NullPointerException("The source returned by the mapper was null"));
                                return;
                            }
                            if (call != Observable.empty()) {
                                if (call instanceof ScalarSynchronousObservable) {
                                    this.active = true;
                                    this.arbiter.setProducer(new ConcatMapInnerScalarProducer(((ScalarSynchronousObservable) call).get(), this));
                                } else {
                                    ConcatMapInnerSubscriber concatMapInnerSubscriber = new ConcatMapInnerSubscriber(this);
                                    this.inner.set(concatMapInnerSubscriber);
                                    if (!concatMapInnerSubscriber.isUnsubscribed()) {
                                        this.active = true;
                                        call.unsafeSubscribe(concatMapInnerSubscriber);
                                    } else {
                                        return;
                                    }
                                }
                                request(1L);
                            } else {
                                request(1L);
                            }
                        } catch (Throwable th5) {
                            Exceptions.throwIfFatal(th5);
                            drainError(th5);
                            return;
                        }
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        void drainError(Throwable th5) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.error, th5)) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                    return;
                }
                return;
            }
            pluginError(th5);
        }

        void innerCompleted(long j3) {
            if (j3 != 0) {
                this.arbiter.produced(j3);
            }
            this.active = false;
            drain();
        }

        void innerError(Throwable th5, long j3) {
            if (!ExceptionsUtils.addThrowable(this.error, th5)) {
                pluginError(th5);
                return;
            }
            if (this.delayErrorMode == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
                return;
            }
            if (j3 != 0) {
                this.arbiter.produced(j3);
            }
            this.active = false;
            drain();
        }

        void innerNext(R r16) {
            this.actual.onNext(r16);
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (ExceptionsUtils.addThrowable(this.error, th5)) {
                this.done = true;
                if (this.delayErrorMode == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.inner.unsubscribe();
                    return;
                }
                drain();
                return;
            }
            pluginError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!this.queue.offer(NotificationLite.instance().next(t16))) {
                unsubscribe();
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }

        void pluginError(Throwable th5) {
            RxJavaHooks.onError(th5);
        }

        void requestMore(long j3) {
            if (j3 > 0) {
                this.arbiter.request(j3);
            } else {
                if (j3 >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j3);
            }
        }
    }

    public OnSubscribeConcatMap(Observable<? extends T> observable, Func1<? super T, ? extends Observable<? extends R>> func1, int i3, int i16) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i3;
        this.delayErrorMode = i16;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        final ConcatMapSubscriber concatMapSubscriber = new ConcatMapSubscriber(this.delayErrorMode == 0 ? new SerializedSubscriber<>(subscriber) : subscriber, this.mapper, this.prefetch, this.delayErrorMode);
        subscriber.add(concatMapSubscriber);
        subscriber.add(concatMapSubscriber.inner);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeConcatMap.1
            @Override // rx.Producer
            public void request(long j3) {
                concatMapSubscriber.requestMore(j3);
            }
        });
        if (subscriber.isUnsubscribed()) {
            return;
        }
        this.source.unsafeSubscribe(concatMapSubscriber);
    }
}
