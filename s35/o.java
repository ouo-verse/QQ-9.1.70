package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class o extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433253d;

    /* renamed from: e, reason: collision with root package name */
    public String f433254e;

    /* renamed from: f, reason: collision with root package name */
    public ac f433255f;

    public o() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new o(0, null, null, 7, null));
    }

    public /* synthetic */ o(int i3, String str, ac acVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433253d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433254e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433255f, new b.d(new ac(null, null, 3, null)))));
        return mapOf;
    }

    public o(int i3, String str, ac acVar) {
        this.f433253d = i3;
        this.f433254e = str;
        this.f433255f = acVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433253d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433254e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UpdateLimit");
            this.f433255f = (ac) obj;
        }
    }
}
