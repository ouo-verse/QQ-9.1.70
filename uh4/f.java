package uh4;

import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH&J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\nH&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0018H&J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u001b"}, d2 = {"Luh4/f;", "Lmm4/a;", "", "key", "Luh4/c;", "floatParams", "Landroid/view/View;", "customView", "", BdhLogUtil.LogTag.Tag_Req, "", "w", h.F, "h0", "", "canFreeDrag", "e0", "Lxh4/a;", "listener", "u1", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CLOSE_REASON, "g1", "d0", "E3", "Luh4/g;", "c2", "f0", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface f extends mm4.a {
    void E3(@NotNull String key);

    void R(@NotNull String key, @Nullable c floatParams, @Nullable View customView);

    void c2(@Nullable g listener);

    void d0(@NotNull String key);

    void e0(@NotNull String key, boolean canFreeDrag);

    void f0(@NotNull String key);

    void g1(@NotNull String key, int closeReason);

    void h0(@NotNull String key, int w3, int h16);

    void u1(@NotNull String key, @NotNull xh4.a listener);
}
