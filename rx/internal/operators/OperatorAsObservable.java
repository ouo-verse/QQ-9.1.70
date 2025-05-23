package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorAsObservable<T> implements Observable.Operator<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorAsObservable<Object> INSTANCE = new OperatorAsObservable<>();

        Holder() {
        }
    }

    OperatorAsObservable() {
    }

    public static <T> OperatorAsObservable<T> instance() {
        return (OperatorAsObservable<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        return subscriber;
    }
}
