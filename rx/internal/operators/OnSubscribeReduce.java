package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeReduce<T> implements Observable.OnSubscribe<T> {
    final Func2<T, T, T> reducer;
    final Observable<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReduceSubscriber<T> extends Subscriber<T> {
        static final Object EMPTY = new Object();
        final Subscriber<? super T> actual;
        final Func2<T, T, T> reducer;
        T value = (T) EMPTY;

        public ReduceSubscriber(Subscriber<? super T> subscriber, Func2<T, T, T> func2) {
            this.actual = subscriber;
            this.reducer = func2;
            request(0L);
        }

        void downstreamRequest(long j3) {
            if (j3 >= 0) {
                if (j3 != 0) {
                    request(Long.MAX_VALUE);
                }
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j3);
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            T t16 = this.value;
            if (t16 != EMPTY) {
                this.actual.onNext(t16);
                this.actual.onCompleted();
            } else {
                this.actual.onError(new NoSuchElementException());
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            T t17 = this.value;
            if (t17 == EMPTY) {
                this.value = t16;
                return;
            }
            try {
                this.value = this.reducer.call(t17, t16);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                unsubscribe();
                this.actual.onError(th5);
            }
        }
    }

    public OnSubscribeReduce(Observable<T> observable, Func2<T, T, T> func2) {
        this.source = observable;
        this.reducer = func2;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        final ReduceSubscriber reduceSubscriber = new ReduceSubscriber(subscriber, this.reducer);
        subscriber.add(reduceSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeReduce.1
            @Override // rx.Producer
            public void request(long j3) {
                reduceSubscriber.downstreamRequest(j3);
            }
        });
        this.source.unsafeSubscribe(reduceSubscriber);
    }
}
