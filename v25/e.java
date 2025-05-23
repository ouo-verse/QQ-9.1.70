package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440845d;

    /* renamed from: e, reason: collision with root package name */
    public o25.f f440846e;

    /* renamed from: f, reason: collision with root package name */
    public int f440847f;

    public e() {
        this(null, null, 0, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, null, 0, 7, null));
    }

    public /* synthetic */ e(m25.c cVar, o25.f fVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, 0);
    }

    public e(m25.c cVar, o25.f fVar, int i3) {
        this.f440845d = cVar;
        this.f440846e = fVar;
        this.f440847f = i3;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440845d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, this.f440846e, new b.d(new o25.f(null, null, null, null, null, null, null, null, null, null, false, false, 0, 0, false, null, null, 0, 262143, null)))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f440847f), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440845d = (m25.c) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.map.MapTheme");
            this.f440846e = (o25.f) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440847f = ((Integer) obj).intValue();
        }
    }
}
