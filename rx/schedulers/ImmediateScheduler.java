package rx.schedulers;

import rx.Scheduler;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public final class ImmediateScheduler extends Scheduler {
    ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return null;
    }
}
