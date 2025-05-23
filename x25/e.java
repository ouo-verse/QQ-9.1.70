package x25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p35.ah;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public m25.c f447082d;

    /* renamed from: e, reason: collision with root package name */
    public ah f447083e;

    /* renamed from: f, reason: collision with root package name */
    public int f447084f;

    /* renamed from: h, reason: collision with root package name */
    public String f447085h;

    /* renamed from: i, reason: collision with root package name */
    public long f447086i;

    public e(m25.c cVar, ah ahVar, int i3, String str, long j3) {
        this.f447082d = cVar;
        this.f447083e = ahVar;
        this.f447084f = i3;
        this.f447085h = str;
        this.f447086i = j3;
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new e(null, null, 0, "", 0L));
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447082d, new b.d(new m25.c(null, null, 15)))), TuplesKt.to(2, new c45.h(2, this.f447083e, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(3, new c45.h(3, Integer.valueOf(this.f447084f), new b.e.h(false))), TuplesKt.to(4, new c45.h(4, this.f447085h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, Long.valueOf(this.f447086i), new b.e.i(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.common.CommonExt");
            this.f447082d = (m25.c) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
            this.f447083e = (ah) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f447084f = ((Integer) obj).intValue();
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447085h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f447086i = ((Long) obj).longValue();
        }
    }
}
