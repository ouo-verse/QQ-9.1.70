package q25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f428245d;

    /* renamed from: e, reason: collision with root package name */
    public String f428246e;

    public c(String str, String str2) {
        this.f428245d = str;
        this.f428246e = str2;
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new c("", ""));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f428245d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f428246e, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f428245d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f428246e = (String) obj;
        }
    }
}
