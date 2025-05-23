package rx;

import rx.annotations.Beta;
import rx.internal.util.SubscriptionList;

/* compiled from: P */
@Beta
/* loaded from: classes29.dex */
public abstract class SingleSubscriber<T> implements Subscription {

    /* renamed from: cs, reason: collision with root package name */
    private final SubscriptionList f432651cs = new SubscriptionList();

    public final void add(Subscription subscription) {
        this.f432651cs.add(subscription);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.f432651cs.isUnsubscribed();
    }

    public abstract void onError(Throwable th5);

    public abstract void onSuccess(T t16);

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.f432651cs.unsubscribe();
    }
}
