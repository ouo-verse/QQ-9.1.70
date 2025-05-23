package qu2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParamKey;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdOfflineInfo;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPageInfo;
import com.tencent.qqlive.ona.protocol.jce.AdVideoInfo;
import com.tencent.qqlive.ona.protocol.jce.AdVideoItem;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static HashMap<String, String> a(ju2.a aVar) {
        return b(aVar, false);
    }

    public static HashMap<String, String> b(ju2.a aVar, boolean z16) {
        int i3;
        AdOfflineInfo adOfflineInfo;
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (aVar == null) {
            return hashMap;
        }
        hashMap.put("startTime", String.valueOf(System.currentTimeMillis()));
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, d(aVar.f410959a));
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, String.valueOf(aVar.f410960b));
        AdPageInfo adPageInfo = aVar.f410965g;
        if (adPageInfo != null) {
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_FLOW_ID, d(adPageInfo.flowId));
        }
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_NEW_NET_TYPE, String.valueOf(c()));
        AdVideoInfo adVideoInfo = aVar.f410963e;
        if (adVideoInfo != null) {
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_VIDOE_TYPE, String.valueOf(adVideoInfo.isLive));
            hashMap.put("pid", d(adVideoInfo.livepId));
            hashMap.put("lid", d(adVideoInfo.lid));
            hashMap.put("coverId", d(adVideoInfo.coverId));
            hashMap.put("vid", d(adVideoInfo.vid));
            hashMap.put("previd", d(adVideoInfo.preVid));
        }
        AdPageInfo adPageInfo2 = aVar.f410965g;
        if (adPageInfo2 != null) {
            if (adPageInfo2.adPlayMode == 3) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("offline", str);
            hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, d(aVar.f410965g.reportKey));
        }
        if (!z16 && ((adOfflineInfo = aVar.f410966h) == null || adOfflineInfo.offlineVideoType != 3)) {
            if (aVar.f410970l) {
                i3 = 2;
            } else {
                i3 = 0;
            }
        } else {
            i3 = 1;
        }
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PRELOAD_AD_TYPE, String.valueOf(i3));
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, String.valueOf(aVar.f410962d));
        return hashMap;
    }

    private static int c() {
        String j3 = QAdDeviceUtils.j();
        if (TextUtils.isEmpty(j3)) {
            return 0;
        }
        j3.hashCode();
        char c16 = '\uffff';
        switch (j3.hashCode()) {
            case 1653:
                if (j3.equals(QADNetStatus.G_2)) {
                    c16 = 0;
                    break;
                }
                break;
            case 1684:
                if (j3.equals(QADNetStatus.G_3)) {
                    c16 = 1;
                    break;
                }
                break;
            case 1715:
                if (j3.equals(QADNetStatus.G_4)) {
                    c16 = 2;
                    break;
                }
                break;
            case 1746:
                if (j3.equals(QADNetStatus.G_5)) {
                    c16 = 3;
                    break;
                }
                break;
            case 3649301:
                if (j3.equals("wifi")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 5;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    private static String d(String str) {
        if (str != null && !"null".equals(str)) {
            return str;
        }
        return "";
    }

    public static HashMap<String, String> e(c cVar) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (cVar == null) {
            return hashMap;
        }
        AdInsideVideoItem adInsideVideoItem = cVar.f303589a;
        if (adInsideVideoItem != null) {
            AdOrderItem adOrderItem = adInsideVideoItem.orderItem;
            if (adOrderItem != null) {
                AdInSideVideoExposureItem adInSideVideoExposureItem = adOrderItem.exposureItem;
                String str2 = "";
                if (adInSideVideoExposureItem == null) {
                    str = "";
                } else {
                    str = adInSideVideoExposureItem.adReportParams;
                }
                if (adInSideVideoExposureItem != null) {
                    str2 = adInSideVideoExposureItem.adReportKey;
                }
                hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAM, str);
                hashMap.put(QAdReportDefine$AdReporterParamKey.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, str2);
                hashMap.put("adId", d(cVar.f303589a.orderItem.orderId));
            }
            AdVideoItem adVideoItem = cVar.f303589a.videoItem;
            if (adVideoItem != null) {
                hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLIP_DURATION, String.valueOf(adVideoItem.duration));
            }
        }
        hashMap.put("index", String.valueOf(cVar.f303593e));
        return hashMap;
    }
}
