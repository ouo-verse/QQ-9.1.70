package wi0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.router.api.IECRouterFilter;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.biz.detail.fragment.ECShopDetailDistributionFragment;
import com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailPageFragment;
import com.tencent.ecommerce.biz.hr.ECHRFragment;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016J0\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J8\u0010\u0014\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0017"}, d2 = {"Lwi0/e;", "Lcom/tencent/ecommerce/base/router/api/IECRouterFilter;", "", "a", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragment", "accept", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "launcher", "Landroid/content/Context;", "packageContext", "cls", "Landroid/os/Bundle;", "bundle", "filterLaunch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "filterLaunchForResult", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class e implements IECRouterFilter {
    private final boolean a() {
        int intValue = ((Number) com.tencent.ecommerce.base.config.service.b.f100655b.b(100307, "ktv_product_detail_enabled", 0)).intValue();
        cg0.a.b("ECommerceShopDetailFragmentFilter", "[checkIsKtvShopDetail] remoteConf = " + intValue);
        return intValue == 1;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean accept(Class<? extends Fragment> fragment) {
        if (Intrinsics.areEqual(fragment, ECShopDetailDistributionFragment.class) || Intrinsics.areEqual(fragment, ECShopProductDetailPageFragment.class)) {
            return a();
        }
        return false;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean filterLaunch(IECRouterLauncher launcher, Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
        String str;
        if (bundle.containsKey("half")) {
            str = String.valueOf(bundle.get("half"));
        } else {
            Object obj = com.tencent.ecommerce.base.ktx.a.a(bundle, "ext_userdata").getExtUserDataMap().get("half");
            if (!(obj instanceof String)) {
                obj = null;
            }
            str = (String) obj;
            if (str == null) {
                str = "";
            }
        }
        if (Intrinsics.areEqual(str, "1")) {
            bundle.putInt(KuiklyLaunchParams.PARAM_MODAL_MODE, 1);
        }
        bundle.putString("page_name", "product_detail");
        launcher.launch(packageContext, ECHRFragment.class, bundle);
        return true;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean filterLaunchForResult(IECRouterLauncher launcher, Activity activity, int requestCode, Class<? extends Fragment> cls, Bundle bundle) {
        return true;
    }
}
