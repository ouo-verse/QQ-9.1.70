package qy1;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.main.data.SchedulerMsgData;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a {
    private static String a(String str, String str2) {
        return str + "_" + str2;
    }

    private static String b(String str, String str2) {
        return bw.L().decodeString(g(str, str2), null);
    }

    public static SchedulerMsgData c(String str, String str2) {
        String b16 = b(str, str2);
        if (TextUtils.isEmpty(b16)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(b16);
            long j3 = jSONObject.getLong("expireTimeMs");
            if (j3 < NetConnInfoCenter.getServerTimeMillis()) {
                d(str, str2);
                return null;
            }
            SchedulerMsgData schedulerMsgData = new SchedulerMsgData();
            schedulerMsgData.expireTimeMs = j3;
            schedulerMsgData.creatorUrl = jSONObject.getString("creatorUrl");
            schedulerMsgData.wording = jSONObject.getString("wording");
            schedulerMsgData.msgSeq = jSONObject.optLong("msgSeq");
            return schedulerMsgData;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void d(String str, String str2) {
        bw.L().removeKey(g(str, str2));
    }

    public static void e(String str, String str2, SchedulerMsgData schedulerMsgData, long j3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("creatorUrl", schedulerMsgData.creatorUrl);
            jSONObject.put("wording", schedulerMsgData.wording);
            jSONObject.put("expireTimeMs", schedulerMsgData.expireTimeMs);
            jSONObject.put("msgSeq", j3);
            f(str, str2, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private static void f(String str, String str2, String str3) {
        bw.L().encodeString(g(str, str2), str3);
    }

    private static String g(String str, String str2) {
        return bw.b2("QQGuildScheduleMSG") + "_" + a(str, str2);
    }
}
