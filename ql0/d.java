package ql0;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.api.IQQGameAutoUpdateService;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.util.AppSetting;
import java.util.HashSet;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameAutoDownloadTask$PreDownloadInfo;
import tencent.im.qqgame.QQGameAutoUpdateTask$PreUpdateInfo;
import tencent.im.qqgame.QQGameAutoUpdateTask$ReportGameUpdatesReq;
import tencent.im.qqgame.UserGameVersionPB$QueryGameChannelRsp;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d implements a, WadlTrpcListener {

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f429047f = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    private LruCache<String, Long> f429048d = new LruCache<>(3);

    /* renamed from: e, reason: collision with root package name */
    private HashSet<String> f429049e;

    public d() {
        HashSet<String> hashSet = new HashSet<>();
        this.f429049e = hashSet;
        hashSet.add(WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
    }

    private void e(final WadlParams wadlParams) {
        int i3;
        final int d16 = e.d();
        QLog.i("WadlGamePreDownload", 1, "checkAndStartDownload devicesStatus=" + d16 + ", appId=" + wadlParams.appId);
        JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF);
        if (configJsonObj != null) {
            i3 = configJsonObj.optInt("auto_update_kingcard_switch", 0);
        } else {
            i3 = 0;
        }
        if (i3 == 1 && ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard()) {
            WadlProxyServiceUtil.getProxyService().preLaunchWadlService();
            ((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).getAutoDualGameSwitch(27, new jl0.a() { // from class: ql0.c
                @Override // jl0.a
                public final void a(int i16) {
                    d.this.l(wadlParams, d16, i16);
                }
            });
        } else if (e.b(d16)) {
            t(false, wadlParams);
        }
    }

    private void f(int i3, boolean z16, WadlParams wadlParams) {
        boolean z17;
        int i16;
        boolean z18 = false;
        if (!e.a(wadlParams.appId, wadlParams.packageName, wadlParams.apkUrl)) {
            QLog.w("WadlGamePreDownload", 1, "checkDownload params check fail\uff0cwadlParams=" + wadlParams);
            return;
        }
        if (wadlParams.downloadType == 2) {
            z17 = true;
        } else {
            z17 = false;
        }
        boolean g16 = e.g(wadlParams.appId, wadlParams.versionCode, z17);
        if (z17) {
            e.l(wadlParams.appId, i3, g16, z16);
        }
        if (!z16 && !g16) {
            WadlProxyServiceUtil.getProxyService().preLaunchWadlService();
            com.tencent.gamecenter.wadl.biz.entity.a installInfo = GameCenterUtil.getInstallInfo(wadlParams.appId, wadlParams.packageName);
            e.k(z17, i3, wadlParams, installInfo);
            if (!e.f(i3, 1)) {
                return;
            }
            if (z17) {
                if (installInfo.f106749d && !installInfo.f106750e) {
                    if (installInfo.f106751f > wadlParams.versionCode) {
                        q(wadlParams.appId);
                        e.m(wadlParams.appId);
                        return;
                    } else {
                        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).checkInstallChannel(1, 1, installInfo.f106748c, wadlParams);
                        return;
                    }
                }
            } else {
                if (installInfo.f106749d) {
                    int i17 = installInfo.f106751f;
                    int i18 = wadlParams.versionCode;
                    if (i17 >= i18) {
                        e.p(wadlParams.appId, 5, 2, i18);
                        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).checkInstallChannel(2, 2, installInfo.f106748c, wadlParams);
                        return;
                    }
                }
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102359", false);
                int i19 = installInfo.f106751f;
                if (i19 < wadlParams.versionCode && (i19 != -1 || isSwitchOn)) {
                    z18 = true;
                }
                if (!z18) {
                    e.o(wadlParams.appId);
                    QLog.d("WadlGamePreDownload", 1, "checkDownload cancel, appId=" + wadlParams.appId + ",checkVersion invalid");
                    return;
                }
            }
            e(wadlParams);
            return;
        }
        QLog.w("WadlGamePreDownload", 1, "checkDownload abort, appId=" + wadlParams.appId + " isExpire=" + z16 + " isDownloaded=" + g16);
        if (z17) {
            q(wadlParams.appId);
            return;
        }
        String str = wadlParams.appId;
        if (g16) {
            i16 = 7;
        } else {
            i16 = 6;
        }
        e.p(str, i16, 2, wadlParams.versionCode);
        r(3, wadlParams.appId, wadlParams.apkChannel, wadlParams.versionCode);
        u(wadlParams.appId, wadlParams.versionCode);
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JSONArray g() {
        JSONArray jSONArray;
        String readFromSp = GameCenterSpUtils.readFromSp("QQGAME_PRE_UPDATE_LIST");
        if (!TextUtils.isEmpty(readFromSp)) {
            try {
                jSONArray = new JSONArray(readFromSp);
            } catch (JSONException e16) {
                QLog.e("WadlGamePreDownload", 1, "getLocalPreUpdateList exception", e16);
                GameCenterSpUtils.deleteToSp("QQGAME_PRE_UPDATE_LIST");
            }
            if (jSONArray != null) {
                return new JSONArray();
            }
            return jSONArray;
        }
        jSONArray = null;
        if (jSONArray != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(WadlParams wadlParams, int i3, int i16) {
        if (i16 == 1) {
            t(true, wadlParams);
            return;
        }
        if (e.f(i3, 2)) {
            t(false, wadlParams);
            return;
        }
        QLog.w("WadlGamePreDownload", 1, "checkAndStartUpdateDownload abort, kingCardStatus=" + i16 + ", devicesStatus=" + i3 + ", appId=" + wadlParams.appId);
    }

    private String[] m() {
        String readFromSp = GameCenterSpUtils.readFromSp("QQGAME_LIST");
        QLog.i("WadlGamePreDownload", 1, "loadAndParsePreGameInfo appointmentList=" + readFromSp);
        if (TextUtils.isEmpty(readFromSp)) {
            return null;
        }
        return readFromSp.split("\\|");
    }

    private JSONArray n() {
        String readFromSp = GameCenterSpUtils.readFromSp("QQGAME_PRE_UPDATE_LIST");
        QLog.i("WadlGamePreDownload", 1, "loadAndParseUpdateGameInfo updatePreListStr=" + readFromSp);
        if (TextUtils.isEmpty(readFromSp)) {
            return null;
        }
        try {
            return new JSONArray(readFromSp);
        } catch (JSONException e16) {
            QLog.e("WadlGamePreDownload", 1, "loadAndParseUpdateGameInfo exception", e16);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o(int i3) {
        boolean z16;
        long j3;
        JSONObject jSONObject;
        int length;
        int i16;
        JSONObject optJSONObject;
        boolean z17;
        JSONArray n3 = n();
        if (n3 != null && n3.length() >= 1) {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAME_INSTALL_CHANNEL_CONFIG, "");
            long j16 = 0;
            boolean z18 = false;
            if (!TextUtils.isEmpty(loadAsString)) {
                try {
                    jSONObject = new JSONObject(loadAsString);
                    z16 = jSONObject.optBoolean("autoUpdateExpireSwith", false);
                } catch (JSONException e16) {
                    e = e16;
                    z16 = false;
                }
                try {
                    j3 = jSONObject.optLong("autoUpdateExpireTime", 1209600L);
                } catch (JSONException e17) {
                    e = e17;
                    QLog.e("WadlGamePreDownload", 1, "loadUpdateDownloadInfoAndCheck autoUpdateExpireTime config exception", e);
                    j3 = 0;
                    long serverTime = NetConnInfoCenter.getServerTime();
                    length = n3.length();
                    i16 = 0;
                    while (i16 < length) {
                    }
                    return;
                }
            } else {
                j3 = 0;
                z16 = false;
            }
            long serverTime2 = NetConnInfoCenter.getServerTime();
            length = n3.length();
            i16 = 0;
            while (i16 < length) {
                try {
                    optJSONObject = n3.optJSONObject(i16);
                    long optLong = optJSONObject.optLong("configTime", j16);
                    if (z16 && serverTime2 > optLong + j3) {
                        z17 = true;
                    } else {
                        z17 = z18;
                    }
                    QLog.w("WadlGamePreDownload", 1, "loadUpdateDownloadInfoAndCheck configValidTime=" + (optLong + j3) + ",now=" + serverTime2);
                } catch (Exception e18) {
                    e = e18;
                }
                try {
                    f(i3, z17, e.i(optJSONObject, 4));
                } catch (Exception e19) {
                    e = e19;
                    QLog.e("WadlGamePreDownload", 1, "loadUpdateDownloadInfoAndCheck exception", e);
                    i16++;
                    j16 = 0;
                    z18 = false;
                }
                i16++;
                j16 = 0;
                z18 = false;
            }
            return;
        }
        GameCenterSpUtils.deleteToSp("QQGAME_PRE_UPDATE_LIST");
    }

    private void p(int i3) {
        JSONObject jSONObject;
        long optLong;
        long optLong2;
        boolean z16;
        String[] m3 = m();
        if (m3 != null && m3.length >= 1) {
            long serverTime = NetConnInfoCenter.getServerTime();
            for (String str : m3) {
                if (!TextUtils.isEmpty(str)) {
                    String readFromSp = GameCenterSpUtils.readFromSp("QQGAME_APPID_DETAIL_" + str);
                    if (TextUtils.isEmpty(readFromSp)) {
                        q(str);
                        QLog.w("WadlGamePreDownload", 1, "loadYuYueDownloadInfoAndCheck remove invalid appId=" + str);
                    } else {
                        try {
                            jSONObject = new JSONObject(readFromSp);
                            optLong = jSONObject.optLong("downloadStartTime");
                            optLong2 = jSONObject.optLong("downloadEndTime");
                        } catch (Exception e16) {
                            e = e16;
                        }
                        if (serverTime < optLong) {
                            QLog.w("WadlGamePreDownload", 1, "loadYuYueDownloadInfoAndCheck not start time, appId=" + str);
                        } else {
                            if (serverTime > optLong2) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            try {
                                f(i3, z16, e.i(jSONObject, 2));
                            } catch (Exception e17) {
                                e = e17;
                                QLog.e("WadlGamePreDownload", 1, "loadYuYueDownloadInfoAndCheck exception", e);
                            }
                        }
                    }
                }
            }
        }
    }

    private void q(String str) {
        QLog.i("WadlGamePreDownload", 1, "removeYuYueDetailInfo appId=" + str);
        GameCenterUtil.delAppDetail(str, "QQGAME_APPID_DETAIL_");
        GameCenterUtil.deleteAppidFromList(str, "QQGAME_LIST");
    }

    private void r(int i3, String str, String str2, int i16) {
        int i17;
        QQGameAutoUpdateTask$ReportGameUpdatesReq qQGameAutoUpdateTask$ReportGameUpdatesReq = new QQGameAutoUpdateTask$ReportGameUpdatesReq();
        PBEnumField pBEnumField = qQGameAutoUpdateTask$ReportGameUpdatesReq.operation;
        if (i3 == 3) {
            i17 = 1;
        } else {
            i17 = 2;
        }
        pBEnumField.set(i17);
        qQGameAutoUpdateTask$ReportGameUpdatesReq.channel_id.set(str2);
        qQGameAutoUpdateTask$ReportGameUpdatesReq.appid.set(str);
        qQGameAutoUpdateTask$ReportGameUpdatesReq.version_code.set(i16);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).requestTrpc(WadlProxyConsts.CMD_TRPC_REQUEST_PRE_UPDATE_REPORT, qQGameAutoUpdateTask$ReportGameUpdatesReq.toByteArray(), null);
    }

    private void s(int i3, String str) {
        int i16;
        if (i3 == 1) {
            i16 = 2;
        } else {
            i16 = 5;
        }
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).setOrderGame(i16, null, str);
    }

    private void t(boolean z16, WadlParams wadlParams) {
        QLog.i("WadlGamePreDownload", 1, "startDownload isKingCardAuthority=" + z16 + ", wadlParams=" + wadlParams);
        if (z16) {
            wadlParams.isDualDownload = true;
        } else {
            wadlParams.setFlags(24);
        }
        if (wadlParams.downloadType == 2) {
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onAutoDownloadStart(wadlParams);
        } else {
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onAutoUpdateStart(wadlParams);
            e.p(wadlParams.appId, 0, 1, wadlParams.versionCode);
        }
        WadlProxyServiceUtil.getProxyService().doDownloadAction(wadlParams);
    }

    private void u(String str, int i3) {
        QLog.d("WadlGamePreDownload", 1, "removeAndUpdateDownList appId=" + str + ",versionCode=" + i3);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f429047f) {
            JSONArray g16 = g();
            if (g16 == null) {
                return;
            }
            if (g16.length() < 1) {
                return;
            }
            int c16 = e.c(g16, str);
            if (c16 < 0) {
                return;
            }
            g16.remove(c16);
            String jSONArray = g16.toString();
            QLog.d("WadlGamePreDownload", 1, "removeAndUpdateDownList appId=" + str + ",findIndex=" + c16 + ",newSize=" + g16.length());
            if (QLog.isColorLevel()) {
                QLog.d("WadlGamePreDownload", 1, "removeAndUpdateDownList newJsonStr=" + jSONArray);
            }
            if (g16.length() < 1) {
                GameCenterSpUtils.deleteToSp("QQGAME_PRE_UPDATE_LIST");
            } else {
                GameCenterSpUtils.writeToSp("QQGAME_PRE_UPDATE_LIST", jSONArray);
            }
        }
    }

    @Override // ql0.a
    public void a(@NotNull com.tencent.gamecenter.wadl.biz.entity.g gVar) {
        int d16 = e.d();
        if (gVar.f106807t) {
            p(d16);
        } else {
            QLog.i("WadlGamePreDownload", 1, "checkPreDownload isAppointDownload off");
        }
        if (gVar.f106808u) {
            o(d16);
        } else {
            QLog.i("WadlGamePreDownload", 1, "checkPreDownload isUpdateDownload off");
        }
    }

    @Override // ql0.a
    public void b(@NonNull WadlParams wadlParams) {
        q(wadlParams.appId);
        s(wadlParams.from, wadlParams.appId);
        r(wadlParams.from, wadlParams.appId, wadlParams.apkChannel, wadlParams.versionCode);
        u(wadlParams.appId, wadlParams.versionCode);
    }

    @Override // ql0.a
    public boolean c() {
        String readFromSp = GameCenterSpUtils.readFromSp("QQGAME_LIST");
        String readFromSp2 = GameCenterSpUtils.readFromSp("QQGAME_PRE_UPDATE_LIST");
        if (TextUtils.isEmpty(readFromSp) && TextUtils.isEmpty(readFromSp2)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return this.f429049e;
    }

    public void h(List<QQGameAutoDownloadTask$PreDownloadInfo> list) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        QQGameAutoDownloadTask$PreDownloadInfo qQGameAutoDownloadTask$PreDownloadInfo = list.get(i3);
                        if (qQGameAutoDownloadTask$PreDownloadInfo != null) {
                            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onGetAutoDownloadInfo(qQGameAutoDownloadTask$PreDownloadInfo);
                            String str = qQGameAutoDownloadTask$PreDownloadInfo.appid.get();
                            String str2 = qQGameAutoDownloadTask$PreDownloadInfo.package_name.get();
                            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("appId", qQGameAutoDownloadTask$PreDownloadInfo.appid.get());
                                jSONObject.put("iconUrl", qQGameAutoDownloadTask$PreDownloadInfo.icon_url.get());
                                jSONObject.put("apkUrl", qQGameAutoDownloadTask$PreDownloadInfo.url.get());
                                jSONObject.put("packageName", qQGameAutoDownloadTask$PreDownloadInfo.package_name.get());
                                jSONObject.put("via", qQGameAutoDownloadTask$PreDownloadInfo.via.get());
                                jSONObject.put("appName", qQGameAutoDownloadTask$PreDownloadInfo.app_name.get());
                                jSONObject.put("apkChannel", qQGameAutoDownloadTask$PreDownloadInfo.apk_channel.get());
                                jSONObject.put("versionCode", qQGameAutoDownloadTask$PreDownloadInfo.version_code.get());
                                jSONObject.put("downloadStartTime", qQGameAutoDownloadTask$PreDownloadInfo.download_start_time.get());
                                jSONObject.put("downloadEndTime", qQGameAutoDownloadTask$PreDownloadInfo.download_end_time.get());
                                jSONObject.put("appointment_time", qQGameAutoDownloadTask$PreDownloadInfo.appointment_time.get());
                                GameCenterUtil.addAppidToList(str, "QQGAME_LIST");
                                GameCenterUtil.saveAppDetail(str, jSONObject.toString(), "QQGAME_APPID_DETAIL_");
                            }
                        }
                    }
                    return;
                }
            } catch (Exception e16) {
                QLog.e("WadlGamePreDownload", 1, e16, new Object[0]);
                return;
            }
        }
        QLog.i("WadlGamePreDownload", 1, "pre download list is empty!");
    }

    public void i(String str, String str2) {
        QLog.i("WadlGamePreDownload", 1, "handlePreDownloadPush jsonStr=" + str + MttLoader.QQBROWSER_PARAMS_FROME + str2);
        String str3 = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                str3 = new JSONObject(str).optString("appid", "");
                if (!TextUtils.isEmpty(str3)) {
                    Long l3 = this.f429048d.get(str3);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (l3 != null && elapsedRealtime - l3.longValue() < 5000) {
                        return;
                    } else {
                        this.f429048d.put(str3, Long.valueOf(elapsedRealtime));
                    }
                }
            } catch (JSONException e16) {
                QLog.e("WadlGamePreDownload", 1, "handlePreDownloadPush exception", e16);
            }
        }
        e.n(str3, false);
        ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onReceivePush(0, str3);
        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getAutoDownloadTask(0);
    }

    public void j(List<QQGameAutoUpdateTask$PreUpdateInfo> list) {
        if (list != null && list.size() >= 1) {
            synchronized (f429047f) {
                JSONArray g16 = g();
                try {
                    for (QQGameAutoUpdateTask$PreUpdateInfo qQGameAutoUpdateTask$PreUpdateInfo : list) {
                        String str = qQGameAutoUpdateTask$PreUpdateInfo.appid.get();
                        if (!TextUtils.isEmpty(str)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("appId", str);
                            jSONObject.put("versionCode", qQGameAutoUpdateTask$PreUpdateInfo.version_code.get());
                            jSONObject.put("packageName", qQGameAutoUpdateTask$PreUpdateInfo.pkg_name.get());
                            jSONObject.put("appName", qQGameAutoUpdateTask$PreUpdateInfo.app_name.get());
                            jSONObject.put("apkChannel", qQGameAutoUpdateTask$PreUpdateInfo.apk_channel.get());
                            jSONObject.put("apkUrl", qQGameAutoUpdateTask$PreUpdateInfo.apk_url.get());
                            jSONObject.put("iconUrl", qQGameAutoUpdateTask$PreUpdateInfo.icon.get());
                            jSONObject.put("configTime", NetConnInfoCenter.getServerTime());
                            int c16 = e.c(g16, str);
                            if (c16 > -1) {
                                g16.put(c16, jSONObject);
                            } else {
                                g16.mo162put(jSONObject);
                            }
                        }
                    }
                    QLog.d("WadlGamePreDownload", 1, "handlePreUpdateList jsonArray last len=" + g16.length());
                    GameCenterSpUtils.writeToSp("QQGAME_PRE_UPDATE_LIST", g16.toString());
                } catch (JSONException e16) {
                    QLog.e("WadlGamePreDownload", 1, "handlePreUpdateList exception=", e16);
                }
            }
            return;
        }
        boolean isPublicVersion = AppSetting.isPublicVersion();
        QLog.i("WadlGamePreDownload", 1, "handlePreUpdateList preUpdateInfoList is empty! isPublicVersion=" + isPublicVersion);
        if (isPublicVersion) {
            GameCenterSpUtils.deleteToSp("QQGAME_PRE_UPDATE_LIST");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(String str, String str2) {
        String optString;
        AppInterface appInterface;
        QLog.i("WadlGamePreDownload", 1, "handlePreUpdatePush jsonStr=" + str + MttLoader.QQBROWSER_PARAMS_FROME + str2);
        if (!TextUtils.isEmpty(str)) {
            try {
                optString = new JSONObject(str).optString("appid", "");
            } catch (JSONException e16) {
                QLog.e("WadlGamePreDownload", 1, "handlePreUpdatePush autoUpdate exception", e16);
            }
            appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (appInterface != null) {
                IQQGameAutoUpdateService iQQGameAutoUpdateService = (IQQGameAutoUpdateService) appInterface.getRuntimeService(IQQGameAutoUpdateService.class, "");
                if (iQQGameAutoUpdateService == null) {
                    QLog.e("WadlGamePreDownload", 2, "[handlePreUpdatePush], autoUpdate service is null");
                    return;
                }
                iQQGameAutoUpdateService.pullAutoUpdateTask(true);
            }
            e.n(optString, false);
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onReceivePush(1, optString);
        }
        optString = "";
        appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (appInterface != null) {
        }
        e.n(optString, false);
        ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onReceivePush(1, optString);
    }

    @Override // ql0.a
    public void onDestroy() {
        QLog.i("WadlGamePreDownload", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
        WadlParams wadlParams;
        boolean z16;
        PBBytesField pBBytesField;
        if (WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL.equals(str)) {
            int intExtra = intent.getIntExtra("actionFrom", 0);
            if ((intExtra != 1 && intExtra != 2) || (wadlParams = (WadlParams) intent.getParcelableExtra(WadlProxyConsts.PARAM_DOWNLOAD_INFO)) == null) {
                return;
            }
            String str2 = "";
            if (j3 == 0 && trpcInovkeRsp != null && (pBBytesField = trpcInovkeRsp.data) != null && pBBytesField.get() != null) {
                try {
                    UserGameVersionPB$QueryGameChannelRsp userGameVersionPB$QueryGameChannelRsp = new UserGameVersionPB$QueryGameChannelRsp();
                    userGameVersionPB$QueryGameChannelRsp.mergeFrom(trpcInovkeRsp.data.get().toByteArray());
                    z16 = userGameVersionPB$QueryGameChannelRsp.is_gamecenter_channel.get();
                    try {
                        str2 = userGameVersionPB$QueryGameChannelRsp.reason.get();
                    } catch (Throwable th5) {
                        th = th5;
                        QLog.e("WadlGamePreDownload", 1, "onTrpcRsp " + str + " error:" + th);
                        QLog.w("WadlGamePreDownload", 1, "onTrpcRsp " + str + " appId=" + wadlParams.appId + ",isGameCenterChannel=" + z16 + ",ret=" + j3 + ",reason=" + str2);
                        if (intExtra != 1) {
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    z16 = true;
                }
            } else {
                z16 = true;
            }
            QLog.w("WadlGamePreDownload", 1, "onTrpcRsp " + str + " appId=" + wadlParams.appId + ",isGameCenterChannel=" + z16 + ",ret=" + j3 + ",reason=" + str2);
            if (intExtra != 1) {
                if (z16) {
                    q(wadlParams.appId);
                    return;
                } else {
                    e(wadlParams);
                    return;
                }
            }
            if (z16) {
                u(wadlParams.appId, wadlParams.versionCode);
            } else {
                e(wadlParams);
            }
        }
    }
}
