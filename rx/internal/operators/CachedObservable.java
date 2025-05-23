package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        final SerialSubscription connection;
        volatile boolean isConnected;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432654nl;
        volatile ReplayProducer<?>[] producers;
        final Observable<? extends T> source;
        boolean sourceDone;

        public CacheState(Observable<? extends T> observable, int i3) {
            super(i3);
            this.source = observable;
            this.producers = EMPTY;
            this.f432654nl = NotificationLite.instance();
            this.connection = new SerialSubscription();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void addProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[length + 1];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
                this.producers = replayProducerArr2;
            }
        }

        public void connect() {
            Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.CachedObservable.CacheState.1
                @Override // rx.Observer
                public void onCompleted() {
                    CacheState.this.onCompleted();
                }

                @Override // rx.Observer
                public void onError(Throwable th5) {
                    CacheState.this.onError(th5);
                }

                @Override // rx.Observer
                public void onNext(T t16) {
                    CacheState.this.onNext(t16);
                }
            };
            this.connection.set(subscriber);
            this.source.unsafeSubscribe(subscriber);
            this.isConnected = true;
        }

        void dispatch() {
            for (ReplayProducer<?> replayProducer : this.producers) {
                replayProducer.replay();
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(this.f432654nl.completed());
                this.connection.unsubscribe();
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(this.f432654nl.error(th5));
                this.connection.unsubscribe();
                dispatch();
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!this.sourceDone) {
                add(this.f432654nl.next(t16));
                dispatch();
            }
        }

        public void removeProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        if (replayProducerArr[i3].equals(replayProducer)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    this.producers = EMPTY;
                    return;
                }
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[length - 1];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i3);
                System.arraycopy(replayProducerArr, i3 + 1, replayProducerArr2, i3, (length - i3) - 1);
                this.producers = replayProducerArr2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        final CacheState<T> state;

        public CachedSubscribe(CacheState<T> cacheState) {
            this.state = cacheState;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer<T> replayProducer = new ReplayProducer<>(subscriber, this.state);
            this.state.addProducer(replayProducer);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (get() || !compareAndSet(false, true)) {
                return;
            }
            this.state.connect();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        final Subscriber<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        boolean emitting;
        int index;
        boolean missed;
        final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        public long produced(long j3) {
            return addAndGet(-j3);
        }

        public void replay() {
            boolean z16;
            synchronized (this) {
                boolean z17 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                try {
                    NotificationLite<T> notificationLite = this.state.f432654nl;
                    Subscriber<? super T> subscriber = this.child;
                    while (true) {
                        long j3 = get();
                        if (j3 < 0) {
                            return;
                        }
                        int size = this.state.size();
                        try {
                            if (size != 0) {
                                Object[] objArr = this.currentBuffer;
                                if (objArr == null) {
                                    objArr = this.state.head();
                                    this.currentBuffer = objArr;
                                }
                                int length = objArr.length - 1;
                                int i3 = this.index;
                                int i16 = this.currentIndexInBuffer;
                                if (j3 == 0) {
                                    Object obj = objArr[i16];
                                    if (notificationLite.isCompleted(obj)) {
                                        subscriber.onCompleted();
                                        unsubscribe();
                                        return;
                                    } else if (notificationLite.isError(obj)) {
                                        subscriber.onError(notificationLite.getError(obj));
                                        unsubscribe();
                                        return;
                                    }
                                } else if (j3 > 0) {
                                    int i17 = 0;
                                    while (i3 < size && j3 > 0) {
                                        if (subscriber.isUnsubscribed()) {
                                            return;
                                        }
                                        if (i16 == length) {
                                            objArr = (Object[]) objArr[length];
                                            i16 = 0;
                                        }
                                        Object obj2 = objArr[i16];
                                        try {
                                            if (notificationLite.accept(subscriber, obj2)) {
                                                try {
                                                    unsubscribe();
                                                    return;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    z16 = true;
                                                    try {
                                                        Exceptions.throwIfFatal(th);
                                                        unsubscribe();
                                                        if (!notificationLite.isError(obj2) && !notificationLite.isCompleted(obj2)) {
                                                            subscriber.onError(OnErrorThrowable.addValueAsLastCause(th, notificationLite.getValue(obj2)));
                                                            return;
                                                        }
                                                        return;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        z17 = z16;
                                                        if (!z17) {
                                                            synchronized (this) {
                                                                this.emitting = false;
                                                            }
                                                        }
                                                        throw th;
                                                    }
                                                }
                                            }
                                            i16++;
                                            i3++;
                                            j3--;
                                            i17++;
                                        } catch (Throwable th7) {
                                            th = th7;
                                            z16 = false;
                                        }
                                    }
                                    if (subscriber.isUnsubscribed()) {
                                        return;
                                    }
                                    this.index = i3;
                                    this.currentIndexInBuffer = i16;
                                    this.currentBuffer = objArr;
                                    produced(i17);
                                }
                            }
                            try {
                                synchronized (this) {
                                    try {
                                        if (!this.missed) {
                                            this.emitting = false;
                                            return;
                                        }
                                        this.missed = false;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        throw th;
                                    }
                                }
                            } catch (Throwable th9) {
                                th = th9;
                            }
                        } catch (Throwable th10) {
                            th = th10;
                        }
                    }
                } catch (Throwable th11) {
                    th = th11;
                    z17 = false;
                }
            }
        }

        @Override // rx.Producer
        public void request(long j3) {
            long j16;
            long j17;
            do {
                j16 = get();
                if (j16 < 0) {
                    return;
                }
                j17 = j16 + j3;
                if (j17 < 0) {
                    j17 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j16, j17));
            replay();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1L) >= 0) {
                this.state.removeProducer(this);
            }
        }
    }

    CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> cacheState) {
        super(onSubscribe);
        this.state = cacheState;
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable) {
        return from(observable, 16);
    }

    boolean hasObservers() {
        if (this.state.producers.length != 0) {
            return true;
        }
        return false;
    }

    boolean isConnected() {
        return this.state.isConnected;
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable, int i3) {
        if (i3 >= 1) {
            CacheState cacheState = new CacheState(observable, i3);
            return new CachedObservable<>(new CachedSubscribe(cacheState), cacheState);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }
}
