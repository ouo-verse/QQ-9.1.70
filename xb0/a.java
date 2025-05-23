package xb0;

import com.tencent.biz.qqcircle.events.QFSBarrageSwitchEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends QCircleBaseShareOperation {
    public a(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        int i3;
        String str;
        if (t() != null && t().feed != null && f() != null) {
            int i16 = 2;
            QLog.d("QFSSharePart", 1, "switchBarrage isBarrageOpen: ", Boolean.valueOf(z()));
            if (z()) {
                i3 = R.string.f1902241i;
            } else {
                i3 = R.string.f1902141h;
            }
            QCircleToast.h(i3, 0);
            com.tencent.biz.qqcircle.manager.d.b().h(!z());
            if (!z()) {
                i16 = 1;
            }
            SimpleEventBus.getInstance().dispatchEvent(new QFSBarrageSwitchEvent(i16));
            if (z()) {
                str = QCircleDaTongConstant.ElementParamValue.CLOSE_BULLET_SCREEN;
            } else {
                str = QCircleDaTongConstant.ElementParamValue.OPEN_BULLET_SCREEN;
            }
            d(str, null);
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
