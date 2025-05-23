package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BackpressureUtils {
    static final long COMPLETED_MASK = Long.MIN_VALUE;
    static final long REQUESTED_MASK = Long.MAX_VALUE;

    BackpressureUtils() {
        throw new IllegalStateException("No instances!");
    }

    public static long addCap(long j3, long j16) {
        long j17 = j3 + j16;
        if (j17 < 0) {
            return Long.MAX_VALUE;
        }
        return j17;
    }

    @Deprecated
    public static <T> long getAndAddRequest(AtomicLongFieldUpdater<T> atomicLongFieldUpdater, T t16, long j3) {
        long j16;
        do {
            j16 = atomicLongFieldUpdater.get(t16);
        } while (!atomicLongFieldUpdater.compareAndSet(t16, j16, addCap(j16, j3)));
        return j16;
    }

    public static long multiplyCap(long j3, long j16) {
        long j17 = j3 * j16;
        if (((j3 | j16) >>> 31) != 0 && j16 != 0 && j17 / j16 != j3) {
            return Long.MAX_VALUE;
        }
        return j17;
    }

    public static <T> void postCompleteDone(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super T> subscriber) {
        postCompleteDone(atomicLong, queue, subscriber, UtilityFunctions.identity());
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        r0 = r10.addAndGet(-(r6 & Long.MAX_VALUE));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T, R> void postCompleteDrain(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j3 = atomicLong.get();
        if (j3 == Long.MAX_VALUE) {
            while (!subscriber.isUnsubscribed()) {
                Object poll = queue.poll();
                if (poll == null) {
                    subscriber.onCompleted();
                    return;
                }
                subscriber.onNext(func1.call(poll));
            }
            return;
        }
        do {
            long j16 = Long.MIN_VALUE;
            while (true) {
                if (j16 != j3) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    Object poll2 = queue.poll();
                    if (poll2 == null) {
                        subscriber.onCompleted();
                        return;
                    } else {
                        subscriber.onNext(func1.call(poll2));
                        j16++;
                    }
                } else {
                    if (j16 == j3) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (queue.isEmpty()) {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    j3 = atomicLong.get();
                    if (j3 == j16) {
                        break;
                    }
                }
            }
        } while (j3 != Long.MIN_VALUE);
    }

    public static <T> boolean postCompleteRequest(AtomicLong atomicLong, long j3, Queue<T> queue, Subscriber<? super T> subscriber) {
        return postCompleteRequest(atomicLong, j3, queue, subscriber, UtilityFunctions.identity());
    }

    public static long produced(AtomicLong atomicLong, long j3) {
        long j16;
        long j17;
        do {
            j16 = atomicLong.get();
            if (j16 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j17 = j16 - j3;
            if (j17 < 0) {
                throw new IllegalStateException("More produced than requested: " + j17);
            }
        } while (!atomicLong.compareAndSet(j16, j17));
        return j17;
    }

    public static boolean validate(long j3) {
        if (j3 >= 0) {
            if (j3 != 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j3);
    }

    public static <T, R> void postCompleteDone(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j3;
        do {
            j3 = atomicLong.get();
            if ((j3 & Long.MIN_VALUE) != 0) {
                return;
            }
        } while (!atomicLong.compareAndSet(j3, Long.MIN_VALUE | j3));
        if (j3 != 0) {
            postCompleteDrain(atomicLong, queue, subscriber, func1);
        }
    }

    public static <T, R> boolean postCompleteRequest(AtomicLong atomicLong, long j3, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j16;
        long j17;
        if (j3 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j3);
        }
        if (j3 == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        }
        do {
            j16 = atomicLong.get();
            j17 = j16 & Long.MIN_VALUE;
        } while (!atomicLong.compareAndSet(j16, addCap(Long.MAX_VALUE & j16, j3) | j17));
        if (j16 != Long.MIN_VALUE) {
            return j17 == 0;
        }
        postCompleteDrain(atomicLong, queue, subscriber, func1);
        return false;
    }

    public static long getAndAddRequest(AtomicLong atomicLong, long j3) {
        long j16;
        do {
            j16 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j16, addCap(j16, j3)));
        return j16;
    }
}
