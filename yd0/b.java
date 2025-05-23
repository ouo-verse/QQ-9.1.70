package yd0;

import android.R;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Lyd0/b;", "", "Landroid/graphics/drawable/Drawable;", "normalDrawable", "", "overlayColor", "d", "originDrawable", "c", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "b", "drawable", "color", "e", "", "factor", "a", "<init>", "()V", "QUINoticeBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f450165a = new b();

    b() {
    }

    public final int a(int color, float factor) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(Color.alpha(color) * factor);
        return Color.argb(roundToInt, Color.red(color), Color.green(color), Color.blue(color));
    }

    @NotNull
    public final Drawable b(@NotNull Drawable old) {
        Drawable newDrawable;
        Drawable mutate;
        Intrinsics.checkNotNullParameter(old, "old");
        if (old instanceof SkinnableBitmapDrawable) {
            Drawable mutate2 = ((SkinnableBitmapDrawable) old).mutate2();
            Intrinsics.checkNotNullExpressionValue(mutate2, "old.mutate2()");
            return mutate2;
        }
        Drawable.ConstantState constantState = old.getConstantState();
        if (constantState != null && (newDrawable = constantState.newDrawable()) != null && (mutate = newDrawable.mutate()) != null) {
            old = mutate;
        }
        Intrinsics.checkNotNullExpressionValue(old, "old.constantState?.newDrawable()?.mutate() ?: old");
        return old;
    }

    @NotNull
    public final Drawable c(@NotNull Drawable originDrawable, int overlayColor) {
        Intrinsics.checkNotNullParameter(originDrawable, "originDrawable");
        Drawable e16 = e(originDrawable, overlayColor);
        Drawable b16 = b(e16);
        b16.setAlpha((int) 127.5d);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, b16);
        stateListDrawable.addState(new int[0], e16);
        return stateListDrawable;
    }

    @NotNull
    public final Drawable d(@NotNull Drawable normalDrawable, int overlayColor) {
        Intrinsics.checkNotNullParameter(normalDrawable, "normalDrawable");
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, e(normalDrawable, overlayColor));
        stateListDrawable.addState(new int[0], normalDrawable);
        return stateListDrawable;
    }

    @NotNull
    public final Drawable e(@NotNull Drawable drawable, int color) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Drawable b16 = b(drawable);
        b16.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        return b16;
    }
}
