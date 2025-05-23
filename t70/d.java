package t70;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.a {
    public d(@NonNull com.tencent.biz.qqcircle.immersive.views.banner.bottom.a aVar) {
        super(aVar);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.a
    protected boolean C() {
        return c40.c.c(this.f90602e);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    public String m() {
        return "DPC-QFSFeedDisplayPinnedCommentView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.a
    protected int v() {
        return R.drawable.oo6;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.a
    protected FeedCloudMeta$StComment w(e30.b bVar) {
        FeedCloudMeta$StComment feedCloudMeta$StComment = (FeedCloudMeta$StComment) RFSafeListUtils.get(c40.c.a(bj.f(bVar)), 0);
        if (feedCloudMeta$StComment != null) {
            String d16 = ba.d(bj.f(bVar));
            String g16 = bj.g(this.f90602e);
            String str = feedCloudMeta$StComment.content.get();
            String str2 = feedCloudMeta$StComment.f398447id.get();
            RFWLog.d("DPC-QFSFeedDisplayPinnedCommentView", RFWLog.USR, "[getComment] commentId: " + str2 + " | traceId: " + d16 + " | feedId: " + g16 + " | commentText: " + str);
        }
        return feedCloudMeta$StComment;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.a
    protected String x() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_PINNED_COMMENT_BAR;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.comment.a
    protected int z() {
        return R.drawable.ntk;
    }
}
