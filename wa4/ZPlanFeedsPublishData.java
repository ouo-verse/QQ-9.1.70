package wa4;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lwa4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getTaskId", "()J", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "b", "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "getTaskInfo", "()Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "taskInfo", "c", "Z", "isFinalSuccess", "()Z", "<init>", "(JLcom/tencent/mobileqq/winkpublish/TaskInfo;Z)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wa4.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZPlanFeedsPublishData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final TaskInfo taskInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isFinalSuccess;

    public ZPlanFeedsPublishData(long j3, TaskInfo taskInfo, boolean z16) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        this.taskId = j3;
        this.taskInfo = taskInfo;
        this.isFinalSuccess = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((com.tencent.mobileqq.vas.banner.c.a(this.taskId) * 31) + this.taskInfo.hashCode()) * 31;
        boolean z16 = this.isFinalSuccess;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    public String toString() {
        return "ZPlanFeedsPublishData(taskId=" + this.taskId + ", taskInfo=" + this.taskInfo + ", isFinalSuccess=" + this.isFinalSuccess + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanFeedsPublishData)) {
            return false;
        }
        ZPlanFeedsPublishData zPlanFeedsPublishData = (ZPlanFeedsPublishData) other;
        return this.taskId == zPlanFeedsPublishData.taskId && Intrinsics.areEqual(this.taskInfo, zPlanFeedsPublishData.taskInfo) && this.isFinalSuccess == zPlanFeedsPublishData.isFinalSuccess;
    }
}
