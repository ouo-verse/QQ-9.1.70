package v25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class n extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440868d;

    /* renamed from: e, reason: collision with root package name */
    public o25.e f440869e;

    /* renamed from: f, reason: collision with root package name */
    public n25.k f440870f;

    /* renamed from: h, reason: collision with root package name */
    public String f440871h;

    /* renamed from: i, reason: collision with root package name */
    public String f440872i;

    /* renamed from: m, reason: collision with root package name */
    public final List<String> f440873m;

    public n(m25.c cVar, o25.e eVar, n25.k kVar, String str, String str2, List<String> list) {
        this.f440868d = cVar;
        this.f440869e = eVar;
        this.f440870f = kVar;
        this.f440871h = str;
        this.f440872i = str2;
        this.f440873m = list;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new n(null, null, null, "", "", new ArrayList()));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.f440868d = (m25.c) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
                this.f440869e = (o25.e) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
                this.f440870f = (n25.k) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440871h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f440872i = (String) obj;
                return;
            case 6:
                List<String> list = this.f440873m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440868d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f440869e, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(3, new c45.h(3, this.f440870f, new b.d(new n25.k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))), TuplesKt.to(4, new c45.h(4, this.f440871h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f440872i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f440873m, new b.f(new b.e.g(false), false))));
        return mapOf;
    }
}
