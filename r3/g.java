package r3;

import androidx.annotation.NonNull;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g implements r3.f {

    /* renamed from: d, reason: collision with root package name */
    private final CopyOnWriteArrayList<r3.f> f430616d = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.f f430617a;

        a(q3.f fVar) {
            this.f430617a = fVar;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.e(this.f430617a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.f f430619a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RefreshState f430620b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RefreshState f430621c;

        b(q3.f fVar, RefreshState refreshState, RefreshState refreshState2) {
            this.f430619a = fVar;
            this.f430620b = refreshState;
            this.f430621c = refreshState2;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.d(this.f430619a, this.f430620b, this.f430621c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.f f430623a;

        c(q3.f fVar) {
            this.f430623a = fVar;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.E6(this.f430623a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class d implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.d f430625a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f430626b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f430627c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f430628d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f430629e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f430630f;

        d(q3.d dVar, boolean z16, float f16, int i3, int i16, int i17) {
            this.f430625a = dVar;
            this.f430626b = z16;
            this.f430627c = f16;
            this.f430628d = i3;
            this.f430629e = i16;
            this.f430630f = i17;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.B9(this.f430625a, this.f430626b, this.f430627c, this.f430628d, this.f430629e, this.f430630f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class e implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.d f430632a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f430633b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f430634c;

        e(q3.d dVar, int i3, int i16) {
            this.f430632a = dVar;
            this.f430633b = i3;
            this.f430634c = i16;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.Pe(this.f430632a, this.f430633b, this.f430634c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class f implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.d f430636a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f430637b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f430638c;

        f(q3.d dVar, int i3, int i16) {
            this.f430636a = dVar;
            this.f430637b = i3;
            this.f430638c = i16;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.vf(this.f430636a, this.f430637b, this.f430638c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: r3.g$g, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C11110g implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.d f430640a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f430641b;

        C11110g(q3.d dVar, boolean z16) {
            this.f430640a = dVar;
            this.f430641b = z16;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.Tf(this.f430640a, this.f430641b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class h implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.c f430643a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f430644b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f430645c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f430646d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f430647e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f430648f;

        h(q3.c cVar, boolean z16, float f16, int i3, int i16, int i17) {
            this.f430643a = cVar;
            this.f430644b = z16;
            this.f430645c = f16;
            this.f430646d = i3;
            this.f430647e = i16;
            this.f430648f = i17;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.kb(this.f430643a, this.f430644b, this.f430645c, this.f430646d, this.f430647e, this.f430648f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class i implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.c f430650a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f430651b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f430652c;

        i(q3.c cVar, int i3, int i16) {
            this.f430650a = cVar;
            this.f430651b = i3;
            this.f430652c = i16;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.Z7(this.f430650a, this.f430651b, this.f430652c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class j implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.c f430654a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f430655b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f430656c;

        j(q3.c cVar, int i3, int i16) {
            this.f430654a = cVar;
            this.f430655b = i3;
            this.f430656c = i16;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.k6(this.f430654a, this.f430655b, this.f430656c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class k implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q3.c f430658a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f430659b;

        k(q3.c cVar, boolean z16) {
            this.f430658a = cVar;
            this.f430659b = z16;
        }

        @Override // r3.g.l
        public void a(r3.f fVar) {
            fVar.cd(this.f430658a, this.f430659b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface l {
        void a(r3.f fVar);
    }

    private void h(l lVar) {
        Iterator<r3.f> it = this.f430616d.iterator();
        while (it.hasNext()) {
            lVar.a(it.next());
        }
    }

    @Override // r3.f
    public void B9(q3.d dVar, boolean z16, float f16, int i3, int i16, int i17) {
        h(new d(dVar, z16, f16, i3, i16, i17));
    }

    public void E6(@NonNull q3.f fVar) {
        h(new c(fVar));
    }

    @Override // r3.f
    public void Pe(q3.d dVar, int i3, int i16) {
        h(new e(dVar, i3, i16));
    }

    @Override // r3.f
    public void Tf(q3.d dVar, boolean z16) {
        h(new C11110g(dVar, z16));
    }

    @Override // r3.f
    public void Z7(q3.c cVar, int i3, int i16) {
        h(new i(cVar, i3, i16));
    }

    @Override // r3.f
    public void cd(q3.c cVar, boolean z16) {
        h(new k(cVar, z16));
    }

    public void d(@NonNull q3.f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        h(new b(fVar, refreshState, refreshState2));
    }

    @Override // r3.h
    public void e(@NonNull q3.f fVar) {
        h(new a(fVar));
    }

    public void g(r3.f fVar) {
        this.f430616d.addIfAbsent(fVar);
    }

    public void i(r3.f fVar) {
        this.f430616d.remove(fVar);
    }

    @Override // r3.f
    public void k6(q3.c cVar, int i3, int i16) {
        h(new j(cVar, i3, i16));
    }

    @Override // r3.f
    public void kb(q3.c cVar, boolean z16, float f16, int i3, int i16, int i17) {
        h(new h(cVar, z16, f16, i3, i16, i17));
    }

    @Override // r3.f
    public void vf(q3.d dVar, int i3, int i16) {
        h(new f(dVar, i3, i16));
    }
}
