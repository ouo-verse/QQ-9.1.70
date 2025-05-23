package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorSkip<T> implements Observable.Operator<T, T> {
    final int toSkip;

    public OperatorSkip(int i3) {
        if (i3 >= 0) {
            this.toSkip = i3;
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + i3);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorSkip.1
            int skipped;

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
                int i3 = this.skipped;
                if (i3 >= OperatorSkip.this.toSkip) {
                    subscriber.onNext(t16);
                } else {
                    this.skipped = i3 + 1;
                }
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                subscriber.setProducer(producer);
                producer.request(OperatorSkip.this.toSkip);
            }
        };
    }
}
