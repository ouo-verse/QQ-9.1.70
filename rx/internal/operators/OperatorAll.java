package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorAll<T> implements Observable.Operator<Boolean, T> {
    final Func1<? super T, Boolean> predicate;

    public OperatorAll(Func1<? super T, Boolean> func1) {
        this.predicate = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super Boolean> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorAll.1
            boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    singleDelayedProducer.setValue(Boolean.TRUE);
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                try {
                    if (!OperatorAll.this.predicate.call(t16).booleanValue() && !this.done) {
                        this.done = true;
                        singleDelayedProducer.setValue(Boolean.FALSE);
                        unsubscribe();
                    }
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this, t16);
                }
            }
        };
        subscriber.add(subscriber2);
        subscriber.setProducer(singleDelayedProducer);
        return subscriber2;
    }
}
