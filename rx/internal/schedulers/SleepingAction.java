package rx.internal.schedulers;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import rx.Scheduler;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

/* compiled from: P */
/* loaded from: classes29.dex */
class SleepingAction implements Action0 {
    private final long execTime;
    private final Scheduler.Worker innerScheduler;
    private final Action0 underlying;

    public SleepingAction(Action0 action0, Scheduler.Worker worker, long j3) {
        this.underlying = action0;
        this.innerScheduler = worker;
        this.execTime = j3;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.innerScheduler.isUnsubscribed()) {
            return;
        }
        long now = this.execTime - this.innerScheduler.now();
        if (now > 0) {
            try {
                LockMethodProxy.sleep(now);
            } catch (InterruptedException e16) {
                Thread.currentThread().interrupt();
                Exceptions.propagate(e16);
            }
        }
        if (this.innerScheduler.isUnsubscribed()) {
            return;
        }
        this.underlying.call();
    }
}
