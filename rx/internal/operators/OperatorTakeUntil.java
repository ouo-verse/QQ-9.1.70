package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTakeUntil<T, E> implements Observable.Operator<T, T> {
    private final Observable<? extends E> other;

    public OperatorTakeUntil(Observable<? extends E> observable) {
        this.other = observable;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        final Subscriber<T> subscriber2 = new Subscriber<T>(serializedSubscriber, false) { // from class: rx.internal.operators.OperatorTakeUntil.1
            @Override // rx.Observer
            public void onCompleted() {
                try {
                    serializedSubscriber.onCompleted();
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                try {
                    serializedSubscriber.onError(th5);
                } finally {
                    serializedSubscriber.unsubscribe();
                }
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                serializedSubscriber.onNext(t16);
            }
        };
        Subscriber<E> subscriber3 = new Subscriber<E>() { // from class: rx.internal.operators.OperatorTakeUntil.2
            @Override // rx.Observer
            public void onCompleted() {
                subscriber2.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber2.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(E e16) {
                onCompleted();
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        serializedSubscriber.add(subscriber2);
        serializedSubscriber.add(subscriber3);
        subscriber.add(serializedSubscriber);
        this.other.unsafeSubscribe(subscriber3);
        return subscriber2;
    }
}
