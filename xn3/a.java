package xn3;

import on3.b;
import on3.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f448204a;

    /* renamed from: b, reason: collision with root package name */
    private final long f448205b;

    public a(b bVar, long j3) {
        this.f448204a = bVar;
        this.f448205b = j3;
    }

    public long a(long j3) {
        b bVar = this.f448204a;
        if (bVar == null) {
            return 0L;
        }
        bVar.a();
        c a16 = on3.a.a(null);
        if (a16 == null) {
            return 0L;
        }
        return a16.h();
    }

    public boolean b(long j3, long j16) {
        b bVar = this.f448204a;
        if (bVar == null) {
            return false;
        }
        bVar.a();
        c a16 = on3.a.a(null);
        if (a16 == null || a16.h() != j16) {
            return false;
        }
        return true;
    }

    public boolean c() {
        b bVar = this.f448204a;
        if (bVar == null) {
            return false;
        }
        bVar.a();
        on3.a.a(null).getUser();
        return false;
    }
}
