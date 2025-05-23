package zo;

import android.content.Context;
import com.qzone.video.TVK_SDK.mediaplayer.config.TencentVideo;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f452846a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f452847b = false;

    public static int a() {
        return com.qzone.video.TVK_SDK.mediaplayer.utils.e.j();
    }

    public static synchronized void b(Context context, String str, String str2) {
        synchronized (c.class) {
            if (f452846a) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            f452846a = true;
            TencentVideo.c(context, str2);
            com.qzone.video.TVK_SDK.mediaplayer.utils.b.c("SDKMgr", 0, 40, "MediaPlayerMgr", "Init SDK all times: " + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
        }
    }

    public static boolean c() {
        return f452847b;
    }
}
