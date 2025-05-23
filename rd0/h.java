package rd0;

import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
    
        if (com.tencent.common.config.AppSetting.p(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0018, code lost:
    
        if (com.tencent.common.config.AppSetting.p(com.tencent.mobileqq.mqsafeedit.BaseApplication.getContext()) != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(int i3) {
        boolean z16;
        switch (i3) {
            case 65793:
            case 66818:
            case 66831:
            case 77313:
            case 78082:
            case 78096:
            case 81154:
            case 83714:
                z16 = true;
                break;
            case 65799:
            case 67586:
                break;
            case Friends.TERM_TYPE_MOBILE_HD /* 65805 */:
            case Friends.TERM_TYPE_ANDROID_PAD /* 68104 */:
            case Friends.TERM_TYPE_MOBILE_IPAD /* 68361 */:
            case Friends.TERM_TYPE_MOBILE_IPAD_NEW /* 72194 */:
                break;
            default:
                z16 = false;
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoginDevicesUtils", 1, "login [" + i3 + "]->[" + z16);
        }
        return z16;
    }

    public static boolean b(long j3) {
        if (j3 != 65793 && j3 != 77313 && j3 != 66831 && j3 != 66818 && j3 != 81154 && j3 != 83714) {
            return false;
        }
        return true;
    }

    public static boolean c(long j3) {
        if (j3 != 72194 && j3 != 68361 && j3 != 65805 && j3 != 68104 && j3 != 88322) {
            return false;
        }
        return true;
    }

    public static boolean d(long j3) {
        if (j3 != 65799 && j3 != 67586) {
            return false;
        }
        return true;
    }

    public static boolean e(int i3) {
        if (i3 != 4 && i3 != 7 && i3 != 8 && i3 != 9 && i3 != 10 && i3 != 11 && i3 != 12 && i3 != 14 && i3 != 16) {
            if (i3 < 100 || i3 >= 200) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static boolean f(long j3) {
        if (j3 != 78082 && j3 != 78096 && j3 != 75023) {
            return false;
        }
        return true;
    }
}
