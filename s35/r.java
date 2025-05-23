package s35;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class r extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f433263d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f433264e;

    /* renamed from: f, reason: collision with root package name */
    public String f433265f;

    public r() {
        this(false, false, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new r(false, false, null, 7, null));
    }

    public /* synthetic */ r(boolean z16, boolean z17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, false, "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Boolean.valueOf(this.f433263d), new b.e.a(false))), TuplesKt.to(2, new c45.h(2, Boolean.valueOf(this.f433264e), new b.e.a(false))), TuplesKt.to(3, new c45.h(3, this.f433265f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f433263d = ((Boolean) obj).booleanValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f433264e = ((Boolean) obj).booleanValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433265f = (String) obj;
        }
    }

    public r(boolean z16, boolean z17, String str) {
        this.f433263d = z16;
        this.f433264e = z17;
        this.f433265f = str;
    }
}
