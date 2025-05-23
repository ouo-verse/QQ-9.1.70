package z4;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    private float f451869a;

    public b(float f16) {
        this.f451869a = f16;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.f451869a);
    }
}
