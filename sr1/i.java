package sr1;

import android.view.MotionEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i extends b {

    /* renamed from: e, reason: collision with root package name */
    private rr1.i f434334e;

    /* renamed from: f, reason: collision with root package name */
    private Set<rr1.a> f434335f;

    public i(h hVar) {
        super(hVar);
        this.f434334e = null;
        this.f434335f = new LinkedHashSet();
        this.f434334e = new rr1.i();
    }

    private void h(rr1.i iVar) {
        if (iVar.f() == 1) {
            QLog.i("Guild.MF.Gesture.NotifyComponent", 1, "notifyBeingMoveEvent moveDirection=" + iVar.d());
            com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new yn0.a(iVar.d()));
        }
    }

    public void f(rr1.a aVar) {
        if (aVar != null) {
            this.f434335f.add(aVar);
        }
    }

    public int g() {
        return this.f434334e.f();
    }

    public boolean i(int i3, int i16) {
        for (rr1.a aVar : new LinkedHashSet(this.f434335f)) {
            if (aVar != null && aVar.a(i3, i16)) {
                return true;
            }
        }
        return false;
    }

    public boolean j(MotionEvent motionEvent) {
        for (rr1.a aVar : new LinkedHashSet(this.f434335f)) {
            if (aVar != null && aVar.b(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    public void k() {
        for (rr1.a aVar : new LinkedHashSet(this.f434335f)) {
            if (aVar != null) {
                aVar.c(this.f434334e);
            }
        }
        h(this.f434334e);
    }

    public void l(rr1.a aVar) {
        if (aVar != null) {
            this.f434335f.remove(aVar);
        }
    }

    public i m(int i3) {
        this.f434334e.k(i3);
        return this;
    }

    public i n(int i3) {
        this.f434334e.p(i3);
        return this;
    }

    public i o(float f16) {
        this.f434334e.l(f16);
        return this;
    }

    public i p(int i3) {
        this.f434334e.m(i3);
        return this;
    }

    public i q(int i3) {
        this.f434334e.n(i3);
        return this;
    }

    public i r(int i3) {
        this.f434334e.o(i3);
        return this;
    }

    public i s(int i3) {
        this.f434334e.q(i3);
        return this;
    }
}
