package q25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f428242d;

    /* renamed from: e, reason: collision with root package name */
    public h f428243e;

    /* renamed from: f, reason: collision with root package name */
    public String f428244f;

    public b() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, null, null, 7, null));
    }

    public /* synthetic */ b(String str, h hVar, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", null, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f428242d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f428243e, new b.d(new h(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(3, new c45.h(3, this.f428244f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f428242d = (String) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.UserDressKey");
            this.f428243e = (h) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f428244f = (String) obj;
        }
    }

    public b(String str, h hVar, String str2) {
        this.f428242d = str;
        this.f428243e = hVar;
        this.f428244f = str2;
    }
}
