package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeLift<T, R> implements Observable.OnSubscribe<R> {
    final Observable.Operator<? extends R, ? super T> operator;
    final Observable.OnSubscribe<T> parent;

    public OnSubscribeLift(Observable.OnSubscribe<T> onSubscribe, Observable.Operator<? extends R, ? super T> operator) {
        this.parent = onSubscribe;
        this.operator = operator;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        try {
            Subscriber<? super T> call = RxJavaHooks.onObservableLift(this.operator).call(subscriber);
            try {
                call.onStart();
                this.parent.call(call);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                call.onError(th5);
            }
        } catch (Throwable th6) {
            Exceptions.throwIfFatal(th6);
            subscriber.onError(th6);
        }
    }
}
