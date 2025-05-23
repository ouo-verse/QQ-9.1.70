package rx.subscriptions;

import androidx.lifecycle.c;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SerialSubscription implements Subscription {
    final AtomicReference<State> state = new AtomicReference<>(new State(false, Subscriptions.empty()));

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class State {
        final boolean isUnsubscribed;
        final Subscription subscription;

        State(boolean z16, Subscription subscription) {
            this.isUnsubscribed = z16;
            this.subscription = subscription;
        }

        State set(Subscription subscription) {
            return new State(this.isUnsubscribed, subscription);
        }

        State unsubscribe() {
            return new State(true, this.subscription);
        }
    }

    public Subscription get() {
        return this.state.get().subscription;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.state.get().isUnsubscribed;
    }

    public void set(Subscription subscription) {
        State state;
        if (subscription != null) {
            AtomicReference<State> atomicReference = this.state;
            do {
                state = atomicReference.get();
                if (state.isUnsubscribed) {
                    subscription.unsubscribe();
                    return;
                }
            } while (!c.a(atomicReference, state, state.set(subscription)));
            state.subscription.unsubscribe();
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        State state;
        AtomicReference<State> atomicReference = this.state;
        do {
            state = atomicReference.get();
            if (state.isUnsubscribed) {
                return;
            }
        } while (!c.a(atomicReference, state, state.unsubscribe()));
        state.subscription.unsubscribe();
    }
}
