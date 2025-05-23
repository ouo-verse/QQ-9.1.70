package s25;

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
import n25.l;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f433125d;

    /* renamed from: e, reason: collision with root package name */
    public final List<l> f433126e;

    /* renamed from: f, reason: collision with root package name */
    public String f433127f;

    /* renamed from: h, reason: collision with root package name */
    public int f433128h;

    public b() {
        this(null, null, null, 0, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(null, null, null, 0, 15, null));
    }

    public /* synthetic */ b(m25.c cVar, List list, String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, new ArrayList(), "", 0);
    }

    public b(m25.c cVar, List<l> list, String str, int i3) {
        this.f433125d = cVar;
        this.f433126e = list;
        this.f433127f = str;
        this.f433128h = i3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433125d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, this.f433126e, new b.f(new b.d(new l(null, null, null, null, 0 == true ? 1 : 0, null, null, 0L, null, false, 0, null, 0, null, null, 2097151)), false))), TuplesKt.to(3, new c45.h(3, this.f433127f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f433128h), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f433125d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            List<l> list = this.f433126e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.feed.StatusFeed>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433127f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433128h = ((Integer) obj).intValue();
        }
    }
}
