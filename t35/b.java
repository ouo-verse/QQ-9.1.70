package t35;

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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f435368d;

    /* renamed from: e, reason: collision with root package name */
    public String f435369e;

    /* renamed from: f, reason: collision with root package name */
    public final List<a> f435370f;

    /* renamed from: h, reason: collision with root package name */
    public String f435371h;

    public b() {
        this(0, null, null, null, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0, null, null, null, 15, null));
    }

    public /* synthetic */ b(int i3, String str, List list, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", new ArrayList(), "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f435368d), new b.e.h(false))), TuplesKt.to(2, new h(2, this.f435369e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f435370f, new b.f(new b.d(new a(0, null, 63)), false))), TuplesKt.to(4, new h(4, this.f435371h, new b.e.g(false))));
        return mapOf;
    }

    public b(int i3, String str, List<a> list, String str2) {
        this.f435368d = i3;
        this.f435369e = str;
        this.f435370f = list;
        this.f435371h = str2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f435368d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f435369e = (String) obj;
        } else if (i3 == 3) {
            List<a> list = this.f435370f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f435371h = (String) obj;
        }
    }
}
