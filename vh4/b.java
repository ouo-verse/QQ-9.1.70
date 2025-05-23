package vh4;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uh4.f;
import uh4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016\u00a8\u0006!"}, d2 = {"Lvh4/b;", "Luh4/f;", "Landroid/content/Context;", "context", "", "init", "", "key", "Luh4/c;", "floatParams", "Landroid/view/View;", "customView", BdhLogUtil.LogTag.Tag_Req, "", "w", h.F, "h0", "", "canFreeDrag", "e0", "Lxh4/a;", "listener", "u1", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "g1", "d0", "E3", "Luh4/g;", "c2", "f0", "o2", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b implements f {
    @Override // uh4.f
    public void E3(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        d.INSTANCE.a().f(key);
    }

    @Override // uh4.f
    public void R(@NotNull String key, @Nullable uh4.c floatParams, @Nullable View customView) {
        Intrinsics.checkNotNullParameter(key, "key");
        d.INSTANCE.a().d(key, floatParams, customView);
    }

    @Override // uh4.f
    public void c2(@Nullable g listener) {
        d.INSTANCE.a().c(listener);
    }

    @Override // uh4.f
    public void d0(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        d.INSTANCE.a().q(key);
    }

    @Override // uh4.f
    public void e0(@NotNull String key, boolean canFreeDrag) {
        Intrinsics.checkNotNullParameter(key, "key");
        d.INSTANCE.a().r(key, canFreeDrag);
    }

    @Override // uh4.f
    public void f0(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        d.INSTANCE.a().l(key);
    }

    @Override // uh4.f
    public void g1(@NotNull String key, int closeReason) {
        Intrinsics.checkNotNullParameter(key, "key");
        d.INSTANCE.a().i(key, closeReason);
    }

    @Override // uh4.f
    public void h0(@NotNull String key, int w3, int h16) {
        Intrinsics.checkNotNullParameter(key, "key");
        d.INSTANCE.a().s(key, w3, h16);
    }

    @Override // uh4.f
    public void u1(@NotNull String key, @NotNull xh4.a listener) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        d.INSTANCE.a().o(key, listener);
    }

    @Override // mm4.a
    public void o2() {
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}
