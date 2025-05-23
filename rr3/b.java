package rr3;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "reportData", "", "a", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull ReportData reportData) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        return "?sign=" + reportData.d() + "&timestamp=" + System.currentTimeMillis() + "&nonce=" + reportData.getParams().optString(ReportDataBuilder.KEY_CLIENT_IDENTIFY, "clientidnull");
    }
}
