package rx.internal.operators;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.FuncN;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SingleOperatorZip {
    SingleOperatorZip() {
        throw new IllegalStateException("No instances!");
    }

    public static <T, R> Single<R> zip(final Single<? extends T>[] singleArr, final FuncN<? extends R> funcN) {
        return Single.create(new Single.OnSubscribe<R>() { // from class: rx.internal.operators.SingleOperatorZip.1
            @Override // rx.functions.Action1
            public void call(final SingleSubscriber<? super R> singleSubscriber) {
                if (singleArr.length == 0) {
                    singleSubscriber.onError(new NoSuchElementException("Can't zip 0 Singles."));
                    return;
                }
                final AtomicInteger atomicInteger = new AtomicInteger(singleArr.length);
                final AtomicBoolean atomicBoolean = new AtomicBoolean();
                final Object[] objArr = new Object[singleArr.length];
                CompositeSubscription compositeSubscription = new CompositeSubscription();
                singleSubscriber.add(compositeSubscription);
                for (int i3 = 0; i3 < singleArr.length && !compositeSubscription.isUnsubscribed() && !atomicBoolean.get(); i3++) {
                    final int i16 = i3;
                    Subscription subscription = new SingleSubscriber<T>() { // from class: rx.internal.operators.SingleOperatorZip.1.1
                        @Override // rx.SingleSubscriber
                        public void onError(Throwable th5) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                singleSubscriber.onError(th5);
                            } else {
                                RxJavaHooks.onError(th5);
                            }
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // rx.SingleSubscriber
                        public void onSuccess(T t16) {
                            objArr[i16] = t16;
                            if (atomicInteger.decrementAndGet() == 0) {
                                try {
                                    singleSubscriber.onSuccess(funcN.call(objArr));
                                } catch (Throwable th5) {
                                    Exceptions.throwIfFatal(th5);
                                    onError(th5);
                                }
                            }
                        }
                    };
                    compositeSubscription.add(subscription);
                    if (compositeSubscription.isUnsubscribed() || atomicBoolean.get()) {
                        return;
                    }
                    singleArr[i3].subscribe((SingleSubscriber) subscription);
                }
            }
        });
    }
}
