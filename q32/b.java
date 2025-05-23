package q32;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Landroid/content/Context;", "activityContext", "", "c", "", "source", "", "b", "e", "d", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "a", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "logger", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final IAegisLogApi f428297a;

    static {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        f428297a = (IAegisLogApi) api;
    }

    public static final boolean b(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            long parseLong = Long.parseLong(source);
            if (300001 > parseLong || parseLong >= 300100) {
                return false;
            }
            return true;
        } catch (NumberFormatException e16) {
            f428297a.a("ICliveHallUtil", "source can not format as long value! " + e16);
            return false;
        }
    }

    public static final void c(@NotNull Context activityContext) {
        Intrinsics.checkNotNullParameter(activityContext, "activityContext");
        if (((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).isSwitchOn(ICGameQMCCConfigKeysKt.KEY_ICGAME_ENABLE_MINI_APP_LANDING_PAGE, false)) {
            e(activityContext);
        } else {
            d(activityContext);
        }
    }

    private static final void d(Context context) {
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", "https://now.qq.com/cos/activity/cloud-games/index.html?_wv=16777218&_wwv=8192");
        intent.putExtra("hide_more_button", true);
        intent.setFlags(67108864);
        context.startActivity(intent);
    }

    private static final void e(Context context) {
        final long currentTimeMillis = System.currentTimeMillis();
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, "mqqapi://miniapp/open?_atype=0&_mappid=1112222915&_miniapptype=1&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2014&via=qq_hdy&_sig=1077149078", LaunchScene.LAUNCH_SCENE_ICGAME_LANDING_PAGE, new MiniAppLaunchListener() { // from class: q32.a
            @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
            public final void onLaunchResult(boolean z16, Bundle bundle) {
                b.f(currentTimeMillis, z16, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(long j3, boolean z16, Bundle bundle) {
        f428297a.i("ICliveHallUtil", "launch app cost:" + (System.currentTimeMillis() - j3));
    }
}
