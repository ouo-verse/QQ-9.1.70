package u12;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.annotation.ColorInt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a5\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00028\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\n\u001a\u00020\t*\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0001\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u0014\u0010\u000f\u001a\u00020\r*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0000\u001a\u0014\u0010\u0013\u001a\u00020\t*\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0000\u00a8\u0006\u0016"}, d2 = {"Landroid/view/View;", "T", "", "colorString", "", "color", "Landroid/graphics/Paint;", "b", "(Landroid/view/View;Ljava/lang/String;Ljava/lang/Integer;)Landroid/graphics/Paint;", "", "f", "(Landroid/graphics/Paint;Ljava/lang/String;Ljava/lang/Integer;)V", "Landroid/content/Context;", "", "dpValue", "d", "Landroid/graphics/Canvas;", "", "debug", "e", "flag", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "DrawUtil")
/* loaded from: classes14.dex */
public final class a {
    public static final boolean a(int i3, int i16) {
        if ((i16 | i3) == i3) {
            return true;
        }
        return false;
    }

    @JvmOverloads
    @NotNull
    public static final <T extends View> Paint b(@NotNull T t16, @Nullable String str, @ColorInt @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(t16, "<this>");
        Paint paint = new Paint();
        f(paint, str, num);
        return paint;
    }

    public static /* synthetic */ Paint c(View view, String str, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            num = null;
        }
        return b(view, str, num);
    }

    public static final float d(@NotNull Context context, float f16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0.0f;
        }
        return (f16 * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static final void e(@NotNull Canvas canvas, boolean z16) {
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        if (z16) {
            canvas.drawColor(-16711936);
        }
    }

    @JvmOverloads
    public static final void f(@NotNull Paint paint, @Nullable String str, @ColorInt @Nullable Integer num) {
        int parseColor;
        Intrinsics.checkNotNullParameter(paint, "<this>");
        paint.reset();
        if (num != null) {
            parseColor = num.intValue();
        } else {
            if (str == null) {
                str = "#FFFFFF";
            }
            parseColor = Color.parseColor(str);
        }
        paint.setColor(parseColor);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(0.0f);
    }

    public static /* synthetic */ void g(Paint paint, String str, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            num = null;
        }
        f(paint, str, num);
    }
}
