package rx.plugins;

import rx.annotations.Beta;
import rx.exceptions.Exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class RxJavaErrorHandler {
    protected static final String ERROR_IN_RENDERING_SUFFIX = ".errorRendering";

    @Beta
    public final String handleOnNextValueRendering(Object obj) {
        try {
            return render(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            return obj.getClass().getName() + ERROR_IN_RENDERING_SUFFIX;
        }
    }

    @Beta
    protected String render(Object obj) throws InterruptedException {
        return null;
    }

    @Deprecated
    public void handleError(Throwable th5) {
    }
}
