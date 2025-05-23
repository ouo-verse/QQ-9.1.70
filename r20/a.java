package r20;

import com.tencent.biz.qqcircle.adapter.QFSCommentBlock;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.part.interfaces.IPartHost;

/* compiled from: P */
/* loaded from: classes4.dex */
public interface a {
    QFSCommentBlock getCmtBlock();

    QFSCommentInfo getCommentInfo();

    IPartHost getCommentPartHost();

    boolean hasReceiveNeedResetBlockEvent();

    void loadMoreComments(LoadInfo loadInfo);

    void setCommentBottomBarVisibility(int i3);
}
