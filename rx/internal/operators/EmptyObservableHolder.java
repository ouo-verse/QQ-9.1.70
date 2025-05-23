package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public enum EmptyObservableHolder implements Observable.OnSubscribe<Object> {
    INSTANCE;

    static final Observable<Object> EMPTY = Observable.create(INSTANCE);

    public static <T> Observable<T> instance() {
        return (Observable<T>) EMPTY;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super Object> subscriber) {
        subscriber.onCompleted();
    }
}
