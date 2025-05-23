package zj3;

import com.tencent.mobileqq.perf.block.ReportMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.raft.standard.report.IRReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lzj3/m;", "Lcom/tencent/raft/standard/report/IRReport;", "Lcom/tencent/raft/standard/report/BaseEvent;", "event", "", "report", "", "appId", "reportToBeacon", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class m implements IRReport {
    @Override // com.tencent.raft.standard.report.IRReport
    public boolean report(BaseEvent event) {
        if (event == null) {
            return true;
        }
        mb4.c cVar = mb4.c.f416532a;
        String key = event.getKey();
        Intrinsics.checkNotNullExpressionValue(key, "it.key");
        Map<String, String> reportParam = event.getReportParam();
        Intrinsics.checkNotNullExpressionValue(reportParam, "it.reportParam");
        mb4.c.c(cVar, key, reportParam, false, 4, null);
        return true;
    }

    @Override // com.tencent.raft.standard.report.IRReport
    public boolean reportToBeacon(String appId, BaseEvent event) {
        if (appId != null && event != null) {
            try {
                ReportMethodProxy.onUserActionToTunnel(appId, event.getKey(), event.getReportParam(), false, true);
                return true;
            } catch (Exception e16) {
                QLog.e("ZPlanResHubReportImpl", 1, e16, new Object[0]);
            }
        }
        return false;
    }
}
