package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.operators.OperatorTimeoutBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTimeout<T> extends OperatorTimeoutBase<T> {
    public OperatorTimeout(final long j3, final TimeUnit timeUnit, Observable<? extends T> observable, Scheduler scheduler) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() { // from class: rx.internal.operators.OperatorTimeout.1
            @Override // rx.functions.Func3
            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l3, Scheduler.Worker worker) {
                return worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorTimeout.1.1
                    @Override // rx.functions.Action0
                    public void call() {
                        timeoutSubscriber.onTimeout(l3.longValue());
                    }
                }, j3, timeUnit);
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() { // from class: rx.internal.operators.OperatorTimeout.2
            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Subscription call(Object obj, Long l3, Object obj2, Scheduler.Worker worker) {
                return call((OperatorTimeoutBase.TimeoutSubscriber<Long>) obj, l3, (Long) obj2, worker);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l3, T t16, Scheduler.Worker worker) {
                return worker.schedule(new Action0() { // from class: rx.internal.operators.OperatorTimeout.2.1
                    @Override // rx.functions.Action0
                    public void call() {
                        timeoutSubscriber.onTimeout(l3.longValue());
                    }
                }, j3, timeUnit);
            }
        }, observable, scheduler);
    }

    @Override // rx.internal.operators.OperatorTimeoutBase
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber subscriber) {
        return super.call(subscriber);
    }
}
