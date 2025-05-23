package xz;

import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0007R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lxz/b;", "", "", "key", "a", "", "c", "", "b", "Z", "d", "()Z", "e", "(Z)V", "isShowedGuide", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f449122a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowedGuide;

    b() {
    }

    private final String a(String key) {
        String str;
        Map<String, String> g16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().g();
        return (g16 == null || (str = g16.get(key)) == null) ? "" : str;
    }

    public final int b() {
        return bb.Y(a("show_times"), 0);
    }

    public final boolean c() {
        return Intrinsics.areEqual("1", a(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public final boolean d() {
        return isShowedGuide;
    }

    public final void e(boolean z16) {
        isShowedGuide = z16;
    }
}
