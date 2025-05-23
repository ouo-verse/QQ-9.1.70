package x35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
public final class b extends j {
    public String C;

    /* renamed from: d, reason: collision with root package name */
    public final List<a> f447164d;

    /* renamed from: e, reason: collision with root package name */
    public Integer f447165e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f447166f;

    /* renamed from: h, reason: collision with root package name */
    public Integer f447167h;

    /* renamed from: i, reason: collision with root package name */
    public c45.a f447168i;

    /* renamed from: m, reason: collision with root package name */
    public String f447169m;

    public b() {
        this(null, null, null, null, null, 127);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(null, null, null, null, null, 127));
    }

    public /* synthetic */ b(Integer num, Integer num2, Integer num3, c45.a aVar, String str, int i3) {
        this((i3 & 1) != 0 ? new ArrayList() : null, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) != 0 ? null : num3, (i3 & 16) != 0 ? null : aVar, null, (i3 & 64) != 0 ? null : str);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f447165e, new b.e.h(true))), TuplesKt.to(2, new h(2, this.f447166f, new b.e.h(true))), TuplesKt.to(3, new h(3, this.f447167h, new b.e.h(true))), TuplesKt.to(4, new h(4, this.f447168i, new b.e.C0167b(true))), TuplesKt.to(5, new h(5, this.f447169m, new b.e.g(true))), TuplesKt.to(6, new h(6, this.C, new b.e.g(true))), TuplesKt.to(11, new h(11, this.f447164d, new b.f(new b.d(new a(null, null)), false))));
        return mapOf;
    }

    public b(List<a> list, Integer num, Integer num2, Integer num3, c45.a aVar, String str, String str2) {
        this.f447164d = list;
        this.f447165e = num;
        this.f447166f = num2;
        this.f447167h = num3;
        this.f447168i = aVar;
        this.f447169m = str;
        this.C = str2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 != 11) {
            switch (i3) {
                case 1:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f447165e = (Integer) obj;
                    return;
                case 2:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f447166f = (Integer) obj;
                    return;
                case 3:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    this.f447167h = (Integer) obj;
                    return;
                case 4:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                    this.f447168i = (c45.a) obj;
                    return;
                case 5:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.f447169m = (String) obj;
                    return;
                case 6:
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                    this.C = (String) obj;
                    return;
                default:
                    return;
            }
        }
        List<a> list = this.f447164d;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.tencent.im.oidb.MetaData>");
        CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
    }
}
