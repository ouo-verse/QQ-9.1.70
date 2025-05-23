package q03;

import com.tencent.mobileqq.config.am;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lq03/i;", "Lq03/c;", "Lxa1/d;", "f", "Lq03/f;", tl.h.F, "Lq03/b;", "e", "Lq03/d;", "g", "Lq03/e;", "d", "", "b", "Lq03/a;", "a", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final i f428160a = new i();

    i() {
    }

    private final xa1.d f() {
        Object x16 = am.s().x(854);
        Intrinsics.checkNotNullExpressionValue(x16, "getSingleton().loadConOb\u2026onfigProcessor.CONFIG_ID)");
        return (xa1.d) x16;
    }

    @Override // q03.c
    public a a() {
        return new g(f().getQZoneFeedsConfig());
    }

    @Override // q03.c
    public String b() {
        return f().getSquareMsgBoxConfigJson();
    }

    @Override // q03.c
    public String c() {
        return f().getSquarePerformanceConfigJson();
    }

    @Override // q03.c
    public e d() {
        return new k(f().getSquareConfig());
    }

    public b e() {
        return new h(f().getBadgeBrandRedDotConfig());
    }

    public d g() {
        return new j(f().getSmallHomeCallbackConfig());
    }

    public f h() {
        return new l(f().getWoTransitPageConfig());
    }
}
