package vv;

import android.content.Context;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static volatile e f443587b;

    /* renamed from: a, reason: collision with root package name */
    private final a f443588a;

    e(VideoAppInterface videoAppInterface) {
        this.f443588a = new b(videoAppInterface);
    }

    private boolean a(Context context) {
        return d.b(context);
    }

    public static e b(VideoAppInterface videoAppInterface) {
        if (f443587b == null) {
            synchronized (e.class) {
                if (f443587b == null) {
                    f443587b = new e(videoAppInterface);
                }
            }
        }
        return f443587b;
    }

    public void c(Context context, SessionInfo sessionInfo) {
        if (a(context)) {
            this.f443588a.c(sessionInfo);
        }
    }

    public void d(Context context, SessionInfo sessionInfo) {
        if (a(context)) {
            this.f443588a.d(sessionInfo);
        }
    }

    public void e(Context context, SessionInfo sessionInfo) {
        if (a(context)) {
            this.f443588a.b(sessionInfo);
        }
    }

    public void f(SessionInfo sessionInfo) {
        this.f443588a.e(sessionInfo);
    }

    public void g(SessionInfo sessionInfo) {
        this.f443588a.a(sessionInfo);
    }

    public void h(SessionInfo sessionInfo) {
        this.f443588a.f(sessionInfo);
    }
}
