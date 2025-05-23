package x25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p35.ah;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f447091d;

    /* renamed from: e, reason: collision with root package name */
    public ah f447092e;

    /* renamed from: f, reason: collision with root package name */
    public o25.e f447093f;

    public g(m25.c cVar, ah ahVar, o25.e eVar) {
        this.f447091d = cVar;
        this.f447092e = ahVar;
        this.f447093f = eVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, null, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447091d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f447092e, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(3, new c45.h(3, this.f447093f, new b.d(new o25.e(0.0f, 0.0f, 7)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f447091d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
            this.f447092e = (ah) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f447093f = (o25.e) obj;
        }
    }
}
