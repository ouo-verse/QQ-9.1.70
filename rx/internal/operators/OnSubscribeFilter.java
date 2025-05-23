package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeFilter<T> implements Observable.OnSubscribe<T> {
    final Func1<? super T, Boolean> predicate;
    final Observable<T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FilterSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> actual;
        boolean done;
        final Func1<? super T, Boolean> predicate;

        public FilterSubscriber(Subscriber<? super T> subscriber, Func1<? super T, Boolean> func1) {
            this.actual = subscriber;
            this.predicate = func1;
            request(0L);
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
                if (this.predicate.call(t16).booleanValue()) {
                    this.actual.onNext(t16);
                } else {
                    request(1L);
                }
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th5, t16));
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            super.setProducer(producer);
            this.actual.setProducer(producer);
        }
    }

    public OnSubscribeFilter(Observable<T> observable, Func1<? super T, Boolean> func1) {
        this.source = observable;
        this.predicate = func1;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        FilterSubscriber filterSubscriber = new FilterSubscriber(subscriber, this.predicate);
        subscriber.add(filterSubscriber);
        this.source.unsafeSubscribe(filterSubscriber);
    }
}
