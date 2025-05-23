package q25;

import c45.b;
import c45.j;
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
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public final List<c> f428247d;

    /* renamed from: e, reason: collision with root package name */
    public String f428248e;

    public d() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ d(List list, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f428247d, new b.f(new b.d(new c("", "")), false))), TuplesKt.to(2, new c45.h(2, this.f428248e, new b.e.g(false))));
        return mapOf;
    }

    public d(List<c> list, String str) {
        this.f428247d = list;
        this.f428248e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<c> list = this.f428247d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.status.FilamentData>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f428248e = (String) obj;
        }
    }
}
