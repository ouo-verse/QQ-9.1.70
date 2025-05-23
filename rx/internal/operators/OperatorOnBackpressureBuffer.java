package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.BackpressureOverflow;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorOnBackpressureBuffer<T> implements Observable.Operator<T, T> {
    private final Long capacity;
    private final Action0 onOverflow;
    private final BackpressureOverflow.Strategy overflowStrategy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BufferSubscriber<T> extends Subscriber<T> implements BackpressureDrainManager.BackpressureQueueCallback {
        private final AtomicLong capacity;
        private final Subscriber<? super T> child;
        private final BackpressureDrainManager manager;
        private final Action0 onOverflow;
        private final BackpressureOverflow.Strategy overflowStrategy;
        private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue<>();
        private final AtomicBoolean saturated = new AtomicBoolean(false);

        /* renamed from: on, reason: collision with root package name */
        private final NotificationLite<T> f432675on = NotificationLite.instance();

        public BufferSubscriber(Subscriber<? super T> subscriber, Long l3, Action0 action0, BackpressureOverflow.Strategy strategy) {
            AtomicLong atomicLong;
            this.child = subscriber;
            if (l3 != null) {
                atomicLong = new AtomicLong(l3.longValue());
            } else {
                atomicLong = null;
            }
            this.capacity = atomicLong;
            this.onOverflow = action0;
            this.manager = new BackpressureDrainManager(this);
            this.overflowStrategy = strategy;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0049 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean assertCapacity() {
            long j3;
            boolean z16;
            Action0 action0;
            if (this.capacity == null) {
                return true;
            }
            do {
                j3 = this.capacity.get();
                if (j3 <= 0) {
                    try {
                    } catch (MissingBackpressureException e16) {
                        if (this.saturated.compareAndSet(false, true)) {
                            unsubscribe();
                            this.child.onError(e16);
                        }
                    }
                    if (this.overflowStrategy.mayAttemptDrop() && poll() != null) {
                        z16 = true;
                        action0 = this.onOverflow;
                        if (action0 != null) {
                            try {
                                action0.call();
                            } catch (Throwable th5) {
                                Exceptions.throwIfFatal(th5);
                                this.manager.terminateAndDrain(th5);
                                return false;
                            }
                        }
                        if (!z16) {
                            return false;
                        }
                    }
                    z16 = false;
                    action0 = this.onOverflow;
                    if (action0 != null) {
                    }
                    if (!z16) {
                    }
                }
            } while (!this.capacity.compareAndSet(j3, j3 - 1));
            return true;
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public boolean accept(Object obj) {
            return this.f432675on.accept(this.child, obj);
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public void complete(Throwable th5) {
            if (th5 != null) {
                this.child.onError(th5);
            } else {
                this.child.onCompleted();
            }
        }

        protected Producer manager() {
            return this.manager;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.saturated.get()) {
                this.manager.terminateAndDrain(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!assertCapacity()) {
                return;
            }
            this.queue.offer(this.f432675on.next(t16));
            this.manager.drain();
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public Object peek() {
            return this.queue.peek();
        }

        @Override // rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback
        public Object poll() {
            Object poll = this.queue.poll();
            AtomicLong atomicLong = this.capacity;
            if (atomicLong != null && poll != null) {
                atomicLong.incrementAndGet();
            }
            return poll;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorOnBackpressureBuffer<?> INSTANCE = new OperatorOnBackpressureBuffer<>();

        Holder() {
        }
    }

    OperatorOnBackpressureBuffer() {
        this.capacity = null;
        this.onOverflow = null;
        this.overflowStrategy = BackpressureOverflow.ON_OVERFLOW_DEFAULT;
    }

    public static <T> OperatorOnBackpressureBuffer<T> instance() {
        return (OperatorOnBackpressureBuffer<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        BufferSubscriber bufferSubscriber = new BufferSubscriber(subscriber, this.capacity, this.onOverflow, this.overflowStrategy);
        subscriber.add(bufferSubscriber);
        subscriber.setProducer(bufferSubscriber.manager());
        return bufferSubscriber;
    }

    public OperatorOnBackpressureBuffer(long j3) {
        this(j3, null, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long j3, Action0 action0) {
        this(j3, action0, BackpressureOverflow.ON_OVERFLOW_DEFAULT);
    }

    public OperatorOnBackpressureBuffer(long j3, Action0 action0, BackpressureOverflow.Strategy strategy) {
        if (j3 <= 0) {
            throw new IllegalArgumentException("Buffer capacity must be > 0");
        }
        if (strategy != null) {
            this.capacity = Long.valueOf(j3);
            this.onOverflow = action0;
            this.overflowStrategy = strategy;
            return;
        }
        throw new NullPointerException("The BackpressureOverflow strategy must not be null");
    }
}
