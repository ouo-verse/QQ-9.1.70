package v35;

import c45.b;
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

/* compiled from: P */
/* loaded from: classes36.dex */
public final class e extends j {

    /* renamed from: d, reason: collision with root package name */
    public boolean f440935d;

    /* renamed from: e, reason: collision with root package name */
    public String f440936e;

    /* renamed from: f, reason: collision with root package name */
    public final List<g> f440937f;

    /* renamed from: h, reason: collision with root package name */
    public final List<a> f440938h;

    /* renamed from: i, reason: collision with root package name */
    public f f440939i;

    public e() {
        this(false, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public final j decodeWith(c45.f fVar) {
        return fVar.g(new e(false, null, null, null, null, 31, null));
    }

    public /* synthetic */ e(boolean z16, String str, List list, List list2, f fVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(false, "", new ArrayList(), new ArrayList(), null);
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Boolean.valueOf(this.f440935d), new b.e.a(false))), TuplesKt.to(2, new h(2, this.f440936e, new b.e.g(false))), TuplesKt.to(3, new h(3, this.f440937f, new b.f(new b.d(new g(0, null, 0, null, 0.0f, null, null, null, 0, 0, null, 2047, null)), false))), TuplesKt.to(4, new h(4, this.f440938h, new b.f(new b.d(new a(0, null, 0, 7, null)), false))), TuplesKt.to(5, new h(5, this.f440939i, new b.d(new f(0, 0L, 3, 0 == true ? 1 : 0)))));
        return mapOf;
    }

    public e(boolean z16, String str, List<g> list, List<a> list2, f fVar) {
        this.f440935d = z16;
        this.f440936e = str;
        this.f440937f = list;
        this.f440938h = list2;
        this.f440939i = fVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            this.f440935d = ((Boolean) obj).booleanValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f440936e = (String) obj;
            return;
        }
        if (i3 == 3) {
            List<g> list = this.f440937f;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.HeadConfig>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 4) {
            List<a> list2 = this.f440938h;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.BackgroundConfig>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.zplan.avatar_head_info.config.GlobalConfig");
            this.f440939i = (f) obj;
        }
    }
}
