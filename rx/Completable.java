package rx;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.annotations.Experimental;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.CompletableOnSubscribeConcat;
import rx.internal.operators.CompletableOnSubscribeConcatArray;
import rx.internal.operators.CompletableOnSubscribeConcatIterable;
import rx.internal.operators.CompletableOnSubscribeMerge;
import rx.internal.operators.CompletableOnSubscribeMergeArray;
import rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray;
import rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable;
import rx.internal.operators.CompletableOnSubscribeMergeIterable;
import rx.internal.operators.CompletableOnSubscribeTimeout;
import rx.internal.util.SubscriptionList;
import rx.internal.util.UtilityFunctions;
import rx.observers.SafeCompletableSubscriber;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public class Completable {
    static final Completable COMPLETE = new Completable(new CompletableOnSubscribe() { // from class: rx.Completable.1
        @Override // rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
            completableSubscriber.onCompleted();
        }
    }, false);
    static final Completable NEVER = new Completable(new CompletableOnSubscribe() { // from class: rx.Completable.2
        @Override // rx.functions.Action1
        public void call(CompletableSubscriber completableSubscriber) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
        }
    }, false);
    private final CompletableOnSubscribe onSubscribe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: rx.Completable$17, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class AnonymousClass17 implements CompletableOnSubscribe {
        final /* synthetic */ Action0 val$onAfterComplete;
        final /* synthetic */ Action0 val$onComplete;
        final /* synthetic */ Action1 val$onError;
        final /* synthetic */ Action1 val$onSubscribe;
        final /* synthetic */ Action0 val$onUnsubscribe;

        AnonymousClass17(Action0 action0, Action0 action02, Action1 action1, Action1 action12, Action0 action03) {
            this.val$onComplete = action0;
            this.val$onAfterComplete = action02;
            this.val$onError = action1;
            this.val$onSubscribe = action12;
            this.val$onUnsubscribe = action03;
        }

        @Override // rx.functions.Action1
        public void call(final CompletableSubscriber completableSubscriber) {
            Completable.this.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.17.1
                @Override // rx.Completable.CompletableSubscriber
                public void onCompleted() {
                    try {
                        AnonymousClass17.this.val$onComplete.call();
                        completableSubscriber.onCompleted();
                        try {
                            AnonymousClass17.this.val$onAfterComplete.call();
                        } catch (Throwable th5) {
                            RxJavaHooks.onError(th5);
                        }
                    } catch (Throwable th6) {
                        completableSubscriber.onError(th6);
                    }
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onError(Throwable th5) {
                    try {
                        AnonymousClass17.this.val$onError.call(th5);
                    } catch (Throwable th6) {
                        th5 = new CompositeException(Arrays.asList(th5, th6));
                    }
                    completableSubscriber.onError(th5);
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onSubscribe(final Subscription subscription) {
                    try {
                        AnonymousClass17.this.val$onSubscribe.call(subscription);
                        completableSubscriber.onSubscribe(Subscriptions.create(new Action0() { // from class: rx.Completable.17.1.1
                            @Override // rx.functions.Action0
                            public void call() {
                                try {
                                    AnonymousClass17.this.val$onUnsubscribe.call();
                                } catch (Throwable th5) {
                                    RxJavaHooks.onError(th5);
                                }
                                subscription.unsubscribe();
                            }
                        }));
                    } catch (Throwable th5) {
                        subscription.unsubscribe();
                        completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                        completableSubscriber.onError(th5);
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* renamed from: rx.Completable$33, reason: invalid class name */
    /* loaded from: classes29.dex */
    class AnonymousClass33 implements CompletableOnSubscribe {
        final /* synthetic */ Scheduler val$scheduler;

        AnonymousClass33(Scheduler scheduler) {
            this.val$scheduler = scheduler;
        }

        @Override // rx.functions.Action1
        public void call(final CompletableSubscriber completableSubscriber) {
            Completable.this.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.33.1
                @Override // rx.Completable.CompletableSubscriber
                public void onCompleted() {
                    completableSubscriber.onCompleted();
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onError(Throwable th5) {
                    completableSubscriber.onError(th5);
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onSubscribe(final Subscription subscription) {
                    completableSubscriber.onSubscribe(Subscriptions.create(new Action0() { // from class: rx.Completable.33.1.1
                        @Override // rx.functions.Action0
                        public void call() {
                            final Scheduler.Worker createWorker = AnonymousClass33.this.val$scheduler.createWorker();
                            createWorker.schedule(new Action0() { // from class: rx.Completable.33.1.1.1
                                @Override // rx.functions.Action0
                                public void call() {
                                    try {
                                        subscription.unsubscribe();
                                    } finally {
                                        createWorker.unsubscribe();
                                    }
                                }
                            });
                        }
                    }));
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface CompletableOnSubscribe extends Action1<CompletableSubscriber> {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface CompletableOperator extends Func1<CompletableSubscriber, CompletableSubscriber> {
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface CompletableSubscriber {
        void onCompleted();

        void onError(Throwable th5);

        void onSubscribe(Subscription subscription);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface CompletableTransformer extends Func1<Completable, Completable> {
    }

    protected Completable(CompletableOnSubscribe completableOnSubscribe) {
        this.onSubscribe = RxJavaHooks.onCreate(completableOnSubscribe);
    }

    public static Completable amb(final Completable... completableArr) {
        requireNonNull(completableArr);
        if (completableArr.length == 0) {
            return complete();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.3
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                final CompositeSubscription compositeSubscription = new CompositeSubscription();
                completableSubscriber.onSubscribe(compositeSubscription);
                final AtomicBoolean atomicBoolean = new AtomicBoolean();
                CompletableSubscriber completableSubscriber2 = new CompletableSubscriber() { // from class: rx.Completable.3.1
                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            compositeSubscription.unsubscribe();
                            completableSubscriber.onCompleted();
                        }
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(Throwable th5) {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            compositeSubscription.unsubscribe();
                            completableSubscriber.onError(th5);
                        } else {
                            RxJavaHooks.onError(th5);
                        }
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription subscription) {
                        compositeSubscription.add(subscription);
                    }
                };
                for (Completable completable : completableArr) {
                    if (compositeSubscription.isUnsubscribed()) {
                        return;
                    }
                    if (completable == null) {
                        Throwable nullPointerException = new NullPointerException("One of the sources is null");
                        if (atomicBoolean.compareAndSet(false, true)) {
                            compositeSubscription.unsubscribe();
                            completableSubscriber.onError(nullPointerException);
                            return;
                        } else {
                            RxJavaHooks.onError(nullPointerException);
                            return;
                        }
                    }
                    if (atomicBoolean.get() || compositeSubscription.isUnsubscribed()) {
                        return;
                    }
                    completable.unsafeSubscribe(completableSubscriber2);
                }
            }
        });
    }

    public static Completable complete() {
        Completable completable = COMPLETE;
        CompletableOnSubscribe onCreate = RxJavaHooks.onCreate(completable.onSubscribe);
        if (onCreate == completable.onSubscribe) {
            return completable;
        }
        return new Completable(onCreate, false);
    }

    public static Completable concat(Completable... completableArr) {
        requireNonNull(completableArr);
        if (completableArr.length == 0) {
            return complete();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return create(new CompletableOnSubscribeConcatArray(completableArr));
    }

    public static Completable create(CompletableOnSubscribe completableOnSubscribe) {
        requireNonNull(completableOnSubscribe);
        try {
            return new Completable(completableOnSubscribe);
        } catch (NullPointerException e16) {
            throw e16;
        } catch (Throwable th5) {
            RxJavaHooks.onError(th5);
            throw toNpe(th5);
        }
    }

    public static Completable defer(final Func0<? extends Completable> func0) {
        requireNonNull(func0);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.5
            @Override // rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                try {
                    Completable completable = (Completable) Func0.this.call();
                    if (completable == null) {
                        completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                        completableSubscriber.onError(new NullPointerException("The completable returned is null"));
                    } else {
                        completable.unsafeSubscribe(completableSubscriber);
                    }
                } catch (Throwable th5) {
                    completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                    completableSubscriber.onError(th5);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deliverUncaughtException(Throwable th5) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th5);
    }

    public static Completable error(final Func0<? extends Throwable> func0) {
        requireNonNull(func0);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.6
            @Override // rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                try {
                    th = (Throwable) Func0.this.call();
                } catch (Throwable th5) {
                    th = th5;
                }
                if (th == null) {
                    th = new NullPointerException("The error supplied is null");
                }
                completableSubscriber.onError(th);
            }
        });
    }

    public static Completable fromAction(final Action0 action0) {
        requireNonNull(action0);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.8
            @Override // rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                BooleanSubscription booleanSubscription = new BooleanSubscription();
                completableSubscriber.onSubscribe(booleanSubscription);
                try {
                    Action0.this.call();
                    if (booleanSubscription.isUnsubscribed()) {
                        return;
                    }
                    completableSubscriber.onCompleted();
                } catch (Throwable th5) {
                    if (booleanSubscription.isUnsubscribed()) {
                        return;
                    }
                    completableSubscriber.onError(th5);
                }
            }
        });
    }

    public static Completable fromCallable(final Callable<?> callable) {
        requireNonNull(callable);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.9
            @Override // rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                BooleanSubscription booleanSubscription = new BooleanSubscription();
                completableSubscriber.onSubscribe(booleanSubscription);
                try {
                    callable.call();
                    if (booleanSubscription.isUnsubscribed()) {
                        return;
                    }
                    completableSubscriber.onCompleted();
                } catch (Throwable th5) {
                    if (booleanSubscription.isUnsubscribed()) {
                        return;
                    }
                    completableSubscriber.onError(th5);
                }
            }
        });
    }

    public static Completable fromFuture(Future<?> future) {
        requireNonNull(future);
        return fromObservable(Observable.from(future));
    }

    public static Completable fromObservable(final Observable<?> observable) {
        requireNonNull(observable);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.10
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                Subscriber<Object> subscriber = new Subscriber<Object>() { // from class: rx.Completable.10.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        completableSubscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        completableSubscriber.onError(th5);
                    }

                    @Override // rx.Observer
                    public void onNext(Object obj) {
                    }
                };
                completableSubscriber.onSubscribe(subscriber);
                Observable.this.unsafeSubscribe(subscriber);
            }
        });
    }

    public static Completable fromSingle(final Single<?> single) {
        requireNonNull(single);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.11
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                SingleSubscriber<Object> singleSubscriber = new SingleSubscriber<Object>() { // from class: rx.Completable.11.1
                    @Override // rx.SingleSubscriber
                    public void onError(Throwable th5) {
                        completableSubscriber.onError(th5);
                    }

                    @Override // rx.SingleSubscriber
                    public void onSuccess(Object obj) {
                        completableSubscriber.onCompleted();
                    }
                };
                completableSubscriber.onSubscribe(singleSubscriber);
                Single.this.subscribe(singleSubscriber);
            }
        });
    }

    public static Completable merge(Completable... completableArr) {
        requireNonNull(completableArr);
        if (completableArr.length == 0) {
            return complete();
        }
        if (completableArr.length == 1) {
            return completableArr[0];
        }
        return create(new CompletableOnSubscribeMergeArray(completableArr));
    }

    protected static Completable merge0(Observable<? extends Completable> observable, int i3, boolean z16) {
        requireNonNull(observable);
        if (i3 >= 1) {
            return create(new CompletableOnSubscribeMerge(observable, i3, z16));
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i3);
    }

    public static Completable mergeDelayError(Completable... completableArr) {
        requireNonNull(completableArr);
        return create(new CompletableOnSubscribeMergeDelayErrorArray(completableArr));
    }

    public static Completable never() {
        Completable completable = NEVER;
        CompletableOnSubscribe onCreate = RxJavaHooks.onCreate(completable.onSubscribe);
        if (onCreate == completable.onSubscribe) {
            return completable;
        }
        return new Completable(onCreate, false);
    }

    static <T> T requireNonNull(T t16) {
        t16.getClass();
        return t16;
    }

    public static Completable timer(long j3, TimeUnit timeUnit) {
        return timer(j3, timeUnit, Schedulers.computation());
    }

    static NullPointerException toNpe(Throwable th5) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th5);
        return nullPointerException;
    }

    public static <R> Completable using(Func0<R> func0, Func1<? super R, ? extends Completable> func1, Action1<? super R> action1) {
        return using(func0, func1, action1, true);
    }

    public final Completable ambWith(Completable completable) {
        requireNonNull(completable);
        return amb(this, completable);
    }

    public final <T> Observable<T> andThen(Observable<T> observable) {
        requireNonNull(observable);
        return observable.delaySubscription(toObservable());
    }

    public final void await() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.14
            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th5) {
                thArr[0] = th5;
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
            }
        });
        if (countDownLatch.getCount() == 0) {
            Throwable th5 = thArr[0];
            if (th5 != null) {
                Exceptions.propagate(th5);
                return;
            }
            return;
        }
        try {
            countDownLatch.await();
            Throwable th6 = thArr[0];
            if (th6 != null) {
                Exceptions.propagate(th6);
            }
        } catch (InterruptedException e16) {
            throw Exceptions.propagate(e16);
        }
    }

    public final Completable compose(CompletableTransformer completableTransformer) {
        return (Completable) to(completableTransformer);
    }

    public final Completable concatWith(Completable completable) {
        requireNonNull(completable);
        return concat(this, completable);
    }

    public final Completable delay(long j3, TimeUnit timeUnit) {
        return delay(j3, timeUnit, Schedulers.computation(), false);
    }

    public final Completable doAfterTerminate(Action0 action0) {
        return doOnLifecycle(Actions.empty(), Actions.empty(), Actions.empty(), action0, Actions.empty());
    }

    @Deprecated
    public final Completable doOnComplete(Action0 action0) {
        return doOnCompleted(action0);
    }

    public final Completable doOnCompleted(Action0 action0) {
        return doOnLifecycle(Actions.empty(), Actions.empty(), action0, Actions.empty(), Actions.empty());
    }

    public final Completable doOnError(Action1<? super Throwable> action1) {
        return doOnLifecycle(Actions.empty(), action1, Actions.empty(), Actions.empty(), Actions.empty());
    }

    protected final Completable doOnLifecycle(Action1<? super Subscription> action1, Action1<? super Throwable> action12, Action0 action0, Action0 action02, Action0 action03) {
        requireNonNull(action1);
        requireNonNull(action12);
        requireNonNull(action0);
        requireNonNull(action02);
        requireNonNull(action03);
        return create(new AnonymousClass17(action0, action02, action12, action1, action03));
    }

    public final Completable doOnSubscribe(Action1<? super Subscription> action1) {
        return doOnLifecycle(action1, Actions.empty(), Actions.empty(), Actions.empty(), Actions.empty());
    }

    public final Completable doOnTerminate(final Action0 action0) {
        return doOnLifecycle(Actions.empty(), new Action1<Throwable>() { // from class: rx.Completable.18
            @Override // rx.functions.Action1
            public void call(Throwable th5) {
                action0.call();
            }
        }, action0, Actions.empty(), Actions.empty());
    }

    public final Completable doOnUnsubscribe(Action0 action0) {
        return doOnLifecycle(Actions.empty(), Actions.empty(), Actions.empty(), Actions.empty(), action0);
    }

    @Deprecated
    public final Completable endWith(Completable completable) {
        return andThen(completable);
    }

    public final Throwable get() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.19
            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th5) {
                thArr[0] = th5;
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
            }
        });
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            countDownLatch.await();
            return thArr[0];
        } catch (InterruptedException e16) {
            throw Exceptions.propagate(e16);
        }
    }

    public final Completable lift(final CompletableOperator completableOperator) {
        requireNonNull(completableOperator);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.21
            @Override // rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                try {
                    Completable.this.unsafeSubscribe(RxJavaHooks.onCompletableLift(completableOperator).call(completableSubscriber));
                } catch (NullPointerException e16) {
                    throw e16;
                } catch (Throwable th5) {
                    throw Completable.toNpe(th5);
                }
            }
        });
    }

    public final Completable mergeWith(Completable completable) {
        requireNonNull(completable);
        return merge(this, completable);
    }

    public final Completable observeOn(final Scheduler scheduler) {
        requireNonNull(scheduler);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.22
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                final SubscriptionList subscriptionList = new SubscriptionList();
                final Scheduler.Worker createWorker = scheduler.createWorker();
                subscriptionList.add(createWorker);
                completableSubscriber.onSubscribe(subscriptionList);
                Completable.this.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.22.1
                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        createWorker.schedule(new Action0() { // from class: rx.Completable.22.1.1
                            @Override // rx.functions.Action0
                            public void call() {
                                try {
                                    completableSubscriber.onCompleted();
                                } finally {
                                    subscriptionList.unsubscribe();
                                }
                            }
                        });
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(final Throwable th5) {
                        createWorker.schedule(new Action0() { // from class: rx.Completable.22.1.2
                            @Override // rx.functions.Action0
                            public void call() {
                                try {
                                    completableSubscriber.onError(th5);
                                } finally {
                                    subscriptionList.unsubscribe();
                                }
                            }
                        });
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription subscription) {
                        subscriptionList.add(subscription);
                    }
                });
            }
        });
    }

    public final Completable onErrorComplete() {
        return onErrorComplete(UtilityFunctions.alwaysTrue());
    }

    public final Completable onErrorResumeNext(final Func1<? super Throwable, ? extends Completable> func1) {
        requireNonNull(func1);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.24
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                final SerialSubscription serialSubscription = new SerialSubscription();
                Completable.this.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.24.1
                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        completableSubscriber.onCompleted();
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(Throwable th5) {
                        try {
                            Completable completable = (Completable) func1.call(th5);
                            if (completable == null) {
                                completableSubscriber.onError(new CompositeException(Arrays.asList(th5, new NullPointerException("The completable returned is null"))));
                            } else {
                                completable.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.24.1.1
                                    @Override // rx.Completable.CompletableSubscriber
                                    public void onCompleted() {
                                        completableSubscriber.onCompleted();
                                    }

                                    @Override // rx.Completable.CompletableSubscriber
                                    public void onError(Throwable th6) {
                                        completableSubscriber.onError(th6);
                                    }

                                    @Override // rx.Completable.CompletableSubscriber
                                    public void onSubscribe(Subscription subscription) {
                                        serialSubscription.set(subscription);
                                    }
                                });
                            }
                        } catch (Throwable th6) {
                            completableSubscriber.onError(new CompositeException(Arrays.asList(th5, th6)));
                        }
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription subscription) {
                        serialSubscription.set(subscription);
                    }
                });
            }
        });
    }

    public final Completable repeat() {
        return fromObservable(toObservable().repeat());
    }

    public final Completable repeatWhen(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        requireNonNull(func1);
        return fromObservable(toObservable().repeatWhen(func1));
    }

    public final Completable retry() {
        return fromObservable(toObservable().retry());
    }

    public final Completable retryWhen(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return fromObservable(toObservable().retryWhen(func1));
    }

    public final Completable startWith(Completable completable) {
        requireNonNull(completable);
        return concat(completable, this);
    }

    public final Subscription subscribe() {
        final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.25
            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                multipleAssignmentSubscription.unsubscribe();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th5) {
                RxJavaHooks.onError(th5);
                multipleAssignmentSubscription.unsubscribe();
                Completable.deliverUncaughtException(th5);
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
                multipleAssignmentSubscription.set(subscription);
            }
        });
        return multipleAssignmentSubscription;
    }

    public final Completable subscribeOn(final Scheduler scheduler) {
        requireNonNull(scheduler);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.29
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                final Scheduler.Worker createWorker = scheduler.createWorker();
                createWorker.schedule(new Action0() { // from class: rx.Completable.29.1
                    @Override // rx.functions.Action0
                    public void call() {
                        try {
                            Completable.this.unsafeSubscribe(completableSubscriber);
                        } finally {
                            createWorker.unsubscribe();
                        }
                    }
                });
            }
        });
    }

    public final Completable timeout(long j3, TimeUnit timeUnit) {
        return timeout0(j3, timeUnit, Schedulers.computation(), null);
    }

    public final Completable timeout0(long j3, TimeUnit timeUnit, Scheduler scheduler, Completable completable) {
        requireNonNull(timeUnit);
        requireNonNull(scheduler);
        return create(new CompletableOnSubscribeTimeout(this, j3, timeUnit, scheduler, completable));
    }

    public final <U> U to(Func1<? super Completable, U> func1) {
        return func1.call(this);
    }

    public final <T> Observable<T> toObservable() {
        return Observable.create(new Observable.OnSubscribe<T>() { // from class: rx.Completable.30
            @Override // rx.functions.Action1
            public void call(Subscriber<? super T> subscriber) {
                Completable.this.unsafeSubscribe(subscriber);
            }
        });
    }

    public final <T> Single<T> toSingle(final Func0<? extends T> func0) {
        requireNonNull(func0);
        return Single.create(new Single.OnSubscribe<T>() { // from class: rx.Completable.31
            @Override // rx.functions.Action1
            public void call(final SingleSubscriber<? super T> singleSubscriber) {
                Completable.this.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.31.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        try {
                            Object call = func0.call();
                            if (call == null) {
                                singleSubscriber.onError(new NullPointerException("The value supplied is null"));
                            } else {
                                singleSubscriber.onSuccess(call);
                            }
                        } catch (Throwable th5) {
                            singleSubscriber.onError(th5);
                        }
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(Throwable th5) {
                        singleSubscriber.onError(th5);
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription subscription) {
                        singleSubscriber.add(subscription);
                    }
                });
            }
        });
    }

    public final <T> Single<T> toSingleDefault(final T t16) {
        requireNonNull(t16);
        return toSingle(new Func0<T>() { // from class: rx.Completable.32
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public T call() {
                return (T) t16;
            }
        });
    }

    public final void unsafeSubscribe(CompletableSubscriber completableSubscriber) {
        requireNonNull(completableSubscriber);
        try {
            RxJavaHooks.onCompletableStart(this, this.onSubscribe).call(completableSubscriber);
        } catch (NullPointerException e16) {
            throw e16;
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            Throwable onCompletableError = RxJavaHooks.onCompletableError(th5);
            RxJavaHooks.onError(onCompletableError);
            throw toNpe(onCompletableError);
        }
    }

    public final Completable unsubscribeOn(Scheduler scheduler) {
        requireNonNull(scheduler);
        return create(new AnonymousClass33(scheduler));
    }

    public static Completable timer(final long j3, final TimeUnit timeUnit, final Scheduler scheduler) {
        requireNonNull(timeUnit);
        requireNonNull(scheduler);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.12
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
                completableSubscriber.onSubscribe(multipleAssignmentSubscription);
                if (multipleAssignmentSubscription.isUnsubscribed()) {
                    return;
                }
                final Scheduler.Worker createWorker = Scheduler.this.createWorker();
                multipleAssignmentSubscription.set(createWorker);
                createWorker.schedule(new Action0() { // from class: rx.Completable.12.1
                    @Override // rx.functions.Action0
                    public void call() {
                        try {
                            completableSubscriber.onCompleted();
                        } finally {
                            createWorker.unsubscribe();
                        }
                    }
                }, j3, timeUnit);
            }
        });
    }

    public static <R> Completable using(final Func0<R> func0, final Func1<? super R, ? extends Completable> func1, final Action1<? super R> action1, final boolean z16) {
        requireNonNull(func0);
        requireNonNull(func1);
        requireNonNull(action1);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.13

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            /* renamed from: rx.Completable$13$1, reason: invalid class name */
            /* loaded from: classes29.dex */
            public class AnonymousClass1 implements CompletableSubscriber {

                /* renamed from: d, reason: collision with root package name */
                Subscription f432650d;
                final /* synthetic */ AtomicBoolean val$once;
                final /* synthetic */ Object val$resource;
                final /* synthetic */ CompletableSubscriber val$s;

                AnonymousClass1(AtomicBoolean atomicBoolean, Object obj, CompletableSubscriber completableSubscriber) {
                    this.val$once = atomicBoolean;
                    this.val$resource = obj;
                    this.val$s = completableSubscriber;
                }

                void dispose() {
                    this.f432650d.unsubscribe();
                    if (this.val$once.compareAndSet(false, true)) {
                        try {
                            action1.call(this.val$resource);
                        } catch (Throwable th5) {
                            RxJavaHooks.onError(th5);
                        }
                    }
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onCompleted() {
                    if (z16 && this.val$once.compareAndSet(false, true)) {
                        try {
                            action1.call(this.val$resource);
                        } catch (Throwable th5) {
                            this.val$s.onError(th5);
                            return;
                        }
                    }
                    this.val$s.onCompleted();
                    if (!z16) {
                        dispose();
                    }
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onError(Throwable th5) {
                    if (z16 && this.val$once.compareAndSet(false, true)) {
                        try {
                            action1.call(this.val$resource);
                        } catch (Throwable th6) {
                            th5 = new CompositeException(Arrays.asList(th5, th6));
                        }
                    }
                    this.val$s.onError(th5);
                    if (!z16) {
                        dispose();
                    }
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onSubscribe(Subscription subscription) {
                    this.f432650d = subscription;
                    this.val$s.onSubscribe(Subscriptions.create(new Action0() { // from class: rx.Completable.13.1.1
                        @Override // rx.functions.Action0
                        public void call() {
                            AnonymousClass1.this.dispose();
                        }
                    }));
                }
            }

            @Override // rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                try {
                    Object call = Func0.this.call();
                    try {
                        Completable completable = (Completable) func1.call(call);
                        if (completable == null) {
                            try {
                                action1.call(call);
                                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                                completableSubscriber.onError(new NullPointerException("The completable supplied is null"));
                                return;
                            } catch (Throwable th5) {
                                Exceptions.throwIfFatal(th5);
                                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                                completableSubscriber.onError(new CompositeException(Arrays.asList(new NullPointerException("The completable supplied is null"), th5)));
                                return;
                            }
                        }
                        completable.unsafeSubscribe(new AnonymousClass1(new AtomicBoolean(), call, completableSubscriber));
                    } catch (Throwable th6) {
                        try {
                            action1.call(call);
                            Exceptions.throwIfFatal(th6);
                            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                            completableSubscriber.onError(th6);
                        } catch (Throwable th7) {
                            Exceptions.throwIfFatal(th6);
                            Exceptions.throwIfFatal(th7);
                            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                            completableSubscriber.onError(new CompositeException(Arrays.asList(th6, th7)));
                        }
                    }
                } catch (Throwable th8) {
                    completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                    completableSubscriber.onError(th8);
                }
            }
        });
    }

    public final Completable delay(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j3, timeUnit, scheduler, false);
    }

    @Deprecated
    public final <T> Observable<T> endWith(Observable<T> observable) {
        return andThen(observable);
    }

    public final Completable onErrorComplete(final Func1<? super Throwable, Boolean> func1) {
        requireNonNull(func1);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.23
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                Completable.this.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.23.1
                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        completableSubscriber.onCompleted();
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(Throwable th5) {
                        boolean z16;
                        try {
                            z16 = ((Boolean) func1.call(th5)).booleanValue();
                        } catch (Throwable th6) {
                            Exceptions.throwIfFatal(th6);
                            th5 = new CompositeException(Arrays.asList(th5, th6));
                            z16 = false;
                        }
                        if (z16) {
                            completableSubscriber.onCompleted();
                        } else {
                            completableSubscriber.onError(th5);
                        }
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription subscription) {
                        completableSubscriber.onSubscribe(subscription);
                    }
                });
            }
        });
    }

    public final Completable repeat(long j3) {
        return fromObservable(toObservable().repeat(j3));
    }

    public final Completable retry(Func2<Integer, Throwable, Boolean> func2) {
        return fromObservable(toObservable().retry(func2));
    }

    public final Completable timeout(long j3, TimeUnit timeUnit, Completable completable) {
        requireNonNull(completable);
        return timeout0(j3, timeUnit, Schedulers.computation(), completable);
    }

    Completable(CompletableOnSubscribe completableOnSubscribe, boolean z16) {
        this.onSubscribe = z16 ? RxJavaHooks.onCreate(completableOnSubscribe) : completableOnSubscribe;
    }

    public static Completable error(final Throwable th5) {
        requireNonNull(th5);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.7
            @Override // rx.functions.Action1
            public void call(CompletableSubscriber completableSubscriber) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                completableSubscriber.onError(th5);
            }
        });
    }

    public static Completable mergeDelayError(Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new CompletableOnSubscribeMergeDelayErrorIterable(iterable));
    }

    public final <T> Single<T> andThen(Single<T> single) {
        requireNonNull(single);
        return single.delaySubscription(toObservable());
    }

    public final Completable delay(final long j3, final TimeUnit timeUnit, final Scheduler scheduler, final boolean z16) {
        requireNonNull(timeUnit);
        requireNonNull(scheduler);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.16
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                final CompositeSubscription compositeSubscription = new CompositeSubscription();
                final Scheduler.Worker createWorker = scheduler.createWorker();
                compositeSubscription.add(createWorker);
                Completable.this.unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.16.1
                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        CompositeSubscription compositeSubscription2 = compositeSubscription;
                        Scheduler.Worker worker = createWorker;
                        Action0 action0 = new Action0() { // from class: rx.Completable.16.1.1
                            @Override // rx.functions.Action0
                            public void call() {
                                try {
                                    completableSubscriber.onCompleted();
                                } finally {
                                    createWorker.unsubscribe();
                                }
                            }
                        };
                        AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                        compositeSubscription2.add(worker.schedule(action0, j3, timeUnit));
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(final Throwable th5) {
                        if (z16) {
                            CompositeSubscription compositeSubscription2 = compositeSubscription;
                            Scheduler.Worker worker = createWorker;
                            Action0 action0 = new Action0() { // from class: rx.Completable.16.1.2
                                @Override // rx.functions.Action0
                                public void call() {
                                    try {
                                        completableSubscriber.onError(th5);
                                    } finally {
                                        createWorker.unsubscribe();
                                    }
                                }
                            };
                            AnonymousClass16 anonymousClass16 = AnonymousClass16.this;
                            compositeSubscription2.add(worker.schedule(action0, j3, timeUnit));
                            return;
                        }
                        completableSubscriber.onError(th5);
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription subscription) {
                        compositeSubscription.add(subscription);
                        completableSubscriber.onSubscribe(compositeSubscription);
                    }
                });
            }
        });
    }

    public final Completable retry(long j3) {
        return fromObservable(toObservable().retry(j3));
    }

    public final <T> Observable<T> startWith(Observable<T> observable) {
        requireNonNull(observable);
        return toObservable().startWith((Observable) observable);
    }

    public final Subscription subscribe(final Action0 action0) {
        requireNonNull(action0);
        final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.26
            boolean done;

            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    try {
                        action0.call();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th5) {
                RxJavaHooks.onError(th5);
                multipleAssignmentSubscription.unsubscribe();
                Completable.deliverUncaughtException(th5);
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
                multipleAssignmentSubscription.set(subscription);
            }
        });
        return multipleAssignmentSubscription;
    }

    public final Completable timeout(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j3, timeUnit, scheduler, null);
    }

    public static Completable mergeDelayError(Observable<? extends Completable> observable) {
        return merge0(observable, Integer.MAX_VALUE, true);
    }

    public final Completable andThen(Completable completable) {
        return concatWith(completable);
    }

    public final Completable timeout(long j3, TimeUnit timeUnit, Scheduler scheduler, Completable completable) {
        requireNonNull(completable);
        return timeout0(j3, timeUnit, scheduler, completable);
    }

    public static Completable mergeDelayError(Observable<? extends Completable> observable, int i3) {
        return merge0(observable, i3, true);
    }

    public final Throwable get(long j3, TimeUnit timeUnit) {
        requireNonNull(timeUnit);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.20
            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th5) {
                thArr[0] = th5;
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
            }
        });
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            if (countDownLatch.await(j3, timeUnit)) {
                return thArr[0];
            }
            Exceptions.propagate(new TimeoutException());
            return null;
        } catch (InterruptedException e16) {
            throw Exceptions.propagate(e16);
        }
    }

    public final Subscription subscribe(final Action0 action0, final Action1<? super Throwable> action1) {
        requireNonNull(action0);
        requireNonNull(action1);
        final MultipleAssignmentSubscription multipleAssignmentSubscription = new MultipleAssignmentSubscription();
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.27
            boolean done;

            void callOnError(Throwable th5) {
                try {
                    action1.call(th5);
                } finally {
                    try {
                    } finally {
                    }
                }
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                if (!this.done) {
                    this.done = true;
                    try {
                        action0.call();
                        multipleAssignmentSubscription.unsubscribe();
                    } catch (Throwable th5) {
                        callOnError(th5);
                    }
                }
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th5) {
                if (!this.done) {
                    this.done = true;
                    callOnError(th5);
                } else {
                    RxJavaHooks.onError(th5);
                    Completable.deliverUncaughtException(th5);
                }
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
                multipleAssignmentSubscription.set(subscription);
            }
        });
        return multipleAssignmentSubscription;
    }

    public static Completable amb(final Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new CompletableOnSubscribe() { // from class: rx.Completable.4
            @Override // rx.functions.Action1
            public void call(final CompletableSubscriber completableSubscriber) {
                final CompositeSubscription compositeSubscription = new CompositeSubscription();
                completableSubscriber.onSubscribe(compositeSubscription);
                try {
                    Iterator it = iterable.iterator();
                    if (it == null) {
                        completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
                        return;
                    }
                    final AtomicBoolean atomicBoolean = new AtomicBoolean();
                    CompletableSubscriber completableSubscriber2 = new CompletableSubscriber() { // from class: rx.Completable.4.1
                        @Override // rx.Completable.CompletableSubscriber
                        public void onCompleted() {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onCompleted();
                            }
                        }

                        @Override // rx.Completable.CompletableSubscriber
                        public void onError(Throwable th5) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(th5);
                            } else {
                                RxJavaHooks.onError(th5);
                            }
                        }

                        @Override // rx.Completable.CompletableSubscriber
                        public void onSubscribe(Subscription subscription) {
                            compositeSubscription.add(subscription);
                        }
                    };
                    boolean z16 = true;
                    while (!atomicBoolean.get() && !compositeSubscription.isUnsubscribed()) {
                        try {
                            if (!it.hasNext()) {
                                if (z16) {
                                    completableSubscriber.onCompleted();
                                    return;
                                }
                                return;
                            }
                            if (atomicBoolean.get() || compositeSubscription.isUnsubscribed()) {
                                return;
                            }
                            try {
                                Completable completable = (Completable) it.next();
                                if (completable == null) {
                                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                    if (atomicBoolean.compareAndSet(false, true)) {
                                        compositeSubscription.unsubscribe();
                                        completableSubscriber.onError(nullPointerException);
                                        return;
                                    } else {
                                        RxJavaHooks.onError(nullPointerException);
                                        return;
                                    }
                                }
                                if (atomicBoolean.get() || compositeSubscription.isUnsubscribed()) {
                                    return;
                                }
                                completable.unsafeSubscribe(completableSubscriber2);
                                z16 = false;
                            } catch (Throwable th5) {
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    compositeSubscription.unsubscribe();
                                    completableSubscriber.onError(th5);
                                    return;
                                } else {
                                    RxJavaHooks.onError(th5);
                                    return;
                                }
                            }
                        } catch (Throwable th6) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(th6);
                                return;
                            } else {
                                RxJavaHooks.onError(th6);
                                return;
                            }
                        }
                    }
                } catch (Throwable th7) {
                    completableSubscriber.onError(th7);
                }
            }
        });
    }

    public static Completable concat(Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new CompletableOnSubscribeConcatIterable(iterable));
    }

    public static Completable merge(Iterable<? extends Completable> iterable) {
        requireNonNull(iterable);
        return create(new CompletableOnSubscribeMergeIterable(iterable));
    }

    public final boolean await(long j3, TimeUnit timeUnit) {
        Throwable th5;
        requireNonNull(timeUnit);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Throwable[] thArr = new Throwable[1];
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.15
            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th6) {
                thArr[0] = th6;
                countDownLatch.countDown();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
            }
        });
        if (countDownLatch.getCount() == 0) {
            Throwable th6 = thArr[0];
            if (th6 != null) {
                Exceptions.propagate(th6);
            }
            return true;
        }
        try {
            boolean await = countDownLatch.await(j3, timeUnit);
            if (await && (th5 = thArr[0]) != null) {
                Exceptions.propagate(th5);
            }
            return await;
        } catch (InterruptedException e16) {
            throw Exceptions.propagate(e16);
        }
    }

    public static Completable concat(Observable<? extends Completable> observable) {
        return concat(observable, 2);
    }

    public static Completable merge(Observable<? extends Completable> observable) {
        return merge0(observable, Integer.MAX_VALUE, false);
    }

    public final <T> void unsafeSubscribe(Subscriber<T> subscriber) {
        unsafeSubscribe(subscriber, true);
    }

    public static Completable concat(Observable<? extends Completable> observable, int i3) {
        requireNonNull(observable);
        if (i3 >= 1) {
            return create(new CompletableOnSubscribeConcat(observable, i3));
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i3);
    }

    public static Completable merge(Observable<? extends Completable> observable, int i3) {
        return merge0(observable, i3, false);
    }

    private final <T> void unsafeSubscribe(final Subscriber<T> subscriber, boolean z16) {
        requireNonNull(subscriber);
        if (z16) {
            try {
                subscriber.onStart();
            } catch (NullPointerException e16) {
                throw e16;
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                Throwable onObservableError = RxJavaHooks.onObservableError(th5);
                RxJavaHooks.onError(onObservableError);
                throw toNpe(onObservableError);
            }
        }
        unsafeSubscribe(new CompletableSubscriber() { // from class: rx.Completable.28
            @Override // rx.Completable.CompletableSubscriber
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onError(Throwable th6) {
                subscriber.onError(th6);
            }

            @Override // rx.Completable.CompletableSubscriber
            public void onSubscribe(Subscription subscription) {
                subscriber.add(subscription);
            }
        });
        RxJavaHooks.onObservableReturn(subscriber);
    }

    public final void subscribe(CompletableSubscriber completableSubscriber) {
        if (!(completableSubscriber instanceof SafeCompletableSubscriber)) {
            completableSubscriber = new SafeCompletableSubscriber(completableSubscriber);
        }
        unsafeSubscribe(completableSubscriber);
    }

    public final <T> void subscribe(Subscriber<T> subscriber) {
        subscriber.onStart();
        if (!(subscriber instanceof SafeSubscriber)) {
            subscriber = new SafeSubscriber(subscriber);
        }
        unsafeSubscribe(subscriber, false);
    }
}
