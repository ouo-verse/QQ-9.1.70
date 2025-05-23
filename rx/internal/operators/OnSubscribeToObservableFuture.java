package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.internal.producers.SingleProducer;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeToObservableFuture {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class ToObservableFuture<T> implements Observable.OnSubscribe<T> {
        final Future<? extends T> that;
        private final long time;
        private final TimeUnit unit;

        public ToObservableFuture(Future<? extends T> future) {
            this.that = future;
            this.time = 0L;
            this.unit = null;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OnSubscribeToObservableFuture.ToObservableFuture.1
                @Override // rx.functions.Action0
                public void call() {
                    ToObservableFuture.this.that.cancel(true);
                }
            }));
            try {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                TimeUnit timeUnit = this.unit;
                subscriber.setProducer(new SingleProducer(subscriber, timeUnit == null ? this.that.get() : this.that.get(this.time, timeUnit)));
            } catch (Throwable th5) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                Exceptions.throwOrReport(th5, subscriber);
            }
        }

        public ToObservableFuture(Future<? extends T> future, long j3, TimeUnit timeUnit) {
            this.that = future;
            this.time = j3;
            this.unit = timeUnit;
        }
    }

    OnSubscribeToObservableFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> future) {
        return new ToObservableFuture(future);
    }

    public static <T> Observable.OnSubscribe<T> toObservableFuture(Future<? extends T> future, long j3, TimeUnit timeUnit) {
        return new ToObservableFuture(future, j3, timeUnit);
    }
}
