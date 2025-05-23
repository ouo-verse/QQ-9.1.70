package s10;

import UserGrowth.stSimpleMetaComment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ls10/a;", "", "", "a", "Z", "b", "()Z", "isFinished", "", "LUserGrowth/stSimpleMetaComment;", "Ljava/util/List;", "()Ljava/util/List;", "setComments", "(Ljava/util/List;)V", "comments", "<init>", "(ZLjava/util/List;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isFinished;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private List<stSimpleMetaComment> comments;

    public a(boolean z16, List<stSimpleMetaComment> comments) {
        Intrinsics.checkNotNullParameter(comments, "comments");
        this.isFinished = z16;
        this.comments = comments;
    }

    public final List<stSimpleMetaComment> a() {
        return this.comments;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }
}
