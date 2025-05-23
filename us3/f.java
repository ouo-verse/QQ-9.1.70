package us3;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qq.minibox.api.data.VirtualAppInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0002\u00a8\u0006\u000f"}, d2 = {"Lus3/f;", "", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/qq/minibox/api/data/MiniBoxAppDataInfo;", "Lkotlin/collections/ArrayList;", "c", "appDataInfo", "", "a", "dataJson", "b", "<init>", "()V", "minibox-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f439985a = new f();

    f() {
    }

    public final boolean a(@Nullable VirtualAppInfo appDataInfo) {
        boolean z16;
        boolean z17;
        boolean z18 = false;
        if (appDataInfo == null) {
            return false;
        }
        String downloadUrl = appDataInfo.getDownloadUrl();
        if (downloadUrl != null && downloadUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String versionCode = appDataInfo.getVersionCode();
        if (versionCode != null && versionCode.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        boolean z19 = z16 | z17;
        String packageName = appDataInfo.getPackageName();
        if (packageName == null || packageName.length() == 0) {
            z18 = true;
        }
        return !(z19 | z18);
    }

    @NotNull
    public final VirtualAppInfo b(@NotNull String dataJson) {
        Intrinsics.checkNotNullParameter(dataJson, "dataJson");
        if (TextUtils.isEmpty(dataJson)) {
            return new VirtualAppInfo();
        }
        try {
            JSONObject jSONObject = new JSONObject(dataJson);
            VirtualAppInfo virtualAppInfo = new VirtualAppInfo();
            String optString = jSONObject.optString("appIcon");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(VADataConstant.KEY.KEY_APP_ICON)");
            virtualAppInfo.y(optString);
            String optString2 = jSONObject.optString("appName");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(VADataConstant.KEY.KEY_APP_NAME)");
            virtualAppInfo.A(optString2);
            String optString3 = jSONObject.optString("appLabel");
            Intrinsics.checkNotNullExpressionValue(optString3, "json.optString(VADataConstant.KEY.KEY_APP_LABEL)");
            virtualAppInfo.G(optString3);
            String optString4 = jSONObject.optString("appid");
            Intrinsics.checkNotNullExpressionValue(optString4, "json.optString(VADataConstant.KEY.KEY_APPID)");
            virtualAppInfo.z(optString4);
            String optString5 = jSONObject.optString("appDesc");
            Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(VADataConstant.KEY.KEY_APP_DES)");
            virtualAppInfo.D(optString5);
            String optString6 = jSONObject.optString("packageName");
            Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(VADataConstant.KEY.KEY_PACKAGENAME)");
            virtualAppInfo.N(optString6);
            String optString7 = jSONObject.optString("versionCode");
            Intrinsics.checkNotNullExpressionValue(optString7, "json.optString(VADataConstant.KEY.KEY_APP_VERSION)");
            virtualAppInfo.c0(optString7);
            String optString8 = jSONObject.optString("downloadUrl");
            Intrinsics.checkNotNullExpressionValue(optString8, "json.optString(VADataCon\u2026ant.KEY.KEY_DOWNLOAD_URL)");
            virtualAppInfo.E(optString8);
            String optString9 = jSONObject.optString("appCoverUrl");
            Intrinsics.checkNotNullExpressionValue(optString9, "json.optString(VADataCon\u2026ant.KEY.KEY_APP_COVERURL)");
            virtualAppInfo.C(optString9);
            String optString10 = jSONObject.optString(AppConstants.Key.KEY_QZONE_VIDEO_URL);
            Intrinsics.checkNotNullExpressionValue(optString10, "json.optString(VADataConstant.KEY.KEY_VIDEOURL)");
            virtualAppInfo.f0(optString10);
            virtualAppInfo.e0(jSONObject.optInt("videoHeight"));
            virtualAppInfo.g0(jSONObject.optInt("videoWidth"));
            String optString11 = jSONObject.optString("isnot_login");
            Intrinsics.checkNotNullExpressionValue(optString11, "json.optString(VADataCon\u2026nt.KEY.KEY_SUPPORT_LOGIN)");
            virtualAppInfo.a0(optString11);
            String optString12 = jSONObject.optString("isnot_pay");
            Intrinsics.checkNotNullExpressionValue(optString12, "json.optString(VADataConstant.KEY.KEY_SUPPORT_PAY)");
            virtualAppInfo.b0(optString12);
            return virtualAppInfo;
        } catch (JSONException unused) {
            return new VirtualAppInfo();
        }
    }

    @NotNull
    public final ArrayList<VirtualAppInfo> c(@NotNull String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList<VirtualAppInfo> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(data);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String jSONObject = jSONArray.optJSONObject(i3).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "jsonArray.optJSONObject(index).toString()");
                VirtualAppInfo b16 = b(jSONObject);
                if (a(b16)) {
                    arrayList.add(b16);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return arrayList;
    }
}
