package xz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.v;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001e\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003J0\u0010\u0012\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J*\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001aR$\u0010!\u001a\u0010\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010 \u00a8\u0006&"}, d2 = {"Lxz/h;", "Ljz/c;", "Lcom/tencent/biz/pubaccount/weishi/player/l;", "Lxz/d;", "floatingInfo", "", "d", "isInPublicAccount", "", "a", "", "c", "", "videoInfoList", "isRefresh", "isFirst", "", "extObject", "d0", "", "errorCode", "errorMsg", "i", "position", "Lcom/tencent/biz/pubaccount/weishi/player/e;", "playingParam", "Landroid/content/Context;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "b", "Lmqq/util/WeakReference;", "Lxz/a;", "kotlin.jvm.PlatformType", "Lmqq/util/WeakReference;", "viewWeakReference", "wsVideoFloating", "<init>", "(Lxz/a;)V", "e", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h implements jz.c<l> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<a> viewWeakReference;

    public h(a wsVideoFloating) {
        Intrinsics.checkNotNullParameter(wsVideoFloating, "wsVideoFloating");
        this.viewWeakReference = new WeakReference<>(wsVideoFloating);
    }

    private final boolean d(d floatingInfo) {
        return (floatingInfo.h() - 1) - floatingInfo.getVideoIndex() <= 3;
    }

    public final void b(int position, com.tencent.biz.pubaccount.weishi.player.e playingParam, Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        yz.i iVar = yz.i.f451583a;
        iVar.m(playingParam);
        boolean isInWSPublicAccount = WSPublicAccReport.getInstance().isInWSPublicAccount();
        if (!isInWSPublicAccount) {
            v.b().f();
            v.b().e();
            WSPublicAccReport.getInstance().enterPublicAccReport(null, 2, "from_float_window", null);
        }
        a.b.c(new com.tencent.biz.pubaccount.weishi.verticalvideo.k(activity, a(isInWSPublicAccount), "mini_videoplay").M(iVar.i() + position));
    }

    public final void c(d floatingInfo) {
        Intrinsics.checkNotNullParameter(floatingInfo, "floatingInfo");
        if (d(floatingInfo)) {
            yz.i iVar = yz.i.f451583a;
            iVar.e(iVar.f(), this);
        }
    }

    @Override // jz.c
    public void d0(List<l> videoInfoList, boolean isRefresh, boolean isFirst, Object extObject) {
        Intrinsics.checkNotNullParameter(videoInfoList, "videoInfoList");
        a aVar = this.viewWeakReference.get();
        if (aVar != null) {
            aVar.a(videoInfoList);
        }
    }

    private final String a(boolean isInPublicAccount) {
        if (isInPublicAccount) {
            return "float_window_in_ws";
        }
        return "float_window_out_ws";
    }

    @Override // jz.c
    public void i(int errorCode, String errorMsg, boolean isFirst, boolean isRefresh) {
    }
}
