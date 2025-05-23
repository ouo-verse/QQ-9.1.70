package qe2;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\rJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000f\u00a8\u0006\u0013"}, d2 = {"Lqe2/a;", "", "", "toggleName", "", "g", "Lmqq/app/AppRuntime;", "a", RemoteHandleConst.PARAM_DEFAULT_VALUE, "f", "", "d", "b", "Lorg/json/JSONObject;", "e", "", "c", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f428882a = new a();

    a() {
    }

    private final AppRuntime a() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            return application.getRuntime();
        }
        return null;
    }

    private final boolean g(String toggleName) {
        AppRuntime a16 = a();
        IFeatureRuntimeService iFeatureRuntimeService = a16 != null ? (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all") : null;
        if (iFeatureRuntimeService != null) {
            return iFeatureRuntimeService.isFeatureSwitchEnable(toggleName);
        }
        return false;
    }

    public final boolean b(String toggleName, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        if (!g(toggleName)) {
            QLog.e("ECFeatureConfig", 1, "[getFeatureBoolean] isSwitchEnable = " + g(toggleName));
            return defaultValue;
        }
        AppRuntime a16 = a();
        IFeatureRuntimeService iFeatureRuntimeService = a16 != null ? (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all") : null;
        return iFeatureRuntimeService != null ? iFeatureRuntimeService.isFeatureSwitchEnable(toggleName, defaultValue) : defaultValue;
    }

    public final Map<String, String> c(String toggleName, Map<?, ?> defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<?, ?> entry : defaultValue.entrySet()) {
            linkedHashMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
        if (!g(toggleName)) {
            QLog.e("ECFeatureConfig", 1, "[getFeatureDataSet] isSwitchEnable = " + g(toggleName));
            return linkedHashMap;
        }
        AppRuntime a16 = a();
        IFeatureRuntimeService iFeatureRuntimeService = a16 != null ? (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all") : null;
        Map<String, String> isEnabledWithDataSet = iFeatureRuntimeService != null ? iFeatureRuntimeService.isEnabledWithDataSet(toggleName, "") : null;
        return isEnabledWithDataSet == null ? linkedHashMap : isEnabledWithDataSet;
    }

    public final int d(String toggleName, int defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        if (!g(toggleName)) {
            QLog.e("ECFeatureConfig", 1, "[getFeatureInt] isSwitchEnable = " + g(toggleName));
            return defaultValue;
        }
        AppRuntime a16 = a();
        IFeatureRuntimeService iFeatureRuntimeService = a16 != null ? (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all") : null;
        return iFeatureRuntimeService != null ? iFeatureRuntimeService.getInt(toggleName, defaultValue) : defaultValue;
    }

    public final JSONObject e(String toggleName, JSONObject defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (!g(toggleName)) {
            QLog.e("ECFeatureConfig", 1, "[getFeatureJSONObject] isSwitchEnable = " + g(toggleName));
            return defaultValue;
        }
        AppRuntime a16 = a();
        IFeatureRuntimeService iFeatureRuntimeService = a16 != null ? (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all") : null;
        JSONObject jSONObject = iFeatureRuntimeService != null ? iFeatureRuntimeService.getJSONObject(toggleName, defaultValue.toString()) : null;
        return jSONObject == null ? defaultValue : jSONObject;
    }

    public final String f(String toggleName, String defaultValue) {
        Intrinsics.checkNotNullParameter(toggleName, "toggleName");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        if (!g(toggleName)) {
            QLog.e("ECFeatureConfig", 1, "[getFeatureString] isSwitchEnable = " + g(toggleName));
            return defaultValue;
        }
        AppRuntime a16 = a();
        IFeatureRuntimeService iFeatureRuntimeService = a16 != null ? (IFeatureRuntimeService) a16.getRuntimeService(IFeatureRuntimeService.class, "all") : null;
        String string = iFeatureRuntimeService != null ? iFeatureRuntimeService.getString(toggleName, defaultValue) : null;
        return string == null ? defaultValue : string;
    }
}
