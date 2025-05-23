package xe;

import android.util.Log;
import com.qzone.report.QZonePerfReporter;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import common.config.service.QZoneConfigHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tl.h;
import u5.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J'\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lxe/b;", "", "", "curCrashCount", "", "firstCrashTime", "", "e", "f", "", "orgKey", "g", "crashStack", "", "keywords", "a", "(Ljava/lang/String;[Ljava/lang/String;)Z", "", "b", h.F, "key", "i", "c", "", "t", "d", "", "Ljava/util/Map;", "mFlagCache", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f447841a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Boolean> mFlagCache = new LinkedHashMap();

    b() {
    }

    private final boolean f(int curCrashCount) {
        if (curCrashCount >= 5) {
            return true;
        }
        return false;
    }

    private final String g(String orgKey) {
        return orgKey + ((IAppSettingApi) QRoute.api(IAppSettingApi.class)).getReportVersionName();
    }

    public final void b(String crashStack) {
        Intrinsics.checkNotNullParameter(crashStack, "crashStack");
        if (QZoneConfigHelper.J0()) {
            boolean a16 = a(crashStack, new String[]{"com.qzone."});
            Log.d("QZoneCrashProtector", "checkExceptionWhetherCauseByFeedx: " + a16);
            if (a16) {
                String g16 = g("KEY_CRASH_COUNT_FEEDX");
                String g17 = g("KEY_CRASH_TIME_FEEDX");
                int h16 = c.h(g16, 0);
                if (h16 == 0) {
                    c.G(g17, System.currentTimeMillis());
                }
                int i3 = h16 + 1;
                c.D(g16, i3);
                long k3 = c.k(g17, 0L);
                Log.d("QZoneCrashProtector", "qq crash by feedx " + i3 + " times, first crash time: " + k3 + ", " + g16);
                if (f(i3) || e(i3, k3)) {
                    c("KEY_CRASH_PROTECT_FEEDX");
                }
            }
        }
    }

    public final void c(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        c.B(g(key), true);
        mFlagCache.put(key, Boolean.TRUE);
    }

    public final void d(Throwable t16) {
        Intrinsics.checkNotNullParameter(t16, "t");
        QZonePerfReporter.f59697a.m(t16);
        RFWLog.e("QZoneCrashProtector", RFWLog.USR, t16);
    }

    public final boolean h() {
        return i("KEY_CRASH_PROTECT_FEEDX");
    }

    public final boolean i(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!QZoneConfigHelper.J0()) {
            return false;
        }
        Map<String, Boolean> map = mFlagCache;
        if (!map.containsKey(key)) {
            map.put(key, Boolean.valueOf(c.f(g(key), false)));
        }
        Boolean bool = map.get(key);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean a(String crashStack, String[] keywords) {
        boolean contains$default;
        if (crashStack != null && QZoneConfigHelper.J0()) {
            for (String str : keywords) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) crashStack, (CharSequence) str, false, 2, (Object) null);
                if (contains$default) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean e(int curCrashCount, long firstCrashTime) {
        return curCrashCount >= 3 && firstCrashTime > 0 && System.currentTimeMillis() - firstCrashTime < 86400000;
    }
}
