package x30;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.utils.cy;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.event.QFSAggregationUpdateEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StMusicPageData;
import qqcircle.QQCircleFeedBase$StUnifiedTagPageData;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 a2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001bB\u000f\u0012\u0006\u00106\u001a\u000203\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0015`\u0016H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\tH\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0018\u0010 \u001a\u00020\t2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0002J\u0012\u0010\"\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0002J\u0010\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020#H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002J\b\u0010'\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020\t2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0002J\b\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\tH\u0002R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010>\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00109R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0014\u0010U\u001a\u00020+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0014\u0010W\u001a\u00020+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010TR\u0014\u0010Y\u001a\u00020+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bX\u0010TR\u0014\u0010\\\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010^\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b]\u0010[\u00a8\u0006c"}, d2 = {"Lx30/l;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "onPartResume", "onPartPause", "v", NodeProps.ON_CLICK, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "initData", "Z9", "Y9", "initViewModel", "Q9", "Lcom/tencent/richframework/data/base/UIStateData;", "Lqqcircle/QQCircleFeedBase$StFeedListBusiRspData;", "uiStateData", "M9", "data", "ca", "Lfeedcloud/FeedCloudMeta$StShare;", "stShare", "ba", "I9", "J9", "P9", "N9", "O9", "", "collectState", "da", "isSuccess", "collectionAction", "aa", "E9", "G9", "Lcom/tencent/biz/qqcircle/immersive/aggregation/bean/QFSFlowAggregationInitBean;", "d", "Lcom/tencent/biz/qqcircle/immersive/aggregation/bean/QFSFlowAggregationInitBean;", "mInitBean", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mIvBack", "f", "mIvCollectBtn", tl.h.F, "mIvShareBtn", "Lcom/tencent/biz/qqcircle/immersive/aggregation/QFSFlowAggregationViewModel;", "i", "Lcom/tencent/biz/qqcircle/immersive/aggregation/QFSFlowAggregationViewModel;", "mViewModel", "Lqqcircle/QQCircleFeedBase$StMusicPageData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqqcircle/QQCircleFeedBase$StMusicPageData;", "mMusicPageData", "Lqqcircle/QQCircleFeedBase$StUnifiedTagPageData;", BdhLogUtil.LogTag.Tag_Conn, "Lqqcircle/QQCircleFeedBase$StUnifiedTagPageData;", "mUnifiedTagPageData", "D", "Ljava/lang/String;", "mSongMid", "E", "Z", "mIsCollectState", UserInfo.SEX_FEMALE, "isFirstResume", "W9", "()Z", "isNeedSetCollectPage", "V9", "isMusicPage", "X9", "isUnifiedPage", "L9", "()Ljava/lang/String;", "unifiedType", "K9", "unifiedId", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/aggregation/bean/QFSFlowAggregationInitBean;)V", "G", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class l extends u implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QQCircleFeedBase$StUnifiedTagPageData mUnifiedTagPageData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mSongMid;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsCollectState;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isFirstResume;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSFlowAggregationInitBean mInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mIvBack;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mIvCollectBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mIvShareBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QFSFlowAggregationViewModel mViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCircleFeedBase$StMusicPageData mMusicPageData;

    public l(@NotNull QFSFlowAggregationInitBean mInitBean) {
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
        this.mSongMid = "";
        this.isFirstResume = true;
    }

    private final void E9() {
        VideoReport.setElementId(this.mIvCollectBtn, QCircleDaTongConstant.ElementId.EM_XSJ_MUSIC_COLLECT);
        VideoReport.setEventDynamicParams(this.mIvCollectBtn, new IDynamicParams() { // from class: x30.k
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map F9;
                F9 = l.F9(l.this, str);
                return F9;
            }
        });
        VideoReport.setElementExposePolicy(this.mIvCollectBtn, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.mIvCollectBtn, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map F9(l this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        boolean areEqual = Intrinsics.areEqual(str, "imp");
        String str2 = QCircleDaTongConstant.ElementParamValue.COLLECT;
        if (areEqual) {
            Intrinsics.checkNotNullExpressionValue(map, "map");
            if (!this$0.mIsCollectState) {
                str2 = QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL;
            }
            map.put("xsj_action_type", str2);
        } else if (Intrinsics.areEqual(str, "clck")) {
            Intrinsics.checkNotNullExpressionValue(map, "map");
            if (this$0.mIsCollectState) {
                str2 = QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL;
            }
            map.put("xsj_action_type", str2);
        }
        QLog.d("QFSAggregationTitleViewPartV2", 1, "event:" + str + " mIsCollectState:" + this$0.mIsCollectState);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_material_type", "music");
        map.put("xsj_material_id", this$0.mSongMid);
        return map;
    }

    private final void G9() {
        VideoReport.setElementId(this.mIvCollectBtn, QCircleDaTongConstant.ElementId.EM_XSJ_MATERIAL_COLLECT);
        VideoReport.setEventDynamicParams(this.mIvCollectBtn, new IDynamicParams() { // from class: x30.j
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map H9;
                H9 = l.H9(l.this, str);
                return H9;
            }
        });
        VideoReport.setElementExposePolicy(this.mIvCollectBtn, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.mIvCollectBtn, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map H9(l this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        boolean areEqual = Intrinsics.areEqual(str, "imp");
        String str2 = QCircleDaTongConstant.ElementParamValue.COLLECT;
        if (areEqual) {
            Intrinsics.checkNotNullExpressionValue(map, "map");
            if (!this$0.mIsCollectState) {
                str2 = QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL;
            }
            map.put("xsj_action_type", str2);
        } else if (Intrinsics.areEqual(str, "clck")) {
            Intrinsics.checkNotNullExpressionValue(map, "map");
            if (this$0.mIsCollectState) {
                str2 = QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL;
            }
            map.put("xsj_action_type", str2);
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_material_type", this$0.L9());
        map.put("xsj_material_id", this$0.K9());
        return map;
    }

    private final String I9() {
        if (V9()) {
            return this.mSongMid;
        }
        if (X9()) {
            return K9();
        }
        return "";
    }

    private final String J9() {
        if (V9()) {
            return "music";
        }
        if (X9()) {
            return L9();
        }
        return "";
    }

    private final String K9() {
        String str = this.mInitBean.getFeedUnifiedTag().unifiedId.get();
        Intrinsics.checkNotNullExpressionValue(str, "mInitBean.getFeedUnifiedTag().unifiedId.get()");
        return str;
    }

    private final String L9() {
        String str = this.mInitBean.getFeedUnifiedTag().unifiedType.get();
        Intrinsics.checkNotNullExpressionValue(str, "mInitBean.getFeedUnifiedTag().unifiedType.get()");
        return str;
    }

    private final void M9(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uiStateData) {
        if (uiStateData == null) {
            return;
        }
        if (uiStateData.getIsLoadMore()) {
            QLog.d("QFSAggregationTitleViewPartV2", 1, "handleBusiRspData, loadMore data do not refresh UI.");
        } else if (uiStateData.getState() == 3) {
            ca(uiStateData.getData());
        }
    }

    private final void N9() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData;
        if (!FastClickUtils.isFastDoubleClick("QFSAggregationTitleViewPartV2") && (qQCircleFeedBase$StMusicPageData = this.mMusicPageData) != null) {
            Intrinsics.checkNotNull(qQCircleFeedBase$StMusicPageData);
            if (qQCircleFeedBase$StMusicPageData.music != null) {
                boolean z16 = !this.mIsCollectState;
                QLog.d("QFSAggregationTitleViewPartV2", 1, "handleClickCollectButton, songMid:" + this.mSongMid + ", collectionAction:" + z16);
                QFSFlowAggregationViewModel qFSFlowAggregationViewModel = this.mViewModel;
                if (qFSFlowAggregationViewModel != null) {
                    qFSFlowAggregationViewModel.m2(this.mSongMid, z16);
                }
                da(z16);
            }
        }
    }

    private final void O9() {
        if (FastClickUtils.isFastDoubleClick("QFSAggregationTitleViewPartV2")) {
            return;
        }
        boolean z16 = !this.mIsCollectState;
        QLog.d("QFSAggregationTitleViewPartV2", 1, "handleClickCollectButtonInUnified collectionAction:" + z16);
        String str = this.mInitBean.getFeedUnifiedTag().unifiedType.get();
        String str2 = this.mInitBean.getFeedUnifiedTag().unifiedId.get();
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = this.mViewModel;
        if (qFSFlowAggregationViewModel != null) {
            qFSFlowAggregationViewModel.n2(str, str2, z16);
        }
        da(z16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
    
        if (r0 == true) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void P9() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData;
        FeedCloudMeta$StShare feedCloudMeta$StShare;
        PBStringField pBStringField;
        String str;
        boolean z16;
        if (o83.b.f422214a.a() && (qQCircleFeedBase$StMusicPageData = this.mMusicPageData) != null) {
            Intrinsics.checkNotNull(qQCircleFeedBase$StMusicPageData);
            if (qQCircleFeedBase$StMusicPageData.music != null) {
                QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData2 = this.mMusicPageData;
                Intrinsics.checkNotNull(qQCircleFeedBase$StMusicPageData2);
                boolean z17 = true;
                if (TextUtils.isEmpty(qQCircleFeedBase$StMusicPageData2.music.playUrl.get())) {
                    QLog.d("QFSAggregationTitleViewPartV2", 1, "initMusicCollectView, playUrl is empty!");
                    return;
                }
                QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData3 = this.mMusicPageData;
                Intrinsics.checkNotNull(qQCircleFeedBase$StMusicPageData3);
                if (qQCircleFeedBase$StMusicPageData3.music.MID.get() != null) {
                    QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData4 = this.mMusicPageData;
                    Intrinsics.checkNotNull(qQCircleFeedBase$StMusicPageData4);
                    String str2 = qQCircleFeedBase$StMusicPageData4.music.MID.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "mMusicPageData!!.music.MID.get()");
                    this.mSongMid = str2;
                    QFSFlowAggregationViewModel qFSFlowAggregationViewModel = this.mViewModel;
                    if (qFSFlowAggregationViewModel != null) {
                        qFSFlowAggregationViewModel.C2(str2);
                    }
                }
                QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData5 = this.mMusicPageData;
                Intrinsics.checkNotNull(qQCircleFeedBase$StMusicPageData5);
                boolean z18 = qQCircleFeedBase$StMusicPageData5.is_collect.get();
                this.mIsCollectState = z18;
                QLog.d("QFSAggregationTitleViewPartV2", 1, "initMusicCollectView, mid:" + this.mSongMid + ", isCollect:" + z18);
                QFSFlowAggregationViewModel qFSFlowAggregationViewModel2 = this.mViewModel;
                if (qFSFlowAggregationViewModel2 != null) {
                    qFSFlowAggregationViewModel2.M = Boolean.valueOf(this.mIsCollectState);
                }
                da(this.mIsCollectState);
                ImageView imageView = this.mIvCollectBtn;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData6 = this.mMusicPageData;
                if (qQCircleFeedBase$StMusicPageData6 != null && (feedCloudMeta$StShare = qQCircleFeedBase$StMusicPageData6.shareInfo) != null && (pBStringField = feedCloudMeta$StShare.url) != null && (str = pBStringField.get()) != null) {
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                z17 = false;
                if (z17) {
                    ImageView imageView2 = this.mIvShareBtn;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                } else {
                    ImageView imageView3 = this.mIvShareBtn;
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                    }
                }
                E9();
            }
        }
    }

    private final void Q9() {
        MutableLiveData<QFSFlowAggregationViewModel.a> Z1;
        MutableLiveData<QFSFlowAggregationViewModel.a> b26;
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = this.mViewModel;
        if (qFSFlowAggregationViewModel != null && (b26 = qFSFlowAggregationViewModel.b2()) != null) {
            b26.observe(getHostFragment(), new Observer() { // from class: x30.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    l.R9(l.this, (QFSFlowAggregationViewModel.a) obj);
                }
            });
        }
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel2 = this.mViewModel;
        if (qFSFlowAggregationViewModel2 != null && (Z1 = qFSFlowAggregationViewModel2.Z1()) != null) {
            Z1.observe(getHostFragment(), new Observer() { // from class: x30.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    l.S9(l.this, (QFSFlowAggregationViewModel.a) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(l this$0, QFSFlowAggregationViewModel.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSAggregationTitleViewPartV2", 1, "reqCollectionLiveData, type:" + this$0.mInitBean.getAggregationType() + " mid:" + this$0.mSongMid + ", result:" + aVar);
        boolean z16 = aVar.f84759b;
        this$0.mIsCollectState = z16;
        this$0.da(z16);
        if (aVar.f84760c) {
            this$0.aa(aVar.f84758a, aVar.f84759b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(l this$0, QFSFlowAggregationViewModel.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QFSAggregationTitleViewPartV2", 1, "reqCollectionLiveData, result:" + aVar);
        boolean z16 = aVar.f84759b;
        this$0.mIsCollectState = z16;
        this$0.da(z16);
        if (aVar.f84760c) {
            this$0.aa(aVar.f84758a, aVar.f84759b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(l this$0, UIStateData uIStateData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M9(uIStateData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
    
        if (r6 == true) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void U9(l this$0, Pair pair) {
        PBStringField pBStringField;
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean isCollect = (Boolean) pair.first;
        FeedCloudMeta$StShare feedCloudMeta$StShare = (FeedCloudMeta$StShare) pair.second;
        boolean z17 = true;
        QLog.i("QFSAggregationTitleViewPartV2", 1, "isCollect:" + isCollect + " isMusicPage:" + this$0.V9() + " isUnifiedPage:" + this$0.X9());
        this$0.G9();
        if (this$0.X9()) {
            if (feedCloudMeta$StShare != null && (pBStringField = feedCloudMeta$StShare.shareCardInfo) != null && (str = pBStringField.get()) != null) {
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            z17 = false;
            if (z17) {
                ImageView imageView = this$0.mIvShareBtn;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else {
                ImageView imageView2 = this$0.mIvShareBtn;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
        }
        Intrinsics.checkNotNullExpressionValue(isCollect, "isCollect");
        this$0.mIsCollectState = isCollect.booleanValue();
        ImageView imageView3 = this$0.mIvCollectBtn;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        }
        if (Intrinsics.areEqual("template", this$0.mInitBean.getFeedUnifiedTag().unifiedType.get())) {
            ImageView imageView4 = this$0.mIvCollectBtn;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        } else {
            ImageView imageView5 = this$0.mIvCollectBtn;
            if (imageView5 != null) {
                imageView5.setVisibility(0);
            }
        }
        this$0.da(isCollect.booleanValue());
    }

    private final boolean V9() {
        if (this.mInitBean.getAggregationType() == 43) {
            return true;
        }
        return false;
    }

    private final boolean W9() {
        if (!V9() && !X9()) {
            return false;
        }
        return true;
    }

    private final boolean X9() {
        if (this.mInitBean.getAggregationType() == 44) {
            return true;
        }
        return false;
    }

    private final void Y9() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void Z9() {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel;
        if (X9() && (qFSFlowAggregationViewModel = this.mViewModel) != null) {
            qFSFlowAggregationViewModel.f2();
        }
    }

    private final void aa(boolean isSuccess, boolean collectionAction) {
        QQToast.makeText(getContext(), 0, o83.a.f422212a.c(L9(), isSuccess, collectionAction, V9()), 0).show();
    }

    private final void ba(FeedCloudMeta$StShare stShare) {
        QCircleShareInfo qCircleShareInfo = new QCircleShareInfo();
        qCircleShareInfo.isShowShareToWechat = false;
        qCircleShareInfo.isShowShareToWechatCircle = false;
        qCircleShareInfo.isShowCopyShortLink = false;
        qCircleShareInfo.type = 6;
        qCircleShareInfo.materialType = J9();
        qCircleShareInfo.materialId = I9();
        qCircleShareInfo.mReportBean = getReportBean();
        QLog.i("QFSAggregationTitleViewPartV2", 2, "showSharePanel... materialType:" + qCircleShareInfo.materialType + " materialId:" + qCircleShareInfo.materialId + " reportBean:" + getReportBean());
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.share.set(stShare);
        qCircleShareInfo.feed = feedCloudMeta$StFeed;
        qCircleShareInfo.feedBlockData = new e30.b(feedCloudMeta$StFeed);
        qCircleShareInfo.shareStyleType = 0;
        qCircleShareInfo.source = 11;
        broadcastMessage("share_action_show_share_sheet", qCircleShareInfo);
    }

    private final void ca(QQCircleFeedBase$StFeedListBusiRspData data) {
        if (data == null) {
            return;
        }
        if (V9()) {
            this.mMusicPageData = data.musicPageData.get();
            P9();
        } else if (X9()) {
            String a16 = cy.a(data.unifiedTagPageData.publishSchema.get(), QCirclePublishQualityReporter.getTraceId());
            QLog.i("QFSAggregationTitleViewPartV2", 1, "schema:" + a16);
            this.mUnifiedTagPageData = data.unifiedTagPageData.get();
            QFSFlowAggregationViewModel qFSFlowAggregationViewModel = this.mViewModel;
            if (qFSFlowAggregationViewModel != null) {
                qFSFlowAggregationViewModel.A2(a16);
            }
        }
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel2 = this.mViewModel;
        if (qFSFlowAggregationViewModel2 != null) {
            qFSFlowAggregationViewModel2.y2(true);
        }
    }

    private final void da(boolean collectState) {
        if (collectState) {
            ImageView imageView = this.mIvCollectBtn;
            Intrinsics.checkNotNull(imageView);
            imageView.setImageResource(R.drawable.qui_music_collected);
        } else {
            ImageView imageView2 = this.mIvCollectBtn;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setImageResource(R.drawable.qui_star);
        }
    }

    private final void initData() {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel;
        if (this.mInitBean.getSchemeAttrs() != null && !TextUtils.isEmpty(this.mInitBean.getSchemeAttrs().get(QCircleScheme.AttrQQPublish.ARK_SHARE_AUTHOR)) && (qFSFlowAggregationViewModel = this.mViewModel) != null) {
            qFSFlowAggregationViewModel.B2(Boolean.TRUE);
        }
    }

    private final void initViewModel() {
        MutableLiveData<Pair<Boolean, FeedCloudMeta$StShare>> mutableLiveData;
        MutableLiveData<UIStateData<QQCircleFeedBase$StFeedListBusiRspData>> X1;
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = (QFSFlowAggregationViewModel) getViewModel(QFSFlowAggregationViewModel.class);
        this.mViewModel = qFSFlowAggregationViewModel;
        if (qFSFlowAggregationViewModel != null && (X1 = qFSFlowAggregationViewModel.X1()) != null) {
            X1.observe(getHostFragment(), new Observer() { // from class: x30.f
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    l.T9(l.this, (UIStateData) obj);
                }
            });
        }
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel2 = this.mViewModel;
        if (qFSFlowAggregationViewModel2 != null && (mutableLiveData = qFSFlowAggregationViewModel2.I) != null) {
            mutableLiveData.observe(getHostFragment(), new Observer() { // from class: x30.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    l.U9(l.this, (Pair) obj);
                }
            });
        }
        Q9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSAggregationUpdateEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAggregationTitleViewPartV2";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        FeedCloudMeta$StShare feedCloudMeta$StShare;
        FeedCloudMeta$StShare feedCloudMeta$StShare2;
        PBStringField pBStringField;
        FeedCloudMeta$StShare feedCloudMeta$StShare3;
        FeedCloudMeta$StShare feedCloudMeta$StShare4;
        PBStringField pBStringField2;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.y_2) {
            if (!getPartManager().onBackEvent() && getActivity() != null) {
                getActivity().finish();
            }
        } else if (v3.getId() == R.id.f165948y60) {
            if (V9()) {
                N9();
            } else if (X9()) {
                O9();
            }
        } else if (v3.getId() == R.id.f165970y94 && !FastClickUtils.isFastDoubleClick("QFSAggregationTitleViewPartV2")) {
            String str = null;
            if (V9()) {
                QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData = this.mMusicPageData;
                if (qQCircleFeedBase$StMusicPageData != null && (feedCloudMeta$StShare4 = qQCircleFeedBase$StMusicPageData.shareInfo) != null && (pBStringField2 = feedCloudMeta$StShare4.shareCardInfo) != null) {
                    str = pBStringField2.get();
                }
                QLog.i("QFSAggregationTitleViewPartV2", 1, "shareCardInfo:" + str);
                QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData2 = this.mMusicPageData;
                if (qQCircleFeedBase$StMusicPageData2 != null && (feedCloudMeta$StShare3 = qQCircleFeedBase$StMusicPageData2.shareInfo) != null) {
                    ba(feedCloudMeta$StShare3);
                }
            } else if (X9()) {
                QQCircleFeedBase$StUnifiedTagPageData qQCircleFeedBase$StUnifiedTagPageData = this.mUnifiedTagPageData;
                if (qQCircleFeedBase$StUnifiedTagPageData != null && (feedCloudMeta$StShare2 = qQCircleFeedBase$StUnifiedTagPageData.shareInfo) != null && (pBStringField = feedCloudMeta$StShare2.shareCardInfo) != null) {
                    str = pBStringField.get();
                }
                QLog.i("QFSAggregationTitleViewPartV2", 1, "shareCardInfo:" + str);
                QQCircleFeedBase$StUnifiedTagPageData qQCircleFeedBase$StUnifiedTagPageData2 = this.mUnifiedTagPageData;
                if (qQCircleFeedBase$StUnifiedTagPageData2 != null && (feedCloudMeta$StShare = qQCircleFeedBase$StUnifiedTagPageData2.shareInfo) != null) {
                    ba(feedCloudMeta$StShare);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.mIvBack = (ImageView) rootView.findViewById(R.id.y_2);
        this.mIvCollectBtn = (ImageView) rootView.findViewById(R.id.f165948y60);
        this.mIvShareBtn = (ImageView) rootView.findViewById(R.id.f165970y94);
        if (getHostFragment() != null) {
            getHostFragment().setExcludeInteractiveView(this.mIvBack);
            getHostFragment().setExcludeInteractiveView(this.mIvCollectBtn);
        }
        ImageView imageView = this.mIvBack;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        ImageView imageView2 = this.mIvCollectBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        ImageView imageView3 = this.mIvShareBtn;
        if (imageView3 != null) {
            imageView3.setOnClickListener(this);
        }
        if (W9()) {
            initViewModel();
            initData();
            Z9();
        }
        Y9();
        ImageView imageView4 = this.mIvShareBtn;
        if (imageView4 != null) {
            com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_material_type", J9()), TuplesKt.to("xsj_material_id", I9()));
            com.tencent.mobileqq.wink.report.a.d(aVar, imageView4, "em_xsj_share_button", null, null, null, mapOf, null, 92, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartPause(activity);
        this.isFirstResume = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel;
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartResume(activity);
        if (!this.isFirstResume && !TextUtils.isEmpty(this.mSongMid) && (qFSFlowAggregationViewModel = this.mViewModel) != null) {
            qFSFlowAggregationViewModel.e2(this.mSongMid);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof QFSAggregationUpdateEvent) {
            QFSAggregationUpdateEvent qFSAggregationUpdateEvent = (QFSAggregationUpdateEvent) event;
            String id5 = qFSAggregationUpdateEvent.getId();
            String unifiedType = qFSAggregationUpdateEvent.getUnifiedType();
            boolean isCollection = qFSAggregationUpdateEvent.getIsCollection();
            boolean z17 = false;
            if (!Intrinsics.areEqual("meterial", unifiedType) && !Intrinsics.areEqual("libTemplate", unifiedType)) {
                z16 = false;
            } else {
                z16 = true;
            }
            boolean areEqual = Intrinsics.areEqual(this.mInitBean.getFeedUnifiedTag().unifiedId.get(), id5);
            if (Intrinsics.areEqual("music", unifiedType) && Intrinsics.areEqual(this.mSongMid, id5)) {
                z17 = true;
            }
            QLog.i("QFSAggregationTitleViewPartV2", 1, "unifiedType:" + unifiedType + " id:" + id5 + " isCollect:" + isCollection + " isMaterialOrTemplate:" + z16 + " isMatchingTag:" + areEqual + " isMatchingSong:" + z17);
            if ((z16 && areEqual) || z17) {
                this.mIsCollectState = isCollection;
                QFSFlowAggregationViewModel qFSFlowAggregationViewModel = this.mViewModel;
                if (qFSFlowAggregationViewModel != null) {
                    qFSFlowAggregationViewModel.M = Boolean.valueOf(isCollection);
                }
                da(this.mIsCollectState);
            }
        }
    }
}
