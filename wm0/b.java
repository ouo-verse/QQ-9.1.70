package wm0;

import com.tencent.freesia.IConfigData;
import com.tencent.gdtad.config.data.e;
import com.tencent.gdtad.config.data.f;
import com.tencent.gdtad.config.data.g;
import com.tencent.gdtad.config.data.h;
import com.tencent.gdtad.config.data.i;
import com.tencent.gdtad.config.data.j;
import com.tencent.gdtad.config.data.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f445801a;

    b() {
    }

    private static <T extends IConfigData> T a(String str, boolean z16) {
        try {
            if (!v(str, z16)) {
                return null;
            }
            return (T) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(str);
        } catch (Throwable th5) {
            QLog.e("GdtConfigManager", 1, "[getConfig] groupId:" + str, th5);
            return null;
        }
    }

    public static b m() {
        if (f445801a == null) {
            synchronized (b.class) {
                if (f445801a == null) {
                    f445801a = new b();
                }
            }
        }
        return f445801a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v(String str, boolean z16) {
        try {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, z16);
        } catch (Throwable th5) {
            QLog.e("GdtConfigManager", 1, "[isSwitchOn] groupId:" + str, th5);
            return z16;
        }
    }

    public com.tencent.gdtad.config.data.a b() {
        return (com.tencent.gdtad.config.data.a) a("102518", false);
    }

    public com.tencent.gdtad.config.data.b c() {
        return (com.tencent.gdtad.config.data.b) a("105538", true);
    }

    public com.tencent.gdtad.config.data.c d() {
        return (com.tencent.gdtad.config.data.c) a("102436", false);
    }

    public com.tencent.gdtad.config.data.d e() {
        return (com.tencent.gdtad.config.data.d) a("102658", false);
    }

    public e f() {
        return (e) a("102454", false);
    }

    public f g() {
        return (f) a("103109", false);
    }

    public g h() {
        return (g) a("102670", true);
    }

    public h i() {
        return (h) a("102923", false);
    }

    public i j() {
        return (i) a("102399", false);
    }

    public j k() {
        return (j) a("102445", false);
    }

    public k l() {
        return null;
    }

    public boolean n() {
        return v("106194", true);
    }

    public boolean o() {
        return v("102651", true);
    }

    public boolean p() {
        return v("105858", true);
    }

    public boolean q() {
        return v("105962", true);
    }

    public boolean r() {
        return v("106184", true);
    }

    public boolean s() {
        return v("106185", true);
    }

    public boolean t() {
        return v("102518", false);
    }

    public boolean u() {
        return v("105989", false);
    }
}
