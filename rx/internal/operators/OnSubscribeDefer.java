package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.Subscribers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeDefer<T> implements Observable.OnSubscribe<T> {
    final Func0<? extends Observable<? extends T>> observableFactory;

    public OnSubscribeDefer(Func0<? extends Observable<? extends T>> func0) {
        this.observableFactory = func0;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        try {
            this.observableFactory.call().unsafeSubscribe(Subscribers.wrap(subscriber));
        } catch (Throwable th5) {
            Exceptions.throwOrReport(th5, subscriber);
        }
    }
}
