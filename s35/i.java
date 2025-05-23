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
public final class i extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f433241d;

    /* renamed from: e, reason: collision with root package name */
    public String f433242e;

    /* renamed from: f, reason: collision with root package name */
    public v35.e f433243f;

    /* renamed from: h, reason: collision with root package name */
    public String f433244h;

    /* renamed from: i, reason: collision with root package name */
    public final List<r25.c> f433245i;

    public i() {
        this(0, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new i(0, null, null, null, null, 31, null));
    }

    public /* synthetic */ i(int i3, String str, v35.e eVar, String str2, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", null, "", new ArrayList());
    }

    public i(int i3, String str, v35.e eVar, String str2, List<r25.c> list) {
        this.f433241d = i3;
        this.f433242e = str;
        this.f433243f = eVar;
        this.f433244h = str2;
        this.f433245i = list;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433241d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, this.f433242e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f433243f, new b.d(new v35.e(false, null, null, null, null, 31, null)))), TuplesKt.to(4, new c45.h(4, this.f433244h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f433245i, new b.f(new b.d(new r25.c(null, 31)), false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            this.f433241d = ((Integer) obj).intValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433242e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.GetConfigRsp");
            this.f433243f = (v35.e) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f433244h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            List<r25.c> list = this.f433245i;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.lplan.common.user.DressDetail>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        }
    }
}
