package sb1;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lsb1/a;", "", "", "d", "", VipFunCallConstants.KEY_GROUP, "Lsb1/b;", "a", "", AdMetricTag.FALLBACK, "c", "Lorg/json/JSONObject;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "mConfigCache", "Ljava/lang/String;", "mCurrentUin", "<init>", "()V", "qqfile-selector-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f433609a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, b> mConfigCache = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mCurrentUin = "";

    a() {
    }

    private final b a(String group) {
        d();
        ConcurrentHashMap<String, b> concurrentHashMap = mConfigCache;
        b bVar = concurrentHashMap.get(group);
        if (bVar == null) {
            b bVar2 = new b();
            concurrentHashMap.put(group, bVar2);
            return bVar2;
        }
        return bVar;
    }

    private final void d() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(mCurrentUin, str)) {
            QLog.d("FileConfigCacheManager", 1, "reset cache uin " + mCurrentUin + " -> " + str);
            mConfigCache.clear();
            mCurrentUin = str;
        }
    }

    @Nullable
    public final JSONObject b(@NotNull String group, @NotNull String fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        b a16 = a(group);
        JSONObject configJson = a16.getConfigJson();
        if (configJson == null) {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(group, fallback);
            try {
                a16.c(new JSONObject(loadAsString));
                QLog.d("FileConfigCacheManager", 1, mCurrentUin + " is " + group + " json: " + loadAsString);
            } catch (JSONException e16) {
                QLog.e("FileConfigCacheManager", 1, "parse json failed!", e16);
            }
            return a16.getConfigJson();
        }
        return configJson;
    }

    public final boolean c(@NotNull String group, boolean fallback) {
        Intrinsics.checkNotNullParameter(group, "group");
        b a16 = a(group);
        Boolean switchValue = a16.getSwitchValue();
        if (switchValue == null) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(group, fallback);
            a16.d(Boolean.valueOf(isSwitchOn));
            QLog.d("FileConfigCacheManager", 1, mCurrentUin + " is " + group + " switch on: " + isSwitchOn);
            return isSwitchOn;
        }
        return switchValue.booleanValue();
    }
}
