package x25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f447119d;

    /* renamed from: e, reason: collision with root package name */
    public String f447120e;

    /* renamed from: f, reason: collision with root package name */
    public long f447121f;

    public n() {
        this(0L, null, 0L, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new n(0L, null, 0L, 7, null));
    }

    public /* synthetic */ n(long j3, String str, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f447119d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f447120e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f447121f), new b.e.f(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f447119d = ((Long) obj).longValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447120e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f447121f = ((Long) obj).longValue();
        }
    }

    public n(long j3, String str, long j16) {
        this.f447119d = j3;
        this.f447120e = str;
        this.f447121f = j16;
    }
}
