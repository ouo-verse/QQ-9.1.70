package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.TimeInterval;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTimeInterval<T> implements Observable.Operator<TimeInterval<T>, T> {
    final Scheduler scheduler;

    public OperatorTimeInterval(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super TimeInterval<T>> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorTimeInterval.1
            private long lastTimestamp;

            {
                this.lastTimestamp = OperatorTimeInterval.this.scheduler.now();
            }

            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                long now = OperatorTimeInterval.this.scheduler.now();
                subscriber.onNext(new TimeInterval(now - this.lastTimestamp, t16));
                this.lastTimestamp = now;
            }
        };
    }
}
