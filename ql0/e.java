package ql0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e {
    public static boolean a(String... strArr) {
        if (strArr == null || strArr.length < 1) {
            return false;
        }
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(int i3) {
        if (f(i3, 1) && f(i3, 2)) {
            return true;
        }
        return false;
    }

    public static int c(JSONArray jSONArray, String str) {
        int length;
        if (jSONArray == null || (length = jSONArray.length()) <= 0) {
            return -1;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(jSONArray.optJSONObject(i3).optString("appId"))) {
                return i3;
            }
        }
        return -1;
    }

    public static int d() {
        int i3;
        JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF);
        int i16 = 2;
        if (configJsonObj != null) {
            i16 = configJsonObj.optInt("auto_download_min_power", 2);
        }
        if (GameCenterBroadcastReceiver.f106854h < i16 && !GameCenterBroadcastReceiver.f106855i) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        String str = MobileQQ.QQ_PACKAGE_NAME;
        if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
            return i3 | 2;
        }
        return i3;
    }

    public static Pair<String, Integer> e(String str, String str2) {
        Pair<String, Integer> pair = new Pair<>(str, 0);
        if (TextUtils.isEmpty(str)) {
            return pair;
        }
        int i3 = 1;
        if (GameCenterUtil.getPackageInfo(str2) == null) {
            QLog.i("WadlPreDownloadUtil", 1, str + ",packageName=" + str2 + " no installed");
            return pair;
        }
        boolean isExistMiniApp = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).isExistMiniApp(str2);
        QLog.i("WadlPreDownloadUtil", 1, str + ",packageName=" + str2 + " installed,isMiniApp=" + isExistMiniApp);
        if (!isExistMiniApp) {
            i3 = 2;
        }
        return new Pair<>(str, Integer.valueOf(i3));
    }

    public static boolean f(int i3, int i16) {
        if ((i3 & i16) == i16) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(String str, int i3, boolean z16) {
        boolean z17;
        boolean z18;
        JSONObject jSONObject;
        String[] strArr;
        int readFromSpInt;
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAME_INSTALL_CHANNEL_CONFIG, "");
        long j3 = 0;
        if (!TextUtils.isEmpty(loadAsString)) {
            try {
                jSONObject = new JSONObject(loadAsString);
                z17 = jSONObject.optBoolean("autoDownloadAppIdExpireSwith", false);
            } catch (JSONException e16) {
                e = e16;
                z17 = false;
            }
            try {
                j3 = jSONObject.optLong("autoDownloadAppIdExpireTime", 1209600L);
                z18 = jSONObject.optBoolean("autoDownloadCheckVersionSwith", false);
            } catch (JSONException e17) {
                e = e17;
                QLog.e("WadlPreDownloadUtil", 1, "isDownloadedAppId config exception", e);
                z18 = false;
                QLog.d("WadlPreDownloadUtil", 1, "isDownloadedAppId appId=" + str + " expireSwitchOn=" + z17 + ",expireTime=" + j3 + ",checkVersionSwitch=" + z18 + ",currVer=" + i3 + ",isFromYY=" + z16);
                if (z18) {
                    readFromSpInt = GameCenterSpUtils.readFromSpInt("QQGAME_DOWNLOADED_VERSION_APPID_" + str);
                    QLog.d("WadlPreDownloadUtil", 1, "isDownloadedAppId currVer=" + i3 + ",lastDownloadVer=" + readFromSpInt);
                    if (readFromSpInt > 0) {
                    }
                }
                if (z16) {
                }
            }
        } else {
            z17 = false;
            z18 = false;
        }
        QLog.d("WadlPreDownloadUtil", 1, "isDownloadedAppId appId=" + str + " expireSwitchOn=" + z17 + ",expireTime=" + j3 + ",checkVersionSwitch=" + z18 + ",currVer=" + i3 + ",isFromYY=" + z16);
        if (z18 && i3 > 0) {
            readFromSpInt = GameCenterSpUtils.readFromSpInt("QQGAME_DOWNLOADED_VERSION_APPID_" + str);
            QLog.d("WadlPreDownloadUtil", 1, "isDownloadedAppId currVer=" + i3 + ",lastDownloadVer=" + readFromSpInt);
            if (readFromSpInt > 0) {
                if (readFromSpInt >= i3) {
                    return true;
                }
                return false;
            }
        }
        if (z16) {
            return false;
        }
        if (z17) {
            long readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_DOWNLOADED_TIME_APPID_" + str);
            QLog.d("WadlPreDownloadUtil", 1, "isDownloadedAppId lastTime=" + readFromSpLong);
            if (readFromSpLong >= 1 && NetConnInfoCenter.getServerTime() < readFromSpLong + j3) {
                return true;
            }
            return false;
        }
        String readFromSp = GameCenterSpUtils.readFromSp("QQGAME_DOWNLOAD_LIST");
        QLog.d("WadlPreDownloadUtil", 1, "isDownloadedAppId downloadedAppidsStr=" + readFromSp);
        if (readFromSp != null) {
            strArr = readFromSp.split("\\|");
        } else {
            strArr = null;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean h() {
        IQQGameNoticeService iQQGameNoticeService = (IQQGameNoticeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameNoticeService.class, "");
        if (iQQGameNoticeService != null) {
            return iQQGameNoticeService.isShowKeepView();
        }
        return false;
    }

    public static WadlParams i(@NonNull JSONObject jSONObject, int i3) {
        WadlParams wadlParams = new WadlParams(jSONObject.optString("appId"), jSONObject.optString("packageName"));
        wadlParams.iconUrl = jSONObject.optString("iconUrl", "");
        wadlParams.apkChannel = jSONObject.optString("apkChannel", WadlProxyConsts.APP_CHANNEL_GAMECENTER);
        wadlParams.appName = jSONObject.optString("appName");
        wadlParams.apkUrl = jSONObject.optString("apkUrl");
        wadlParams.versionCode = jSONObject.optInt("versionCode");
        wadlParams.downloadType = i3;
        if (i3 == 2) {
            wadlParams.actionCode = 2;
            wadlParams.from = 1;
            wadlParams.via = WadlProxyConsts.VIA_AUTO_DOWNLOAD;
        } else {
            wadlParams.actionCode = 12;
            wadlParams.from = 3;
            wadlParams.via = WadlProxyConsts.VIA_AUTO_UPDATE;
        }
        return wadlParams;
    }

    public static void j(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GameCenterUtil.addAppidToList(str, "QQGAME_DOWNLOAD_LIST");
        if (i3 < 1) {
            return;
        }
        GameCenterSpUtils.writeToSpLong("QQGAME_DOWNLOADED_TIME_APPID_" + str, NetConnInfoCenter.getServerTime());
        GameCenterSpUtils.writeToSpInt("QQGAME_DOWNLOADED_VERSION_APPID_" + str, i3);
    }

    public static void k(boolean z16, int i3, @NonNull WadlParams wadlParams, @NonNull com.tencent.gamecenter.wadl.biz.entity.a aVar) {
        boolean f16 = f(i3, 1);
        boolean f17 = f(i3, 2);
        boolean isKingCard = ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard();
        if (z16) {
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onPreAutoDownloadCheck(wadlParams.appId, wadlParams.packageName, wadlParams.appName, wadlParams.versionCode, f17, f16, aVar.f106749d, isKingCard, aVar.f106748c);
        } else {
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onPreAutoUpdateCheck(wadlParams.appId, wadlParams.packageName, wadlParams.appName, wadlParams.versionCode, f17, f16, aVar.f106749d, isKingCard, aVar.f106748c);
        }
    }

    public static boolean l(String str, int i3, boolean z16, boolean z17) {
        String str2;
        WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_GAMECENTER).setOperId(WadlProxyConsts.OPER_ID_AUTO_DOWNLOAD_REASON).setGameAppId(str).setExt(1, WadlProxyConsts.MOUDLE_TYPE_GAMECENTER).setExt(11, "4").setExt(12, WadlProxyConsts.PAGE_ID_GAMECENTER);
        String str3 = "1";
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        WadlReportBuilder ext2 = ext.setExt(18, str2);
        if (!z17) {
            str3 = "0";
        }
        ext2.setExt(19, str3).setExt(3, String.valueOf(i3)).report();
        return true;
    }

    public static void m(String str) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("426").setOperId(WadlProxyConsts.OPER_ID_PREDOWNLOAD_INSTALLED).setGameAppId(str).setExt(1, "42601").setExt(11, "1").setExt(12, "116").setExt(13, "0").report();
    }

    public static void n(String str, boolean z16) {
        String str2;
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        WadlReportBuilder ext = wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("426").setOperId("205581").setGameAppId(str).setExt(1, "42601").setExt(11, "1");
        if (z16) {
            str2 = "117";
        } else {
            str2 = "116";
        }
        ext.setExt(12, str2);
        wadlReportBuilder.report();
    }

    public static void o(String str) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_GAMECENTER).setOperId(WadlProxyConsts.OPER_ID_PREUPDATE_NOT_INSTALL).setGameAppId(str).setExt(1, "72703").setExt(11, "4").setExt(12, WadlProxyConsts.PAGE_ID_GAMECENTER).setExt(3, "1").setExt(4, "5").report();
    }

    public static void p(String str, int i3, int i16, int i17) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_GAMECENTER).setOperId("928882").setGameAppId(str).setExt(1, WadlProxyConsts.MOUDLE_TYPE_GAMECENTER).setExt(2, String.valueOf(i16)).setExt(11, "4").setExt(12, WadlProxyConsts.PAGE_ID_GAMECENTER).setExt(22, String.valueOf(i17)).setExt(3, String.valueOf(i3)).report();
    }
}
