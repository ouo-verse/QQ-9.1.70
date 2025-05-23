package s80;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.search.viewmodel.QFSSearchViewModel;
import com.tencent.biz.qqcircle.immersive.views.search.feed.QFSSearchFeedResultItemView;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.f;
import com.tencent.biz.qqcircle.immersive.views.search.util.k;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import p70.i;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener, e80.g, e80.c, f.b {
    private RoundCorneredRelativeLayout I;
    protected ImageView J;
    private QCircleAsyncTextView K;
    protected ImageView L;
    protected QQBlurViewWrapper M;
    protected Option N;
    protected i P;
    protected com.tencent.biz.qqcircle.immersive.views.search.util.g Q;
    protected com.tencent.biz.qqcircle.immersive.views.search.util.f R;
    protected final k S = new k();
    protected ImageView T;

    private void B1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int i3;
        int i16;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        Size r16 = ad.r(feedCloudMeta$StFeed, this.C, com.tencent.biz.qqcircle.immersive.utils.a.g());
        if (r16.getWidth() != 0 && r16.getHeight() != 0) {
            ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
            layoutParams.width = r16.getWidth();
            layoutParams.height = r16.getHeight();
            this.J.requestLayout();
            q1(r16.getWidth(), r16.getHeight());
            i3 = r16.getWidth();
            i16 = r16.getHeight();
        } else if (this.J.getLayoutParams() != null) {
            i3 = this.J.getLayoutParams().width;
            i16 = this.J.getLayoutParams().height;
        } else {
            i3 = 0;
            i16 = 0;
        }
        n1(feedCloudMeta$StFeed, i3, i16);
    }

    private void C1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_POSITION, 3);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_IS_PLAY, Integer.valueOf(this.Q.a()));
        VideoReport.setElementParams(this.C, hashMap);
        EventCollector.getInstance().onViewClicked(this.C);
        x1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private QCircleLayerBean h1() {
        if (this.f85017h != 0) {
            View view = this.C;
            if (view instanceof QFSSearchFeedResultItemView) {
                QFSSearchFeedResultItemView qFSSearchFeedResultItemView = (QFSSearchFeedResultItemView) view;
                QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
                if (((FeedCloudMeta$StFeed) this.f85017h).poiInfo.has() && qFSSearchFeedResultItemView.getQCircleExtraTypeInfo() != null && qFSSearchFeedResultItemView.getQCircleExtraTypeInfo().pageType == 12) {
                    qCircleLayerBean.setPoiInfo(((FeedCloudMeta$StFeed) this.f85017h).poiInfo.get());
                }
                qCircleLayerBean.setFeed((FeedCloudMeta$StFeed) this.f85017h);
                qCircleLayerBean.setUseLoadingPic(true);
                qCircleLayerBean.setSourceType(qFSSearchFeedResultItemView.getQCircleExtraTypeInfo().pageType);
                qCircleLayerBean.setLayerBizAssemblerType("biz_search_result_page");
                qCircleLayerBean.setFeedListBusiReqData(new QQCircleFeedBase$StFeedListBusiReqData());
                qCircleLayerBean.setFromReportBean(getReportBean().m466clone());
                QFSSearchBean qFSSearchBean = new QFSSearchBean();
                qFSSearchBean.setExtraTypeInfo(qFSSearchFeedResultItemView.getQCircleExtraTypeInfo());
                qFSSearchBean.setUserSource(p.s(m0()));
                qCircleLayerBean.setTransInitBean(qFSSearchBean);
                i iVar = this.P;
                if (iVar != null) {
                    qCircleLayerBean.setPageCode(iVar.hashCode());
                } else {
                    qCircleLayerBean.setPageCode(this.J.getContext().hashCode());
                }
                HashMap<String, String> hashMap = new HashMap<>(2);
                hashMap.put("feedid", ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
                i iVar2 = this.P;
                if (iVar2 != null) {
                    hashMap.put(QCircleSchemeAttr.Detail.CURRENT_TIME, String.valueOf(iVar2.N1(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())));
                }
                qCircleLayerBean.setSchemeAttrs(hashMap);
                w1(qCircleLayerBean, qFSSearchFeedResultItemView);
                QLog.i("QFSSearchFeedResultBasePresenter", 1, "#getDetailInitBean: position=" + qFSSearchFeedResultItemView.getDataPosInList() + ", id=" + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get() + ", content=" + ((FeedCloudMeta$StFeed) this.f85017h).content.get() + ", playUrl=" + p.m((FeedCloudMeta$StFeed) this.f85017h));
                return qCircleLayerBean;
            }
        }
        return new QCircleLayerBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void m1() {
        B1((FeedCloudMeta$StFeed) this.f85017h);
    }

    private void r1(View view, int i3) {
        p.E(this.E, view, this.f85018i, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void u1(QCircleLayerBean qCircleLayerBean, QFSSearchFeedResultItemView qFSSearchFeedResultItemView) {
        qCircleLayerBean.setGlobalViewModelKey(qFSSearchFeedResultItemView.getQCircleExtraTypeInfo().mGlobalViewModelKey);
        qCircleLayerBean.setDataPosInList(qFSSearchFeedResultItemView.getDataPosInList());
        int[] iArr = new int[2];
        this.J.getLocationInWindow(iArr);
        QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
        int i3 = iArr[0];
        qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], this.J.getWidth() + i3, iArr[1] + this.J.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(((FeedCloudMeta$StFeed) this.f85017h).cover.picUrl.get()));
        qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(this.J.getDrawable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v1(QCircleLayerBean qCircleLayerBean) {
        t80.b bVar = (t80.b) A0(t80.b.class);
        bVar.I2((FeedCloudMeta$StFeed) this.f85017h);
        bVar.H2(this.P.e2());
        ArrayList arrayList = new ArrayList();
        T t16 = this.f85017h;
        if (t16 != 0) {
            arrayList.add((FeedCloudMeta$StFeed) t16);
        }
        bVar.G2(arrayList);
        String E2 = bVar.E2();
        w20.a.j().registerDisplaySurface(E2, bVar);
        qCircleLayerBean.setGlobalViewModelKey(E2);
        qCircleLayerBean.setDataPosInList(0);
    }

    private void w1(QCircleLayerBean qCircleLayerBean, QFSSearchFeedResultItemView qFSSearchFeedResultItemView) {
        boolean z16;
        if (this.P.t2()) {
            v1(qCircleLayerBean);
        } else {
            u1(qCircleLayerBean, qFSSearchFeedResultItemView);
        }
        if (o.U0() && !this.P.t2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        qCircleLayerBean.setReUsePlayerWhenExit(z16);
    }

    private void x1() {
        i iVar = this.P;
        if (iVar == null || iVar.r2()) {
            return;
        }
        this.P.F2(true);
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FIRST_CLCK_DURATION, Long.valueOf((System.currentTimeMillis() - this.P.g2()) / 1000));
        ua0.i.h(this.C, "ev_xsj_abnormal_clck", hashMap);
    }

    private void y1() {
        this.I.setOnClickListener(this);
        this.K.setOnClickListener(this);
        this.Q.e();
        this.L.setVisibility(8);
        this.M.setVisibility(8);
    }

    protected void A1() {
        VideoReport.setElementParam(this.C, QCircleDaTongConstant.ElementParamKey.XSJ_IS_MUTE, Integer.valueOf(!k1() ? 1 : 0));
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.f.b
    public void B(boolean z16) {
        A1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.f.b
    public void G() {
        o1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        B1((FeedCloudMeta$StFeed) this.f85017h);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void M0() {
        super.M0();
        this.R.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (RoundCorneredRelativeLayout) view.findViewById(R.id.f52322_h);
        this.J = (ImageView) view.findViewById(R.id.f363914f);
        this.K = (QCircleAsyncTextView) view.findViewById(R.id.f365814y);
        this.L = (ImageView) view.findViewById(R.id.f52422_r);
        this.M = (QQBlurViewWrapper) view.findViewById(R.id.f52432_s);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        ImageView imageView = (ImageView) view.findViewById(R.id.f363514b);
        this.T = imageView;
        this.Q = new com.tencent.biz.qqcircle.immersive.views.search.util.g(imageView, (e80.g) view);
        this.R = new com.tencent.biz.qqcircle.immersive.views.search.util.f(view, this);
        float a16 = cx.a(8.0f);
        this.I.setRadius(a16, a16, a16, a16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    @CallSuper
    public void a() {
        this.Q.h();
        s1(false);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QCircleConfigChangeEvent.class);
        return eventClass;
    }

    public abstract void i1();

    @Override // e80.g
    public boolean isPlaying() {
        return this.Q.c();
    }

    public void j1() {
        com.tencent.biz.qqcircle.immersive.views.search.util.f fVar = this.R;
        if (fVar != null) {
            fVar.e();
        }
    }

    public boolean k1() {
        com.tencent.biz.qqcircle.immersive.views.search.util.f fVar = this.R;
        if (fVar != null && fVar.H()) {
            return true;
        }
        return false;
    }

    @Override // e80.c
    public boolean l() {
        com.tencent.biz.qqcircle.immersive.views.search.util.g gVar = this.Q;
        if (gVar != null && gVar.l()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l1() {
        if (this.f85017h == 0) {
            return;
        }
        com.tencent.biz.qqcircle.launcher.c.u(this.J.getContext(), h1());
        C1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        String str;
        if (this.J.getTag(R.id.f363914f) instanceof String) {
            str = (String) this.J.getTag(R.id.f363914f);
        } else {
            str = "";
        }
        this.J.setTag(R.id.f363914f, feedCloudMeta$StFeed.cover.picUrl.get());
        if (!str.equals(feedCloudMeta$StFeed.cover.picUrl.get())) {
            Option loadingDrawableColor = Option.getDefaultOptions(null).setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(this.J).setFromPreLoad(false).setPredecode(true).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawableColor(0);
            this.N = loadingDrawableColor;
            loadingDrawableColor.setSupportRecycler(true);
            this.N.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            QCircleFeedPicLoader.g().loadImage(this.N);
        }
    }

    protected void o1() {
        VideoReport.setElementParam(this.C, QCircleDaTongConstant.ElementParamKey.XSJ_CLCK_POSITION, 5);
        EventCollector.getInstance().onViewClicked(this.C);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (p.w((FeedCloudMeta$StFeed) this.f85017h)) {
            if (view == this.I) {
                i3 = 6;
            } else if (view == this.K) {
                i3 = 4;
            } else {
                i3 = 1000;
            }
            r1(view, i3);
        } else if (view == this.I || view == this.K) {
            l1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public final void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            x0().post(new Runnable() { // from class: s80.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.m1();
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @CallSuper
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (this.f85017h == feedCloudMeta$StFeed) {
            B1(feedCloudMeta$StFeed);
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (this.P == null) {
            this.P = (i) A0(i.class);
            this.R.j((QFSSearchViewModel) QCirclePluginUtil.getQCircleBaseFragment(m0()).getViewModel(QFSSearchViewModel.class));
        }
        y1();
        B1(feedCloudMeta$StFeed);
        this.Q.h();
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    @CallSuper
    public void pause() {
        this.Q.h();
        s1(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    @CallSuper
    public void play() {
        this.Q.setStatusPlay();
        QFSSearchVideoPlayHelper.N(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), this.C.hashCode());
        t1(false);
    }

    protected abstract void q1(int i3, int i16);

    protected abstract void s1(boolean z16);

    @Override // e80.g
    @CallSuper
    public void stop() {
        this.Q.h();
        s1(false);
    }

    protected abstract void t1(boolean z16);

    public void z1(boolean z16) {
        com.tencent.biz.qqcircle.immersive.views.search.util.g gVar = this.Q;
        if (gVar != null) {
            gVar.f(z16);
        }
    }
}
