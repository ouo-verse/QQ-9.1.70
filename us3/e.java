package us3;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.qphone.base.util.QLog;
import cs3.ApkInfo;
import cs3.MetaDreamAppExtraInfo;
import cs3.PufferInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lus3/e;", "", "", "extraInfo", "Lcs3/d;", "a", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f439984a = new e();

    e() {
    }

    @Nullable
    public final MetaDreamAppExtraInfo a(@NotNull String extraInfo) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        long j3;
        String str8;
        String str9;
        String str10;
        String str11;
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (TextUtils.isEmpty(extraInfo)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(extraInfo);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null) {
                str = optJSONObject2.optString("version_info");
            } else {
                str = null;
            }
            String str12 = "";
            if (str == null) {
                str = "";
            }
            JSONObject jSONObject2 = new JSONObject(str);
            JSONObject optJSONObject3 = jSONObject2.optJSONObject("apkInfo");
            JSONObject optJSONObject4 = jSONObject2.optJSONObject("pufferInfo");
            MetaDreamAppExtraInfo metaDreamAppExtraInfo = new MetaDreamAppExtraInfo();
            ApkInfo apkInfo = new ApkInfo();
            if (optJSONObject3 != null) {
                str2 = optJSONObject3.optString("appId");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            apkInfo.j(str2);
            if (optJSONObject3 != null) {
                str3 = optJSONObject3.optString("gameIcon");
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str3 = "";
            }
            apkInfo.i(str3);
            if (optJSONObject3 != null) {
                str4 = optJSONObject3.optString("gameName");
            } else {
                str4 = null;
            }
            if (str4 == null) {
                str4 = "";
            }
            apkInfo.k(str4);
            if (optJSONObject3 != null) {
                str5 = optJSONObject3.optString("versionName");
            } else {
                str5 = null;
            }
            if (str5 == null) {
                str5 = "";
            }
            apkInfo.o(str5);
            apkInfo.l("com.tencent.letsgo");
            if (optJSONObject3 != null) {
                str6 = optJSONObject3.optString("versionCode");
            } else {
                str6 = null;
            }
            apkInfo.n(str6);
            if (optJSONObject3 != null) {
                str7 = optJSONObject3.optString("apkUrl");
            } else {
                str7 = null;
            }
            if (str7 != null) {
                str12 = str7;
            }
            apkInfo.h(str12);
            if (optJSONObject3 != null) {
                j3 = optJSONObject3.optLong("size");
            } else {
                j3 = 0;
            }
            apkInfo.m(j3);
            metaDreamAppExtraInfo.e(apkInfo);
            PufferInfo pufferInfo = new PufferInfo();
            if (optJSONObject4 != null) {
                str8 = optJSONObject4.optString("preDownloadInfo");
            } else {
                str8 = null;
            }
            pufferInfo.d(str8);
            if (optJSONObject4 != null) {
                str9 = optJSONObject4.toString();
            } else {
                str9 = null;
            }
            pufferInfo.c(str9);
            metaDreamAppExtraInfo.h(pufferInfo);
            JSONObject optJSONObject5 = jSONObject.optJSONObject("data");
            if (optJSONObject5 != null) {
                str10 = optJSONObject5.optString(MosaicConstants$JsProperty.PROP_ENV);
            } else {
                str10 = null;
            }
            metaDreamAppExtraInfo.g(str10);
            JSONObject optJSONObject6 = jSONObject.optJSONObject("data");
            if (optJSONObject6 != null && (optJSONObject = optJSONObject6.optJSONObject("diff_patch_info")) != null) {
                str11 = optJSONObject.toString();
            } else {
                str11 = null;
            }
            metaDreamAppExtraInfo.f(str11);
            return metaDreamAppExtraInfo;
        } catch (Exception e16) {
            QLog.e("MetaDreamExtraUtils", 1, e16, new Object[0]);
            return null;
        }
    }
}
