package v33;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends a {
    public b(SurfaceHolder surfaceHolder) {
        super(surfaceHolder);
    }

    @Override // s33.b
    public boolean a() {
        return false;
    }

    @Override // v33.a
    Canvas d(SurfaceHolder surfaceHolder) {
        return surfaceHolder.lockCanvas();
    }
}
