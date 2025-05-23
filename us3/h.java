package us3;

import android.text.TextUtils;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\f\u001a\u00020\u000b*\u00020\u0005J\n\u0010\r\u001a\u00020\u0002*\u00020\u0005J\u0012\u0010\u000f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0012"}, d2 = {"Lus3/h;", "", "", PushClientConstants.TAG_PKG_NAME, "e", "Lcom/tencent/minibox/business/api/MiniBoxAppInfo;", "appInfo", "", "a", "c", "f", "", "d", "g", "cacheJson", "b", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f439987a = new h();

    h() {
    }

    private final String e(String pkgName) {
        return "minibox_app_" + pkgName;
    }

    public final void a(@Nullable MiniBoxAppInfo appInfo) {
        if (appInfo != null && !TextUtils.isEmpty(appInfo.getAppName()) && !TextUtils.isEmpty(appInfo.getVersionName())) {
            String g16 = g(appInfo);
            m mVar = m.f439991a;
            String pkgName = appInfo.getPkgName();
            if (pkgName == null) {
                pkgName = "";
            }
            mVar.o(e(pkgName), g16);
            QLog.i("MiniBoxAppInfoCacheManager", 1, "cacheAppInfo cacheJson:" + g16);
        }
    }

    @NotNull
    public final MiniBoxAppInfo b(@NotNull MiniBoxAppInfo miniBoxAppInfo, @NotNull String cacheJson) {
        JSONObject jSONObject;
        String str;
        String str2;
        String str3;
        int i3;
        Intrinsics.checkNotNullParameter(miniBoxAppInfo, "<this>");
        Intrinsics.checkNotNullParameter(cacheJson, "cacheJson");
        if (TextUtils.isEmpty(cacheJson)) {
            return miniBoxAppInfo;
        }
        String str4 = null;
        try {
            jSONObject = new JSONObject(cacheJson);
        } catch (Exception e16) {
            QLog.e("MiniBoxAppInfoCacheManager", 1, "fromCacheJson:", e16);
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = jSONObject.optString("appName");
        } else {
            str = null;
        }
        miniBoxAppInfo.setAppName(str);
        if (jSONObject != null) {
            str2 = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
        } else {
            str2 = null;
        }
        miniBoxAppInfo.setPkgName(str2);
        if (jSONObject != null) {
            str3 = jSONObject.optString("versionName");
        } else {
            str3 = null;
        }
        miniBoxAppInfo.setVersionName(str3);
        if (jSONObject != null) {
            str4 = jSONObject.optString("iconFilePath");
        }
        miniBoxAppInfo.setIconFilePath(str4);
        if (jSONObject != null) {
            i3 = jSONObject.optInt("versionCode");
        } else {
            i3 = 0;
        }
        miniBoxAppInfo.setVersionCode(i3);
        return miniBoxAppInfo;
    }

    @Nullable
    public final MiniBoxAppInfo c(@NotNull String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        String k3 = m.f439991a.k(e(pkgName));
        if (TextUtils.isEmpty(k3)) {
            return null;
        }
        MiniBoxAppInfo miniBoxAppInfo = new MiniBoxAppInfo();
        b(miniBoxAppInfo, k3);
        QLog.i("MiniBoxAppInfoCacheManager", 1, "getCacheAppInfo appInfo:" + miniBoxAppInfo);
        if (!d(miniBoxAppInfo)) {
            return null;
        }
        return miniBoxAppInfo;
    }

    public final boolean d(@NotNull MiniBoxAppInfo miniBoxAppInfo) {
        Intrinsics.checkNotNullParameter(miniBoxAppInfo, "<this>");
        if (!TextUtils.isEmpty(miniBoxAppInfo.getAppName()) && !TextUtils.isEmpty(miniBoxAppInfo.getVersionName())) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        m.f439991a.l(e(pkgName));
        QLog.i("MiniBoxAppInfoCacheManager", 1, "removeAppInfo pkgName:" + pkgName);
    }

    @NotNull
    public final String g(@NotNull MiniBoxAppInfo miniBoxAppInfo) {
        Intrinsics.checkNotNullParameter(miniBoxAppInfo, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appName", miniBoxAppInfo.getAppName());
        jSONObject.put(PushClientConstants.TAG_PKG_NAME, miniBoxAppInfo.getPkgName());
        jSONObject.put("versionName", miniBoxAppInfo.getVersionName());
        jSONObject.put("iconFilePath", miniBoxAppInfo.getIconFilePath());
        jSONObject.put("versionCode", miniBoxAppInfo.getVersionCode());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }
}
