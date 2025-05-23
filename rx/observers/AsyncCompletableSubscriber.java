package rx.observers;

import androidx.lifecycle.c;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public abstract class AsyncCompletableSubscriber implements Completable.CompletableSubscriber, Subscription {
    static final Unsubscribed UNSUBSCRIBED = new Unsubscribed();
    private final AtomicReference<Subscription> upstream = new AtomicReference<>();

    protected final void clear() {
        this.upstream.set(UNSUBSCRIBED);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        if (this.upstream.get() == UNSUBSCRIBED) {
            return true;
        }
        return false;
    }

    @Override // rx.Completable.CompletableSubscriber
    public final void onSubscribe(Subscription subscription) {
        if (!c.a(this.upstream, null, subscription)) {
            subscription.unsubscribe();
            if (this.upstream.get() != UNSUBSCRIBED) {
                RxJavaHooks.onError(new IllegalStateException("Subscription already set!"));
                return;
            }
            return;
        }
        onStart();
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        Subscription andSet;
        Subscription subscription = this.upstream.get();
        Unsubscribed unsubscribed = UNSUBSCRIBED;
        if (subscription != unsubscribed && (andSet = this.upstream.getAndSet(unsubscribed)) != null && andSet != unsubscribed) {
            andSet.unsubscribe();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class Unsubscribed implements Subscription {
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

    protected void onStart() {
    }
}
