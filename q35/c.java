package q35;

import c45.b;
import c45.d;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class c extends j {
    public c45.a C;
    public int D;
    public int E;

    /* renamed from: d, reason: collision with root package name */
    public m25.c f428311d;

    /* renamed from: e, reason: collision with root package name */
    public int f428312e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f428313f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f428314h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f428315i;

    /* renamed from: m, reason: collision with root package name */
    public String f428316m;

    public c(m25.c cVar, int i3, boolean z16, boolean z17, boolean z18, String str, c45.a aVar, int i16, int i17) {
        this.f428311d = cVar;
        this.f428312e = i3;
        this.f428313f = z16;
        this.f428314h = z17;
        this.f428315i = z18;
        this.f428316m = str;
        this.C = aVar;
        this.D = i16;
        this.E = i17;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(null, new d.c(0).getValue(), false, false, false, "", c45.a.f30290b, 0, new d.c(0).getValue()));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
                this.f428311d = (m25.c) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.follow.FollowKt.OperationType }");
                this.f428312e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f428313f = ((Boolean) obj).booleanValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f428314h = ((Boolean) obj).booleanValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f428315i = ((Boolean) obj).booleanValue();
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f428316m = (String) obj;
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
                this.C = (c45.a) obj;
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.D = ((Integer) obj).intValue();
                return;
            case 9:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.common.CommonKt.AccountType }");
                this.E = ((Integer) obj).intValue();
                return;
            default:
                return;
        }
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f428311d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f428312e), new b.a(false))), TuplesKt.to(3, new h(3, Boolean.valueOf(this.f428313f), new b.e.a(false))), TuplesKt.to(4, new h(4, Boolean.valueOf(this.f428314h), new b.e.a(false))), TuplesKt.to(5, new h(5, Boolean.valueOf(this.f428315i), new b.e.a(false))), TuplesKt.to(6, new h(6, this.f428316m, new b.e.g(false))), TuplesKt.to(7, new h(7, this.C, new b.e.C0167b(false))), TuplesKt.to(8, new h(8, Integer.valueOf(this.D), new b.e.h(false))), TuplesKt.to(9, new h(9, Integer.valueOf(this.E), new b.a(false))));
        return mapOf;
    }
}
