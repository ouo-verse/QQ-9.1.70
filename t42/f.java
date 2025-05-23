package t42;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    public static int a() {
        if (!AppNetConnInfo.isNetSupport()) {
            return 0;
        }
        if (AppNetConnInfo.isWifiConn()) {
            return 1;
        }
        if (!AppNetConnInfo.isMobileConn()) {
            return 0;
        }
        int mobileInfo = AppNetConnInfo.getMobileInfo();
        if (mobileInfo == 0 || mobileInfo == 1) {
            return 2;
        }
        if (mobileInfo == 2) {
            return 3;
        }
        if (mobileInfo == 3) {
            return 4;
        }
        if (mobileInfo != 4) {
            return 0;
        }
        return 5;
    }
}
