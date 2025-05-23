package rv;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.av.utils.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends e {
    private TextPaint E;
    private Paint.FontMetricsInt F;
    protected Canvas G;
    private final Bitmap.Config H;

    /* renamed from: y, reason: collision with root package name */
    private float f432539y = 1.0f;

    /* renamed from: z, reason: collision with root package name */
    private float f432540z = 15.0f;
    private int A = -1;
    private int B = Integer.MAX_VALUE;
    private int C = Integer.MAX_VALUE;
    private int D = Integer.MAX_VALUE;
    private boolean I = false;

    /* renamed from: x, reason: collision with root package name */
    private String f432538x = "";

    public d() {
        TextPaint textPaint = new TextPaint();
        this.E = textPaint;
        textPaint.setAntiAlias(true);
        this.E.setColor(this.A);
        this.E.setTextSize(this.f432540z);
        this.E.setShadowLayer(2.0f, 0.0f, 0.0f, -16777216);
        this.F = this.E.getFontMetricsInt();
        this.H = Bitmap.Config.ARGB_8888;
        H(false);
    }

    @Override // rv.e
    protected void E(Bitmap bitmap) {
        if (!com.tencent.av.opengl.texture.a.m()) {
            bitmap.recycle();
        }
    }

    @Override // rv.e
    protected Bitmap F() {
        Bitmap createBitmap = Bitmap.createBitmap(this.f74098g, this.f74099h, this.H);
        Canvas canvas = new Canvas(createBitmap);
        this.G = canvas;
        canvas.translate(0.0f, -this.F.ascent);
        this.G.drawText(this.f432538x, 0.0f, 0.0f, this.E);
        return createBitmap;
    }

    public int L() {
        return Math.abs(this.F.ascent);
    }

    public int M() {
        Paint.FontMetricsInt fontMetricsInt = this.F;
        return (int) Math.ceil(fontMetricsInt.descent - fontMetricsInt.ascent);
    }

    public boolean N() {
        return this.I;
    }

    public void O() {
        int i3;
        boolean z16;
        int i16 = 1;
        if (!TextUtils.isEmpty(this.f432538x)) {
            int e16 = i.e(this.f432538x);
            int ceil = (int) Math.ceil(this.E.measureText(this.f432538x));
            int i17 = this.B;
            if (ceil > i17) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int ceil2 = i17 - ((int) Math.ceil(this.E.measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX)));
                double ceil3 = Math.ceil(this.E.measureText(this.f432538x));
                while (((int) ceil3) > ceil2 && e16 > 0) {
                    e16--;
                    this.f432538x = i.h(this.f432538x, 0, e16);
                    ceil3 = Math.ceil(this.E.measureText(r2));
                }
                this.f432538x = this.f432538x + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                ceil = (int) Math.ceil(this.E.measureText(r0));
            }
            Paint.FontMetricsInt fontMetricsInt = this.F;
            int i18 = fontMetricsInt.bottom - fontMetricsInt.top;
            if (ceil <= 0) {
                ceil = 1;
            }
            if (i18 > 0) {
                i16 = i18;
            }
            i3 = i16;
            i16 = ceil;
        } else {
            i3 = 1;
        }
        w(i16, i3);
        x(i16, i3);
        if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "refreshText width: " + this.f74098g + ", height: " + this.f74099h + ", maxLength: " + this.D + ", textSize: " + this.f432540z + ", text: " + this.f432538x + ";mMetrics:=" + this.F.toString());
        }
    }

    public void P(boolean z16) {
        if (z16) {
            this.E.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.E.setTypeface(Typeface.defaultFromStyle(0));
        }
        this.I = z16;
    }

    public void Q(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "setMaxLength maxLength: " + i3);
        }
        this.D = i3;
    }

    public void R(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "setWidth width: " + i3);
        }
        if (i3 > 0) {
            this.B = i3;
        }
    }

    public void S(String str) {
        this.f432538x = str;
    }

    public void T(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "setTextColor textColor: " + i3);
        }
        this.A = i3;
        this.E.setColor(i3);
    }

    public void U(float f16) {
        if (QLog.isColorLevel()) {
            QLog.d("StringTexture", 2, "setTextSize textSize: " + f16);
        }
        this.f432540z = f16;
        this.E.setTextSize(f16);
        this.F = this.E.getFontMetricsInt();
    }

    @Override // com.tencent.av.opengl.texture.a
    public void a(ov.a aVar, int i3, int i16, int i17, int i18) {
        boolean z16;
        if (this.f432539y < 0.99f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            aVar.f(3);
            aVar.setAlpha(this.f432539y);
        }
        aVar.g(this, i3, i16, i17, i18);
        if (z16) {
            aVar.restore();
        }
    }
}
