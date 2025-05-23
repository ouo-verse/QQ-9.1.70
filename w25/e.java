package w25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n25.i;
import n25.k;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f444483d;

    /* renamed from: e, reason: collision with root package name */
    public int f444484e;

    /* renamed from: f, reason: collision with root package name */
    public o25.e f444485f;

    /* renamed from: h, reason: collision with root package name */
    public k f444486h;

    public e(m25.c cVar, int i3, o25.e eVar, k kVar) {
        this.f444483d = cVar;
        this.f444484e = i3;
        this.f444485f = eVar;
        this.f444486h = kVar;
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, 0, null, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f444483d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f444484e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f444485f, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(4, new c45.h(4, this.f444486h, new b.d(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f444483d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f444484e = ((Integer) obj).intValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f444485f = (o25.e) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
            this.f444486h = (k) obj;
        }
    }
}
