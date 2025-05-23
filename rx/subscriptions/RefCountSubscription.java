package rx.subscriptions;

import androidx.lifecycle.c;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RefCountSubscription implements Subscription {
    static final State EMPTY_STATE = new State(false, 0);
    private final Subscription actual;
    final AtomicReference<State> state = new AtomicReference<>(EMPTY_STATE);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class InnerSubscription extends AtomicInteger implements Subscription {
        private static final long serialVersionUID = 7005765588239987643L;
        final RefCountSubscription parent;

        public InnerSubscription(RefCountSubscription refCountSubscription) {
            this.parent = refCountSubscription;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() != 0) {
                return true;
            }
            return false;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (compareAndSet(0, 1)) {
                this.parent.unsubscribeAChild();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class State {
        final int children;
        final boolean isUnsubscribed;

        State(boolean z16, int i3) {
            this.isUnsubscribed = z16;
            this.children = i3;
        }

        State addChild() {
            return new State(this.isUnsubscribed, this.children + 1);
        }

        State removeChild() {
            return new State(this.isUnsubscribed, this.children - 1);
        }

        State unsubscribe() {
            return new State(true, this.children);
        }
    }

    public RefCountSubscription(Subscription subscription) {
        if (subscription != null) {
            this.actual = subscription;
            return;
        }
        throw new IllegalArgumentException(ReportConstant.COSTREPORT_PREFIX);
    }

    private void unsubscribeActualIfApplicable(State state) {
        if (state.isUnsubscribed && state.children == 0) {
            this.actual.unsubscribe();
        }
    }

    public Subscription get() {
        State state;
        AtomicReference<State> atomicReference = this.state;
        do {
            state = atomicReference.get();
            if (state.isUnsubscribed) {
                return Subscriptions.unsubscribed();
            }
        } while (!c.a(atomicReference, state, state.addChild()));
        return new InnerSubscription(this);
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.state.get().isUnsubscribed;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        State state;
        State unsubscribe;
        AtomicReference<State> atomicReference = this.state;
        do {
            state = atomicReference.get();
            if (state.isUnsubscribed) {
                return;
            } else {
                unsubscribe = state.unsubscribe();
            }
        } while (!c.a(atomicReference, state, unsubscribe));
        unsubscribeActualIfApplicable(unsubscribe);
    }

    void unsubscribeAChild() {
        State state;
        State removeChild;
        AtomicReference<State> atomicReference = this.state;
        do {
            state = atomicReference.get();
            removeChild = state.removeChild();
        } while (!c.a(atomicReference, state, removeChild));
        unsubscribeActualIfApplicable(removeChild);
    }
}
