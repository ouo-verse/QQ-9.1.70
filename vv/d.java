package vv;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d {
    public static String a(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return "unknown";
        }
        if (sessionInfo.M0) {
            return "audio";
        }
        if (sessionInfo.N) {
            if (sessionInfo.O) {
                return "video";
            }
            return "local_video_only";
        }
        if (!sessionInfo.O) {
            return "audio";
        }
        return "remote_video_only";
    }

    public static boolean b(Context context) {
        return false;
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i3 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("qavp_switch")) {
                i3 = jSONObject.getInt("qavp_switch");
                c.a("switch:" + i3);
            }
        } catch (Exception unused) {
            c.a("QAVP Get Config Error");
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("qavp_switch", 4).edit();
        edit.putInt("qavp_switch", i3);
        edit.apply();
    }
}
