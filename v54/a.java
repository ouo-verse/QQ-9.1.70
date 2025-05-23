package v54;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ml3.b;
import org.jetbrains.annotations.NotNull;
import x64.j;
import x64.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lv54/a;", "Lx64/j;", "Lml3/b;", "emitterService", "Landroid/graphics/Rect;", "viewport", "", "isHalfMode", "", "d", "businessRootViewHeight", "e", "Landroid/util/DisplayMetrics;", "metrics", "<init>", "(Landroid/util/DisplayMetrics;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a extends j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull DisplayMetrics metrics) {
        super(metrics);
        Intrinsics.checkNotNullParameter(metrics, "metrics");
    }

    @Override // x64.j
    public int d(@NotNull b emitterService, @NotNull Rect viewport, boolean isHalfMode) {
        Intrinsics.checkNotNullParameter(emitterService, "emitterService");
        Intrinsics.checkNotNullParameter(viewport, "viewport");
        return ((m) emitterService.b(m.class)).w0(isHalfMode, 0, viewport.height());
    }

    @Override // x64.j
    public int e(@NotNull b emitterService, @NotNull Rect viewport, int businessRootViewHeight, boolean isHalfMode) {
        Intrinsics.checkNotNullParameter(emitterService, "emitterService");
        Intrinsics.checkNotNullParameter(viewport, "viewport");
        return Math.max(viewport.height() - c(emitterService, viewport.height(), isHalfMode), g());
    }
}
