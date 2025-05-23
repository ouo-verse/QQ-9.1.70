package xb0;

import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class j extends QCircleBaseShareOperation {
    public j(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        QCircleShareInfo t16 = t();
        t16.isShowPersonalQrcodeDown = true;
        t16.source = 7;
        if (h() != null) {
            h().e(t());
        }
        d(QCircleDaTongConstant.ElementParamValue.QRCODE, null);
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
