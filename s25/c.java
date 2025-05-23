package s25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public String f433129d;

    /* renamed from: e, reason: collision with root package name */
    public m25.c f433130e;

    public c(String str, m25.c cVar) {
        this.f433129d = str;
        this.f433130e = cVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c("", null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433129d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f433130e, new b.d(new m25.c(null, null, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433129d = (String) obj;
        } else {
            if (i3 != 2) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f433130e = (m25.c) obj;
        }
    }
}
