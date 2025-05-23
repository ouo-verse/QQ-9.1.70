package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class t extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433269d;

    /* renamed from: e, reason: collision with root package name */
    public String f433270e;

    /* renamed from: f, reason: collision with root package name */
    public n25.j f433271f;

    /* renamed from: h, reason: collision with root package name */
    public String f433272h;

    public t() {
        this(0, null, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new t(0, null, null, null, 15, null));
    }

    public /* synthetic */ t(int i3, String str, n25.j jVar, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433269d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433270e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433271f, new b.d(new n25.j((n35.w) null, (String) null, 7)))), TuplesKt.to(4, new c45.h(4, this.f433272h, new b.e.g(false))));
        return mapOf;
    }

    public t(int i3, String str, n25.j jVar, String str2) {
        this.f433269d = i3;
        this.f433270e = str;
        this.f433271f = jVar;
        this.f433272h = str2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433269d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433270e = (String) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StImage");
            this.f433271f = (n25.j) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433272h = (String) obj;
        }
    }
}
