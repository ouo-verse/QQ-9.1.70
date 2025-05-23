package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public class SchedulerWhen extends Scheduler implements Subscription {
    private static final Subscription SUBSCRIBED = new Subscription() { // from class: rx.internal.schedulers.SchedulerWhen.3
        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    };
    private static final Subscription UNSUBSCRIBED = Subscriptions.unsubscribed();
    private final Scheduler actualScheduler;
    private final Subscription subscription;
    private final Observer<Observable<Completable>> workerObserver;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class DelayedAction extends ScheduledAction {
        private final Action0 action;
        private final long delayTime;
        private final TimeUnit unit;

        public DelayedAction(Action0 action0, long j3, TimeUnit timeUnit) {
            this.action = action0;
            this.delayTime = j3;
            this.unit = timeUnit;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Subscription callActual(Scheduler.Worker worker) {
            return worker.schedule(this.action, this.delayTime, this.unit);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class ImmediateAction extends ScheduledAction {
        private final Action0 action;

        public ImmediateAction(Action0 action0) {
            this.action = action0;
        }

        @Override // rx.internal.schedulers.SchedulerWhen.ScheduledAction
        protected Subscription callActual(Scheduler.Worker worker) {
            return worker.schedule(this.action);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class ScheduledAction extends AtomicReference<Subscription> implements Subscription {
        public ScheduledAction() {
            super(SchedulerWhen.SUBSCRIBED);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void call(Scheduler.Worker worker) {
            Subscription subscription = get();
            if (subscription == SchedulerWhen.UNSUBSCRIBED || subscription != SchedulerWhen.SUBSCRIBED) {
                return;
            }
            Subscription callActual = callActual(worker);
            if (!compareAndSet(SchedulerWhen.SUBSCRIBED, callActual)) {
                callActual.unsubscribe();
            }
        }

        protected abstract Subscription callActual(Scheduler.Worker worker);

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            Subscription subscription;
            Subscription subscription2 = SchedulerWhen.UNSUBSCRIBED;
            do {
                subscription = get();
                if (subscription == SchedulerWhen.UNSUBSCRIBED) {
                    return;
                }
            } while (!compareAndSet(subscription, subscription2));
            if (subscription != SchedulerWhen.SUBSCRIBED) {
                subscription.unsubscribe();
            }
        }
    }

    public SchedulerWhen(Func1<Observable<Observable<Completable>>, Completable> func1, Scheduler scheduler) {
        this.actualScheduler = scheduler;
        PublishSubject create = PublishSubject.create();
        this.workerObserver = new SerializedObserver(create);
        this.subscription = func1.call(create.onBackpressureBuffer()).subscribe();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.Scheduler
    public Scheduler.Worker createWorker() {
        final Scheduler.Worker createWorker = this.actualScheduler.createWorker();
        BufferUntilSubscriber create = BufferUntilSubscriber.create();
        final SerializedObserver serializedObserver = new SerializedObserver(create);
        Object map = create.map(new Func1<ScheduledAction, Completable>() { // from class: rx.internal.schedulers.SchedulerWhen.1
            @Override // rx.functions.Func1
            public Completable call(final ScheduledAction scheduledAction) {
                return Completable.create(new Completable.CompletableOnSubscribe() { // from class: rx.internal.schedulers.SchedulerWhen.1.1
                    @Override // rx.functions.Action1
                    public void call(Completable.CompletableSubscriber completableSubscriber) {
                        completableSubscriber.onSubscribe(scheduledAction);
                        scheduledAction.call(createWorker);
                        completableSubscriber.onCompleted();
                    }
                });
            }
        });
        Scheduler.Worker worker = new Scheduler.Worker() { // from class: rx.internal.schedulers.SchedulerWhen.2
            private final AtomicBoolean unsubscribed = new AtomicBoolean();

            @Override // rx.Subscription
            public boolean isUnsubscribed() {
                return this.unsubscribed.get();
            }

            @Override // rx.Scheduler.Worker
            public Subscription schedule(Action0 action0, long j3, TimeUnit timeUnit) {
                DelayedAction delayedAction = new DelayedAction(action0, j3, timeUnit);
                serializedObserver.onNext(delayedAction);
                return delayedAction;
            }

            @Override // rx.Subscription
            public void unsubscribe() {
                if (this.unsubscribed.compareAndSet(false, true)) {
                    createWorker.unsubscribe();
                    serializedObserver.onCompleted();
                }
            }

            @Override // rx.Scheduler.Worker
            public Subscription schedule(Action0 action0) {
                ImmediateAction immediateAction = new ImmediateAction(action0);
                serializedObserver.onNext(immediateAction);
                return immediateAction;
            }
        };
        this.workerObserver.onNext(map);
        return worker;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.subscription.isUnsubscribed();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.subscription.unsubscribe();
    }
}
