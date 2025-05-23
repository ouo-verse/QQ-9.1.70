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
public final class b extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<String> f433221d;

    /* renamed from: e, reason: collision with root package name */
    public int f433222e;

    /* renamed from: f, reason: collision with root package name */
    public final List<Integer> f433223f;

    /* renamed from: h, reason: collision with root package name */
    public int f433224h;

    /* renamed from: i, reason: collision with root package name */
    public String f433225i;

    public b(List<String> list, int i3, List<Integer> list2, int i16, String str) {
        this.f433221d = list;
        this.f433222e = i3;
        this.f433223f = list2;
        this.f433224h = i16;
        this.f433225i = str;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new b(new ArrayList(), new d.c(0).getValue(), new ArrayList(), new d.c(0).getValue(), ""));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433221d, new b.f(new b.e.g(false), false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433222e), new b.a(false))), TuplesKt.to(3, new c45.h(3, this.f433223f, new b.f(new b.a(false), true))), TuplesKt.to(4, new c45.h(4, Integer.valueOf(this.f433224h), new b.a(false))), TuplesKt.to(5, new c45.h(5, this.f433225i, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<String> list = this.f433221d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.common.CommonKt.AccountType }");
            this.f433222e = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 3) {
            List<Integer> list2 = this.f433223f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.UserInfoItemId }>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.Source }");
            this.f433224h = ((Integer) obj).intValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433225i = (String) obj;
        }
    }
}
