package w72;

import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0007\u001a*\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u00a8\u0006\r"}, d2 = {"Landroid/view/View;", "", "name", "c", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", "policy", "d", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "f", "elementId", "", "params", "a", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final View a(View view, String elementId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        VideoReport.reportEvent("dt_clck", view, map);
        return view;
    }

    public static final View c(View view, String name) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        VideoReport.setElementId(view, name);
        return view;
    }

    public static final View d(View view, ClickPolicy policy) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(policy, "policy");
        VideoReport.setElementClickPolicy(view, policy);
        return view;
    }

    public static final View f(View view, ExposurePolicy policy) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(policy, "policy");
        VideoReport.setElementExposePolicy(view, policy);
        return view;
    }

    public static /* synthetic */ View e(View view, ClickPolicy clickPolicy, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            clickPolicy = ClickPolicy.REPORT_ALL;
        }
        return d(view, clickPolicy);
    }

    public static /* synthetic */ View g(View view, ExposurePolicy exposurePolicy, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            exposurePolicy = ExposurePolicy.REPORT_FIRST;
        }
        return f(view, exposurePolicy);
    }

    public static /* synthetic */ View b(View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        return a(view, str, map);
    }
}
