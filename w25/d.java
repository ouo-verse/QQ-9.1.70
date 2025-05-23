package w25;

import c45.b;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f444477d;

    /* renamed from: e, reason: collision with root package name */
    public String f444478e;

    /* renamed from: f, reason: collision with root package name */
    public String f444479f;

    /* renamed from: h, reason: collision with root package name */
    public h f444480h;

    /* renamed from: i, reason: collision with root package name */
    public String f444481i;

    /* renamed from: m, reason: collision with root package name */
    public String f444482m;

    public d() {
        this(null, null, null, null, null, null, 63, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new d(null, null, null, null, null, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444477d = (String) obj;
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444478e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444479f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.mood_svr.mood_svr.Weather");
                this.f444480h = (h) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444481i = (String) obj;
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f444482m = (String) obj;
                return;
            default:
                return;
        }
    }

    public /* synthetic */ d(String str, String str2, String str3, h hVar, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", "", "", null, "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f444477d, new b.e.g(false))), TuplesKt.to(2, new c45.h(2, this.f444478e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f444479f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f444480h, new b.d(new h(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(5, new c45.h(5, this.f444481i, new b.e.g(false))), TuplesKt.to(6, new c45.h(6, this.f444482m, new b.e.g(false))));
        return mapOf;
    }

    public d(String str, String str2, String str3, h hVar, String str4, String str5) {
        this.f444477d = str;
        this.f444478e = str2;
        this.f444479f = str3;
        this.f444480h = hVar;
        this.f444481i = str4;
        this.f444482m = str5;
    }
}
