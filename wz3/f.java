package wz3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;
import tz3.i;
import tz3.k;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Rect f446800a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    private static final TextPaint f446801b = new TextPaint();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Float, Float> f446802c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private static final Map<Float, Float> f446803d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final Map<Float, Float> f446804e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public static volatile Paint f446805f = new Paint();

    static {
        f446805f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }

    public static void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 29) {
            b(canvas, 0, 0, canvas.getWidth(), canvas.getHeight());
        } else {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    public static void b(Canvas canvas, int i3, int i16, int i17, int i18) {
        Rect rect = f446800a;
        rect.set(i3, i16, i17, i18);
        c(canvas, rect);
    }

    public static void c(Canvas canvas, Rect rect) {
        if (rect.width() > 0 && rect.height() > 0) {
            canvas.drawRect(rect, f446805f);
        }
    }

    public static float d(k kVar) {
        return e(kVar.l()) + (i.l().f() * 2) + (kVar.a() * 2.0f) + (kVar.h() * 2.0f);
    }

    public static float e(float f16) {
        TextPaint textPaint = f446801b;
        textPaint.setTextSize(f16);
        Map<Float, Float> map = f446802c;
        Float f17 = map.get(Float.valueOf(f16));
        if (f17 == null) {
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            f17 = Float.valueOf((fontMetrics.descent - fontMetrics.ascent) + fontMetrics.leading);
            map.put(Float.valueOf(f16), f17);
        }
        return f17.floatValue();
    }

    public static float f(float f16, String str) {
        TextPaint textPaint = f446801b;
        textPaint.setTextSize(f16);
        return g(textPaint, str);
    }

    public static float g(Paint paint, String str) {
        return paint.measureText(str);
    }
}
