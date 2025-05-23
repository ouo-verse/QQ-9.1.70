package s35;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class ac extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<f> f433195d;

    /* renamed from: e, reason: collision with root package name */
    public final List<f> f433196e;

    public ac() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ac(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    public /* synthetic */ ac(List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), new ArrayList());
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<f> list = this.f433195d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.DurationLimit>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 2) {
                return;
            }
            List<f> list2 = this.f433196e;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.DurationLimit>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        }
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f433195d, new b.f(new b.d(new f(0, 0, 0, 7, null)), false))), TuplesKt.to(2, new c45.h(2, this.f433196e, new b.f(new b.d(new f(0, 0, 0, 7, null)), false))));
        return mapOf;
    }

    public ac(List<f> list, List<f> list2) {
        this.f433195d = list;
        this.f433196e = list2;
    }
}
