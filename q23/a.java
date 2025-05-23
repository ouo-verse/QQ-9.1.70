package q23;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    public static String a(MessageRecord messageRecord) {
        Throwable th5;
        String str;
        String str2;
        try {
            str2 = messageRecord.extStr;
        } catch (Throwable th6) {
            th5 = th6;
            str = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        JSONObject jSONObject = new JSONObject(str2);
        str = jSONObject.optString(AppConstants.Key.KEY_PUBLIC_ACCOUNT_MSGID, "");
        try {
            if (TextUtils.isEmpty(str)) {
                return jSONObject.optString("pa_msgId", "");
            }
        } catch (Throwable th7) {
            th5 = th7;
            QLog.e("QQVipConstant", 1, "getPAMsgId error =" + th5.toString());
            return str;
        }
        return str;
    }
}
