package xd1;

import android.text.SpannableStringBuilder;
import yd1.b;
import yd1.c;
import yd1.d;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {

    /* compiled from: P */
    /* renamed from: xd1.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public interface InterfaceC11539a {
        void a(SpannableStringBuilder spannableStringBuilder, yd1.b bVar);

        void b(SpannableStringBuilder spannableStringBuilder, yd1.b bVar);

        void c(SpannableStringBuilder spannableStringBuilder, c.C11605c c11605c);

        void d(SpannableStringBuilder spannableStringBuilder, yd1.b bVar, b.d dVar);

        void e(SpannableStringBuilder spannableStringBuilder, c.b bVar);

        void f(SpannableStringBuilder spannableStringBuilder, yd1.b bVar, b.a aVar);

        void g(SpannableStringBuilder spannableStringBuilder, c.a aVar);
    }

    public SpannableStringBuilder a(d dVar, InterfaceC11539a interfaceC11539a) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (dVar != null && !dVar.a().isEmpty()) {
            if (interfaceC11539a == null) {
                return spannableStringBuilder;
            }
            for (int i3 = 0; i3 < dVar.a().size(); i3++) {
                c cVar = dVar.a().get(i3);
                if (cVar instanceof c.a) {
                    interfaceC11539a.g(spannableStringBuilder, (c.a) cVar);
                } else if (cVar instanceof c.C11605c) {
                    interfaceC11539a.c(spannableStringBuilder, (c.C11605c) cVar);
                } else if (cVar instanceof c.b) {
                    interfaceC11539a.e(spannableStringBuilder, (c.b) cVar);
                } else if (cVar instanceof yd1.b) {
                    yd1.b bVar = (yd1.b) cVar;
                    interfaceC11539a.a(spannableStringBuilder, bVar);
                    for (int i16 = 0; i16 < bVar.f450172c.size(); i16++) {
                        b.c cVar2 = bVar.f450172c.get(i16);
                        if (cVar2 instanceof b.a) {
                            interfaceC11539a.f(spannableStringBuilder, bVar, (b.a) cVar2);
                        } else if (cVar2 instanceof b.d) {
                            interfaceC11539a.d(spannableStringBuilder, bVar, (b.d) cVar2);
                        }
                    }
                    interfaceC11539a.b(spannableStringBuilder, bVar);
                }
            }
        }
        return spannableStringBuilder;
    }
}
