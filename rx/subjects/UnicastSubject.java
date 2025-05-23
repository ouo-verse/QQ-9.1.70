package rx.subjects;

import androidx.lifecycle.c;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.internal.operators.BackpressureUtils;
import rx.internal.operators.NotificationLite;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public final class UnicastSubject<T> extends Subject<T, T> {
    final State<T> state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class State<T> extends AtomicLong implements Producer, Observer<T>, Observable.OnSubscribe<T>, Subscription {
        private static final long serialVersionUID = -9044104859202255786L;
        volatile boolean caughtUp;
        volatile boolean done;
        boolean emitting;
        Throwable error;
        boolean missed;
        final Queue<Object> queue;
        final AtomicReference<Action0> terminateOnce;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432882nl = NotificationLite.instance();
        final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();

        public State(int i3, Action0 action0) {
            AtomicReference<Action0> atomicReference;
            Queue<Object> spscLinkedAtomicQueue;
            Queue<Object> queue;
            if (action0 != null) {
                atomicReference = new AtomicReference<>(action0);
            } else {
                atomicReference = null;
            }
            this.terminateOnce = atomicReference;
            if (i3 > 1) {
                if (UnsafeAccess.isUnsafeAvailable()) {
                    queue = new SpscUnboundedArrayQueue<>(i3);
                } else {
                    queue = new SpscUnboundedAtomicArrayQueue<>(i3);
                }
            } else {
                if (UnsafeAccess.isUnsafeAvailable()) {
                    spscLinkedAtomicQueue = new SpscLinkedQueue<>();
                } else {
                    spscLinkedAtomicQueue = new SpscLinkedAtomicQueue<>();
                }
                queue = spscLinkedAtomicQueue;
            }
            this.queue = queue;
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<? super T> subscriber) {
            if (subscriber.isUnsubscribed()) {
                this.queue.clear();
                return true;
            }
            if (z16) {
                Throwable th5 = this.error;
                if (th5 != null) {
                    this.queue.clear();
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

        void doTerminate() {
            Action0 action0;
            AtomicReference<Action0> atomicReference = this.terminateOnce;
            if (atomicReference != null && (action0 = atomicReference.get()) != null && c.a(atomicReference, action0, null)) {
                action0.call();
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.done;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                doTerminate();
                boolean z16 = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z16 = false;
                        }
                    }
                    if (z16) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.done) {
                doTerminate();
                this.error = th5;
                boolean z16 = true;
                this.done = true;
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (this.caughtUp) {
                            z16 = false;
                        }
                    }
                    if (z16) {
                        replay();
                        return;
                    }
                }
                this.subscriber.get().onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            boolean z16;
            if (!this.done) {
                if (!this.caughtUp) {
                    synchronized (this) {
                        if (!this.caughtUp) {
                            this.queue.offer(this.f432882nl.next(t16));
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                    }
                    if (z16) {
                        replay();
                        return;
                    }
                }
                Subscriber<? super T> subscriber = this.subscriber.get();
                try {
                    subscriber.onNext(t16);
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, subscriber, t16);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x0081, code lost:
        
            if (r6 == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0087, code lost:
        
            if (r0.isEmpty() == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0089, code lost:
        
            r14.caughtUp = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x008b, code lost:
        
            r14.emitting = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x008e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void replay() {
            boolean z16;
            boolean z17;
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                Queue<Object> queue = this.queue;
                while (true) {
                    Subscriber<? super T> subscriber = this.subscriber.get();
                    if (subscriber != null) {
                        if (checkTerminated(this.done, queue.isEmpty(), subscriber)) {
                            return;
                        }
                        long j3 = get();
                        if (j3 == Long.MAX_VALUE) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        long j16 = 0;
                        while (j3 != 0) {
                            boolean z18 = this.done;
                            Object poll = queue.poll();
                            if (poll == null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (checkTerminated(z18, z17, subscriber)) {
                                return;
                            }
                            if (z17) {
                                break;
                            }
                            T value = this.f432882nl.getValue(poll);
                            try {
                                subscriber.onNext(value);
                                j3--;
                                j16++;
                            } catch (Throwable th5) {
                                queue.clear();
                                Exceptions.throwIfFatal(th5);
                                subscriber.onError(OnErrorThrowable.addValueAsLastCause(th5, value));
                                return;
                            }
                        }
                        if (!z16 && j16 != 0) {
                            addAndGet(-j16);
                        }
                    } else {
                        z16 = false;
                    }
                    synchronized (this) {
                        if (!this.missed) {
                            break;
                        } else {
                            this.missed = false;
                        }
                    }
                }
            }
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 > 0) {
                    BackpressureUtils.getAndAddRequest(this, j3);
                    replay();
                    return;
                } else {
                    if (this.done) {
                        replay();
                        return;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("n >= 0 required");
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            doTerminate();
            this.done = true;
            synchronized (this) {
                if (this.emitting) {
                    return;
                }
                this.emitting = true;
                this.queue.clear();
            }
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            if (c.a(this.subscriber, null, subscriber)) {
                subscriber.add(this);
                subscriber.setProducer(this);
            } else {
                subscriber.onError(new IllegalStateException("Only a single subscriber is allowed"));
            }
        }
    }

    UnicastSubject(State<T> state) {
        super(state);
        this.state = state;
    }

    public static <T> UnicastSubject<T> create() {
        return create(16);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        if (this.state.subscriber.get() != null) {
            return true;
        }
        return false;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.state.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.state.onError(th5);
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.state.onNext(t16);
    }

    public static <T> UnicastSubject<T> create(int i3) {
        return new UnicastSubject<>(new State(i3, null));
    }

    public static <T> UnicastSubject<T> create(int i3, Action0 action0) {
        return new UnicastSubject<>(new State(i3, action0));
    }
}
