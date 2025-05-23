package tc0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f435823d;

    public b(Drawable drawable, int i3, int i16) {
        super(drawable, i3);
        this.f435823d = i16;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        int i26 = (i18 + paint.getFontMetricsInt().descent) - drawable.getBounds().bottom;
        int i27 = ((ImageSpan) this).mVerticalAlignment;
        if (i27 == 1) {
            i26 -= paint.getFontMetricsInt().descent;
        } else if (i27 == 2) {
            i26 = (i17 + ((i19 - i17) / 2)) - (drawable.getBounds().height() / 2);
        }
        canvas.translate(f16, i26);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        if (fontMetricsInt != null) {
            int i17 = -bounds.bottom;
            fontMetricsInt.ascent = i17;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i17;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right + this.f435823d;
    }
}
