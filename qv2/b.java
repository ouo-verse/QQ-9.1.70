package qv2;

import android.app.Application;
import androidx.annotation.NonNull;
import qv2.c;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private static c f429686a = new c.a().s();

    public static Application a() {
        return f429686a.a();
    }

    @NonNull
    public static c b() {
        return f429686a;
    }

    public static String c() {
        return f429686a.d();
    }

    public static String d() {
        return f429686a.e();
    }

    public static boolean e() {
        return f429686a.f();
    }

    public static void f(c cVar) {
        if (cVar != null) {
            f429686a = cVar;
        }
        ov2.a.b().c(f429686a.b());
    }
}
