package r35;

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
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f430679d;

    /* renamed from: e, reason: collision with root package name */
    public int f430680e;

    /* renamed from: f, reason: collision with root package name */
    public String f430681f;

    public a() {
        this(0, 0, null, 7, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a(0, 0, null, 7, null));
    }

    public /* synthetic */ a(int i3, int i16, String str, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, 0, "");
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f430679d), new b.e.h(false))), TuplesKt.to(2, new h(2, Integer.valueOf(this.f430680e), new b.e.h(false))), TuplesKt.to(3, new h(3, this.f430681f, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f430679d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f430680e = ((Integer) obj).intValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f430681f = (String) obj;
        }
    }

    public a(int i3, int i16, String str) {
        this.f430679d = i3;
        this.f430680e = i16;
        this.f430681f = str;
    }
}
