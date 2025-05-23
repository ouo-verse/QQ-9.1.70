package vo1;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lvo1/d;", "Lvo1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", "isDashLine", "I", "()I", "lengthPx", "<init>", "(ZI)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vo1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class LineData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDashLine;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int lengthPx;

    public LineData(boolean z16, int i3) {
        this.isDashLine = z16;
        this.lengthPx = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getLengthPx() {
        return this.lengthPx;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsDashLine() {
        return this.isDashLine;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineData)) {
            return false;
        }
        LineData lineData = (LineData) other;
        if (this.isDashLine == lineData.isDashLine && this.lengthPx == lineData.lengthPx) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.isDashLine;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + this.lengthPx;
    }

    @NotNull
    public String toString() {
        return "LineData(isDashLine=" + this.isDashLine + ", lengthPx=" + this.lengthPx + ")";
    }
}
