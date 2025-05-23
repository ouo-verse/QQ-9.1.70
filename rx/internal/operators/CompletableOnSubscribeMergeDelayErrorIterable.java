package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Subscription;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeMergeDelayErrorIterable implements Completable.CompletableOnSubscribe {
    final Iterable<? extends Completable> sources;

    public CompletableOnSubscribeMergeDelayErrorIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    @Override // rx.functions.Action1
    public void call(final Completable.CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        completableSubscriber.onSubscribe(compositeSubscription);
        try {
            Iterator<? extends Completable> it = this.sources.iterator();
            if (it == null) {
                completableSubscriber.onError(new NullPointerException("The source iterator returned is null"));
                return;
            }
            final AtomicInteger atomicInteger = new AtomicInteger(1);
            final MpscLinkedQueue mpscLinkedQueue = new MpscLinkedQueue();
            while (!compositeSubscription.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (mpscLinkedQueue.isEmpty()) {
                                completableSubscriber.onCompleted();
                                return;
                            } else {
                                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedQueue));
                                return;
                            }
                        }
                        return;
                    }
                    if (compositeSubscription.isUnsubscribed()) {
                        return;
                    }
                    try {
                        Completable next = it.next();
                        if (compositeSubscription.isUnsubscribed()) {
                            return;
                        }
                        if (next == null) {
                            mpscLinkedQueue.offer(new NullPointerException("A completable source is null"));
                            if (atomicInteger.decrementAndGet() == 0) {
                                if (mpscLinkedQueue.isEmpty()) {
                                    completableSubscriber.onCompleted();
                                    return;
                                } else {
                                    completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedQueue));
                                    return;
                                }
                            }
                            return;
                        }
                        atomicInteger.getAndIncrement();
                        next.unsafeSubscribe(new Completable.CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable.1
                            @Override // rx.Completable.CompletableSubscriber
                            public void onCompleted() {
                                tryTerminate();
                            }

                            @Override // rx.Completable.CompletableSubscriber
                            public void onError(Throwable th5) {
                                mpscLinkedQueue.offer(th5);
                                tryTerminate();
                            }

                            @Override // rx.Completable.CompletableSubscriber
                            public void onSubscribe(Subscription subscription) {
                                compositeSubscription.add(subscription);
                            }

                            void tryTerminate() {
                                if (atomicInteger.decrementAndGet() == 0) {
                                    if (mpscLinkedQueue.isEmpty()) {
                                        completableSubscriber.onCompleted();
                                    } else {
                                        completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedQueue));
                                    }
                                }
                            }
                        });
                    } catch (Throwable th5) {
                        mpscLinkedQueue.offer(th5);
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (mpscLinkedQueue.isEmpty()) {
                                completableSubscriber.onCompleted();
                                return;
                            } else {
                                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedQueue));
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th6) {
                    mpscLinkedQueue.offer(th6);
                    if (atomicInteger.decrementAndGet() == 0) {
                        if (mpscLinkedQueue.isEmpty()) {
                            completableSubscriber.onCompleted();
                            return;
                        } else {
                            completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(mpscLinkedQueue));
                            return;
                        }
                    }
                    return;
                }
            }
        } catch (Throwable th7) {
            completableSubscriber.onError(th7);
        }
    }
}
