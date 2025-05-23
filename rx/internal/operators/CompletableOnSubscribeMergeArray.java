package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Subscription;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeMergeArray implements Completable.CompletableOnSubscribe {
    final Completable[] sources;

    public CompletableOnSubscribeMergeArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    @Override // rx.functions.Action1
    public void call(final Completable.CompletableSubscriber completableSubscriber) {
        final CompositeSubscription compositeSubscription = new CompositeSubscription();
        boolean z16 = true;
        final AtomicInteger atomicInteger = new AtomicInteger(this.sources.length + 1);
        final AtomicBoolean atomicBoolean = new AtomicBoolean();
        completableSubscriber.onSubscribe(compositeSubscription);
        Completable[] completableArr = this.sources;
        int length = completableArr.length;
        boolean z17 = false;
        int i3 = 0;
        while (i3 < length) {
            Completable completable = completableArr[i3];
            if (compositeSubscription.isUnsubscribed()) {
                return;
            }
            if (completable == null) {
                compositeSubscription.unsubscribe();
                Throwable nullPointerException = new NullPointerException("A completable source is null");
                if (atomicBoolean.compareAndSet(z17, z16)) {
                    completableSubscriber.onError(nullPointerException);
                    return;
                }
                RxJavaHooks.onError(nullPointerException);
            }
            completable.unsafeSubscribe(new Completable.CompletableSubscriber() { // from class: rx.internal.operators.CompletableOnSubscribeMergeArray.1
                @Override // rx.Completable.CompletableSubscriber
                public void onCompleted() {
                    if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
                        completableSubscriber.onCompleted();
                    }
                }

                @Override // rx.Completable.CompletableSubscriber
                public void onError(Throwable th5) {
                    compositeSubscription.unsubscribe();
                    if (atomicBoolean.compareAndSet(false, true)) {
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
            i3++;
            z16 = true;
            z17 = false;
        }
        if (atomicInteger.decrementAndGet() == 0 && atomicBoolean.compareAndSet(false, true)) {
            completableSubscriber.onCompleted();
        }
    }
}
