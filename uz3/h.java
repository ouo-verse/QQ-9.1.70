package uz3;

import android.graphics.Canvas;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;
import uz3.b;

/* compiled from: P */
/* loaded from: classes25.dex */
public class h implements b, SurfaceHolder.Callback {
    private volatile Object C;
    private volatile boolean D = false;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceView f440680d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceHolder f440681e;

    /* renamed from: f, reason: collision with root package name */
    private b.a f440682f;

    /* renamed from: h, reason: collision with root package name */
    private volatile ReentrantLock f440683h;

    /* renamed from: i, reason: collision with root package name */
    private volatile Object f440684i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f440685m;

    public h(SurfaceView surfaceView) {
        this.f440680d = surfaceView;
        surfaceView.setWillNotCacheDrawing(true);
        this.f440680d.setDrawingCacheEnabled(false);
        this.f440680d.setWillNotDraw(true);
        this.f440680d.setZOrderMediaOverlay(true);
        SurfaceHolder holder = this.f440680d.getHolder();
        this.f440681e = holder;
        holder.addCallback(this);
        this.f440681e.setFormat(-2);
    }

    private void c() {
        this.f440684i = d(SurfaceView.class, "mDrawingStopped", this.f440680d);
        this.C = d(SurfaceView.class, "mWindow", this.f440680d);
        if (this.f440684i instanceof Boolean) {
            this.f440685m = ((Boolean) this.f440684i).booleanValue();
        }
    }

    private Object d(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private void e() {
        Object d16 = d(SurfaceView.class, "mSurfaceLock", this.f440680d);
        if (d16 instanceof ReentrantLock) {
            this.f440683h = (ReentrantLock) d16;
        }
    }

    private void f() {
        e();
        c();
    }

    private boolean g() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    private boolean h() {
        if (tz3.j.b() && ((Build.VERSION.SDK_INT == 23 && i()) || g())) {
            return true;
        }
        return false;
    }

    private boolean i() {
        f();
        if (this.f440683h != null && this.f440684i != null && this.C != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0036 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Canvas j() {
        Canvas canvas;
        Canvas lockHardwareCanvas;
        if (g()) {
            lockHardwareCanvas = this.f440681e.lockHardwareCanvas();
            return lockHardwareCanvas;
        }
        this.f440683h.lock();
        c();
        if (!this.f440685m && this.C != null) {
            try {
                canvas = this.f440681e.getSurface().lockHardwareCanvas();
            } catch (Exception e16) {
                wz3.b.d("SurfaceDanmakuView", "Exception locking surface", e16);
            }
            if (canvas == null) {
                return canvas;
            }
            this.f440683h.unlock();
            return null;
        }
        canvas = null;
        if (canvas == null) {
        }
    }

    private void k(Canvas canvas) {
        if (g()) {
            this.f440681e.unlockCanvasAndPost(canvas);
            return;
        }
        this.f440681e.getSurface().unlockCanvasAndPost(canvas);
        if (this.f440683h != null) {
            this.f440683h.unlock();
        }
    }

    @Override // uz3.b
    public float a() {
        return this.f440680d.getY();
    }

    @Override // uz3.b
    public void b(b.a aVar) {
        this.f440682f = aVar;
    }

    @Override // uz3.b
    public Canvas lockCanvas() {
        if (this.D) {
            return j();
        }
        return this.f440681e.lockCanvas();
    }

    @Override // uz3.b
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.f440680d.setOnTouchListener(onTouchListener);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        b.a aVar = this.f440682f;
        if (aVar != null) {
            aVar.a();
        }
        wz3.b.f("SurfaceDanmakuView", "surfaceChanged, width = " + i16 + ", height = " + i17);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        b.a aVar = this.f440682f;
        if (aVar != null) {
            aVar.c();
        }
        this.D = h();
        wz3.b.f("SurfaceDanmakuView", "surfaceCreated, isHardwareAccelerateEnable = " + this.D);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        b.a aVar = this.f440682f;
        if (aVar != null) {
            aVar.b();
        }
        wz3.b.f("SurfaceDanmakuView", "surfaceDestroyed");
    }

    @Override // uz3.b
    public void unlock() {
        ReentrantLock reentrantLock = (ReentrantLock) d(SurfaceView.class, "mSurfaceLock", this.f440680d);
        Surface surface = this.f440680d.getHolder().getSurface();
        try {
            try {
                Method declaredMethod = Surface.class.getDeclaredMethod("nativeRelease", Long.TYPE);
                declaredMethod.setAccessible(true);
                Field declaredField = Surface.class.getDeclaredField("mLockedObject");
                declaredField.setAccessible(true);
                Long l3 = (Long) declaredField.get(surface);
                wz3.b.f("SurfaceDanmakuView", "SurfaceBarrageView unlock lockObjectValue = " + l3);
                if (l3.longValue() != 0) {
                    declaredMethod.invoke(null, l3);
                }
                declaredField.setLong(surface, 0L);
                wz3.b.a("SurfaceDanmakuView", "SurfaceBarrageView unlock: release success");
                wz3.b.f("SurfaceDanmakuView", "SurfaceBarrageView unlock surfaceLock = " + reentrantLock);
                if (reentrantLock == null || !reentrantLock.isLocked()) {
                    return;
                }
            } catch (Exception e16) {
                wz3.b.d("SurfaceDanmakuView", "SurfaceBarrageView unlock:release failed", e16);
                wz3.b.f("SurfaceDanmakuView", "SurfaceBarrageView unlock surfaceLock = " + reentrantLock);
                if (reentrantLock == null || !reentrantLock.isLocked()) {
                    return;
                }
            }
            wz3.b.f("SurfaceDanmakuView", "SurfaceBarrageView unlock");
            reentrantLock.unlock();
        } catch (Throwable th5) {
            wz3.b.f("SurfaceDanmakuView", "SurfaceBarrageView unlock surfaceLock = " + reentrantLock);
            if (reentrantLock != null && reentrantLock.isLocked()) {
                wz3.b.f("SurfaceDanmakuView", "SurfaceBarrageView unlock");
                reentrantLock.unlock();
            }
            throw th5;
        }
    }

    @Override // uz3.b
    public void unlockCanvasAndPost(Canvas canvas) {
        if (this.D) {
            k(canvas);
        } else {
            this.f440681e.unlockCanvasAndPost(canvas);
        }
    }

    @Override // uz3.b
    public void destroy() {
    }
}
