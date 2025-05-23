package rp2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lrp2/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tabName", "", "J", "()J", "tabMask", "<init>", "(Ljava/lang/String;J)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rp2.d, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class UnifySearchTabInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long tabMask;

    public UnifySearchTabInfo(@NotNull String tabName, long j3) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        this.tabName = tabName;
        this.tabMask = j3;
    }

    /* renamed from: a, reason: from getter */
    public final long getTabMask() {
        return this.tabMask;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTabName() {
        return this.tabName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnifySearchTabInfo)) {
            return false;
        }
        UnifySearchTabInfo unifySearchTabInfo = (UnifySearchTabInfo) other;
        if (Intrinsics.areEqual(this.tabName, unifySearchTabInfo.tabName) && this.tabMask == unifySearchTabInfo.tabMask) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.tabName.hashCode() * 31) + androidx.fragment.app.a.a(this.tabMask);
    }

    @NotNull
    public String toString() {
        return "UnifySearchTabInfo(tabName=" + this.tabName + ", tabMask=" + this.tabMask + ")";
    }
}
