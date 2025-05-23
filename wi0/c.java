package wi0;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.QQECChannel;
import com.tencent.ecommerce.base.router.api.IECRouterFilter;
import com.tencent.ecommerce.base.router.api.IECRouterLauncher;
import com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterIntroFragment;
import com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo;
import com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterStatusCallback;
import com.tencent.ecommerce.repo.register.ECMsgBox;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006H\u0016J0\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J8\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0019"}, d2 = {"Lwi0/c;", "Lcom/tencent/ecommerce/base/router/api/IECRouterFilter;", "", WadlProxyConsts.CHANNEL, "", "b", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragment", "accept", "Lcom/tencent/ecommerce/base/router/api/IECRouterLauncher;", "launcher", "Landroid/content/Context;", "packageContext", "cls", "Landroid/os/Bundle;", "bundle", "filterLaunch", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "filterLaunchForResult", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class c implements IECRouterFilter {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"wi0/c$a", "Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterStatusCallback;", "", "isRegistered", "", "mediaID", "", "role", "Lcom/tencent/ecommerce/repo/register/ECMsgBox;", "msgBox", "", "onCheck", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes36.dex */
    public static final class a implements IECRegisterStatusCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f445691b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f445692c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f445693d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f445694e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ IECRouterLauncher f445695f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Context f445696g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Class f445697h;

        a(Bundle bundle, String str, String str2, String str3, IECRouterLauncher iECRouterLauncher, Context context, Class cls) {
            this.f445691b = bundle;
            this.f445692c = str;
            this.f445693d = str2;
            this.f445694e = str3;
            this.f445695f = iECRouterLauncher;
            this.f445696g = context;
            this.f445697h = cls;
        }

        @Override // com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterStatusCallback
        public void onCheck(boolean isRegistered, String mediaID, int role, ECMsgBox msgBox) {
            cg0.a.b("ECommerceRegisterIntroFragment", "checkRegister isRegistered = " + isRegistered + " mediaID = " + mediaID + " role = " + role);
            if (msgBox != null) {
                this.f445691b.putSerializable("msg_box", msgBox);
            }
            if (isRegistered) {
                if (!c.this.b(this.f445692c)) {
                    com.tencent.ecommerce.biz.register.refactoring.utils.b.b(com.tencent.ecommerce.biz.register.refactoring.utils.b.f104104a, this.f445693d, this.f445694e, null, 4, null);
                    return;
                }
                this.f445691b.putInt("register_role", role);
                this.f445691b.putBoolean("is_register", isRegistered);
                this.f445695f.launch(this.f445696g, this.f445697h, this.f445691b);
                return;
            }
            if (role == ECommerceRegisterIntroFragment.RoleType.ROLE_TYPE_OLD_MCN.ordinal()) {
                com.tencent.ecommerce.biz.register.refactoring.utils.b.f104104a.c(role, this.f445693d, this.f445694e);
                return;
            }
            if (role == ECommerceRegisterIntroFragment.RoleType.ROLE_TYPE_OLD_PERSONA.ordinal()) {
                com.tencent.ecommerce.biz.register.refactoring.utils.b.f104104a.c(role, this.f445693d, this.f445694e);
                return;
            }
            this.f445691b.putInt("register_role", role);
            this.f445691b.putBoolean("need_check_condition", true);
            this.f445691b.putBoolean("is_register", false);
            this.f445695f.launch(this.f445696g, this.f445697h, this.f445691b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(String channel) {
        return Intrinsics.areEqual(channel, String.valueOf(QQECChannel.CHANNEL_QQ_LITTLE_WORLD.ordinal())) || Intrinsics.areEqual(channel, String.valueOf(QQECChannel.CHANNEL_QQ_LIVE.ordinal()));
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean accept(Class<? extends Fragment> fragment) {
        return Intrinsics.areEqual(fragment, ECommerceRegisterIntroFragment.class);
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean filterLaunch(IECRouterLauncher launcher, Context packageContext, Class<? extends Fragment> cls, Bundle bundle) {
        String string = bundle.getString(WadlProxyConsts.CHANNEL);
        String str = string != null ? string : "";
        String string2 = bundle.getString("scheme_callback_id");
        String str2 = string2 != null ? string2 : "";
        String string3 = bundle.getString("jump_scheme");
        ECommerceRegisterRepo.f104099a.c(new a(bundle, str, new String(Base64.decode(string3 != null ? string3 : "", 0), StandardCharsets.UTF_8), str2, launcher, packageContext, cls));
        return true;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECRouterFilter
    public boolean filterLaunchForResult(IECRouterLauncher launcher, Activity activity, int requestCode, Class<? extends Fragment> cls, Bundle bundle) {
        return true;
    }
}
