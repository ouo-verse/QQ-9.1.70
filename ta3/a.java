package ta3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mtt.hippy.dom.node.ImageNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0015\u0010\u0016JR\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0019"}, d2 = {"Lta3/a;", "Landroid/text/style/ImageSpan;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "text", "", "start", "end", "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "Landroid/graphics/Paint;", "paint", "", "draw", "Landroid/graphics/drawable/Drawable;", "drawable", ImageNode.PROP_VERTICAL_ALIGNMENT, "<init>", "(Landroid/graphics/drawable/Drawable;I)V", "d", "a", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends ImageSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Drawable drawable, int i3) {
        super(drawable, i3);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (((ImageSpan) this).mVerticalAlignment == 100) {
            Drawable drawable = getDrawable();
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            canvas.save();
            canvas.translate(x16, top);
            drawable.draw(canvas);
            canvas.restore();
            return;
        }
        super.draw(canvas, text, start, end, x16, top, y16, bottom, paint);
    }
}
