package u25;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import n25.i;
import n25.k;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f438156d;

    /* renamed from: e, reason: collision with root package name */
    public String f438157e;

    /* renamed from: f, reason: collision with root package name */
    public String f438158f;

    /* renamed from: h, reason: collision with root package name */
    public m25.c f438159h;

    /* renamed from: i, reason: collision with root package name */
    public k f438160i;

    public /* synthetic */ a(int i3, String str, String str2, m25.c cVar, int i16) {
        this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? null : cVar, (k) null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new a(0, (String) null, (String) null, (m25.c) null, 31));
    }

    public a(int i3, String str, String str2, m25.c cVar, k kVar) {
        this.f438156d = i3;
        this.f438157e = str;
        this.f438158f = str2;
        this.f438159h = cVar;
        this.f438160i = kVar;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f438156d), new b.e.h(false))), TuplesKt.to(2, new h(2, this.f438157e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f438158f, new b.e.g(false))), TuplesKt.to(4, new h(4, this.f438159h, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(5, new h(5, this.f438160i, new b.d(new k((String) null, (String) null, 0, (String) null, (String) null, 0, (i) null, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 2097151)))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f438156d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f438157e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f438158f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f438159h = (m25.c) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.feed.StPoiInfoV2");
            this.f438160i = (k) obj;
        }
    }
}
