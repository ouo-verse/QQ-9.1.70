package rx;

import rx.annotations.Experimental;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public interface AsyncEmitter<T> extends Observer<T> {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum BackpressureMode {
        NONE,
        ERROR,
        BUFFER,
        DROP,
        LATEST
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Cancellable {
        void cancel() throws Exception;
    }

    long requested();

    void setCancellation(Cancellable cancellable);

    void setSubscription(Subscription subscription);
}
