package yt3;

import androidx.annotation.NonNull;
import com.tencent.qqlive.superplayer.tools.utils.ITVKHttpProcessor;
import com.tencent.qqlive.superplayer.tools.utils.i;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static d f451198d;

    /* renamed from: a, reason: collision with root package name */
    private int f451199a;

    /* renamed from: b, reason: collision with root package name */
    private int f451200b;

    /* renamed from: c, reason: collision with root package name */
    private int f451201c;

    d() {
        this.f451199a = 0;
        this.f451200b = 0;
        this.f451201c = 0;
        int b16 = a.c().b();
        this.f451199a = b16;
        this.f451200b = b16 + 2000;
        this.f451201c = 0;
    }

    public static synchronized d c() {
        d dVar;
        synchronized (d.class) {
            if (f451198d == null) {
                f451198d = new d();
            }
            dVar = f451198d;
        }
        return dVar;
    }

    public void a(int i3, String str, Map<String, String> map, Map<String, String> map2, ITVKHttpProcessor.b bVar) {
        b(i3, str, map, map2, new byte[0], bVar);
    }

    public void b(int i3, String str, Map<String, String> map, Map<String, String> map2, @NonNull byte[] bArr, ITVKHttpProcessor.b bVar) {
        String c16 = new i().d(str).b(map).c();
        com.tencent.qqlive.superplayer.tools.utils.d.d("MediaPlayerMgr[TVKVideoInfoHttpProcessor.java]", "http request, url:" + c16);
        com.tencent.qqlive.superplayer.tools.utils.c.a().a(c16, map2, bArr, this.f451200b * i3, bVar);
    }
}
