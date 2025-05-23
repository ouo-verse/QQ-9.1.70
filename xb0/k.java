package xb0;

import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.qqcircle.utils.bh;

/* compiled from: P */
/* loaded from: classes5.dex */
public class k extends QCircleBaseShareOperation {
    public k(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && f() != null && t().feed != null && t().feed.urlInfo != null && t().feed.urlInfo.get().size() != 0) {
            com.tencent.biz.qqcircle.launcher.c.g(f(), bh.d(t().feed.urlInfo.get(), "creator_data"));
            d("data", null);
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
