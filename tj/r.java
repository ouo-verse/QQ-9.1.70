package tj;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.queue.DownloadState;
import com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener;
import com.tencent.biz.richframework.queue.RFWDownloadQueueTaskInfo;
import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import cooperation.qzone.util.QZonePermission;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0006\u0010\u0012\u001a\u00020\u0004J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Ltj/r;", "Ltj/f;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Lcom/tencent/biz/richframework/queue/RFWDownloadQueueResultListener;", "", "G9", "", "text", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "F9", "Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "taskState", "onStateChange", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "saveRoot", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "saveIcon", "Landroid/app/Dialog;", "D", "Landroid/app/Dialog;", "waitingDialog", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class r extends f<QZIntimateLayerExtraInfoBean> implements RFWDownloadQueueResultListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView saveIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private Dialog waitingDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View saveRoot;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"tj/r$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RFWDownloadQueueTaskInfo f436395a;

        b(RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo) {
            this.f436395a = rFWDownloadQueueTaskInfo;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            kj.b.l().b(this.f436395a);
        }
    }

    private final void G9() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo downloadPicInfo;
        String url;
        String str;
        String str2;
        RFWLayerPicInfo layerPicInfo2;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        String url2;
        wj.d E;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo2;
        RFWLayerVideoInfo layerVideoInfo;
        QZIntimateLayerExtraInfoBean x95 = x9();
        String str3 = "";
        if (!(x95 != null && x95.getIsVideo()) ? (rFWLayerItemMediaInfo = this.mCurrentSelectedItem) == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (downloadPicInfo = layerPicInfo.getDownloadPicInfo()) == null || (url = downloadPicInfo.getUrl()) == null : (rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem) == null || (layerVideoInfo = rFWLayerItemMediaInfo2.getLayerVideoInfo()) == null || (url = layerVideoInfo.getCurrentVideoUrl()) == null) {
            url = "";
        }
        QLog.i("QZIntimateLayerMediaSavePart", 1, "download url is " + url);
        if (TextUtils.isEmpty(url)) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.sly, 0).show();
            return;
        }
        I9("");
        RFWDownloadQueueTaskInfo rFWDownloadQueueTaskInfo = new RFWDownloadQueueTaskInfo(url);
        HashMap<String, String> hashMap = new HashMap<>();
        String uinString = LoginData.getInstance().getUinString();
        Intrinsics.checkNotNullExpressionValue(uinString, "getInstance().uinString");
        hashMap.put("ext_key_uin", uinString);
        QZIntimateLayerExtraInfoBean x96 = x9();
        if (x96 == null || (str = x96.getUploadUid()) == null) {
            str = "";
        }
        hashMap.put("ext_key_uid", str);
        String a16 = com.qzone.util.l.a(R.string.toe);
        QZIntimateLayerExtraInfoBean x97 = x9();
        String albumName = x97 != null ? x97.getAlbumName() : null;
        hashMap.put("ext_key_task_desc", a16 + albumName + com.qzone.util.l.a(R.string.uwn));
        hashMap.put("ext_key_space_id", getSpaceId());
        qj.a aVar = (qj.a) RFWIocAbilityProvider.g().getIocInterface(qj.a.class, getPartRootView(), null);
        hashMap.put("ext_key_space_type", String.valueOf((aVar == null || (E = aVar.E()) == null) ? 0 : E.getSpaceType()));
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo3 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo3 != null && rFWLayerItemMediaInfo3.isVideo()) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo4 = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo4 != null && (layerPicInfo2 = rFWLayerItemMediaInfo4.getLayerPicInfo()) != null && (currentPicInfo = layerPicInfo2.getCurrentPicInfo()) != null && (url2 = currentPicInfo.getUrl()) != null) {
                str3 = url2;
            }
            hashMap.put("ext_key_video_url", str3);
        }
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo5 = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo5 != null && rFWLayerItemMediaInfo5.isVideo()) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("ext_key_is_video", str2);
        rFWDownloadQueueTaskInfo.setExtMap(hashMap);
        if (QZonePermission.requestStoragePermission(getActivity(), new b(rFWDownloadQueueTaskInfo), QQPermissionConstants.Business.SCENE.QQ_QZONE_SAVE_MEDIA_TO_ALBUM)) {
            kj.b.l().b(rFWDownloadQueueTaskInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(r this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.G9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I9(String text) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        if (this.waitingDialog == null) {
            ReportDialog reportDialog = new ReportDialog(getActivity(), R.style.f174269ui);
            this.waitingDialog = reportDialog;
            reportDialog.setContentView(R.layout.bqd);
            Dialog dialog = this.waitingDialog;
            View findViewById = dialog != null ? dialog.findViewById(R.id.kja) : null;
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Dialog dialog2 = this.waitingDialog;
            View findViewById2 = dialog2 != null ? dialog2.findViewById(R.id.cib) : null;
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
        }
        Dialog dialog3 = this.waitingDialog;
        View findViewById3 = dialog3 != null ? dialog3.findViewById(R.id.dialogText) : null;
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById3).setText(text);
        Dialog dialog4 = this.waitingDialog;
        if (dialog4 != null) {
            dialog4.show();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        View findViewById = rootView != null ? rootView.findViewById(R.id.n4f) : null;
        View findViewById2 = findViewById != null ? findViewById.findViewById(R.id.n4t) : null;
        View inflate = LayoutInflater.from(rootView != null ? rootView.getContext() : null).inflate(R.layout.cll, (ViewGroup) null);
        this.saveRoot = inflate;
        if (findViewById2 == null || inflate == null) {
            return;
        }
        Intrinsics.checkNotNull(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.n6j);
        this.saveIcon = imageView;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_download_icon_white);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ImmersiveUtils.dpToPx(32.0f), ImmersiveUtils.dpToPx(32.0f));
        layoutParams.setMarginEnd(ImmersiveUtils.dpToPx(10.0f));
        View view = this.saveRoot;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: tj.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    r.H9(r.this, view2);
                }
            });
        }
        fo.c.n(this.saveRoot, "em_qz_view_save");
        ((ViewGroup) findViewById2).addView(this.saveRoot, layoutParams);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        kj.b.l().s(getSpaceId(), this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        kj.b.l().t(getSpaceId(), this);
    }

    public final void F9() {
        Dialog dialog;
        try {
            Dialog dialog2 = this.waitingDialog;
            if (!(dialog2 != null && dialog2.isShowing()) || (dialog = this.waitingDialog) == null) {
                return;
            }
            dialog.dismiss();
        } catch (Exception e16) {
            RFWLog.e(getTAG(), RFWLog.USR, "exception is " + e16);
        }
    }

    @Override // com.tencent.biz.richframework.queue.RFWDownloadQueueResultListener
    public void onStateChange(RFWDownloadTaskStateData taskState) {
        if ((taskState != null ? taskState.getState() : null) == DownloadState.STATE_SUCCESS) {
            Uri fromFile = Uri.fromFile(new File(taskState.getFilePath()));
            Intrinsics.checkNotNullExpressionValue(fromFile, "fromFile(file)");
            BaseApplication.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", fromFile));
            F9();
            RFWLog.i("QZIntimateLayerMediaSavePart", RFWLog.USR, "download success");
            QQToast.makeText(BaseApplication.getContext(), 5, R.string.slz, 0).show();
            return;
        }
        if ((taskState != null ? taskState.getState() : null) == DownloadState.STATE_ERROR) {
            F9();
            RFWLog.i("QZIntimateLayerMediaSavePart", RFWLog.USR, "download fail");
            QQToast.makeText(BaseApplication.getContext(), 4, R.string.sly, 0).show();
        }
    }
}
