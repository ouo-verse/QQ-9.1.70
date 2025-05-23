package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NewThreadScheduler extends Scheduler {
    private final ThreadFactory threadFactory;

    public NewThreadScheduler(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new NewThreadWorker(this.threadFactory);
    }
}
