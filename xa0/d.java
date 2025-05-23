package xa0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.utils.cg;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoaderFactory;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qcircle.application.initprocess.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends c {

    /* renamed from: d, reason: collision with root package name */
    private boolean f447526d;

    public d(@NonNull Activity activity) {
        super(activity);
        this.f447526d = false;
    }

    private boolean l() {
        Serializable serializable;
        Intent intent = this.f447523a.getIntent();
        if (intent != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (!(serializable instanceof QCircleFolderBean) && !(serializable instanceof QCircleLayerBean)) {
            return false;
        }
        return true;
    }

    private void m() {
        int d16 = l30.a.a().d();
        if (d16 <= 0) {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateLayerItemView] preInflateCount:" + d16 + ", direct return!");
            return;
        }
        RFWLayoutPreLoaderFactory.getLayoutLoader(l30.a.a().c()).preloadView(this.f447523a, R.layout.gen, d16);
        QLog.d("QCirclePreloadProcess", 1, "[preInflateLayerItemView] done, preInflateCount:" + d16 + ", resId:" + R.layout.gen);
    }

    private void n() {
        if (this.f447526d) {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateViews] repeat call, direct return!");
            return;
        }
        QLog.d("QCirclePreloadProcess", 1, "[preInflateViews] device level:" + QCircleDeviceInfoUtils.getLevel());
        if (!l30.a.a().b()) {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateViews] pass, don't support async inflate");
            return;
        }
        if (l()) {
            m();
        } else {
            QLog.e("QCirclePreloadProcess", 1, "[preInflateViews] not folder or layer page");
        }
        this.f447526d = true;
    }

    @Override // xa0.c
    public void d(Bundle bundle) {
        super.d(bundle);
        QLog.d("QFSFolderLogicImpl", 1, "onCreate");
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_FOLDER_CREATE);
        f.i();
        QCircleReportHelper.getInstance().pushPageScene(0);
        QCirclePeriodCollect.record(QCirclePeriodCollect.PERIOD_FOLDER_INIT);
        n();
    }

    @Override // xa0.c
    public void e() {
        super.e();
        QLog.d("QFSFolderLogicImpl", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        QCircleReportHelper.getInstance().popPageScene(0);
        VSNetworkHelper.getInstance().cancelRequest(this.f447523a);
        QCircleReporter.getInstance().flush();
        QCirclePanelStateEvent.resetPanelState(this.f447523a);
        QCircleFeedPicLoader.g().deleteSdCacheIfNeed();
        QCirclePanelStateEvent.resetPanelState();
        cg.d();
        QCirclePluginGlobalInfo.V(hashCode(), false);
    }

    @Override // xa0.c
    public void f() {
        super.f();
        QLog.d("QFSFolderLogicImpl", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // xa0.c
    public void h() {
        super.h();
        QLog.d("QFSFolderLogicImpl", 1, "onResume");
        QCircleFolderBean qCircleFolderBean = (QCircleFolderBean) this.f447523a.getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (qCircleFolderBean == null) {
            QLog.e("QFSFolderLogicImpl", 1, "onResume folder bean is null");
            return;
        }
        QLog.d("QFSFolderLogicImpl", 4, "doOnResume isWrite?" + qCircleFolderBean.isPublish());
        if (qCircleFolderBean.getEnterTime() > 0) {
            QLog.d("QFSFolderLogicImpl", 4, "onResume time:" + (System.currentTimeMillis() - qCircleFolderBean.getEnterTime()));
        }
    }

    @Override // xa0.c
    public void j() {
        super.j();
        QLog.d("QFSFolderLogicImpl", 1, DKHippyEvent.EVENT_STOP);
    }
}
