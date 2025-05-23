package s25;

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
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f433142d;

    /* renamed from: e, reason: collision with root package name */
    public int f433143e;

    /* renamed from: f, reason: collision with root package name */
    public final List<String> f433144f;

    public g(m25.c cVar, int i3, List<String> list) {
        this.f433142d = cVar;
        this.f433143e = i3;
        this.f433144f = list;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(null, 0, new ArrayList()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433142d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433143e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, this.f433144f, new b.f(new b.e.g(false), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f433142d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433143e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            List<String> list = this.f433144f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
