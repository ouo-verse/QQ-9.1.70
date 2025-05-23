package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ag extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433219d;

    /* renamed from: e, reason: collision with root package name */
    public String f433220e;

    public ag() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ag(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ag(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433219d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433220e, new b.e.g(false))));
        return mapOf;
    }

    public ag(int i3, String str) {
        this.f433219d = i3;
        this.f433220e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433219d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433220e = (String) obj;
        }
    }
}
