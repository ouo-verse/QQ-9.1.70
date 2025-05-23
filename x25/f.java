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
public final class f extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public final List<l25.c> f447087d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f447088e;

    /* renamed from: f, reason: collision with root package name */
    public String f447089f;

    /* renamed from: h, reason: collision with root package name */
    public String f447090h;

    public f() {
        this(null, false, null, null, 15, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new f(null, false, null, null, 15, null));
    }

    public /* synthetic */ f(List list, boolean z16, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(new ArrayList(), false, "", "");
    }

    public f(List<l25.c> list, boolean z16, String str, String str2) {
        this.f447087d = list;
        this.f447088e = z16;
        this.f447089f = str;
        this.f447090h = str2;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, this.f447087d, new b.f(new b.d(new l25.c(null, null, null, null, null, null, 63, null)), false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f447088e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, this.f447089f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f447090h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<l25.c> list = this.f447087d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChFeed>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f447088e = ((Boolean) obj).booleanValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447089f = (String) obj;
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f447090h = (String) obj;
        }
    }
}
