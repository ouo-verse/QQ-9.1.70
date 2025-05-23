package uz3;

import android.graphics.Canvas;
import com.tencent.rfw.barrage.data.a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class f<D extends com.tencent.rfw.barrage.data.a> {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f440678a;

    private void d(Canvas canvas, D d16, tz3.i iVar, float f16, float f17) {
        ArrayList<a> arrayList = this.f440678a;
        if (arrayList != null) {
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a(canvas, d16, iVar, f16, f17);
            }
        }
    }

    public abstract boolean a(com.tencent.rfw.barrage.data.a aVar);

    public final void c(Canvas canvas, D d16, tz3.i iVar, float f16, float f17) {
        f(canvas, d16, iVar, f16, f17);
        d(canvas, d16, iVar, f16, f17);
    }

    public abstract wz3.a e(D d16);

    public abstract void f(Canvas canvas, D d16, tz3.i iVar, float f16, float f17);

    public void b() {
    }

    public void g(D d16) {
    }
}
