package yk;

import android.content.Intent;
import com.qzone.reborn.configx.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final xk.a f450540a;

    /* renamed from: b, reason: collision with root package name */
    public final String f450541b = getClass().getSimpleName();

    public a(xk.a aVar) {
        this.f450540a = aVar;
    }

    public boolean a(Intent intent) {
        if (g.f53821a.b().d0()) {
            if (d(intent)) {
                j(intent);
                if (!c(intent)) {
                    return true;
                }
            }
            if (b(intent)) {
                g(intent);
                return true;
            }
        } else {
            if (b(intent)) {
                h(intent);
                return true;
            }
            if (d(intent)) {
                j(intent);
            }
        }
        if (f(intent)) {
            i(intent);
            return true;
        }
        if (!e(intent)) {
            return false;
        }
        xk.a aVar = this.f450540a;
        if (aVar != null) {
            aVar.b();
        }
        return true;
    }

    abstract boolean b(Intent intent);

    protected abstract boolean c(Intent intent);

    abstract boolean d(Intent intent);

    abstract boolean e(Intent intent);

    abstract boolean f(Intent intent);

    protected abstract void g(Intent intent);

    protected abstract void h(Intent intent);

    protected abstract void i(Intent intent);

    protected abstract void j(Intent intent);
}
