package rx.internal.util;

import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class RxThreadFactory extends AtomicLong implements ThreadFactory {
    public static final ThreadFactory NONE = new ThreadFactory() { // from class: rx.internal.util.RxThreadFactory.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    };
    private static final long serialVersionUID = -8841098858898482335L;
    final String prefix;

    public RxThreadFactory(String str) {
        this.prefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        BaseThread baseThread = new BaseThread(runnable, this.prefix + incrementAndGet());
        baseThread.setDaemon(true);
        return baseThread;
    }
}
