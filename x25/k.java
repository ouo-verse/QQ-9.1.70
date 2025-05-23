package x25;

import c45.b;
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
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f447103d;

    /* renamed from: e, reason: collision with root package name */
    public String f447104e;

    /* renamed from: f, reason: collision with root package name */
    public String f447105f;

    /* renamed from: h, reason: collision with root package name */
    public final List<t35.a> f447106h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f447107i;

    /* renamed from: m, reason: collision with root package name */
    public final List<r35.a> f447108m;

    public /* synthetic */ k() {
        this(0L, "", "", new ArrayList(), false, new ArrayList());
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k());
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f447103d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f447104e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f447105f = (String) obj;
                return;
            case 4:
                List<t35.a> list = this.f447106h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f447107i = ((Boolean) obj).booleanValue();
                return;
            case 6:
                List<r35.a> list2 = this.f447108m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.meta.Image>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public k(long j3, String str, String str2, List<t35.a> list, boolean z16, List<r35.a> list2) {
        this.f447103d = j3;
        this.f447104e = str;
        this.f447105f = str2;
        this.f447106h = list;
        this.f447107i = z16;
        this.f447108m = list2;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f447103d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f447104e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f447105f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f447106h, new b.f(new b.d(new t35.a(0, null, 63)), false))), TuplesKt.to(5, new c45.h(5, Boolean.valueOf(this.f447107i), new b.e.a(false))), TuplesKt.to(6, new c45.h(6, this.f447108m, new b.f(new b.d(new r35.a(0, 0, null, 7, null)), false))));
        return mapOf;
    }
}
