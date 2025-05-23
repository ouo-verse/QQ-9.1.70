package qj3;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sj3.ZPlanReportEndTaskInfo;
import sj3.ZPlanReportStartTaskInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H&J8\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eH&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0015"}, d2 = {"Lqj3/b;", "", "Lsj3/b;", "startTaskInfo", "Lsj3/a;", "endTaskInfo", "", "a", "taskInfo", "d", "", "taskName", "featureName", AdMetricTag.EVENT_NAME, "", "params", "e", "c", "Lcom/tencent/mobileqq/tianjige/external/a;", "qqExternalSpanData", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {
    void a(@NotNull ZPlanReportStartTaskInfo startTaskInfo, @NotNull ZPlanReportEndTaskInfo endTaskInfo);

    void b(@NotNull com.tencent.mobileqq.tianjige.external.a qqExternalSpanData);

    void c(@NotNull ZPlanReportEndTaskInfo taskInfo);

    void d(@NotNull ZPlanReportStartTaskInfo taskInfo);

    void e(@NotNull String taskName, @NotNull String featureName, @NotNull String eventName, @Nullable Map<String, String> params);
}
