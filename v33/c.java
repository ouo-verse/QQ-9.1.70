package v33;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends a {
    public c(SurfaceHolder surfaceHolder) {
        super(surfaceHolder);
    }

    @Override // s33.b
    public boolean a() {
        return true;
    }

    @Override // v33.a
    Canvas d(SurfaceHolder surfaceHolder) {
        Canvas lockHardwareCanvas;
        lockHardwareCanvas = surfaceHolder.lockHardwareCanvas();
        return lockHardwareCanvas;
    }
}
