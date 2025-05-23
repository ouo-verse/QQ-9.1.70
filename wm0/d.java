package wm0;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f445802a = new String[0];

    public static String[] a() {
        return b(f445802a, "exp_id", "-999");
    }

    private static String[] b(String[] strArr, String str, String str2) {
        if (strArr != null && strArr.length > 0) {
            if (TextUtils.isEmpty(str)) {
                QLog.e("GdtConfigManagerForExperiment", 2, "[getExperimentIdList] error, key is empty");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str3 : strArr) {
                if (TextUtils.isEmpty(str3)) {
                    QLog.e("GdtConfigManagerForExperiment", 2, "[getExperimentIdList] error, groupId is empty");
                } else {
                    String c16 = c(str3, str, str2);
                    if (!TextUtils.isEmpty(c16) && !TextUtils.equals(c16, str2)) {
                        arrayList.add(c16);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return (String[]) arrayList.toArray(new String[0]);
        }
        QLog.i("GdtConfigManagerForExperiment", 2, "[getExperimentIdList] do nothing, groupIdList is empty");
        return null;
    }

    static String c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        if (TextUtils.isEmpty(str2)) {
            return str3;
        }
        try {
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, false)) {
                String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str, "");
                if (!TextUtils.isEmpty(loadAsString)) {
                    return new JSONObject(loadAsString).optString(str2, str3);
                }
                return str3;
            }
            return str3;
        } catch (Throwable th5) {
            QLog.e("GdtConfigManagerForExperiment", 1, "[getExperimentParamValue]", th5);
            return str3;
        }
    }
}
