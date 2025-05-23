package th4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lth4/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSelfOnMic", "Lth4/a;", "b", "Lth4/a;", "()Lth4/a;", "pendingTask", "", "J", "()J", "roomId", "<init>", "(ZLth4/a;J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: th4.m, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class HallLeaveParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSelfOnMic;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final a pendingTask;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    public HallLeaveParam(boolean z16, @NotNull a pendingTask, long j3) {
        Intrinsics.checkNotNullParameter(pendingTask, "pendingTask");
        this.isSelfOnMic = z16;
        this.pendingTask = pendingTask;
        this.roomId = j3;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final a getPendingTask() {
        return this.pendingTask;
    }

    /* renamed from: b, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSelfOnMic() {
        return this.isSelfOnMic;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HallLeaveParam)) {
            return false;
        }
        HallLeaveParam hallLeaveParam = (HallLeaveParam) other;
        if (this.isSelfOnMic == hallLeaveParam.isSelfOnMic && Intrinsics.areEqual(this.pendingTask, hallLeaveParam.pendingTask) && this.roomId == hallLeaveParam.roomId) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.isSelfOnMic;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (((r06 * 31) + this.pendingTask.hashCode()) * 31) + androidx.fragment.app.a.a(this.roomId);
    }

    @NotNull
    public String toString() {
        return "HallLeaveParam(isSelfOnMic=" + this.isSelfOnMic + ", pendingTask=" + this.pendingTask + ", roomId=" + this.roomId + ")";
    }
}
