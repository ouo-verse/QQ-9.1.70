package sf3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pv4.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lsf3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lpv4/q;", "a", "Lpv4/q;", "()Lpv4/q;", "littleModule", "b", "Z", "()Z", "c", "(Z)V", "isItemSelected", "<init>", "(Lpv4/q;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sf3.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZplanBannerIndicatorBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final q littleModule;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isItemSelected;

    public ZplanBannerIndicatorBean(q qVar, boolean z16) {
        this.littleModule = qVar;
        this.isItemSelected = z16;
    }

    /* renamed from: a, reason: from getter */
    public final q getLittleModule() {
        return this.littleModule;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsItemSelected() {
        return this.isItemSelected;
    }

    public final void c(boolean z16) {
        this.isItemSelected = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        q qVar = this.littleModule;
        int hashCode = (qVar == null ? 0 : qVar.hashCode()) * 31;
        boolean z16 = this.isItemSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ZplanBannerIndicatorBean(littleModule=" + this.littleModule + ", isItemSelected=" + this.isItemSelected + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZplanBannerIndicatorBean)) {
            return false;
        }
        ZplanBannerIndicatorBean zplanBannerIndicatorBean = (ZplanBannerIndicatorBean) other;
        return Intrinsics.areEqual(this.littleModule, zplanBannerIndicatorBean.littleModule) && this.isItemSelected == zplanBannerIndicatorBean.isItemSelected;
    }
}
