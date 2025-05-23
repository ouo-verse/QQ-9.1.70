package s35;

import c45.b;
import c45.d;
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
public final class aa extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433190d;

    /* renamed from: e, reason: collision with root package name */
    public String f433191e;

    /* renamed from: f, reason: collision with root package name */
    public final List<y> f433192f;

    public aa() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new aa(0, null, null, 7, null));
    }

    public /* synthetic */ aa(int i3, String str, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "", new ArrayList());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433190d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f433191e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433192f, new b.f(new b.d(new y(0, null, null, 7, null)), false))));
        return mapOf;
    }

    public aa(int i3, String str, List<y> list) {
        this.f433190d = i3;
        this.f433191e = str;
        this.f433192f = list;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.TacitRelation }");
            this.f433190d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433191e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            List<y> list = this.f433192f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.TacitContent>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
