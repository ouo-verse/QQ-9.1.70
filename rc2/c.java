package rc2;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService;
import com.tencent.mobileqq.onlinestatus.utils.f;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import eipc.EIPCResult;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static volatile c f431045d;

    public c(String str) {
        super(str);
    }

    public static c d() {
        if (f431045d == null) {
            synchronized (c.class) {
                if (f431045d == null) {
                    f431045d = new c("TencentVideoStatusQIPCModule");
                }
            }
        }
        return f431045d;
    }

    private void e(AppRuntime appRuntime, int i3) {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar;
        long j3;
        String str;
        String currentUid = appRuntime.getCurrentUid();
        if (!TextUtils.isEmpty(currentUid)) {
            cVar = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(currentUid, "TencentVideoStatusQIPCModule");
        } else {
            cVar = null;
        }
        if (cVar != null) {
            j3 = cVar.e0();
        } else {
            j3 = 0;
        }
        if (cVar != null) {
            str = cVar.g0();
        } else {
            str = "";
        }
        EIPCResult eIPCResult = new EIPCResult();
        eIPCResult.code = 0;
        Bundle bundle = new Bundle();
        bundle.putLong(IOnlineStatusMiniService.ONLINE_STATE, j3);
        bundle.putString("cid", str);
        eIPCResult.data = bundle;
        callbackResult(i3, eIPCResult);
    }

    private void f(AppRuntime appRuntime, Bundle bundle, final int i3) {
        try {
            ((IOnlineStatusMiniService) appRuntime.getRuntimeService(IOnlineStatusMiniService.class, "all")).setTencentVideoStatus((AppInterface) appRuntime, bundle.getString("cid"), bundle.getString("url"), f.b(AppRuntime.Status.online, 1021L, bundle), new IOnlineStatusMiniService.b() { // from class: rc2.a
                @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService.b
                public final void a(boolean z16) {
                    c.this.g(i3, z16);
                }
            });
        } catch (Exception e16) {
            QLog.e("TencentVideoStatusQIPCModule", 1, "handleSetOnlineStatus: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i3, boolean z16) {
        int i16;
        EIPCResult eIPCResult = new EIPCResult();
        if (z16) {
            i16 = 0;
        } else {
            i16 = -102;
        }
        eIPCResult.code = i16;
        callbackResult(i3, eIPCResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(int i3, String str) {
        Bundle bundle = new Bundle();
        EIPCResult eIPCResult = new EIPCResult();
        if (str != null) {
            bundle.putString(IOnlineStatusMiniService.VIDEO_NAME, str);
            eIPCResult.code = 0;
        } else {
            eIPCResult.code = -102;
        }
        eIPCResult.data = bundle;
        callbackResult(i3, eIPCResult);
    }

    private void i(AppRuntime appRuntime, Bundle bundle, final int i3) {
        try {
            ((IOnlineStatusMiniService) appRuntime.getRuntimeService(IOnlineStatusMiniService.class, "all")).sendReqToGetVideoName(bundle.getString("cid"), new y.f() { // from class: rc2.b
                @Override // com.tencent.mobileqq.onlinestatus.y.f
                public final void a(String str) {
                    c.this.h(i3, str);
                }
            });
        } catch (Exception e16) {
            QLog.e("TencentVideoStatusQIPCModule", 1, "handleSetOnlineStatus: " + e16);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        QLog.d("TencentVideoStatusQIPCModule", 1, "action: " + str);
        if ("ACTION_SHOW_ONLINE_STATUS_POPUPWINDOW".equals(str)) {
            i(waitAppRuntime, bundle, i3);
        } else if ("ACTION_SET_ONLINE_STATUS_MAIN".equals(str)) {
            f(waitAppRuntime, bundle, i3);
        } else if ("ACTION_GET_ONLINE_STATUS_MAIN".equals(str)) {
            e(waitAppRuntime, i3);
        }
        return null;
    }
}
