package q35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f428310d;

    public b() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ b(m25.c cVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new h(1, this.f428310d, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    public b(m25.c cVar) {
        this.f428310d = cVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f428310d = (m25.c) obj;
        }
    }
}
