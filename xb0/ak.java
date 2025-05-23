package xb0;

import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ak extends QCircleBaseShareOperation {
    public ak(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        d(QCircleDaTongConstant.ElementParamValue.QRCODE, null);
        if (h() != null) {
            h().saveQrcode();
        }
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
