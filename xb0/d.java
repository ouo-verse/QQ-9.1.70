package xb0;

import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.utils.cg;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends QCircleBaseShareOperation {
    public d(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        QCircleShareInfo t16 = t();
        if (t16 != null && t16.feed != null && f() != null) {
            int i3 = t16.type;
            if (i3 == 12) {
                cg.h(f().hashCode(), t16.feed, t16.comment);
            } else if (i3 == 13) {
                cg.i(f().hashCode(), t16.feed, t16.comment, t16.reply);
            }
            d("report", null);
            return;
        }
        J("comment_or_reply_report");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
