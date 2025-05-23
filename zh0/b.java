package zh0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import java.net.URLDecoder;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"Lzh0/b;", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "Landroid/content/Context;", "packageContext", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "cls", "Landroid/os/Bundle;", "bundle", "", "launch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "launchForResult", "Landroid/content/Intent;", "getIntent", "launchFragmentClz", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class b implements IECRouterLauncher {

    /* renamed from: a, reason: collision with root package name */
    public static final b f452542a = new b();

    b() {
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public Intent getIntent(Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
        return new Intent();
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public boolean launch(Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
        String string = bundle.getString(TuxDialogBundleKey.WEB_URL);
        cg0.a.b("ECWebFloatRouterLauncher", "launch " + string);
        if (string == null || string.length() == 0) {
            return false;
        }
        ECScheme.e(URLDecoder.decode(string, "UTF-8") + "&ecwebview_type=slide_float", com.tencent.ecommerce.base.ktx.a.a(bundle, "ext_userdata").getExtUserDataMap());
        return true;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public boolean launchForResult(Activity activity, int requestCode, Class<? extends Fragment> cls, Bundle bundle) {
        return launch(activity, cls, bundle);
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public Class<? extends Fragment> launchFragmentClz() {
        return ECBaseFragment.class;
    }
}
