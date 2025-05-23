package v35;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends j {
    public b C;
    public c D;
    public int E;
    public int F;
    public String G;

    /* renamed from: d, reason: collision with root package name */
    public int f440942d;

    /* renamed from: e, reason: collision with root package name */
    public String f440943e;

    /* renamed from: f, reason: collision with root package name */
    public int f440944f;

    /* renamed from: h, reason: collision with root package name */
    public String f440945h;

    /* renamed from: i, reason: collision with root package name */
    public float f440946i;

    /* renamed from: m, reason: collision with root package name */
    public b f440947m;

    public g() {
        this(0, null, 0, null, 0.0f, null, null, null, 0, 0, null, 2047, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new g(0, null, 0, null, 0.0f, null, null, null, 0, 0, null, 2047, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f440942d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440943e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f440944f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440945h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.f440946i = ((Float) obj).floatValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.Clipper");
                this.f440947m = (b) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.Clipper");
                this.C = (b) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.Event");
                this.D = (c) obj;
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.E = ((Integer) obj).intValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.F = ((Integer) obj).intValue();
                return;
            case 11:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.G = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g(int i3, String str, int i16, String str2, float f16, b bVar, b bVar2, c cVar, int i17, int i18, String str3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", 0, "", 0.0f, null, null, null, 0, 0, "");
    }

    public g(int i3, String str, int i16, String str2, float f16, b bVar, b bVar2, c cVar, int i17, int i18, String str3) {
        this.f440942d = i3;
        this.f440943e = str;
        this.f440944f = i16;
        this.f440945h = str2;
        this.f440946i = f16;
        this.f440947m = bVar;
        this.C = bVar2;
        this.D = cVar;
        this.E = i17;
        this.F = i18;
        this.G = str3;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f440942d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, this.f440943e, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f440944f), new b.e.C0168e(false))), TuplesKt.to(4, new h(4, this.f440945h, new b.e.g(false))), TuplesKt.to(5, new h(5, Float.valueOf(this.f440946i), new b.e.d(false))), TuplesKt.to(6, new h(6, this.f440947m, new b.d(new b(0.0f, 0.0f, 0.0f, 0.0f, 15, null)))), TuplesKt.to(7, new h(7, this.C, new b.d(new b(0.0f, 0.0f, 0.0f, 0.0f, 15, null)))), TuplesKt.to(8, new h(8, this.D, new b.d(new c(0L, null, 3, null)))), TuplesKt.to(9, new h(9, Integer.valueOf(this.E), new b.e.C0168e(false))), TuplesKt.to(10, new h(10, Integer.valueOf(this.F), new b.e.C0168e(false))), TuplesKt.to(11, new h(11, this.G, new b.e.g(false))));
        return mapOf;
    }
}
