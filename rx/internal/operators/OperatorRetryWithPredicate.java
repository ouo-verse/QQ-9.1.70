package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

/* loaded from: classes29.dex */
public final class OperatorRetryWithPredicate<T> implements Observable.Operator<T, Observable<T>> {
    final Func2<Integer, Throwable, Boolean> predicate;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes29.dex */
    public static final class SourceSubscriber<T> extends Subscriber<Observable<T>> {
        final AtomicInteger attempts = new AtomicInteger();
        final Subscriber<? super T> child;
        final Scheduler.Worker inner;

        /* renamed from: pa, reason: collision with root package name */
        final ProducerArbiter f432680pa;
        final Func2<Integer, Throwable, Boolean> predicate;
        final SerialSubscription serialSubscription;

        public SourceSubscriber(Subscriber<? super T> subscriber, Func2<Integer, Throwable, Boolean> func2, Scheduler.Worker worker, SerialSubscription serialSubscription, ProducerArbiter producerArbiter) {
            this.child = subscriber;
            this.predicate = func2;
            this.inner = worker;
            this.serialSubscription = serialSubscription;
            this.f432680pa = producerArbiter;
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.child.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(final Observable<T> observable) {
            this.inner.schedule(new Action0() { // from class: rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    SourceSubscriber.this.attempts.incrementAndGet();
                    Subscriber<T> subscriber = new Subscriber<T>() { // from class: rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber.1.1
                        boolean done;

                        @Override // rx.Observer
                        public void onCompleted() {
                            if (!this.done) {
                                this.done = true;
                                SourceSubscriber.this.child.onCompleted();
                            }
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th5) {
                            if (!this.done) {
                                this.done = true;
                                SourceSubscriber sourceSubscriber = SourceSubscriber.this;
                                if (sourceSubscriber.predicate.call(Integer.valueOf(sourceSubscriber.attempts.get()), th5).booleanValue() && !SourceSubscriber.this.inner.isUnsubscribed()) {
                                    SourceSubscriber.this.inner.schedule(this);
                                } else {
                                    SourceSubscriber.this.child.onError(th5);
                                }
                            }
                        }

                        @Override // rx.Observer
                        public void onNext(T t16) {
                            if (!this.done) {
                                SourceSubscriber.this.child.onNext(t16);
                                SourceSubscriber.this.f432680pa.produced(1L);
                            }
                        }

                        @Override // rx.Subscriber
                        public void setProducer(Producer producer) {
                            SourceSubscriber.this.f432680pa.setProducer(producer);
                        }
                    };
                    SourceSubscriber.this.serialSubscription.set(subscriber);
                    observable.unsafeSubscribe(subscriber);
                }
            });
        }

        @Override // rx.Observer
        public void onCompleted() {
        }
    }

    public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
        this.predicate = func2;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super Observable<T>> call(Subscriber<? super T> subscriber) {
        Scheduler.Worker createWorker = Schedulers.trampoline().createWorker();
        subscriber.add(createWorker);
        SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        ProducerArbiter producerArbiter = new ProducerArbiter();
        subscriber.setProducer(producerArbiter);
        return new SourceSubscriber(subscriber, this.predicate, createWorker, serialSubscription, producerArbiter);
    }
}
