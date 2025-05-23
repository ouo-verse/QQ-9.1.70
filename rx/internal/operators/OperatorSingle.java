package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Subscriber;
import rx.internal.producers.SingleProducer;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorSingle<T> implements Observable.Operator<T, T> {
    private final T defaultValue;
    private final boolean hasDefaultValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorSingle<?> INSTANCE = new OperatorSingle<>();

        Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> child;
        private final T defaultValue;
        private final boolean hasDefaultValue;
        private boolean hasTooManyElements;
        private boolean isNonEmpty;
        private T value;

        ParentSubscriber(Subscriber<? super T> subscriber, boolean z16, T t16) {
            this.child = subscriber;
            this.hasDefaultValue = z16;
            this.defaultValue = t16;
            request(2L);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.hasTooManyElements) {
                if (this.isNonEmpty) {
                    this.child.setProducer(new SingleProducer(this.child, this.value));
                } else if (this.hasDefaultValue) {
                    this.child.setProducer(new SingleProducer(this.child, this.defaultValue));
                } else {
                    this.child.onError(new NoSuchElementException("Sequence contains no elements"));
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.hasTooManyElements) {
                RxJavaHooks.onError(th5);
            } else {
                this.child.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (this.hasTooManyElements) {
                return;
            }
            if (this.isNonEmpty) {
                this.hasTooManyElements = true;
                this.child.onError(new IllegalArgumentException("Sequence contains too many elements"));
                unsubscribe();
            } else {
                this.value = t16;
                this.isNonEmpty = true;
            }
        }
    }

    OperatorSingle() {
        this(false, null);
    }

    public static <T> OperatorSingle<T> instance() {
        return (OperatorSingle<T>) Holder.INSTANCE;
    }

    public OperatorSingle(T t16) {
        this(true, t16);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber, this.hasDefaultValue, this.defaultValue);
        subscriber.add(parentSubscriber);
        return parentSubscriber;
    }

    OperatorSingle(boolean z16, T t16) {
        this.hasDefaultValue = z16;
        this.defaultValue = t16;
    }
}
