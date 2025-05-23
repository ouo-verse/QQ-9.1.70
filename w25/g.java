package w25;

import c45.b;
import c45.d;
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
public final class g extends j {
    public boolean C;
    public final List<t35.a> D;
    public int E;
    public int F;

    /* renamed from: d, reason: collision with root package name */
    public long f444488d;

    /* renamed from: e, reason: collision with root package name */
    public p25.a f444489e;

    /* renamed from: f, reason: collision with root package name */
    public String f444490f;

    /* renamed from: h, reason: collision with root package name */
    public String f444491h;

    /* renamed from: i, reason: collision with root package name */
    public final List<r25.b> f444492i;

    /* renamed from: m, reason: collision with root package name */
    public String f444493m;

    public g() {
        this(0L, null, null, null, null, null, false, null, 0, 0, 1023, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new g(0L, null, null, null, null, null, false, null, 0, 0, 1023, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f444488d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.mood.Mood");
                this.f444489e = (p25.a) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444490f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444491h = (String) obj;
                return;
            case 5:
                List<r25.b> list = this.f444492i;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.user.Dress>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444493m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.C = ((Boolean) obj).booleanValue();
                return;
            case 8:
                List<t35.a> list2 = this.D;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.E = ((Integer) obj).intValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.Mood_svrKt.UserType }");
                this.F = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ g(long j3, p25.a aVar, String str, String str2, List list, String str3, boolean z16, List list2, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, null, "", "", new ArrayList(), "", false, new ArrayList(), 0, d.c.f30317b.b().getValue());
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f444488d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f444489e, new b.d(new p25.a(0L, 0, null, 0L, 0L, 0, null, null, 255, null)))), TuplesKt.to(3, new c45.h(3, this.f444490f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f444491h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f444492i, new b.f(new b.d(new r25.b(0, (r25.c) null, 7)), false))), TuplesKt.to(6, new c45.h(6, this.f444493m, new b.e.g(false))), TuplesKt.to(7, new c45.h(7, Boolean.valueOf(this.C), new b.e.a(false))), TuplesKt.to(8, new c45.h(8, this.D, new b.f(new b.d(new t35.a(0, null, 63)), false))), TuplesKt.to(9, new c45.h(9, Integer.valueOf(this.E), new b.e.h(false))), TuplesKt.to(10, new c45.h(10, Integer.valueOf(this.F), new b.a(false))));
        return mapOf;
    }

    public g(long j3, p25.a aVar, String str, String str2, List<r25.b> list, String str3, boolean z16, List<t35.a> list2, int i3, int i16) {
        this.f444488d = j3;
        this.f444489e = aVar;
        this.f444490f = str;
        this.f444491h = str2;
        this.f444492i = list;
        this.f444493m = str3;
        this.C = z16;
        this.D = list2;
        this.E = i3;
        this.F = i16;
    }
}
