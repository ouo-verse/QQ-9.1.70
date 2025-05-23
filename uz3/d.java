package uz3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* renamed from: f, reason: collision with root package name */
    private static volatile Bitmap f440672f;

    /* renamed from: h, reason: collision with root package name */
    private static volatile Bitmap f440674h;

    /* renamed from: a, reason: collision with root package name */
    private final com.tencent.rfw.barrage.core.f f440675a;

    /* renamed from: b, reason: collision with root package name */
    private volatile Paint f440676b = new Paint();

    /* renamed from: c, reason: collision with root package name */
    private boolean f440677c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile Paint f440670d = new Paint();

    /* renamed from: e, reason: collision with root package name */
    private static volatile Matrix f440671e = new Matrix();

    /* renamed from: g, reason: collision with root package name */
    private static volatile Matrix f440673g = new Matrix();

    public d(com.tencent.rfw.barrage.core.f fVar, boolean z16) {
        this.f440675a = fVar;
        this.f440677c = z16;
    }

    private boolean b(Canvas canvas, com.tencent.rfw.barrage.data.a aVar, tz3.i iVar) {
        com.tencent.rfw.barrage.core.f fVar = this.f440675a;
        if (fVar == null) {
            return false;
        }
        f440674h = fVar.b(aVar, iVar);
        if (f440674h == null || f440674h.isRecycled()) {
            return false;
        }
        int save = canvas.save();
        f440673g.setTranslate(aVar.t(), aVar.I());
        synchronized (f440674h) {
            if (f440674h != null && !f440674h.isRecycled()) {
                canvas.drawBitmap(f440674h, f440673g, this.f440676b);
                canvas.restoreToCount(save);
            }
        }
        return true;
    }

    private void c(Canvas canvas, com.tencent.rfw.barrage.data.a aVar, tz3.i iVar, f fVar) {
        if (fVar == null) {
            return;
        }
        int save = canvas.save();
        fVar.c(canvas, aVar, iVar, aVar.i(), aVar.j());
        canvas.restoreToCount(save);
    }

    private boolean d(Canvas canvas, com.tencent.rfw.barrage.data.a aVar, tz3.i iVar) {
        com.tencent.rfw.barrage.core.f fVar = this.f440675a;
        if (fVar == null) {
            return false;
        }
        f440672f = fVar.b(aVar, iVar);
        if (f440672f == null || f440672f.isRecycled()) {
            return false;
        }
        int save = canvas.save();
        f440671e.setTranslate(aVar.t(), aVar.I());
        synchronized (f440672f) {
            if (f440672f != null && !f440672f.isRecycled()) {
                canvas.drawBitmap(f440672f, f440671e, f440670d);
                canvas.restoreToCount(save);
            }
        }
        return true;
    }

    public void a(Canvas canvas, com.tencent.rfw.barrage.data.a aVar, tz3.i iVar, f fVar) {
        boolean b16;
        if (canvas == null || aVar == null) {
            return;
        }
        if (aVar.Q()) {
            if (this.f440677c) {
                b16 = d(canvas, aVar, iVar);
            } else {
                b16 = b(canvas, aVar, iVar);
            }
            if (b16) {
                return;
            } else {
                tz3.k.w(false);
            }
        }
        c(canvas, aVar, iVar, fVar);
    }
}
