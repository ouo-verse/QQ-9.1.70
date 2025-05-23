package w81;

import android.os.Build;
import com.tencent.mobileqq.utils.StringUtil;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    public static boolean a(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        if (!("" + Build.MANUFACTURER).equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }
}
