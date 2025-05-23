package q35;

import c45.b;
import c45.d;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f428306d;

    /* renamed from: e, reason: collision with root package name */
    public int f428307e;

    /* renamed from: f, reason: collision with root package name */
    public String f428308f;

    /* renamed from: h, reason: collision with root package name */
    public int f428309h;

    public a(m25.c cVar, int i3, String str, int i16) {
        this.f428306d = cVar;
        this.f428307e = i3;
        this.f428308f = str;
        this.f428309h = i16;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, 0, "", new d.c(0).getValue()));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f428306d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f428307e), new b.e.h(false))), TuplesKt.to(3, new h(3, this.f428308f, new b.e.g(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f428309h), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f428306d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f428307e = ((Integer) obj).intValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f428308f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.common.CommonKt.AccountType }");
            this.f428309h = ((Integer) obj).intValue();
        }
    }
}
