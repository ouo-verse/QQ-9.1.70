package zd3;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012\u00a8\u0006\u0017"}, d2 = {"Lzd3/d;", "", "Landroid/view/View;", "view", "", "elementId", "", "params", "", "needReportImp", "needReportImpEnd", "needReportClick", "", "c", "source", "g", "", "payNum", "", "payPrice", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f452376a = new d();

    d() {
    }

    private final void c(final View view, final String elementId, final Map<String, ? extends Object> params, final boolean needReportImp, final boolean needReportImpEnd, final boolean needReportClick) {
        ThreadManagerV2.excute(new Runnable() { // from class: zd3.c
            @Override // java.lang.Runnable
            public final void run() {
                d.d(view, elementId, params, needReportImp, needReportClick, needReportImpEnd);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view, String elementId, Map map, boolean z16, boolean z17, boolean z18) {
        ExposurePolicy exposurePolicy;
        ClickPolicy clickPolicy;
        EndExposurePolicy endExposurePolicy;
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        VideoReport.setElementId(view, elementId);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
        if (z16) {
            exposurePolicy = ExposurePolicy.REPORT_ALL;
        } else {
            exposurePolicy = ExposurePolicy.REPORT_NONE;
        }
        if (z17) {
            clickPolicy = ClickPolicy.REPORT_ALL;
        } else {
            clickPolicy = ClickPolicy.REPORT_NONE;
        }
        if (z18) {
            endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        } else {
            endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        }
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementEndExposePolicy(view, endExposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, HashMap params) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(params, "$params");
        VideoReport.setElementId(view, "em_zplan_pay_btn");
        VideoReport.reportEvent("dt_clck", view, params);
    }

    public final void e(final View view, long payNum, int payPrice) {
        final HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_pay_num", Integer.valueOf((int) payNum)), TuplesKt.to("zplan_pay_price", Integer.valueOf(payPrice)));
        ThreadManagerV2.excute(new Runnable() { // from class: zd3.b
            @Override // java.lang.Runnable
            public final void run() {
                d.f(view, hashMapOf);
            }
        }, 16, null, false);
    }

    public final void g(View view, String source) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        int i3 = 2;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        if (Intrinsics.areEqual(source, "source_pop_tip")) {
            i3 = 1;
        } else if (!Intrinsics.areEqual(source, "source_add_btn")) {
            i3 = 0;
        }
        pairArr[1] = TuplesKt.to("zplan_panel_imp_source", Integer.valueOf(i3));
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        c(view, "em_zplan_pay_panel", hashMapOf, true, true, false);
    }
}
