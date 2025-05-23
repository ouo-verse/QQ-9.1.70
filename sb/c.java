package sb;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.albumx.common.part.n;
import com.qzone.reborn.albumx.common.viewmodel.k;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxTaskDetailInitBean;
import com.qzone.reborn.configx.g;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bo;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\b\u0010\r\u001a\u00020\u000bH\u0014J\u0012\u0010\u000e\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000fH\u0016R\u0014\u0010\u0016\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lsb/c;", "Lcom/qzone/reborn/albumx/common/part/n;", "Lcom/tencent/mobileqq/msf/sdk/handler/IWeakNetStatusHandler;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lcom/qzone/reborn/albumx/common/viewmodel/k;", "G9", "", "H9", "F9", "onPartDestroy", "", "weakReason", "onNormalToWeakNet", "lastWeakReason", "onWeakNetToNormal", "D", "Ljava/lang/String;", "TAG", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxTaskDetailInitBean;", "E", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxTaskDetailInitBean;", "initBean", UserInfo.SEX_FEMALE, "weakNetworkHint", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends n implements IWeakNetStatusHandler {

    /* renamed from: E, reason: from kotlin metadata */
    private QZAlbumxTaskDetailInitBean initBean;

    /* renamed from: D, reason: from kotlin metadata */
    private final String TAG = "QZAlbumxPublishQueuePart";

    /* renamed from: F, reason: from kotlin metadata */
    private final String weakNetworkHint = g.f53821a.b().k1();

    @Override // com.qzone.reborn.albumx.common.part.n
    protected String F9() {
        String albumId;
        QZAlbumxTaskDetailInitBean qZAlbumxTaskDetailInitBean = this.initBean;
        return (qZAlbumxTaskDetailInitBean == null || (albumId = qZAlbumxTaskDetailInitBean.getAlbumId()) == null) ? "" : albumId;
    }

    @Override // com.qzone.reborn.albumx.common.part.n
    protected k G9() {
        ViewModel viewModel = getViewModel(bo.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZAlbumxPub\u2026eueViewModel::class.java)");
        return (k) viewModel;
    }

    @Override // com.qzone.reborn.albumx.common.part.n
    protected String H9() {
        String uin;
        QZAlbumxTaskDetailInitBean qZAlbumxTaskDetailInitBean = this.initBean;
        return (qZAlbumxTaskDetailInitBean == null || (uin = qZAlbumxTaskDetailInitBean.getUin()) == null) ? "" : uin;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onNormalToWeakNet(int weakReason) {
        QLog.d(this.TAG, 1, "onNormalToWeakNet reason:", Integer.valueOf(weakReason));
        Activity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            return;
        }
        Activity activity2 = getActivity();
        if (activity2 != null && activity2.isDestroyed()) {
            return;
        }
        Fragment hostFragment = getHostFragment();
        if (((hostFragment == null || hostFragment.isResumed()) ? false : true) || TextUtils.isEmpty(this.weakNetworkHint)) {
            return;
        }
        List<IQueueTask> value = G9().Q1().getValue();
        if ((value == null || value.isEmpty()) ? false : true) {
            QQToastUtil.showQQToastInUiThread(0, "\u5f53\u524d\u7f51\u7edc\u8fde\u63a5\u8f83\u5f31\uff0c\u8bf7\u8010\u5fc3\u7b49\u5f85~");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        Intrinsics.checkNotNull(activity);
        this.initBean = (QZAlbumxTaskDetailInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
        if (TextUtils.isEmpty(this.weakNetworkHint)) {
            return;
        }
        AppNetConnInfo.registerWeakNetStatusHandler(null, this);
        QLog.d(this.TAG, 1, "onCreate registerWeakNetStatusHandler");
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        if (TextUtils.isEmpty(this.weakNetworkHint)) {
            return;
        }
        AppNetConnInfo.unRegisterWeakNetStatusHandler(this);
        QLog.d(this.TAG, 1, "onDestroy unRegisterWeakNetStatusHandler");
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onWeakNetToNormal(int lastWeakReason) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
