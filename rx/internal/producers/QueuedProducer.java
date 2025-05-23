package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.BackpressureUtils;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

/* loaded from: classes29.dex */
public final class QueuedProducer<T> extends AtomicLong implements Producer, Observer<T> {
    static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    final Subscriber<? super T> child;
    volatile boolean done;
    Throwable error;
    final Queue<Object> queue;
    final AtomicInteger wip;

    public QueuedProducer(Subscriber<? super T> subscriber) {
        this(subscriber, UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue() : new SpscLinkedAtomicQueue());
    }

    private boolean checkTerminated(boolean z16, boolean z17) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (z16) {
            Throwable th5 = this.error;
            if (th5 != null) {
                this.queue.clear();
                this.child.onError(th5);
                return true;
            }
            if (z17) {
                this.child.onCompleted();
                return true;
            }
            return false;
        }
        return false;
    }

    private void drain() {
        boolean z16;
        if (this.wip.getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.child;
            Queue<Object> queue = this.queue;
            while (!checkTerminated(this.done, queue.isEmpty())) {
                this.wip.lazySet(1);
                long j3 = get();
                long j16 = 0;
                while (j3 != 0) {
                    boolean z17 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (checkTerminated(z17, z16)) {
                        return;
                    }
                    if (poll == null) {
                        break;
                    }
                    try {
                        if (poll == NULL_SENTINEL) {
                            subscriber.onNext(null);
                        } else {
                            subscriber.onNext(poll);
                        }
                        j3--;
                        j16++;
                    } catch (Throwable th5) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        Exceptions.throwOrReport(th5, subscriber, poll);
                        return;
                    }
                }
                if (j16 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j16);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t16) {
        if (t16 == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t16)) {
            return false;
        }
        drain();
        return true;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.error = th5;
        this.done = true;
        drain();
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        if (!offer(t16)) {
            onError(new MissingBackpressureException());
        }
    }

    @Override // rx.Producer
    public void request(long j3) {
        if (j3 >= 0) {
            if (j3 > 0) {
                BackpressureUtils.getAndAddRequest(this, j3);
                drain();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public QueuedProducer(Subscriber<? super T> subscriber, Queue<Object> queue) {
        this.child = subscriber;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
