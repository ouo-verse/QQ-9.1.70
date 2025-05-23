package ql0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameDLService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g implements a {
    private String[] d() {
        String readFromSp = GameCenterSpUtils.readFromSp("VM_DELAY_LIST");
        QLog.i("WadlVMDownload", 1, "getDelayAppIds delayAppIdStr=" + readFromSp);
        if (TextUtils.isEmpty(readFromSp)) {
            return null;
        }
        return readFromSp.split("\\|");
    }

    private void e(String str) {
        QLog.i("WadlVMDownload", 1, "removeDetailInfo appId=" + str);
        GameCenterUtil.deleteAppidFromList(str, "VM_DELAY_LIST");
        GameCenterUtil.delAppDetail(str, "VM_DELAY_APPID_DETAIL_");
    }

    private void f(String str, int i3, boolean z16) {
        QLog.i("WadlVMDownload", 1, "startDownload paramsJson=" + str + MttLoader.QQBROWSER_PARAMS_FROME + i3 + ",isWifi=" + NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ) + ", isKingCardAuthority=" + z16);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            WadlParams wadlParams = new WadlParams(str);
            wadlParams.actionCode = 2;
            wadlParams.downloadType = 2;
            wadlParams.from = i3;
            IQQGameDLService iQQGameDLService = (IQQGameDLService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameDLService.class, ProcessConstant.MULTI);
            if (iQQGameDLService != null) {
                iQQGameDLService.doDownloadAction(3, wadlParams);
            }
        } catch (Exception e16) {
            QLog.e("WadlVMDownload", 1, "startDownload exception", e16);
        }
    }

    @Override // ql0.a
    public void a(@NonNull com.tencent.gamecenter.wadl.biz.entity.g gVar) {
        if (!gVar.f106806s) {
            QLog.d("WadlVMDownload", 1, "checkPreDownload isDelayDownload off");
            return;
        }
        int d16 = e.d();
        if (!e.b(d16)) {
            QLog.d("WadlVMDownload", 1, "checkPreDownload abort, devicesStatus=" + d16);
            return;
        }
        String[] d17 = d();
        if (d17 != null && d17.length >= 1) {
            GameCenterSpUtils.writeToSp("VM_DELAY_LIST", "");
            for (String str : d17) {
                String readFromSp = GameCenterSpUtils.readFromSp("VM_DELAY_APPID_DETAIL_" + str);
                try {
                    if (e.e(str, new JSONObject(readFromSp).optString("packageName", "")).second.intValue() != 2) {
                        f(readFromSp, 2, false);
                    } else {
                        e(str);
                    }
                } catch (Exception e16) {
                    QLog.e("WadlVMDownload", 1, "checkPreDownload exception", e16);
                }
            }
            return;
        }
        QLog.d("WadlVMDownload", 1, "checkPreDownload abort, delayAppIds is empty");
    }

    @Override // ql0.a
    public void b(@NonNull WadlParams wadlParams) {
        e(wadlParams.appId);
    }

    @Override // ql0.a
    public boolean c() {
        return !TextUtils.isEmpty(GameCenterSpUtils.readFromSp("VM_DELAY_LIST"));
    }

    @Override // ql0.a
    public void onDestroy() {
        QLog.i("WadlVMDownload", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }
}
