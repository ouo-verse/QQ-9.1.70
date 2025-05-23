package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorAny<T> implements Observable.Operator<Boolean, T> {
    final Func1<? super T, Boolean> predicate;
    final boolean returnOnEmpty;

    public OperatorAny(Func1<? super T, Boolean> func1, boolean z16) {
        this.predicate = func1;
        this.returnOnEmpty = z16;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super Boolean> subscriber) {
        final SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorAny.1
            boolean done;
            boolean hasElements;

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    if (this.hasElements) {
                        singleDelayedProducer.setValue(Boolean.FALSE);
                    } else {
                        singleDelayedProducer.setValue(Boolean.valueOf(OperatorAny.this.returnOnEmpty));
                    }
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                this.hasElements = true;
                try {
                    if (OperatorAny.this.predicate.call(t16).booleanValue() && !this.done) {
                        this.done = true;
                        singleDelayedProducer.setValue(Boolean.valueOf(true ^ OperatorAny.this.returnOnEmpty));
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
