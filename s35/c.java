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
public final class c extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433226d;

    /* renamed from: e, reason: collision with root package name */
    public String f433227e;

    /* renamed from: f, reason: collision with root package name */
    public final List<af> f433228f;

    public c() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new c(0, null, null, 7, null));
    }

    public /* synthetic */ c(int i3, String str, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", new ArrayList());
    }

    public c(int i3, String str, List<af> list) {
        this.f433226d = i3;
        this.f433227e = str;
        this.f433228f = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433226d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433227e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433228f, new b.f(new b.d(new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433226d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433227e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            List<af> list = this.f433228f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
