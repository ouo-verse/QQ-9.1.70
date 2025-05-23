package z25;

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
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f451825d;

    /* renamed from: e, reason: collision with root package name */
    public long f451826e;

    /* renamed from: f, reason: collision with root package name */
    public long f451827f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f451828h;

    public c() {
        this(0L, 0L, 0L, null, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(0L, 0L, 0L, null, 15, null));
    }

    public /* synthetic */ c(long j3, long j16, long j17, c45.a aVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0L, 0L, c45.a.f30290b);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f451825d), new b.e.i(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f451826e), new b.e.i(false))), TuplesKt.to(3, new h(3, Long.valueOf(this.f451827f), new b.e.i(false))), TuplesKt.to(4, new h(4, this.f451828h, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f451825d = ((Long) obj).longValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f451826e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f451827f = ((Long) obj).longValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f451828h = (c45.a) obj;
        }
    }

    public c(long j3, long j16, long j17, c45.a aVar) {
        this.f451825d = j3;
        this.f451826e = j16;
        this.f451827f = j17;
        this.f451828h = aVar;
    }
}
