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
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f435362d;

    /* renamed from: e, reason: collision with root package name */
    public String f435363e;

    /* renamed from: f, reason: collision with root package name */
    public final List<String> f435364f;

    /* renamed from: h, reason: collision with root package name */
    public String f435365h;

    /* renamed from: i, reason: collision with root package name */
    public String f435366i;

    /* renamed from: m, reason: collision with root package name */
    public String f435367m;

    public a() {
        this(0, null, 63);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(0, null, 63));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f435362d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f435363e = (String) obj;
                return;
            case 3:
                List<String> list = this.f435364f;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f435365h = (String) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f435366i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f435367m = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ a(int i3, String str, int i16) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? new ArrayList() : null, (i16 & 8) != 0 ? "" : null, (i16 & 16) != 0 ? "" : null, (i16 & 32) != 0 ? "" : null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f435362d), new b.e.h(false))), TuplesKt.to(2, new h(2, this.f435363e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f435364f, new b.f(new b.e.g(false), false))), TuplesKt.to(4, new h(4, this.f435365h, new b.e.g(false))), TuplesKt.to(5, new h(5, this.f435366i, new b.e.g(false))), TuplesKt.to(6, new h(6, this.f435367m, new b.e.g(false))));
        return mapOf;
    }

    public a(int i3, String str, List<String> list, String str2, String str3, String str4) {
        this.f435362d = i3;
        this.f435363e = str;
        this.f435364f = list;
        this.f435365h = str2;
        this.f435366i = str3;
        this.f435367m = str4;
    }
}
