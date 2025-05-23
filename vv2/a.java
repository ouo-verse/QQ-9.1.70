package vv2;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.Map;
import pw2.w;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static VideoReportInfo a(View view, QAdVrReportParams qAdVrReportParams) {
        if (view == null) {
            return null;
        }
        Map<String, Object> g16 = w.g(view);
        VideoReportInfo videoReportInfo = new VideoReportInfo();
        if (qAdVrReportParams != null) {
            g16 = qAdVrReportParams.i().h(g16).i().h();
        }
        videoReportInfo.setClickReportParams(g16);
        return videoReportInfo;
    }

    public static void b(View view, Object obj, String str, @QAdVrReport.ReportPolicy int i3, Map<String, Object> map) {
        if (view != null && obj != null) {
            QAdVrReportParams qAdVrReportParams = new QAdVrReportParams();
            qAdVrReportParams.g(map);
            c(view, qAdVrReportParams, str, i3);
        }
    }

    private static void c(View view, QAdVrReportParams qAdVrReportParams, @QAdVrReport.ElementID String str, @QAdVrReport.ReportPolicy int i3) {
        if (view != null && qAdVrReportParams != null) {
            QAdVrReport.a(i3, view, str, qAdVrReportParams.h());
        }
    }
}
