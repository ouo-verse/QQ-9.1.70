package rx.schedulers;

import rx.Scheduler;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public final class NewThreadScheduler extends Scheduler {
    NewThreadScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return null;
    }
}
