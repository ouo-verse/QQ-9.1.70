package xb0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e extends QCircleBaseShareOperation {
    public e(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && f() != null) {
            String str = t().copyContent;
            if (TextUtils.isEmpty(str)) {
                QLog.e("copy_content", 1, "[realOperate] copyContent is empty");
                return;
            } else {
                com.tencent.biz.qqcircle.utils.s.a(f(), str);
                d("copy", null);
                return;
            }
        }
        J("copy_content");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
