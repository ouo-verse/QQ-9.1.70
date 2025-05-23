package ua0;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.qqcircle.immersive.views.search.QFSVideoTaskRunner;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001c\u0010\u000b\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0003J:\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H\u0007J$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H\u0007J$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H\u0007J\u001c\u0010\u0018\u001a\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H\u0007\u00a8\u0006\u001b"}, d2 = {"Lua0/j;", "", "Lcom/tencent/mobileqq/qcircle/api/constant/QCircleAlphaUserReportDataBuilder;", "reportData", "", "", BaseConstants.ATTR_KET_EXTRA_MAP, "", "c", "g", "dtReportParams", "b", "eventCode", "a", "Lcom/tencent/biz/qqcircle/immersive/views/search/QFSVideoTaskRunner$QFSVideoTask;", "task", "i", "", "success", "", "params", "d", tl.h.F, "e", "f", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f438635a = new j();

    j() {
    }

    private final Map<String, String> a(QCircleAlphaUserReportDataBuilder reportData, String eventCode, Map<String, String> extraMap) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("eventCode", eventCode);
        linkedHashMap.put("duration", String.valueOf(reportData.timeCost));
        String str = reportData.svrRetCode;
        if (str == null) {
            str = "0";
        }
        linkedHashMap.put("errorCode", str);
        String str2 = reportData.cmd;
        String str3 = "";
        if (str2 == null) {
            str2 = "";
        }
        linkedHashMap.put("name", str2);
        String str4 = reportData.user;
        if (str4 != null) {
            str3 = str4;
        }
        linkedHashMap.put("uin", str3);
        if (extraMap != null && (!extraMap.isEmpty())) {
            linkedHashMap.putAll(extraMap);
        }
        return linkedHashMap;
    }

    @JvmStatic
    private static final void b(Map<String, String> dtReportParams) {
        String str;
        String remove = dtReportParams.remove("eventCode");
        if (remove == null) {
            remove = "";
        }
        String remove2 = dtReportParams.remove("uin");
        if (remove2 == null) {
            str = "";
        } else {
            str = remove2;
        }
        if (!TextUtils.isEmpty(remove)) {
            QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", str, remove, true, dtReportParams, true);
        }
        if (QLog.isColorLevel()) {
            QLog.i("QFSSearchPerformanceReporter", 2, remove + " baseReport data:" + dtReportParams);
        }
    }

    @JvmStatic
    public static final void c(@NotNull QCircleAlphaUserReportDataBuilder reportData, @Nullable Map<String, String> extraMap) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        b(f438635a.a(reportData, "qfs_search_request_quality", extraMap));
    }

    @JvmStatic
    public static final void d(boolean success, @NotNull Map<String, String> params) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(params, "params");
        String currentAccount = QCircleHostStubUtil.getCurrentAccount();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("uin", currentAccount));
        mutableMapOf.putAll(params);
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentAccount, "favorite_search_cost", success, mutableMapOf, true);
    }

    @JvmStatic
    public static final void e(boolean success, @NotNull Map<String, String> params) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(params, "params");
        String currentAccount = QCircleHostStubUtil.getCurrentAccount();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("uin", currentAccount));
        mutableMapOf.putAll(params);
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentAccount, "search_page_first_frame_perf", success, mutableMapOf, true);
    }

    @JvmStatic
    public static final void f(@NotNull Map<String, String> params) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(params, "params");
        String currentAccount = QCircleHostStubUtil.getCurrentAccount();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("uin", currentAccount));
        mutableMapOf.putAll(params);
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentAccount, "search_engine_step_cost", true, mutableMapOf, true);
    }

    @JvmStatic
    public static final void g(@NotNull QCircleAlphaUserReportDataBuilder reportData) {
        Intrinsics.checkNotNullParameter(reportData, "reportData");
        b(f438635a.a(reportData, "unify_search_request_quality", null));
    }

    @JvmStatic
    public static final void h(boolean success, @NotNull Map<String, String> params) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(params, "params");
        String currentAccount = QCircleHostStubUtil.getCurrentAccount();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("uin", currentAccount));
        mutableMapOf.putAll(params);
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentAccount, "qfs_search_result_video_time", success, mutableMapOf, true);
    }

    @JvmStatic
    public static final void i(@NotNull QFSVideoTaskRunner.QFSVideoTask task) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(task, "task");
        String currentAccount = QCircleHostStubUtil.getCurrentAccount();
        long j3 = task.f91066f;
        long j16 = task.f91065e;
        long j17 = task.f91067h;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("uin", currentAccount), TuplesKt.to("tag", task.f91064d), TuplesKt.to("state", String.valueOf(task.f91068i)), TuplesKt.to("errorMessage", task.f91069m), TuplesKt.to(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, String.valueOf(j3 - j16)), TuplesKt.to("executeTime", String.valueOf(j17 - j3)), TuplesKt.to("totalTime", String.valueOf(j17 - j16)));
        QQBeaconReport.reportWithAppKey("0DOU0TYBSY4OEY1K", currentAccount, "qfs_search_result_video_event_queue", task.e(), mapOf, true);
    }
}
