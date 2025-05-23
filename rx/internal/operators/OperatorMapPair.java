package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.plugins.RxJavaHooks;

/* loaded from: classes29.dex */
public final class OperatorMapPair<T, U, R> implements Observable.Operator<Observable<? extends R>, T> {
    final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
    final Func2<? super T, ? super U, ? extends R> resultSelector;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static final class MapPairSubscriber<T, U, R> extends Subscriber<T> {
        final Subscriber<? super Observable<? extends R>> actual;
        final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
        boolean done;
        final Func2<? super T, ? super U, ? extends R> resultSelector;

        public MapPairSubscriber(Subscriber<? super Observable<? extends R>> subscriber, Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
            this.actual = subscriber;
            this.collectionSelector = func1;
            this.resultSelector = func2;
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
                this.actual.onNext(this.collectionSelector.call(t16).map(new OuterInnerMapper(t16, this.resultSelector)));
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

    /* loaded from: classes29.dex */
    static final class OuterInnerMapper<T, U, R> implements Func1<U, R> {
        final T outer;
        final Func2<? super T, ? super U, ? extends R> resultSelector;

        public OuterInnerMapper(T t16, Func2<? super T, ? super U, ? extends R> func2) {
            this.outer = t16;
            this.resultSelector = func2;
        }

        @Override // rx.functions.Func1
        public R call(U u16) {
            return this.resultSelector.call(this.outer, u16);
        }
    }

    public OperatorMapPair(Func1<? super T, ? extends Observable<? extends U>> func1, Func2<? super T, ? super U, ? extends R> func2) {
        this.collectionSelector = func1;
        this.resultSelector = func2;
    }

    public static <T, U> Func1<T, Observable<U>> convertSelector(final Func1<? super T, ? extends Iterable<? extends U>> func1) {
        return new Func1<T, Observable<U>>() { // from class: rx.internal.operators.OperatorMapPair.1
            @Override // rx.functions.Func1
            public /* bridge */ /* synthetic */ Object call(Object obj) {
                return call((AnonymousClass1) obj);
            }

            @Override // rx.functions.Func1
            public Observable<U> call(T t16) {
                return Observable.from((Iterable) Func1.this.call(t16));
            }
        };
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<? extends R>> subscriber) {
        MapPairSubscriber mapPairSubscriber = new MapPairSubscriber(subscriber, this.collectionSelector, this.resultSelector);
        subscriber.add(mapPairSubscriber);
        return mapPairSubscriber;
    }
}
