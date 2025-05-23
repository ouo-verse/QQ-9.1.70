package y6;

import NS_FAMOUS_BASE.SchoolSingleGameItem;
import WEBAPP_FAMOUS.ActInfo;
import WEBAPP_FAMOUS.GetBottomNaviRsp;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QzoneBaseDataService;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.homepage.business.protocol.QZoneGetBottomNaviRequest;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends QzoneBaseDataService implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f449496d;

    private JSONObject C(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            jSONObject.put("url", str2);
            return jSONObject;
        } catch (Exception e16) {
            e16.printStackTrace();
            QZLog.e("QZoneGetBottomNaviService", "createBtnDataJSON() error!" + e16.getMessage());
            return null;
        }
    }

    public static a E() {
        if (f449496d == null) {
            synchronized (a.class) {
                if (f449496d == null) {
                    f449496d = new a();
                }
            }
        }
        return f449496d;
    }

    private void G(QZoneTask qZoneTask) {
        if (qZoneTask == null) {
            QZLog.e("QZoneGetBottomNaviService", "onGetBottomNaviResponse error\uff01task == null");
            return;
        }
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        if (qZoneRequest != null && (qZoneRequest instanceof QZoneGetBottomNaviRequest)) {
            QZoneResult result = qZoneTask.getResult(1000205);
            QZoneGetBottomNaviRequest qZoneGetBottomNaviRequest = (QZoneGetBottomNaviRequest) qZoneTask.mRequest;
            GetBottomNaviRsp getBottomNaviRsp = (GetBottomNaviRsp) qZoneGetBottomNaviRequest.rsp;
            if (getBottomNaviRsp != null && result.getSucceed()) {
                String F = F(qZoneGetBottomNaviRequest.getOwnerUin(), getBottomNaviRsp);
                Bundle bundle = new Bundle();
                bundle.putString(QZoneHelper.KEY_FAMOUS_SPACE_NAVIGATION_BAR_INFO, F);
                result.setData(bundle);
                qZoneTask.sendResultMsg(result);
                return;
            }
            result.setSucceed(false);
            qZoneTask.sendResultMsg(result);
            QZLog.e("QZoneGetBottomNaviService", "onGetBottomNaviResponse error\uff01returnCode=" + qZoneTask.mResultCode);
            return;
        }
        QZLog.e("QZoneGetBottomNaviService", "onGetBottomNaviResponse error\uff01task.req == null or req type mismatch");
    }

    public void D(long j3, Handler handler) {
        if (QZLog.isDevelopLevel()) {
            QZLog.d("QZoneGetBottomNaviService", 4, "getBottomNavi() uin=" + j3);
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QZoneGetBottomNaviRequest(j3), handler, this, 1));
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneGetBottomNaviService", 2, "QZoneGetBottomNaviService\t onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        if (qZoneTask.mType != 1) {
            return;
        }
        G(qZoneTask);
    }

    private String F(long j3, GetBottomNaviRsp getBottomNaviRsp) {
        ArrayList<ActInfo> arrayList = getBottomNaviRsp.vec_out_app;
        Map<String, ArrayList<SchoolSingleGameItem>> map = getBottomNaviRsp.app_list;
        boolean z16 = map != null && map.size() > 0;
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<ActInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                ActInfo next = it.next();
                if (next != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = next.act_name;
                    String str2 = next.act_url;
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            jSONObject2.put("name", str);
                            jSONObject2.put("url", str2);
                            jSONArray.mo162put(jSONObject2);
                        } else if (z16 && map.containsKey(str)) {
                            ArrayList<SchoolSingleGameItem> arrayList2 = map.get(str);
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                JSONObject jSONObject3 = new JSONObject();
                                JSONArray jSONArray2 = new JSONArray();
                                Iterator<SchoolSingleGameItem> it5 = arrayList2.iterator();
                                while (it5.hasNext()) {
                                    SchoolSingleGameItem next2 = it5.next();
                                    if (next2 != null) {
                                        try {
                                            JSONObject C = C(next2.app_name, next2.detail_url);
                                            if (C != null) {
                                                jSONArray2.mo162put(C);
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            e.printStackTrace();
                                            QZLog.e("QZoneGetBottomNaviService", "handleResponse() error!" + e.getMessage());
                                            return "";
                                        }
                                    }
                                }
                                jSONObject3.put("name", str);
                                jSONObject3.put("sub_button", jSONArray2);
                                jSONArray.mo162put(jSONObject3);
                            } else {
                                QZLog.e("QZoneGetBottomNaviService", "handleResponse() error!subBtn has no data");
                            }
                        } else {
                            QZLog.e("QZoneGetBottomNaviService", "handleResponse() error!ActInfo has invalid subBtn data");
                        }
                    } else {
                        QZLog.e("QZoneGetBottomNaviService", "handleResponse() error!ActInfo act_name invalid");
                    }
                }
            }
            jSONObject.put("PGCNavViewButtons", jSONArray);
            jSONObject.put("uin", j3);
            return jSONObject.toString();
        } catch (Exception e17) {
            e = e17;
        }
    }
}
