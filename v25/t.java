package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n35.w;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public n25.k f440896d;

    /* renamed from: e, reason: collision with root package name */
    public n25.j f440897e;

    /* renamed from: f, reason: collision with root package name */
    public String f440898f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f440899h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f440900i;

    public t() {
        this(null, null, null, false, false, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new t(null, null, null, false, false, 31, null));
    }

    public /* synthetic */ t(n25.k kVar, n25.j jVar, String str, boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, "", false, false);
    }

    public t(n25.k kVar, n25.j jVar, String str, boolean z16, boolean z17) {
        this.f440896d = kVar;
        this.f440897e = jVar;
        this.f440898f = str;
        this.f440899h = z16;
        this.f440900i = z17;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f440896d, new b.d(new n25.k((String) null, (String) null, 0, (String) null, (String) null, 0, (n25.i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))), TuplesKt.to(2, new c45.h(2, this.f440897e, new b.d(new n25.j((w) null, (String) (0 == true ? 1 : 0), 7)))), TuplesKt.to(3, new c45.h(3, this.f440898f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, Boolean.valueOf(this.f440899h), new b.e.a(false))), TuplesKt.to(5, new c45.h(5, Boolean.valueOf(this.f440900i), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
            this.f440896d = (n25.k) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StImage");
            this.f440897e = (n25.j) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440898f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f440899h = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f440900i = ((Boolean) obj).booleanValue();
        }
    }
}
