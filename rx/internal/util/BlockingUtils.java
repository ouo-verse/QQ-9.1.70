package rx.internal.util;

import java.util.concurrent.CountDownLatch;
import rx.Subscription;
import rx.annotations.Experimental;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public final class BlockingUtils {
    BlockingUtils() {
    }

    @Experimental
    public static void awaitForComplete(CountDownLatch countDownLatch, Subscription subscription) {
        if (countDownLatch.getCount() == 0) {
            return;
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e16) {
            subscription.unsubscribe();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting for subscription to complete.", e16);
        }
    }
}
