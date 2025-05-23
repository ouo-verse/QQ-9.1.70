package ql0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class f implements a {
    private boolean d(String str, String str2, int i3, String str3) {
        if (GameCenterUtil.isInvalidResType(i3)) {
            return false;
        }
        if (i3 == 4) {
            if (GameCenterUtil.getAppVersionCode(str2) != -1) {
                return false;
            }
            return true;
        }
        if (i3 != 0) {
            return false;
        }
        return !GameCenterUtil.isResExist(0, str, str3);
    }

    @Override // ql0.a
    public void a(@NonNull com.tencent.gamecenter.wadl.biz.entity.g gVar) {
        JSONArray jSONArray;
        if (!gVar.f106810w) {
            QLog.d("WadlResDownload", 1, "checkPreDownload isResDefDownload off");
            return;
        }
        int d16 = e.d();
        if (!e.b(d16)) {
            QLog.i("WadlResDownload", 1, "checkPreDownload abort devicesStatus=" + d16);
            return;
        }
        String readFromSp = GameCenterSpUtils.readFromSp("QQGAME_PRELOAD_RES_LIST");
        if (TextUtils.isEmpty(readFromSp)) {
            QLog.i("WadlResDownload", 1, "checkPreDownload abort preloadResListStr is empty");
            return;
        }
        if (!TextUtils.isEmpty(readFromSp)) {
            try {
                jSONArray = new JSONArray(readFromSp);
            } catch (JSONException e16) {
                QLog.e("WadlResDownload", 1, "checkPreDownload exception", e16);
                GameCenterSpUtils.deleteToSp("QQGAME_PRELOAD_RES_LIST");
            }
            if (jSONArray == null && jSONArray.length() >= 1) {
                GameCenterSpUtils.deleteToSp("QQGAME_PRELOAD_RES_LIST");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                        String optString = optJSONObject.optString("app_id");
                        int optInt = optJSONObject.optInt("version_code");
                        String optString2 = optJSONObject.optString("package_name");
                        int optInt2 = optJSONObject.optInt(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE);
                        String optString3 = optJSONObject.optString("file_name");
                        String optString4 = optJSONObject.optString("url");
                        String optString5 = optJSONObject.optString("md5");
                        int optInt3 = optJSONObject.optInt("package_index", 0);
                        String optString6 = optJSONObject.optString("package_id", "");
                        if (!e.a(optString, optString2, optString3, optString4)) {
                            QLog.w("WadlResDownload", 1, "checkPreDownload checkParams fail\uff0cjsonTmp=" + optJSONObject);
                        } else {
                            try {
                                if (!d(optString, optString2, optInt2, optString3)) {
                                    QLog.w("WadlResDownload", 1, "checkPreDownload checkLocalStatus fail\uff0cjsonTmp=" + optJSONObject);
                                } else {
                                    g(optString, optString2, optInt2, optString4, optString3, optInt3, optString6, optInt, optString5);
                                }
                            } catch (Exception e17) {
                                e = e17;
                                QLog.e("WadlResDownload", 1, "checkPreDownload exception", e);
                            }
                        }
                    } catch (Exception e18) {
                        e = e18;
                    }
                }
                return;
            }
        }
        jSONArray = null;
        if (jSONArray == null) {
        }
    }

    @Override // ql0.a
    public boolean c() {
        return !TextUtils.isEmpty(GameCenterSpUtils.readFromSp("QQGAME_PRELOAD_RES_LIST"));
    }

    public boolean e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("preload_list");
            QLog.d("WadlResDownload", 1, "handlePreloadPush dataJson=" + jSONObject);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                f(optJSONArray);
                return true;
            }
            return false;
        } catch (JSONException e16) {
            QLog.e("WadlResDownload", 1, "handlePreloadPush exception=" + e16.toString());
            return false;
        }
    }

    protected void f(JSONArray jSONArray) {
        int i3;
        int optInt;
        if (jSONArray != null) {
            i3 = jSONArray.length();
        } else {
            i3 = 0;
        }
        if (i3 < 1) {
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i16 = 0; i16 < i3; i16++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i16);
            if (optJSONObject != null && ((optInt = optJSONObject.optInt(QCircleSchemeAttr.CoverFeed.SOURCE_TYPE)) == 0 || optInt == 4)) {
                jSONArray2.mo162put(optJSONObject);
            }
        }
        if (jSONArray2.length() > 0) {
            GameCenterSpUtils.writeToSp("QQGAME_PRELOAD_RES_LIST", jSONArray2.toString());
        }
    }

    protected void g(String str, String str2, int i3, String str3, String str4, int i16, String str5, int i17, String str6) {
        QLog.d("WadlResDownload", 1, "startDownload packageName=" + str2 + ",resType=" + i3 + ",appId=" + str + ",resName=" + str4 + ",srcUrl=" + str3 + ",versionCode=" + i17 + ",versionName=" + str5 + ",resMD5=" + str6);
        WadlParams wadlParams = new WadlParams(str, str2);
        wadlParams.setFlagDisable(2);
        wadlParams.setFlagDisable(4);
        wadlParams.setFlagDisable(16384);
        wadlParams.actionCode = 2;
        wadlParams.isRes = true;
        wadlParams.resType = i3;
        wadlParams.from = 3;
        wadlParams.apkUrl = str3;
        wadlParams.resName = str4;
        wadlParams.resIndex = i16;
        wadlParams.resVersionName = str5;
        wadlParams.versionCode = i17;
        wadlParams.resMD5 = str6;
        wadlParams.via = WadlProxyConsts.VIA_AUTO_TGPA;
        wadlParams.setFlags(8);
        WadlProxyServiceUtil.getProxyService().doDownloadResAction(wadlParams);
    }

    @Override // ql0.a
    public void onDestroy() {
        QLog.i("WadlResDownload", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // ql0.a
    public void b(@NonNull WadlParams wadlParams) {
    }
}
