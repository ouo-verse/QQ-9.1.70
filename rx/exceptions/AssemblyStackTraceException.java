package rx.exceptions;

import rx.annotations.Experimental;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public final class AssemblyStackTraceException extends RuntimeException {
    private static final long serialVersionUID = 2038859767182585852L;

    public AssemblyStackTraceException(String str, Throwable th5) {
        super(str, th5);
    }

    @Override // java.lang.Throwable
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public AssemblyStackTraceException(String str) {
        super(str);
    }
}
