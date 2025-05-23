package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorCast<T, R> implements Observable.Operator<R, T> {
    final Class<R> castClass;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CastSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> actual;
        final Class<R> castClass;
        boolean done;

        public CastSubscriber(Subscriber<? super R> subscriber, Class<R> cls) {
            this.actual = subscriber;
            this.castClass = cls;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.done) {
                RxJavaHooks.onError(th5);
            } else {
                this.done = true;
                this.actual.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            try {
                this.actual.onNext(this.castClass.cast(t16));
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th5, t16));
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.actual.setProducer(producer);
        }
    }

    public OperatorCast(Class<R> cls) {
        this.castClass = cls;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        CastSubscriber castSubscriber = new CastSubscriber(subscriber, this.castClass);
        subscriber.add(castSubscriber);
        return castSubscriber;
    }
}
