package rx.exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OnErrorNotImplementedException extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String str, Throwable th5) {
        super(str, th5 == null ? new NullPointerException() : th5);
    }

    public OnErrorNotImplementedException(Throwable th5) {
        super(th5 != null ? th5.getMessage() : null, th5 == null ? new NullPointerException() : th5);
    }
}
