package rx.internal.operators;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.operators.OperatorTimeoutBase;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorTimeoutWithSelector<T, U, V> extends OperatorTimeoutBase<T> {
    public OperatorTimeoutWithSelector(final Func0<? extends Observable<U>> func0, final Func1<? super T, ? extends Observable<V>> func1, Observable<? extends T> observable) {
        super(new OperatorTimeoutBase.FirstTimeoutStub<T>() { // from class: rx.internal.operators.OperatorTimeoutWithSelector.1
            @Override // rx.functions.Func3
            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l3, Scheduler.Worker worker) {
                Func0 func02 = Func0.this;
                if (func02 != null) {
                    try {
                        return ((Observable) func02.call()).unsafeSubscribe(new Subscriber<U>() { // from class: rx.internal.operators.OperatorTimeoutWithSelector.1.1
                            @Override // rx.Observer
                            public void onCompleted() {
                                timeoutSubscriber.onTimeout(l3.longValue());
                            }

                            @Override // rx.Observer
                            public void onError(Throwable th5) {
                                timeoutSubscriber.onError(th5);
                            }

                            @Override // rx.Observer
                            public void onNext(U u16) {
                                timeoutSubscriber.onTimeout(l3.longValue());
                            }
                        });
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, timeoutSubscriber);
                        return Subscriptions.unsubscribed();
                    }
                }
                return Subscriptions.unsubscribed();
            }
        }, new OperatorTimeoutBase.TimeoutStub<T>() { // from class: rx.internal.operators.OperatorTimeoutWithSelector.2
            @Override // rx.functions.Func4
            public /* bridge */ /* synthetic */ Subscription call(Object obj, Long l3, Object obj2, Scheduler.Worker worker) {
                return call((OperatorTimeoutBase.TimeoutSubscriber<Long>) obj, l3, (Long) obj2, worker);
            }

            public Subscription call(final OperatorTimeoutBase.TimeoutSubscriber<T> timeoutSubscriber, final Long l3, T t16, Scheduler.Worker worker) {
                try {
                    return ((Observable) Func1.this.call(t16)).unsafeSubscribe(new Subscriber<V>() { // from class: rx.internal.operators.OperatorTimeoutWithSelector.2.1
                        @Override // rx.Observer
                        public void onCompleted() {
                            timeoutSubscriber.onTimeout(l3.longValue());
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th5) {
                            timeoutSubscriber.onError(th5);
                        }

                        @Override // rx.Observer
                        public void onNext(V v3) {
                            timeoutSubscriber.onTimeout(l3.longValue());
                        }
                    });
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, timeoutSubscriber);
                    return Subscriptions.unsubscribed();
                }
            }
        }, observable, Schedulers.immediate());
    }

    @Override // rx.internal.operators.OperatorTimeoutBase
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber subscriber) {
        return super.call(subscriber);
    }
}
