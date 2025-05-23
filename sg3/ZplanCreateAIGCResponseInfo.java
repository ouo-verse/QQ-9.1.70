package sg3;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lsg3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "couponCount", "b", "Z", "getResult", "()Z", "setResult", "(Z)V", "result", "<init>", "(IZ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sg3.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZplanCreateAIGCResponseInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int couponCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean result;

    public ZplanCreateAIGCResponseInfo(int i3, boolean z16) {
        this.couponCount = i3;
        this.result = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getCouponCount() {
        return this.couponCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3 = this.couponCount * 31;
        boolean z16 = this.result;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        return i3 + i16;
    }

    public String toString() {
        return "ZplanCreateAIGCResponseInfo(couponCount=" + this.couponCount + ", result=" + this.result + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZplanCreateAIGCResponseInfo)) {
            return false;
        }
        ZplanCreateAIGCResponseInfo zplanCreateAIGCResponseInfo = (ZplanCreateAIGCResponseInfo) other;
        return this.couponCount == zplanCreateAIGCResponseInfo.couponCount && this.result == zplanCreateAIGCResponseInfo.result;
    }
}
