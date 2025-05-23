package q35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import s35.af;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public final List<af> f428317d;

    /* renamed from: e, reason: collision with root package name */
    public int f428318e;

    /* renamed from: f, reason: collision with root package name */
    public int f428319f;

    /* renamed from: h, reason: collision with root package name */
    public c45.a f428320h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f428321i;

    public d() {
        this(null, 0, 0, null, false, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new d(null, 0, 0, null, false, 31, null));
    }

    public /* synthetic */ d(List list, int i3, int i16, c45.a aVar, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), 0, 0, c45.a.f30290b, false);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f428317d, new b.f(new b.d(new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255)), false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f428318e), new b.e.h(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f428319f), new b.e.h(false))), TuplesKt.to(5, new h(5, this.f428320h, new b.e.C0167b(false))), TuplesKt.to(6, new h(6, Boolean.valueOf(this.f428321i), new b.e.a(false))));
        return mapOf;
    }

    public d(List<af> list, int i3, int i16, c45.a aVar, boolean z16) {
        this.f428317d = list;
        this.f428318e = i3;
        this.f428319f = i16;
        this.f428320h = aVar;
        this.f428321i = z16;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<af> list = this.f428317d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.UserInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f428318e = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f428319f = ((Integer) obj).intValue();
        } else if (i3 == 5) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.ByteArr");
            this.f428320h = (c45.a) obj;
        } else {
            if (i3 != 6) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f428321i = ((Boolean) obj).booleanValue();
        }
    }
}
