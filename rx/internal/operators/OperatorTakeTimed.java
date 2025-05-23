package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTakeTimed<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class TakeSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> child;

        public TakeSubscriber(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.child = subscriber;
        }

        @Override // rx.functions.Action0
        public void call() {
            onCompleted();
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.child.onCompleted();
            unsubscribe();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.child.onError(th5);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.child.onNext(t16);
        }
    }

    public OperatorTakeTimed(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.time = j3;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        TakeSubscriber takeSubscriber = new TakeSubscriber(new SerializedSubscriber(subscriber));
        createWorker.schedule(takeSubscriber, this.time, this.unit);
        return takeSubscriber;
    }
}
