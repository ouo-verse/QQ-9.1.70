package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440891d;

    /* renamed from: e, reason: collision with root package name */
    public o25.e f440892e;

    /* renamed from: f, reason: collision with root package name */
    public n25.k f440893f;

    public r(m25.c cVar, o25.e eVar, n25.k kVar) {
        this.f440891d = cVar;
        this.f440892e = eVar;
        this.f440893f = kVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new r(null, null, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440891d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f440892e, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(3, new c45.h(3, this.f440893f, new b.d(new n25.k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440891d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f440892e = (o25.e) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
            this.f440893f = (n25.k) obj;
        }
    }
}
