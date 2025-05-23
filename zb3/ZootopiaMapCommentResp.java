package zb3;

import com.tencent.sqshow.zootopia.data.ZootopiaMapComment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lzb3/h;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/sqshow/zootopia/data/l;", "a", "Ljava/util/List;", "()Ljava/util/List;", "comments", "b", "Z", "()Z", "hasMore", "<init>", "(Ljava/util/List;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.h, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaMapCommentResp {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ZootopiaMapComment> comments;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean hasMore;

    public ZootopiaMapCommentResp(List<ZootopiaMapComment> comments, boolean z16) {
        Intrinsics.checkNotNullParameter(comments, "comments");
        this.comments = comments;
        this.hasMore = z16;
    }

    public final List<ZootopiaMapComment> a() {
        return this.comments;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.comments.hashCode() * 31;
        boolean z16 = this.hasMore;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ZootopiaMapCommentResp(comments=" + this.comments + ", hasMore=" + this.hasMore + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaMapCommentResp)) {
            return false;
        }
        ZootopiaMapCommentResp zootopiaMapCommentResp = (ZootopiaMapCommentResp) other;
        return Intrinsics.areEqual(this.comments, zootopiaMapCommentResp.comments) && this.hasMore == zootopiaMapCommentResp.hasMore;
    }
}
