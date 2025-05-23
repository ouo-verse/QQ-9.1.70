package s35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class p extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433256d;

    /* renamed from: e, reason: collision with root package name */
    public int f433257e;

    /* renamed from: f, reason: collision with root package name */
    public int f433258f;

    public p(int i3, int i16, int i17) {
        this.f433256d = i3;
        this.f433257e = i16;
        this.f433258f = i17;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new p(new d.c(0).getValue(), 0, 0));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433256d), new b.a(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433257e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f433258f), new b.e.h(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.TacitAnswerHistoryFilter }");
            this.f433256d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433257e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433258f = ((Integer) obj).intValue();
        }
    }
}
