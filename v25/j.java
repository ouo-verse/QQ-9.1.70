package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440859d;

    /* renamed from: e, reason: collision with root package name */
    public long f440860e;

    public j(m25.c cVar, long j3) {
        this.f440859d = cVar;
        this.f440860e = j3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(null, 0L));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440859d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Long.valueOf(this.f440860e), new b.e.i(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440859d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f440860e = ((Long) obj).longValue();
        }
    }
}
