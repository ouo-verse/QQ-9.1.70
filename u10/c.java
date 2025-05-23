package u10;

import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0003\u00a8\u0006\t"}, d2 = {"Lu10/c;", "", "", "b", "", "key", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f438053a = new c();

    c() {
    }

    @JvmStatic
    private static final String a(String key) {
        String str;
        Map<String, String> o16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().o();
        return (o16 == null || (str = o16.get(key)) == null) ? "" : str;
    }

    @JvmStatic
    public static final boolean b() {
        return Intrinsics.areEqual(a(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH), "1");
    }
}
