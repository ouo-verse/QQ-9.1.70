package tp;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Ltp/b;", "", "", "elementId", "", "b", "", "params", "c", "d", "e", "f", "g", "Landroid/view/View;", "view", "source", "a", "", "isInPage", h.F, "Ltp/a;", "Ltp/a;", "paramBuilder", "Landroid/util/ArrayMap;", "", "Landroid/util/ArrayMap;", "exploreMap", "<init>", "()V", "qqrtc_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f437029a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final a paramBuilder = new a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ArrayMap<String, Long> exploreMap = new ArrayMap<>();

    b() {
    }

    public final void a(View view, String source) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setPageId(view, "pg_bas_robot_live_talk");
        VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_ALL);
        if (!TextUtils.isEmpty(source)) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(IFileBrowserService.FILE_BROWSER_PAGE_FROM, source));
            VideoReport.setPageParams(view, new PageParams((Map<String, ?>) mapOf));
        } else {
            QLog.e("AdelieAVDTReportUtil", 1, "initPageDT illegal error.");
        }
    }

    public final void b(String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        c(elementId, null);
    }

    public final void c(String elementId, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("dt_clck", a16);
    }

    public final void d(String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        e(elementId, null);
    }

    public final void e(String elementId, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        exploreMap.put(elementId, Long.valueOf(System.currentTimeMillis()));
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("dt_imp", a16);
    }

    public final void f(String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        g(elementId, null);
    }

    public final void g(String elementId, Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Map<String, Object> a16 = paramBuilder.a();
        a16.put("qq_eid", elementId);
        ArrayMap<String, Long> arrayMap = exploreMap;
        if (arrayMap.containsKey(elementId)) {
            Long l3 = arrayMap.get(elementId);
            Intrinsics.checkNotNull(l3);
            a16.put("qq_element_lvtm", Long.valueOf(l3.longValue() - System.currentTimeMillis()));
            arrayMap.remove(elementId);
        } else {
            a16.put("qq_element_lvtm", 0);
        }
        if (params != null) {
            a16.putAll(params);
        }
        VideoReport.reportEvent("dt_imp_end", a16);
    }

    public final void h(View view, boolean isInPage) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (isInPage) {
            VideoReport.reportPgIn(view, false);
        } else {
            VideoReport.reportPgOut(view);
        }
    }
}
