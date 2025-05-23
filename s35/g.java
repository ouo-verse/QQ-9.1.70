package s35;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class g extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433237d;

    /* renamed from: e, reason: collision with root package name */
    public String f433238e;

    /* renamed from: f, reason: collision with root package name */
    public long f433239f;

    public g() {
        this(0, null, 0L, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new g(0, null, 0L, 7, null));
    }

    public /* synthetic */ g(int i3, String str, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "", 0L);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433237d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f433238e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, Long.valueOf(this.f433239f), new b.e.i(false))));
        return mapOf;
    }

    public g(int i3, String str, long j3) {
        this.f433237d = i3;
        this.f433238e = str;
        this.f433239f = j3;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.FirstRelationOrigin }");
            this.f433237d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433238e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f433239f = ((Long) obj).longValue();
        }
    }
}
