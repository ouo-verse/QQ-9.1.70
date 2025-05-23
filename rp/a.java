package rp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static double a() {
        try {
            JSONObject c16 = c("103040");
            if (c16 == null) {
                QLog.i("AdelieAVEntranceSwitch", 1, "getInviteAnimDuration exception");
                return -1.0d;
            }
            double optDouble = c16.optDouble("invite_anim_duration_s", -1.0d);
            QLog.i("AdelieAVEntranceSwitch", 1, "getInviteAnimDuration: " + optDouble + " hasKey:" + c16.has("invite_anim_duration_s") + " content=" + c16);
            return optDouble;
        } catch (Throwable unused) {
            QLog.i("AdelieAVEntranceSwitch", 1, "getInviteAnimDuration exception");
            return -1.0d;
        }
    }

    private static boolean b(String str, String str2) {
        try {
            JSONObject c16 = c(str);
            if (c16 == null) {
                QLog.i("AdelieAVEntranceSwitch", 1, "getMCQQSwitchOn exception");
                return false;
            }
            boolean optBoolean = c16.optBoolean(str2, false);
            QLog.i("AdelieAVEntranceSwitch", 1, "getMCQQSwitchOn: " + optBoolean + " hasKey:" + c16.has(str2) + " content=" + c16);
            return optBoolean;
        } catch (Throwable unused) {
            QLog.i("AdelieAVEntranceSwitch", 1, "getMCQQSwitchOn exception");
            return false;
        }
    }

    private static JSONObject c(String str) {
        String str2;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
        if (loadRawConfig != null && loadRawConfig.length != 0) {
            try {
                str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
                try {
                    return new JSONObject(str2);
                } catch (Exception e16) {
                    e = e16;
                    QLog.e("AdelieAVEntranceSwitch", 1, "parse raw config failed!!! str: " + str2 + "\n", e);
                    return null;
                }
            } catch (Exception e17) {
                e = e17;
                str2 = null;
            }
        } else {
            QLog.e("AdelieAVEntranceSwitch", 1, "get null raw config!!! groupId: " + str);
            return null;
        }
    }

    public static boolean d() {
        return b("103040", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE);
    }
}
