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
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433234d;

    /* renamed from: e, reason: collision with root package name */
    public int f433235e;

    /* renamed from: f, reason: collision with root package name */
    public int f433236f;

    public f() {
        this(0, 0, 0, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(0, 0, 0, 7, null));
    }

    public /* synthetic */ f(int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), 0, 0);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433234d), new b.a(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433235e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f433236f), new b.e.h(false))));
        return mapOf;
    }

    public f(int i3, int i16, int i17) {
        this.f433234d = i3;
        this.f433235e = i16;
        this.f433236f = i17;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.DurationType }");
            this.f433234d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433235e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433236f = ((Integer) obj).intValue();
        }
    }
}
