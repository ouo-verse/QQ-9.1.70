package s;

import java.io.File;
import s.a;

/* compiled from: P */
/* loaded from: classes.dex */
public class d implements a.InterfaceC11197a {

    /* renamed from: a, reason: collision with root package name */
    private final long f433020a;

    /* renamed from: b, reason: collision with root package name */
    private final a f433021b;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j3) {
        this.f433020a = j3;
        this.f433021b = aVar;
    }

    @Override // s.a.InterfaceC11197a
    public s.a build() {
        File a16 = this.f433021b.a();
        if (a16 == null) {
            return null;
        }
        if (!a16.isDirectory() && !a16.mkdirs()) {
            return null;
        }
        return e.c(a16, this.f433020a);
    }
}
