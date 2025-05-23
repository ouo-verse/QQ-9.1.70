package w35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f444546d;

    /* renamed from: e, reason: collision with root package name */
    public String f444547e;

    public /* synthetic */ c() {
        this("", "");
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c());
    }

    public c(String str, String str2) {
        this.f444546d = str;
        this.f444547e = str2;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f444546d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f444547e, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f444546d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f444547e = (String) obj;
        }
    }
}
