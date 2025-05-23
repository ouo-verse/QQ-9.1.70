package uv2;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.ona.protocol.jce.AdAndroidMarketInfo;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import pw2.j;
import pw2.n;
import pw2.o;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {

    /* compiled from: P */
    /* renamed from: uv2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C11368a {

        /* renamed from: a, reason: collision with root package name */
        int f440098a;

        /* renamed from: b, reason: collision with root package name */
        String f440099b;

        /* renamed from: c, reason: collision with root package name */
        JSONObject f440100c;

        public C11368a(int i3, String str, JSONObject jSONObject) {
            this.f440098a = i3;
            this.f440099b = str == null ? "" : str;
            this.f440100c = jSONObject;
        }

        @NonNull
        public static JSONObject a(@NonNull String str, @NonNull String str2, int i3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("packageName", str);
                jSONObject.put(ZPlanPublishSource.FROM_SCHEME, str2);
                jSONObject.put("errorCode", i3);
            } catch (Exception e16) {
                n.i("AppStoreJsApiHelper", e16, "generateMarketDownloadJson: there is something wrong");
            }
            return jSONObject;
        }

        @NonNull
        public String toString() {
            String str;
            JSONObject jSONObject = this.f440100c;
            if (jSONObject != null) {
                str = jSONObject.toString();
            } else {
                str = "{}";
            }
            return String.format(Locale.getDefault(), com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.jsapi.a.RESULT_FORMAT, Integer.valueOf(this.f440098a), this.f440099b, str);
        }
    }

    private boolean a(@NonNull AdDownloadItem adDownloadItem) {
        Application a16 = qv2.b.a();
        if (a16 == null || !pw2.b.b(a16, adDownloadItem.packageName)) {
            return false;
        }
        pw2.b.g(a16, adDownloadItem.packageName);
        return true;
    }

    private boolean b(@Nullable AdDownloadItem adDownloadItem) {
        AdAndroidMarketInfo adAndroidMarketInfo;
        if (adDownloadItem != null && (adAndroidMarketInfo = adDownloadItem.androidMarketInfo) != null && adAndroidMarketInfo.enableMarketDownload) {
            return true;
        }
        return false;
    }

    private boolean c(@NonNull List<String> list) {
        Application a16 = qv2.b.a();
        if (a16 == null) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (pw2.b.b(a16, it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(@NonNull AdAndroidMarketInfo adAndroidMarketInfo) {
        String str = adAndroidMarketInfo.marketDeepLink;
        if (!y.h(adAndroidMarketInfo.marketPackageName) && !TextUtils.isEmpty(str) && (str.startsWith("market://details?id=") || str.startsWith("samsungapps://ProductDetail/"))) {
            return true;
        }
        return false;
    }

    private void g(@NonNull AdDownloadItem adDownloadItem, @Nullable String str) {
        String str2 = adDownloadItem.packageName;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            o.d().c(str2, str, 0);
        }
    }

    private boolean h(@NonNull AdAndroidMarketInfo adAndroidMarketInfo, @Nullable String str) {
        Activity a16 = ev2.a.a();
        if (a16 == null) {
            n.h("AppStoreJsApiHelper", "the input param is invalid in startAppStoreActivity method");
            return false;
        }
        for (Intent intent : c.a(adAndroidMarketInfo.marketDeepLink, adAndroidMarketInfo.marketPackageName, true)) {
            if (intent != null && c.b(a16, intent)) {
                return true;
            }
        }
        return false;
    }

    public C11368a e() {
        int i3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", j.c());
            jSONObject.put("brand", j.a());
            jSONObject.put("manufacturer", j.b());
            jSONObject.put("appVersion", qv2.b.c());
            i3 = 0;
        } catch (Exception e16) {
            n.i("AppStoreJsApiHelper", e16, "there is something wrong in obtainDeviceInfo");
            i3 = 1;
        }
        return new C11368a(i3, "", jSONObject);
    }

    public C11368a f(JSONObject jSONObject, String str, AdDownloadItem adDownloadItem) {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u6536\u5230\u7684\u6570\u636eAdDownloadItem\u662f\u5426\u4e3anull");
        if (adDownloadItem == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        n.e("AppStoreJsApiHelper", sb5.toString());
        if (!b(adDownloadItem)) {
            return new C11368a(1, "", C11368a.a("", "", 206));
        }
        AdAndroidMarketInfo adAndroidMarketInfo = adDownloadItem.androidMarketInfo;
        if (a(adDownloadItem)) {
            return new C11368a(0, "", null);
        }
        g(adDownloadItem, str);
        if (!d(adAndroidMarketInfo)) {
            return new C11368a(1, "", C11368a.a("", adAndroidMarketInfo.marketDeepLink, 304));
        }
        if (!c(adAndroidMarketInfo.marketPackageName)) {
            return new C11368a(1, "", C11368a.a("", adAndroidMarketInfo.marketDeepLink, 314));
        }
        if (h(adAndroidMarketInfo, str)) {
            return new C11368a(0, "", null);
        }
        return new C11368a(1, "start app store failed", C11368a.a("", adAndroidMarketInfo.marketDeepLink, 315));
    }
}
