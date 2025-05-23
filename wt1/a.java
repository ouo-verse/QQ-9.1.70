package wt1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends ImageSpan {

    /* renamed from: d, reason: collision with root package name */
    private int f446474d;

    /* renamed from: e, reason: collision with root package name */
    private int f446475e;

    /* renamed from: f, reason: collision with root package name */
    private int f446476f;

    public a(Context context, int i3, int i16, int i17, int i18) {
        super(context, i3);
        this.f446474d = i16;
        this.f446475e = i17;
        this.f446476f = i18;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i26 = this.f446474d;
        if (i26 > 0) {
            drawable.setBounds(0, 0, i26, i26);
        } else if (i26 == 0) {
            int dip2px = ViewUtils.dip2px(16.0f);
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight == 0) {
                intrinsicHeight = dip2px;
            }
            drawable.setBounds(0, 0, (drawable.getIntrinsicWidth() * dip2px) / intrinsicHeight, dip2px);
        }
        canvas.save();
        canvas.translate(this.f446475e + f16, ((((fontMetricsInt.descent + i18) + i18) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Drawable drawable = getDrawable();
        int i17 = this.f446474d;
        if (i17 > 0) {
            drawable.setBounds(0, 0, i17, i17);
        } else if (i17 == 0) {
            int dip2px = ViewUtils.dip2px(16.0f);
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight == 0) {
                intrinsicHeight = dip2px;
            }
            drawable.setBounds(0, 0, (drawable.getIntrinsicWidth() * dip2px) / intrinsicHeight, dip2px);
        }
        Rect bounds = drawable.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i18 = fontMetricsInt2.bottom - fontMetricsInt2.top;
            int i19 = (bounds.bottom - bounds.top) / 2;
            int i26 = i18 / 4;
            int i27 = i19 - i26;
            int i28 = -(i19 + i26);
            fontMetricsInt.ascent = i28;
            fontMetricsInt.top = i28;
            fontMetricsInt.bottom = i27;
            fontMetricsInt.descent = i27;
        }
        return this.f446475e + bounds.right + this.f446476f;
    }
}
