package wd;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lwd/a;", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "comment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "reply", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CommonComment comment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CommonReply reply;

    public a(CommonComment comment, CommonReply commonReply) {
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.comment = comment;
        this.reply = commonReply;
    }

    /* renamed from: a, reason: from getter */
    public final CommonComment getComment() {
        return this.comment;
    }

    /* renamed from: b, reason: from getter */
    public final CommonReply getReply() {
        return this.reply;
    }

    public /* synthetic */ a(CommonComment commonComment, CommonReply commonReply, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(commonComment, (i3 & 2) != 0 ? null : commonReply);
    }
}
