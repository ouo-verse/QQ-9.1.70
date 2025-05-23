package uy;

import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\b\u00a8\u0006\u0012"}, d2 = {"Luy/a;", "", "", "key", "b", "default", "c", "bottomBarId", "", h.F, "f", "a", "selectedBarId", "g", "d", "e", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f440578a = new a();

    a() {
    }

    private final String b(String key) {
        return c(key, "");
    }

    private final String c(String key, String r36) {
        String str;
        Map<String, String> c16 = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().c();
        return (c16 == null || (str = c16.get(key)) == null) ? r36 : str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0030 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean h(String bottomBarId) {
        switch (bottomBarId.hashCode()) {
            case -1059699070:
                return bottomBarId.equals("my_tab");
            case -872770723:
                if (!bottomBarId.equals("message_tab")) {
                }
                break;
            case -710258968:
                if (!bottomBarId.equals("waterfall_tab")) {
                }
                break;
            case 194805079:
                if (bottomBarId.equals("monofeed_tab")) {
                }
                break;
        }
    }

    public final String a() {
        String c16 = c("selected_bar", "waterfall_tab");
        return (!h(c16) || g(c16)) ? "waterfall_tab" : c16;
    }

    public final boolean d() {
        return Intrinsics.areEqual(a(), "monofeed_tab");
    }

    public final boolean e() {
        return Intrinsics.areEqual(a(), "waterfall_tab");
    }

    public final boolean f() {
        return Intrinsics.areEqual("1", b(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH));
    }

    public final boolean g(String selectedBarId) {
        WSRedDotPushMsg z16 = bb.z();
        return com.tencent.biz.pubaccount.weishi.push.c.b(z16) ? (Intrinsics.areEqual(selectedBarId, "waterfall_tab") || Intrinsics.areEqual(selectedBarId, "monofeed_tab")) ? false : true : com.tencent.biz.pubaccount.weishi.push.c.a(z16) || com.tencent.biz.pubaccount.weishi.push.c.c(z16) || Intrinsics.areEqual(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_open_home_then_video");
    }
}
