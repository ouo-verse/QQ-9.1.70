package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorDoAfterTerminate<T> implements Observable.Operator<T, T> {
    final Action0 action;

    public OperatorDoAfterTerminate(Action0 action0) {
        if (action0 != null) {
            this.action = action0;
            return;
        }
        throw new NullPointerException("Action can not be null");
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorDoAfterTerminate.1
            void callAction() {
                try {
                    OperatorDoAfterTerminate.this.action.call();
                } catch (Throwable th5) {
                    Exceptions.throwIfFatal(th5);
                    RxJavaHooks.onError(th5);
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                try {
                    subscriber.onCompleted();
                } finally {
                    callAction();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                try {
                    subscriber.onError(th5);
                } finally {
                    callAction();
                }
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                subscriber.onNext(t16);
            }
        };
    }
}
