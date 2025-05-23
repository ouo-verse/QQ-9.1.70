package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorSerialize<T> implements Observable.Operator<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize<>();

        Holder() {
        }
    }

    OperatorSerialize() {
    }

    public static <T> OperatorSerialize<T> instance() {
        return (OperatorSerialize<T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new SerializedSubscriber(new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorSerialize.1
            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                subscriber.onNext(t16);
            }
        });
    }
}
