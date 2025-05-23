package w53;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.core.render.log.ILogProxy;
import com.tencent.tavcut.core.render.log.TavLogger;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ILogProxy f444617a = new C11462a();

    /* compiled from: P */
    /* renamed from: w53.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    class C11462a implements ILogProxy {
        C11462a() {
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void d(@Nullable String str, @Nullable String str2) {
            a.a(str, str2);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void e(@Nullable String str, @Nullable String str2) {
            a.b(str, str2);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void i(@Nullable String str, @Nullable String str2) {
            a.b(str, str2);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void v(@Nullable String str, @Nullable String str2) {
            a.a(str, str2);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void w(@Nullable String str, @Nullable String str2) {
            a.b(str, str2);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void e(@Nullable String str, @Nullable String str2, @Nullable Throwable th5) {
            a.c(str, str2, th5);
        }
    }

    public static void a(@NonNull String str, @NonNull String str2) {
        QLog.d("MODULE_GY_TAVCUT :" + str, 4, str2);
    }

    public static void b(@NonNull String str, @NonNull String str2) {
        QLog.e("MODULE_GY_TAVCUT :" + str, 1, str2);
    }

    public static void c(@NonNull String str, @NonNull String str2, @android.support.annotation.Nullable Throwable th5) {
        QLog.e("MODULE_GY_TAVCUT :" + str, 1, str2, th5);
    }

    public static boolean d() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_wink_tavcut_print_all_log", false);
    }

    public static void e(int i3) {
        f(i3);
        if (d()) {
            f(2);
        }
        TavLogger.setProxy(f444617a);
    }

    public static void f(int i3) {
        b.a("MODULE_GY_TAVCUT :", "setTavCutLogLevel level:" + i3);
        TavLogger.setLevel(i3);
    }
}
