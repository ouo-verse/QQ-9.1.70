package rx.internal.operators;

import java.util.Arrays;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorDoOnEach<T> implements Observable.Operator<T, T> {
    final Observer<? super T> doOnEachObserver;

    public OperatorDoOnEach(Observer<? super T> observer) {
        this.doOnEachObserver = observer;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorDoOnEach.1
            private boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                try {
                    OperatorDoOnEach.this.doOnEachObserver.onCompleted();
                    this.done = true;
                    subscriber.onCompleted();
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                Exceptions.throwIfFatal(th5);
                if (this.done) {
                    return;
                }
                this.done = true;
                try {
                    OperatorDoOnEach.this.doOnEachObserver.onError(th5);
                    subscriber.onError(th5);
                } catch (Throwable th6) {
                    Exceptions.throwIfFatal(th6);
                    subscriber.onError(new CompositeException(Arrays.asList(th5, th6)));
                }
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                if (this.done) {
                    return;
                }
                try {
                    OperatorDoOnEach.this.doOnEachObserver.onNext(t16);
                    subscriber.onNext(t16);
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this, t16);
                }
            }
        };
    }
}
