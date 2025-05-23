package uu;

import android.os.Build;
import com.tencent.av.ManageConfig.AVTestforEncDecConfig;
import com.tencent.av.utils.ba;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.avcore.util.ArrayUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {
    public static boolean a(String str, String[] strArr) {
        int qQVersion = ba.getQQVersion();
        if (AVCoreUtil.strVersionToInt(str) > qQVersion) {
            return false;
        }
        if (strArr != null && strArr.length > 0) {
            for (String str2 : strArr) {
                if (AVCoreUtil.strVersionToInt(str2) == qQVersion) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public static int b(AVTestforEncDecConfig.c cVar) {
        int i3 = Build.VERSION.SDK_INT;
        if (cVar == null || i3 < cVar.f72807c || !a(cVar.f72810f, null) || ArrayUtils.contains(cVar.f72808d, Integer.valueOf(i3))) {
            return 0;
        }
        int i16 = cVar.f72809e;
        if (i16 != 0 && i3 >= i16) {
            return 2;
        }
        return 1;
    }
}
