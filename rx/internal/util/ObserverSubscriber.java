package rx.internal.util;

import rx.Observer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ObserverSubscriber<T> extends Subscriber<T> {
    final Observer<? super T> observer;

    public ObserverSubscriber(Observer<? super T> observer) {
        this.observer = observer;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.observer.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.observer.onError(th5);
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.observer.onNext(t16);
    }
}
