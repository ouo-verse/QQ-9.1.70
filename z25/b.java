package z25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class b extends j {

    /* renamed from: d, reason: collision with root package name */
    public a f451821d;

    /* renamed from: e, reason: collision with root package name */
    public d f451822e;

    /* renamed from: f, reason: collision with root package name */
    public c45.a f451823f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f451824h;

    public b() {
        this(null, null, null, false, 15, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new b(null, null, null, false, 15, null));
    }

    public /* synthetic */ b(a aVar, d dVar, c45.a aVar2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, c45.a.f30290b, false);
    }

    public b(a aVar, d dVar, c45.a aVar2, boolean z16) {
        this.f451821d = aVar;
        this.f451822e = dVar;
        this.f451823f = aVar2;
        this.f451824h = z16;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f451821d, new b.d(new a(null, 0L, 0, 0, 0L, 0L, null, 0L, 0L, 0, 1023, null)))), TuplesKt.to(2, new h(2, this.f451822e, new b.d(new d(0L, null, null, null, 0, 0, 63, null)))), TuplesKt.to(3, new h(3, this.f451823f, new b.e.C0167b(false))), TuplesKt.to(4, new h(4, Boolean.valueOf(this.f451824h), new b.e.a(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.chat_comm.MsgHeader");
            this.f451821d = (a) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.qmeta.common.chat_comm.UserInfo");
            this.f451822e = (d) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f451823f = (c45.a) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f451824h = ((Boolean) obj).booleanValue();
        }
    }
}
