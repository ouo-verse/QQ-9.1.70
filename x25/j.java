package x25;

import c45.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class j extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<p35.n> f447100d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f447101e;

    /* renamed from: f, reason: collision with root package name */
    public String f447102f;

    public j() {
        this(null, false, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new j(null, false, null, 7, null));
    }

    public /* synthetic */ j(List list, boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), false, "");
    }

    public j(List<p35.n> list, boolean z16, String str) {
        this.f447100d = list;
        this.f447101e = z16;
        this.f447102f = str;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447100d, new b.f(new b.d(new p35.n(null, null, null, null, null, null, null, 0L, null, false, 0, null, null, null, 0, 0, 524287)), false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f447101e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, this.f447102f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<p35.n> list = this.f447100d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.Feed>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f447101e = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447102f = (String) obj;
        }
    }
}
