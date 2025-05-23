package rx.internal.util;

import rx.Scheduler;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ScalarSynchronousSingle<T> extends Single<T> {
    final T value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DirectScheduledEmission<T> implements Single.OnSubscribe<T> {

        /* renamed from: es, reason: collision with root package name */
        private final EventLoopsScheduler f432691es;
        private final T value;

        DirectScheduledEmission(EventLoopsScheduler eventLoopsScheduler, T t16) {
            this.f432691es = eventLoopsScheduler;
            this.value = t16;
        }

        @Override // rx.functions.Action1
        public void call(SingleSubscriber<? super T> singleSubscriber) {
            singleSubscriber.add(this.f432691es.scheduleDirect(new ScalarSynchronousSingleAction(singleSubscriber, this.value)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class NormalScheduledEmission<T> implements Single.OnSubscribe<T> {
        private final Scheduler scheduler;
        private final T value;

        NormalScheduledEmission(Scheduler scheduler, T t16) {
            this.scheduler = scheduler;
            this.value = t16;
        }

        @Override // rx.functions.Action1
        public void call(SingleSubscriber<? super T> singleSubscriber) {
            Scheduler.Worker createWorker = this.scheduler.createWorker();
            singleSubscriber.add(createWorker);
            createWorker.schedule(new ScalarSynchronousSingleAction(singleSubscriber, this.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ScalarSynchronousSingleAction<T> implements Action0 {
        private final SingleSubscriber<? super T> subscriber;
        private final T value;

        ScalarSynchronousSingleAction(SingleSubscriber<? super T> singleSubscriber, T t16) {
            this.subscriber = singleSubscriber;
            this.value = t16;
        }

        @Override // rx.functions.Action0
        public void call() {
            try {
                this.subscriber.onSuccess(this.value);
            } catch (Throwable th5) {
                this.subscriber.onError(th5);
            }
        }
    }

    protected ScalarSynchronousSingle(final T t16) {
        super(new Single.OnSubscribe<T>() { // from class: rx.internal.util.ScalarSynchronousSingle.1
            @Override // rx.functions.Action1
            public void call(SingleSubscriber<? super T> singleSubscriber) {
                singleSubscriber.onSuccess((Object) t16);
            }
        });
        this.value = t16;
    }

    public static <T> ScalarSynchronousSingle<T> create(T t16) {
        return new ScalarSynchronousSingle<>(t16);
    }

    public T get() {
        return this.value;
    }

    public <R> Single<R> scalarFlatMap(final Func1<? super T, ? extends Single<? extends R>> func1) {
        return Single.create(new Single.OnSubscribe<R>() { // from class: rx.internal.util.ScalarSynchronousSingle.2
            @Override // rx.functions.Action1
            public void call(final SingleSubscriber<? super R> singleSubscriber) {
                Single single = (Single) func1.call(ScalarSynchronousSingle.this.value);
                if (single instanceof ScalarSynchronousSingle) {
                    singleSubscriber.onSuccess(((ScalarSynchronousSingle) single).value);
                    return;
                }
                Subscriber<R> subscriber = new Subscriber<R>() { // from class: rx.internal.util.ScalarSynchronousSingle.2.1
                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        singleSubscriber.onError(th5);
                    }

                    @Override // rx.Observer
                    public void onNext(R r16) {
                        singleSubscriber.onSuccess(r16);
                    }

                    @Override // rx.Observer
                    public void onCompleted() {
                    }
                };
                singleSubscriber.add(subscriber);
                single.unsafeSubscribe(subscriber);
            }
        });
    }

    public Single<T> scalarScheduleOn(Scheduler scheduler) {
        if (scheduler instanceof EventLoopsScheduler) {
            return Single.create(new DirectScheduledEmission((EventLoopsScheduler) scheduler, this.value));
        }
        return Single.create(new NormalScheduledEmission(scheduler, this.value));
    }
}
