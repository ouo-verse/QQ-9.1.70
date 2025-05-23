package v63;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.mobileqq.wink.editor.mosaic.ui.DoodleView;
import hd0.c;

/* compiled from: P */
/* loaded from: classes21.dex */
public abstract class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public Context f441188a;

    /* renamed from: b, reason: collision with root package name */
    protected DoodleView f441189b;

    /* renamed from: c, reason: collision with root package name */
    protected Paint f441190c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f441191d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f441192e;

    /* renamed from: f, reason: collision with root package name */
    protected int f441193f;

    /* renamed from: g, reason: collision with root package name */
    protected int f441194g;

    /* renamed from: h, reason: collision with root package name */
    protected int f441195h;

    /* renamed from: i, reason: collision with root package name */
    protected int f441196i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f441197j;

    /* renamed from: l, reason: collision with root package name */
    protected float f441199l;

    /* renamed from: k, reason: collision with root package name */
    protected int f441198k = 0;

    /* renamed from: m, reason: collision with root package name */
    protected Matrix f441200m = new Matrix();

    public a(DoodleView doodleView) {
        if (doodleView != null) {
            this.f441188a = doodleView.getContext();
            this.f441189b = doodleView;
            f();
            return;
        }
        throw new IllegalStateException("DoodleView can not be null.");
    }

    private void f() {
        this.f441191d = new Rect();
        Paint paint = new Paint();
        this.f441190c = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f441192e = paint2;
        paint2.setAntiAlias(true);
        this.f441192e.setStyle(Paint.Style.STROKE);
        this.f441192e.setStrokeWidth(5.0f);
        this.f441192e.setColor(-16776961);
        this.f441197j = false;
    }

    public final boolean b(MotionEvent motionEvent) {
        h();
        return k(motionEvent);
    }

    public final void c(Canvas canvas) {
        j(canvas);
    }

    public int d() {
        return this.f441198k;
    }

    public void e(int i3) {
        this.f441198k = i3 + 1;
    }

    public abstract boolean g(long j3);

    public void h() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f441189b.invalidate();
        } else {
            this.f441189b.postInvalidate();
        }
    }

    public void i() {
        c.a("BaseLayer_Mosaic", getClass().getName() + " onDestroy.");
    }

    protected abstract void j(Canvas canvas);

    protected abstract boolean k(MotionEvent motionEvent);

    public void l() {
        c.a("BaseLayer_Mosaic", getClass().getName() + " onPause.");
        this.f441197j = false;
    }

    public void m() {
        c.a("BaseLayer_Mosaic", getClass().getName() + " onResume.");
        this.f441197j = true;
    }

    public void n(Matrix matrix) {
        this.f441200m.set(matrix);
    }

    public void o(float f16) {
        this.f441199l = f16;
    }

    public void p(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            c.a("BaseLayer_Mosaic", "layer size,width=" + i3 + ",height=" + i16);
            Rect rect = this.f441191d;
            rect.left = 0;
            rect.right = i3;
            rect.top = 0;
            rect.bottom = i16;
            this.f441195h = 0;
            this.f441196i = i3;
            this.f441193f = 0;
            this.f441194g = i16;
            return;
        }
        throw new IllegalArgumentException("illegal width or height, width=" + i3 + ",height=" + i16);
    }
}
