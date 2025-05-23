package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeMergeDelayErrorArray implements Completable.CompletableOnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeDelayErrorArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    @Override // rx.functions.Action1
    public void call(final Completable.CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        final AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        completableSubscriber.onSubscribe(compositeSubscription);
        for (Completable completable : this.sources) {
            if (compositeSubscription.isUnsubscribed()) {
                return;
            }
            if (completable == null) {
                concurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
                atomicInteger.decrementAndGet();
            } else {
                completable.unsafeSubscribe(new Completable.CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray.1
                    @Override // rx.Completable.CompletableSubscriber
                    public void onCompleted() {
                        tryTerminate();
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onError(Throwable th5) {
                        concurrentLinkedQueue.offer(th5);
                        tryTerminate();
                    }

                    @Override // rx.Completable.CompletableSubscriber
                    public void onSubscribe(Subscription subscription) {
                        compositeSubscription.add(subscription);
                    }

                    void tryTerminate() {
                        if (atomicInteger.decrementAndGet() == 0) {
                            if (concurrentLinkedQueue.isEmpty()) {
                                completableSubscriber.onCompleted();
                            } else {
                                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(concurrentLinkedQueue));
                            }
                        }
                    }
                });
            }
        }
        if (atomicInteger.decrementAndGet() == 0) {
            if (concurrentLinkedQueue.isEmpty()) {
                completableSubscriber.onCompleted();
            } else {
                completableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(concurrentLinkedQueue));
            }
        }
    }
}
