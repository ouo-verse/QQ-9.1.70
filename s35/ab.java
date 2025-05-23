package s35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ab extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433193d;

    /* renamed from: e, reason: collision with root package name */
    public String f433194e;

    public ab() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ab(0, null, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ab(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433193d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f433194e, new b.e.g(false))));
        return mapOf;
    }

    public ab(int i3, String str) {
        this.f433193d = i3;
        this.f433194e = str;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.TacitFAQUser }");
            this.f433193d = ((Integer) obj).intValue();
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433194e = (String) obj;
        }
    }
}
