package wf2;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\r\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0004\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0013\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lwf2/a;", "T", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "Ljava/util/List;", "()Ljava/util/List;", "resultList", "b", "Z", "c", "()Z", "isSucceed", "isEnd", "<init>", "(Ljava/util/List;ZZ)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wf2.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class NetworkResult<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<T> resultList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSucceed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnd;

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkResult(List<? extends T> resultList, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        this.resultList = resultList;
        this.isSucceed = z16;
        this.isEnd = z17;
    }

    public final List<T> a() {
        return this.resultList;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsEnd() {
        return this.isEnd;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSucceed() {
        return this.isSucceed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.resultList.hashCode() * 31;
        boolean z16 = this.isSucceed;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        boolean z17 = this.isEnd;
        return i16 + (z17 ? 1 : z17 ? 1 : 0);
    }

    public String toString() {
        return "NetworkResult(resultList=" + this.resultList + ", isSucceed=" + this.isSucceed + ", isEnd=" + this.isEnd + ")";
    }

    public /* synthetic */ NetworkResult(List list, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z16, (i3 & 4) != 0 ? true : z17);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetworkResult)) {
            return false;
        }
        NetworkResult networkResult = (NetworkResult) other;
        return Intrinsics.areEqual(this.resultList, networkResult.resultList) && this.isSucceed == networkResult.isSucceed && this.isEnd == networkResult.isEnd;
    }
}
