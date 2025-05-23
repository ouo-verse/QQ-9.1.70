package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorThrottleFirst<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeInMilliseconds;

    public OperatorThrottleFirst(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.timeInMilliseconds = timeUnit.toMillis(j3);
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorThrottleFirst.1
            private long lastOnNext;

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
                long now = OperatorThrottleFirst.this.scheduler.now();
                long j3 = this.lastOnNext;
                if (j3 == 0 || now - j3 >= OperatorThrottleFirst.this.timeInMilliseconds) {
                    this.lastOnNext = now;
                    subscriber.onNext(t16);
                }
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
    }
}
