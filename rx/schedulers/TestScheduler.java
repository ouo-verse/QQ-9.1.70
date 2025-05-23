package rx.schedulers;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TestScheduler extends Scheduler {
    static long counter;
    final Queue<TimedAction> queue = new PriorityQueue(11, new CompareActionsByTime());
    long time;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class CompareActionsByTime implements Comparator<TimedAction> {
        CompareActionsByTime() {
        }

        @Override // java.util.Comparator
        public int compare(TimedAction timedAction, TimedAction timedAction2) {
            long j3 = timedAction.time;
            long j16 = timedAction2.time;
            if (j3 == j16) {
                if (timedAction.count < timedAction2.count) {
                    return -1;
                }
                return timedAction.count > timedAction2.count ? 1 : 0;
            }
            if (j3 < j16) {
                return -1;
            }
            return j3 > j16 ? 1 : 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class TimedAction {
        final Action0 action;
        private final long count;
        final Scheduler.Worker scheduler;
        final long time;

        TimedAction(Scheduler.Worker worker, long j3, Action0 action0) {
            long j16 = TestScheduler.counter;
            TestScheduler.counter = 1 + j16;
            this.count = j16;
            this.time = j3;
            this.action = action0;
            this.scheduler = worker;
        }

        public String toString() {
            return String.format("TimedAction(time = %d, action = %s)", Long.valueOf(this.time), this.action.toString());
        }
    }

    public void advanceTimeBy(long j3, TimeUnit timeUnit) {
        advanceTimeTo(this.time + timeUnit.toNanos(j3), TimeUnit.NANOSECONDS);
    }

    public void advanceTimeTo(long j3, TimeUnit timeUnit) {
        triggerActions(timeUnit.toNanos(j3));
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new InnerTestScheduler();
    }

    @Override // rx.Scheduler
    public long now() {
        return TimeUnit.NANOSECONDS.toMillis(this.time);
    }

    public void triggerActions() {
        triggerActions(this.time);
    }

    private void triggerActions(long j3) {
        while (!this.queue.isEmpty()) {
            TimedAction peek = this.queue.peek();
            long j16 = peek.time;
            if (j16 > j3) {
                break;
            }
            if (j16 == 0) {
                j16 = this.time;
            }
            this.time = j16;
            this.queue.remove();
            if (!peek.scheduler.isUnsubscribed()) {
                peek.action.call();
            }
        }
        this.time = j3;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    final class InnerTestScheduler extends Scheduler.Worker {

        /* renamed from: s, reason: collision with root package name */
        private final BooleanSubscription f432877s = new BooleanSubscription();

        InnerTestScheduler() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f432877s.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public long now() {
            return TestScheduler.this.now();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j3, TimeUnit timeUnit) {
            final TimedAction timedAction = new TimedAction(this, TestScheduler.this.time + timeUnit.toNanos(j3), action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() { // from class: rx.schedulers.TestScheduler.InnerTestScheduler.1
                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.f432877s.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            final TimedAction timedAction = new TimedAction(this, 0L, action0);
            TestScheduler.this.queue.add(timedAction);
            return Subscriptions.create(new Action0() { // from class: rx.schedulers.TestScheduler.InnerTestScheduler.2
                @Override // rx.functions.Action0
                public void call() {
                    TestScheduler.this.queue.remove(timedAction);
                }
            });
        }
    }
}
