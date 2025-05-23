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
public final class f extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f440940d;

    /* renamed from: e, reason: collision with root package name */
    public long f440941e;

    public f() {
        this(0, 0L, 3, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new f(0, 0L, 3, null));
    }

    public /* synthetic */ f(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0L);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f440940d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f440941e), new b.e.i(false))));
        return mapOf;
    }

    public f(int i3, long j3) {
        this.f440940d = i3;
        this.f440941e = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440940d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f440941e = ((Long) obj).longValue();
        }
    }
}
