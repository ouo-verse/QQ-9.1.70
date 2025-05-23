package tr;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a implements d {
    protected int C;
    protected int D;
    protected int E;
    protected boolean F;
    protected float H;
    protected InterfaceC11305a I;

    /* renamed from: d, reason: collision with root package name */
    public Context f437142d;

    /* renamed from: e, reason: collision with root package name */
    protected DoodleView f437143e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f437144f;

    /* renamed from: h, reason: collision with root package name */
    public Rect f437145h;

    /* renamed from: i, reason: collision with root package name */
    protected Paint f437146i;

    /* renamed from: m, reason: collision with root package name */
    protected int f437147m;
    protected int G = 0;
    protected Matrix J = new Matrix();

    /* compiled from: P */
    /* renamed from: tr.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11305a<T extends a> {
        boolean a(T t16, MotionEvent motionEvent);
    }

    public a(DoodleView doodleView) {
        if (doodleView != null) {
            this.f437142d = doodleView.getContext();
            this.f437143e = doodleView;
            l();
            return;
        }
        throw new IllegalStateException("DoodleView can not be null.");
    }

    private void l() {
        this.f437145h = new Rect();
        Paint paint = new Paint();
        this.f437144f = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f437146i = paint2;
        paint2.setAntiAlias(true);
        this.f437146i.setStyle(Paint.Style.STROKE);
        this.f437146i.setStrokeWidth(5.0f);
        this.f437146i.setColor(-16776961);
        this.F = false;
    }

    public void A(int i3, int i16) {
        if (i3 > 0 && i16 > 0) {
            hd0.c.a("BaseLayer", "layer size,width=" + i3 + ",height=" + i16);
            Rect rect = this.f437145h;
            rect.left = 0;
            rect.right = i3;
            rect.top = 0;
            rect.bottom = i16;
            this.D = 0;
            this.E = i3;
            this.f437147m = 0;
            this.C = i16;
            return;
        }
        throw new IllegalArgumentException("illegal width or height, width=" + i3 + ",height=" + i16);
    }

    public void B() {
        this.f437143e.setTopLevelLayer(this);
    }

    public final boolean c(MotionEvent motionEvent) {
        InterfaceC11305a interfaceC11305a = this.I;
        if (interfaceC11305a != null) {
            interfaceC11305a.a(this, motionEvent);
        }
        n();
        return q(motionEvent);
    }

    public final void d(Canvas canvas) {
        p(canvas);
    }

    public Matrix e() {
        return this.J;
    }

    public int f() {
        return this.f437145h.height();
    }

    public float g() {
        return this.H;
    }

    public abstract String h();

    public int i() {
        return this.G;
    }

    public int j() {
        return this.f437145h.width();
    }

    public abstract boolean m(long j3);

    public void n() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f437143e.invalidate();
        } else {
            this.f437143e.postInvalidate();
        }
    }

    public void o() {
        hd0.c.a("BaseLayer", getClass().getName() + " onDestroy.");
    }

    protected abstract void p(Canvas canvas);

    protected abstract boolean q(MotionEvent motionEvent);

    public void r() {
        hd0.c.a("BaseLayer", getClass().getName() + " onPause.");
        this.F = false;
    }

    public void s() {
        hd0.c.a("BaseLayer", getClass().getName() + " onResume.");
        this.F = true;
    }

    public void v(Canvas canvas, float f16) {
        b(canvas);
    }

    public void w(Canvas canvas, float f16, boolean z16) {
        v(canvas, f16);
    }

    public void x(Matrix matrix) {
        this.J.set(matrix);
    }

    public void y(InterfaceC11305a interfaceC11305a) {
        this.I = interfaceC11305a;
    }

    public void z(float f16) {
        this.H = f16;
    }

    public void k(int i3) {
        this.G = i3 + 1;
    }

    public void t(boolean z16) {
        if (z16) {
            this.f437143e.setActiveLayer(this);
        } else {
            this.f437143e.j(this);
        }
        n();
    }

    public void u(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.G = bundle.getInt("BaseLayer:TopLevelWeight");
    }
}
