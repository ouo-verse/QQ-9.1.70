package su;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static boolean a(String str, String str2) {
        try {
            JSONObject b16 = b(str);
            if (b16 == null) {
                QLog.i("AVNTPartSwitch", 1, "getMCQQSwitchOn exception");
                return false;
            }
            boolean optBoolean = b16.optBoolean(str2, false);
            QLog.i("AVNTPartSwitch", 1, "getMCQQSwitchOn: " + optBoolean + " hasKey:" + b16.has(str2) + " content=" + b16);
            return optBoolean;
        } catch (Throwable unused) {
            QLog.i("AVNTPartSwitch", 1, "getMCQQSwitchOn exception");
            return false;
        }
    }

    public static JSONObject b(String str) {
        String str2;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
        if (loadRawConfig == null || loadRawConfig.length == 0) {
            return null;
        }
        try {
            str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
            try {
                return new JSONObject(str2);
            } catch (Exception e16) {
                e = e16;
                QLog.e("AVNTPartSwitch", 1, "parse raw config failed!!! str: " + str2 + "\n", e);
                return null;
            }
        } catch (Exception e17) {
            e = e17;
            str2 = null;
        }
    }

    public static boolean c() {
        return a("102759", "ginviteSwitch");
    }

    public static boolean d() {
        return a("102388", "switchOn");
    }
}
