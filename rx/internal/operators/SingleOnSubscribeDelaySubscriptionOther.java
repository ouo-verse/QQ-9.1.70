package rx.internal.operators;

import rx.Observable;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SingleOnSubscribeDelaySubscriptionOther<T> implements Single.OnSubscribe<T> {
    final Single<? extends T> main;
    final Observable<?> other;

    public SingleOnSubscribeDelaySubscriptionOther(Single<? extends T> single, Observable<?> observable) {
        this.main = single;
        this.other = observable;
    }

    @Override // rx.functions.Action1
    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        final SingleSubscriber<T> singleSubscriber2 = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOnSubscribeDelaySubscriptionOther.1
            @Override // rx.SingleSubscriber
            public void onError(Throwable th5) {
                singleSubscriber.onError(th5);
            }

            @Override // rx.SingleSubscriber
            public void onSuccess(T t16) {
                singleSubscriber.onSuccess(t16);
            }
        };
        final SerialSubscription serialSubscription = new SerialSubscription();
        singleSubscriber.add(serialSubscription);
        Subscriber<? super Object> subscriber = new Subscriber<Object>() { // from class: rx.internal.operators.SingleOnSubscribeDelaySubscriptionOther.2
            boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                serialSubscription.set(singleSubscriber2);
                SingleOnSubscribeDelaySubscriptionOther.this.main.subscribe(singleSubscriber2);
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                if (this.done) {
                    RxJavaHooks.onError(th5);
                } else {
                    this.done = true;
                    singleSubscriber2.onError(th5);
                }
            }

            @Override // rx.Observer
            public void onNext(Object obj) {
                onCompleted();
            }
        };
        serialSubscription.set(subscriber);
        this.other.subscribe(subscriber);
    }
}
