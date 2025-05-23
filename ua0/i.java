package ua0;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class i {
    private static Map<String, Object> d(Map<String, Object> map) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
        if (map != null) {
            buildElementParams.putAll(map);
        }
        return buildElementParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(String str, View view, Map map) {
        VideoReport.reportEvent(str, view, d(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Activity activity, View view, String str, Map map) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, new QCircleDTParamBuilder().buildPageParams("QFSSearchFragment", map));
        VideoReport.setElementDynamicParams(view, new QCircleDTParamBuilder().buildElementDynamicParams());
        VideoReport.setEventDynamicParams(view, new QCircleDTParamBuilder().buildDynamicParams());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(View view, String str, int i3, Map map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementReuseIdentifier(view, str + "_" + i3);
        VideoReport.setElementParams(view, d(map));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    public static void h(final View view, final String str, final Map<String, Object> map) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: ua0.g
            @Override // java.lang.Runnable
            public final void run() {
                i.e(str, view, map);
            }
        });
    }

    public static void i(final Activity activity, final View view, final String str, final Map<String, Object> map) {
        if (view == null) {
            return;
        }
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: ua0.h
            @Override // java.lang.Runnable
            public final void run() {
                i.f(activity, view, str, map);
            }
        });
    }

    public static void j(View view, String str, Map<String, Object> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementParams(view, d(map));
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    public static void k(final View view, final String str, final Map<String, Object> map, final int i3) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: ua0.f
            @Override // java.lang.Runnable
            public final void run() {
                i.g(view, str, i3, map);
            }
        });
    }

    public static String l(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return "follow";
                }
                return QCircleDaTongConstant.ElementParamValue.MUTUAL;
            }
            return QCircleDaTongConstant.ElementParamValue.FOLLOWBACK;
        }
        return QCircleDaTongConstant.ElementParamValue.FOLLOWED;
    }
}
