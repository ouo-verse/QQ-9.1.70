package xj3;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vj3.b;
import vj3.d;
import vj3.e;
import wj3.ZPlanResHubPathParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016J(\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0016JN\u0010\u0018\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J2\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J(\u0010\u001c\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J(\u0010\u001d\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016\u00a8\u0006 "}, d2 = {"Lxj3/a;", "Lvj3/a;", "", "doWhenQQLogout", "", "forceInit", "f", "", "appId", com.heytap.mcssdk.a.a.f36102l, MosaicConstants$JsProperty.PROP_ENV, "Lcom/tencent/rdelivery/reshub/api/i;", "M", "Lvj3/d;", "listener", "i0", "resId", "Lwj3/b;", "savePath", "Lvj3/e;", "callback", "forceRequestLatest", "Lvj3/b;", "mobileDownloadHandler", "t0", "validateResFile", "Lcom/tencent/rdelivery/reshub/api/g;", "c", HippyTKDListViewAdapter.X, "w", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a implements vj3.a {
    @Override // vj3.a
    public i M(String appId, String appKey, String env) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        return yj3.a.f450500a.m(appId, appKey, env);
    }

    @Override // vj3.a
    public g c(String appId, String appKey, String env, String resId, boolean validateResFile) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        return yj3.a.f450500a.s(appId, appKey, env, resId, validateResFile);
    }

    @Override // vj3.a
    public void doWhenQQLogout() {
        yj3.a.f450500a.h();
    }

    @Override // vj3.a
    public void f(boolean forceInit) {
        yj3.a.f450500a.n(forceInit);
    }

    @Override // vj3.a
    public void i0(String appId, String appKey, String env, d listener) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(listener, "listener");
        yj3.a.f450500a.e(appId, appKey, env, listener);
    }

    @Override // vj3.a
    public void t0(String appId, String appKey, String env, String resId, ZPlanResHubPathParam savePath, e callback, boolean forceRequestLatest, b mobileDownloadHandler) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        yj3.a.f450500a.q(appId, appKey, env, resId, savePath, callback, forceRequestLatest, mobileDownloadHandler);
    }

    @Override // vj3.a
    public void w(String appId, String appKey, String env, String resId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        yj3.a.f450500a.f(appId, appKey, env, resId);
    }

    @Override // vj3.a
    public void x(String appId, String appKey, String env, String resId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(resId, "resId");
        yj3.a.f450500a.g(appId, appKey, env, resId);
    }
}
