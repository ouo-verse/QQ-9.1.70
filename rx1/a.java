package rx1;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    public static void a(View view, String str) {
        if (view == null) {
            return;
        }
        VideoReport.setElementId(view, str);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    public static void b(Activity activity, View view, String str, HashMap<String, Object> hashMap) {
        if (activity != null && view != null) {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(view, str);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            VideoReport.setPageParams(view, new PageParams(hashMap));
        }
    }

    public static void c(View view, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_robot_id", str);
        hashMap.put("sgrp_robot_name", str2);
        VideoReport.setElementId(view, "em_sgrp_robot_list_node");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, hashMap);
    }

    public static void d(View view, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_robot_id", str);
        hashMap.put("sgrp_robot_name", str2);
        VideoReport.setElementId(view, "em_sgrp_robot_slash_enter");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, hashMap);
    }

    public static void e(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_qqrobot_halfscreen_service");
        hashMap.put("eid", "em_qqrobot_servicetab");
        VideoReport.reportEvent("imp", view, hashMap);
    }

    public static void f(View view, int i3) {
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_service");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "qq_robot_role_type", Integer.valueOf(i3));
    }

    public static void g(View view) {
        VideoReport.setPageId(view, "pg_qqrobot_halfscreen_service");
        VideoReport.setElementId(view, "em_qqrobot_servicetab");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }
}
