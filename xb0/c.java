package xb0;

import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.events.QFSCommentOrReplySharePanelClickEvent;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends QCircleBaseShareOperation {
    public c(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        QCircleShareInfo t16 = t();
        if (t16 != null && t16.feed != null && f() != null) {
            int i3 = t16.type;
            if (i3 == 12) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentOrReplySharePanelClickEvent(3, t16.feed.f398449id.get(), t16.contextHashCode, t16.comment, null));
            } else if (i3 == 13) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentOrReplySharePanelClickEvent(4, t16.feed.f398449id.get(), t16.contextHashCode, t16.comment, t16.reply));
            }
            d("delete", null);
            return;
        }
        J("comment_or_reply_delete");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
