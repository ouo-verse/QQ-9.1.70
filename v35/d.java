package v35;

import c45.b;
import c45.h;
import c45.j;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes36.dex */
public final class d extends j {

    /* renamed from: d, reason: collision with root package name */
    public String f440931d;

    /* renamed from: e, reason: collision with root package name */
    public long f440932e;

    /* renamed from: f, reason: collision with root package name */
    public int f440933f;

    /* renamed from: h, reason: collision with root package name */
    public String f440934h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public d() {
        this(r2, 0, r2, 15);
        String str = null;
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        String str = null;
        return fVar.g(new d(str, 0, str, 15));
    }

    public /* synthetic */ d(String str, int i3, String str2, int i16) {
        this((i16 & 1) != 0 ? "" : str, 0L, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str2);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f440931d, new b.e.g(false))), TuplesKt.to(2, new h(2, Long.valueOf(this.f440932e), new b.e.i(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f440933f), new b.e.C0168e(false))), TuplesKt.to(4, new h(4, this.f440934h, new b.e.g(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440931d = (String) obj;
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f440932e = ((Long) obj).longValue();
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f440933f = ((Integer) obj).intValue();
        } else {
            if (i3 != 4) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440934h = (String) obj;
        }
    }

    public d(String str, long j3, int i3, String str2) {
        this.f440931d = str;
        this.f440932e = j3;
        this.f440933f = i3;
        this.f440934h = str2;
    }
}
