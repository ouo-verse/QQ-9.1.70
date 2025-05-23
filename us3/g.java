package us3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.proxy.MiniBoxHostEventProcessor;
import com.tencent.qq.minibox.ui.PermissionsInfoFragment;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J<\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nJ\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006J2\u0010!\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u001f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006$"}, d2 = {"Lus3/g;", "", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "", "b", "", VirtualAppProxy.KEY_GAME_ID, "packageName", "appName", "", "versionCode", "iconUrl", "apkUrl", "c", "pid", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, tl.h.F, "appId", "f", "pName", "i", "e", "Landroid/content/Context;", "context", "permissions", "g", DTConstants.TAG.API, "params", "", "isAsync", "a", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f439986a = new g();

    g() {
    }

    private final void b(Promise promise) {
        if (promise != null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("result", -2);
            hippyMap.pushString("errorMsg", "notify client error");
            promise.resolve(hippyMap);
        }
    }

    public final void a(int pid, @NotNull String api, @Nullable String params, boolean isAsync, @Nullable Promise promise) {
        String str;
        Intrinsics.checkNotNullParameter(api, "api");
        QLog.d("MiniBoxAppHelper", 2, "callMcMethod pid:" + pid + ", api:" + api + ", params:" + params + ", isAsync:" + isAsync);
        MiniBoxHostEventProcessor miniBoxHostEventProcessor = MiniBoxHostEventProcessor.f344586a;
        if (!miniBoxHostEventProcessor.w()) {
            if (promise != null) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("code", -1);
                hippyMap.pushString("errorMsg", "channel not ready");
                promise.resolve(hippyMap);
                return;
            }
            return;
        }
        if (promise != null) {
            miniBoxHostEventProcessor.e(api, promise);
        }
        Bundle bundle = new Bundle();
        bundle.putString("minibox_client_key_common_call_api", api);
        bundle.putString("minibox_client_key_common_call_params", params);
        if (!isAsync) {
            str = "minibox_call_mc";
        } else {
            str = "minibox_call_mc_with_observer";
        }
        if (!MiniBoxSDK.notifyClient(pid, str, bundle)) {
            b(promise);
        }
    }

    public final void c(@NotNull String gameId, @NotNull String packageName, @Nullable String appName, int versionCode, @Nullable String iconUrl, @Nullable String apkUrl) {
        IQQGameDLService iQQGameDLService;
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iQQGameDLService = (IQQGameDLService) peekAppRuntime.getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
        } else {
            iQQGameDLService = null;
        }
        if (iQQGameDLService == null) {
            QLog.e("MiniBoxAppHelper", 1, "downloadAndInstall: IQQGameDLService get null.");
            return;
        }
        WadlParams wadlParams = new WadlParams(gameId, packageName);
        wadlParams.actionCode = 2;
        wadlParams.appName = appName;
        wadlParams.versionCode = versionCode;
        wadlParams.iconUrl = iconUrl;
        wadlParams.apkUrl = apkUrl;
        iQQGameDLService.doDownloadAction(1, wadlParams);
    }

    public final void d(int pid) {
        if (!MiniBoxSDK.notifyClient(pid, "minibox_client_virtual_game", null)) {
            SystemMethodProxy.killProcess(pid);
        }
    }

    public final void e(int pid, @NotNull String appId, @Nullable Promise promise) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (promise == null) {
            return;
        }
        MiniBoxHostEventProcessor.f344586a.e("mimibox_get_user_time_info", promise);
        if (!MiniBoxSDK.notifyClient(pid, "mimibox_get_user_time_info", null)) {
            b(promise);
        }
    }

    public final void f(int pid, @NotNull String appId, @Nullable Promise promise) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (promise == null) {
            return;
        }
        MiniBoxHostEventProcessor.f344586a.e("minibox_get_resolution", promise);
        if (!MiniBoxSDK.notifyClient(pid, "minibox_get_resolution", null)) {
            b(promise);
        }
    }

    public final void g(@NotNull Context context, @NotNull String permissions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intent intent = new Intent();
        intent.putExtra("key_permissions", permissions);
        QPublicFragmentActivity.start(context, intent, PermissionsInfoFragment.class);
    }

    public final void h(int pid, @Nullable Activity activity, @Nullable Promise promise) {
        if (activity == null) {
            return;
        }
        if (MiniBoxHostEventProcessor.f344586a.w()) {
            if (!MiniBoxSDK.notifyClient(pid, "minibox_restart_client", null)) {
                b(promise);
            }
            activity.finish();
            return;
        }
        QQToast.makeText(activity, 0, "\u4e91\u6e38\u620f\u672a\u542f\u52a8\u5b8c\u6210\uff0c\u65e0\u6cd5\u4e3a\u4f60\u91cd\u542f\u6e38\u620f", 0).show();
    }

    public final void i(int pid, @NotNull String appId, @NotNull String pName, @Nullable Promise promise) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pName, "pName");
        Bundle bundle = new Bundle();
        bundle.putString("minibox_client_key_resolution", pName);
        if (!MiniBoxSDK.notifyClient(pid, "minibox_set_resolution", bundle)) {
            b(promise);
        }
    }
}
