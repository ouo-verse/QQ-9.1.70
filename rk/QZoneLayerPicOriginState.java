package rk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lrk/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "picId", "b", "Z", "()Z", "isShowOrigin", "<init>", "(Ljava/lang/String;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rk.i, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class QZoneLayerPicOriginState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String picId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isShowOrigin;

    public QZoneLayerPicOriginState(String picId, boolean z16) {
        Intrinsics.checkNotNullParameter(picId, "picId");
        this.picId = picId;
        this.isShowOrigin = z16;
    }

    /* renamed from: a, reason: from getter */
    public final String getPicId() {
        return this.picId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsShowOrigin() {
        return this.isShowOrigin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.picId.hashCode() * 31;
        boolean z16 = this.isShowOrigin;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "QZoneLayerPicOriginState(picId=" + this.picId + ", isShowOrigin=" + this.isShowOrigin + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneLayerPicOriginState)) {
            return false;
        }
        QZoneLayerPicOriginState qZoneLayerPicOriginState = (QZoneLayerPicOriginState) other;
        return Intrinsics.areEqual(this.picId, qZoneLayerPicOriginState.picId) && this.isShowOrigin == qZoneLayerPicOriginState.isShowOrigin;
    }
}
