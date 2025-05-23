package u35;

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
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f438197d;

    /* renamed from: e, reason: collision with root package name */
    public String f438198e;

    /* renamed from: f, reason: collision with root package name */
    public int f438199f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f438200h;

    public a(String str, String str2, int i3, c45.a aVar) {
        this.f438197d = str;
        this.f438198e = str2;
        this.f438199f = i3;
        this.f438200h = aVar;
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a("", "", new d.c(0).getValue(), c45.a.f30290b));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f438197d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f438198e, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f438199f), new b.a(false))), TuplesKt.to(4, new h(4, this.f438200h, new b.e.C0167b(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f438197d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f438198e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.common.CommonKt.AppID }");
            this.f438199f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f438200h = (c45.a) obj;
        }
    }
}
