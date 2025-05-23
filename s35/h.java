package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public v35.d f433240d;

    public h(v35.d dVar) {
        this.f433240d = dVar;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(null));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433240d, new b.d(new v35.d((String) null, 0, (String) null, 15)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.GetConfigReq");
            this.f433240d = (v35.d) obj;
        }
    }
}
