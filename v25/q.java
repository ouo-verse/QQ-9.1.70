package v25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class q extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f440886d;

    /* renamed from: e, reason: collision with root package name */
    public String f440887e;

    /* renamed from: f, reason: collision with root package name */
    public String f440888f;

    /* renamed from: h, reason: collision with root package name */
    public m25.e f440889h;

    /* renamed from: i, reason: collision with root package name */
    public String f440890i;

    public q() {
        this(0, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new q(0, null, null, null, null, 31, null));
    }

    public /* synthetic */ q(int i3, String str, String str2, m25.e eVar, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", "", null, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f440886d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f440887e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f440888f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f440889h, new b.d(new m25.e(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)))), TuplesKt.to(5, new c45.h(5, this.f440890i, new b.e.g(false))));
        return mapOf;
    }

    public q(int i3, String str, String str2, m25.e eVar, String str3) {
        this.f440886d = i3;
        this.f440887e = str;
        this.f440888f = str2;
        this.f440889h = eVar;
        this.f440890i = str3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440886d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440887e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440888f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.Material");
            this.f440889h = (m25.e) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440890i = (String) obj;
        }
    }
}
