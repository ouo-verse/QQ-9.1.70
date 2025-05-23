package t13;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.vas.VasTabFactory;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\r"}, d2 = {"Lt13/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "Lcom/tencent/mobileqq/vas/VasTabFactory$ABTest;", "a", "", "Z", "needPreload", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f435305a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean needPreload = true;

    a() {
    }

    @NotNull
    public final VasTabFactory.ABTest a() {
        if (MobileQQ.sMobileQQ.isLoginByNT()) {
            return VasTabFactory.ABTest.MISS;
        }
        Pair<VasTabFactory.ABTest, Map<String, String>> d16 = VasTabFactory.d("kenaiyu", "2024-11-15", "exp_register_page_add_lianghao_new", ABTestController.APPID_1504);
        if (needPreload && d16.getFirst().getIsExperiment()) {
            VasInjectApi.getInstance().preloadKuiklyBundle("vas_qqvip_lianghao", "vas_lianghao_home_page");
            needPreload = false;
        }
        return d16.getFirst();
    }

    public final void b(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(activity, ar.INSTANCE.b("kenaiyu", "2024-11-15", "vas_register_liang").getStringData("mqqapi://kuikly/open?version=1&src_type=app&qqmc_config=vas_kuikly_config&page_name=vas_lianghao_home_page&bundle_name=vas_qqvip_lianghao&kr_turbo_display=1&enteranceId=register"));
    }
}
