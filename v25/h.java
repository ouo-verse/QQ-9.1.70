package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440854d;

    /* renamed from: e, reason: collision with root package name */
    public n25.k f440855e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f440856f;

    public h(m25.c cVar, n25.k kVar, boolean z16) {
        this.f440854d = cVar;
        this.f440855e = kVar;
        this.f440856f = z16;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(null, null, false));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440854d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f440855e, new b.d(new n25.k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))), TuplesKt.to(3, new c45.h(3, Boolean.valueOf(this.f440856f), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440854d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
            this.f440855e = (n25.k) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f440856f = ((Boolean) obj).booleanValue();
        }
    }
}
