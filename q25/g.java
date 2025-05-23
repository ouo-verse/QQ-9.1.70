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
public final class g extends j {
    public c45.a C;
    public String D;
    public String E;
    public String F;

    /* renamed from: d, reason: collision with root package name */
    public int f428257d;

    /* renamed from: e, reason: collision with root package name */
    public int f428258e;

    /* renamed from: f, reason: collision with root package name */
    public String f428259f;

    /* renamed from: h, reason: collision with root package name */
    public String f428260h;

    /* renamed from: i, reason: collision with root package name */
    public String f428261i;

    /* renamed from: m, reason: collision with root package name */
    public String f428262m;

    public g() {
        this(0, 0, null, null, null, null, null, null, null, null, 1023, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new g(0, 0, null, null, null, null, null, null, null, null, 1023, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f428257d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f428258e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f428259f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f428260h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f428261i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f428262m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.C = (c45.a) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.D = (String) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.E = (String) obj;
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.F = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g(int i3, int i16, String str, String str2, String str3, String str4, c45.a aVar, String str5, String str6, String str7, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, "", "", "", "", c45.a.f30290b, "", "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f428257d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f428258e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f428259f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f428260h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f428261i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f428262m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, this.C, new b.e.C0167b(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.e.g(false))), TuplesKt.to(9, new c45.h(9, this.E, new b.e.g(false))), TuplesKt.to(10, new c45.h(10, this.F, new b.e.g(false))));
        return mapOf;
    }

    public g(int i3, int i16, String str, String str2, String str3, String str4, c45.a aVar, String str5, String str6, String str7) {
        this.f428257d = i3;
        this.f428258e = i16;
        this.f428259f = str;
        this.f428260h = str2;
        this.f428261i = str3;
        this.f428262m = str4;
        this.C = aVar;
        this.D = str5;
        this.E = str6;
        this.F = str7;
    }
}
