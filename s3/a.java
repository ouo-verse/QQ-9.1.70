package s3;

import android.graphics.PointF;
import android.view.View;
import r3.j;
import t3.d;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements j {

    /* renamed from: a, reason: collision with root package name */
    public PointF f433150a;

    /* renamed from: b, reason: collision with root package name */
    public j f433151b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f433152c = true;

    @Override // r3.j
    public boolean canLoadMore(View view) {
        j jVar = this.f433151b;
        if (jVar != null) {
            return jVar.canLoadMore(view);
        }
        return d.a(view, this.f433150a, this.f433152c);
    }

    @Override // r3.j
    public boolean canRefresh(View view) {
        j jVar = this.f433151b;
        if (jVar != null) {
            return jVar.canRefresh(view);
        }
        return d.b(view, this.f433150a);
    }
}
