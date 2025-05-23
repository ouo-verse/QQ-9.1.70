package zv;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.u;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static u.a f453487a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: zv.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class AsyncTaskC11718a extends u.a {
        AsyncTaskC11718a(String str, String str2, String str3) {
            super(str, str2, str3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            a.f453487a = null;
            if (QLog.isColorLevel()) {
                QLog.d("AVPushReport", 2, "onAvReportPush SimpleHttpPostTask rsp = " + str);
            }
        }
    }

    public static boolean b() {
        return false;
    }

    public static void c(VideoAppInterface videoAppInterface, int i3, String str) {
        String str2;
        JSONObject jSONObject;
        if (QLog.isColorLevel()) {
            QLog.d("AVPushReport", 2, "onAvReportPush : rspType = " + i3 + ",rspBody = " + str);
        }
        if (f453487a != null) {
            if (QLog.isColorLevel()) {
                QLog.d("AVPushReport", 2, "ReportTask is running.");
                return;
            }
            return;
        }
        if (b()) {
            str2 = "https://play.mobile.qq.com/avreport_test/cgi-bin/report";
        } else {
            str2 = "https://play.mobile.qq.com/avreport/cgi-bin/report";
        }
        try {
            jSONObject = new JSONObject(str).optJSONObject("attach");
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("uin", videoAppInterface.getLongAccountUin());
            jSONObject2.put("qqversion", AppSetting.f99551k);
            jSONObject2.put("time", System.currentTimeMillis());
            if (jSONObject != null) {
                jSONObject2.put("attach", jSONObject);
            }
        } catch (JSONException e17) {
            e17.printStackTrace();
        }
        AsyncTaskC11718a asyncTaskC11718a = new AsyncTaskC11718a(str2, jSONObject2.toString(), null);
        f453487a = asyncTaskC11718a;
        asyncTaskC11718a.execute(new Void[0]);
    }
}
