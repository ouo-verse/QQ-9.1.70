package q40;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.avbiz.Constants;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.floatingwindow.event.QFSFloatingMuteIconEvent;
import com.tencent.biz.qqcircle.immersive.floatingwindow.event.QFSFloatingPlayPauseEvent;
import com.tencent.biz.qqcircle.immersive.floatingwindow.event.QFSFloatingWindowReleaseEvent;
import com.tencent.biz.qqcircle.immersive.utils.ac;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerUpperData;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSdkInitListener;
import com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import p40.u;
import q40.c;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {
    private QFSVideoView I;
    private ImageView J;
    private Option K;
    private FeedCloudMeta$StFeed L;
    private int M;
    private boolean N;
    private RFWFeedSelectInfo P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends RFWPlayerIOC {
        a() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        /* renamed from: getPlayerUpperData */
        public RFWPlayerUpperData getUpperData() {
            RFWPlayerUpperData rFWPlayerUpperData = new RFWPlayerUpperData();
            Boolean bool = Boolean.FALSE;
            rFWPlayerUpperData.addValue("RFW_ENABLE_BACKGROUND_PAUSE", bool);
            rFWPlayerUpperData.addValue("QFS_PLAYER_MUTE_KEY", bool);
            return rFWPlayerUpperData;
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC
        public boolean isValid() {
            if (u.H().K() == ((QFSBaseFeedChildPresenter) c.this).f85018i) {
                return true;
            }
            return false;
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
            c.this.I.setLoopBack(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: q40.c$c, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C11056c implements IRFWPlayerPrepareListener {
        C11056c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            c.this.J.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d() {
            u.H().H0(8);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onFirstFrameRendered(RFWPlayer rFWPlayer) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: q40.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.C11056c.this.c();
                }
            });
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: q40.e
                @Override // java.lang.Runnable
                public final void run() {
                    c.C11056c.d();
                }
            }, 100L);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerPrepareListener
        public void onVideoPrepared(RFWPlayer rFWPlayer) {
            boolean o06 = u.H().o0();
            boolean h06 = u.H().h0();
            QLog.d("QFP-QFSFloatingVideoPresent", 1, "[onVideoPrepared] isScreenOff: " + o06 + " | isFloatingFolded: " + h06);
            if (((QFSBaseFeedChildPresenter) c.this).f85017h != null && u.H().m0(((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) c.this).f85017h).f398449id.get())) {
                c.this.D1();
                u.H().a0();
                return;
            }
            if (h06) {
                u.H().a0();
                return;
            }
            if (!o06) {
                c.this.D1();
                c.this.t1();
                c.this.I.start();
                boolean i06 = u.H().i0();
                QLog.d("QFP-QFSFloatingVideoPresent", 1, "setMute:" + i06);
                rFWPlayer.setOutputMute(i06);
                return;
            }
            u.H().V0(true);
            rFWPlayer.setOutputMute(true);
            QLog.d("QFP-QFSFloatingVideoPresent", 1, "[onVideoPrepared] update to mute state.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements IRFWPlayerCompletionListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            c.this.S0();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerCompletionListener
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.CLR, "[onCompletion] current is auto scroll: ");
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true)) {
                return;
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: q40.f
                @Override // java.lang.Runnable
                public final void run() {
                    c.d.this.b();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class e implements IRFWPlayerSeekListener {
        e() {
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public void onProgress(String str, int i3, int i16) {
            u.H().T0((FeedCloudMeta$StFeed) ((QFSBaseFeedChildPresenter) c.this).f85017h, i3, i16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onSeekBarProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            re0.b.b(this, seekBar, i3, z16);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onStartTrackingTouch(SeekBar seekBar) {
            re0.b.c(this, seekBar);
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerSeekListener
        public /* synthetic */ void onStopTrackingTouch(SeekBar seekBar) {
            re0.b.d(this, seekBar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A1(int i3, int i16, int i17, String str) {
        u.H().O0(i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B1() {
        if (y1()) {
            return;
        }
        int i3 = this.f85018i + 1;
        RecyclerView recyclerView = (RecyclerView) this.C.getParent();
        QLog.d("QFP-QFSFloatingVideoPresent", 1, "[scrollToNextItem] nextPos: " + i3 + " | prePos: " + this.f85018i);
        if (recyclerView.getAdapter().getItemCount() - 1 >= i3) {
            recyclerView.smoothScrollToPosition(i3);
            com.tencent.biz.qqcircle.immersive.utils.u.c(recyclerView);
        } else {
            if (o.K0()) {
                return;
            }
            E1(this.E, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1() {
        ISuperPlayer superPlayer;
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null && (superPlayer = qFSVideoView.getSuperPlayer()) != null) {
            superPlayer.setXYaxis(2);
        }
    }

    private void E1(@NotNull e30.b bVar, RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        String str;
        FeedCloudMeta$StFeed g16 = bVar.g();
        long R = u.H().R(g16);
        RFWPlayerOptions addAttachInfo = RFWPlayerOptions.obtain(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setPlayUrl(g16.video.playUrl.get()).setFileId(g16.video.fileId.get()).setStVideo(gb0.b.k(g16.video)).setIsMutualExclusion(false).setStartOffset(R).setFromType(15).setPreloadSourceType(QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE).setEnableDataCollect(true).addAttachInfo("ATTACH_INFO_KEY_POI", Integer.valueOf(this.f85018i));
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.isScrollToNext()) {
            z16 = true;
        } else {
            z16 = false;
        }
        RFWPlayerOptions addAttachInfo2 = addAttachInfo.addAttachInfo("ATTACH_INFO_KEY_SCROLL_NEXT", Boolean.valueOf(z16)).addAttachInfo("ATTACH_INFO_KEY_IS_FLOATING", Boolean.TRUE);
        if (rFWFeedSelectInfo != null) {
            str = rFWFeedSelectInfo.getSelectedType();
        } else {
            str = "";
        }
        RFWPlayerOptions addAttachInfo3 = addAttachInfo2.addAttachInfo("ATTACH_INFO_KEY_SELECTED_TYPE", str);
        u.H().R0(0);
        RFWLog.d("QFP-QFSFloatingVideoPresent_" + addAttachInfo3.tag(), RFWLog.USR, "fs_lifecycle  startANewPlayer:" + ac.f90062a.a(g16.content.get()) + R);
        q1(addAttachInfo3);
        this.I.setData(g16, this.f85018i);
        this.I.loadPlayOptions(addAttachInfo3);
    }

    private void F1() {
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView == null) {
            return;
        }
        qFSVideoView.X0(Constants.Business.QQ_CIRCLE_WINDOW);
    }

    private void q1(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions == null) {
            return;
        }
        rFWPlayerOptions.setPlayIOC(new a());
        rFWPlayerOptions.getListenerSet().addSDKInitListeners(new b());
        rFWPlayerOptions.getListenerSet().addPrepareListeners(new C11056c());
        rFWPlayerOptions.getListenerSet().addCompletionListener(new d());
        rFWPlayerOptions.getListenerSet().addErrorStatusListener(new IRFWPlayErrorStatusListener() { // from class: q40.a
            @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayErrorStatusListener
            public final void onVideoPlayError(int i3, int i16, int i17, String str) {
                c.A1(i3, i16, i17, str);
            }
        });
        rFWPlayerOptions.getListenerSet().addSeekListeners(new e());
        rFWPlayerOptions.getListenerSet().addLooperListeners(new f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean s1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        int i16;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = (FeedCloudMeta$StFeed) this.f85017h;
        if (r.B0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2) && i3 == this.f85018i) {
            return true;
        }
        if (r.f0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2) && i3 == (i16 = this.f85018i)) {
            this.f85017h = feedCloudMeta$StFeed;
            this.L = feedCloudMeta$StFeed;
            this.I.setData(feedCloudMeta$StFeed, i16);
            return true;
        }
        if (feedCloudMeta$StFeed != 0) {
            return false;
        }
        RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "onBindData is null: " + i3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void t1() {
        if (this.I != null && this.f85017h != 0) {
            Map<String, ?> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.E));
            buildElementParams.putAll(ua0.c.e((FeedCloudMeta$StFeed) this.f85017h));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            buildElementParams.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, u.H().P());
            VideoEntity build = new VideoEntity.Builder().setContentId(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()).setPage((Object) QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE).setContentType(2).setVideoDuration(((FeedCloudMeta$StFeed) this.f85017h).video.duration.get()).setVideoView((View) this.I).addCustomParams(buildElementParams).ignoreReport(false).bizReady(true).build();
            ISuperPlayer superPlayer = this.I.getSuperPlayer();
            if (superPlayer != null) {
                VideoReport.bindVideoPlayerInfo(superPlayer, build);
            }
            RFWLog.i("QFP-QFSFloatingVideoPresent", RFWLog.USR, "dtReportBindVideoData  pos = " + this.f85018i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void v1(SimpleBaseEvent simpleBaseEvent) {
        if (this.f85017h != 0 && (simpleBaseEvent instanceof QFSFloatingMuteIconEvent)) {
            QFSFloatingMuteIconEvent qFSFloatingMuteIconEvent = (QFSFloatingMuteIconEvent) simpleBaseEvent;
            if (qFSFloatingMuteIconEvent.getTargetFeedId().equals(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get())) {
                this.I.setOutPutMute(qFSFloatingMuteIconEvent.isMute());
            }
        }
    }

    private void w1(SimpleBaseEvent simpleBaseEvent) {
        if ((simpleBaseEvent instanceof QFSFloatingWindowReleaseEvent) && this.I != null && o.z()) {
            this.I.release();
            RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "handRelease");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void x1(SimpleBaseEvent simpleBaseEvent) {
        if (this.f85017h != 0 && (simpleBaseEvent instanceof QFSFloatingPlayPauseEvent)) {
            QFSFloatingPlayPauseEvent qFSFloatingPlayPauseEvent = (QFSFloatingPlayPauseEvent) simpleBaseEvent;
            if (!qFSFloatingPlayPauseEvent.getTargetFeedId().equals(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get()) || this.I.getQCirclePlayer() == null) {
                return;
            }
            int i3 = qFSFloatingPlayPauseEvent.mState;
            if (i3 == 1) {
                t1();
                if (this.I.getQCirclePlayer().isError()) {
                    E1(this.E, this.P);
                    return;
                } else {
                    this.I.start();
                    return;
                }
            }
            if (i3 == 2) {
                VideoReport.unbindVideoPlayerInfo(this.I);
                this.I.pause();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: C1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (s1(feedCloudMeta$StFeed, i3)) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        r1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (QFSVideoView) view.findViewById(R.id.f74163vi);
        this.J = (ImageView) view.findViewById(R.id.f363714d);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void S0() {
        x0().post(new Runnable() { // from class: q40.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.B1();
            }
        });
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean X() {
        RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "canDealWithSimpleFeed true");
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSFloatingPlayPauseEvent.class);
        arrayList.add(QFSFloatingMuteIconEvent.class);
        arrayList.add(QFSFloatingWindowReleaseEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        QLog.d("QFP-QFSFloatingVideoPresent", 1, "fs_lifecycle onDestroy: | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | playView is null | pageId:" + y0());
        QFSVideoView qFSVideoView = this.I;
        if (qFSVideoView != null) {
            qFSVideoView.release();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo == null) {
            return;
        }
        RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "fs_lifecycle onSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        u1(rFWFeedSelectInfo);
        com.tencent.biz.qqcircle.immersive.manager.f.f().i();
        this.N = true;
        F1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        QFSVideoView qFSVideoView;
        super.onFeedUnSelected(rFWFeedSelectInfo);
        RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "fs_lifecycle onFeedUnSelected:" + rFWFeedSelectInfo + " | mPos:" + this.f85018i + " | hashCode:" + hashCode() + " | pageId:" + y0());
        this.J.setVisibility(0);
        this.N = false;
        if (rFWFeedSelectInfo.getPosition() == this.M && (qFSVideoView = this.I) != null) {
            qFSVideoView.release();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPosUpdate(int i3) {
        super.onPosUpdate(i3);
        this.M = i3;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        x1(simpleBaseEvent);
        v1(simpleBaseEvent);
        w1(simpleBaseEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void r1() {
        T t16;
        if (this.J != null && (t16 = this.f85017h) != 0 && ((FeedCloudMeta$StFeed) t16).cover != null && ((FeedCloudMeta$StFeed) t16).cover.picUrl != null) {
            q50.b.e().b(this.K);
            Option targetView = Option.obtain().setUrl(((FeedCloudMeta$StFeed) this.f85017h).cover.picUrl.get()).setTargetView(this.J);
            this.K = targetView;
            targetView.setSupportRecycler(true);
            this.K.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
            this.J.setVisibility(0);
            if (bi.l(this.J, this.K, (FeedCloudMeta$StFeed) this.f85017h)) {
                return;
            }
            QCircleFeedPicLoader.g().loadImage(this.K);
        }
    }

    protected void u1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (z1() && !e1(this.I)) {
            RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "executeFromSelected return");
            return;
        }
        RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "executeFromSelected");
        E1(this.E, rFWFeedSelectInfo);
        this.P = rFWFeedSelectInfo;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFP-QFSFloatingVideoPresent";
    }

    protected boolean y1() {
        View view = this.C;
        if (view != null && (view.getParent() instanceof RecyclerView) && ((RecyclerView) this.C.getParent()).getAdapter() != null && ((RecyclerView) this.C.getParent()).getAdapter().getItemCount() > this.f85018i) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected boolean z1() {
        T t16;
        if (this.L != null && (t16 = this.f85017h) != 0 && this.M == this.f85018i) {
            try {
                if (((FeedCloudMeta$StFeed) t16).f398449id.get().equals(this.L.f398449id.get()) && ((FeedCloudMeta$StFeed) this.f85017h).video.playUrl.get().equals(this.L.video.playUrl.get())) {
                    RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "fs_lifecycle , same video, playUrl = " + this.L.video.playUrl.get());
                    return true;
                }
            } catch (Exception e16) {
                RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.USR, "same video, exception = " + e16.getMessage());
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements IRFWPlayerLooperListener {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            c.this.S0();
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopEnd() {
            if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_use_loop_end_auto_scroll", true)) {
                return;
            }
            RFWLog.d("QFP-QFSFloatingVideoPresent", RFWLog.CLR, "[onVideoLoopEnd] current is auto scroll: ");
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: q40.g
                @Override // java.lang.Runnable
                public final void run() {
                    c.f.this.b();
                }
            });
        }

        @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
        public void onVideoLoopStart() {
        }
    }
}
