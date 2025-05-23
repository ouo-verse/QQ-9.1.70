package r25;

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

    /* renamed from: d, reason: collision with root package name */
    public String f430601d;

    /* renamed from: e, reason: collision with root package name */
    public String f430602e;

    /* renamed from: f, reason: collision with root package name */
    public String f430603f;

    /* renamed from: h, reason: collision with root package name */
    public String f430604h;

    /* renamed from: i, reason: collision with root package name */
    public int f430605i;

    public c() {
        this(null, 31);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(null, 31));
    }

    public /* synthetic */ c(String str, int i3) {
        this((i3 & 1) != 0 ? "" : null, (i3 & 2) != 0 ? "" : null, (i3 & 4) != 0 ? "" : null, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? d.c.f30317b.b().getValue() : 0);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f430601d, new b.e.g(false))), TuplesKt.to(2, new h(2, this.f430602e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f430603f, new b.e.g(false))), TuplesKt.to(4, new h(4, this.f430604h, new b.e.g(false))), TuplesKt.to(5, new h(5, Integer.valueOf(this.f430605i), new b.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f430601d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f430602e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f430603f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f430604h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.common.user.UserKt.DressStatus }");
            this.f430605i = ((Integer) obj).intValue();
        }
    }

    public c(String str, String str2, String str3, String str4, int i3) {
        this.f430601d = str;
        this.f430602e = str2;
        this.f430603f = str3;
        this.f430604h = str4;
        this.f430605i = i3;
    }
}
