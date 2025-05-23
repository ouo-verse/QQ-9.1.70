package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorDistinctUntilChanged<T, U> implements Observable.Operator<T, T>, Func2<U, U, Boolean> {
    final Func2<? super U, ? super U, Boolean> comparator;
    final Func1<? super T, ? extends U> keySelector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorDistinctUntilChanged<?, ?> INSTANCE = new OperatorDistinctUntilChanged<>(UtilityFunctions.identity());

        Holder() {
        }
    }

    public OperatorDistinctUntilChanged(Func1<? super T, ? extends U> func1) {
        this.keySelector = func1;
        this.comparator = this;
    }

    public static <T> OperatorDistinctUntilChanged<T, T> instance() {
        return (OperatorDistinctUntilChanged<T, T>) Holder.INSTANCE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.Func2
    public Boolean call(U u16, U u17) {
        return Boolean.valueOf(u16 == u17 || (u16 != null && u16.equals(u17)));
    }

    public OperatorDistinctUntilChanged(Func2<? super U, ? super U, Boolean> func2) {
        this.keySelector = UtilityFunctions.identity();
        this.comparator = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorDistinctUntilChanged.1
            boolean hasPrevious;
            U previousKey;

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
                try {
                    U call = OperatorDistinctUntilChanged.this.keySelector.call(t16);
                    U u16 = this.previousKey;
                    this.previousKey = call;
                    if (this.hasPrevious) {
                        try {
                            if (!OperatorDistinctUntilChanged.this.comparator.call(u16, call).booleanValue()) {
                                subscriber.onNext(t16);
                                return;
                            } else {
                                request(1L);
                                return;
                            }
                        } catch (Throwable th5) {
                            Exceptions.throwOrReport(th5, subscriber, call);
                            return;
                        }
                    }
                    this.hasPrevious = true;
                    subscriber.onNext(t16);
                } catch (Throwable th6) {
                    Exceptions.throwOrReport(th6, subscriber, t16);
                }
            }
        };
    }
}
