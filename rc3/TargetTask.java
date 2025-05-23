package rc3;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.minors.util.LoadingDialogHelperFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lrc3/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Runnable;", "a", "Ljava/lang/Runnable;", "c", "()Ljava/lang/Runnable;", "setTask", "(Ljava/lang/Runnable;)V", "task", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "<init>", "(Ljava/lang/Runnable;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rc3.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class TargetTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private Runnable task;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String taskId;

    public TargetTask() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: c, reason: from getter */
    public final Runnable getTask() {
        return this.task;
    }

    /* renamed from: d, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        return (this.task.hashCode() * 31) + this.taskId.hashCode();
    }

    public String toString() {
        return "TargetTask(task=" + this.task + ", taskId=" + this.taskId + ")";
    }

    public TargetTask(Runnable task, String taskId) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        this.task = task;
        this.taskId = taskId;
    }

    public /* synthetic */ TargetTask(Runnable runnable, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new Runnable() { // from class: rc3.b
            @Override // java.lang.Runnable
            public final void run() {
                TargetTask.b();
            }
        } : runnable, (i3 & 2) != 0 ? LoadingDialogHelperFragment.INSTANCE.c() : str);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TargetTask)) {
            return false;
        }
        TargetTask targetTask = (TargetTask) other;
        return Intrinsics.areEqual(this.task, targetTask.task) && Intrinsics.areEqual(this.taskId, targetTask.taskId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b() {
    }
}
