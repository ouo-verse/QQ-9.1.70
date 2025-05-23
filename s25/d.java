package s25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n25.l;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public l f433131d;

    /* renamed from: e, reason: collision with root package name */
    public m25.c f433132e;

    public d() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ d(l lVar, m25.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public d(l lVar, m25.c cVar) {
        this.f433131d = lVar;
        this.f433132e = cVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433131d, new b.d(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151)))), TuplesKt.to(2, new c45.h(2, this.f433132e, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StatusFeed");
            this.f433131d = (l) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f433132e = (m25.c) obj;
        }
    }
}
