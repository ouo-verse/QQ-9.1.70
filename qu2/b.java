package qu2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.qqlive.ona.protocol.jce.AdOrderItem;
import hw2.f;
import java.util.Map;
import pw2.w;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    public static String a(int i3) {
        if (i3 != 1014) {
            if (i3 != 1021) {
                if (i3 != 1040) {
                    if (i3 != 5001) {
                        return null;
                    }
                    return QAdVrReport.ElementID.AD_NEGATIVE_FEEDBACK_ENTRY;
                }
                return QAdVrReport.ElementID.AD_MORE;
            }
            return QAdVrReport.ElementID.AD_ACTION_BTN;
        }
        return QAdVrReport.ElementID.AD_POSTER;
    }

    public static void b(View view, String str, Object obj) {
        if (view != null && !TextUtils.isEmpty(str) && obj != null) {
            w.h(view, str, obj);
        }
    }

    public static Map<String, String> c(Object obj) {
        return f.a(obj).a(6);
    }

    public static View d(Map<String, View> map, String str) {
        if (!y.i(map)) {
            return map.get(str);
        }
        return null;
    }

    private static QAdVrReportParams e(AdOrderItem adOrderItem) {
        Map<String, String> b16 = gw2.b.b(adOrderItem);
        QAdVrReportParams i3 = new QAdVrReportParams.a().i();
        i3.g(b16);
        return i3;
    }

    public static QAdVrReportParams f(AdOrderItem adOrderItem, View view) {
        QAdVrReportParams e16 = e(adOrderItem);
        e16.b(QAdVrReport.d(view));
        return e16;
    }
}
