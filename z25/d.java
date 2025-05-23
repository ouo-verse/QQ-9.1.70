package z25;

import c45.b;
import c45.d;
import c45.f;
import c45.h;
import c45.j;
import c45.k;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public long f451829d;

    /* renamed from: e, reason: collision with root package name */
    public c45.a f451830e;

    /* renamed from: f, reason: collision with root package name */
    public String f451831f;

    /* renamed from: h, reason: collision with root package name */
    public final Map<String, String> f451832h;

    /* renamed from: i, reason: collision with root package name */
    public int f451833i;

    /* renamed from: m, reason: collision with root package name */
    public int f451834m;

    public d() {
        this(0L, null, null, null, 0, 0, 63, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(0L, null, null, null, 0, 0, 63, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ d(long j3, c45.a aVar, String str, Map map, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, r4, "", r6, r1.b().getValue(), r1.b().getValue());
        c45.a aVar2 = c45.a.f30290b;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        d.c.a aVar3 = d.c.f30317b;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Long.valueOf(this.f451829d), new b.e.i(false))), TuplesKt.to(2, new h(2, this.f451830e, new b.e.C0167b(false))), TuplesKt.to(3, new h(3, this.f451831f, new b.e.g(false))), TuplesKt.to(4, new h(4, this.f451832h, new b.C0166b(new b.e.g(false), new b.e.g(false)))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f451833i), new b.a(false))), TuplesKt.to(6, new h(6, Integer.valueOf(this.f451834m), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f451829d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.f451830e = (c45.a) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f451831f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.MessageMap.Entry<kotlin.String, kotlin.String>");
                k.a((a.c) obj, this.f451832h);
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.status_square_data.Status_square_dataKt.GenderType }");
                this.f451833i = ((Integer) obj).intValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.chat_comm.CommKt.RelationType }");
                this.f451834m = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    public d(long j3, c45.a aVar, String str, Map<String, String> map, int i3, int i16) {
        this.f451829d = j3;
        this.f451830e = aVar;
        this.f451831f = str;
        this.f451832h = map;
        this.f451833i = i3;
        this.f451834m = i16;
    }
}
