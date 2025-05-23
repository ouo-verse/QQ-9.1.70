package so2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.trpcprotocol.unite.unifysearch.head_template.HeadTemplatePB$ReportInfo;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    public static void a(View view, HeadTemplatePB$ReportInfo headTemplatePB$ReportInfo, int i3) {
        b(view, headTemplatePB$ReportInfo, i3, true);
    }

    public static void b(View view, HeadTemplatePB$ReportInfo headTemplatePB$ReportInfo, int i3, boolean z16) {
        ClickPolicy clickPolicy;
        if (headTemplatePB$ReportInfo != null && !headTemplatePB$ReportInfo.eid.get().isEmpty()) {
            QLog.e("QCircleSearchGameUnionReportUtil", 1, "report eid: " + headTemplatePB$ReportInfo.eid.get() + "    view.class: " + view.getClass().getName() + "  includeClick:" + z16);
            VideoReport.setElementId(view, headTemplatePB$ReportInfo.eid.get());
            VideoReport.setElementReuseIdentifier(view, String.valueOf(headTemplatePB$ReportInfo.hashCode()));
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
            if (z16) {
                clickPolicy = ClickPolicy.REPORT_ALL;
            } else {
                clickPolicy = ClickPolicy.REPORT_NONE;
            }
            VideoReport.setElementClickPolicy(view, clickPolicy);
            String str = headTemplatePB$ReportInfo.report_info.get();
            if (str.isEmpty()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                HashMap hashMap = new HashMap();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    String optString = jSONObject.optString(str2);
                    if (TextUtils.isEmpty(optString)) {
                        QLog.d("QCircleSearchGameUnionReportUtil", 1, "#report: key=" + str2 + ", value is empty");
                    } else {
                        hashMap.put(str2, optString);
                    }
                }
                if (!hashMap.isEmpty()) {
                    VideoReport.setElementParams(view, hashMap);
                }
                if (i3 >= 0) {
                    VideoReport.setElementParam(view, "serial_number", String.valueOf(i3));
                }
            } catch (JSONException e16) {
                QLog.e("QCircleSearchGameUnionReportUtil", 1, e16, new Object[0]);
            }
        }
    }
}
