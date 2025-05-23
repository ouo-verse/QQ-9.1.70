package yi;

import kotlin.Metadata;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lyi/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "getMulti", "()Z", ProcessConstant.MULTI, "<init>", "(Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yi.l, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class MultiPayLoad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean multi;

    public MultiPayLoad(boolean z16) {
        this.multi = z16;
    }

    public int hashCode() {
        boolean z16 = this.multi;
        if (z16) {
            return 1;
        }
        return z16 ? 1 : 0;
    }

    public String toString() {
        return "MultiPayLoad(multi=" + this.multi + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MultiPayLoad) && this.multi == ((MultiPayLoad) other).multi;
    }
}
