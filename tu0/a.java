package tu0;

import android.app.Application;
import com.tencent.icgame.game.utils.g;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Application f437474a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f437475b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f437476c = false;

    /* renamed from: d, reason: collision with root package name */
    private static volatile AtomicBoolean f437477d;

    a() {
    }

    public static void a(Application application) {
        g.h("ICGameENV", "attachContext - " + application);
        f437474a = application;
    }

    public static Application b() {
        return BaseApplication.getContext();
    }

    public static boolean c() {
        boolean z16;
        if (f437477d == null) {
            synchronized (a.class) {
                if (f437477d == null && f437474a != null) {
                    if (f437474a.getApplicationInfo() != null && (f437474a.getApplicationInfo().flags & 2) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    f437477d = new AtomicBoolean(z16);
                }
            }
        }
        if (f437477d != null && f437477d.get()) {
            return true;
        }
        return false;
    }

    private static boolean d() {
        if (f437475b == null) {
            synchronized (a.class) {
                if (f437475b == null) {
                    String str = "";
                    InputStream inputStream = null;
                    try {
                        inputStream = b().getResources().getAssets().open("enable_debug_for_release.txt");
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        inputStream.close();
                        str = properties.getProperty("ENABLE_DEBUG_FOR_RELEASE", "");
                    } catch (Exception e16) {
                        g.h("ICGameENV", e16.getMessage());
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e17) {
                            g.e("ICGameENV", "isEnableDebugModeInRelease close stream error", e17);
                        }
                    }
                    f437475b = str;
                    f437476c = "true".equals(str);
                }
            }
        }
        return f437476c;
    }

    public static boolean e() {
        if (!c() && !d()) {
            return false;
        }
        return true;
    }
}
