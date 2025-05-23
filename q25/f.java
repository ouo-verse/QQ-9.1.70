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
public final class f extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f428251d;

    /* renamed from: e, reason: collision with root package name */
    public d f428252e;

    /* renamed from: f, reason: collision with root package name */
    public e f428253f;

    /* renamed from: h, reason: collision with root package name */
    public o25.h f428254h;

    /* renamed from: i, reason: collision with root package name */
    public h f428255i;

    /* renamed from: m, reason: collision with root package name */
    public b f428256m;

    public f() {
        this(0, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new f(0, null, null, null, null, null, 63, null));
    }

    public /* synthetic */ f(int i3, d dVar, e eVar, o25.h hVar, h hVar2, b bVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, null, null, null, null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 0;
        int i16 = 3;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f428251d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f428252e, new b.d(new d(null, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(3, new c45.h(3, this.f428253f, new b.d(new e(0 == true ? 1 : 0, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(4, new c45.h(4, this.f428254h, new b.d(new o25.h(i3, i3, i16, 0 == true ? 1 : 0)))), TuplesKt.to(7, new c45.h(7, this.f428255i, new b.d(new h(0 == true ? 1 : 0, 0 == true ? 1 : 0, i16, 0 == true ? 1 : 0)))), TuplesKt.to(8, new c45.h(8, this.f428256m, new b.d(new b(null, null, 0 == true ? 1 : 0, 7, null)))));
        return mapOf;
    }

    public f(int i3, d dVar, e eVar, o25.h hVar, h hVar2, b bVar) {
        this.f428251d = i3;
        this.f428252e = dVar;
        this.f428253f = eVar;
        this.f428254h = hVar;
        this.f428255i = hVar2;
        this.f428256m = bVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f428251d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.FilamentResource");
            this.f428252e = (d) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.MotionDpi");
            this.f428253f = (e) obj;
            return;
        }
        if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.PixelCoordinate");
            this.f428254h = (o25.h) obj;
        } else if (i3 == 7) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.UserDressKey");
            this.f428255i = (h) obj;
        } else {
            if (i3 != 8) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.FilamentCoverResource");
            this.f428256m = (b) obj;
        }
    }
}
