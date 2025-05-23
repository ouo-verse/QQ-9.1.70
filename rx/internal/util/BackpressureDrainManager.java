package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.annotations.Experimental;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th5);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0038, code lost:
    
        r1 = r13.terminated;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
    
        if (r5.peek() == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
    
        if (get() != Long.MAX_VALUE) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0050, code lost:
    
        if (r2 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
    
        if (r1 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0058, code lost:
    
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005c, code lost:
    
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0062, code lost:
    
        if (r9 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
    
        if (r2 != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006b, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0066, code lost:
    
        if (r1 == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0068, code lost:
    
        if (r2 == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006e, code lost:
    
        r13.emitting = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0070, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0071, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0042, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0072, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0074, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0075, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002e, code lost:
    
        if (r2 == 0) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        synchronized (this) {
            if (this.emitting) {
                return;
            }
            boolean z16 = true;
            this.emitting = true;
            boolean z17 = this.terminated;
            long j3 = get();
            try {
                BackpressureQueueCallback backpressureQueueCallback = this.actual;
                while (true) {
                    int i3 = 0;
                    while (true) {
                        try {
                            if (j3 > 0 || z17) {
                                if (z17) {
                                    if (backpressureQueueCallback.peek() == null) {
                                        backpressureQueueCallback.complete(this.exception);
                                        return;
                                    }
                                }
                                Object poll = backpressureQueueCallback.poll();
                                if (poll != null) {
                                    if (backpressureQueueCallback.accept(poll)) {
                                        return;
                                    }
                                    j3--;
                                    i3++;
                                }
                            }
                            try {
                                break;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            if (!z16) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                z16 = false;
            }
        }
    }

    public boolean isTerminated() {
        return this.terminated;
    }

    @Override // rx.Producer
    public void request(long j3) {
        boolean z16;
        if (j3 == 0) {
            return;
        }
        while (true) {
            long j16 = get();
            boolean z17 = true;
            if (j16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            long j17 = Long.MAX_VALUE;
            if (j16 == Long.MAX_VALUE) {
                break;
            }
            if (j3 == Long.MAX_VALUE) {
                j17 = j3;
            } else {
                if (j16 <= Long.MAX_VALUE - j3) {
                    j17 = j16 + j3;
                }
                z17 = z16;
            }
            if (compareAndSet(j16, j17)) {
                z16 = z17;
                break;
            }
        }
        if (z16) {
            drain();
        }
    }

    public void terminate() {
        this.terminated = true;
    }

    public void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public void terminate(Throwable th5) {
        if (this.terminated) {
            return;
        }
        this.exception = th5;
        this.terminated = true;
    }

    public void terminateAndDrain(Throwable th5) {
        if (this.terminated) {
            return;
        }
        this.exception = th5;
        this.terminated = true;
        drain();
    }
}
