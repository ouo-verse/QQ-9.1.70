package w25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class f extends j {

    /* renamed from: d, reason: collision with root package name */
    public g f444487d;

    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, 1, 0 == true ? 1 : 0));
    }

    public /* synthetic */ f(g gVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f444487d, new b.d(new g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null)))));
        return mapOf;
    }

    public f(g gVar) {
        this.f444487d = gVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.User");
            this.f444487d = (g) obj;
        }
    }
}
