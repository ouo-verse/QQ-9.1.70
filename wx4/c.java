package wx4;

import com.tencent.zplan.meme.action.ActionStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0002H&J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H&R\u001c\u0010\u0016\u001a\u00020\u00118&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lwx4/c;", "", "", "portraitId", "totalFrameCount", "", "scriptStatisticData", "", "f", "Lcom/tencent/zplan/meme/action/ActionStatus;", "status", "e", "b", "path", "realFrameCount", "a", "c", "", "g", "()Z", "d", "(Z)V", "occurOOM", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface c {
    void a(int portraitId, @NotNull ActionStatus status, @NotNull String path, int realFrameCount);

    void b(int portraitId);

    void c(int portraitId, @NotNull ActionStatus status, @NotNull String path);

    void d(boolean z16);

    void e(int portraitId, @NotNull ActionStatus status, @Nullable String scriptStatisticData);

    void f(int portraitId, int totalFrameCount, @Nullable String scriptStatisticData);

    boolean g();
}
