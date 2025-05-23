package s35;

import c45.b;
import c45.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ad extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<Integer> f433197d;

    /* renamed from: e, reason: collision with root package name */
    public int f433198e;

    /* renamed from: f, reason: collision with root package name */
    public int f433199f;

    public ad(List<Integer> list, int i3, int i16) {
        this.f433197d = list;
        this.f433198e = i3;
        this.f433199f = i16;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ad(new ArrayList(), new d.c(0).getValue(), new d.c(0).getValue()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433197d, new b.f(new b.e.h(false), true))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433198e), new b.a(false))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f433199f), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<Integer> list = this.f433197d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.TagKt.TagOwner }");
            this.f433198e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.SourceType }");
            this.f433199f = ((Integer) obj).intValue();
        }
    }
}
