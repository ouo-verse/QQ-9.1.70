package u25;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f438164d;

    /* renamed from: e, reason: collision with root package name */
    public int f438165e;

    public d() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ d(m25.c cVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f438164d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f438165e), new b.e.h(false))));
        return mapOf;
    }

    public d(m25.c cVar, int i3) {
        this.f438164d = cVar;
        this.f438165e = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f438164d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f438165e = ((Integer) obj).intValue();
        }
    }
}
