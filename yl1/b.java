package yl1;

import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ2\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006J2\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006J.\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006J.\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u00a8\u0006\u0010"}, d2 = {"Lyl1/b;", "", "Landroid/view/View;", "view", "", "id", "", "params", "", "a", "c", "elemId", "e", "g", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f450589a = new b();

    b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(b bVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        bVar.a(view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(b bVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        bVar.c(view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(b bVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        bVar.e(view, str, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(b bVar, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        bVar.g(view, str, map);
    }

    public final void a(@NotNull View view, @NotNull String id5, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(view, id5);
        VideoReport.setElementParams(view, params);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public final void c(@NotNull View view, @NotNull String id5, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(view, id5);
        VideoReport.setElementParams(view, params);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    public final void e(@NotNull View view, @NotNull String elemId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        VideoReport.setElementId(view, elemId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, params);
    }

    public final void g(@NotNull View view, @NotNull String elemId, @Nullable Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elemId, "elemId");
        VideoReport.setElementId(view, elemId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", view, params);
    }
}
