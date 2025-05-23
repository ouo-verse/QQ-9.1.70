package rx.exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class UnsubscribeFailedException extends RuntimeException {
    private static final long serialVersionUID = 4594672310593167598L;

    public UnsubscribeFailedException(Throwable th5) {
        super(th5 == null ? new NullPointerException() : th5);
    }

    public UnsubscribeFailedException(String str, Throwable th5) {
        super(str, th5 == null ? new NullPointerException() : th5);
    }
}
