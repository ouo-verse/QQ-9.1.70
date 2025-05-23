package wa1;

import com.tencent.ark.ark;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import xa1.VasBadgeBrandRedDotConfig;
import xa1.VasSmallHomeCallbackConfig;
import xa1.c;
import xa1.d;
import xa1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001f\u0010\u0014\u001a\u00020\u00022\u0010\u0010\u0013\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0012\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lwa1/a;", "", "Lxa1/d;", DownloadInfo.spKey_Config, "", "content", "", "c", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "e", "d", "f", h.F, "g", "b", "i", "", "Lcom/tencent/mobileqq/config/ai;", "confFiles", "a", "([Lcom/tencent/mobileqq/config/ai;)Lxa1/d;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f445122a = new a();

    a() {
    }

    private final void b(d config, JSONObject json) {
        config.h(new VasBadgeBrandRedDotConfig(json.optJSONObject("BadgeBrandRedDot").optInt("dayLimit", 3)));
    }

    private final void c(d config, String content) {
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (jSONObject.has("WoTransitPage")) {
                i(config, jSONObject);
            }
            if (jSONObject.has("BadgeBrandRedDot")) {
                b(config, jSONObject);
            }
            if (jSONObject.has("WoPushBanner")) {
                g(config, jSONObject);
            }
            if (jSONObject.has("VasRecordConfig")) {
                h(config, jSONObject);
            }
            if (jSONObject.has("MsgBox")) {
                d(config, jSONObject);
            }
            if (jSONObject.has("QZoneFeeds")) {
                f(config, jSONObject);
            }
            if (jSONObject.has("Performance")) {
                e(config, jSONObject);
            }
        } catch (Throwable th5) {
            QLog.e("VasZplanConfigParser", 1, "parseItem err", th5);
        }
    }

    private final void d(d config, JSONObject json) {
        String str;
        try {
            JSONObject optJSONObject = json.optJSONObject("MsgBox");
            if (optJSONObject != null) {
                str = optJSONObject.toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            config.j(str);
        } catch (Throwable th5) {
            QLog.e("VasZplanConfigParser", 1, "parseMsgBoxConfig err.", th5);
        }
    }

    private final void e(d config, JSONObject json) {
        String str;
        try {
            JSONObject optJSONObject = json.optJSONObject("Performance");
            if (optJSONObject != null) {
                str = optJSONObject.toString();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            config.k(str);
        } catch (Throwable th5) {
            QLog.e("VasZplanConfigParser", 1, "parsePerformanceConfig err.", th5);
        }
    }

    private final void f(d config, JSONObject json) {
        boolean z16;
        boolean z17;
        JSONObject optJSONObject = json.optJSONObject("QZoneFeeds");
        boolean z18 = true;
        if (optJSONObject != null && optJSONObject.has("HomePageUrl")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            c qZoneFeedsConfig = config.getQZoneFeedsConfig();
            String optString = optJSONObject.optString("HomePageUrl", config.getQZoneFeedsConfig().getHomePageUrl());
            Intrinsics.checkNotNullExpressionValue(optString, "configJson.optString(Vas\u2026eFeedsConfig.homePageUrl)");
            qZoneFeedsConfig.d(optString);
        }
        if (optJSONObject != null && optJSONObject.has("PrivacyDialogShowLimitDay")) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            config.getQZoneFeedsConfig().e(optJSONObject.optInt("PrivacyDialogShowLimitDay", config.getQZoneFeedsConfig().getPrivacyDialogShowLimitDay()));
        }
        if (optJSONObject == null || !optJSONObject.has("QZoneBubbleText")) {
            z18 = false;
        }
        if (z18) {
            c qZoneFeedsConfig2 = config.getQZoneFeedsConfig();
            String optString2 = optJSONObject.optString("QZoneBubbleText", config.getQZoneFeedsConfig().getQZoneBubbleText());
            Intrinsics.checkNotNullExpressionValue(optString2, "configJson.optString(Vas\u2026dsConfig.qZoneBubbleText)");
            qZoneFeedsConfig2.f(optString2);
        }
    }

    private final void g(d config, JSONObject json) {
        config.i(new VasSmallHomeCallbackConfig(json.optJSONObject("WoPushBanner").optInt("timeLimitAfterDownload", 5)));
    }

    private final void h(d config, JSONObject json) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        JSONObject optJSONObject = json.optJSONObject("VasRecordConfig");
        boolean z38 = true;
        if (optJSONObject != null && optJSONObject.has("encodeType")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            config.getSquareConfig().n(optJSONObject.optInt("encodeType", 1));
        }
        if (optJSONObject != null && optJSONObject.has("IpConnect")) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            config.getSquareConfig().o(optJSONObject.optBoolean("IpConnect", false));
        }
        if (optJSONObject != null && optJSONObject.has("NeedReportPlaySuccess")) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            config.getSquareConfig().r(optJSONObject.optBoolean("NeedReportPlaySuccess", false));
        }
        if (optJSONObject != null && optJSONObject.has("UseSticker")) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19) {
            config.getSquareConfig().t(optJSONObject.optBoolean("UseSticker", false));
        }
        if (optJSONObject != null && optJSONObject.has("NeedCheckMp4TrackCount")) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (z26) {
            config.getSquareConfig().q(optJSONObject.optBoolean("NeedCheckMp4TrackCount", true));
        }
        if (optJSONObject != null && optJSONObject.has("Mp4FileSizeLimit")) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z27) {
            config.getSquareConfig().p(optJSONObject.optLong("Mp4FileSizeLimit", -1L));
        }
        if (optJSONObject != null && optJSONObject.has("AALevel")) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (z28) {
            config.getSquareConfig().j(optJSONObject.optInt("AALevel", 3));
        }
        if (optJSONObject != null && optJSONObject.has("AAType")) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z29) {
            config.getSquareConfig().k(optJSONObject.optInt("AAType", 4));
        }
        if (optJSONObject != null && optJSONObject.has("CanCodecReUse")) {
            z36 = true;
        } else {
            z36 = false;
        }
        if (z36) {
            config.getSquareConfig().l(optJSONObject.optBoolean("CanCodecReUse", false));
        }
        if (optJSONObject != null && optJSONObject.has("SoftEncodeMode")) {
            z37 = true;
        } else {
            z37 = false;
        }
        if (z37) {
            config.getSquareConfig().s(optJSONObject.optInt("SoftEncodeMode", 0));
        }
        if (optJSONObject == null || !optJSONObject.has("DoubleUserRecordUseV2")) {
            z38 = false;
        }
        if (z38) {
            config.getSquareConfig().m(optJSONObject.optBoolean("DoubleUserRecordUseV2", false));
        }
    }

    private final void i(d config, JSONObject json) {
        boolean z16;
        JSONObject optJSONObject = json.optJSONObject("WoTransitPage");
        JSONArray optJSONArray = optJSONObject.optJSONArray("backgrounds");
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(optJSONArray.optString(i3));
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(f.INSTANCE.a());
        }
        String optString = optJSONObject.optString("desTitleNeedDownload", "\u6b22\u8fce\u5149\u4e34\u6211\u7684\u5c0f\u7a9d\uff0c\u6765\u4e00\u573a\u5076\u9047\u5427~");
        Intrinsics.checkNotNullExpressionValue(optString, "configJson.optString(Vas\u2026itPageConfig.DES_DEFAULT)");
        String optString2 = optJSONObject.optString("desTitleNeedUpdate", "\u6b22\u8fce\u5149\u4e34\u6211\u7684\u5c0f\u7a9d\uff0c\u6765\u4e00\u573a\u5076\u9047\u5427~");
        Intrinsics.checkNotNullExpressionValue(optString2, "configJson.optString(Vas\u2026itPageConfig.DES_DEFAULT)");
        String optString3 = optJSONObject.optString("desTitleDefault", "\u6b22\u8fce\u5149\u4e34\u6211\u7684\u5c0f\u7a9d\uff0c\u6765\u4e00\u573a\u5076\u9047\u5427~");
        Intrinsics.checkNotNullExpressionValue(optString3, "configJson.optString(Vas\u2026itPageConfig.DES_DEFAULT)");
        if (optJSONObject.optInt("showTips", 0) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        String optString4 = optJSONObject.optString("tipsDownloading", "\u81ea\u7531\u5e03\u7f6e\u4f60\u60f3\u8981\u7684\u88c5\u4fee\u98ce\u683c");
        Intrinsics.checkNotNullExpressionValue(optString4, "configJson.optString(Vas\u2026tPageConfig.TIPS_DEFAULT)");
        String optString5 = optJSONObject.optString("tipsDefault", "\u81ea\u7531\u5e03\u7f6e\u4f60\u60f3\u8981\u7684\u88c5\u4fee\u98ce\u683c");
        Intrinsics.checkNotNullExpressionValue(optString5, "configJson.optString(Vas\u2026tPageConfig.TIPS_DEFAULT)");
        String optString6 = optJSONObject.optString("tipsIcon", "https://imgcache.gtimg.cn/mie/act/img/public/202203/m1646384615_liwu@3x.png");
        Intrinsics.checkNotNullExpressionValue(optString6, "configJson.optString(Vas\u2026Config.TIPS_ICON_DEFAULT)");
        config.l(new f(arrayList, optString, optString2, optString3, z16, optString4, optString5, optString6));
    }

    @NotNull
    public final d a(@Nullable ai[] confFiles) {
        boolean z16;
        d dVar = new d();
        if (confFiles != null) {
            if (confFiles.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                for (ai aiVar : confFiles) {
                    a aVar = f445122a;
                    String str = aiVar.f202268b;
                    Intrinsics.checkNotNullExpressionValue(str, "it.content");
                    aVar.c(dVar, str);
                }
                return dVar;
            }
        }
        QLog.d("VasZplanConfigParser", 1, "confFiles is null or empty");
        return dVar;
    }
}
