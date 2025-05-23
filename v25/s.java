package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440894d;

    /* renamed from: e, reason: collision with root package name */
    public int f440895e;

    public s() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new s(null, 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ s(m25.c cVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440894d, new b.d(new m25.c(null, 0 == true ? 1 : 0, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f440895e), new b.e.h(false))));
        return mapOf;
    }

    public s(m25.c cVar, int i3) {
        this.f440894d = cVar;
        this.f440895e = i3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440894d = (m25.c) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440895e = ((Integer) obj).intValue();
        }
    }
}
