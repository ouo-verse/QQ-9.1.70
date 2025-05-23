package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeThrow<T> implements Observable.OnSubscribe<T> {
    private final Throwable exception;

    public OnSubscribeThrow(Throwable th5) {
        this.exception = th5;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        subscriber.onError(this.exception);
    }
}
