package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeReduceSeed<T, R> implements Observable.OnSubscribe<R> {
    final R initialValue;
    final Func2<R, ? super T, R> reducer;
    final Observable<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReduceSeedSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        final Func2<R, ? super T, R> reducer;

        public ReduceSeedSubscriber(Subscriber<? super R> subscriber, R r16, Func2<R, ? super T, R> func2) {
            super(subscriber);
            this.value = r16;
            this.hasValue = true;
            this.reducer = func2;
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            try {
                this.value = this.reducer.call(this.value, t16);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                unsubscribe();
                this.actual.onError(th5);
            }
        }
    }

    public OnSubscribeReduceSeed(Observable<T> observable, R r16, Func2<R, ? super T, R> func2) {
        this.source = observable;
        this.initialValue = r16;
        this.reducer = func2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        new ReduceSeedSubscriber(subscriber, this.initialValue, this.reducer).subscribeTo(this.source);
    }
}
