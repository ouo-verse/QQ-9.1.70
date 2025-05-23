package rk4;

import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements rh2.a {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<rh2.a> f431652d;

    public a(rh2.a aVar) {
        this.f431652d = new WeakReference<>(aVar);
    }

    @Override // rh2.a
    public void h(long j3, long j16, long j17, int i3) {
        rh2.a aVar = this.f431652d.get();
        if (aVar != null) {
            aVar.h(j3, j16, j17, i3);
        }
    }

    @Override // qh2.d
    public void onFailed(int i3, String str) {
        rh2.a aVar = this.f431652d.get();
        if (aVar != null) {
            aVar.onFailed(i3, str);
        }
    }
}
