package x25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p35.ah;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f447096d;

    /* renamed from: e, reason: collision with root package name */
    public ah f447097e;

    /* renamed from: f, reason: collision with root package name */
    public int f447098f;

    /* renamed from: h, reason: collision with root package name */
    public String f447099h;

    public i(m25.c cVar, ah ahVar, int i3, String str) {
        this.f447096d = cVar;
        this.f447097e = ahVar;
        this.f447098f = i3;
        this.f447099h = str;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(null, null, 0, ""));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447096d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f447097e, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f447098f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f447099h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f447096d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
            this.f447097e = (ah) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f447098f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447099h = (String) obj;
        }
    }
}
