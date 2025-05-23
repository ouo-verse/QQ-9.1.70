package rx.exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnCompletedFailedException extends RuntimeException {
    private static final long serialVersionUID = 8622579378868820554L;

    public OnCompletedFailedException(Throwable th5) {
        super(th5 == null ? new NullPointerException() : th5);
    }

    public OnCompletedFailedException(String str, Throwable th5) {
        super(str, th5 == null ? new NullPointerException() : th5);
    }
}
