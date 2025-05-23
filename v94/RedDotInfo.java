package v94;

import com.tencent.sqshow.zootopia.nativeui.data.reddot.DotTreeLevel;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lv94/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getRedDotId", "()I", "redDotId", "b", "getFirstType", "firstType", "<init>", "(II)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: v94.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class RedDotInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int redDotId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int firstType;

    public RedDotInfo(int i3, @DotTreeLevel int i16) {
        this.redDotId = i3;
        this.firstType = i16;
    }

    public int hashCode() {
        return (this.redDotId * 31) + this.firstType;
    }

    public String toString() {
        return "RedDotInfo(redDotId=" + this.redDotId + ", firstType=" + this.firstType + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedDotInfo)) {
            return false;
        }
        RedDotInfo redDotInfo = (RedDotInfo) other;
        return this.redDotId == redDotInfo.redDotId && this.firstType == redDotInfo.firstType;
    }
}
