package y70;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QFSVideoOnPlayEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.cm;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSVideoFeedPlayEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.an;
import com.tencent.biz.qqcircle.immersive.feed.event.h;
import com.tencent.biz.qqcircle.immersive.utils.ba;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.viewmodels.o;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleFeedBase$StFeedListBusiReqData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends y70.a implements View.OnClickListener {
    private static final int U = QCircleApplication.APP.getResources().getDimensionPixelSize(R.dimen.d4u);
    private static final int V = QCircleApplication.APP.getResources().getDimensionPixelSize(R.dimen.d4v);
    private String J;
    private QFSVideoView K;
    private ImageView L;
    private FrameLayout M;
    private int N;
    private int P;
    private an Q;
    private HashMap<Object, Long> R = new HashMap<>();
    private FeedCloudMeta$StFeed S;
    private Option T;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RFWPlayerIOC {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QCircleReportBean getReportBean() {
            return e.this.getReportBean();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public RFWPlayerReportInfo<e30.b> getBusinessReportInfo() {
            return gb0.b.m(((QFSBaseFeedChildPresenter) e.this).E.o("KEY_RFW_VIDEO_FEED_POI", Integer.valueOf(((QFSBaseFeedChildPresenter) e.this).f85018i)));
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            return e.this.E0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements IRFWPlayerSdkInitListener {
        b() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener
        public void onInitSuccess(RFWPlayer rFWPlayer) {
            e.this.K.setOutPutMute(false);
            e.this.K.setLoopBack(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements IRFWPlayerPrepareListener {
        d() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            e.this.K1();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            e.this.w1(rFWPlayer.getRealPlayer());
        }
    }

    private QCircleLayerBean A1() {
        if (r() != null && this.S != null && this.L != null) {
            QCircleLayerBean qCircleLayerBean = new QCircleLayerBean();
            QCircleInitBean qCircleInitBean = new QCircleInitBean();
            qCircleInitBean.setExtraTypeInfo(r());
            qCircleLayerBean.setVideoCurrentPosition(this.N);
            qCircleLayerBean.setFeed(this.S);
            qCircleLayerBean.setFeedListBusiReqData(new QQCircleFeedBase$StFeedListBusiReqData());
            qCircleLayerBean.setUseLoadingPic(true);
            qCircleLayerBean.setSourceType(r().mSubPageType);
            qCircleLayerBean.setFromReportBean(getReportBean().setFromElement(QCircleDaTongConstant.ElementId.EM_XSJ_INFO_CARD));
            qCircleLayerBean.setTransInitBean(qCircleInitBean);
            qCircleLayerBean.setLayerBizAssemblerType("biz_data_share");
            qCircleLayerBean.setGlobalViewModelKey(D1());
            int[] iArr = new int[2];
            this.L.getLocationInWindow(iArr);
            QFSTransitionAnimBean qFSTransitionAnimBean = new QFSTransitionAnimBean();
            int i3 = iArr[0];
            qCircleLayerBean.setTransitionAnimBean(qFSTransitionAnimBean.setLayoutRect(new QFSTransitionAnimBean.SourceRect(i3, iArr[1], this.L.getWidth() + i3, iArr[1] + this.L.getHeight())).setScaleType(ImageView.ScaleType.CENTER_CROP).setImageUrl(this.S.cover.picUrl.get()).setBackTransition(false));
            qCircleLayerBean.getTransitionAnimBean().setCoverDrawable(this.L.getDrawable());
            return qCircleLayerBean;
        }
        return new QCircleLayerBean();
    }

    private ISuperPlayer B1() {
        QFSVideoView z16 = z1();
        if (z16 == null) {
            return null;
        }
        return z16.getSuperPlayer();
    }

    private String C1() {
        String valueOf;
        if (TextUtils.isEmpty(this.J)) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.S;
            if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.get().content.get())) {
                valueOf = this.S.get().content.get();
            } else {
                valueOf = String.valueOf(hashCode());
            }
            this.J = valueOf;
        }
        return this.J;
    }

    private String D1() {
        if (this.S == null) {
            return "";
        }
        return this.S.f398449id.get() + C1();
    }

    private void E1(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        s1();
    }

    private boolean F1() {
        boolean z16;
        QFSVideoView z17 = z1();
        if (z17 == null) {
            return false;
        }
        boolean isOnThirdTab = ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        if (z17.getContext() instanceof Activity) {
            z16 = QCirclePluginUtil.isTopActivityInQCircle((Activity) z17.getContext());
        } else {
            z16 = false;
        }
        QLog.d("QFSMixFeedRecommendVide", 2, "isFeedOnScreen:" + E0() + " isOnThirdTab:" + isOnThirdTab + " pageId:" + y0() + "| isQCircleTopActivity" + z16 + "|" + C1());
        if (E0() && ((isOnThirdTab || !QCirclePluginUtil.isTabMode()) && z16)) {
            QLog.d("QFSMixFeedRecommendVide", 1, "isOnScreen:true|" + C1());
            return true;
        }
        QLog.d("QFSMixFeedRecommendVide", 1, "isOnScreen:false|" + C1());
        return false;
    }

    private boolean G1() {
        QFSVideoView z16 = z1();
        if (z16 == null) {
            return false;
        }
        FeedCloudMeta$StFeed data = z16.getData();
        FeedCloudMeta$StFeed feed = getFeed();
        if (data == null || feed == null) {
            return false;
        }
        return data.f398449id.get().equals(feed.f398449id.get());
    }

    private void H1() {
        o oVar;
        if (this.S == null || (oVar = (o) A0(o.class)) == null) {
            return;
        }
        oVar.C2(this.S);
        w20.a.j().registerDisplaySurface(D1(), oVar);
        com.tencent.biz.qqcircle.launcher.c.u(this.L.getContext(), A1());
    }

    private void J1() {
        q50.b.e().n(this.T);
        this.L.setVisibility(0);
        QLog.d("QFSMixFeedRecommendVide", 1, "onVideoPause show view:|" + C1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1() {
        if (!F1()) {
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new QFSVideoOnPlayEvent(this.S.f398449id.get(), this.C.hashCode()));
        this.L.setVisibility(8);
        q50.b.e().b(this.T);
        QLog.d("QFSMixFeedRecommendVide", 1, "onVideoStart gone view:|" + C1());
    }

    private void L1(ISuperPlayer iSuperPlayer) {
        if (!G1()) {
            O1(false);
            return;
        }
        if (iSuperPlayer.isPlaying()) {
            return;
        }
        if (iSuperPlayer.isPausing()) {
            x1();
            iSuperPlayer.start();
            K1();
            return;
        }
        O1(true);
    }

    private void M1(int i3) {
        VideoReport.setElementId(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_INFO_CARD);
        VideoReport.setElementParams(this.M, ua0.c.e(this.S));
        VideoReport.setElementReuseIdentifier(this.M, QCircleDaTongConstant.ElementId.EM_XSJ_INFO_CARD + i3);
    }

    private void N1(int i3) {
        ISuperPlayer superPlayer;
        QFSVideoView z16 = z1();
        if (z16 == null) {
            superPlayer = null;
        } else {
            superPlayer = z16.getSuperPlayer();
        }
        if (z16 != null && superPlayer != null) {
            superPlayer.setXYaxis(i3);
            z16.requestLayout();
        }
    }

    private void O1(boolean z16) {
        long j3;
        QFSVideoView z17 = z1();
        if (z17 == null) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.S;
        z17.setData(feedCloudMeta$StFeed, this.f85018i);
        z17.setReportBean(getReportBean());
        String N = r.N(feedCloudMeta$StFeed.video.playUrl.get());
        QLog.d("QFSMixFeedRecommendVide", 1, "fs_lifecycle  startANewPlayer , playUrlKey:" + N + "|" + this.R.containsKey(N) + " , feedId = " + feedCloudMeta$StFeed.f398449id.get() + " , hashcode: " + hashCode() + "|" + C1() + " , trace id: " + ba.d(feedCloudMeta$StFeed));
        if (z16 && this.R.containsKey(N)) {
            j3 = this.R.get(N).longValue();
        } else {
            j3 = 0;
        }
        RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(this.S.video.playUrl.get()).setFileId(this.S.video.fileId.get()).setStVideo(gb0.b.k(this.S.video)).setStartOffset(j3).setFromType(12).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", Integer.valueOf(this.f85018i));
        r1(addAttachInfo, N);
        addAttachInfo.setPlayIOC(new a());
        z17.loadPlayOptions(addAttachInfo);
    }

    private void P1(int i3, int i16) {
        QFSVideoView z16 = z1();
        if (z16 == null) {
            return;
        }
        Y0(z16, i3, i16);
    }

    private void Y0(View view, int i3, int i16) {
        int i17;
        if (i16 != 0 && i3 != 0 && view != null) {
            int i18 = -1;
            if (i3 == -1 && i16 == -1) {
                i17 = -1;
            } else {
                i18 = V;
                i17 = (int) ((i18 / i3) * i16);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(i18, i17);
            }
            layoutParams.width = i18;
            layoutParams.height = i17;
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            DisplayUtil.adjustViewSize(new DisplayUtil.AdjustViewSizeParams().setView(view).setDefaultWidth(i18).setDefaultHeight(i17).setTargetWidth(bz.j()).setMaxCardWidthScale(1.5f).setLayoutParams(layoutParams));
            if (QLog.isColorLevel()) {
                QLog.d("QFSMixFeedRecommendVide", 2, "fs_lifecycle setSize origin:" + i3 + "|" + i16 + " , target:" + i18 + "|" + i17 + " , hashCode" + hashCode() + " , pageId:" + y0());
                return;
            }
            return;
        }
        QLog.d("QFSMixFeedRecommendVide", 1, "setSize origin size zero");
    }

    private void r1(RFWPlayerOptions rFWPlayerOptions, String str) {
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new b());
        rFWPlayerOptions.getListenerSet().addSeekListeners(new c(str));
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new d());
    }

    private void s1() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.S;
        if (feedCloudMeta$StFeed == null) {
            QLog.d("QFSMixFeedRecommendVide", 1, "mFeed is null");
            return;
        }
        int i3 = feedCloudMeta$StFeed.video.width.get();
        int i16 = this.S.video.height.get();
        if (i16 > i3) {
            Y0(this.L, -1, -1);
            P1(-1, -1);
        } else {
            Y0(this.L, i3, i16);
            P1(i3, i16);
        }
        DisplayUtil.adjustViewSize(new DisplayUtil.AdjustViewSizeParams().setView(this.M).setDefaultWidth(V).setDefaultHeight(U).setTargetWidth(bz.j()).setMaxCardWidthScale(1.5f).setLayoutParams(this.M.getLayoutParams()));
        N1(2);
    }

    private void t1() {
        QLog.d("QFSMixFeedRecommendVide", 1, "bindCoverData show view:|" + C1());
        this.L.setVisibility(0);
        q50.b.e().b(this.T);
        Option requestHeight = Option.obtain().setTargetView(this.L).setUrl(this.S.cover.picUrl.get()).setRequestWidth(V).setRequestHeight(U);
        this.T = requestHeight;
        requestHeight.setSupportRecycler(true);
        this.T.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
        QCircleFeedPicLoader.g().loadImage(this.T);
        Q0();
    }

    private void u1() {
        QFSVideoView z16 = z1();
        if (z16 == null) {
            return;
        }
        z16.bindData(getFeed(), this.f85018i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (java.lang.Math.abs(r1 - r0.longValue()) > 100) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void v1(int i3, int i16, String str) {
        if (i16 == this.N && this.P == i3) {
            return;
        }
        Long l3 = this.R.get(str);
        if (l3 != null) {
            long j3 = i3;
            if (j3 != l3.longValue()) {
            }
            this.N = i16;
            this.P = i3;
            if (this.Q == null) {
                this.Q = new an();
            }
            this.Q.h(i3);
            this.Q.j(i16);
            T0(this.Q);
        }
        this.R.put(str, Long.valueOf(i16));
        this.N = i16;
        this.P = i3;
        if (this.Q == null) {
        }
        this.Q.h(i3);
        this.Q.j(i16);
        T0(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(ISuperPlayer iSuperPlayer) {
        QFSVideoView z16 = z1();
        if (z16 != null && this.S != null && iSuperPlayer != null && F1()) {
            x1();
            iSuperPlayer.setXYaxis(2);
            z16.start();
        }
    }

    private void x1() {
        QFSVideoView z16 = z1();
        if (z16 != null && this.S != null) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(new e30.b(this.S)));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            buildElementParams.put("xsj_custom_pgid", r0());
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoEntity build = new VideoEntity.Builder().setContentId(this.S.f398449id.get()).setPage((Object) r0()).setContentType(2).setVideoDuration(this.S.video.duration.get()).setVideoView((View) z16).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = z16.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
            }
            QLog.i("QFSMixFeedRecommendVide", 1, "dtReportBindVideoData  pos = " + this.f85018i);
        }
    }

    private void y1(QFSVideoFeedPlayEvent qFSVideoFeedPlayEvent) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.S;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StVideo = feedCloudMeta$StFeed.video) != null && qFSVideoFeedPlayEvent != null) {
            String N = r.N(feedCloudMeta$StVideo.playUrl.get());
            if (!TextUtils.isEmpty(N) && this.S.f398449id.get().equals(qFSVideoFeedPlayEvent.feedId)) {
                this.R.put(N, Long.valueOf(qFSVideoFeedPlayEvent.progress));
            }
        }
    }

    private QFSVideoView z1() {
        return this.K;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean E0() {
        if (h1() != null && h1().isContainerOnScreen()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void L0(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
        super.L0(qQCircleDitto$StItemInfo, i3);
        FeedCloudMeta$StFeed feed = getFeed();
        this.S = feed;
        if (feed == null) {
            return;
        }
        s1();
        t1();
        u1();
        M1(i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void K0() {
        super.K0();
        s1();
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        this.M = (FrameLayout) view.findViewById(R.id.f5182295);
        this.K = (QFSVideoView) view.findViewById(R.id.f517228v);
        this.L = (ImageView) view.findViewById(R.id.f516928s);
        this.M.setOnClickListener(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void Q0() {
        super.Q0();
        if (!F1()) {
            return;
        }
        QCircleLpReportDc05507.report(ua0.c.c(getFeed()).setActionType(1).setSubActionType(1).setPageId(y0()).setFirstFeedId(w20.a.j().h()));
        QLog.d("QFSMixFeedRecommendVide", 1, "reportExpose:|" + C1());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void T0(h hVar) {
        cm cmVar = this.f85019m;
        if (cmVar == null) {
            return;
        }
        cmVar.b(hVar);
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        super.a();
        if (QCirclePluginUtil.isSharePanelOnShow()) {
            return;
        }
        QFSVideoView z16 = z1();
        ISuperPlayer B1 = B1();
        if (z16 != null && B1 != null) {
            VideoReport.unbindVideoPlayerInfo(z16);
            z16.release();
            QLog.d("QFSMixFeedRecommendVide", 1, "releasePlayer:" + C1());
        }
        this.R.clear();
        J1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSVideoFeedPlayEvent.class);
        eventClass.add(QCircleConfigChangeEvent.class);
        return eventClass;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f5182295) {
            H1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof QFSVideoFeedPlayEvent) {
            y1((QFSVideoFeedPlayEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            E1((QCircleConfigChangeEvent) simpleBaseEvent);
        }
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void pause() {
        ISuperPlayer B1 = B1();
        if (B1 == null) {
            return;
        }
        QFSVideoView z16 = z1();
        if (B1.isPlaying() && z16 != null) {
            VideoReport.unbindVideoPlayerInfo(z16);
            B1.pause();
        }
        J1();
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        super.play();
        if (!F1()) {
            return;
        }
        Q0();
        ISuperPlayer B1 = B1();
        if (B1 != null) {
            L1(B1);
        } else {
            O1(true);
        }
    }

    @Override // y70.a, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSMixFeedRecommendVide";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements IRFWPlayerSeekListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f449534d;

        c(String str) {
            this.f449534d = str;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            e.this.v1(i3, i16, this.f449534d);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        }
    }
}
