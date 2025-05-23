package w21;

import com.tencent.luggage.wxa.eo.g;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.j4.d;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final /* synthetic */ class a {
    static {
        String[] strArr = com.tencent.luggage.wxa.j4.c.f130788r;
    }

    public static d a(com.tencent.luggage.wxa.j4.c cVar, n0 n0Var) {
        if (n0Var != null) {
            d dVar = new d();
            dVar.G = n0Var.f138465d;
            dVar.f125808a = n0Var.f138467f;
            dVar.f125809b = n0Var.f138469h;
            dVar.f125810c = n0Var.f138479r;
            if (n0Var.f() != null) {
                dVar.I = n0Var.f().f125867e;
                dVar.J = n0Var.f().b();
                dVar.f125814g = n0Var.f().f125877o;
                dVar.f125816i = n0Var.f().f125879q;
                dVar.f125815h = n0Var.f().f125878p;
                dVar.f125817j = n0Var.f().f125882t;
                dVar.B0 = (ArrayList) com.tencent.luggage.wxa.h6.c.a(new ArrayList(), n0Var.f().f125875m);
                dVar.C0 = n0Var.f().f125887y;
            } else {
                w.b("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", n0Var.f138465d, n0Var.f138467f);
            }
            if (n0Var.h() != null) {
                dVar.W = n0Var.h().f125922c;
                dVar.V = n0Var.h().f125920a;
                dVar.X = n0Var.h();
            } else {
                w.b("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", n0Var.f138465d, n0Var.f138467f);
            }
            dVar.Y = n0Var.D;
            dVar.Z = n0Var.F;
            if (n0Var.g() != null && n0Var.g().f125894a != null) {
                dVar.f130789a0 = n0Var.g().f125894a.clone();
                return dVar;
            }
            return dVar;
        }
        return null;
    }

    public static com.tencent.luggage.wxa.j4.c b() {
        com.tencent.luggage.wxa.j4.c cVar;
        com.tencent.luggage.wxa.j4.c cVar2 = (com.tencent.luggage.wxa.j4.c) g.a(com.tencent.luggage.wxa.j4.c.class);
        if (cVar2 == null) {
            cVar = com.tencent.luggage.wxa.j4.b.f130787a;
            return cVar;
        }
        return cVar2;
    }
}
