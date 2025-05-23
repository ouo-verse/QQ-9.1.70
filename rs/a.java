package rs;

import com.tencent.qphone.base.util.QLog;
import org.light.utils.ILightLogger;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a implements ILightLogger {
    @Override // org.light.utils.ILightLogger
    public void d(String str, String str2) {
        QLog.d("AELightLog_" + str, 4, str2);
    }

    @Override // org.light.utils.ILightLogger
    public void e(String str, String str2) {
        QLog.e("AELightLog_" + str, 1, str2);
    }

    @Override // org.light.utils.ILightLogger
    public void i(String str, String str2) {
        QLog.i("AELightLog_" + str, 1, str2);
    }

    @Override // org.light.utils.ILightLogger
    public void log(int i3, String str, String str2) {
        if (i3 == 3) {
            d(str, str2);
            return;
        }
        if (i3 == 4) {
            i(str, str2);
        } else if (i3 == 5) {
            w(str, str2);
        } else {
            if (i3 != 6) {
                return;
            }
            e(str, str2);
        }
    }

    @Override // org.light.utils.ILightLogger
    public void v(String str, String str2) {
    }

    @Override // org.light.utils.ILightLogger
    public void w(String str, String str2) {
        QLog.w("AELightLog_" + str, 1, str2);
    }

    @Override // org.light.utils.ILightLogger
    public void d(String str, String str2, Throwable th5) {
        QLog.d("AELightLog_" + str, 4, str2, th5);
    }

    @Override // org.light.utils.ILightLogger
    public void e(String str, String str2, Throwable th5) {
        QLog.e("AELightLog_" + str, 1, str2, th5);
    }

    @Override // org.light.utils.ILightLogger
    public void i(String str, String str2, Throwable th5) {
        QLog.i("AELightLog_" + str, 1, str2, th5);
    }

    @Override // org.light.utils.ILightLogger
    public void v(String str, String str2, Throwable th5) {
    }

    @Override // org.light.utils.ILightLogger
    public void w(String str, String str2, Throwable th5) {
        QLog.w("AELightLog_" + str, 1, str2, th5);
    }

    @Override // org.light.utils.ILightLogger
    public void log(int i3, String str, String str2, Throwable th5) {
        if (i3 == 3) {
            d(str, str2, th5);
            return;
        }
        if (i3 == 4) {
            i(str, str2, th5);
        } else if (i3 == 5) {
            w(str, str2, th5);
        } else {
            if (i3 != 6) {
                return;
            }
            e(str, str2, th5);
        }
    }
}
