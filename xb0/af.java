package xb0;

import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class af extends QCircleBaseShareOperation {
    public af(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && f() != null && t().feed != null && t().feed.poster != null) {
            QFSFlowAggregationInitBean qFSFlowAggregationInitBean = new QFSFlowAggregationInitBean();
            qFSFlowAggregationInitBean.setFeedMusic(t().feed.musicInfo.get());
            qFSFlowAggregationInitBean.setAggregationType(43);
            com.tencent.biz.qqcircle.launcher.c.H(f(), qFSFlowAggregationInitBean);
            d(QCircleDaTongConstant.ElementParamValue.BACKGROUND_MUSIC, null);
            return;
        }
        J("QCircleOpenMusicAggregationPageOperation");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
