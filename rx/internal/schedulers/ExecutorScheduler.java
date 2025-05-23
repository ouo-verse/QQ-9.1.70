package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ExecutorScheduler extends Scheduler {
    final Executor executor;

    public ExecutorScheduler(Executor executor) {
        this.executor = executor;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new ExecutorSchedulerWorker(this.executor);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class ExecutorSchedulerWorker extends Scheduler.Worker implements Runnable {
        final Executor executor;
        final ConcurrentLinkedQueue<ScheduledAction> queue = new ConcurrentLinkedQueue<>();
        final AtomicInteger wip = new AtomicInteger();
        final CompositeSubscription tasks = new CompositeSubscription();
        final ScheduledExecutorService service = GenericScheduledExecutorService.getInstance();

        public ExecutorSchedulerWorker(Executor executor) {
            this.executor = executor;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.tasks.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.tasks.isUnsubscribed()) {
                ScheduledAction poll = this.queue.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.tasks.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.queue.clear();
                        return;
                    }
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            ScheduledAction scheduledAction = new ScheduledAction(action0, this.tasks);
            this.tasks.add(scheduledAction);
            this.queue.offer(scheduledAction);
            if (this.wip.getAndIncrement() == 0) {
                try {
                    this.executor.execute(this);
                } catch (RejectedExecutionException e16) {
                    this.tasks.remove(scheduledAction);
                    this.wip.decrementAndGet();
                    RxJavaHooks.onError(e16);
                    throw e16;
                }
            }
            return scheduledAction;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.tasks.unsubscribe();
            this.queue.clear();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(final Action0 action0, long j3, TimeUnit timeUnit) {
            if (j3 <= 0) {
                return schedule(action0);
            }
            if (isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            final MultipleAssignmentSubscription multipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
            multipleAssignmentSubscription2.set(multipleAssignmentSubscription);
            this.tasks.add(multipleAssignmentSubscription2);
            final Subscription create = Subscriptions.create(new Action0() { // from class: rx.internal.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.1
                @Override // rx.functions.Action0
                public void call() {
                    ExecutorSchedulerWorker.this.tasks.remove(multipleAssignmentSubscription2);
                }
            });
            ScheduledAction scheduledAction = new ScheduledAction(new Action0() { // from class: rx.internal.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.2
                @Override // rx.functions.Action0
                public void call() {
                    if (multipleAssignmentSubscription2.isUnsubscribed()) {
                        return;
                    }
                    Subscription schedule = ExecutorSchedulerWorker.this.schedule(action0);
                    multipleAssignmentSubscription2.set(schedule);
                    if (schedule.getClass() == ScheduledAction.class) {
                        ((ScheduledAction) schedule).add(create);
                    }
                }
            });
            multipleAssignmentSubscription.set(scheduledAction);
            try {
                scheduledAction.add(this.service.schedule(scheduledAction, j3, timeUnit));
                return create;
            } catch (RejectedExecutionException e16) {
                RxJavaHooks.onError(e16);
                throw e16;
            }
        }
    }
}
