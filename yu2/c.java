package yu2;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    protected static String f451246a = "QAdAbsMessageThread";

    /* renamed from: b, reason: collision with root package name */
    protected static String f451247b = "base";

    /* renamed from: c, reason: collision with root package name */
    private static volatile HandlerThread f451248c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile Handler f451249d;

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        e();
    }

    private void a() {
        b();
        if (f451249d != null) {
            return;
        }
        synchronized (c.class) {
            if (f451249d == null) {
                f451249d = new Handler(f451248c.getLooper());
            }
        }
    }

    private void b() {
        if (f451248c != null) {
            return;
        }
        synchronized (c.class) {
            if (f451248c == null) {
                f451248c = new BaseHandlerThread(f451247b + "-Handler-Thread");
                f451248c.start();
            }
        }
    }

    public void c(Runnable runnable) {
        try {
            a();
            f451249d.post(runnable);
        } catch (Throwable th5) {
            n.b(f451246a, Log.getStackTraceString(th5));
        }
    }

    public void d(Runnable runnable, long j3) {
        try {
            a();
            f451249d.postDelayed(runnable, j3);
        } catch (Throwable th5) {
            n.b(f451246a, Log.getStackTraceString(th5));
        }
    }

    protected abstract void e();
}
