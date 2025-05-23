package u63;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.mobileqq.wink.editor.mosaic.ui.DoodleView;
import hd0.c;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class a extends v63.a {

    /* renamed from: n, reason: collision with root package name */
    public static final String f438498n = "a";

    public a(DoodleView doodleView) {
        super(doodleView);
    }

    @Override // v63.b
    public boolean a(MotionEvent motionEvent) {
        c.a(f438498n, "EmptyLayer handle touch event.");
        return false;
    }

    @Override // v63.a
    public boolean g(long j3) {
        return true;
    }

    @Override // v63.a
    public boolean k(MotionEvent motionEvent) {
        return false;
    }

    @Override // v63.b
    public void clear() {
    }

    @Override // v63.a
    protected void j(Canvas canvas) {
    }
}
