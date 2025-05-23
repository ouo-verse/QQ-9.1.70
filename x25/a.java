package x25;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p35.ah;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f447075d;

    /* renamed from: e, reason: collision with root package name */
    public ah f447076e;

    /* renamed from: f, reason: collision with root package name */
    public o25.e f447077f;

    /* renamed from: h, reason: collision with root package name */
    public int f447078h;

    public a(m25.c cVar, ah ahVar, o25.e eVar, int i3) {
        this.f447075d = cVar;
        this.f447076e = ahVar;
        this.f447077f = eVar;
        this.f447078h = i3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(null, null, null, new d.c(0).getValue()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447075d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f447076e, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(3, new c45.h(3, this.f447077f, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f447078h), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f447075d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
            this.f447076e = (ah) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f447077f = (o25.e) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.poi_svr.poi_svr.Poi_svrKt.ActOperation }");
            this.f447078h = ((Integer) obj).intValue();
        }
    }
}
