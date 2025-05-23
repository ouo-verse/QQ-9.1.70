package uz3;

import android.graphics.Canvas;
import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface b {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    float a();

    void b(a aVar);

    void destroy();

    Canvas lockCanvas();

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void unlock();

    void unlockCanvasAndPost(Canvas canvas);
}
