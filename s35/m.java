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
public final class m extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433250d;

    /* renamed from: e, reason: collision with root package name */
    public String f433251e;

    /* renamed from: f, reason: collision with root package name */
    public final List<t35.b> f433252f;

    public m() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new m(0, null, null, 7, null));
    }

    public /* synthetic */ m(int i3, String str, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", new ArrayList());
    }

    public m(int i3, String str, List<t35.b> list) {
        this.f433250d = i3;
        this.f433251e = str;
        this.f433252f = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433250d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433251e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433252f, new b.f(new b.d(new t35.b(0, null, null, null, 15, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433250d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433251e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            List<t35.b> list = this.f433252f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.TagTab>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
