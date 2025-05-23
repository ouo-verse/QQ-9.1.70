package rx.internal.operators;

import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorOnErrorResumeNextViaFunction<T> implements Observable.Operator<T, T> {
    final Func1<Throwable, ? extends Observable<? extends T>> resumeFunction;

    public OperatorOnErrorResumeNextViaFunction(Func1<Throwable, ? extends Observable<? extends T>> func1) {
        this.resumeFunction = func1;
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withException(final Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.3
            @Override // rx.functions.Func1
            public Observable<? extends T> call(Throwable th5) {
                if (th5 instanceof Exception) {
                    return Observable.this;
                }
                return Observable.error(th5);
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withOther(final Observable<? extends T> observable) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.2
            @Override // rx.functions.Func1
            public Observable<? extends T> call(Throwable th5) {
                return Observable.this;
            }
        });
    }

    public static <T> OperatorOnErrorResumeNextViaFunction<T> withSingle(final Func1<Throwable, ? extends T> func1) {
        return new OperatorOnErrorResumeNextViaFunction<>(new Func1<Throwable, Observable<? extends T>>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.1
            @Override // rx.functions.Func1
            public Observable<? extends T> call(Throwable th5) {
                return Observable.just(Func1.this.call(th5));
            }
        });
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final ProducerArbiter producerArbiter = new ProducerArbiter();
        final SerialSubscription serialSubscription = new SerialSubscription();
        Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.4
            private boolean done;
            long produced;

            @Override // rx.Observer
            public void onCompleted() {
                if (this.done) {
                    return;
                }
                this.done = true;
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                if (this.done) {
                    Exceptions.throwIfFatal(th5);
                    RxJavaHooks.onError(th5);
                    return;
                }
                this.done = true;
                try {
                    unsubscribe();
                    Subscriber<T> subscriber3 = new Subscriber<T>() { // from class: rx.internal.operators.OperatorOnErrorResumeNextViaFunction.4.1
                        @Override // rx.Observer
                        public void onCompleted() {
                            subscriber.onCompleted();
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th6) {
                            subscriber.onError(th6);
                        }

                        @Override // rx.Observer
                        public void onNext(T t16) {
                            subscriber.onNext(t16);
                        }

                        @Override // rx.Subscriber
                        public void setProducer(Producer producer) {
                            producerArbiter.setProducer(producer);
                        }
                    };
                    serialSubscription.set(subscriber3);
                    long j3 = this.produced;
                    if (j3 != 0) {
                        producerArbiter.produced(j3);
                    }
                    OperatorOnErrorResumeNextViaFunction.this.resumeFunction.call(th5).unsafeSubscribe(subscriber3);
                } catch (Throwable th6) {
                    Exceptions.throwOrReport(th6, subscriber);
                }
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                if (this.done) {
                    return;
                }
                this.produced++;
                subscriber.onNext(t16);
            }

            @Override // rx.Subscriber
            public void setProducer(Producer producer) {
                producerArbiter.setProducer(producer);
            }
        };
        serialSubscription.set(subscriber2);
        subscriber.add(serialSubscription);
        subscriber.setProducer(producerArbiter);
        return subscriber2;
    }
}
