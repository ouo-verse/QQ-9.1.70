package rx.plugins;

import rx.Observable;
import rx.Subscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class RxJavaObservableExecutionHook {
    @Deprecated
    public <T> Observable.OnSubscribe<T> onCreate(Observable.OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public <T, R> Observable.Operator<? extends R, ? super T> onLift(Observable.Operator<? extends R, ? super T> operator) {
        return operator;
    }

    @Deprecated
    public <T> Throwable onSubscribeError(Throwable th5) {
        return th5;
    }

    @Deprecated
    public <T> Subscription onSubscribeReturn(Subscription subscription) {
        return subscription;
    }

    @Deprecated
    public <T> Observable.OnSubscribe<T> onSubscribeStart(Observable<? extends T> observable, Observable.OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }
}
