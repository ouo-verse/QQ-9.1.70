package rx;

import rx.annotations.Experimental;
import rx.exceptions.MissingBackpressureException;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public final class BackpressureOverflow {
    public static final Strategy ON_OVERFLOW_DEFAULT;
    public static final Strategy ON_OVERFLOW_DROP_LATEST;
    public static final Strategy ON_OVERFLOW_DROP_OLDEST;
    public static final Strategy ON_OVERFLOW_ERROR;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class DropLatest implements Strategy {
        static final DropLatest INSTANCE = new DropLatest();

        DropLatest() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class DropOldest implements Strategy {
        static final DropOldest INSTANCE = new DropOldest();

        DropOldest() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() {
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class Error implements Strategy {
        static final Error INSTANCE = new Error();

        Error() {
        }

        @Override // rx.BackpressureOverflow.Strategy
        public boolean mayAttemptDrop() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface Strategy {
        boolean mayAttemptDrop() throws MissingBackpressureException;
    }

    static {
        Error error = Error.INSTANCE;
        ON_OVERFLOW_ERROR = error;
        ON_OVERFLOW_DEFAULT = error;
        ON_OVERFLOW_DROP_OLDEST = DropOldest.INSTANCE;
        ON_OVERFLOW_DROP_LATEST = DropLatest.INSTANCE;
    }
}
