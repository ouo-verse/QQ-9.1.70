package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action2;
import rx.functions.Func0;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeCollect<T, R> implements Observable.OnSubscribe<R> {
    final Func0<R> collectionFactory;
    final Action2<R, ? super T> collector;
    final Observable<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class CollectSubscriber<T, R> extends DeferredScalarSubscriber<T, R> {
        final Action2<R, ? super T> collector;

        public CollectSubscriber(Subscriber<? super R> subscriber, R r16, Action2<R, ? super T> action2) {
            super(subscriber);
            this.value = r16;
            this.hasValue = true;
            this.collector = action2;
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            try {
                this.collector.call(this.value, t16);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                unsubscribe();
                this.actual.onError(th5);
            }
        }
    }

    public OnSubscribeCollect(Observable<T> observable, Func0<R> func0, Action2<R, ? super T> action2) {
        this.source = observable;
        this.collectionFactory = func0;
        this.collector = action2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super R> subscriber) {
        try {
            new CollectSubscriber(subscriber, this.collectionFactory.call(), this.collector).subscribeTo(this.source);
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            subscriber.onError(th5);
        }
    }
}
