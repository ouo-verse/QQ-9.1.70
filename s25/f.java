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
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public l f433139d;

    /* renamed from: e, reason: collision with root package name */
    public m25.c f433140e;

    /* renamed from: f, reason: collision with root package name */
    public m25.f f433141f;

    public f() {
        this(null, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, null, null, 7, null));
    }

    public /* synthetic */ f(l lVar, m25.c cVar, m25.f fVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }

    public f(l lVar, m25.c cVar, m25.f fVar) {
        this.f433139d = lVar;
        this.f433140e = cVar;
        this.f433141f = fVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433139d, new b.d(new l(null, null, null, null, null, null, null, 0L, null, false, 0, null, 0, null, null, 2097151)))), TuplesKt.to(2, new c45.h(2, this.f433140e, new b.d(new m25.c(0 == true ? 1 : 0, 0 == true ? 1 : 0, 15)))), TuplesKt.to(3, new c45.h(3, this.f433141f, new b.d(new m25.f(0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StatusFeed");
            this.f433139d = (l) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f433140e = (m25.c) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.Response");
            this.f433141f = (m25.f) obj;
        }
    }
}
