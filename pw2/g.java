package pw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    public static void a(Runnable runnable) {
        QAdThreadManager.INSTANCE.postOnUiThread(runnable);
    }

    public static void b(Runnable runnable, long j3) {
        if (runnable != null) {
            QAdThreadManager.INSTANCE.execOnUiThreadDelay(runnable, j3);
        }
    }

    public static void c(Runnable runnable) {
        QAdThreadManager.INSTANCE.removeCallBackOnUiThread(runnable);
    }
}
