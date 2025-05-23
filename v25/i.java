package v25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class i extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440857d;

    /* renamed from: e, reason: collision with root package name */
    public final List<o25.f> f440858e;

    public i() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ i(m25.c cVar, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList());
    }

    public i(m25.c cVar, List<o25.f> list) {
        this.f440857d = cVar;
        this.f440858e = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440857d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f440858e, new b.f(new b.d(new o25.f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440857d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            List<o25.f> list = this.f440858e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.map.MapTheme>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
