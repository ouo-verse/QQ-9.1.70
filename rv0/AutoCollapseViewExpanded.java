package rv0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lrv0/a;", "Lg32/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "c", "J", "getRoomId", "()J", "roomId", "d", "Z", "()Z", "expand", "<init>", "(JZ)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rv0.a, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class AutoCollapseViewExpanded extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long roomId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean expand;

    public AutoCollapseViewExpanded(long j3, boolean z16) {
        this.roomId = j3;
        this.expand = z16;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getExpand() {
        return this.expand;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoCollapseViewExpanded)) {
            return false;
        }
        AutoCollapseViewExpanded autoCollapseViewExpanded = (AutoCollapseViewExpanded) other;
        if (this.roomId == autoCollapseViewExpanded.roomId && this.expand == autoCollapseViewExpanded.expand) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = androidx.fragment.app.a.a(this.roomId) * 31;
        boolean z16 = this.expand;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    @NotNull
    public String toString() {
        return "AutoCollapseViewExpanded(roomId=" + this.roomId + ", expand=" + this.expand + ")";
    }
}
