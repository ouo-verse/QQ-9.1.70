package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action0;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeTimeout implements Completable.CompletableOnSubscribe {
    final Completable other;
    final Scheduler scheduler;
    final Completable source;
    final long timeout;
    final TimeUnit unit;

    public CompletableOnSubscribeTimeout(Completable completable, long j3, TimeUnit timeUnit, Scheduler scheduler, Completable completable2) {
        this.source = completable;
        this.timeout = j3;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.other = completable2;
    }

    @Override // rx.functions.Action1
    public void call(final Completable.CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        Scheduler.Worker createWorker = this.scheduler.createWorker();
        compositeSubscription.add(createWorker);
        createWorker.schedule(new Action0() { // from class: rx.internal.operators.CompletableOnSubscribeTimeout.1
            @Override // rx.functions.Action0
            public void call() {
                if (atomicBoolean.compareAndSet(false, true)) {
                    compositeSubscription.clear();
                    Completable completable = CompletableOnSubscribeTimeout.this.other;
                    if (completable == null) {
                        completableSubscriber.onError(new TimeoutException());
                    } else {
                        completable.unsafeSubscribe(new Completable.CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeTimeout.1.1
                            @Override // rx.Completable.CompletableSubscriber
                            public void onCompleted() {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onCompleted();
                            }

                            @Override // rx.Completable.CompletableSubscriber
                            public void onError(Throwable th5) {
                                compositeSubscription.unsubscribe();
                                completableSubscriber.onError(th5);
                            }

                            @Override // rx.Completable.CompletableSubscriber
                            public void onSubscribe(Subscription subscription) {
                                compositeSubscription.add(subscription);
                            }
                        });
                    }
                }
            }
        }, this.timeout, this.unit);
        this.source.unsafeSubscribe(new Completable.CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeTimeout.2
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
        });
    }
}
