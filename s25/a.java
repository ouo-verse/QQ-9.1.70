package s25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f433121d;

    /* renamed from: e, reason: collision with root package name */
    public int f433122e;

    /* renamed from: f, reason: collision with root package name */
    public int f433123f;

    /* renamed from: h, reason: collision with root package name */
    public String f433124h;

    public a(m25.c cVar, int i3, int i16, String str) {
        this.f433121d = cVar;
        this.f433122e = i3;
        this.f433123f = i16;
        this.f433124h = str;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new a(null, 0, 0, ""));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433121d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433122e), new b.e.h(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f433123f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f433124h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f433121d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433122e = ((Integer) obj).intValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433123f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433124h = (String) obj;
        }
    }
}
