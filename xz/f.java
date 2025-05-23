package xz;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lxz/f;", "Lcom/tencent/biz/pubaccount/weishi/player/g;", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "playParam", "", "e", "b", tl.h.F, "", "isCompleted", "a", "Lxz/a;", "Lxz/a;", "floating", "<init>", "(Lxz/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class f extends com.tencent.biz.pubaccount.weishi.player.g {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final a floating;

    public f(a floating) {
        Intrinsics.checkNotNullParameter(floating, "floating");
        this.floating = floating;
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.g, com.tencent.biz.pubaccount.weishi.player.f
    public void a(com.tencent.biz.pubaccount.weishi.player.e playParam, boolean isCompleted) {
        super.a(playParam, isCompleted);
        d d16 = this.floating.d();
        c.j(playParam, isCompleted, d16 != null ? d16.getVerticalTestId() : null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.g, com.tencent.biz.pubaccount.weishi.player.f
    public void b(com.tencent.biz.pubaccount.weishi.player.e playParam) {
        super.b(playParam);
        d d16 = this.floating.d();
        c.i(playParam, d16 != null ? d16.getVerticalTestId() : null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.g, com.tencent.biz.pubaccount.weishi.player.f
    public void e(com.tencent.biz.pubaccount.weishi.player.e playParam) {
        super.e(playParam);
        this.floating.preloadVideo();
        d d16 = this.floating.d();
        c.i(playParam, d16 != null ? d16.getVerticalTestId() : null);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.g, com.tencent.biz.pubaccount.weishi.player.f
    public void h(com.tencent.biz.pubaccount.weishi.player.e playParam) {
        super.h(playParam);
        this.floating.e();
    }
}
