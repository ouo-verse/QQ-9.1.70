package rx.android.schedulers;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.android.plugins.RxAndroidPlugins;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class HandlerScheduler extends Scheduler {
    private final Handler handler;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerScheduler(Handler handler) {
        this.handler = handler;
    }

    public static HandlerScheduler from(Handler handler) {
        if (handler != null) {
            return new HandlerScheduler(handler);
        }
        throw new NullPointerException("handler == null");
    }

    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class HandlerWorker extends Scheduler.Worker {
        private final CompositeSubscription compositeSubscription = new CompositeSubscription();
        private final Handler handler;

        HandlerWorker(Handler handler) {
            this.handler = handler;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.compositeSubscription.isUnsubscribed();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0, long j3, TimeUnit timeUnit) {
            if (this.compositeSubscription.isUnsubscribed()) {
                return Subscriptions.unsubscribed();
            }
            final ScheduledAction scheduledAction = new ScheduledAction(RxAndroidPlugins.getInstance().getSchedulersHook().onSchedule(action0));
            scheduledAction.addParent(this.compositeSubscription);
            this.compositeSubscription.add(scheduledAction);
            this.handler.postDelayed(scheduledAction, timeUnit.toMillis(j3));
            scheduledAction.add(Subscriptions.create(new Action0() { // from class: rx.android.schedulers.HandlerScheduler.HandlerWorker.1
                @Override // rx.functions.Action0
                public void call() {
                    HandlerWorker.this.handler.removeCallbacks(scheduledAction);
                }
            }));
            return scheduledAction;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.compositeSubscription.unsubscribe();
        }

        @Override // rx.Scheduler.Worker
        public Subscription schedule(Action0 action0) {
            return schedule(action0, 0L, TimeUnit.MILLISECONDS);
        }
    }
}
