package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorTimeoutBase<T> implements Observable.Operator<T, T> {
    final FirstTimeoutStub<T> firstTimeoutStub;
    final Observable<? extends T> other;
    final Scheduler scheduler;
    final TimeoutStub<T> timeoutStub;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface FirstTimeoutStub<T> extends Func3<TimeoutSubscriber<T>, Long, Scheduler.Worker, Subscription> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface TimeoutStub<T> extends Func4<TimeoutSubscriber<T>, Long, T, Scheduler.Worker, Subscription> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class TimeoutSubscriber<T> extends Subscriber<T> {
        long actual;
        final ProducerArbiter arbiter = new ProducerArbiter();
        final Scheduler.Worker inner;
        final Observable<? extends T> other;
        final SerialSubscription serial;
        final SerializedSubscriber<T> serializedSubscriber;
        boolean terminated;
        final TimeoutStub<T> timeoutStub;

        TimeoutSubscriber(SerializedSubscriber<T> serializedSubscriber, TimeoutStub<T> timeoutStub, SerialSubscription serialSubscription, Observable<? extends T> observable, Scheduler.Worker worker) {
            this.serializedSubscriber = serializedSubscriber;
            this.timeoutStub = timeoutStub;
            this.serial = serialSubscription;
            this.other = observable;
            this.inner = worker;
        }

        @Override // rx.Observer
        public void onCompleted() {
            boolean z16;
            synchronized (this) {
                if (!this.terminated) {
                    z16 = true;
                    this.terminated = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            boolean z16;
            synchronized (this) {
                if (!this.terminated) {
                    z16 = true;
                    this.terminated = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                this.serial.unsubscribe();
                this.serializedSubscriber.onError(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            long j3;
            boolean z16;
            synchronized (this) {
                if (!this.terminated) {
                    j3 = this.actual + 1;
                    this.actual = j3;
                    z16 = true;
                } else {
                    j3 = this.actual;
                    z16 = false;
                }
            }
            if (z16) {
                this.serializedSubscriber.onNext(t16);
                this.serial.set(this.timeoutStub.call(this, Long.valueOf(j3), t16, this.inner));
            }
        }

        public void onTimeout(long j3) {
            boolean z16;
            synchronized (this) {
                if (j3 == this.actual && !this.terminated) {
                    z16 = true;
                    this.terminated = true;
                } else {
                    z16 = false;
                }
            }
            if (z16) {
                if (this.other == null) {
                    this.serializedSubscriber.onError(new TimeoutException());
                    return;
                }
                Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        TimeoutSubscriber.this.serializedSubscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        TimeoutSubscriber.this.serializedSubscriber.onError(th5);
                    }

                    @Override // rx.Observer
                    public void onNext(T t16) {
                        TimeoutSubscriber.this.serializedSubscriber.onNext(t16);
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer producer) {
                        TimeoutSubscriber.this.arbiter.setProducer(producer);
                    }
                };
                this.other.unsafeSubscribe(subscriber);
                this.serial.set(subscriber);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.arbiter.setProducer(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OperatorTimeoutBase(FirstTimeoutStub<T> firstTimeoutStub, TimeoutStub<T> timeoutStub, Observable<? extends T> observable, Scheduler scheduler) {
        this.firstTimeoutStub = firstTimeoutStub;
        this.timeoutStub = timeoutStub;
        this.other = observable;
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber);
        SerialSubscription serialSubscription = new SerialSubscription();
        serializedSubscriber.add(serialSubscription);
        TimeoutSubscriber timeoutSubscriber = new TimeoutSubscriber(serializedSubscriber, this.timeoutStub, serialSubscription, this.other, createWorker);
        serializedSubscriber.add(timeoutSubscriber);
        serializedSubscriber.setProducer(timeoutSubscriber.arbiter);
        serialSubscription.set(this.firstTimeoutStub.call(timeoutSubscriber, 0L, createWorker));
        return timeoutSubscriber;
    }
}
