package rx.internal.operators;

import java.util.HashSet;
import java.util.Set;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorDistinct<T, U> implements Observable.Operator<T, T> {
    final Func1<? super T, ? extends U> keySelector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorDistinct<?, ?> INSTANCE = new OperatorDistinct<>(UtilityFunctions.identity());

        Holder() {
        }
    }

    public OperatorDistinct(Func1<? super T, ? extends U> func1) {
        this.keySelector = func1;
    }

    public static <T> OperatorDistinct<T, T> instance() {
        return (OperatorDistinct<T, T>) Holder.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorDistinct.1
            Set<U> keyMemory = new HashSet();

            @Override // rx.Observer
            public void onCompleted() {
                this.keyMemory = null;
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                this.keyMemory = null;
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                if (this.keyMemory.add(OperatorDistinct.this.keySelector.call(t16))) {
                    subscriber.onNext(t16);
                } else {
                    request(1L);
                }
            }
        };
    }
}
