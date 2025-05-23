package tj;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.layer.bean.QZIntimateLayerExtraInfoBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\r\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010%\u001a\u00020 \u00a2\u0006\u0004\b9\u0010:J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\u001c\u0010\u0017\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00150&j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0015`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00100R\u0016\u00108\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00100\u00a8\u0006;"}, d2 = {"Ltj/s;", "Ltj/f;", "Lcom/qzone/reborn/intimate/layer/bean/QZIntimateLayerExtraInfoBean;", "Lqj/l;", "Lcom/tencent/richframework/gallery/delegate/outer/ILayerOperationListener;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "data", "initIntentData", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "onLayerStateUpdate", "", "action", "", "args", "handleBroadcastMessage", "", "D6", "onDoubleClick", "onDragClose", "", "isClickToExit", "onSingleClick", "onZoomScaleChangeEnd", "Lp9/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lp9/b;", "getBuilder", "()Lp9/b;", "builder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/HashMap;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "D", "Ljava/lang/String;", "feedId", "", "E", "I", "spaceType", UserInfo.SEX_FEMALE, "Z", "isReadyToReportLayer", "G", "mediaSum", "H", "mediaPosition", "<init>", "(Lp9/b;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public class s extends f<QZIntimateLayerExtraInfoBean> implements qj.l, ILayerOperationListener {

    /* renamed from: C, reason: from kotlin metadata */
    private final HashMap<String, Object> pageParams;

    /* renamed from: D, reason: from kotlin metadata */
    private String feedId;

    /* renamed from: E, reason: from kotlin metadata */
    private int spaceType;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isReadyToReportLayer;

    /* renamed from: G, reason: from kotlin metadata */
    private int mediaSum;

    /* renamed from: H, reason: from kotlin metadata */
    private int mediaPosition;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final p9.b builder;

    public s(p9.b builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.builder = builder;
        this.pageParams = new HashMap<>();
        this.feedId = "";
    }

    @Override // qj.l
    public Map<String, Object> D6() {
        String str;
        RFWLayerPicInfo layerPicInfo;
        RFWLayerPicInfo.RFWPicInfo currentPicInfo;
        this.pageParams.clear();
        this.pageParams.put("feedid", this.feedId);
        HashMap<String, Object> hashMap = this.pageParams;
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || (layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo()) == null || (currentPicInfo = layerPicInfo.getCurrentPicInfo()) == null || (str = currentPicInfo.getUrl()) == null) {
            str = "";
        }
        hashMap.put("pic_url", str);
        HashMap<String, Object> hashMap2 = this.pageParams;
        QZIntimateLayerExtraInfoBean x95 = x9();
        hashMap2.put("framer_uin", String.valueOf(x95 != null ? x95.getUploadUid() : null));
        this.pageParams.put("close_friend_space_id", getSpaceId());
        this.pageParams.put("close_friend_space_type", Integer.valueOf(this.spaceType));
        return this.pageParams;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "QZONE_INTIMATE_LAYER_READY_REPORT")) {
            this.isReadyToReportLayer = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tj.f, com.qzone.reborn.albumx.common.layer.part.i
    public void initIntentData(Bundle data) {
        super.initIntentData(data);
        if (data != null) {
            if (data.containsKey("key_feed_id")) {
                Object obj = data.get("key_feed_id");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.feedId = (String) obj;
            }
            if (data.containsKey("key_space_type")) {
                Object obj2 = data.get("key_space_type");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                this.spaceType = ((Integer) obj2).intValue();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Context context = rootView.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        VideoReport.addToDetectionWhitelist((Activity) context);
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_NONE);
        RFWLayerIOCUtil.registerLayerOperationListener(rootView, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.layer.part.i
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        tk.j jVar = tk.j.f436437a;
        this.mediaSum = jVar.b(layerState);
        this.mediaPosition = jVar.a(layerState);
    }

    @Override // com.qzone.reborn.albumx.common.layer.part.i, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this, qj.l.class);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onSingleClick(boolean isClickToExit) {
        HashMap hashMap = new HashMap();
        hashMap.put("pic_cnt", Integer.valueOf(this.mediaSum));
        hashMap.put("is_last_page", Integer.valueOf(this.mediaPosition == this.mediaSum ? 1 : 0));
        vj.e eVar = vj.e.f441735a;
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        eVar.b(hashMap, "em_qz_page_turning_floating", rootView);
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDoubleClick() {
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onDragClose() {
    }

    @Override // com.tencent.richframework.gallery.delegate.outer.ILayerOperationListener
    public void onZoomScaleChangeEnd() {
    }
}
