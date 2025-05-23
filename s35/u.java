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
public final class u extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<Integer> f433273d;

    /* renamed from: e, reason: collision with root package name */
    public af f433274e;

    /* renamed from: f, reason: collision with root package name */
    public int f433275f;

    public u(List<Integer> list, af afVar, int i3) {
        this.f433273d = list;
        this.f433274e = afVar;
        this.f433275f = i3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new u(new ArrayList(), null, new d.c(0).getValue()));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433273d, new b.f(new b.a(false), true))), TuplesKt.to(2, new c45.h(2, this.f433274e, new b.d(new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255)))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f433275f), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<Integer> list = this.f433273d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.UserInfoItemId }>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo");
            this.f433274e = (af) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.SourceType }");
            this.f433275f = ((Integer) obj).intValue();
        }
    }
}
