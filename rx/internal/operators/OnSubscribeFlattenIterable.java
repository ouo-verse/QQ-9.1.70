package rx.internal.operators;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
    final Func1<? super T, ? extends Iterable<? extends R>> mapper;
    final int prefetch;
    final Observable<? extends T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FlattenIterableSubscriber<T, R> extends Subscriber<T> {
        Iterator<? extends R> active;
        final Subscriber<? super R> actual;
        volatile boolean done;
        final long limit;
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        long produced;
        final Queue<Object> queue;
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();
        final AtomicLong requested = new AtomicLong();

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432661nl = NotificationLite.instance();

        public FlattenIterableSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Iterable<? extends R>> func1, int i3) {
            this.actual = subscriber;
            this.mapper = func1;
            if (i3 == Integer.MAX_VALUE) {
                this.limit = Long.MAX_VALUE;
                this.queue = new SpscLinkedArrayQueue(RxRingBuffer.SIZE);
            } else {
                this.limit = i3 - (i3 >> 2);
                if (UnsafeAccess.isUnsafeAvailable()) {
                    this.queue = new SpscArrayQueue(i3);
                } else {
                    this.queue = new SpscAtomicArrayQueue(i3);
                }
            }
            request(i3);
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<?> subscriber, Queue<?> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                this.active = null;
                return true;
            }
            if (z16) {
                if (this.error.get() != null) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    unsubscribe();
                    queue.clear();
                    this.active = null;
                    subscriber.onError(terminate);
                    return true;
                }
                if (z17) {
                    subscriber.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00da A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0010 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00d1 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drain() {
            int i3;
            boolean z16;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super R> subscriber = this.actual;
            Queue<?> queue = this.queue;
            int i16 = 1;
            while (true) {
                Iterator<? extends R> it = this.active;
                boolean z17 = false;
                if (it == null) {
                    boolean z18 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (checkTerminated(z18, z16, subscriber, queue)) {
                        return;
                    }
                    if (!z16) {
                        long j3 = this.produced + 1;
                        i3 = i16;
                        if (j3 == this.limit) {
                            this.produced = 0L;
                            request(j3);
                        } else {
                            this.produced = j3;
                        }
                        try {
                            it = this.mapper.call(this.f432661nl.getValue(poll)).iterator();
                        } catch (Throwable th5) {
                            Exceptions.throwIfFatal(th5);
                            onError(th5);
                        }
                        if (it.hasNext()) {
                            this.active = it;
                            if (it == null) {
                                long j16 = this.requested.get();
                                long j17 = 0;
                                while (j17 != j16) {
                                    if (checkTerminated(this.done, false, subscriber, queue)) {
                                        return;
                                    }
                                    try {
                                        subscriber.onNext(it.next());
                                    } catch (Throwable th6) {
                                        Exceptions.throwIfFatal(th6);
                                        this.active = null;
                                        onError(th6);
                                    }
                                    if (checkTerminated(this.done, false, subscriber, queue)) {
                                        return;
                                    }
                                    j17++;
                                    try {
                                    } catch (Throwable th7) {
                                        Exceptions.throwIfFatal(th7);
                                        this.active = null;
                                        onError(th7);
                                    }
                                    if (!it.hasNext()) {
                                        this.active = null;
                                        it = null;
                                        break;
                                    }
                                }
                                if (j17 == j16) {
                                    boolean z19 = this.done;
                                    if (queue.isEmpty() && it == null) {
                                        z17 = true;
                                    }
                                    if (checkTerminated(z19, z17, subscriber, queue)) {
                                        return;
                                    }
                                }
                                if (j17 != 0) {
                                    BackpressureUtils.produced(this.requested, j17);
                                }
                                if (it == null) {
                                    i16 = i3;
                                }
                            }
                            i16 = this.wip.addAndGet(-i3);
                            if (i16 != 0) {
                                return;
                            }
                        } else {
                            i16 = i3;
                        }
                    }
                }
                i3 = i16;
                if (it == null) {
                }
                i16 = this.wip.addAndGet(-i3);
                if (i16 != 0) {
                }
            }
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
                drain();
            } else {
                RxJavaHooks.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!this.queue.offer(this.f432661nl.next(t16))) {
                unsubscribe();
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }

        void requestMore(long j3) {
            if (j3 > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j3);
                drain();
            } else {
                if (j3 >= 0) {
                    return;
                }
                throw new IllegalStateException("n >= 0 required but it was " + j3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class OnSubscribeScalarFlattenIterable<T, R> implements Observable.OnSubscribe<R> {
        final Func1<? super T, ? extends Iterable<? extends R>> mapper;
        final T value;

        public OnSubscribeScalarFlattenIterable(T t16, Func1<? super T, ? extends Iterable<? extends R>> func1) {
            this.value = t16;
            this.mapper = func1;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super R> subscriber) {
            try {
                Iterator<? extends R> it = this.mapper.call(this.value).iterator();
                if (!it.hasNext()) {
                    subscriber.onCompleted();
                } else {
                    subscriber.setProducer(new OnSubscribeFromIterable.IterableProducer(subscriber, it));
                }
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, subscriber, this.value);
            }
        }
    }

    protected OnSubscribeFlattenIterable(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i3) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i3;
    }

    public static <T, R> Observable<R> createFrom(Observable<? extends T> observable, Func1<? super T, ? extends Iterable<? extends R>> func1, int i3) {
        if (observable instanceof ScalarSynchronousObservable) {
            return Observable.create(new OnSubscribeScalarFlattenIterable(((ScalarSynchronousObservable) observable).get(), func1));
        }
        return Observable.create(new OnSubscribeFlattenIterable(observable, func1, i3));
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        final FlattenIterableSubscriber flattenIterableSubscriber = new FlattenIterableSubscriber(subscriber, this.mapper, this.prefetch);
        subscriber.add(flattenIterableSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeFlattenIterable.1
            @Override // rx.Producer
            public void request(long j3) {
                flattenIterableSubscriber.requestMore(j3);
            }
        });
        this.source.unsafeSubscribe(flattenIterableSubscriber);
    }
}
