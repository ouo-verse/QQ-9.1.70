package tf0;

import android.view.MotionEvent;
import com.tencent.crossengine.CEApplication;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private CEApplication f436082a;

    /* renamed from: b, reason: collision with root package name */
    float f436083b = -1.0f;

    /* renamed from: c, reason: collision with root package name */
    float f436084c = -1.0f;

    public d(CEApplication cEApplication) {
        this.f436082a = cEApplication;
    }

    public boolean a(MotionEvent motionEvent) {
        float width = this.f436082a.getWidth() / this.f436082a.getScale();
        float height = this.f436082a.getHeight() / this.f436082a.getScale();
        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
            int action = motionEvent.getAction();
            float x16 = motionEvent.getX(i3) / this.f436082a.getScale();
            float y16 = motionEvent.getY(i3) / this.f436082a.getScale();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        this.f436082a.dispatchTouchEvent(action, 1, (x16 - this.f436083b) / width, (y16 - this.f436084c) / height);
                        this.f436083b = x16;
                        this.f436084c = y16;
                    } else if (action != 3) {
                    }
                }
                this.f436082a.dispatchTouchEvent(action, 1, 0.0f, 0.0f);
            } else {
                this.f436083b = x16;
                this.f436084c = y16;
                this.f436082a.dispatchTouchEvent(action, 1, x16, y16);
            }
        }
        return true;
    }
}
