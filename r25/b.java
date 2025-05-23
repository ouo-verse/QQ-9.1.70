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
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f430598d;

    /* renamed from: e, reason: collision with root package name */
    public String f430599e;

    /* renamed from: f, reason: collision with root package name */
    public c f430600f;

    public b() {
        this(0, (c) null, 7);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(0, (c) null, 7));
    }

    public /* synthetic */ b(int i3, c cVar, int i16) {
        this((i16 & 1) != 0 ? d.c.f30317b.b().getValue() : i3, (i16 & 2) != 0 ? "" : null, (i16 & 4) != 0 ? null : cVar);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f430598d), new b.a(false))), TuplesKt.to(2, new h(2, this.f430599e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f430600f, new b.d(new c(null, 31)))));
        return mapOf;
    }

    public b(int i3, String str, c cVar) {
        this.f430598d = i3;
        this.f430599e = str;
        this.f430600f = cVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.common.user.UserKt.DressType }");
            this.f430598d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f430599e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.user.DressDetail");
            this.f430600f = (c) obj;
        }
    }
}
