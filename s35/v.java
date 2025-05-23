package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class v extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433276d;

    /* renamed from: e, reason: collision with root package name */
    public String f433277e;

    public v() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new v(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ v(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433276d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433277e, new b.e.g(false))));
        return mapOf;
    }

    public v(int i3, String str) {
        this.f433276d = i3;
        this.f433277e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433276d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433277e = (String) obj;
        }
    }
}
