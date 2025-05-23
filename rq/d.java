package rq;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.ae.font.AEFontManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private TextPaint f431903a = new TextPaint();

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f431904b = new TextPaint();

    /* renamed from: c, reason: collision with root package name */
    private int f431905c = 0;

    /* renamed from: d, reason: collision with root package name */
    private Rect f431906d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private String f431907e = "";

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f431908f;

    /* renamed from: g, reason: collision with root package name */
    private Canvas f431909g;

    /* renamed from: h, reason: collision with root package name */
    private String f431910h;

    /* renamed from: i, reason: collision with root package name */
    private int f431911i;

    /* renamed from: j, reason: collision with root package name */
    private int f431912j;

    public d(int i3, int i16) {
        this.f431911i = i3;
        this.f431912j = i16;
        this.f431908f = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        this.f431909g = new Canvas(this.f431908f);
    }

    private void a(String str, Paint paint, int i3, int i16, int i17) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        while (true) {
            if (rect.width() + i17 <= i3 * 0.8f && rect.height() + i17 <= i16 * 0.8f) {
                return;
            }
            paint.setTextSize(paint.getTextSize() - 2.0f);
            paint.getTextBounds(str, 0, str.length(), rect);
        }
    }

    private void c(Canvas canvas, String str, float f16, float f17, Paint paint) {
        canvas.drawText(str, f16, f17, paint);
    }

    private void g() {
        Typeface e16 = AEFontManager.d().e(this.f431910h);
        this.f431903a.setTypeface(e16);
        this.f431904b.setTypeface(e16);
    }

    public void b() {
        g();
        this.f431904b.setTextSize(this.f431903a.getTextSize());
        this.f431904b.setStyle(Paint.Style.STROKE);
        this.f431904b.setStrokeWidth(this.f431905c);
        this.f431903a.setAntiAlias(true);
        this.f431904b.setAntiAlias(true);
        TextPaint textPaint = this.f431903a;
        String str = this.f431907e;
        textPaint.getTextBounds(str, 0, str.length(), this.f431906d);
        float height = this.f431906d.height();
        int indexOf = this.f431907e.indexOf("\r\n");
        if (indexOf < 0) {
            if (TextUtils.isEmpty(this.f431907e)) {
                return;
            }
            a(this.f431907e, this.f431904b, this.f431911i, this.f431912j, this.f431905c);
            this.f431903a.setTextSize(this.f431904b.getTextSize());
            float abs = (height / 2.0f) + ((Math.abs(this.f431903a.ascent()) - this.f431903a.descent()) / 2.0f);
            Canvas canvas = this.f431909g;
            String str2 = this.f431907e;
            c(canvas, str2, (this.f431911i - this.f431904b.measureText(str2)) / 2.0f, ((this.f431912j - height) / 2.0f) + abs, this.f431904b);
            Canvas canvas2 = this.f431909g;
            String str3 = this.f431907e;
            c(canvas2, str3, (this.f431911i - this.f431903a.measureText(str3)) / 2.0f, ((this.f431912j - height) / 2.0f) + abs, this.f431903a);
        } else {
            String substring = this.f431907e.substring(0, indexOf);
            String substring2 = this.f431907e.substring(indexOf + 2);
            a(substring, this.f431904b, this.f431911i, this.f431912j / 2, this.f431905c);
            this.f431903a.setTextSize(this.f431904b.getTextSize());
            float f16 = height / 2.0f;
            float abs2 = ((Math.abs(this.f431903a.ascent()) - this.f431903a.descent()) / 2.0f) + f16;
            c(this.f431909g, substring, (this.f431911i - this.f431904b.measureText(substring)) / 2.0f, ((this.f431912j * 0.25f) - f16) + abs2, this.f431904b);
            c(this.f431909g, substring, (this.f431911i - this.f431903a.measureText(substring)) / 2.0f, ((this.f431912j * 0.25f) - f16) + abs2, this.f431903a);
            c(this.f431909g, substring2, (this.f431911i - this.f431904b.measureText(substring2)) / 2.0f, ((this.f431912j * 0.65f) - f16) + abs2, this.f431904b);
            c(this.f431909g, substring2, (this.f431911i - this.f431903a.measureText(substring2)) / 2.0f, ((this.f431912j * 0.65f) - f16) + abs2, this.f431903a);
        }
        this.f431909g.drawBitmap(this.f431908f, 0.0f, 0.0f, this.f431903a);
    }

    public Bitmap d() {
        return this.f431908f;
    }

    public void e() {
        Bitmap bitmap = this.f431908f;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.f431908f.recycle();
    }

    public void f(String str) {
        this.f431910h = str;
    }

    public void h(String str) {
        this.f431904b.setColor(Color.parseColor(str));
    }

    public void i(int i3) {
        this.f431905c = i3;
    }

    public void j(String str) {
        this.f431907e = str.trim();
        Bitmap bitmap = this.f431908f;
        if (bitmap != null) {
            bitmap.eraseColor(0);
        }
    }

    public void k(String str) {
        this.f431903a.setColor(Color.parseColor(str));
    }

    public void l(float f16) {
        this.f431903a.setTextSize(f16);
    }
}
