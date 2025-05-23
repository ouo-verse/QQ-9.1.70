package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTakeWhile<T> implements Observable.Operator<T, T> {
    final Func2<? super T, ? super Integer, Boolean> predicate;

    public OperatorTakeWhile(final Func1<? super T, Boolean> func1) {
        this(new Func2<T, Integer, Boolean>() { // from class: rx.internal.operators.OperatorTakeWhile.1
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
                return call2((AnonymousClass1) obj, num);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public Boolean call2(T t16, Integer num) {
                return (Boolean) Func1.this.call(t16);
            }
        });
    }

    public OperatorTakeWhile(Func2<? super T, ? super Integer, Boolean> func2) {
        this.predicate = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        Subscriber<T> subscriber2 = new Subscriber<T>(subscriber, false) { // from class: rx.internal.operators.OperatorTakeWhile.2
            private int counter;
            private boolean done;

            @Override // rx.Observer
            public void onCompleted() {
                if (!this.done) {
                    subscriber.onCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                if (!this.done) {
                    subscriber.onError(th5);
                }
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                try {
                    Func2<? super T, ? super Integer, Boolean> func2 = OperatorTakeWhile.this.predicate;
                    int i3 = this.counter;
                    this.counter = i3 + 1;
                    if (func2.call(t16, Integer.valueOf(i3)).booleanValue()) {
                        subscriber.onNext(t16);
                        return;
                    }
                    this.done = true;
                    subscriber.onCompleted();
                    unsubscribe();
                } catch (Throwable th5) {
                    this.done = true;
                    Exceptions.throwOrReport(th5, subscriber, t16);
                    unsubscribe();
                }
            }
        };
        subscriber.add(subscriber2);
        return subscriber2;
    }
}
