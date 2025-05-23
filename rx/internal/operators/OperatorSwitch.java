package rx.internal.operators;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayError;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);

        Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class HolderDelayError {
        static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);

        HolderDelayError() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class InnerSubscriber<T> extends Subscriber<T> {

        /* renamed from: id, reason: collision with root package name */
        private final long f432682id;
        private final SwitchSubscriber<T> parent;

        InnerSubscriber(long j3, SwitchSubscriber<T> switchSubscriber) {
            this.f432682id = j3;
            this.parent = switchSubscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.parent.complete(this.f432682id);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.parent.error(th5, this.f432682id);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.parent.emit(t16, this);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.parent.innerProducer(producer, this.f432682id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        final Subscriber<? super T> child;
        final boolean delayError;
        boolean emitting;
        Throwable error;
        boolean innerActive;
        volatile boolean mainDone;
        boolean missed;
        Producer producer;
        long requested;
        final SerialSubscription ssub = new SerialSubscription();
        final AtomicLong index = new AtomicLong();
        final SpscLinkedArrayQueue<Object> queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432683nl = NotificationLite.instance();

        SwitchSubscriber(Subscriber<? super T> subscriber, boolean z16) {
            this.child = subscriber;
            this.delayError = z16;
        }

        protected boolean checkTerminated(boolean z16, boolean z17, Throwable th5, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z18) {
            if (this.delayError) {
                if (z16 && !z17 && z18) {
                    if (th5 != null) {
                        subscriber.onError(th5);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                }
                return false;
            }
            if (th5 != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th5);
                return true;
            }
            if (z16 && !z17 && z18) {
                subscriber.onCompleted();
                return true;
            }
            return false;
        }

        void childRequested(long j3) {
            Producer producer;
            synchronized (this) {
                producer = this.producer;
                this.requested = BackpressureUtils.addCap(this.requested, j3);
            }
            if (producer != null) {
                producer.request(j3);
            }
            drain();
        }

        void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        void complete(long j3) {
            synchronized (this) {
                if (this.index.get() != j3) {
                    return;
                }
                this.innerActive = false;
                this.producer = null;
                drain();
            }
        }

        void drain() {
            Throwable th5;
            Throwable th6;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                boolean z16 = this.innerActive;
                long j3 = this.requested;
                Throwable th7 = this.error;
                if (th7 != null && th7 != (th6 = TERMINAL_ERROR) && !this.delayError) {
                    this.error = th6;
                }
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                AtomicLong atomicLong = this.index;
                Subscriber<? super T> subscriber = this.child;
                long j16 = j3;
                Throwable th8 = th7;
                boolean z17 = this.mainDone;
                while (true) {
                    long j17 = 0;
                    while (j17 != j16) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (checkTerminated(z17, z16, th8, spscLinkedArrayQueue, subscriber, isEmpty)) {
                            return;
                        }
                        if (isEmpty) {
                            break;
                        }
                        InnerSubscriber innerSubscriber = (InnerSubscriber) spscLinkedArrayQueue.poll();
                        T value = this.f432683nl.getValue(spscLinkedArrayQueue.poll());
                        if (atomicLong.get() == innerSubscriber.f432682id) {
                            subscriber.onNext(value);
                            j17++;
                        }
                    }
                    if (j17 == j16) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (checkTerminated(this.mainDone, z16, th8, spscLinkedArrayQueue, subscriber, spscLinkedArrayQueue.isEmpty())) {
                            return;
                        }
                    }
                    synchronized (this) {
                        long j18 = this.requested;
                        if (j18 != Long.MAX_VALUE) {
                            j18 -= j17;
                            this.requested = j18;
                        }
                        j16 = j18;
                        if (!this.missed) {
                            this.emitting = false;
                            return;
                        }
                        this.missed = false;
                        z17 = this.mainDone;
                        z16 = this.innerActive;
                        th8 = this.error;
                        if (th8 != null && th8 != (th5 = TERMINAL_ERROR) && !this.delayError) {
                            this.error = th5;
                        }
                    }
                }
            }
        }

        void emit(T t16, InnerSubscriber<T> innerSubscriber) {
            synchronized (this) {
                if (this.index.get() != ((InnerSubscriber) innerSubscriber).f432682id) {
                    return;
                }
                this.queue.offer(innerSubscriber, this.f432683nl.next(t16));
                drain();
            }
        }

        void error(Throwable th5, long j3) {
            boolean z16;
            synchronized (this) {
                if (this.index.get() == j3) {
                    z16 = updateError(th5);
                    this.innerActive = false;
                    this.producer = null;
                } else {
                    z16 = true;
                }
            }
            if (z16) {
                drain();
            } else {
                pluginError(th5);
            }
        }

        void init() {
            this.child.add(this.ssub);
            this.child.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorSwitch.SwitchSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorSwitch.SwitchSubscriber.2
                @Override // rx.Producer
                public void request(long j3) {
                    if (j3 > 0) {
                        SwitchSubscriber.this.childRequested(j3);
                    } else {
                        if (j3 >= 0) {
                            return;
                        }
                        throw new IllegalArgumentException("n >= 0 expected but it was " + j3);
                    }
                }
            });
        }

        void innerProducer(Producer producer, long j3) {
            synchronized (this) {
                if (this.index.get() != j3) {
                    return;
                }
                long j16 = this.requested;
                this.producer = producer;
                producer.request(j16);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            boolean updateError;
            synchronized (this) {
                updateError = updateError(th5);
            }
            if (updateError) {
                this.mainDone = true;
                drain();
            } else {
                pluginError(th5);
            }
        }

        void pluginError(Throwable th5) {
            RxJavaHooks.onError(th5);
        }

        boolean updateError(Throwable th5) {
            Throwable th6 = this.error;
            if (th6 == TERMINAL_ERROR) {
                return false;
            }
            if (th6 == null) {
                this.error = th5;
            } else if (th6 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th6).getExceptions());
                arrayList.add(th5);
                this.error = new CompositeException(arrayList);
            } else {
                this.error = new CompositeException(th6, th5);
            }
            return true;
        }

        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) {
            InnerSubscriber innerSubscriber;
            long incrementAndGet = this.index.incrementAndGet();
            Subscription subscription = this.ssub.get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                innerSubscriber = new InnerSubscriber(incrementAndGet, this);
                this.innerActive = true;
                this.producer = null;
            }
            this.ssub.set(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
        }
    }

    OperatorSwitch(boolean z16) {
        this.delayError = z16;
    }

    public static <T> OperatorSwitch<T> instance(boolean z16) {
        if (z16) {
            return (OperatorSwitch<T>) HolderDelayError.INSTANCE;
        }
        return (OperatorSwitch<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SwitchSubscriber switchSubscriber = new SwitchSubscriber(subscriber, this.delayError);
        subscriber.add(switchSubscriber);
        switchSubscriber.init();
        return switchSubscriber;
    }
}
