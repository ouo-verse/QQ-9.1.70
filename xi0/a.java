package xi0;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0013B\u0017\u0012\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J0\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J*\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004H\u0016R\u001c\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lxi0/a;", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "Landroid/content/Context;", "packageContext", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "cls", "Landroid/os/Bundle;", "bundle", "", "launch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "launchForResult", "Landroid/content/Intent;", "getIntent", "launchFragmentClz", "a", "Ljava/lang/Class;", "fragmentClz", "<init>", "(Ljava/lang/Class;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a implements IECRouterLauncher {

    /* renamed from: b, reason: collision with root package name */
    private static IECRouterLauncher f448011b;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Class<? extends Fragment> fragmentClz;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R.\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lxi0/a$a;", "", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "proxy", "", "b", "(Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;)V", "<set-?>", "launcherProxy", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "a", "()Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: xi0.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        Companion() {
        }

        private final void c(IECRouterLauncher iECRouterLauncher) {
            a.f448011b = iECRouterLauncher;
        }

        public final IECRouterLauncher a() {
            return a.f448011b;
        }

        public final void b(IECRouterLauncher proxy) {
            c(proxy);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(Class<? extends Fragment> cls) {
        this.fragmentClz = cls;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public Intent getIntent(Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
        IECRouterLauncher iECRouterLauncher = f448011b;
        if (iECRouterLauncher == null) {
            cg0.a.a("ECBaseRouterLauncher", "getIntent", "[getIntent] proxy is not register!");
            return null;
        }
        if (iECRouterLauncher != null) {
            return iECRouterLauncher.getIntent(packageContext, cls, bundle);
        }
        return null;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public boolean launch(Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
        IECRouterLauncher iECRouterLauncher = f448011b;
        if (iECRouterLauncher == null) {
            cg0.a.a("ECBaseRouterLauncher", "launch", "[launch] proxy is not register!");
            return false;
        }
        if (iECRouterLauncher == null) {
            return true;
        }
        iECRouterLauncher.launch(packageContext, cls, bundle);
        return true;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public boolean launchForResult(Activity activity, int requestCode, Class<? extends Fragment> cls, Bundle bundle) {
        IECRouterLauncher iECRouterLauncher = f448011b;
        if (iECRouterLauncher == null) {
            cg0.a.a("ECBaseRouterLauncher", "launchForResult", "[launch] proxy is not register!");
            return false;
        }
        if (iECRouterLauncher == null) {
            return true;
        }
        iECRouterLauncher.launchForResult(activity, requestCode, cls, bundle);
        return true;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterLauncher
    public Class<? extends Fragment> launchFragmentClz() {
        return this.fragmentClz;
    }
}
