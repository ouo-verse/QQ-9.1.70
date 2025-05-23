package xb0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f extends QCircleBaseShareOperation {
    public f(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void L(String str) {
        com.tencent.biz.qqcircle.utils.s.a(f(), str);
        if (t().type == 14) {
            QCircleToast.p(com.tencent.biz.qqcircle.utils.h.a(R.string.f189303z1), 0, true);
        } else {
            QCircleToast.h(R.string.f189303z1, 0);
        }
    }

    private String M() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        QCircleShareInfo t16 = t();
        if (t16 != null && (feedCloudMeta$StFeed = t16.feed) != null) {
            return feedCloudMeta$StFeed.share.shorturl.get();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (f() == null) {
            J("QCircleCopyLinkOperation");
            return;
        }
        d(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, null);
        String M = M();
        if (!TextUtils.isEmpty(M)) {
            L(M);
            QLog.d("QCircleCopyLinkOperation", 1, "getCopyLinkFromShareInfo");
        } else {
            QLog.d("QCircleCopyLinkOperation", 1, "copyLinkFromShareInfo is empty.");
        }
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return true;
    }
}
