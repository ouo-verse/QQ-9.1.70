package s35;

import c45.b;
import c45.d;
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
public final class z extends c45.j {
    public int C;
    public long D;

    /* renamed from: d, reason: collision with root package name */
    public int f433286d;

    /* renamed from: e, reason: collision with root package name */
    public int f433287e;

    /* renamed from: f, reason: collision with root package name */
    public String f433288f;

    /* renamed from: h, reason: collision with root package name */
    public t35.a f433289h;

    /* renamed from: i, reason: collision with root package name */
    public int f433290i;

    /* renamed from: m, reason: collision with root package name */
    public final List<String> f433291m;

    public z() {
        this(0, 0, null, null, 0, null, 0, 0L, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new z(0, 0, null, null, 0, null, 0, 0L, 255, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433286d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.TacitQuestionType }");
                this.f433287e = ((Integer) obj).intValue();
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f433288f = (String) obj;
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.tag.Tag");
                this.f433289h = (t35.a) obj;
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f433290i = ((Integer) obj).intValue();
                return;
            case 6:
                List<String> list = this.f433291m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info.Qqstranger_user_infoKt.TacitAnswerStatus }");
                this.C = ((Integer) obj).intValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.D = ((Long) obj).longValue();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ z(int i3, int i16, String str, t35.a aVar, int i17, List list, int i18, long j3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, r1.b().getValue(), "", null, 0, new ArrayList(), r1.b().getValue(), 0L);
        d.c.a aVar2 = d.c.f30317b;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f433286d), new b.e.h(false))), TuplesKt.to(2, new c45.h(2, Integer.valueOf(this.f433287e), new b.a(false))), TuplesKt.to(3, new c45.h(3, this.f433288f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f433289h, new b.d(new t35.a(0, null, 63)))), TuplesKt.to(5, new c45.h(5, Integer.valueOf(this.f433290i), new b.e.h(false))), TuplesKt.to(6, new c45.h(6, this.f433291m, new b.f(new b.e.g(false), false))), TuplesKt.to(7, new c45.h(7, Integer.valueOf(this.C), new b.a(false))), TuplesKt.to(8, new c45.h(8, Long.valueOf(this.D), new b.e.f(false))));
        return mapOf;
    }

    public z(int i3, int i16, String str, t35.a aVar, int i17, List<String> list, int i18, long j3) {
        this.f433286d = i3;
        this.f433287e = i16;
        this.f433288f = str;
        this.f433289h = aVar;
        this.f433290i = i17;
        this.f433291m = list;
        this.C = i18;
        this.D = j3;
    }
}
