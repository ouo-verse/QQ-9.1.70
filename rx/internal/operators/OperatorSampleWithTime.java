package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorSampleWithTime<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long time;
    final TimeUnit unit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SamplerSubscriber<T> extends Subscriber<T> implements Action0 {
        private static final Object EMPTY_TOKEN = new Object();
        private final Subscriber<? super T> subscriber;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY_TOKEN);

        public SamplerSubscriber(Subscriber<? super T> subscriber) {
            this.subscriber = subscriber;
        }

        private void emitIfNonEmpty() {
            AtomicReference<Object> atomicReference = this.value;
            Object obj = EMPTY_TOKEN;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                try {
                    this.subscriber.onNext(andSet);
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, this);
                }
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            emitIfNonEmpty();
        }

        @Override // rx.Observer
        public void onCompleted() {
            emitIfNonEmpty();
            this.subscriber.onCompleted();
            unsubscribe();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.subscriber.onError(th5);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.value.set(t16);
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorSampleWithTime(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.time = j3;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        SamplerSubscriber samplerSubscriber = new SamplerSubscriber(serializedSubscriber);
        subscriber.add(samplerSubscriber);
        long j3 = this.time;
        createWorker.schedulePeriodically(samplerSubscriber, j3, j3, this.unit);
        return samplerSubscriber;
    }
}
