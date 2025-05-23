package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BooleanSubscription implements Subscription {
    static final Action0 EMPTY_ACTION = new Action0() { // from class: rx.subscriptions.BooleanSubscription.1
        @Override // rx.functions.Action0
        public void call() {
        }
    };
    final AtomicReference<Action0> actionRef;

    public BooleanSubscription() {
        this.actionRef = new AtomicReference<>();
    }

    public static BooleanSubscription create() {
        return new BooleanSubscription();
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (this.actionRef.get() == EMPTY_ACTION) {
            return true;
        }
        return false;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        Action0 andSet;
        Action0 action0 = this.actionRef.get();
        Action0 action02 = EMPTY_ACTION;
        if (action0 != action02 && (andSet = this.actionRef.getAndSet(action02)) != null && andSet != action02) {
            andSet.call();
        }
    }

    public static BooleanSubscription create(Action0 action0) {
        return new BooleanSubscription(action0);
    }

    BooleanSubscription(Action0 action0) {
        this.actionRef = new AtomicReference<>(action0);
    }
}
