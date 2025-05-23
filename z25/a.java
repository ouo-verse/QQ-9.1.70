package z25;

import c45.b;
import c45.d;
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
public final class a extends j {
    public final List<Long> C;
    public long D;
    public long E;
    public int F;

    /* renamed from: d, reason: collision with root package name */
    public String f451815d;

    /* renamed from: e, reason: collision with root package name */
    public long f451816e;

    /* renamed from: f, reason: collision with root package name */
    public int f451817f;

    /* renamed from: h, reason: collision with root package name */
    public int f451818h;

    /* renamed from: i, reason: collision with root package name */
    public long f451819i;

    /* renamed from: m, reason: collision with root package name */
    public long f451820m;

    public a() {
        this(null, 0L, 0, 0, 0L, 0L, null, 0L, 0L, 0, 1023, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(null, 0L, 0, 0, 0L, 0L, null, 0L, 0L, 0, 1023, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f451815d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f451816e = ((Long) obj).longValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.status_square_data.Status_square_dataKt.Scene }");
                this.f451817f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.chat_comm.CommKt.DisplayType }");
                this.f451818h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f451819i = ((Long) obj).longValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f451820m = ((Long) obj).longValue();
                return;
            case 7:
                List<Long> list = this.C;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.Long>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.D = ((Long) obj).longValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.E = ((Long) obj).longValue();
                return;
            case 10:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.F = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ a(String str, long j3, int i3, int i16, long j16, long j17, List list, long j18, long j19, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0L, r3.b().getValue(), r3.b().getValue(), 0L, 0L, new ArrayList(), 0L, 0L, 0);
        d.c.a aVar = d.c.f30317b;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f451815d, new b.e.g(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f451816e), new b.e.i(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f451817f), new b.a(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f451818h), new b.a(false))), TuplesKt.to(5, new h(5, Long.valueOf(this.f451819i), new b.e.i(false))), TuplesKt.to(6, new h(6, Long.valueOf(this.f451820m), new b.e.i(false))), TuplesKt.to(7, new h(7, this.C, new b.f(new b.e.i(false), true))), TuplesKt.to(8, new h(8, Long.valueOf(this.D), new b.e.i(false))), TuplesKt.to(9, new h(9, Long.valueOf(this.E), new b.e.i(false))), TuplesKt.to(10, new h(10, Integer.valueOf(this.F), new b.e.C0168e(false))));
        return mapOf;
    }

    public a(String str, long j3, int i3, int i16, long j16, long j17, List<Long> list, long j18, long j19, int i17) {
        this.f451815d = str;
        this.f451816e = j3;
        this.f451817f = i3;
        this.f451818h = i16;
        this.f451819i = j16;
        this.f451820m = j17;
        this.C = list;
        this.D = j18;
        this.E = j19;
        this.F = i17;
    }
}
