package xz;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001#B\u0007\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u001a\u0010\u0012\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010#\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0016J\u001a\u0010*\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u001d2\u0006\u0010)\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\u0005H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u001bH\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00104\u001a\u00020\u0005H\u0016R\u0018\u00106\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00108R\u0018\u0010<\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010ER\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010IR\u0016\u0010M\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010LR\u0016\u0010O\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010N\u00a8\u0006R"}, d2 = {"Lxz/k;", "Lxz/a;", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IFullScreenEnterListener;", "Landroid/content/Context;", "context", "", "o", "Lxz/d;", "floatingInfo", "t", "u", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "p", "Landroid/widget/FrameLayout;", "videoLayout", "i", "j", HippyTKDListViewAdapter.X, "w", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "k", "Lcom/tencent/biz/pubaccount/weishi/player/e;", tl.h.F, "d", "", "Lcom/tencent/biz/pubaccount/weishi/player/l;", "infoList", "a", "v", "centerX", "centerY", "onEnter", "playingParam", "isPlaying", "y", "playVideo", "e", "pauseVideo", "c", "preloadVideo", "b", "g", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoOuterStatusListener;", "f", "release", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoOuterStatusListener;", "outerListener", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoInnerStatusListener;", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoInnerStatusListener;", "innerListener", "Lcom/tencent/biz/pubaccount/weishi/player/WSPlayerManager;", "Lcom/tencent/biz/pubaccount/weishi/player/WSPlayerManager;", "playerManager", "Lcom/tencent/biz/pubaccount/weishi/player/WSVideoPreDownloadManager;", "Lcom/tencent/biz/pubaccount/weishi/player/WSVideoPreDownloadManager;", "preloadManager", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "currentPlayerParam", "Lxz/d;", "videoFloatingInfo", "Landroid/view/View;", "Landroid/view/View;", "floatingVideoView", "Landroid/widget/FrameLayout;", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "ivAdIcon", "Lxz/h;", "Lxz/h;", "videoFloatingPresenter", "Z", "isEnterVerticalPage", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class k implements a, IFullScreenEnterListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private IVideoOuterStatusListener outerListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private IVideoInnerStatusListener innerListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WSPlayerManager playerManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WSVideoPreDownloadManager preloadManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.player.e currentPlayerParam;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private d videoFloatingInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private View floatingVideoView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout videoLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView ivAdIcon;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private h videoFloatingPresenter = new h(this);

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isEnterVerticalPage;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"xz/k$b", "Lcom/tencent/biz/pubaccount/weishi/player/WSVideoPreDownloadManager$b;", "", "curPosition", "", "isScrollDown", "", "Lcom/tencent/biz/pubaccount/weishi/player/WSVideoPreDownloadManager$c;", "a", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b implements WSVideoPreDownloadManager.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f449157a;

        b(d dVar) {
            this.f449157a = dVar;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public List<WSVideoPreDownloadManager.c> a(int curPosition, boolean isScrollDown) {
            List<WSVideoPreDownloadManager.c> z16 = com.tencent.biz.pubaccount.weishi.player.i.z(this.f449157a.g(), curPosition, isScrollDown);
            Intrinsics.checkNotNullExpressionValue(z16, "getVideoPreloadParams(fl\u2026urPosition, isScrollDown)");
            return z16;
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.b
        public boolean b() {
            return AppNetConnInfo.isWifiConn();
        }
    }

    private final void i(d floatingInfo, FrameLayout videoLayout) {
        if (this.currentPlayerParam == null) {
            this.currentPlayerParam = new com.tencent.biz.pubaccount.weishi.player.e();
        }
        com.tencent.biz.pubaccount.weishi.player.e eVar = this.currentPlayerParam;
        if (eVar != null) {
            eVar.f81125a = videoLayout;
            eVar.f81127c = floatingInfo.a();
            eVar.f81132h = floatingInfo.getStartPosition();
            eVar.f81131g = floatingInfo.getVideoIndex();
            eVar.f81130f = j.f(floatingInfo.a());
            eVar.f81135k = "floating_window";
            eVar.f81134j = true;
            if (eVar.f81136l == null) {
                eVar.f81136l = new g(this);
            }
        }
    }

    private final void j() {
        boolean z16;
        if (!this.isEnterVerticalPage) {
            yz.i.f451583a.c();
            z16 = true;
        } else {
            com.tencent.biz.pubaccount.weishi.player.e currentPlayerParam = getCurrentPlayerParam();
            d videoFloatingInfo = getVideoFloatingInfo();
            c.j(currentPlayerParam, false, videoFloatingInfo != null ? videoFloatingInfo.getVerticalTestId() : null);
            z16 = false;
        }
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            wSPlayerManager.e0(z16);
        }
        this.playerManager = null;
    }

    private final Context l() {
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        return context;
    }

    private final int m() {
        l lVar;
        com.tencent.biz.pubaccount.weishi.player.e eVar = this.currentPlayerParam;
        if (eVar == null || (lVar = eVar.f81127c) == null) {
            return 0;
        }
        return lVar.f81169d;
    }

    private final void n(d floatingInfo) {
        if (floatingInfo.getIsPlay()) {
            playVideo();
            IVideoOuterStatusListener iVideoOuterStatusListener = this.outerListener;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onVideoStart(m());
                return;
            }
            return;
        }
        pauseVideo();
        IVideoOuterStatusListener iVideoOuterStatusListener2 = this.outerListener;
        if (iVideoOuterStatusListener2 != null) {
            iVideoOuterStatusListener2.onVideoStop();
        }
    }

    private final void o(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.d0l, (ViewGroup) null);
        this.floatingVideoView = inflate;
        this.videoLayout = (FrameLayout) inflate.findViewById(R.id.p8n);
        this.ivAdIcon = (ImageView) inflate.findViewById(R.id.p47);
    }

    private final void p() {
        this.innerListener = new e(this);
        this.outerListener = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFloatingVideoListener(this.innerListener);
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).setFullScreenListener(this);
    }

    private final void q() {
        WSPlayerManager wSPlayerManager = new WSPlayerManager(bb.t());
        wSPlayerManager.R0(false);
        wSPlayerManager.Q0(false);
        wSPlayerManager.X(new f(this));
        this.playerManager = wSPlayerManager;
    }

    private final void r(d floatingInfo) {
        WSVideoPreDownloadManager wSVideoPreDownloadManager = new WSVideoPreDownloadManager(l());
        wSVideoPreDownloadManager.x(new b(floatingInfo));
        this.preloadManager = wSVideoPreDownloadManager;
    }

    private final void s(d floatingInfo) {
        int i3 = floatingInfo.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE java.lang.String();
        if (i3 == 0 || i3 == 1 || i3 == 4) {
            x(floatingInfo);
            IVideoOuterStatusListener iVideoOuterStatusListener = this.outerListener;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onVideoBuffering();
            }
        } else if (i3 == 5) {
            IVideoOuterStatusListener iVideoOuterStatusListener2 = this.outerListener;
            if (iVideoOuterStatusListener2 != null) {
                iVideoOuterStatusListener2.onVideoStop();
            }
        } else if (i3 != 6) {
            IVideoOuterStatusListener iVideoOuterStatusListener3 = this.outerListener;
            if (iVideoOuterStatusListener3 != null) {
                iVideoOuterStatusListener3.onVideoStart(m());
            }
            c.i(this.currentPlayerParam, floatingInfo.getVerticalTestId());
        } else {
            x(floatingInfo);
            IVideoOuterStatusListener iVideoOuterStatusListener4 = this.outerListener;
            if (iVideoOuterStatusListener4 != null) {
                iVideoOuterStatusListener4.onVideoError(0);
            }
        }
        y(floatingInfo.getPlayingParam(), !(floatingInfo.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE java.lang.String() == 5));
    }

    private final void t(d floatingInfo) {
        if (floatingInfo.getIsSeamlessPlay()) {
            return;
        }
        x(floatingInfo);
    }

    private final void u(d floatingInfo) {
        if (floatingInfo.getIsSeamlessPlay()) {
            s(floatingInfo);
        } else {
            n(floatingInfo);
        }
    }

    private final void w(d floatingInfo) {
        l a16 = floatingInfo.a();
        boolean z16 = a16 != null ? a16.f81187v : false;
        ImageView imageView = this.ivAdIcon;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(z16 ? 0 : 8);
    }

    private final void x(d floatingInfo) {
        l a16 = floatingInfo.a();
        Drawable g16 = ba.g(a16 != null ? a16.f81174i : null);
        URL c16 = bb.c(a16 != null ? a16.f81172g : null);
        if (c16 == null) {
            IVideoOuterStatusListener iVideoOuterStatusListener = this.outerListener;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onSetVideoCover(g16);
                return;
            }
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = g16;
        obtain.mLoadingDrawable = g16;
        URLDrawable drawable = URLDrawable.getDrawable(c16, obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(string2URL, options)");
        IVideoOuterStatusListener iVideoOuterStatusListener2 = this.outerListener;
        if (iVideoOuterStatusListener2 != null) {
            iVideoOuterStatusListener2.onSetVideoCover(drawable);
        }
    }

    @Override // xz.a
    public void a(List<l> infoList) {
        List<l> g16;
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        d dVar = this.videoFloatingInfo;
        if (dVar == null || (g16 = dVar.g()) == null) {
            return;
        }
        g16.addAll(infoList);
    }

    @Override // xz.a
    public boolean b() {
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            return wSPlayerManager.D0();
        }
        return false;
    }

    @Override // xz.a
    public void c() {
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            wSPlayerManager.O0();
        }
    }

    @Override // xz.a
    /* renamed from: d, reason: from getter */
    public d getVideoFloatingInfo() {
        return this.videoFloatingInfo;
    }

    @Override // xz.a
    public void e() {
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            wSPlayerManager.Y0();
        }
        d dVar = this.videoFloatingInfo;
        if (dVar != null) {
            if (dVar.getVideoIndex() < dVar.h() - 1) {
                dVar.r(dVar.getVideoIndex() + 1);
            }
            dVar.o(0L);
            i(dVar, this.videoLayout);
            IVideoOuterStatusListener iVideoOuterStatusListener = this.outerListener;
            if (iVideoOuterStatusListener != null) {
                iVideoOuterStatusListener.onOrientationChange(!j.g(dVar.a()));
            }
            v(dVar);
            playVideo();
        }
    }

    @Override // xz.a
    /* renamed from: f, reason: from getter */
    public IVideoOuterStatusListener getOuterListener() {
        return this.outerListener;
    }

    @Override // xz.a
    public void g() {
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            wSPlayerManager.N0();
        }
    }

    @Override // xz.a
    /* renamed from: h, reason: from getter */
    public com.tencent.biz.pubaccount.weishi.player.e getCurrentPlayerParam() {
        return this.currentPlayerParam;
    }

    public boolean k(Activity activity, d floatingInfo) {
        Intrinsics.checkNotNullParameter(floatingInfo, "floatingInfo");
        l a16 = floatingInfo.a();
        if (a16 == null || !j.b(activity)) {
            return false;
        }
        x.j("WSVideoFloatingWindow", "[enterFloatingWindow] listSize:" + floatingInfo.h());
        this.videoFloatingInfo = floatingInfo;
        yz.i.f451583a.l(true);
        j.i(true);
        Context l3 = l();
        o(l3);
        i(floatingInfo, this.videoLayout);
        q();
        r(floatingInfo);
        j.c(l3, this.floatingVideoView, a16);
        p();
        t(floatingInfo);
        u(floatingInfo);
        v(floatingInfo);
        return true;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IFullScreenEnterListener
    public void onEnter(int centerX, int centerY) {
        com.tencent.biz.pubaccount.weishi.player.e eVar = this.currentPlayerParam;
        d dVar = this.videoFloatingInfo;
        Integer valueOf = dVar != null ? Integer.valueOf(dVar.getVideoIndex()) : null;
        d dVar2 = this.videoFloatingInfo;
        c.e(eVar, valueOf, dVar2 != null ? dVar2.getVerticalTestId() : null);
        this.isEnterVerticalPage = true;
        h hVar = this.videoFloatingPresenter;
        d dVar3 = this.videoFloatingInfo;
        hVar.b(dVar3 != null ? dVar3.getVideoIndex() : 0, this.currentPlayerParam, l());
    }

    @Override // xz.a
    public void pauseVideo() {
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            wSPlayerManager.K0();
        }
    }

    @Override // xz.a
    public void playVideo() {
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            wSPlayerManager.L0(this.currentPlayerParam, false);
        }
    }

    @Override // xz.a
    public void preloadVideo() {
        d dVar = this.videoFloatingInfo;
        int videoIndex = dVar != null ? dVar.getVideoIndex() : 0;
        x.j("WSVideoFloatingWindow", "[preloadVideo] preloadIndex:" + videoIndex);
        WSVideoPreDownloadManager wSVideoPreDownloadManager = this.preloadManager;
        if (wSVideoPreDownloadManager != null) {
            wSVideoPreDownloadManager.v(videoIndex);
        }
    }

    @Override // xz.a
    public void release() {
        j();
        this.videoLayout = null;
        this.currentPlayerParam = null;
        this.innerListener = null;
        this.outerListener = null;
        this.videoFloatingInfo = null;
        WSVideoPreDownloadManager wSVideoPreDownloadManager = this.preloadManager;
        if (wSVideoPreDownloadManager != null) {
            wSVideoPreDownloadManager.o();
        }
        this.preloadManager = null;
        yz.i.f451583a.l(false);
    }

    public void v(d floatingInfo) {
        Intrinsics.checkNotNullParameter(floatingInfo, "floatingInfo");
        int videoIndex = floatingInfo.getVideoIndex();
        l a16 = floatingInfo.a();
        x.j("WSVideoFloatingWindow", "[onVideoSelected] position:" + videoIndex + ", title:" + (a16 != null ? a16.f81175j : null));
        w(floatingInfo);
        com.tencent.biz.pubaccount.weishi.player.e eVar = this.currentPlayerParam;
        d dVar = this.videoFloatingInfo;
        Integer valueOf = dVar != null ? Integer.valueOf(dVar.getVideoIndex()) : null;
        d dVar2 = this.videoFloatingInfo;
        c.g(eVar, valueOf, dVar2 != null ? dVar2.getVerticalTestId() : null);
        this.videoFloatingPresenter.c(floatingInfo);
    }

    public void y(com.tencent.biz.pubaccount.weishi.player.e playingParam, boolean isPlaying) {
        if ((playingParam != null ? playingParam.f81129e : null) == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.player.e eVar = this.currentPlayerParam;
        if (eVar != null) {
            WSPlayerWrapper wSPlayerWrapper = playingParam.f81129e;
            eVar.f81129e = wSPlayerWrapper;
            eVar.f81126b = playingParam.f81126b;
            eVar.f81137m = playingParam.f81137m;
            wSPlayerWrapper.u0(false);
        }
        WSPlayerManager wSPlayerManager = this.playerManager;
        if (wSPlayerManager != null) {
            wSPlayerManager.a1(this.currentPlayerParam, isPlaying);
        }
    }
}
