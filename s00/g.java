package s00;

import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0017\u001a\u00020\u0016\u00a8\u0006\u001a"}, d2 = {"Ls00/g;", "", "", "key", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", h.F, "p", "", "k", "l", "i", "j", "", "a", "c", "b", "d", "f", "g", DomainData.DOMAIN_NAME, "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f433061a = new g();

    g() {
    }

    private final String q(String key) {
        String str;
        Map<String, String> z16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().z();
        return (z16 == null || (str = z16.get(key)) == null) ? "" : str;
    }

    public final boolean a() {
        return Intrinsics.areEqual("1", q("downloader_p2p_enable"));
    }

    public final boolean b() {
        return Intrinsics.areEqual("1", q("preloader_p2p_enable"));
    }

    public final boolean c() {
        return Intrinsics.areEqual("1", q("downloader_pcdn_enable"));
    }

    public final boolean d() {
        return Intrinsics.areEqual("1", q("preloader_pcdn_enable"));
    }

    public final String e() {
        boolean isBlank;
        String q16 = q("buffer_time_for_unpeak");
        isBlank = StringsKt__StringsJVMKt.isBlank(q16);
        return isBlank ? "10,30" : q16;
    }

    public final int f() {
        return bb.Y(q("downloader_pcdn_min_buff_time"), 3);
    }

    public final int g() {
        return bb.Y(q("downloader_pcdn_protect_buff_time"), 5);
    }

    public final String h() {
        boolean isBlank;
        String q16 = q("emergency_time");
        isBlank = StringsKt__StringsJVMKt.isBlank(q16);
        return isBlank ? "1,5|0,10" : q16;
    }

    public final String i() {
        boolean isBlank;
        String q16 = q("peak_period");
        isBlank = StringsKt__StringsJVMKt.isBlank(q16);
        return isBlank ? "20:00,22:00" : q16;
    }

    public final String j() {
        boolean isBlank;
        String q16 = q("peak_period_weekend");
        isBlank = StringsKt__StringsJVMKt.isBlank(q16);
        return isBlank ? "14:00,15:30|17:05,18:20|20:10,22:00" : q16;
    }

    public final int k() {
        return bb.Y(q("preload_time"), 3);
    }

    public final int l() {
        return bb.Y(q("preload_time_for_unpeak"), -1);
    }

    public final long m() {
        int Y;
        if (d() && b()) {
            Y = bb.Y(q("preloader_duration_pcdn_on"), 2);
        } else {
            Y = bb.Y(q("preloader_duration_pcdn_off"), 2);
        }
        return Y * 1000;
    }

    public final int n() {
        return bb.Y(q("preloader_pcdn_min_buff_time"), 3);
    }

    public final int o() {
        return bb.Y(q("preloader_pcdn_protect_buff_time"), 5);
    }

    public final String p() {
        boolean isBlank;
        String q16 = q("safe_play_time");
        isBlank = StringsKt__StringsJVMKt.isBlank(q16);
        return isBlank ? "1,10|0,30" : q16;
    }
}
