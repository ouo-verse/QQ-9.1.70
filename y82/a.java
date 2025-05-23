package y82;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* compiled from: P */
    /* renamed from: y82.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    private static class C11595a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f449554a = new a();
    }

    a() {
    }

    private void a(View view, String str, String str2, Map<String, ?> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent(str2, view, map);
    }

    public static a b() {
        return C11595a.f449554a;
    }

    public void c(Activity activity, View view, String str, PageParams pageParams) {
        VideoReport.addToDetectionWhitelist(activity);
        VideoReport.setPageId(view, str);
        VideoReport.setPageParams(view, pageParams);
    }

    public void d(View view, String str) {
        a(view, str, "dt_clck", null);
    }

    public void e(View view, String str, Map<String, ?> map) {
        a(view, str, "dt_clck", map);
    }

    public void f(View view, String str) {
        a(view, str, "dt_imp", null);
    }

    public void g(View view, String str, Map<String, ?> map) {
        a(view, str, "dt_imp", map);
    }
}
