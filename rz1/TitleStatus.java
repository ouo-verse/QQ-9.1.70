package rz1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lrz1/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "setStatus", "(I)V", "status", "Z", "c", "()Z", "setOrderChanged", "(Z)V", "isOrderChanged", "setCanSort", "canSort", "<init>", "(IZZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rz1.h, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class TitleStatus {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isOrderChanged;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canSort;

    public TitleStatus() {
        this(0, false, false, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCanSort() {
        return this.canSort;
    }

    /* renamed from: b, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsOrderChanged() {
        return this.isOrderChanged;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TitleStatus)) {
            return false;
        }
        TitleStatus titleStatus = (TitleStatus) other;
        if (this.status == titleStatus.status && this.isOrderChanged == titleStatus.isOrderChanged && this.canSort == titleStatus.canSort) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.status * 31;
        boolean z16 = this.isOrderChanged;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i3 + i17) * 31;
        boolean z17 = this.canSort;
        if (!z17) {
            i16 = z17 ? 1 : 0;
        }
        return i18 + i16;
    }

    @NotNull
    public String toString() {
        return "TitleStatus(status=" + this.status + ", isOrderChanged=" + this.isOrderChanged + ", canSort=" + this.canSort + ")";
    }

    public TitleStatus(int i3, boolean z16, boolean z17) {
        this.status = i3;
        this.isOrderChanged = z16;
        this.canSort = z17;
    }

    public /* synthetic */ TitleStatus(int i3, boolean z16, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 2 : i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? false : z17);
    }
}
