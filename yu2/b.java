package yu2;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.OpenSdkManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adclick.QAdStandardClickReportInfo;
import com.tencent.qqlive.ona.protocol.jce.AdAction;
import com.tencent.qqlive.ona.protocol.jce.AdActionItem;
import com.tencent.qqlive.ona.protocol.jce.AdActionReport;
import com.tencent.qqlive.ona.protocol.jce.AdDownloadItem;
import com.tencent.qqlive.ona.protocol.jce.AdInSideExtraReportItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoPoster;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequest;
import com.tencent.qqlive.ona.protocol.jce.AdMaxViewItem;
import com.tencent.qqlive.ona.protocol.jce.AdOfflineInfo;
import com.tencent.qqlive.ona.protocol.jce.AdOpenAppItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPageInfo;
import com.tencent.qqlive.ona.protocol.jce.AdPositionItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import com.tencent.qqlive.ona.protocol.jce.AdVideoInfo;
import com.tencent.qqlive.ona.protocol.jce.AdVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdcPoster;
import com.tencent.qqlive.ona.protocol.jce.InsideVideoSkipAdInfo;
import com.tencent.qqlive.ona.protocol.jce.PackageAction;
import java.util.List;
import java.util.Map;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    private static boolean A(Context context, AdAction adAction) {
        AdOpenAppItem adOpenAppItem;
        AdActionItem adActionItem = adAction.actionItem;
        if (adActionItem != null && (adOpenAppItem = adActionItem.adOpenApp) != null && !TextUtils.isEmpty(adOpenAppItem.packageName) && pw2.b.b(context, adAction.actionItem.adOpenApp.packageName)) {
            return true;
        }
        return false;
    }

    public static boolean B(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.b bVar) {
        if (!(bVar instanceof cw2.c) && !(bVar instanceof xv2.a)) {
            return false;
        }
        return true;
    }

    public static boolean C(AdInsideVideoItem adInsideVideoItem) {
        if (adInsideVideoItem != null && adInsideVideoItem.formInfo != null && adInsideVideoItem.bannerType == 2) {
            return true;
        }
        return false;
    }

    public static boolean D(AdInsideVideoItem adInsideVideoItem) {
        AdInsideVideoPoster adInsideVideoPoster;
        if (adInsideVideoItem != null && (adInsideVideoPoster = adInsideVideoItem.videoPoster) != null && adInsideVideoPoster.enableScreenClick) {
            return true;
        }
        return false;
    }

    private static boolean E(AdcPoster adcPoster) {
        if (adcPoster != null && !TextUtils.isEmpty(adcPoster.imageUrl)) {
            return true;
        }
        return false;
    }

    public static boolean F(AdInsideVideoItem adInsideVideoItem) {
        AdMaxViewItem adMaxViewItem;
        if (adInsideVideoItem != null && (adMaxViewItem = adInsideVideoItem.maxViewItem) != null && adMaxViewItem.showType == 1) {
            return true;
        }
        return false;
    }

    public static boolean G(List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> list, boolean z16) {
        if (list != null && list.size() > 1) {
            return z16;
        }
        return false;
    }

    public static boolean H(@Nullable AdInsideVideoItem adInsideVideoItem) {
        return L(adInsideVideoItem);
    }

    private static boolean I(@NonNull AdAction adAction) {
        AdActionItem adActionItem = adAction.actionItem;
        if (adActionItem != null && adActionItem.parseType == 1) {
            return true;
        }
        return false;
    }

    private static boolean J(@NonNull AdAction adAction, int i3, int i16) {
        if (I(adAction) && N(i3, i16)) {
            return false;
        }
        return true;
    }

    public static boolean K(AdInsideVideoItem adInsideVideoItem) {
        AdOrderItem adOrderItem;
        if (adInsideVideoItem != null && (adOrderItem = adInsideVideoItem.orderItem) != null && 5 == adOrderItem.adType) {
            return true;
        }
        return false;
    }

    public static boolean L(@Nullable AdInsideVideoItem adInsideVideoItem) {
        AdInsideVideoPoster adInsideVideoPoster;
        if (adInsideVideoItem != null && adInsideVideoItem.adSubType == 0 && (adInsideVideoPoster = adInsideVideoItem.videoPoster) != null && adInsideVideoPoster.countDownViewType == 1) {
            return true;
        }
        return false;
    }

    public static boolean M(@Nullable AdInsideVideoItem adInsideVideoItem) {
        if (t(adInsideVideoItem) == 2) {
            return true;
        }
        return false;
    }

    private static boolean N(int i3, int i16) {
        if (i3 != 5 && !v(i16)) {
            return false;
        }
        return true;
    }

    public static boolean O(AdInsideVideoItem adInsideVideoItem) {
        AdInsideVideoPoster adInsideVideoPoster;
        if (adInsideVideoItem != null && ((W(adInsideVideoItem.adSubType) && (adInsideVideoPoster = adInsideVideoItem.videoPoster) != null && adInsideVideoPoster.skipAdDuration > 0) || adInsideVideoItem.adSubType == 4)) {
            return true;
        }
        return false;
    }

    private static boolean P(AdVideoItem adVideoItem) {
        if (adVideoItem != null && !TextUtils.isEmpty(adVideoItem.url)) {
            return true;
        }
        return false;
    }

    public static boolean Q(AdInsideVideoItem adInsideVideoItem, boolean z16) {
        if (adInsideVideoItem != null && (!z16 ? E(adInsideVideoItem.posterItem) : P(adInsideVideoItem.videoItem))) {
            return true;
        }
        return false;
    }

    public static boolean R(AdInsideVideoRequest adInsideVideoRequest) {
        AdOfflineInfo adOfflineInfo;
        AdPageInfo adPageInfo;
        if (adInsideVideoRequest != null) {
            int i3 = adInsideVideoRequest.adVipState;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 3 && (adOfflineInfo = adInsideVideoRequest.adOfflineInfo) != null && (adPageInfo = adInsideVideoRequest.adPageInfo) != null && adPageInfo.adPlayMode == 3 && adOfflineInfo.offlineVideoType == 3 && adInsideVideoRequest.requestAdType == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean S(AdInsideVideoItem adInsideVideoItem) {
        if (e(adInsideVideoItem) == 1) {
            return true;
        }
        return false;
    }

    public static wv2.a T(AdInsideVideoItem adInsideVideoItem, String str, AdAction adAction, int i3, int i16, VideoReportInfo videoReportInfo, boolean z16) {
        wv2.a aVar = new wv2.a();
        if (w(adInsideVideoItem)) {
            return aVar;
        }
        AdAction p16 = p(adInsideVideoItem, adAction);
        aVar.f446565a = p16.actionItem;
        aVar.f446566b = p16.actionType;
        aVar.f446581q = p16.pageType;
        aVar.f446582r = p16.autoOpenPageType;
        aVar.f446583s = p16.isAutoOpenPage;
        aVar.f446586v = p16.adHalfPageItem;
        AdOrderItem adOrderItem = adInsideVideoItem.orderItem;
        aVar.f446571g = adOrderItem.adType;
        String str2 = adOrderItem.orderId;
        aVar.f446573i = str2;
        aVar.f446567c = str2;
        aVar.f446575k = str;
        aVar.f446568d = I(p16);
        aVar.f446569e = d(p16);
        aVar.f446570f = i3;
        aVar.f446579o = true;
        aVar.f446584t = true;
        aVar.f446578n = J(p16, i3, i16);
        aVar.f446572h = i16;
        aVar.E = videoReportInfo;
        AdInSideExtraReportItem adInSideExtraReportItem = adInsideVideoItem.extraReportItem;
        if (adInSideExtraReportItem != null) {
            aVar.f446574j = adInSideExtraReportItem.soid;
        }
        AdOrderItem adOrderItem2 = adInsideVideoItem.orderItem;
        Map<String, String> map = adOrderItem2.adExperiment;
        if (map != null) {
            aVar.f446587w = map;
        }
        AdPositionItem adPositionItem = adOrderItem2.positionItem;
        if (adPositionItem != null) {
            aVar.f446576l = adPositionItem.adSpace;
        }
        aVar.D = adInsideVideoItem.maxViewItem;
        aVar.f446588x = g(adInsideVideoItem);
        return aVar;
    }

    public static com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d U(AdInsideVideoItem adInsideVideoItem, String str, QAdStandardClickReportInfo.ClickExtraInfo clickExtraInfo, boolean z16, int i3, Map<String, String> map) {
        int i16;
        if (adInsideVideoItem == null) {
            return null;
        }
        if (z16) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        String a16 = nv2.a.a(str);
        return QAdStandardClickReportInfo.E(adInsideVideoItem.orderItem, i3, i16, clickExtraInfo, a16, map);
    }

    public static boolean V(int i3) {
        return false;
    }

    public static boolean W(int i3) {
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    public static boolean X(AdInsideVideoItem adInsideVideoItem) {
        if (adInsideVideoItem != null && W(adInsideVideoItem.adSubType)) {
            return true;
        }
        return false;
    }

    public static com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c a(AdInsideVideoItem adInsideVideoItem, String str, int i3, boolean z16) {
        boolean z17;
        if (adInsideVideoItem == null) {
            return null;
        }
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c(adInsideVideoItem);
        cVar.f303592d = str;
        cVar.f303593e = i3;
        if (adInsideVideoItem.videoItem != null) {
            boolean F = F(adInsideVideoItem);
            String b16 = rv2.c.b(adInsideVideoItem.videoItem.vid, str, u(z16, F));
            if (d.f() && !TextUtils.isEmpty(b16)) {
                z17 = true;
            } else {
                z17 = false;
            }
            n.a("QADInsideDataHelper", "vid = " + adInsideVideoItem.videoItem.vid + ", isCache = " + z17 + ", isMaxView = " + F);
            cVar.f303591c = z17;
            if (z17) {
                adInsideVideoItem.videoItem.url = b16;
            }
            if (!z17) {
                b16 = rv2.c.d(adInsideVideoItem.videoItem.vid, str, u(z16, F));
            }
            cVar.f303590b = b16;
            n.a("QADInsideDataHelper", "vid = " + adInsideVideoItem.videoItem.vid + ", cachePath = " + cVar.f303590b);
        }
        return cVar;
    }

    public static <T extends JceStruct> T b(byte[] bArr, T t16) {
        if (bArr != null && t16 != null) {
            try {
                JceInputStream jceInputStream = new JceInputStream(bArr);
                jceInputStream.setServerEncoding("UTF-8");
                t16.readFrom(jceInputStream);
            } catch (Exception e16) {
                n.c("QADInsideDataHelper", e16);
                if (qv2.b.e()) {
                    throw e16;
                }
            }
            return t16;
        }
        return null;
    }

    public static int c(boolean z16, int i3) {
        if (z16) {
            if (i3 == 1) {
                return 2;
            }
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        return 0;
    }

    private static AdReport d(@NonNull AdAction adAction) {
        AdActionReport adActionReport = adAction.actionReport;
        if (adActionReport != null) {
            return adActionReport.effectReport;
        }
        return null;
    }

    private static int e(AdInsideVideoItem adInsideVideoItem) {
        if (adInsideVideoItem != null) {
            return adInsideVideoItem.adSubType;
        }
        return 0;
    }

    public static int f(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c[] cVarArr, boolean z16) {
        if (cVarArr == null) {
            return 0;
        }
        int i3 = 0;
        for (com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar : cVarArr) {
            i3 = (int) (i3 + h(cVar, z16));
        }
        return i3;
    }

    private static String g(AdInsideVideoItem adInsideVideoItem) {
        AdOrderItem adOrderItem;
        AdAction adAction;
        AdActionReport adActionReport;
        AdReport adReport;
        if (adInsideVideoItem != null && (adOrderItem = adInsideVideoItem.orderItem) != null && (adAction = adOrderItem.adAction) != null && (adActionReport = adAction.actionReport) != null && (adReport = adActionReport.clickReport) != null) {
            return adReport.headerInfo;
        }
        return "";
    }

    public static long h(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar, boolean z16) {
        AdInsideVideoItem adInsideVideoItem;
        if (cVar != null && (adInsideVideoItem = cVar.f303589a) != null) {
            return i(adInsideVideoItem, z16);
        }
        return 0L;
    }

    public static long i(AdInsideVideoItem adInsideVideoItem, boolean z16) {
        AdcPoster adcPoster;
        int i3;
        AdVideoItem adVideoItem;
        if (adInsideVideoItem != null) {
            if (z16 && (adVideoItem = adInsideVideoItem.videoItem) != null) {
                i3 = adVideoItem.duration;
            } else if (!z16 && (adcPoster = adInsideVideoItem.posterItem) != null) {
                i3 = (int) adcPoster.duration;
            } else {
                return 0L;
            }
            return i3;
        }
        return 0L;
    }

    public static String j(AdInsideVideoRequest adInsideVideoRequest) {
        AdVideoInfo adVideoInfo;
        if (adInsideVideoRequest != null && (adVideoInfo = adInsideVideoRequest.adVideoInfo) != null) {
            return adVideoInfo.defn;
        }
        return "hd";
    }

    public static int k(@NonNull AdInsideVideoItem adInsideVideoItem, @NonNull AdInsideVideoItem adInsideVideoItem2) {
        return 1;
    }

    public static int l(AdInsideVideoItem adInsideVideoItem) {
        return 1;
    }

    public static int m(List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> list, int i3, boolean z16) {
        if (list == null) {
            return 0;
        }
        return (int) h((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c) y.d(list, i3), z16);
    }

    public static int n(List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> list, int i3, boolean z16) {
        if (list == null) {
            return 0;
        }
        int i16 = 0;
        for (int i17 = 0; i17 < i3 && i17 < list.size(); i17++) {
            i16 = (int) (i16 + h(list.get(i17), z16));
        }
        return i16;
    }

    public static int o(List<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> list, int i3, boolean z16) {
        AdInsideVideoItem adInsideVideoItem;
        int i16 = 0;
        if (list != null) {
            if (i3 >= list.size()) {
                return 0;
            }
            while (i3 < list.size()) {
                com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c cVar = list.get(i3);
                if (cVar != null && (adInsideVideoItem = cVar.f303589a) != null) {
                    i16 += r(adInsideVideoItem, z16);
                }
                i3++;
            }
        }
        return i16;
    }

    private static AdAction p(@NonNull AdInsideVideoItem adInsideVideoItem, AdAction adAction) {
        if (adAction == null) {
            return adInsideVideoItem.orderItem.adAction;
        }
        return adAction;
    }

    public static int q(@Nullable InsideVideoSkipAdInfo insideVideoSkipAdInfo) {
        int i3;
        if (insideVideoSkipAdInfo != null && insideVideoSkipAdInfo.enableMultiTrueViewAd && (i3 = insideVideoSkipAdInfo.skipAdDuration) >= 0) {
            return i3 * 1000;
        }
        return 0;
    }

    private static int r(AdInsideVideoItem adInsideVideoItem, boolean z16) {
        AdInsideVideoPoster adInsideVideoPoster;
        int i3;
        int i16;
        if (adInsideVideoItem != null && (adInsideVideoPoster = adInsideVideoItem.videoPoster) != null && adInsideVideoPoster.longVideoInfo != null && Q(adInsideVideoItem, z16) && (i3 = adInsideVideoItem.videoPoster.longVideoInfo.playDuration) < (i16 = (int) i(adInsideVideoItem, z16)) && i3 > 0) {
            return i16 - i3;
        }
        return 0;
    }

    public static int s(AdInsideVideoItem adInsideVideoItem) {
        if (adInsideVideoItem != null) {
            return adInsideVideoItem.skipType;
        }
        return 0;
    }

    public static int t(@Nullable AdInsideVideoItem adInsideVideoItem) {
        AdInsideVideoPoster adInsideVideoPoster;
        if (adInsideVideoItem != null && (adInsideVideoPoster = adInsideVideoItem.videoPoster) != null) {
            return adInsideVideoPoster.skipType;
        }
        return 0;
    }

    private static int u(boolean z16, boolean z17) {
        return 0;
    }

    public static boolean v(int i3) {
        if (i3 != 1025 && i3 != 1026 && i3 != 1021) {
            return false;
        }
        return true;
    }

    private static boolean w(AdInsideVideoItem adInsideVideoItem) {
        AdOrderItem adOrderItem;
        if (adInsideVideoItem != null && (adOrderItem = adInsideVideoItem.orderItem) != null && adOrderItem.adAction != null) {
            return false;
        }
        return true;
    }

    public static boolean x(Context context, AdOrderItem adOrderItem) {
        AdAction adAction;
        if (adOrderItem == null || (adAction = adOrderItem.adAction) == null) {
            return false;
        }
        int i3 = adAction.actionType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 100 && i3 != 102 && i3 != 104) {
                            return false;
                        }
                        return OpenSdkManager.INSTANCE.isWXInstalled();
                    }
                    return y(context, adAction);
                }
                return pw2.b.b(context, "com.jingdong.app.mall");
            }
            return A(context, adAction);
        }
        return z(context, adAction);
    }

    private static boolean y(Context context, AdAction adAction) {
        AdOpenAppItem adOpenAppItem;
        PackageAction packageAction;
        AdActionItem adActionItem = adAction.actionItem;
        if (adActionItem != null && (adOpenAppItem = adActionItem.adOpenApp) != null && (packageAction = adOpenAppItem.packageAction) != null && pw2.b.d(context, adOpenAppItem.packageName, packageAction.url)) {
            return true;
        }
        return false;
    }

    private static boolean z(Context context, AdAction adAction) {
        AdDownloadItem adDownloadItem;
        AdActionItem adActionItem = adAction.actionItem;
        if (adActionItem != null && (adDownloadItem = adActionItem.adDownload) != null && !TextUtils.isEmpty(adDownloadItem.packageName)) {
            AdDownloadItem adDownloadItem2 = adAction.actionItem.adDownload;
            if (pw2.b.c(context, adDownloadItem2.packageName, adDownloadItem2.versionCode)) {
                return true;
            }
        }
        return false;
    }
}
