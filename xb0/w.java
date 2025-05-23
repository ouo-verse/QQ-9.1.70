package xb0;

import android.app.Activity;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes5.dex */
public class w extends QCircleBaseShareOperation {
    public w(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        boolean z16;
        if (yb0.c.d(t())) {
            yb0.c.g(f());
            return;
        }
        Activity f16 = f();
        String valueOf = String.valueOf(t().albumId);
        if (t().albumStatus == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.biz.qqcircle.launcher.c.o0(f16, uq3.c.p3(valueOf, z16), null, -1);
        e("edit", null, QCircleDaTongConstant.ElementId.EM_XSJ_ALBUM_SHAREPANEL);
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
