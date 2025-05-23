package x30;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.immersive.aggregation.QFSFlowAggregationViewModel;
import com.tencent.biz.qqcircle.immersive.aggregation.bean.QFSFlowAggregationInitBean;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.Pair;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeedMusic;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedListBusiRspData;
import qqcircle.QQCircleFeedBase$StMusicPageData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends u implements View.OnClickListener {
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f447130d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f447131e;

    /* renamed from: f, reason: collision with root package name */
    private QFSFlowAggregationViewModel f447132f;

    /* renamed from: h, reason: collision with root package name */
    private QFSFlowAggregationInitBean f447133h;

    /* renamed from: i, reason: collision with root package name */
    private QQCircleFeedBase$StMusicPageData f447134i;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f447135m;
    private String C = "";
    private boolean E = true;

    public e(QFSFlowAggregationInitBean qFSFlowAggregationInitBean) {
        this.f447133h = qFSFlowAggregationInitBean;
        this.f447135m = qFSFlowAggregationInitBean.getAggregationType() == 43;
    }

    private void C9() {
        VideoReport.setElementId(this.f447131e, QCircleDaTongConstant.ElementId.EM_XSJ_MUSIC_COLLECT);
        VideoReport.setEventDynamicParams(this.f447131e, new IDynamicParams() { // from class: x30.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map G9;
                G9 = e.this.G9(str);
                return G9;
            }
        });
        VideoReport.setElementExposePolicy(this.f447131e, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.f447131e, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D9(UIStateData<QQCircleFeedBase$StFeedListBusiRspData> uIStateData) {
        if (uIStateData == null) {
            return;
        }
        if (uIStateData.getIsLoadMore()) {
            QLog.d("QFSAggregationTitleView", 1, "handleBusiRspData, loadMore data do not refresh UI.");
        } else if (uIStateData.getState() == 3) {
            K9(uIStateData.getData());
        }
    }

    private void E9() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData;
        if (!FastClickUtils.isFastDoubleClick("QFSAggregationTitleView") && (qQCircleFeedBase$StMusicPageData = this.f447134i) != null && qQCircleFeedBase$StMusicPageData.music != null) {
            boolean z16 = !this.D;
            QLog.d("QFSAggregationTitleView", 1, "handleClickCollectButton, songMid:" + this.C + ", collectionAction:" + z16);
            this.f447132f.m2(this.C, z16);
            L9(z16);
            J9(z16);
        }
    }

    private void F9() {
        QQCircleFeedBase$StMusicPageData qQCircleFeedBase$StMusicPageData;
        FeedCloudMeta$StFeedMusic feedCloudMeta$StFeedMusic;
        if (o83.b.f422214a.a() && (qQCircleFeedBase$StMusicPageData = this.f447134i) != null && (feedCloudMeta$StFeedMusic = qQCircleFeedBase$StMusicPageData.music) != null) {
            if (TextUtils.isEmpty(feedCloudMeta$StFeedMusic.playUrl.get())) {
                QLog.d("QFSAggregationTitleView", 1, "initMusicCollectView, playUrl is empty!");
                return;
            }
            if (this.f447134i.music.MID.get() != null) {
                this.C = this.f447134i.music.MID.get();
            }
            this.D = this.f447134i.is_collect.get();
            QLog.d("QFSAggregationTitleView", 1, "initMusicCollectView, mid:" + this.C + ", isCollect:" + this.D);
            L9(this.D);
            this.f447131e.setVisibility(0);
            C9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map G9(String str) {
        String str2;
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (!this.D) {
            str2 = QCircleDaTongConstant.ElementParamValue.COLLECT;
        } else {
            str2 = QCircleDaTongConstant.ElementParamValue.COLLECT_CANCEL;
        }
        buildElementParams.put("xsj_action_type", str2);
        return buildElementParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void H9(Pair pair) {
        QLog.d("QFSAggregationTitleView", 1, "modCollectLiveData, result:" + pair);
        if (((Integer) pair.first).intValue() == 1) {
            this.D = ((Boolean) pair.second).booleanValue();
        } else {
            this.D = !((Boolean) pair.second).booleanValue();
        }
        L9(this.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I9(QFSFlowAggregationViewModel.a aVar) {
        QLog.d("QFSAggregationTitleView", 1, "getReqCollectionLiveData, mid:" + this.C + ", result:" + aVar);
        boolean z16 = aVar.f84759b;
        this.D = z16;
        L9(z16);
    }

    private void J9(boolean z16) {
        if (z16) {
            QQToast.makeText(getContext(), 0, "\u5df2\u6536\u85cf", 0).show();
        } else {
            QQToast.makeText(getContext(), 0, "\u5df2\u53d6\u6d88\u6536\u85cf", 0).show();
        }
    }

    private void K9(QQCircleFeedBase$StFeedListBusiRspData qQCircleFeedBase$StFeedListBusiRspData) {
        if (qQCircleFeedBase$StFeedListBusiRspData == null) {
            return;
        }
        this.f447134i = qQCircleFeedBase$StFeedListBusiRspData.musicPageData.get();
        F9();
    }

    private void L9(boolean z16) {
        if (z16) {
            this.f447131e.setImageResource(R.drawable.qui_music_collected);
        } else {
            this.f447131e.setImageResource(R.drawable.qui_star);
        }
    }

    private void initViewModel() {
        QFSFlowAggregationViewModel qFSFlowAggregationViewModel = (QFSFlowAggregationViewModel) getViewModel(QFSFlowAggregationViewModel.class);
        this.f447132f = qFSFlowAggregationViewModel;
        qFSFlowAggregationViewModel.X1().observe(getHostFragment(), new Observer() { // from class: x30.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.this.D9((UIStateData) obj);
            }
        });
        this.f447132f.d2().observe(getHostFragment(), new Observer() { // from class: x30.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.this.H9((Pair) obj);
            }
        });
        this.f447132f.Z1().observe(getHostFragment(), new Observer() { // from class: x30.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                e.this.I9((QFSFlowAggregationViewModel.a) obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSAggregationTitleView";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.y_2) {
            if (!getPartManager().onBackEvent() && getActivity() != null) {
                getActivity().finish();
            }
        } else if (view.getId() == R.id.f165948y60) {
            E9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        this.f447130d = (ImageView) view.findViewById(R.id.y_2);
        this.f447131e = (ImageView) view.findViewById(R.id.f165948y60);
        if (getHostFragment() != null) {
            getHostFragment().setExcludeInteractiveView(this.f447130d);
            getHostFragment().setExcludeInteractiveView(this.f447131e);
        }
        this.f447130d.setOnClickListener(this);
        this.f447131e.setOnClickListener(this);
        if (this.f447135m && o83.b.f422214a.a()) {
            initViewModel();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.E = false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        if (this.E || TextUtils.isEmpty(this.C)) {
            return;
        }
        this.f447132f.e2(this.C);
    }
}
