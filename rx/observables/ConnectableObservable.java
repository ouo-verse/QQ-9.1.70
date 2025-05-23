package rx.observables;

import rx.Observable;
import rx.Subscription;
import rx.annotations.Beta;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.OnSubscribeAutoConnect;
import rx.internal.operators.OnSubscribeRefCount;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ConnectableObservable<T> extends Observable<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public ConnectableObservable(Observable.OnSubscribe<T> onSubscribe) {
        super(onSubscribe);
    }

    @Beta
    public Observable<T> autoConnect() {
        return autoConnect(1);
    }

    public final Subscription connect() {
        final Subscription[] subscriptionArr = new Subscription[1];
        connect(new Action1<Subscription>() { // from class: rx.observables.ConnectableObservable.1
            @Override // rx.functions.Action1
            public void call(Subscription subscription) {
                subscriptionArr[0] = subscription;
            }
        });
        return subscriptionArr[0];
    }

    public abstract void connect(Action1<? super Subscription> action1);

    public Observable<T> refCount() {
        return Observable.create(new OnSubscribeRefCount(this));
    }

    @Beta
    public Observable<T> autoConnect(int i3) {
        return autoConnect(i3, Actions.empty());
    }

    @Beta
    public Observable<T> autoConnect(int i3, Action1<? super Subscription> action1) {
        if (i3 <= 0) {
            connect(action1);
            return this;
        }
        return Observable.create(new OnSubscribeAutoConnect(this, i3, action1));
    }
}
