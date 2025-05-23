package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeRedo<T> implements Observable.OnSubscribe<T> {
    static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new Func1<Observable<? extends Notification<?>>, Observable<?>>() { // from class: rx.internal.operators.OnSubscribeRedo.1
        @Override // rx.functions.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.map(new Func1<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.OnSubscribeRedo.1.1
                @Override // rx.functions.Func1
                public Notification<?> call(Notification<?> notification) {
                    return Notification.createOnNext(null);
                }
            });
        }
    };
    private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
    private final Scheduler scheduler;
    final Observable<T> source;
    final boolean stopOnComplete;
    final boolean stopOnError;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RedoFinite implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        final long count;

        public RedoFinite(long j3) {
            this.count = j3;
        }

        @Override // rx.functions.Func1
        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return observable.map(new Func1<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.OnSubscribeRedo.RedoFinite.1
                int num;

                @Override // rx.functions.Func1
                public Notification<?> call(Notification<?> notification) {
                    long j3 = RedoFinite.this.count;
                    if (j3 == 0) {
                        return notification;
                    }
                    int i3 = this.num + 1;
                    this.num = i3;
                    return ((long) i3) <= j3 ? Notification.createOnNext(Integer.valueOf(i3)) : notification;
                }
            }).dematerialize();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RetryWithPredicate implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>> {
        final Func2<Integer, Throwable, Boolean> predicate;

        public RetryWithPredicate(Func2<Integer, Throwable, Boolean> func2) {
            this.predicate = func2;
        }

        @Override // rx.functions.Func1
        public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> observable) {
            return observable.scan(Notification.createOnNext(0), new Func2<Notification<Integer>, Notification<?>, Notification<Integer>>() { // from class: rx.internal.operators.OnSubscribeRedo.RetryWithPredicate.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // rx.functions.Func2
                public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                    int intValue = notification.getValue().intValue();
                    return RetryWithPredicate.this.predicate.call(Integer.valueOf(intValue), notification2.getThrowable()).booleanValue() ? Notification.createOnNext(Integer.valueOf(intValue + 1)) : notification2;
                }
            });
        }
    }

    OnSubscribeRedo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, boolean z16, boolean z17, Scheduler scheduler) {
        this.source = observable;
        this.controlHandlerFunction = func1;
        this.stopOnComplete = z16;
        this.stopOnError = z17;
        this.scheduler = scheduler;
    }

    public static <T> Observable<T> redo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return Observable.create(new OnSubscribeRedo(observable, func1, false, false, scheduler));
    }

    public static <T> Observable<T> repeat(Observable<T> observable) {
        return repeat(observable, Schedulers.trampoline());
    }

    public static <T> Observable<T> retry(Observable<T> observable) {
        return retry(observable, REDO_INFINITE);
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Scheduler scheduler) {
        return repeat(observable, REDO_INFINITE, scheduler);
    }

    public static <T> Observable<T> retry(Observable<T> observable, long j3) {
        if (j3 >= 0) {
            return j3 == 0 ? observable : retry(observable, new RedoFinite(j3));
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    @Override // rx.functions.Action1
    public void call(final Subscriber<? super T> subscriber) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final AtomicLong atomicLong = new AtomicLong();
        final Scheduler.Worker createWorker = this.scheduler.createWorker();
        subscriber.add(createWorker);
        final SerialSubscription serialSubscription = new SerialSubscription();
        subscriber.add(serialSubscription);
        final BehaviorSubject create = BehaviorSubject.create();
        create.subscribe((Subscriber) Subscribers.empty());
        final ProducerArbiter producerArbiter = new ProducerArbiter();
        final Action0 action0 = new Action0() { // from class: rx.internal.operators.OnSubscribeRedo.2
            @Override // rx.functions.Action0
            public void call() {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.internal.operators.OnSubscribeRedo.2.1
                    boolean done;

                    private void decrementConsumerCapacity() {
                        long j3;
                        do {
                            j3 = atomicLong.get();
                            if (j3 == Long.MAX_VALUE) {
                                return;
                            }
                        } while (!atomicLong.compareAndSet(j3, j3 - 1));
                    }

                    @Override // rx.Observer
                    public void onCompleted() {
                        if (!this.done) {
                            this.done = true;
                            unsubscribe();
                            create.onNext(Notification.createOnCompleted());
                        }
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        if (!this.done) {
                            this.done = true;
                            unsubscribe();
                            create.onNext(Notification.createOnError(th5));
                        }
                    }

                    @Override // rx.Observer
                    public void onNext(T t16) {
                        if (!this.done) {
                            subscriber.onNext(t16);
                            decrementConsumerCapacity();
                            producerArbiter.produced(1L);
                        }
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer producer) {
                        producerArbiter.setProducer(producer);
                    }
                };
                serialSubscription.set(subscriber2);
                OnSubscribeRedo.this.source.unsafeSubscribe(subscriber2);
            }
        };
        final Observable<?> call = this.controlHandlerFunction.call(create.lift(new Observable.Operator<Notification<?>, Notification<?>>() { // from class: rx.internal.operators.OnSubscribeRedo.3
            @Override // rx.functions.Func1
            public Subscriber<? super Notification<?>> call(final Subscriber<? super Notification<?>> subscriber2) {
                return new Subscriber<Notification<?>>(subscriber2) { // from class: rx.internal.operators.OnSubscribeRedo.3.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber2.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        subscriber2.onError(th5);
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer producer) {
                        producer.request(Long.MAX_VALUE);
                    }

                    @Override // rx.Observer
                    public void onNext(Notification<?> notification) {
                        if (notification.isOnCompleted() && OnSubscribeRedo.this.stopOnComplete) {
                            subscriber2.onCompleted();
                        } else if (notification.isOnError() && OnSubscribeRedo.this.stopOnError) {
                            subscriber2.onError(notification.getThrowable());
                        } else {
                            subscriber2.onNext(notification);
                        }
                    }
                };
            }
        }));
        createWorker.schedule(new Action0() { // from class: rx.internal.operators.OnSubscribeRedo.4
            @Override // rx.functions.Action0
            public void call() {
                call.unsafeSubscribe(new Subscriber<Object>(subscriber) { // from class: rx.internal.operators.OnSubscribeRedo.4.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        subscriber.onError(th5);
                    }

                    @Override // rx.Observer
                    public void onNext(Object obj) {
                        if (!subscriber.isUnsubscribed()) {
                            if (atomicLong.get() > 0) {
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                createWorker.schedule(action0);
                            } else {
                                atomicBoolean.compareAndSet(false, true);
                            }
                        }
                    }

                    @Override // rx.Subscriber
                    public void setProducer(Producer producer) {
                        producer.request(Long.MAX_VALUE);
                    }
                });
            }
        });
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeRedo.5
            @Override // rx.Producer
            public void request(long j3) {
                if (j3 > 0) {
                    BackpressureUtils.getAndAddRequest(atomicLong, j3);
                    producerArbiter.request(j3);
                    if (atomicBoolean.compareAndSet(true, false)) {
                        createWorker.schedule(action0);
                    }
                }
            }
        });
    }

    public static <T> Observable<T> repeat(Observable<T> observable, long j3) {
        return repeat(observable, j3, Schedulers.trampoline());
    }

    public static <T> Observable<T> repeat(Observable<T> observable, long j3, Scheduler scheduler) {
        if (j3 == 0) {
            return Observable.empty();
        }
        if (j3 >= 0) {
            return repeat(observable, new RedoFinite(j3 - 1), scheduler);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.create(new OnSubscribeRedo(observable, func1, true, false, Schedulers.trampoline()));
    }

    public static <T> Observable<T> retry(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return Observable.create(new OnSubscribeRedo(observable, func1, true, false, scheduler));
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.create(new OnSubscribeRedo(observable, func1, false, true, Schedulers.trampoline()));
    }

    public static <T> Observable<T> repeat(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler) {
        return Observable.create(new OnSubscribeRedo(observable, func1, false, true, scheduler));
    }
}
