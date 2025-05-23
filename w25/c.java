package w25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public a f444475d;

    /* renamed from: e, reason: collision with root package name */
    public g f444476e;

    public c() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new c(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ c(a aVar, g gVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null);
    }

    public c(a aVar, g gVar) {
        this.f444475d = aVar;
        this.f444476e = gVar;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f444475d, new b.d(new a(0, null, null, null, null, null, null, 0L, 0L, null, null, null, 4095, null)))), TuplesKt.to(2, new c45.h(2, this.f444476e, new b.d(new g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.Entrance");
            this.f444475d = (a) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.User");
            this.f444476e = (g) obj;
        }
    }
}
