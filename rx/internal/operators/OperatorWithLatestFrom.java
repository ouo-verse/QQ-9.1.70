package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorWithLatestFrom<T, U, R> implements Observable.Operator<R, T> {
    static final Object EMPTY = new Object();
    final Observable<? extends U> other;
    final Func2<? super T, ? super U, ? extends R> resultSelector;

    public OperatorWithLatestFrom(Observable<? extends U> observable, Func2<? super T, ? super U, ? extends R> func2) {
        this.other = observable;
        this.resultSelector = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        subscriber.add(serializedSubscriber);
        final AtomicReference atomicReference = new AtomicReference(EMPTY);
        Subscriber<T> subscriber2 = new Subscriber<T>(serializedSubscriber, true) { // from class: rx.internal.operators.OperatorWithLatestFrom.1
            @Override // rx.Observer
            public void onCompleted() {
                serializedSubscriber.onCompleted();
                serializedSubscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                serializedSubscriber.onError(th5);
                serializedSubscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                Object obj = atomicReference.get();
                if (obj != OperatorWithLatestFrom.EMPTY) {
                    try {
                        serializedSubscriber.onNext(OperatorWithLatestFrom.this.resultSelector.call(t16, obj));
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, this);
                    }
                }
            }
        };
        Subscriber<U> subscriber3 = new Subscriber<U>() { // from class: rx.internal.operators.OperatorWithLatestFrom.2
            @Override // rx.Observer
            public void onCompleted() {
                if (atomicReference.get() == OperatorWithLatestFrom.EMPTY) {
                    serializedSubscriber.onCompleted();
                    serializedSubscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                serializedSubscriber.onError(th5);
                serializedSubscriber.unsubscribe();
            }

            @Override // rx.Observer
            public void onNext(U u16) {
                atomicReference.set(u16);
            }
        };
        serializedSubscriber.add(subscriber2);
        serializedSubscriber.add(subscriber3);
        this.other.unsafeSubscribe(subscriber3);
        return subscriber2;
    }
}
