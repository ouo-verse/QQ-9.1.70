package uo0;

import androidx.annotation.NonNull;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import uo0.p;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends p {
    public b(p.b bVar) {
        super(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object t(String str, String str2, boolean z16, AppRuntime appRuntime) {
        d dVar = new d(appRuntime, str, str2);
        if (z16) {
            r(dVar);
            return null;
        }
        q(dVar);
        return null;
    }

    @Override // uo0.p
    protected void m(k kVar) {
        if (!this.f439365c && !kVar.j()) {
            this.f439366d.e(kVar, kVar.h(), kVar.i(), kVar.g());
        }
    }

    public void u(@NonNull final String str, @NonNull final String str2, final boolean z16) {
        n("ChannelSearchSession.searchVisibleChannel", new Function1() { // from class: uo0.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object t16;
                t16 = b.this.t(str, str2, z16, (AppRuntime) obj);
                return t16;
            }
        });
    }
}
