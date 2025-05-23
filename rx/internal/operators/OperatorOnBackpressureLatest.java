package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();

        Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final Subscriber<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        LatestSubscriber<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(NOT_REQUESTED);
        }

        void emit() {
            boolean z16;
            Object obj;
            synchronized (this) {
                boolean z17 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        long j3 = get();
                        if (j3 != Long.MIN_VALUE) {
                            Object obj2 = this.value.get();
                            if (j3 > 0 && obj2 != (obj = EMPTY)) {
                                this.child.onNext(obj2);
                                c.a(this.value, obj2, obj);
                                produced(1L);
                                obj2 = obj;
                            }
                            if (obj2 == EMPTY && this.done) {
                                Throwable th5 = this.terminal;
                                if (th5 != null) {
                                    this.child.onError(th5);
                                } else {
                                    this.child.onCompleted();
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
                                    } catch (Throwable th6) {
                                        th = th6;
                                        z17 = false;
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                            try {
                                throw th;
                            } catch (Throwable th8) {
                                z16 = z17;
                                th = th8;
                                if (!z16) {
                                    synchronized (this) {
                                        this.emitting = false;
                                    }
                                }
                                throw th;
                            }
                        }
                        return;
                    } catch (Throwable th9) {
                        th = th9;
                        z16 = false;
                    }
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.terminal = th5;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.value.lazySet(t16);
            emit();
        }

        long produced(long j3) {
            long j16;
            long j17;
            do {
                j16 = get();
                if (j16 < 0) {
                    return j16;
                }
                j17 = j16 - j3;
            } while (!compareAndSet(j16, j17));
            return j17;
        }

        @Override // rx.Producer
        public void request(long j3) {
            long j16;
            long j17;
            if (j3 < 0) {
                return;
            }
            do {
                j16 = get();
                if (j16 == Long.MIN_VALUE) {
                    return;
                }
                if (j16 == NOT_REQUESTED) {
                    j17 = j3;
                } else {
                    j17 = j16 + j3;
                    if (j17 < 0) {
                        j17 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j16, j17));
            if (j16 == NOT_REQUESTED) {
                this.parent.requestMore(Long.MAX_VALUE);
            }
            emit();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        LatestSubscriber(LatestEmitter<T> latestEmitter) {
            this.producer = latestEmitter;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.producer.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.producer.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.producer.onNext(t16);
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(0L);
        }

        void requestMore(long j3) {
            request(j3);
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return (OperatorOnBackpressureLatest<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        LatestEmitter latestEmitter = new LatestEmitter(subscriber);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(latestEmitter);
        latestEmitter.parent = latestSubscriber;
        subscriber.add(latestSubscriber);
        subscriber.add(latestEmitter);
        subscriber.setProducer(latestEmitter);
        return latestSubscriber;
    }
}
