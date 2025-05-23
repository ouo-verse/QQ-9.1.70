package ue2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\nH\u0016J0\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0019"}, d2 = {"Lue2/e;", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher;", "", "canOpenQQMiniApp", "Landroid/content/Context;", "context", "", "appId", "path", "version", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$LaunchListener;", "listener", "", "launchQQMinAppByAppId", QZoneDTLoginReporter.SCHEMA, "miniAppListener", "launchQQMiniAppByUrl", "userName", "launchWxMiniApp", "Lcom/tencent/ecommerce/base/miniapp/api/IECMiniAppLauncher$MiniAppType;", "type", "preloadMiniApp", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e implements IECMiniAppLauncher {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f438877a;

        static {
            int[] iArr = new int[IECMiniAppLauncher.MiniAppType.values().length];
            try {
                iArr[IECMiniAppLauncher.MiniAppType.QQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IECMiniAppLauncher.MiniAppType.WX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IECMiniAppLauncher.MiniAppType.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f438877a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(IECMiniAppLauncher.LaunchListener listener, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onLaunchResult(z16, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(IECMiniAppLauncher.LaunchListener miniAppListener, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(miniAppListener, "$miniAppListener");
        miniAppListener.onLaunchResult(z16, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(IECMiniAppLauncher.LaunchListener listener, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onLaunchResult(z16, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(IECMiniAppLauncher.LaunchListener listener, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onLaunchResult(z16, bundle);
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public boolean canOpenQQMiniApp() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_KEY_CAN_OPEN_APP, 1) == 1;
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void launchQQMinAppByAppId(Context context, String appId, String path, String version, final IECMiniAppLauncher.LaunchListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!(appId.length() == 0)) {
            if (!(path.length() == 0)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(context, appId, path, version, 2016, new MiniAppLaunchListener() { // from class: ue2.a
                    @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                    public final void onLaunchResult(boolean z16, Bundle bundle) {
                        e.e(IECMiniAppLauncher.LaunchListener.this, z16, bundle);
                    }
                });
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putLong("retCode", -1L);
        bundle.putString("errMsg", "params appId or path can not be empty, current appId:" + appId + " and path:" + path);
        Unit unit = Unit.INSTANCE;
        listener.onLaunchResult(false, bundle);
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void launchQQMiniAppByUrl(Context context, String schema, final IECMiniAppLauncher.LaunchListener miniAppListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, "schema");
        Intrinsics.checkNotNullParameter(miniAppListener, "miniAppListener");
        if (TextUtils.isEmpty(schema)) {
            return;
        }
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, schema, 2016, new MiniAppLaunchListener() { // from class: ue2.b
            @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
            public final void onLaunchResult(boolean z16, Bundle bundle) {
                e.f(IECMiniAppLauncher.LaunchListener.this, z16, bundle);
            }
        });
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void launchWxMiniApp(Context context, String appId, String userName, String path, final IECMiniAppLauncher.LaunchListener listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (appId.length() == 0) {
            if (userName.length() == 0) {
                Bundle bundle = new Bundle();
                bundle.putLong("retCode", -1L);
                bundle.putString("errMsg", "params appId and userName can not be empty at same time");
                Unit unit = Unit.INSTANCE;
                listener.onLaunchResult(false, bundle);
                return;
            }
        }
        if (path.length() == 0) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("retCode", -1L);
            bundle2.putString("errMsg", "params path can not be empty");
            Unit unit2 = Unit.INSTANCE;
            listener.onLaunchResult(false, bundle2);
            return;
        }
        if (appId.length() > 0) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppIdWithCallback(context, appId, path, 2016, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: ue2.c
                @Override // com.tencent.mobileqq.wxmini.api.data.b
                public final void onCallback(boolean z16, Bundle bundle3) {
                    e.g(IECMiniAppLauncher.LaunchListener.this, z16, bundle3);
                }
            });
        } else {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByUsernameWithCallback(appId, path, 2016, null, new com.tencent.mobileqq.wxmini.api.data.b() { // from class: ue2.d
                @Override // com.tencent.mobileqq.wxmini.api.data.b
                public final void onCallback(boolean z16, Bundle bundle3) {
                    e.h(IECMiniAppLauncher.LaunchListener.this, z16, bundle3);
                }
            });
        }
    }

    @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher
    public void preloadMiniApp(IECMiniAppLauncher.MiniAppType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i3 = b.f438877a[type.ordinal()];
        if (i3 == 1) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).preloadMiniAppOnce();
            return;
        }
        if (i3 == 2) {
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).loadDynamicPackage(null);
        } else {
            if (i3 != 3) {
                return;
            }
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).preloadMiniAppOnce();
            ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).loadDynamicPackage(null);
        }
    }
}
