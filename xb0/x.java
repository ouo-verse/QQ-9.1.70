package xb0;

import android.os.Bundle;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QFSPersonalGroupInfoInitBean;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class x extends QCircleBaseShareOperation {
    public x(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && f() != null && t().feed != null && t().feed.poster != null) {
            Bundle bundle = new Bundle();
            QFSPersonalGroupInfoInitBean qFSPersonalGroupInfoInitBean = new QFSPersonalGroupInfoInitBean();
            qFSPersonalGroupInfoInitBean.setHostUin(QCirclePluginGlobalInfo.l());
            qFSPersonalGroupInfoInitBean.setFeed(t().feed);
            long j3 = t().feed.feedExtraInfo.inner_jump.qq_group_id.get();
            QLog.d("QCircleFeedBindQQGroupOperation", 1, "[realOperate] qqGroupId =" + j3);
            qFSPersonalGroupInfoInitBean.setSelectGroupId(j3);
            bundle.putSerializable("key_bundle_common_init_bean", qFSPersonalGroupInfoInitBean);
            com.tencent.biz.qqcircle.launcher.c.E(f(), bundle);
            d(QCircleDaTongConstant.ElementParamValue.SHOW_GROUP, null);
            return;
        }
        J("QCircleFeedBindQQGroupOperation");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
