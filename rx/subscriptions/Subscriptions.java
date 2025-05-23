package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;
import rx.functions.Action0;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Subscriptions {
    private static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class FutureSubscription implements Subscription {

        /* renamed from: f, reason: collision with root package name */
        final Future<?> f432883f;

        public FutureSubscription(Future<?> future) {
            this.f432883f = future;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.f432883f.isCancelled();
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.f432883f.cancel(true);
        }
    }

    Subscriptions() {
        throw new IllegalStateException("No instances!");
    }

    public static Subscription create(Action0 action0) {
        return BooleanSubscription.create(action0);
    }

    public static Subscription empty() {
        return BooleanSubscription.create();
    }

    public static Subscription from(Future<?> future) {
        return new FutureSubscription(future);
    }

    public static Subscription unsubscribed() {
        return UNSUBSCRIBED;
    }

    public static CompositeSubscription from(Subscription... subscriptionArr) {
        return new CompositeSubscription(subscriptionArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Unsubscribed implements Subscription {
        Unsubscribed() {
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return true;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
        }
    }
}
