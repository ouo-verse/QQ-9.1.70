package rx.internal.schedulers;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TrampolineScheduler extends Scheduler {
    public static final TrampolineScheduler INSTANCE = new TrampolineScheduler();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class InnerCurrentThreadScheduler extends Scheduler.Worker {
        final AtomicInteger counter = new AtomicInteger();
        final PriorityBlockingQueue<TimedAction> queue = new PriorityBlockingQueue<>();
        private final BooleanSubscription innerSubscription = new BooleanSubscription();
        private final AtomicInteger wip = new AtomicInteger();

        InnerCurrentThreadScheduler() {
        }

        private Subscription enqueue(Action0 action0, long j3) {
            if (this.innerSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final TimedAction timedAction = new TimedAction(action0, Long.valueOf(j3), this.counter.incrementAndGet());
            this.queue.add(timedAction);
            if (this.wip.getAndIncrement() != 0) {
                return Subscriptions.create(new Action0() { // from class: rx.internal.schedulers.TrampolineScheduler.InnerCurrentThreadScheduler.1
                    @Override // rx.functions.Action0
                    public void call() {
                        InnerCurrentThreadScheduler.this.queue.remove(timedAction);
                    }
                });
            }
            do {
                TimedAction poll = this.queue.poll();
                if (poll != null) {
                    poll.action.call();
                }
            } while (this.wip.decrementAndGet() > 0);
            return Subscriptions.unsubscribed();
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.innerSubscription.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return enqueue(action0, now());
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.innerSubscription.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j3, TimeUnit timeUnit) {
            long now = now() + timeUnit.toMillis(j3);
            return enqueue(new SleepingAction(action0, this, now), now);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class TimedAction implements Comparable<TimedAction> {
        final Action0 action;
        final int count;
        final Long execTime;

        TimedAction(Action0 action0, Long l3, int i3) {
            this.action = action0;
            this.execTime = l3;
            this.count = i3;
        }

        @Override // java.lang.Comparable
        public int compareTo(TimedAction timedAction) {
            int compareTo = this.execTime.compareTo(timedAction.execTime);
            return compareTo == 0 ? TrampolineScheduler.compare(this.count, timedAction.count) : compareTo;
        }
    }

    TrampolineScheduler() {
    }

    static int compare(int i3, int i16) {
        if (i3 < i16) {
            return -1;
        }
        if (i3 == i16) {
            return 0;
        }
        return 1;
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerCurrentThreadScheduler();
    }
}
