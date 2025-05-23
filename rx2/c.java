package rx2;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleConfigChangeEvent;
import com.tencent.biz.qqcircle.events.QCircleFeedVideoCurrentTimeEvent;
import com.tencent.biz.qqcircle.events.QCircleVideoRateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSCloseBarrageEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSDeleteBarrageRspEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSFakeDeleteBarrageEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSGetBarrageEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSOpenBarrageEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.event.an;
import com.tencent.biz.qqcircle.immersive.feed.event.ap;
import com.tencent.biz.qqcircle.immersive.feed.event.ar;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSBarrageUpdateEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSFakeBarrageEvent;
import com.tencent.biz.qqcircle.immersive.utils.bk;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoScreenChangedEvent;
import com.tencent.mobileqq.tvideo.danmaku.event.TVideoBarrageSwitchEvent;
import com.tencent.mobileqq.tvideo.danmaku.manager.TVideoDmDataProvider;
import com.tencent.mobileqq.tvideo.danmaku.manager.k;
import com.tencent.mobileqq.tvideo.danmaku.manager.n;
import com.tencent.mobileqq.tvideo.event.QFSTVideoAuthPayPanelEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoFloatingWindowEntranceVisibleEvent;
import com.tencent.mobileqq.tvideo.viewmodel.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import vx2.FeedItemPlayRate;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: e0, reason: collision with root package name */
    private static HashSet<String> f432887e0;
    private ViewGroup I;
    private k T;
    private boolean X;
    private boolean Y;

    /* renamed from: a0, reason: collision with root package name */
    private a f432888a0;

    /* renamed from: c0, reason: collision with root package name */
    private Video f432890c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f432891d0;
    private long J = -1;
    private long K = -1;
    private int L = 0;
    private long M = -1;
    private boolean N = false;
    private int P = 0;
    private int Q = 3;
    private int R = 0;
    private long S = 0;
    private Runnable U = new Runnable() { // from class: rx2.a
        @Override // java.lang.Runnable
        public final void run() {
            c.this.U1();
        }
    };
    private boolean V = false;
    private boolean W = false;
    private boolean Z = true;

    /* renamed from: b0, reason: collision with root package name */
    private float f432889b0 = 1.0f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class a implements h70.a<FeedCloudMeta$StBarrage> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<c> f432892a;

        public a(c cVar) {
            this.f432892a = new WeakReference<>(cVar);
        }

        @Override // h70.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
            c cVar;
            WeakReference<c> weakReference = this.f432892a;
            if (weakReference == null) {
                cVar = null;
            } else {
                cVar = weakReference.get();
            }
            if (cVar == null) {
                QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onExport] presenter should not be null.");
            } else {
                cVar.x1(feedCloudMeta$StBarrage);
            }
        }
    }

    private void A1(TVideoBarrageSwitchEvent tVideoBarrageSwitchEvent) {
        if (tVideoBarrageSwitchEvent.getEventStatus() == 1) {
            I1();
        } else if (tVideoBarrageSwitchEvent.getEventStatus() == 0) {
            B1();
        }
    }

    private void B1() {
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerCloseBarrageEvent] handler close barrage event.");
        k2(false);
    }

    private void C1(QCircleConfigChangeEvent qCircleConfigChangeEvent) {
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[handlerConfigChange] barrage is close");
        } else {
            if (qCircleConfigChangeEvent.configuration == null) {
                return;
            }
            r2();
        }
    }

    private void D1() {
        k kVar;
        if (!this.Y) {
            return;
        }
        if (n.f() && (kVar = this.T) != null) {
            kVar.s();
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, k1("[handlerConfigChangeEvent] handler config barrage event."));
        n1(true);
        k2(true);
        i2(this.K, false);
        k kVar2 = this.T;
        if (kVar2 != null) {
            kVar2.d0(this.K, this.X);
        }
    }

    private void E1(@NonNull QFSDeleteBarrageRspEvent qFSDeleteBarrageRspEvent) {
        String a16;
        if (!S1(qFSDeleteBarrageRspEvent.getFeed())) {
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerDeleteBarrageEvent] event isSuccess: " + qFSDeleteBarrageRspEvent.isSuccess() + " | errorMsg: " + qFSDeleteBarrageRspEvent.getErrorMsg());
        if (qFSDeleteBarrageRspEvent.isSuccess()) {
            QCircleToast.o(h.a(R.string.f188373wi), 0);
            return;
        }
        if (TextUtils.isEmpty(qFSDeleteBarrageRspEvent.getErrorMsg())) {
            a16 = qFSDeleteBarrageRspEvent.getErrorMsg();
        } else {
            a16 = h.a(R.string.f188363wh);
        }
        QCircleToast.o(a16, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F1(@NonNull QFSFakeBarrageEvent qFSFakeBarrageEvent) {
        String str;
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = "";
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        if (!TextUtils.equals(str, qFSFakeBarrageEvent.getFeedId())) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerFakeBarrageEvent] current feed id: " + str + " | event feed id: " + qFSFakeBarrageEvent.getFeedId());
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(qFSFakeBarrageEvent.getBarrage());
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[appendBarrageDataSource] barrage view model should be null, flow return. hashcode: " + hashCode());
            return;
        }
        kVar.q(arrayList, (FeedCloudMeta$StFeed) this.f85017h);
    }

    private void G1(@NonNull final QFSGetBarrageEvent qFSGetBarrageEvent) {
        if (!TextUtils.equals(s1(), qFSGetBarrageEvent.getFeedId())) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerGetBarrageEvent] current feed id: " + s1() + " | event feed id: " + qFSGetBarrageEvent.getFeedId());
            this.P = 0;
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: rx2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.T1(qFSGetBarrageEvent);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void H1() {
        VideoBaseInfo videoBaseInfo;
        Video video = this.f432890c0;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            String str = videoBaseInfo.material_title;
            if (TextUtils.isEmpty(str)) {
                QLog.w("QDM-TVideoDanmakuPresenter", 1, "[handlerMaterialTitleBarrageEvent] materialTitle " + str);
                return;
            }
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerMaterialTitleBarrageEvent] materialTitle " + str);
            FeedCloudMeta$StBarrage feedCloudMeta$StBarrage = new FeedCloudMeta$StBarrage();
            feedCloudMeta$StBarrage.f398446id.set("mater_Id_" + System.currentTimeMillis());
            feedCloudMeta$StBarrage.content.set("\u70ed\u8bae\uff1a" + str);
            feedCloudMeta$StBarrage.createTime.set((long) ((int) (System.currentTimeMillis() / 1000)));
            feedCloudMeta$StBarrage.postUser.set(QCirclePluginGlobalInfo.m());
            ArrayList arrayList = new ArrayList();
            arrayList.add(feedCloudMeta$StBarrage);
            if (this.T == null) {
                p1();
            }
            this.T.q(arrayList, (FeedCloudMeta$StFeed) this.f85017h);
            return;
        }
        QLog.e("QDM-TVideoDanmakuPresenter", 1, "[handlerMaterialTitleBarrageEvent] video_base_info is null ");
    }

    private void I1() {
        if (!this.Y) {
            return;
        }
        if (n.f()) {
            k kVar = this.T;
            if (kVar != null) {
                kVar.e0(true);
                return;
            }
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, k1("[handlerOpenBarrageEvent] handler open barrage event."));
        n1(true);
        k2(true);
        i2(this.K, false);
        this.T.d0(this.K, this.X);
    }

    private void J1(boolean z16) {
        k2(z16);
    }

    private void K1() {
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerPauseBarrage] barrage view model should not be null.");
        } else {
            kVar.U();
        }
    }

    private void L1() {
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerResumeBarrage] barrage view model should not be null.");
        } else {
            kVar.c0();
        }
    }

    private void M1(@NonNull QFSSeekEvent qFSSeekEvent) {
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[handlerSeekBarEvent] barrage is close");
            return;
        }
        n1(false);
        k2(!qFSSeekEvent.mIsOnSeek);
        if (!qFSSeekEvent.mIsOnSeek) {
            o2(qFSSeekEvent.mStopTrackingTouchProgress);
            i2(qFSSeekEvent.mStopTrackingTouchProgress, true);
            k kVar = this.T;
            if (kVar != null) {
                kVar.d0(qFSSeekEvent.mStopTrackingTouchProgress, this.X);
            } else {
                QLog.e("QDM-TVideoDanmakuPresenter", 1, "[handlerSeekBarEvent] seek barrage manager should not be null.");
            }
        }
    }

    private void N1(an anVar) {
        if (anVar == null) {
            return;
        }
        o2(anVar.e());
        if (this.T == null) {
            return;
        }
        if (m1(anVar.e())) {
            this.R = anVar.e();
            int i3 = this.Q;
            if (i3 == 0) {
                return;
            }
            if (this.P == 3) {
                this.Q = i3 - 1;
            }
            W1(anVar.e(), true);
        }
        if (anVar.c() != this.J) {
            m2(anVar.c());
        }
        if (anVar.d() != this.L) {
            n2(anVar.d());
            this.T.o0(0L, anVar.c());
            o2(0L);
            h2();
        }
        this.T.o0(anVar.e(), anVar.c());
    }

    private void O1(@NonNull wx2.h hVar) {
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[handlerVideoRateEvent] barrage is close.");
            return;
        }
        if (this.T == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoRateEvent] barrage manager should not be null.");
            return;
        }
        this.f432889b0 = hVar.getSpeed();
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoRateEvent] selected rate: " + this.f432889b0);
        this.T.h0(this.f432889b0);
        this.f432891d0 = true;
        W1(this.K, true);
    }

    private void P1(@NonNull ap apVar) {
        if (!this.Y) {
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoStatusEvent] event: " + apVar.b() + " | hashcode: " + hashCode());
        s2(apVar.b());
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[handlerVideoStatusEvent] barrage is close");
            return;
        }
        if (this.T == null && !this.X) {
            L1();
        } else if (this.X) {
            K1();
        } else {
            L1();
        }
    }

    private boolean Q1() {
        return n.b().c(this.f432890c0);
    }

    private boolean R1() {
        if (s0() != null && s0().isContainerOnScreen()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean S1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        String str;
        T t16 = this.f85017h;
        String str2 = null;
        if (t16 == 0) {
            str = null;
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        if (feedCloudMeta$StFeed != null) {
            str2 = feedCloudMeta$StFeed.f398449id.get();
        }
        return TextUtils.equals(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(QFSGetBarrageEvent qFSGetBarrageEvent) {
        k kVar;
        List<FeedCloudMeta$StBarrage> barrageList = qFSGetBarrageEvent.getBarrageList();
        int size = RFSafeListUtils.getSize(barrageList);
        this.M = qFSGetBarrageEvent.getAttachInfo();
        this.N = qFSGetBarrageEvent.getIsFinish();
        if (qFSGetBarrageEvent.getRetCode() != 0) {
            this.P = 3;
            this.S = qFSGetBarrageEvent.getRetCode();
        } else if (size == 0) {
            this.P = 0;
        } else {
            this.P = 2;
            if (qFSGetBarrageEvent.isLoadMore() && (kVar = this.T) != null && !RFSafeListUtils.isEmpty(kVar.A())) {
                if (this.f432891d0) {
                    this.f432891d0 = false;
                    this.T.o(barrageList);
                } else {
                    j1(barrageList);
                }
            } else {
                j2(barrageList);
            }
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerGetBarrageEvent] is load more: " + qFSGetBarrageEvent.isLoadMore() + " | barrage size: " + size + " \uff5c feedId: " + s1() + " \uff5c attachInfo: " + this.M + " | mIsFinish: " + this.N + " | hashcode: " + hashCode() + " | mState: " + this.P);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U1() {
        T0(new ar(false));
    }

    private void V1(long j3, boolean z16) {
        String X1 = X1();
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[loadBarrageSource] current barrage is close state, not load source, feed id: " + X1);
            return;
        }
        if (this.V) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[loadBarrageSource] current barrage update data source flag == true, not load source, feed id: " + X1);
            return;
        }
        this.V = true;
        W1(j3, z16);
    }

    private void W1(long j3, boolean z16) {
        this.P = 1;
        ux2.a a16 = ux2.a.a();
        a16.g(this.f432890c0);
        a16.f(hashCode());
        a16.h(j3);
        a16.j(this.J);
        a16.i(z16);
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[loadData] loadBarrageList mRetryTimes: " + this.Q + ", feedPlayTime(): " + j3 + "\uff0cisLoadMore\uff1a" + z16);
        TVideoDmDataProvider.j().l(a16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String X1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return "null";
        }
        return ((FeedCloudMeta$StFeed) t16).f398449id.get();
    }

    public static void a2() {
        f432887e0 = null;
    }

    private void c2() {
        TVideoDmDataProvider.j().o();
        f2();
        q1();
        RFWThreadManager.getUIHandler().removeCallbacks(this.U);
        this.Y = false;
    }

    private void d2() {
        ViewGroup viewGroup = this.I;
        if (viewGroup == null) {
            QLog.e("QDM-TVideoDanmakuPresenter", 1, "[removeAllView] barrage layout should not be null.");
            return;
        }
        int childCount = viewGroup.getChildCount();
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[removeAllView] remove all view, count: " + childCount);
        if (childCount > 0) {
            this.I.removeAllViews();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e2() {
        Video q16 = jy2.g.q((FeedCloudMeta$StFeed) this.f85017h);
        this.f432890c0 = q16;
        this.R = 0;
        this.W = false;
        this.Y = true;
        FeedItemPlayRate feedItemPlayRate = j.f304840b;
        if (jy2.g.H(feedItemPlayRate, q16, this.f85018i)) {
            this.f432889b0 = feedItemPlayRate.getPlayRate();
        } else {
            this.f432889b0 = 1.0f;
        }
        this.Q = g.b();
        this.P = 0;
        this.M = u1();
    }

    private void f2() {
        k kVar = this.T;
        if (kVar != null) {
            kVar.Z();
        }
        this.V = false;
        g2();
    }

    private void g2() {
        if (3 == r1()) {
            m2(0L);
            n2(0);
            o2(0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h2() {
        String str;
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[restart] barrage manager should not be null, hashcode:" + hashCode());
            return;
        }
        List<FeedCloudMeta$StBarrage> A = kVar.A();
        int size = RFSafeListUtils.getSize(A);
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = null;
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[restart] barrage size: " + size + " | feedId: " + str + " | hashcode: " + hashCode());
        this.T.b0(A, (FeedCloudMeta$StFeed) this.f85017h);
    }

    private void i1(View view) {
        if (view == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[addTextureLayoutToBarrageLayout] barrage layout should not be null.");
        } else {
            this.I.addView(view);
            k2(true);
        }
    }

    private void i2(long j3, boolean z16) {
        k kVar = this.T;
        if (kVar == null) {
            QLog.e("QDM-TVideoDanmakuPresenter", 1, "[seekBarrageSource] barrage manager should not be null.");
            return;
        }
        if (!kVar.G(j3, 1000L)) {
            W1(j3, z16);
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[seekBarrageSource] loadBarrageList seekProgress = " + j3 + "| hashcode: " + hashCode() + "| mState: " + this.P);
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerSeekBarEvent] barrage has downloaded, | hashcode: " + hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void j1(List<FeedCloudMeta$StBarrage> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[appendBarrageDataSource] barrages data source is empty, flow return. hashcode: " + hashCode());
            return;
        }
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[appendBarrageDataSource] barrage view model should be null, flow return. hashcode: " + hashCode());
            return;
        }
        kVar.p(list, (FeedCloudMeta$StFeed) this.f85017h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private synchronized void j2(List<FeedCloudMeta$StBarrage> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerGetBarrageEvent] set data source, barrage list should not is empty. hashcode: " + hashCode());
            return;
        }
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[setBarrageDataSource] barrage manager should not be null. hashcode: " + hashCode());
            return;
        }
        if (this.Y) {
            kVar.f0(list, (FeedCloudMeta$StFeed) this.f85017h, this.f432889b0);
            l2();
        } else {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[setBarrageDataSource] current feed not selected, hashcode: " + hashCode());
        }
    }

    private String k1(String str) {
        return str + "feed id: " + X1() + " | hashCode: " + hashCode();
    }

    private void k2(boolean z16) {
        if (z16 && Q1()) {
            bk.c(this.I, 0);
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[setBarrageViewVisible] mBarrageLayout is VISIBLE");
        } else if (!n.f()) {
            bk.c(this.I, 8);
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[setBarrageViewVisible] mBarrageLayout is GONE");
        } else if (this.T != null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[setBarrageViewVisible] isNewStyle mQFSBarrageManager.setBarrageVisibility false");
            this.T.e0(false);
        }
    }

    private TextureView l1() {
        Context v16 = v1();
        if (v16 == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[createTextureView] context should not be null.");
            return null;
        }
        d2();
        View inflate = LayoutInflater.from(v16).inflate(R.layout.i2c, (ViewGroup) null);
        i1(inflate);
        return (TextureView) inflate.findViewById(R.id.v_k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l2() {
        String str;
        if (this.W) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[tryStartBarragePlay] current view paused, not start barrage play, hashcode: " + hashCode());
            return;
        }
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[tryStartBarragePlay] barrage manager should not be null. hashcode: " + hashCode());
            return;
        }
        List<FeedCloudMeta$StBarrage> A = kVar.A();
        if (RFSafeListUtils.isEmpty(A)) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[tryStartBarragePlay] current feed barrage is null. hashcode: " + hashCode());
            return;
        }
        n1(false);
        int size = RFSafeListUtils.getSize(A);
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = null;
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[tryStartBarragePlay] barrage size: " + size + " | feedId: " + str + ", hashcode: " + hashCode() + " | manager hashcode: " + this.T.hashCode() + " | mIsScreenVertical: " + this.Z);
        this.T.b0(A, (FeedCloudMeta$StFeed) this.f85017h);
    }

    private boolean m1(int i3) {
        boolean z16;
        boolean z17;
        if (!Q1()) {
            return false;
        }
        if (this.P == 1) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore:false, mState == UI_STATE_LOADING");
            return false;
        }
        if (this.N) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore:false, mIsFinish == true");
            return false;
        }
        if (this.S == 10037) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore:false, mErrorCode == " + this.S);
            return false;
        }
        if (i3 - this.R < t1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore:false, delta <5 currentProgress:" + i3 + ", mCurAttachInfo:" + this.M);
            return false;
        }
        long j3 = i3;
        long j16 = j3 - this.M;
        if (j16 >= 0 && j16 < t1()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.P == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore, deltaCondition == true");
        }
        if (z17) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore, emptyCondition == true");
        }
        if (!z16 && !z17) {
            return false;
        }
        if (this.T.G(j3, 1000L)) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore:false, isExistsBarrageData == true");
            return false;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlerVideoProgressChangeEvent] canLoadMore = true");
        return true;
    }

    private void m2(long j3) {
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[updateVideoPause] isVideoPause: " + this.X + " | hashcode: " + hashCode());
        this.J = j3;
    }

    private void n1(boolean z16) {
        if (this.T != null && !z16) {
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, k1("[checkBuildBarrageTextureView] build barrage texture view."));
        p1();
    }

    private void n2(int i3) {
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[updateVideoPause] isVideoPause: " + this.X + " | hashcode: " + hashCode());
        this.L = i3;
    }

    private void o1() {
        k kVar = this.T;
        if (kVar == null) {
            return;
        }
        kVar.t();
    }

    private void o2(long j3) {
        this.K = j3;
    }

    private void p1() {
        k kVar = this.T;
        if (kVar != null) {
            kVar.W();
        }
        this.Z = !ScreenUtils.isLandscape();
        k kVar2 = new k(v1(), l1());
        this.T = kVar2;
        kVar2.p0(this.Z);
        this.T.h0(this.f432889b0);
        a aVar = new a(this);
        this.f432888a0 = aVar;
        this.T.g0(aVar);
    }

    private void p2(@NonNull QFSBarrageUpdateEvent qFSBarrageUpdateEvent) {
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[updateFakeBarrageInfo] barrage manager should not be null.");
        } else {
            kVar.m0(qFSBarrageUpdateEvent.fakeBarrageId, qFSBarrageUpdateEvent.mBarrage);
        }
    }

    private void q1() {
        k kVar = this.T;
        if (kVar != null) {
            kVar.W();
        }
        d2();
    }

    private void q2(QFSFakeDeleteBarrageEvent qFSFakeDeleteBarrageEvent) {
        if (!S1(qFSFakeDeleteBarrageEvent.getFeed())) {
            return;
        }
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[updateFakeDeleteBarrageInfo] barrage manager should not be null.");
        } else {
            kVar.X(qFSFakeDeleteBarrageEvent.getBarrage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int r1() {
        T t16 = this.f85017h;
        if (t16 == 0) {
            return -1;
        }
        return ((FeedCloudMeta$StFeed) t16).type.get();
    }

    private void r2() {
        if (!R1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[updateFullBarrageConfig] current container not is screen.");
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[updateFullBarrageConfig] mIsScreenVertical: " + this.Z + " | selectInfo: ");
        D1();
    }

    private String s1() {
        VideoBaseInfo videoBaseInfo;
        Video video = this.f432890c0;
        if (video != null && (videoBaseInfo = video.video_base_info) != null) {
            return videoBaseInfo.vid;
        }
        return null;
    }

    private void s2(boolean z16) {
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[updateVideoPause] isVideoPause: " + z16 + " | hashcode: " + hashCode());
        this.X = z16;
    }

    private long t1() {
        return g.a();
    }

    private long u1() {
        Object b16 = this.E.b("tvideo_feed_play_progress");
        if (b16 instanceof Long) {
            Long l3 = (Long) b16;
            if (l3.longValue() > 0) {
                return l3.longValue();
            }
        }
        return jy2.c.f411160a.b(this.f432890c0);
    }

    private Context v1() {
        ViewGroup viewGroup = this.I;
        if (viewGroup == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[getViewContext()] barrage layout should not be null.");
            return null;
        }
        return viewGroup.getContext();
    }

    private void w1(QCircleFeedVideoCurrentTimeEvent qCircleFeedVideoCurrentTimeEvent) {
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[handleFullScreenProgressTime] barrage is close");
            return;
        }
        k kVar = this.T;
        if (kVar == null) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handleFullScreenProgressTime] barrage manager should not be null, hashcode:" + hashCode());
            return;
        }
        kVar.d0(qCircleFeedVideoCurrentTimeEvent.getCurrentTime(), this.X);
    }

    private void y1(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        if (this.W) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[handlePresenterPause] current view state is pause, flow break, hashcode: " + hashCode());
            return;
        }
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[onResumed] barrage is close");
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[handlePresenterPause] selectInfo: " + rFWFeedSelectInfo + " | hashCode: " + hashCode() + " | feedId: " + X1());
        K1();
        this.W = true;
    }

    private void z1(boolean z16) {
        if (z16) {
            this.W = true;
        }
        J1(!z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        if (hVar instanceof an) {
            N1((an) hVar);
        } else if (hVar instanceof ap) {
            P1((ap) hVar);
        } else if (hVar instanceof wx2.h) {
            O1((wx2.h) hVar);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean H0() {
        return n.b().d();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.I = (ViewGroup) view.findViewById(R.id.v_j);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: Z1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList getEventClass() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSGetBarrageEvent.class);
        arrayList.add(QFSFakeBarrageEvent.class);
        arrayList.add(QFSCloseBarrageEvent.class);
        arrayList.add(QFSOpenBarrageEvent.class);
        arrayList.add(TVideoBarrageSwitchEvent.class);
        arrayList.add(QFSSeekEvent.class);
        arrayList.add(QCircleFeedVideoCurrentTimeEvent.class);
        arrayList.add(QCircleVideoRateEvent.class);
        arrayList.add(QFSBarrageUpdateEvent.class);
        arrayList.add(QFSFakeDeleteBarrageEvent.class);
        arrayList.add(QFSDeleteBarrageRspEvent.class);
        arrayList.add(QCircleConfigChangeEvent.class);
        arrayList.add(QFSTVideoScreenChangedEvent.class);
        arrayList.add(QFSTVideoAuthPayPanelEvent.class);
        arrayList.add(QFSTVideoFloatingWindowEntranceVisibleEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        e2();
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[onFeedSelected] selectInfo: " + rFWFeedSelectInfo + " | mPos: " + this.f85018i);
            return;
        }
        if (!R1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onFeedSelected] current container not screen.");
            return;
        }
        if (n.f()) {
            n1(true);
            f2();
            H1();
        } else {
            if (!Q1()) {
                QLog.d("QDM-TVideoDanmakuPresenter", 2, "[onFeedSelected] barrage is close");
                return;
            }
            long u16 = u1();
            n1(true);
            f2();
            V1(u16, false);
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onFeedSelected] selectInfo: " + rFWFeedSelectInfo.toString() + " | hashCode: " + hashCode() + " | feed id: " + X1() + " | mIsFeedSelected: " + this.Y + " | mCurAttachInfo: " + this.M);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        if (rFWFeedSelectInfo.getPosition() != this.f85018i) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onFeedUnSelected] selectInfo: " + rFWFeedSelectInfo + " | mPos: " + this.f85018i);
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onFeedUnSelected] selectInfo: " + rFWFeedSelectInfo + " | hashCode: " + hashCode() + " | feedId: " + X1());
        c2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        Object obj;
        super.onPaused(rFWFeedSelectInfo);
        if (QCirclePluginUtil.isSharePanelOnShow()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onPaused] don't release player");
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onPaused] selectInfo: ");
        if (rFWFeedSelectInfo == null) {
            obj = "null";
        } else {
            obj = rFWFeedSelectInfo;
        }
        sb5.append(obj);
        sb5.append(" | hashcode: ");
        sb5.append(hashCode());
        QLog.d("QDM-TVideoDanmakuPresenter", 1, sb5.toString());
        y1(rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSGetBarrageEvent) {
            G1((QFSGetBarrageEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFakeBarrageEvent) {
            F1((QFSFakeBarrageEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSCloseBarrageEvent) {
            B1();
            return;
        }
        if (simpleBaseEvent instanceof QFSOpenBarrageEvent) {
            I1();
            return;
        }
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            M1((QFSSeekEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof TVideoBarrageSwitchEvent) {
            A1((TVideoBarrageSwitchEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleFeedVideoCurrentTimeEvent) {
            w1((QCircleFeedVideoCurrentTimeEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSDeleteBarrageRspEvent) {
            E1((QFSDeleteBarrageRspEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSBarrageUpdateEvent) {
            p2((QFSBarrageUpdateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QFSFakeDeleteBarrageEvent) {
            q2((QFSFakeDeleteBarrageEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof QCircleConfigChangeEvent) {
            C1((QCircleConfigChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof QFSTVideoAuthPayPanelEvent) {
            z1(((QFSTVideoAuthPayPanelEvent) simpleBaseEvent).isShow());
        } else if (simpleBaseEvent instanceof QFSTVideoFloatingWindowEntranceVisibleEvent) {
            J1(((QFSTVideoFloatingWindowEntranceVisibleEvent) simpleBaseEvent).getIsShow());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null || rFWFeedSelectInfo.getPosition() != this.f85018i) {
            return;
        }
        if (!Q1()) {
            QLog.d("QDM-TVideoDanmakuPresenter", 2, "[onResumed] barrage is close");
            this.W = false;
            return;
        }
        QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onResumed] selectInfo: " + rFWFeedSelectInfo + " | isPausedState: " + this.W + " | mIsScreenVertical: " + this.Z + " | hashCode: " + hashCode() + " | feedId: " + X1());
        if (this.W) {
            L1();
        }
        this.W = false;
        r2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        Object obj;
        super.onStop(rFWFeedSelectInfo);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[onStop] selectInfo: ");
        if (rFWFeedSelectInfo == null) {
            obj = "null";
        } else {
            obj = rFWFeedSelectInfo;
        }
        sb5.append(obj);
        sb5.append(" | hashcode: ");
        sb5.append(hashCode());
        QLog.d("QDM-TVideoDanmakuPresenter", 1, sb5.toString());
        y1(rFWFeedSelectInfo);
        o1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewHolderDetachedFromWindow(viewHolder);
        if (viewHolder == null) {
            return;
        }
        int adapterPosition = viewHolder.getAdapterPosition();
        if (viewHolder.getAdapterPosition() != this.f85018i) {
            QLog.d("QDM-TVideoDanmakuPresenter", 1, "[onFeedUnSelected] position: " + adapterPosition + " | mPos: " + this.f85018i);
            return;
        }
        RFWLog.d("QDM-TVideoDanmakuPresenter", RFWLog.USR, "[onViewHolderDetachedFromWindow] onViewHolderDetachedFromWindow: | mPos:" + this.f85018i + " | holder.pos:" + viewHolder.getAdapterPosition() + " | hashCode:" + hashCode() + " | feedId: " + X1());
        c2();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QDM-TVideoDanmakuPresenter";
    }

    public void x1(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        if (f432887e0 == null) {
            f432887e0 = new HashSet<>();
        }
        if (f432887e0.contains(s1())) {
            return;
        }
        f432887e0.add(s1());
        VideoReport.setElementExposePolicy(this.I, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(this.I, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.I, "first_bulletscreen");
        Map<String, Object> i3 = gy2.c.i(this.f432890c0);
        i3.put("bulletscreen_id", feedCloudMeta$StBarrage.f398446id.get());
        i3.put("bulletscreen_text", feedCloudMeta$StBarrage.content.get());
        VideoReport.reportEvent("imp", this.I, i3);
    }
}
