package wv3;

import com.tencent.qqnt.avatar.meta.task.RunnableTask;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lwv3/a;", "", "Lcom/tencent/qqnt/avatar/meta/task/RunnableTask;", "runnableTask", "", "b", "", "key", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: wv3.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static final class C11512a {
        public static /* synthetic */ void a(a aVar, RunnableTask runnableTask, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    runnableTask = null;
                }
                aVar.b(runnableTask);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPending");
        }
    }

    void a(@NotNull String key);

    void b(@Nullable RunnableTask runnableTask);
}
