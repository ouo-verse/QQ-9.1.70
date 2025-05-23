package rx.exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OnErrorFailedException extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    public OnErrorFailedException(String str, Throwable th5) {
        super(str, th5 == null ? new NullPointerException() : th5);
    }

    public OnErrorFailedException(Throwable th5) {
        super(th5 != null ? th5.getMessage() : null, th5 == null ? new NullPointerException() : th5);
    }
}
