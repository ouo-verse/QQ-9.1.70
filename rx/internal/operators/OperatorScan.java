package rx.internal.operators;

import ADV_REPORT.mobile_adv_report_req;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorScan<R, T> implements Observable.Operator<R, T> {
    private static final Object NO_INITIAL_VALUE = new Object();
    final Func2<R, ? super T, R> accumulator;
    private final Func0<R> initialValueFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class InitialProducer<R> implements Producer, Observer<R> {
        final Subscriber<? super R> child;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        long missedRequested;
        volatile Producer producer;
        final Queue<Object> queue;
        final AtomicLong requested;

        public InitialProducer(R r16, Subscriber<? super R> subscriber) {
            Queue<Object> spscLinkedAtomicQueue;
            this.child = subscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                spscLinkedAtomicQueue = new SpscLinkedQueue<>();
            } else {
                spscLinkedAtomicQueue = new SpscLinkedAtomicQueue<>();
            }
            this.queue = spscLinkedAtomicQueue;
            spscLinkedAtomicQueue.offer(NotificationLite.instance().next(r16));
            this.requested = new AtomicLong();
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (z16) {
                Throwable th5 = this.error;
                if (th5 != null) {
                    subscriber.onError(th5);
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

        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    emitLoop();
                }
            }
        }

        void emitLoop() {
            boolean z16;
            Subscriber<? super R> subscriber = this.child;
            Queue<Object> queue = this.queue;
            NotificationLite instance = NotificationLite.instance();
            AtomicLong atomicLong = this.requested;
            long j3 = atomicLong.get();
            while (!checkTerminated(this.done, queue.isEmpty(), subscriber)) {
                long j16 = 0;
                while (j16 != j3) {
                    boolean z17 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (checkTerminated(z17, z16, subscriber)) {
                        return;
                    }
                    if (z16) {
                        break;
                    }
                    mobile_adv_report_req mobile_adv_report_reqVar = (Object) instance.getValue(poll);
                    try {
                        subscriber.onNext(mobile_adv_report_reqVar);
                        j16++;
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, subscriber, mobile_adv_report_reqVar);
                        return;
                    }
                }
                if (j16 != 0 && j3 != Long.MAX_VALUE) {
                    j3 = BackpressureUtils.produced(atomicLong, j16);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.error = th5;
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onNext(R r16) {
            this.queue.offer(NotificationLite.instance().next(r16));
            emit();
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 != 0) {
                    BackpressureUtils.getAndAddRequest(this.requested, j3);
                    Producer producer = this.producer;
                    if (producer == null) {
                        synchronized (this.requested) {
                            producer = this.producer;
                            if (producer == null) {
                                this.missedRequested = BackpressureUtils.addCap(this.missedRequested, j3);
                            }
                        }
                    }
                    if (producer != null) {
                        producer.request(j3);
                    }
                    emit();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j3);
        }

        public void setProducer(Producer producer) {
            long j3;
            producer.getClass();
            synchronized (this.requested) {
                if (this.producer == null) {
                    j3 = this.missedRequested;
                    if (j3 != Long.MAX_VALUE) {
                        j3--;
                    }
                    this.missedRequested = 0L;
                    this.producer = producer;
                } else {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
            }
            if (j3 > 0) {
                producer.request(j3);
            }
            emit();
        }
    }

    public OperatorScan(final R r16, Func2<R, ? super T, R> func2) {
        this((Func0) new Func0<R>() { // from class: rx.internal.operators.OperatorScan.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public R call() {
                return (R) r16;
            }
        }, (Func2) func2);
    }

    public OperatorScan(Func0<R> func0, Func2<R, ? super T, R> func2) {
        this.initialValueFactory = func0;
        this.accumulator = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super R> subscriber) {
        R call = this.initialValueFactory.call();
        if (call == NO_INITIAL_VALUE) {
            return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorScan.2
                boolean once;
                R value;

                @Override // rx.Observer
                public void onCompleted() {
                    subscriber.onCompleted();
                }

                @Override // rx.Observer
                public void onError(Throwable th5) {
                    subscriber.onError(th5);
                }

                @Override // rx.Observer
                public void onNext(T t16) {
                    if (!this.once) {
                        this.once = true;
                    } else {
                        try {
                            t16 = OperatorScan.this.accumulator.call(this.value, t16);
                        } catch (Throwable th5) {
                            Exceptions.throwOrReport(th5, subscriber, t16);
                            return;
                        }
                    }
                    this.value = (R) t16;
                    subscriber.onNext(t16);
                }
            };
        }
        InitialProducer initialProducer = new InitialProducer(call, subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>(call, initialProducer) { // from class: rx.internal.operators.OperatorScan.3
            final /* synthetic */ Object val$initialValue;
            final /* synthetic */ InitialProducer val$ip;
            private R value;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.val$initialValue = call;
                this.val$ip = initialProducer;
                this.value = call;
            }

            @Override // rx.Observer
            public void onCompleted() {
                this.val$ip.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                this.val$ip.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                try {
                    R call2 = OperatorScan.this.accumulator.call(this.value, t16);
                    this.value = call2;
                    this.val$ip.onNext(call2);
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this, t16);
                }
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                this.val$ip.setProducer(producer);
            }
        };
        subscriber.add(subscriber2);
        subscriber.setProducer(initialProducer);
        return subscriber2;
    }

    public OperatorScan(Func2<R, ? super T, R> func2) {
        this(NO_INITIAL_VALUE, func2);
    }
}
