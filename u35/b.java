package u35;

import c45.b;
import c45.f;
import c45.h;
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
    public int f438201d;

    /* renamed from: e, reason: collision with root package name */
    public String f438202e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f438203f;

    public b() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0, null, null, 7, null));
    }

    public /* synthetic */ b(int i3, String str, c45.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f438201d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, this.f438202e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f438203f, new b.e.C0167b(false))));
        return mapOf;
    }

    public b(int i3, String str, c45.a aVar) {
        this.f438201d = i3;
        this.f438202e = str;
        this.f438203f = aVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f438201d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f438202e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f438203f = (c45.a) obj;
        }
    }
}
