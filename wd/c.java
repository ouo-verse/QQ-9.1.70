package wd;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonComment;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonReply;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0003BY\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010)B\u0019\b\u0016\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\n\u00a2\u0006\u0004\b(\u0010,B\u0011\b\u0016\u0012\u0006\u0010+\u001a\u00020\n\u00a2\u0006\u0004\b(\u0010-R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u001e\u0010\bR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006."}, d2 = {"Lwd/c;", "", "", "a", "I", "d", "()I", "setMItemType", "(I)V", "mItemType", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;", "mComment", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "f", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;", "l", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;)V", "mReply", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "i", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;)V", "feedData", "e", "j", "mCommentPos", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mReplyPos", tl.h.F, DomainData.DOMAIN_NAME, "mReplyShowNumber", "k", "mPageIndex", "<init>", "(ILcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonReply;Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;IIII)V", "itemType", "comment", "(ILcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;)V", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonComment;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mItemType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CommonComment mComment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private CommonReply mReply;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonFeed feedData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCommentPos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mReplyPos;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mReplyShowNumber;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mPageIndex;

    public c(int i3, CommonComment mComment, CommonReply commonReply, CommonFeed commonFeed, int i16, int i17, int i18, int i19) {
        Intrinsics.checkNotNullParameter(mComment, "mComment");
        this.mItemType = i3;
        this.mComment = mComment;
        this.mReply = commonReply;
        this.feedData = commonFeed;
        this.mCommentPos = i16;
        this.mReplyPos = i17;
        this.mReplyShowNumber = i18;
        this.mPageIndex = i19;
    }

    /* renamed from: a, reason: from getter */
    public final CommonFeed getFeedData() {
        return this.feedData;
    }

    /* renamed from: b, reason: from getter */
    public final CommonComment getMComment() {
        return this.mComment;
    }

    /* renamed from: c, reason: from getter */
    public final int getMCommentPos() {
        return this.mCommentPos;
    }

    /* renamed from: d, reason: from getter */
    public final int getMItemType() {
        return this.mItemType;
    }

    /* renamed from: e, reason: from getter */
    public final int getMPageIndex() {
        return this.mPageIndex;
    }

    /* renamed from: f, reason: from getter */
    public final CommonReply getMReply() {
        return this.mReply;
    }

    /* renamed from: g, reason: from getter */
    public final int getMReplyPos() {
        return this.mReplyPos;
    }

    /* renamed from: h, reason: from getter */
    public final int getMReplyShowNumber() {
        return this.mReplyShowNumber;
    }

    public final void i(CommonFeed commonFeed) {
        this.feedData = commonFeed;
    }

    public final void j(int i3) {
        this.mCommentPos = i3;
    }

    public final void k(int i3) {
        this.mPageIndex = i3;
    }

    public final void l(CommonReply commonReply) {
        this.mReply = commonReply;
    }

    public final void m(int i3) {
        this.mReplyPos = i3;
    }

    public final void n(int i3) {
        this.mReplyShowNumber = i3;
    }

    public /* synthetic */ c(int i3, CommonComment commonComment, CommonReply commonReply, CommonFeed commonFeed, int i16, int i17, int i18, int i19, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this((i26 & 1) != 0 ? 101 : i3, commonComment, (i26 & 4) != 0 ? null : commonReply, (i26 & 8) != 0 ? null : commonFeed, (i26 & 16) != 0 ? 0 : i16, (i26 & 32) != 0 ? 0 : i17, (i26 & 64) != 0 ? 0 : i18, (i26 & 128) != 0 ? 0 : i19);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i3, CommonComment comment) {
        this(i3, comment, null, null, 0, 0, 0, 0, 252, null);
        Intrinsics.checkNotNullParameter(comment, "comment");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(CommonComment comment) {
        this(0, comment, null, null, 0, 0, 0, 0, 253, null);
        Intrinsics.checkNotNullParameter(comment, "comment");
    }
}
