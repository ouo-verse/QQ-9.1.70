package ud0;

import android.os.HandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import td0.k;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static k f438816a;

    private static k a() {
        if (f438816a == null) {
            synchronized (b.class) {
                if (f438816a == null) {
                    f438816a = (k) c.a(k.class);
                }
            }
        }
        return f438816a;
    }

    public static HandlerThread b(String str, int i3) {
        if (a() != null) {
            return a().a(str, i3);
        }
        return new BaseHandlerThread(str, i3);
    }
}
