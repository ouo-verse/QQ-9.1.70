package rx.singles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Single;
import rx.SingleSubscriber;
import rx.annotations.Experimental;
import rx.exceptions.Exceptions;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.util.BlockingUtils;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public final class BlockingSingle<T> {
    private final Single<? extends T> single;

    BlockingSingle(Single<? extends T> single) {
        this.single = single;
    }

    @Experimental
    public static <T> BlockingSingle<T> from(Single<? extends T> single) {
        return new BlockingSingle<>(single);
    }

    @Experimental
    public Future<T> toFuture() {
        return BlockingOperatorToFuture.toFuture(this.single.toObservable());
    }

    @Experimental
    public T value() {
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        BlockingUtils.awaitForComplete(countDownLatch, this.single.subscribe((SingleSubscriber<? super Object>) new SingleSubscriber<T>() { // from class: rx.singles.BlockingSingle.1
            @Override // rx.SingleSubscriber
            public void onError(Throwable th5) {
                atomicReference2.set(th5);
                countDownLatch.countDown();
            }

            @Override // rx.SingleSubscriber
            public void onSuccess(T t16) {
                atomicReference.set(t16);
                countDownLatch.countDown();
            }
        }));
        Throwable th5 = (Throwable) atomicReference2.get();
        if (th5 == null) {
            return (T) atomicReference.get();
        }
        throw Exceptions.propagate(th5);
    }
}
