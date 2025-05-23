package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BlockingOperatorToFuture {
    BlockingOperatorToFuture() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> toFuture(Observable<? extends T> observable) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicReference atomicReference2 = new AtomicReference();
        final Subscription subscribe = observable.single().subscribe((Subscriber<? super Object>) new Subscriber<T>() { // from class: rx.internal.operators.BlockingOperatorToFuture.1
            @Override // rx.Observer
            public void onCompleted() {
                countDownLatch.countDown();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                c.a(atomicReference2, null, th5);
                countDownLatch.countDown();
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                atomicReference.set(t16);
            }
        });
        return new Future<T>() { // from class: rx.internal.operators.BlockingOperatorToFuture.2
            private volatile boolean cancelled;

            private T getValue() throws ExecutionException {
                Throwable th5 = (Throwable) atomicReference2.get();
                if (th5 == null) {
                    if (!this.cancelled) {
                        return (T) atomicReference.get();
                    }
                    throw new CancellationException("Subscription unsubscribed");
                }
                throw new ExecutionException("Observable onError", th5);
            }

            @Override // java.util.concurrent.Future
            public boolean cancel(boolean z16) {
                if (countDownLatch.getCount() > 0) {
                    this.cancelled = true;
                    subscribe.unsubscribe();
                    countDownLatch.countDown();
                    return true;
                }
                return false;
            }

            @Override // java.util.concurrent.Future
            public T get() throws InterruptedException, ExecutionException {
                countDownLatch.await();
                return getValue();
            }

            @Override // java.util.concurrent.Future
            public boolean isCancelled() {
                return this.cancelled;
            }

            @Override // java.util.concurrent.Future
            public boolean isDone() {
                if (countDownLatch.getCount() == 0) {
                    return true;
                }
                return false;
            }

            @Override // java.util.concurrent.Future
            public T get(long j3, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
                if (countDownLatch.await(j3, timeUnit)) {
                    return getValue();
                }
                throw new TimeoutException("Timed out after " + timeUnit.toMillis(j3) + "ms waiting for underlying Observable.");
            }
        };
    }
}
