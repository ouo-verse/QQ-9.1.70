package wi0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.router.api.IECRouterFilter;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.biz.hr.ECHRFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J8\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0015"}, d2 = {"Lwi0/a;", "Lcom/tencent/ecommerce/base/router/api/IECRouterFilter;", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "launcher", "Landroid/content/Context;", "packageContext", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "cls", "Landroid/os/Bundle;", "bundle", "", "filterLaunch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "filterLaunchForResult", "<init>", "()V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public class a implements IECRouterFilter {
    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean filterLaunch(IECRouterLauncher launcher, Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
        bundle.putString("hr_support_custom_back_pressed", "1");
        bundle.putString("page_name", "goods_center");
        launcher.launch(packageContext, ECHRFragment.class, bundle);
        return true;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean filterLaunchForResult(IECRouterLauncher launcher, Activity activity, int requestCode, Class<? extends Fragment> cls, Bundle bundle) {
        return true;
    }
}
