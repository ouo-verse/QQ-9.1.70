package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class s extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public n25.j f433266d;

    /* renamed from: e, reason: collision with root package name */
    public String f433267e;

    /* renamed from: f, reason: collision with root package name */
    public r25.c f433268f;

    public s(n25.j jVar, String str, r25.c cVar) {
        this.f433266d = jVar;
        this.f433267e = str;
        this.f433268f = cVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new s(null, "", null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433266d, new b.d(new n25.j((n35.w) null, (String) null, 7)))), TuplesKt.to(2, new c45.h(2, this.f433267e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433268f, new b.d(new r25.c(null, 31)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StImage");
            this.f433266d = (n25.j) obj;
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433267e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.DressDetail");
            this.f433268f = (r25.c) obj;
        }
    }
}
