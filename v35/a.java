package v35;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f440922d;

    /* renamed from: e, reason: collision with root package name */
    public String f440923e;

    /* renamed from: f, reason: collision with root package name */
    public int f440924f;

    public a() {
        this(0, null, 0, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new a(0, null, 0, 7, null));
    }

    public /* synthetic */ a(int i3, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", 0);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f440922d), new b.e.C0168e(false))), TuplesKt.to(2, new h(2, this.f440923e, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f440924f), new b.e.C0168e(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440922d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440923e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440924f = ((Integer) obj).intValue();
        }
    }

    public a(int i3, String str, int i16) {
        this.f440922d = i3;
        this.f440923e = str;
        this.f440924f = i16;
    }
}
