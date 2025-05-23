package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeDelaySubscriptionOther<T, U> implements Observable.OnSubscribe<T> {
    final Observable<? extends T> main;
    final Observable<U> other;

    public OnSubscribeDelaySubscriptionOther(Observable<? extends T> observable, Observable<U> observable2) {
        this.main = observable;
        this.other = observable2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        final Subscriber wrap = Subscribers.wrap(subscriber);
        Subscriber<U> subscriber2 = new Subscriber<U>() { // from class: rx.internal.operators.OnSubscribeDelaySubscriptionOther.1
            boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                serialSubscription.set(Subscriptions.unsubscribed());
                OnSubscribeDelaySubscriptionOther.this.main.unsafeSubscribe(wrap);
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                if (this.done) {
                    RxJavaHooks.onError(th5);
                } else {
                    this.done = true;
                    wrap.onError(th5);
                }
            }

            @Override // rx.Observer
            public void onNext(U u16) {
                onCompleted();
            }
        };
        serialSubscription.set(subscriber2);
        this.other.unsafeSubscribe(subscriber2);
    }
}
