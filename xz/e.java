package xz;

import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lxz/e;", "Lcom/tencent/mobileqq/qqfloatingwindow/listener/IVideoInnerStatusListener;", "", "notifyVideoStart", "notifyVideoStop", "", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "notifyVideoSeek", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "notifyVideoClose", "Lxz/a;", "a", "Lxz/a;", "floating", "<init>", "(Lxz/a;)V", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e implements IVideoInnerStatusListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final a floating;

    public e(a floating) {
        Intrinsics.checkNotNullParameter(floating, "floating");
        this.floating = floating;
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
    public void notifyVideoClose(int closeReason) {
        x.j("WSVideoFloatingInnerListenerImpl", "notifyVideoClose");
        if (closeReason == 1) {
            com.tencent.biz.pubaccount.weishi.player.e h16 = this.floating.h();
            d d16 = this.floating.d();
            c.d(h16, d16 != null ? d16.getVerticalTestId() : null);
        }
        this.floating.release();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
    public void notifyVideoStart() {
        x.j("WSVideoFloatingInnerListenerImpl", "notifyVideoStart");
        com.tencent.biz.pubaccount.weishi.player.e h16 = this.floating.h();
        d d16 = this.floating.d();
        Integer valueOf = d16 != null ? Integer.valueOf(d16.getVideoIndex()) : null;
        d d17 = this.floating.d();
        c.f(h16, valueOf, d17 != null ? d17.getVerticalTestId() : null);
        if (this.floating.b()) {
            this.floating.c();
        } else {
            this.floating.playVideo();
        }
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
    public void notifyVideoStop() {
        x.j("WSVideoFloatingInnerListenerImpl", "notifyVideoStop");
        com.tencent.biz.pubaccount.weishi.player.e h16 = this.floating.h();
        d d16 = this.floating.d();
        c.j(h16, false, d16 != null ? d16.getVerticalTestId() : null);
        this.floating.g();
        this.floating.pauseVideo();
    }

    @Override // com.tencent.mobileqq.qqfloatingwindow.listener.IVideoInnerStatusListener
    public void notifyVideoSeek(int seek) {
    }
}
