package xb0;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StImageUrl;
import feedcloud.FeedCloudMeta$StVideoUrl;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class aj extends QCircleBaseShareOperation {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            aj.this.N();
        }
    }

    public aj(QCircleBaseShareOperation.a aVar) {
        super(aVar);
    }

    private void M() {
        com.tencent.biz.qqcircle.utils.z.b(f(), 2, new a(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        String str;
        if (h() != null) {
            h().f();
        }
        QCircleRichMediaDownLoadManager.d Q = Q();
        Q.g(k());
        QCircleRichMediaDownLoadManager.g().f(Q);
        if (Q.b() == 0) {
            str = "2";
        } else {
            str = "1";
        }
        R(str);
    }

    private String O() {
        String str;
        List<FeedCloudMeta$StVideoUrl> list = t().feed.video.vecVideoUrl.get();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (list.get(i3).levelType.get() == 20) {
                    str = list.get(i3).playUrl.get();
                    QLog.d("QFSSharePart", 1, "get video downLoad url success");
                    break;
                }
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
            String str2 = t().feed.video.playUrl.get();
            QLog.d("QFSSharePart", 1, "get origin video downLoad url success");
            return str2;
        }
        return str;
    }

    private String P() {
        String str;
        FeedCloudMeta$StImage feedCloudMeta$StImage = t().feed.images.get(t().picDownPos);
        if (feedCloudMeta$StImage != null && feedCloudMeta$StImage.vecImageUrl.size() > 0) {
            for (FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl : feedCloudMeta$StImage.vecImageUrl.get()) {
                if (feedCloudMeta$StImageUrl.levelType.get() == 4) {
                    str = feedCloudMeta$StImageUrl.url.get();
                    QLog.d("QFSSharePart", 1, "get pic downLoad url success");
                    break;
                }
            }
        }
        str = "";
        if (TextUtils.isEmpty(str)) {
            String str2 = t().feed.images.get(t().picDownPos).picUrl.get();
            QLog.d("QFSSharePart", 1, "get origin pic downLoad url success");
            return str2;
        }
        return str;
    }

    private QCircleRichMediaDownLoadManager.d Q() {
        QCircleRichMediaDownLoadManager.d dVar = new QCircleRichMediaDownLoadManager.d();
        int i3 = t().feed.type.get();
        if (i3 != 2) {
            if (i3 == 3) {
                dVar.h(O(), 0, t().feed.f398449id.get());
            }
        } else {
            dVar.h(P(), 1, t().feed.f398449id.get());
        }
        return dVar;
    }

    private void R(String str) {
        if (!C(57) && !uq3.c.g6()) {
            if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
                QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(ua0.c.a(t().extraTypeInfo.mFeed).setActionType(105).setSubActionType(2).setToUin(t().extraTypeInfo.mFeed.poster.f398463id.get()).setIndex(t().extraTypeInfo.mDataPosition).setExt1(str).setPageId(n())));
            }
        } else {
            H(105, 2, t().extraTypeInfo, str);
        }
        d("save", null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && f() != null) {
            if (!HostNetworkUtils.isNetworkAvailable()) {
                QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8), 0);
                QLog.d("QFSSharePart", 4, "network not available");
                return;
            } else {
                M();
                return;
            }
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
