package ty2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.ar.ARPromotionMgr.f;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a {
    public static synchronized PromotionConfigInfo a(String str, String str2) {
        int i3;
        PromotionConfigInfo promotionConfigInfo;
        synchronized (a.class) {
            if (TextUtils.isEmpty(str2)) {
                SharedPreferences c16 = c(str);
                if (c16 != null) {
                    str2 = c16.getString(DownloadInfo.spKey_Config, null);
                    i3 = 1;
                } else {
                    i3 = 2;
                }
            } else {
                i3 = 0;
            }
            QLog.w(f.f196950a, 1, "ConfigInfo.get, step[" + i3 + "], configText[" + str2 + "]");
            promotionConfigInfo = new PromotionConfigInfo();
            promotionConfigInfo.setUin(str);
            if (!TextUtils.isEmpty(str2)) {
                promotionConfigInfo.tryParse(f.f196950a, str2);
            }
        }
        return promotionConfigInfo;
    }

    public static int b(String str) {
        SharedPreferences c16 = c(str);
        if (c16 != null) {
            return ConfigHandler.getConfigVer(c16, DownloadInfo.spKey_Config, "ver");
        }
        return 0;
    }

    public static SharedPreferences c(String str) {
        return b.a(f.f196950a, str, "config_qq.android.ar_");
    }

    public static SharedPreferences d(String str, String str2) {
        return b.a(f.f196950a, str, "res_qq.android.ar_" + str2);
    }

    public static SharedPreferences e(String str) {
        return b.a(f.f196950a, str, "res_qq.android.ar_");
    }

    public static String f(String str) {
        SharedPreferences e16 = e(str);
        if (e16 == null) {
            return null;
        }
        return e16.getString(DownloadInfo.spKey_Config, null);
    }

    public static int g(String str) {
        SharedPreferences e16 = e(str);
        if (e16 != null) {
            return ConfigHandler.getConfigVer(e16, DownloadInfo.spKey_Config, "ver");
        }
        return 0;
    }

    public static boolean h(String str, String str2, int i3, String str3, String str4) {
        return BusinessCommonConfig.isResReady(f.f196950a + "_" + str2, d(str, str2), "md5_" + i3, str3, str4);
    }

    public static void i(String str, String str2, int i3, String str3) {
        BusinessCommonConfig.saveMd5(f.f196950a, d(str, str2), "md5_" + i3, str3);
    }
}
