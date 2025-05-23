package x25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p35.ah;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f447080d;

    /* renamed from: e, reason: collision with root package name */
    public ah f447081e;

    public c(m25.c cVar, ah ahVar) {
        this.f447080d = cVar;
        this.f447081e = ahVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447080d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f447081e, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f447080d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
            this.f447081e = (ah) obj;
        }
    }
}
