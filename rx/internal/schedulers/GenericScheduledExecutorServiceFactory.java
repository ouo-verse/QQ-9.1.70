package rx.internal.schedulers;

import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.functions.Func0;
import rx.internal.util.RxThreadFactory;
import rx.plugins.RxJavaHooks;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public enum GenericScheduledExecutorServiceFactory {
    ;

    static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
    static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);

    public static ScheduledExecutorService create() {
        Func0<? extends ScheduledExecutorService> onGenericScheduledExecutorService = RxJavaHooks.getOnGenericScheduledExecutorService();
        if (onGenericScheduledExecutorService == null) {
            return createDefault();
        }
        return onGenericScheduledExecutorService.call();
    }

    static ScheduledExecutorService createDefault() {
        return ProxyExecutors.newScheduledThreadPool(1, threadFactory());
    }

    static ThreadFactory threadFactory() {
        return THREAD_FACTORY;
    }
}
