package x35;

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
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f447162d;

    /* renamed from: e, reason: collision with root package name */
    public String f447163e;

    public a(String str, String str2) {
        this.f447162d = str;
        this.f447163e = str2;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, null));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f447162d, new b.e.g(true))), TuplesKt.to(2, new h(2, this.f447163e, new b.e.g(true))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447162d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447163e = (String) obj;
        }
    }
}
