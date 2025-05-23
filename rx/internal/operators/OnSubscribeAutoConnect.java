package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeAutoConnect<T> implements Observable.OnSubscribe<T> {
    final AtomicInteger clients;
    final Action1<? super Subscription> connection;
    final int numberOfSubscribers;
    final ConnectableObservable<? extends T> source;

    public OnSubscribeAutoConnect(ConnectableObservable<? extends T> connectableObservable, int i3, Action1<? super Subscription> action1) {
        if (i3 > 0) {
            this.source = connectableObservable;
            this.numberOfSubscribers = i3;
            this.connection = action1;
            this.clients = new AtomicInteger();
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        this.source.unsafeSubscribe(Subscribers.wrap(subscriber));
        if (this.clients.incrementAndGet() == this.numberOfSubscribers) {
            this.source.connect(this.connection);
        }
    }
}
