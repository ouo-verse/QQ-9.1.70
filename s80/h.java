package s80;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchVideoView;
import com.tencent.biz.richframework.video.rfw.view.RFWPlayerReuseUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qui.quiblurview.f;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h extends b implements QFSSearchVideoPlayHelper.d, e80.f {
    private QFSSearchVideoView U;
    private TextView V;
    protected QFSSearchVideoPlayHelper W;
    protected f80.e X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCirclePicStateListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_SUCCESS) {
                h.this.J1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G1() {
        final Bitmap y16 = this.W.y(this.J.getWidth(), this.J.getHeight());
        this.C.post(new Runnable() { // from class: s80.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.K1(y16);
            }
        });
    }

    private void H1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        String str;
        ImageView imageView = this.L;
        if (imageView != null && this.M != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.M.getLayoutParams();
            layoutParams.width = i3;
            layoutParams.height = i16;
            layoutParams2.width = i3;
            layoutParams2.height = i16;
            this.L.setLayoutParams(layoutParams);
            this.M.setLayoutParams(layoutParams2);
            if (this.L.getTag(R.id.f52422_r) instanceof String) {
                str = (String) this.L.getTag(R.id.f52422_r);
            } else {
                str = "";
            }
            this.L.setTag(R.id.f52422_r, feedCloudMeta$StFeed.cover.picUrl.get());
            if (!str.equals(feedCloudMeta$StFeed.cover.picUrl.get())) {
                Option loadingDrawableColor = Option.getDefaultOptions(null).setUrl(feedCloudMeta$StFeed.cover.picUrl.get()).setTargetView(this.L).setFromPreLoad(false).setPredecode(true).setRequestWidth(i3).setRequestHeight(i16).setLoadingDrawableColor(0);
                loadingDrawableColor.setSupportRecycler(true);
                loadingDrawableColor.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
                QCircleFeedPicLoader.g().loadImage(loadingDrawableColor, new a());
            }
            O1(this.L, true);
        }
    }

    private void I1() {
        this.X = new f80.e(new GdtAd(u.e(this.E)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J1() {
        f.a aVar = new f.a(com.tencent.qui.quiblurview.c.f363628c.b(m0()), 60.0f, this.L, 0, null, Integer.valueOf(R.drawable.qvideo_skin_feed_bottomsheet_bg));
        aVar.p(true);
        this.M.a(aVar);
        O1(this.M, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K1(Bitmap bitmap) {
        if (bitmap == null) {
            QLog.d("QFSSearchFeedResultVideoPresenter", 2, "#fetchSnapshot setup cover");
            q50.b.e().n(this.N);
        } else {
            QLog.d("QFSSearchFeedResultVideoPresenter", 2, "#fetchSnapshot setup snapshot");
            this.J.setImageBitmap(bitmap);
        }
        this.U.setVisibility(4);
        this.J.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L1() {
        this.U.setVisibility(0);
        QFSSearchPrerenderManager.E(m0()).s("feed", this.f85018i);
        Boolean J = QFSSearchPrerenderManager.J(this.W.B(), (FeedCloudMeta$StFeed) this.f85017h);
        if (J != null && J.booleanValue()) {
            this.Q.setStatusPlay();
        } else {
            this.Q.setStatusLoading();
        }
    }

    private void M1() {
        q50.b.e().n(this.N);
        this.U.setVisibility(4);
        this.J.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N1() {
        QFSSearchPrerenderManager.E(this.C.getContext()).R((FeedCloudMeta$StFeed) this.f85017h, null, "feed", this.f85018i);
    }

    private void O1(View view, boolean z16) {
        int i3;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private void P1(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        int i16 = i3 / 1000;
        this.V.setVisibility(0);
        this.V.setText(String.format(Locale.CHINA, "%02d:%02d", Integer.valueOf(i16 / 60), Integer.valueOf(i16 % 60)));
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.views.search.util.f.b
    public void B(boolean z16) {
        super.B(z16);
        this.U.setOutPutMute(z16);
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull @NotNull View view) {
        super.N0(view);
        QFSSearchVideoView qFSSearchVideoView = (QFSSearchVideoView) view.findViewById(R.id.f517228v);
        this.U = qFSSearchVideoView;
        qFSSearchVideoView.setProgressEnabled(true);
        this.V = (TextView) view.findViewById(R.id.f519529h);
        QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper = new QFSSearchVideoPlayHelper(this.Q, this.R, "feed", QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        this.W = qFSSearchVideoPlayHelper;
        qFSSearchVideoPlayHelper.T(this.U);
        this.W.R(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void R() {
        s1(true);
        t1(true);
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        super.a();
        M1();
        this.W.K();
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.f();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public int b0() {
        return this.P.N1(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void c0(int i3, int i16) {
        this.P.R1(((FeedCloudMeta$StFeed) this.f85017h).f398449id.get(), i16);
        P1(i3 - i16);
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.e(i16);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void d0() {
        this.Q.h();
    }

    @Override // e80.f
    public void e0() {
        super.a();
        M1();
        this.W.V(null);
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.f();
        }
    }

    @Override // s80.b
    public void i1() {
        if (this.C == null) {
            return;
        }
        this.U.setVisibility(8);
        this.V.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s80.b
    public void l1() {
        super.l1();
        if (o.U0()) {
            Option option = this.N;
            if (option != null) {
                option.setSupportRecycler(false);
            }
            G1();
            RFWPlayerReuseUtils.prepareToReusePlayer(this.U);
            return;
        }
        N1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s80.b
    public void n1(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3, int i16) {
        super.n1(feedCloudMeta$StFeed, i3, i16);
        if (p.w(feedCloudMeta$StFeed) && com.tencent.biz.qqcircle.immersive.utils.a.g()) {
            H1(feedCloudMeta$StFeed, i3, i16);
        } else {
            O1(this.L, false);
            O1(this.M, false);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void o0() {
        this.Q.setStatusPlay();
        QFSSearchPrerenderManager.E(m0()).r("feed", this.f85018i);
        Option option = this.N;
        if (option != null) {
            option.setSupportRecycler(true);
        }
        ad.c(this.J, this.N);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void onCompletion() {
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.c();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public boolean onPlayError(int i3) {
        this.Q.h();
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.i();
            return false;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopEnd() {
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.g();
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopStart() {
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.h();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void p0(ISuperPlayer iSuperPlayer) {
        this.S.b(this.U, VideoReport.getElementParams(this.C), (FeedCloudMeta$StFeed) this.f85017h, r0());
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: p1 */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        if (this.f85017h == feedCloudMeta$StFeed) {
            return;
        }
        super.L0(feedCloudMeta$StFeed, i3);
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        if (p.w(feedCloudMeta$StFeed)) {
            I1();
        } else {
            this.X = null;
        }
        this.J.setVisibility(0);
        this.U.setVisibility(4);
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        this.V.setVisibility(0);
        this.W.Q(i3);
        this.W.S(feedCloudMeta$StFeed);
        this.J.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.U.bindData(this.f85017h, this.f85018i);
        P1(feedCloudMeta$StFeed.video.duration.get());
    }

    @Override // s80.b, e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    @Deprecated
    public void pause() {
        super.pause();
        stop();
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // s80.b, com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        if (isPlaying()) {
            return;
        }
        super.play();
        L1();
        this.W.I();
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s80.b
    protected void q1(int i3, int i16) {
        ViewGroup.LayoutParams layoutParams = this.U.getLayoutParams();
        if (p.w((FeedCloudMeta$StFeed) this.f85017h)) {
            Size q16 = ad.q((FeedCloudMeta$StFeed) this.f85017h, i3, i16, this.C);
            layoutParams.width = q16.getWidth();
            layoutParams.height = q16.getHeight();
        } else {
            layoutParams.width = i3;
            layoutParams.height = i16;
        }
        this.U.setLayoutParams(layoutParams);
    }

    @Override // s80.b
    protected void s1(boolean z16) {
        QFSSearchVideoView qFSSearchVideoView = this.U;
        if (qFSSearchVideoView == null) {
            return;
        }
        this.S.c(qFSSearchVideoView);
    }

    @Override // s80.b, e80.g
    public void stop() {
        if (!isPlaying()) {
            return;
        }
        super.stop();
        this.W.V(new Runnable() { // from class: s80.f
            @Override // java.lang.Runnable
            public final void run() {
                h.this.G1();
            }
        });
        f80.e eVar = this.X;
        if (eVar != null) {
            eVar.m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s80.b
    protected void t1(boolean z16) {
        QFSSearchVideoView qFSSearchVideoView = this.U;
        if (qFSSearchVideoView == null) {
            return;
        }
        this.S.b(qFSSearchVideoView, VideoReport.getElementParams(this.C), (FeedCloudMeta$StFeed) this.f85017h, r0());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSearchFeedResultVideoPresenter";
    }
}
