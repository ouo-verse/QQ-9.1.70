package q25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public a f428249d;

    /* renamed from: e, reason: collision with root package name */
    public a f428250e;

    public e() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ e(a aVar, a aVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        int i3 = 0;
        int i16 = 3;
        DefaultConstructorMarker defaultConstructorMarker = null;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f428249d, new b.d(new a(i3, i3, i16, defaultConstructorMarker)))), TuplesKt.to(2, new c45.h(2, this.f428250e, new b.d(new a(i3, i3, i16, defaultConstructorMarker)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.Dpi");
            this.f428249d = (a) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.status.Dpi");
            this.f428250e = (a) obj;
        }
    }

    public e(a aVar, a aVar2) {
        this.f428249d = aVar;
        this.f428250e = aVar2;
    }
}
