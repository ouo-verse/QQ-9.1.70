package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f440841d;

    /* renamed from: e, reason: collision with root package name */
    public String f440842e;

    /* renamed from: f, reason: collision with root package name */
    public String f440843f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f440844h;

    public d(m25.c cVar, String str, String str2, boolean z16) {
        this.f440841d = cVar;
        this.f440842e = str;
        this.f440843f = str2;
        this.f440844h = z16;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, "", "", false));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440841d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f440842e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f440843f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f440844h), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f440841d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440842e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440843f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f440844h = ((Boolean) obj).booleanValue();
        }
    }
}
