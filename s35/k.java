package s35;

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
public final class k extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433246d;

    /* renamed from: e, reason: collision with root package name */
    public String f433247e;

    /* renamed from: f, reason: collision with root package name */
    public final List<z> f433248f;

    public k() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new k(0, null, null, 7, null));
    }

    public /* synthetic */ k(int i3, String str, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", new ArrayList());
    }

    public k(int i3, String str, List<z> list) {
        this.f433246d = i3;
        this.f433247e = str;
        this.f433248f = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433246d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433247e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433248f, new b.f(new b.d(new z(0, 0, null, null, 0, null, 0, 0L, 255, null)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433246d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433247e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            List<z> list = this.f433248f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.TacitFAQ>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
