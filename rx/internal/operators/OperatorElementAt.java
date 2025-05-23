package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorElementAt<T> implements Observable.Operator<T, T> {
    final T defaultValue;
    final boolean hasDefault;
    final int index;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class InnerProducer extends AtomicBoolean implements Producer {
        private static final long serialVersionUID = 1;
        final Producer actual;

        public InnerProducer(Producer producer) {
            this.actual = producer;
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 > 0 && compareAndSet(false, true)) {
                    this.actual.request(Long.MAX_VALUE);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }

    public OperatorElementAt(int i3) {
        this(i3, null, false);
    }

    public OperatorElementAt(int i3, T t16) {
        this(i3, t16, true);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorElementAt.1
            private int currentIndex;

            @Override // rx.Observer
            public void onCompleted() {
                int i3 = this.currentIndex;
                OperatorElementAt operatorElementAt = OperatorElementAt.this;
                if (i3 <= operatorElementAt.index) {
                    if (operatorElementAt.hasDefault) {
                        subscriber.onNext(operatorElementAt.defaultValue);
                        subscriber.onCompleted();
                        return;
                    }
                    subscriber.onError(new IndexOutOfBoundsException(OperatorElementAt.this.index + " is out of bounds"));
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                int i3 = this.currentIndex;
                this.currentIndex = i3 + 1;
                if (i3 == OperatorElementAt.this.index) {
                    subscriber.onNext(t16);
                    subscriber.onCompleted();
                    unsubscribe();
                }
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                subscriber.setProducer(new InnerProducer(producer));
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }

    OperatorElementAt(int i3, T t16, boolean z16) {
        if (i3 >= 0) {
            this.index = i3;
            this.defaultValue = t16;
            this.hasDefault = z16;
        } else {
            throw new IndexOutOfBoundsException(i3 + " is out of bounds");
        }
    }
}
