package tc0;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends MetricAffectingSpan {

    /* renamed from: d, reason: collision with root package name */
    private Typeface f435821d;

    /* renamed from: e, reason: collision with root package name */
    private float f435822e;

    public a(Typeface typeface, int i3) {
        this.f435821d = typeface;
        this.f435822e = i3;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Typeface typeface = this.f435821d;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        float f16 = this.f435822e;
        if (f16 > 0.0f) {
            textPaint.setTextSize(f16);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(@NonNull TextPaint textPaint) {
        Typeface typeface = this.f435821d;
        if (typeface != null) {
            textPaint.setTypeface(typeface);
        }
        float f16 = this.f435822e;
        if (f16 > 0.0f) {
            textPaint.setTextSize(f16);
        }
    }
}
