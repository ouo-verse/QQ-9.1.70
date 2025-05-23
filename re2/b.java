package re2;

import com.tencent.mobileqq.qqecommerce.base.config.united.ECUnitedConfigParser;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nJ\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\fJ\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u000eJ\u001e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\u0013"}, d2 = {"Lre2/b;", "", "", "configId", "Lcom/tencent/mobileqq/qqecommerce/base/config/united/ECUnitedConfigParser$b;", "f", "key", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "d", "", "b", "", "c", "", "a", "e", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f431163a = new b();

    b() {
    }

    private final ECUnitedConfigParser.b f(String configId) {
        ECUnitedConfigParser.b bVar = (ECUnitedConfigParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(configId);
        return bVar == null ? new ECUnitedConfigParser.b() : bVar;
    }

    public final boolean a(String configId, String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        ECUnitedConfigParser.b f16 = f(configId);
        try {
            String str = f16.a().get(key);
            return str != null ? Boolean.parseBoolean(str) : defaultValue;
        } catch (Exception unused) {
            QLog.e("ECUnitedConfig", 1, "[getBoolean] key = " + key + " config = " + ((Object) f16.a().get(key)));
            return defaultValue;
        }
    }

    public final float b(String configId, String key, float defaultValue) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        ECUnitedConfigParser.b f16 = f(configId);
        try {
            String str = f16.a().get(key);
            return str != null ? Float.parseFloat(str) : defaultValue;
        } catch (Exception unused) {
            QLog.e("ECUnitedConfig", 1, "[getFloat] key = " + key + " config = " + ((Object) f16.a().get(key)));
            return defaultValue;
        }
    }

    public final int c(String configId, String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        ECUnitedConfigParser.b f16 = f(configId);
        try {
            String str = f16.a().get(key);
            return str != null ? Integer.parseInt(str) : defaultValue;
        } catch (Exception unused) {
            QLog.e("ECUnitedConfig", 1, "[getInt] key = " + key + " config = " + ((Object) f16.a().get(key)));
            return defaultValue;
        }
    }

    public final long d(String configId, String key, long defaultValue) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        ECUnitedConfigParser.b f16 = f(configId);
        try {
            String str = f16.a().get(key);
            return str != null ? Long.parseLong(str) : defaultValue;
        } catch (Exception unused) {
            QLog.e("ECUnitedConfig", 1, "[getLong] key = " + key + " config = " + ((Object) f16.a().get(key)));
            return defaultValue;
        }
    }

    public final String e(String configId, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(configId, "configId");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        ECUnitedConfigParser.b f16 = f(configId);
        try {
            String str = f16.a().get(key);
            return str == null ? defaultValue : str;
        } catch (Exception unused) {
            QLog.e("ECUnitedConfig", 1, "[getString] key = " + key + " config = " + ((Object) f16.a().get(key)));
            return defaultValue;
        }
    }
}
