package xz;

import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.listener.IVideoOuterStatusListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u000e\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lxz/g;", "Lcom/tencent/biz/pubaccount/weishi/player/h;", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "playParam", "", "r", "", "e", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "model", "what", "", "errorMsg", "c", "Lxz/a;", "b", "Lxz/a;", "floating", "<init>", "(Lxz/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends com.tencent.biz.pubaccount.weishi.player.h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a floating;

    public g(a floating) {
        Intrinsics.checkNotNullParameter(floating, "floating");
        this.floating = floating;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.h, com.tencent.biz.pubaccount.weishi.player.a
    public void c(com.tencent.biz.pubaccount.weishi.player.e playParam, int model, int what, String errorMsg) {
        super.c(playParam, model, what, errorMsg);
        IVideoOuterStatusListener f16 = this.floating.f();
        if (f16 != null) {
            f16.onVideoError(what);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.h, com.tencent.biz.pubaccount.weishi.player.a
    public void e(com.tencent.biz.pubaccount.weishi.player.e playParam) {
        super.e(playParam);
        IVideoOuterStatusListener f16 = this.floating.f();
        if (f16 != null) {
            f16.onVideoStart(r(playParam));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.h, com.tencent.biz.pubaccount.weishi.player.a
    public void p(com.tencent.biz.pubaccount.weishi.player.e playParam) {
        super.p(playParam);
        IVideoOuterStatusListener f16 = this.floating.f();
        if (f16 != null) {
            f16.onVideoStart(r(playParam));
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.h, com.tencent.biz.pubaccount.weishi.player.a
    public void q(com.tencent.biz.pubaccount.weishi.player.e playParam) {
        super.q(playParam);
        IVideoOuterStatusListener f16 = this.floating.f();
        if (f16 != null) {
            f16.onVideoBuffering();
        }
    }

    private final int r(com.tencent.biz.pubaccount.weishi.player.e playParam) {
        l lVar;
        if (playParam == null || (lVar = playParam.f81127c) == null) {
            return 0;
        }
        return lVar.f81169d;
    }
}
