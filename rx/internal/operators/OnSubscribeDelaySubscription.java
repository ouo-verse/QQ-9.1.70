package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeDelaySubscription<T> implements Observable.OnSubscribe<T> {
    final Scheduler scheduler;
    final Observable<? extends T> source;
    final long time;
    final TimeUnit unit;

    public OnSubscribeDelaySubscription(Observable<? extends T> observable, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.source = observable;
        this.time = j3;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(final Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        createWorker.schedule(new Action0() { // from class: rx.internal.operators.OnSubscribeDelaySubscription.1
            @Override // rx.functions.Action0
            public void call() {
                if (!subscriber.isUnsubscribed()) {
                    OnSubscribeDelaySubscription.this.source.unsafeSubscribe(Subscribers.wrap(subscriber));
                }
            }
        }, this.time, this.unit);
    }
}
