package pw2;

import android.text.TextUtils;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h implements ThreadFactory {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicInteger f427751h = new AtomicInteger(1);

    /* renamed from: d, reason: collision with root package name */
    private final ThreadGroup f427752d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicInteger f427753e = new AtomicInteger(1);

    /* renamed from: f, reason: collision with root package name */
    private final String f427754f;

    public h(String str) {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f427752d = threadGroup;
        this.f427754f = (TextUtils.isEmpty(str) ? "QAdPool" : str) + "-" + f427751h.getAndIncrement() + "-thread-";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        BaseThread baseThread = new BaseThread(this.f427752d, runnable, this.f427754f + this.f427753e.getAndIncrement(), 0L);
        if (baseThread.isDaemon()) {
            baseThread.setDaemon(false);
        }
        if (baseThread.getPriority() != 5) {
            baseThread.setPriority(5);
        }
        return baseThread;
    }
}
