package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

/* loaded from: classes29.dex */
public final class OnSubscribeTimerPeriodically implements Observable.OnSubscribe<Long> {
    final long initialDelay;
    final long period;
    final Scheduler scheduler;
    final TimeUnit unit;

    public OnSubscribeTimerPeriodically(long j3, long j16, TimeUnit timeUnit, Scheduler scheduler) {
        this.initialDelay = j3;
        this.period = j16;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Action1
    public void call(final Subscriber<? super Long> subscriber) {
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        createWorker.schedulePeriodically(new Action0() { // from class: rx.internal.operators.OnSubscribeTimerPeriodically.1
            long counter;

            @Override // rx.functions.Action0
            public void call() {
                try {
                    Subscriber subscriber2 = subscriber;
                    long j3 = this.counter;
                    this.counter = 1 + j3;
                    subscriber2.onNext(Long.valueOf(j3));
                } catch (Throwable th5) {
                    try {
                        createWorker.unsubscribe();
                    } finally {
                        Exceptions.throwOrReport(th5, subscriber);
                    }
                }
            }
        }, this.initialDelay, this.period, this.unit);
    }
}
