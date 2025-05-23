package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    final Action0 action;
    final SubscriptionList cancel;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class FutureCompleter implements Subscription {

        /* renamed from: f, reason: collision with root package name */
        private final Future<?> f432687f;

        FutureCompleter(Future<?> future) {
            this.f432687f = future;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f432687f.isCancelled();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f432687f.cancel(true);
            } else {
                this.f432687f.cancel(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Remover extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final CompositeSubscription parent;

        /* renamed from: s, reason: collision with root package name */
        final ScheduledAction f432688s;

        public Remover(ScheduledAction scheduledAction, CompositeSubscription compositeSubscription) {
            this.f432688s = scheduledAction;
            this.parent = compositeSubscription;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f432688s.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this.f432688s);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class Remover2 extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        final SubscriptionList parent;

        /* renamed from: s, reason: collision with root package name */
        final ScheduledAction f432689s;

        public Remover2(ScheduledAction scheduledAction, SubscriptionList subscriptionList) {
            this.f432689s = scheduledAction;
            this.parent = subscriptionList;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f432689s.isUnsubscribed();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.parent.remove(this.f432689s);
            }
        }
    }

    public ScheduledAction(Action0 action0) {
        this.action = action0;
        this.cancel = new SubscriptionList();
    }

    public void add(Subscription subscription) {
        this.cancel.add(subscription);
    }

    public void addParent(CompositeSubscription compositeSubscription) {
        this.cancel.add(new Remover(this, compositeSubscription));
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } catch (OnErrorNotImplementedException e16) {
                signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e16));
            } catch (Throwable th5) {
                signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th5));
            }
        } finally {
            unsubscribe();
        }
    }

    void signalError(Throwable th5) {
        RxJavaHooks.onError(th5);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th5);
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (!this.cancel.isUnsubscribed()) {
            this.cancel.unsubscribe();
        }
    }

    public void add(Future<?> future) {
        this.cancel.add(new FutureCompleter(future));
    }

    public void addParent(SubscriptionList subscriptionList) {
        this.cancel.add(new Remover2(this, subscriptionList));
    }

    public ScheduledAction(Action0 action0, CompositeSubscription compositeSubscription) {
        this.action = action0;
        this.cancel = new SubscriptionList(new Remover(this, compositeSubscription));
    }

    public ScheduledAction(Action0 action0, SubscriptionList subscriptionList) {
        this.action = action0;
        this.cancel = new SubscriptionList(new Remover2(this, subscriptionList));
    }
}
