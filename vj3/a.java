package vj3;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqfeatureswitch.impl.ShiplyImpl;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import wj3.ZPlanResHubPathParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J&\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007H&J(\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH&JV\u0010\u0018\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J4\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0004H&J(\u0010\u001c\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&J(\u0010\u001d\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&\u00a8\u0006\u001e"}, d2 = {"Lvj3/a;", "Lvb3/b;", "", "doWhenQQLogout", "", "forceInit", "f", "", "appId", com.heytap.mcssdk.a.a.f36102l, MosaicConstants$JsProperty.PROP_ENV, "Lcom/tencent/rdelivery/reshub/api/i;", "M", "Lvj3/d;", "listener", "i0", "resId", "Lwj3/b;", "savePath", "Lvj3/e;", "callback", "forceRequestLatest", "Lvj3/b;", "mobileDownloadHandler", "t0", "validateResFile", "Lcom/tencent/rdelivery/reshub/api/g;", "c", HippyTKDListViewAdapter.X, "w", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public interface a extends vb3.b {
    i M(String appId, String appKey, String env);

    g c(String appId, String appKey, String env, String resId, boolean validateResFile);

    void doWhenQQLogout();

    void f(boolean forceInit);

    void i0(String appId, String appKey, String env, d listener);

    void t0(String appId, String appKey, String env, String resId, ZPlanResHubPathParam savePath, e callback, boolean forceRequestLatest, b mobileDownloadHandler);

    void w(String appId, String appKey, String env, String resId);

    void x(String appId, String appKey, String env, String resId);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: vj3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11422a {
        public static /* synthetic */ i b(a aVar, String str, String str2, String str3, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = ShiplyImpl.APP_ID;
                }
                if ((i3 & 2) != 0) {
                    str2 = ShiplyImpl.APP_KEY;
                }
                if ((i3 & 4) != 0) {
                    str3 = TPReportKeys.Common.COMMON_ONLINE;
                }
                return aVar.M(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preGetResHubWithAppId");
        }

        public static /* synthetic */ void a(a aVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = false;
                }
                aVar.f(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initResHubSDK");
        }

        public static /* synthetic */ g c(a aVar, String str, String str2, String str3, String str4, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    z16 = true;
                }
                return aVar.c(str, str2, str3, str4, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryResLocalVersion");
        }
    }
}
