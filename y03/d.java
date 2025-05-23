package y03;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.text.OffsetableImageSpan;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d extends OffsetableImageSpan {
    public boolean C;

    /* renamed from: d, reason: collision with root package name */
    private String f449230d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f449231e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f449232f;

    /* renamed from: h, reason: collision with root package name */
    private int f449233h;

    /* renamed from: i, reason: collision with root package name */
    private int f449234i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f449235m;

    public int a() {
        Rect bounds = getDrawable().getBounds();
        Paint.FontMetricsInt fontMetricsInt = this.f449235m.getFontMetricsInt();
        int max = Math.max(bounds.bottom, (-fontMetricsInt.top) + fontMetricsInt.bottom);
        this.f449234i = max;
        return max;
    }

    public int b() {
        Paint paint = this.f449235m;
        String str = this.f449230d;
        getSize(paint, str, 0, str.length(), this.f449235m.getFontMetricsInt());
        return this.f449233h;
    }

    @Override // com.tencent.mobileqq.text.OffsetableImageSpan, android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
        int i26;
        int i27;
        if (this.C) {
            i26 = this.f449235m.getFontMetricsInt().top + i18;
        } else {
            i26 = i18;
        }
        int i28 = this.f449233h;
        if (i28 > 0 && (i27 = this.f449234i) > 0) {
            this.f449232f.setBounds(0, i26, i28, i27 + i26);
            this.f449232f.draw(canvas);
        }
        super.draw(canvas, charSequence, i3, i16, f16, i17, i18, i19, paint);
        float f17 = f16 + getDrawable().getBounds().right;
        int i29 = i18 - this.f449235m.getFontMetricsInt().ascent;
        if (!this.C) {
            i18 = i29;
        }
        canvas.drawText(this.f449230d, f17, i18, this.f449235m);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        this.f449235m.getTextWidths(this.f449230d, this.f449231e);
        int i17 = bounds.right;
        for (float f16 : this.f449231e) {
            i17 = (int) (i17 + f16);
        }
        this.f449233h = i17;
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        this.f449234i = Math.max(bounds.bottom, (-fontMetricsInt2.top) + fontMetricsInt2.bottom);
        return i17;
    }
}
