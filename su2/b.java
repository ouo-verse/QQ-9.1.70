package su2;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.qqlive.ona.protocol.jce.AdInSideExtraReportItem;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    private static Map<String, String> a(tu2.a aVar) {
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    private static Map<String, String> b(tu2.a aVar) {
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public static String c(tu2.a aVar) {
        Map<String, String> b16 = b(aVar);
        if (b16 != null) {
            return b16.get("channelId");
        }
        return "";
    }

    public static String d(tu2.a aVar) {
        if (aVar != null) {
            return aVar.c();
        }
        return "";
    }

    private static AdReport e(AdInsideVideoItem adInsideVideoItem) {
        AdOrderItem adOrderItem;
        AdInSideVideoExposureItem adInSideVideoExposureItem;
        AdReport adReport;
        if (adInsideVideoItem != null && (adOrderItem = adInsideVideoItem.orderItem) != null && (adInSideVideoExposureItem = adOrderItem.exposureItem) != null) {
            AdReport adReport2 = adInSideVideoExposureItem.emptyReport;
            if (adReport2 != null && !TextUtils.isEmpty(adReport2.url)) {
                return adReport2;
            }
            ArrayList<AdReport> arrayList = adInsideVideoItem.orderItem.exposureItem.originExposureReportList;
            if (y.h(arrayList) || !o(adInsideVideoItem) || (adReport = arrayList.get(0)) == null || TextUtils.isEmpty(adReport.url)) {
                return null;
            }
            return adReport;
        }
        n.a("PreAdFunnelReportUtils", "report item is null");
        return null;
    }

    public static String f(tu2.a aVar) {
        Map<String, String> a16 = a(aVar);
        if (a16 != null) {
            return a16.get("lid");
        }
        return "";
    }

    public static String g(tu2.a aVar) {
        Map<String, String> b16 = b(aVar);
        if (b16 != null) {
            return b16.get("page");
        }
        return "";
    }

    public static String h(tu2.a aVar) {
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public static int i(tu2.b bVar) {
        boolean z16;
        if (bVar == null) {
            return -1;
        }
        if (TextUtils.isEmpty(bVar.a()) && TextUtils.isEmpty(bVar.b())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        if (!bVar.c()) {
            return 1;
        }
        return 2;
    }

    public static String j(tu2.a aVar) {
        Map<String, String> a16 = a(aVar);
        if (a16 != null) {
            return a16.get(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY);
        }
        return "";
    }

    public static String k(tu2.a aVar) {
        Map<String, String> b16 = b(aVar);
        if (b16 != null) {
            return b16.get("style");
        }
        return "";
    }

    public static String l(tu2.a aVar) {
        Map<String, String> b16 = b(aVar);
        if (b16 != null) {
            return b16.get("lid");
        }
        return "";
    }

    public static String m(tu2.a aVar) {
        if (aVar != null) {
            return aVar.f();
        }
        return "";
    }

    public static boolean n(tu2.a aVar) {
        if (aVar != null && aVar.d() == 1) {
            return true;
        }
        return false;
    }

    private static boolean o(AdInsideVideoItem adInsideVideoItem) {
        AdInSideExtraReportItem adInSideExtraReportItem;
        if (adInsideVideoItem != null && (adInSideExtraReportItem = adInsideVideoItem.extraReportItem) != null && !adInSideExtraReportItem.needFunnelReport) {
            return false;
        }
        return true;
    }

    private static String p(String str, String str2, String str3) {
        String str4;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int indexOf = str.indexOf("&l=");
            if (indexOf < 0) {
                indexOf = str.indexOf("?l=");
            }
            if (indexOf < 0) {
                if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                    str4 = str + "&l=" + str2;
                } else {
                    str4 = str + "?l=" + str2;
                }
            } else {
                int indexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER, indexOf + 1);
                if (indexOf2 < 0) {
                    return str.substring(0, indexOf + 3) + str2;
                }
                str4 = str.substring(0, indexOf + 3) + str2 + str.substring(indexOf2);
            }
            return str4.replace("__ENCRYPT_DATA__", nv2.a.a(str3)).replace("__EXPOSURE_TIME__", "0");
        }
        return str;
    }

    public static void q(AdInsideVideoItem adInsideVideoItem, int i3, String str) {
        AdReport e16 = e(adInsideVideoItem);
        if (e16 != null && !TextUtils.isEmpty(e16.url)) {
            String p16 = p(e16.url, String.valueOf(i3), str);
            HashMap hashMap = new HashMap();
            hashMap.put("step", "200");
            a aVar = new a(p16, e16.reportKey, e16.reportParam, hashMap);
            String q16 = aVar.q();
            if (!TextUtils.isEmpty(q16)) {
                n.a("PreAdFunnelReportUtils", "send Step 200 funnel report. url=" + q16);
                aVar.t(null);
                return;
            }
            return;
        }
        n.a("PreAdFunnelReportUtils", "adReport is null or adReport.url is empty.");
    }

    public static void r(iu2.a aVar, tu2.a aVar2, tu2.b bVar, String str, String str2, String str3, String str4, String str5) {
        String str6;
        if (aVar == null) {
            return;
        }
        int a16 = aVar.a();
        String valueOf = String.valueOf(i(bVar));
        String f16 = f(aVar2);
        String o16 = QAdDeviceUtils.o();
        String m3 = m(aVar2);
        String h16 = h(aVar2);
        if (n(aVar2)) {
            str6 = "1";
        } else {
            str6 = "0";
        }
        String c16 = c(aVar2);
        String l3 = l(aVar2);
        String v3 = QAdDeviceUtils.v();
        String valueOf2 = String.valueOf(QAdDeviceUtils.s());
        String valueOf3 = String.valueOf(a16);
        String a17 = ov2.a.b().a();
        String d16 = d(aVar2);
        if (TextUtils.equals(f16, d16)) {
            d16 = "";
        }
        String r16 = QAdDeviceUtils.r();
        String a18 = lv2.a.b().a();
        String k3 = k(aVar2);
        String g16 = g(aVar2);
        String j3 = j(aVar2);
        String a19 = nv2.a.a(str2);
        HashMap hashMap = new HashMap();
        hashMap.put("platform", "10303");
        hashMap.put("device", valueOf2);
        hashMap.put("defn", str);
        hashMap.put("clip", "1");
        hashMap.put(AdParam.DTYPE, "1");
        hashMap.put("ad_type", str5);
        hashMap.put("sdtfrom", "v5004");
        hashMap.put(AdParam.PU, valueOf);
        hashMap.put("lid", f16);
        hashMap.put(AdParam.OPENUDID, o16);
        hashMap.put("vid", m3);
        hashMap.put("offline", str4);
        hashMap.put("previd", h16);
        hashMap.put("live", str6);
        hashMap.put("channelId", c16);
        hashMap.put(AdParam.TPID, l3);
        hashMap.put("appversion", v3);
        hashMap.put("l", valueOf3);
        hashMap.put("newnettype", str3);
        hashMap.put("chid", a17);
        hashMap.put(AdParam.COVERID, d16);
        hashMap.put(AdParam.PF, r16);
        hashMap.put("guid", a18);
        hashMap.put("style", k3);
        hashMap.put("page", g16);
        hashMap.put("requestid", str2);
        hashMap.put("data", a19);
        hashMap.put(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_KEY, j3);
        hashMap.put("step", "100");
        a aVar3 = new a("", j3, null, hashMap);
        String q16 = aVar3.q();
        if (!TextUtils.isEmpty(q16)) {
            n.a("PreAdFunnelReportUtils", "send Step 100 funnel report. url=" + q16);
            aVar3.t(null);
        }
    }
}
