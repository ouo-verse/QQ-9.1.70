package retrofit2;

import android.os.Build;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.c;
import retrofit2.w;

/* compiled from: P */
/* loaded from: classes29.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    static final Executor f431361a;

    /* renamed from: b, reason: collision with root package name */
    static final w f431362b;

    /* renamed from: c, reason: collision with root package name */
    static final c f431363c;

    static {
        String property = System.getProperty("java.vm.name");
        property.hashCode();
        if (!property.equals("RoboVM")) {
            if (!property.equals("Dalvik")) {
                f431361a = null;
                f431362b = new w.b();
                f431363c = new c.a();
                return;
            }
            f431361a = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                f431362b = new w.a();
                f431363c = new c.a();
                return;
            } else {
                f431362b = new w();
                f431363c = new c();
                return;
            }
        }
        f431361a = null;
        f431362b = new w();
        f431363c = new c();
    }
}
