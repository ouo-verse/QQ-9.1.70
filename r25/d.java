package r25;

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
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f430606d;

    /* renamed from: e, reason: collision with root package name */
    public int f430607e;

    /* renamed from: f, reason: collision with root package name */
    public int f430608f;

    public d() {
        this(0L, 0, 0, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(0L, 0, 0, 7, null));
    }

    public /* synthetic */ d(long j3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f430606d), new b.e.f(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f430607e), new b.e.h(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f430608f), new b.e.h(false))));
        return mapOf;
    }

    public d(long j3, int i3, int i16) {
        this.f430606d = j3;
        this.f430607e = i3;
        this.f430608f = i16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f430606d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f430607e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f430608f = ((Integer) obj).intValue();
        }
    }
}
