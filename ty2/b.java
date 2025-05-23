package ty2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AudioHelperUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {
    public static SharedPreferences a(String str, String str2, String str3) {
        if (AudioHelperUtil.isDev() && TextUtils.isEmpty(str2)) {
            String str4 = " getSP, \u83b7\u53d6\u914d\u7f6e\u9700\u8981UIN, uin[" + str2 + "], spName[" + str3 + "]";
            QLog.w(str, 1, str4, new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            throw new IllegalArgumentException(str + str4);
        }
        BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str3 + str2, 4);
            if (sharedPreferences == null && AudioHelperUtil.isDev()) {
                QLog.w(str, 1, "getSP, sp\u4e3anull, uin[" + str2 + "], spName[" + str3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            }
            return sharedPreferences;
        }
        if (AudioHelperUtil.isDev()) {
            QLog.w(str, 1, "getSP, BaseApplicationImpl\u4e3anull, uin[" + str2 + "], spName[" + str3 + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
            return null;
        }
        return null;
    }
}
