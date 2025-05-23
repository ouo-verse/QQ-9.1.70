package rz3;

import com.tencent.rfw.barrage.core.d;
import com.tencent.rfw.barrage.data.a;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements a.b {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<d> f433010a;

    public a(d dVar) {
        this.f433010a = new WeakReference<>(dVar);
    }

    @Override // com.tencent.rfw.barrage.data.a.b
    public void a(com.tencent.rfw.barrage.data.a aVar) {
        d dVar;
        WeakReference<d> weakReference = this.f433010a;
        if (weakReference == null) {
            dVar = null;
        } else {
            dVar = weakReference.get();
        }
        if (dVar == null) {
            return;
        }
        dVar.H(aVar);
    }

    @Override // com.tencent.rfw.barrage.data.a.b
    public void b(com.tencent.rfw.barrage.data.a aVar) {
        d dVar;
        WeakReference<d> weakReference = this.f433010a;
        if (weakReference == null) {
            dVar = null;
        } else {
            dVar = weakReference.get();
        }
        if (dVar == null) {
            return;
        }
        dVar.Q(aVar);
    }

    @Override // com.tencent.rfw.barrage.data.a.b
    public void c(com.tencent.rfw.barrage.data.a aVar) {
        d dVar;
        WeakReference<d> weakReference = this.f433010a;
        if (weakReference == null) {
            dVar = null;
        } else {
            dVar = weakReference.get();
        }
        if (dVar == null) {
            return;
        }
        dVar.G(aVar);
    }
}
