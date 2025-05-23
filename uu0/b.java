package uu0;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.icgame.game.utils.g;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0005*\u00020\u0000\u001a\u001e\u0010\f\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\n\u0010\n\u001a\u00020\t\"\u00020\u0005\u001a\u0016\u0010\r\u001a\u00020\u000b*\u00020\u00002\n\u0010\n\u001a\u00020\t\"\u00020\u0005\u001a*\u0010\u0013\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a\u0012\u0010\u0015\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0005\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0000\u001a\u0012\u0010\u001b\u001a\u00020\u0003*\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019\u00a8\u0006\u001c"}, d2 = {"Landroid/view/View;", "", ViewStickEventHelper.IS_SHOW, "", "i", "", "e", "f", "radius", "", NodeProps.COLORS, "Landroid/graphics/drawable/GradientDrawable;", "d", "a", "", "leftTop", "rightTop", "leftBottom", "rightBottom", "c", "height", h.F, "Landroid/view/ViewGroup;", "view", "b", "", "tag", "g", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {
    @NotNull
    public static final GradientDrawable a(@NotNull View view, @NotNull int... colors) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(colors, "colors");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (colors.length > 1) {
            gradientDrawable.setColors(colors);
        } else {
            gradientDrawable.setColor(colors[0]);
        }
        view.setBackgroundDrawable(gradientDrawable);
        return gradientDrawable;
    }

    public static final boolean b(@NotNull ViewGroup viewGroup, @Nullable View view) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        if (view == null) {
            return false;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (Intrinsics.areEqual(viewGroup.getChildAt(i3), view)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final GradientDrawable c(@NotNull GradientDrawable gradientDrawable, float f16, float f17, float f18, float f19) {
        Intrinsics.checkNotNullParameter(gradientDrawable, "<this>");
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f17, f17, f19, f19, f18, f18});
        return gradientDrawable;
    }

    @NotNull
    public static final GradientDrawable d(@NotNull View view, int i3, @NotNull int... colors) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(colors, "colors");
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (colors.length > 1) {
            gradientDrawable.setColors(colors);
        } else {
            gradientDrawable.setColor(colors[0]);
        }
        gradientDrawable.setCornerRadius(i3);
        view.setBackgroundDrawable(gradientDrawable);
        return gradientDrawable;
    }

    public static final int e(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    public static final int f(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    public static final void g(@NotNull ViewGroup viewGroup, @NotNull String tag) {
        Object obj;
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt != null) {
                obj = childAt.getTag();
            } else {
                obj = null;
            }
            if (Intrinsics.areEqual(tag, obj)) {
                viewGroup.removeView(childAt);
            }
        }
    }

    public static final void h(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        g.a("ViewEx", "keyboardHeight: " + i3);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i3;
        }
        view.setLayoutParams(layoutParams);
    }

    public static final void i(@NotNull View view, boolean z16) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (z16) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
