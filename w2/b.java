package w2;

import android.os.Handler;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f444423a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f444424b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f444425c;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f444423a = availableProcessors;
        f444424b = availableProcessors + 1;
        f444425c = (availableProcessors * 2) + 1;
    }

    public static Executor a() {
        return new Executor() { // from class: w2.a
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                new Handler(Looper.getMainLooper()).post(runnable);
            }
        };
    }

    public static ExecutorService c() {
        BaseThreadPoolExecutor baseThreadPoolExecutor = new BaseThreadPoolExecutor(f444424b, f444425c, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        baseThreadPoolExecutor.allowCoreThreadTimeOut(true);
        return baseThreadPoolExecutor;
    }
}
