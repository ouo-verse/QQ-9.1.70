package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440830d;

    /* renamed from: e, reason: collision with root package name */
    public o25.e f440831e;

    /* renamed from: f, reason: collision with root package name */
    public int f440832f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f440833h;

    /* renamed from: i, reason: collision with root package name */
    public String f440834i;

    public b(m25.c cVar, o25.e eVar, int i3, boolean z16, String str) {
        this.f440830d = cVar;
        this.f440831e = eVar;
        this.f440832f = i3;
        this.f440833h = z16;
        this.f440834i = str;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, null, 0, false, ""));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440830d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f440831e, new b.d(new o25.e(0.0f, 0.0f, 7)))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f440832f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f440833h), new b.e.a(false))), TuplesKt.to(5, new c45.h(5, this.f440834i, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440830d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.GeoCoordinate");
            this.f440831e = (o25.e) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440832f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f440833h = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440834i = (String) obj;
        }
    }
}
