package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.TrampolineScheduler;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorObserveOn<T> implements Observable.Operator<T, T> {
    private final int bufferSize;
    private final boolean delayError;
    private final Scheduler scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ObserveOnSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;
        final boolean delayError;
        long emitted;
        Throwable error;
        volatile boolean finished;
        final int limit;
        final Queue<Object> queue;
        final Scheduler.Worker recursiveScheduler;
        final AtomicLong requested = new AtomicLong();
        final AtomicLong counter = new AtomicLong();

        /* renamed from: on, reason: collision with root package name */
        final NotificationLite<T> f432674on = NotificationLite.instance();

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z16, int i3) {
            this.child = subscriber;
            this.recursiveScheduler = scheduler.createWorker();
            this.delayError = z16;
            i3 = i3 <= 0 ? RxRingBuffer.SIZE : i3;
            this.limit = i3 - (i3 >> 2);
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i3);
            } else {
                this.queue = new SpscAtomicArrayQueue(i3);
            }
            request(i3);
        }

        @Override // rx.functions.Action0
        public void call() {
            boolean z16;
            long j3 = this.emitted;
            Queue<Object> queue = this.queue;
            Subscriber<? super T> subscriber = this.child;
            NotificationLite<T> notificationLite = this.f432674on;
            long j16 = 1;
            do {
                long j17 = this.requested.get();
                while (j17 != j3) {
                    boolean z17 = this.finished;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (checkTerminated(z17, z16, subscriber, queue)) {
                        return;
                    }
                    if (z16) {
                        break;
                    }
                    subscriber.onNext(notificationLite.getValue(poll));
                    j3++;
                    if (j3 == this.limit) {
                        j17 = BackpressureUtils.produced(this.requested, j3);
                        request(j3);
                        j3 = 0;
                    }
                }
                if (j17 == j3 && checkTerminated(this.finished, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                this.emitted = j3;
                j16 = this.counter.addAndGet(-j16);
            } while (j16 != 0);
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<? super T> subscriber, Queue<Object> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (z16) {
                if (this.delayError) {
                    if (z17) {
                        Throwable th5 = this.error;
                        try {
                            if (th5 != null) {
                                subscriber.onError(th5);
                            } else {
                                subscriber.onCompleted();
                            }
                            return false;
                        } finally {
                        }
                    }
                    return false;
                }
                Throwable th6 = this.error;
                if (th6 != null) {
                    queue.clear();
                    try {
                        subscriber.onError(th6);
                        return true;
                    } finally {
                    }
                }
                if (z17) {
                    try {
                        subscriber.onCompleted();
                        return true;
                    } finally {
                    }
                }
                return false;
            }
            return false;
        }

        void init() {
            Subscriber<? super T> subscriber = this.child;
            subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber.1
                @Override // rx.Producer
                public void request(long j3) {
                    if (j3 > 0) {
                        BackpressureUtils.getAndAddRequest(ObserveOnSubscriber.this.requested, j3);
                        ObserveOnSubscriber.this.schedule();
                    }
                }
            });
            subscriber.add(this.recursiveScheduler);
            subscriber.add(this);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!isUnsubscribed() && !this.finished) {
                this.finished = true;
                schedule();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!isUnsubscribed() && !this.finished) {
                this.error = th5;
                this.finished = true;
                schedule();
                return;
            }
            RxJavaHooks.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!isUnsubscribed() && !this.finished) {
                if (!this.queue.offer(this.f432674on.next(t16))) {
                    onError(new MissingBackpressureException());
                } else {
                    schedule();
                }
            }
        }

        protected void schedule() {
            if (this.counter.getAndIncrement() == 0) {
                this.recursiveScheduler.schedule(this);
            }
        }
    }

    public OperatorObserveOn(Scheduler scheduler, boolean z16) {
        this(scheduler, z16, RxRingBuffer.SIZE);
    }

    public static <T> Observable.Operator<T, T> rebatch(final int i3) {
        return new Observable.Operator<T, T>() { // from class: rx.internal.operators.OperatorObserveOn.1
            @Override // rx.functions.Func1
            public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
                ObserveOnSubscriber observeOnSubscriber = new ObserveOnSubscriber(Schedulers.immediate(), subscriber, false, i3);
                observeOnSubscriber.init();
                return observeOnSubscriber;
            }
        };
    }

    public OperatorObserveOn(Scheduler scheduler, boolean z16, int i3) {
        this.scheduler = scheduler;
        this.delayError = z16;
        this.bufferSize = i3 <= 0 ? RxRingBuffer.SIZE : i3;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler scheduler = this.scheduler;
        if ((scheduler instanceof ImmediateScheduler) || (scheduler instanceof TrampolineScheduler)) {
            return subscriber;
        }
        ObserveOnSubscriber observeOnSubscriber = new ObserveOnSubscriber(scheduler, subscriber, this.delayError, this.bufferSize);
        observeOnSubscriber.init();
        return observeOnSubscriber;
    }
}
