package s25;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f433146d;

    /* renamed from: e, reason: collision with root package name */
    public int f433147e;

    /* renamed from: f, reason: collision with root package name */
    public String f433148f;

    public i(m25.c cVar, int i3, String str) {
        this.f433146d = cVar;
        this.f433147e = i3;
        this.f433148f = str;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(null, new d.c(0).getValue(), ""));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433146d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433147e), new b.a(false))), TuplesKt.to(3, new c45.h(3, this.f433148f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f433146d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.feed_svr.status_rw.Status_rwKt.TipOffType }");
            this.f433147e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433148f = (String) obj;
        }
    }
}
