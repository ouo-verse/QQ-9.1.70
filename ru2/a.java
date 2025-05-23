package ru2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adexposure.QAdStandardExposureReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.ReportManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import com.tencent.qqlive.ona.protocol.jce.AdInSideVideoExposureItem;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import com.tencent.qqlive.ona.protocol.jce.AdPositionItem;
import com.tencent.qqlive.ona.protocol.jce.AdReport;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends QAdStandardExposureReportInfo {
    a(int i3, AdReport adReport, String str, String str2, String str3, String str4, AdOrderItem adOrderItem, String str5, int i16) {
        super(i3, adReport, str, str2, str3, str4, adOrderItem, str5, i16);
    }

    public static a K(AdReport adReport, AdOrderItem adOrderItem, int i3, String str, int i16) {
        String str2;
        String str3;
        String str4;
        if (adOrderItem != null && adReport != null && !TextUtils.isEmpty(adReport.url)) {
            AdInSideVideoExposureItem adInSideVideoExposureItem = adOrderItem.exposureItem;
            if (adInSideVideoExposureItem == null) {
                str2 = "";
            } else {
                str2 = adInSideVideoExposureItem.adReportKey;
            }
            if (adInSideVideoExposureItem == null) {
                str3 = "";
            } else {
                str3 = adInSideVideoExposureItem.adReportParams;
            }
            AdPositionItem adPositionItem = adOrderItem.positionItem;
            if (adPositionItem == null) {
                str4 = "";
            } else {
                str4 = adPositionItem.adSpace;
            }
            return new a(i3, adReport, adOrderItem.orderId, str4, str2, str3, adOrderItem, str, i16);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adexposure.QAdStandardExposureReportInfo, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d
    public void t(g gVar) {
        n.e("QAdSkipVideoExposureReport", "sendReport , type = " + this.f304018s);
        n.e("QAdSkipVideoExposureReport", "reportExposure url = " + q());
        ReportManager.INSTANCE.reportWithSign(this, this.f304054g, 9, gVar);
    }
}
