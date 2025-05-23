package zj3;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.raft.standard.task.IRTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lzj3/g;", "Lcom/tencent/raft/standard/task/IRTask;", "Lcom/tencent/raft/standard/task/IRTask$TaskType;", "taskType", "Lcom/tencent/raft/standard/task/IRTask$Task;", "task", "", "startTask", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g implements IRTask {
    @Override // com.tencent.raft.standard.task.IRTask
    public void startTask(IRTask.TaskType taskType, IRTask.Task task) {
        Intrinsics.checkNotNullParameter(taskType, "taskType");
        Intrinsics.checkNotNullParameter(task, "task");
        ThreadManagerV2.excute(task, 192, null, true);
    }
}
