package rx;

import java.util.concurrent.TimeUnit;
import rx.annotations.Experimental;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.SchedulerWhen;
import rx.subscriptions.MultipleAssignmentSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class Worker implements Subscription {
        public long now() {
            return System.currentTimeMillis();
        }

        public abstract Subscription schedule(Action0 action0);

        public abstract Subscription schedule(Action0 action0, long j3, TimeUnit timeUnit);

        public Subscription schedulePeriodically(Action0 action0, long j3, long j16, TimeUnit timeUnit) {
            long nanos = timeUnit.toNanos(j16);
            long nanos2 = TimeUnit.MILLISECONDS.toNanos(now());
            long nanos3 = nanos2 + timeUnit.toNanos(j3);
            MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
            Action0 action02 = new Action0(nanos2, nanos3, action0, multipleAssignmentSubscription, nanos) { // from class: rx.Scheduler.Worker.1
                long count;
                long lastNowNanos;
                long startInNanos;
                final /* synthetic */ Action0 val$action;
                final /* synthetic */ long val$firstNowNanos;
                final /* synthetic */ long val$firstStartInNanos;
                final /* synthetic */ MultipleAssignmentSubscription val$mas;
                final /* synthetic */ long val$periodInNanos;

                {
                    this.val$firstNowNanos = nanos2;
                    this.val$firstStartInNanos = nanos3;
                    this.val$action = action0;
                    this.val$mas = multipleAssignmentSubscription;
                    this.val$periodInNanos = nanos;
                    this.lastNowNanos = nanos2;
                    this.startInNanos = nanos3;
                }

                @Override // rx.functions.Action0
                public void call() {
                    long j17;
                    this.val$action.call();
                    if (!this.val$mas.isUnsubscribed()) {
                        long nanos4 = TimeUnit.MILLISECONDS.toNanos(Worker.this.now());
                        long j18 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS;
                        long j19 = nanos4 + j18;
                        long j26 = this.lastNowNanos;
                        if (j19 >= j26) {
                            long j27 = this.val$periodInNanos;
                            if (nanos4 < j26 + j27 + j18) {
                                long j28 = this.startInNanos;
                                long j29 = this.count + 1;
                                this.count = j29;
                                j17 = j28 + (j29 * j27);
                                this.lastNowNanos = nanos4;
                                this.val$mas.set(Worker.this.schedule(this, j17 - nanos4, TimeUnit.NANOSECONDS));
                            }
                        }
                        long j36 = this.val$periodInNanos;
                        long j37 = nanos4 + j36;
                        long j38 = this.count + 1;
                        this.count = j38;
                        this.startInNanos = j37 - (j36 * j38);
                        j17 = j37;
                        this.lastNowNanos = nanos4;
                        this.val$mas.set(Worker.this.schedule(this, j17 - nanos4, TimeUnit.NANOSECONDS));
                    }
                }
            };
            MultipleAssignmentSubscription multipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
            multipleAssignmentSubscription.set(multipleAssignmentSubscription2);
            multipleAssignmentSubscription2.set(schedule(action02, j3, timeUnit));
            return multipleAssignmentSubscription;
        }
    }

    public abstract Worker createWorker();

    public long now() {
        return System.currentTimeMillis();
    }

    @Experimental
    public <S extends Scheduler & Subscription> S when(Func1<Observable<Observable<Completable>>, Completable> func1) {
        return new SchedulerWhen(func1, this);
    }
}
