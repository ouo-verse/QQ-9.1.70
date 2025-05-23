package u63;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import com.tencent.widget.ScaleGestureDetector;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends v63.a {

    /* renamed from: n, reason: collision with root package name */
    public int f438499n;

    /* renamed from: o, reason: collision with root package name */
    private Matrix f438500o;

    /* renamed from: p, reason: collision with root package name */
    private float[] f438501p;

    /* renamed from: q, reason: collision with root package name */
    private ScaleGestureDetector f438502q;

    /* renamed from: r, reason: collision with root package name */
    private int f438503r;

    /* renamed from: s, reason: collision with root package name */
    private int f438504s;

    private boolean q(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f438503r = motionEvent.getPointerId(0);
        }
        if (this.f438503r != motionEvent.getPointerId(motionEvent.getActionIndex())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.f438501p[0] = motionEvent.getX();
        this.f438501p[1] = motionEvent.getY();
        this.f438500o.mapPoints(this.f438501p);
        float[] fArr = this.f438501p;
        obtain.setLocation(fArr[0], fArr[1]);
        if (actionMasked == 6 && this.f438503r == motionEvent.getPointerId(motionEvent.getActionIndex())) {
            obtain.setAction(1);
        }
        boolean t16 = t(obtain);
        obtain.recycle();
        return t16;
    }

    private boolean r(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector = this.f438502q;
        if (scaleGestureDetector != null) {
            return scaleGestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    private boolean t(MotionEvent motionEvent) {
        if (this.f438499n != 4) {
            return false;
        }
        throw null;
    }

    @Override // v63.b
    public boolean a(MotionEvent motionEvent) {
        return false;
    }

    @Override // v63.b
    public void clear() {
        throw null;
    }

    @Override // v63.a
    public int d() {
        return -100;
    }

    @Override // v63.a
    public boolean g(long j3) {
        return true;
    }

    @Override // v63.a
    public void i() {
        super.i();
    }

    @Override // v63.a
    protected void j(Canvas canvas) {
        canvas.save();
        canvas.concat(this.f441200m);
        canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        throw null;
    }

    @Override // v63.a
    public boolean k(MotionEvent motionEvent) {
        boolean z16;
        if (this.f441189b == null) {
            return q(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z17 = false;
        if (actionMasked == 0) {
            this.f438504s = 1;
            boolean q16 = q(motionEvent);
            boolean r16 = r(motionEvent);
            if (!q16 && !r16) {
                return false;
            }
            return true;
        }
        if (this.f438504s == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            if (motionEvent.getEventTime() - motionEvent.getDownTime() <= 100) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (actionMasked == 5 && z16) {
                ms.a.f("LineLayer_mosaic", "recognize this gesture as SCALE");
                this.f438504s = 3;
                q(obtain);
            } else if (!z16) {
                ms.a.f("LineLayer_mosaic", "recognize this gesture as DRAW");
                this.f438504s = 2;
                r(obtain);
            }
            obtain.recycle();
        }
        int i3 = this.f438504s;
        if (i3 == 3) {
            z17 = r(motionEvent);
        } else if (i3 == 2) {
            z17 = q(motionEvent);
        } else if (i3 == 1) {
            boolean q17 = q(motionEvent);
            boolean r17 = r(motionEvent);
            if (q17 || r17) {
                z17 = true;
            }
        }
        if (actionMasked == 1) {
            this.f438504s = 1;
        }
        return z17;
    }

    @Override // v63.a
    public void n(Matrix matrix) {
        super.n(matrix);
        this.f441200m.invert(this.f438500o);
    }

    @Override // v63.a
    public void p(int i3, int i16) {
        super.p(i3, i16);
        throw null;
    }

    public w63.a s(int i3) {
        throw null;
    }
}
