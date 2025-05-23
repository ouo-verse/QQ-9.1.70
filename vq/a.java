package vq;

import android.app.Activity;
import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\"\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u0003\u0018\u00010\u000e\u00a8\u0006\u0013"}, d2 = {"Lvq/a;", "", "Landroid/app/Activity;", "page", "", "pageId", "", "d", "Landroid/view/View;", "view", "id", "b", "reuseId", "c", "", "map", "a", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f443174a = new a();

    a() {
    }

    public final void a(View view, Map<String, ?> map) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementParam(view, DTParamKey.REPORT_KEY_APPKEY, "0DOU0ILWXG4IHULU");
        VideoReport.reportEvent("dt_clck", view, map);
    }

    public final void b(View view, String id5) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementId(view, id5);
        VideoReport.setElementParam(view, DTParamKey.REPORT_KEY_APPKEY, "0DOU0ILWXG4IHULU");
    }

    public final void c(View view, String id5, String reuseId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(reuseId, "reuseId");
        b(view, id5);
        VideoReport.setElementReuseIdentifier(view, reuseId);
    }

    public final void d(Activity page, String pageId) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        VideoReport.addToDetectionWhitelist(page);
        VideoReport.setPageId(page, pageId);
        VideoReport.setPageParams(page, DTParamKey.REPORT_KEY_APPKEY, "0DOU0ILWXG4IHULU");
    }
}
