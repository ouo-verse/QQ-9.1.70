package t42;

import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class d {
    @Nullable
    public static AppInterface a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        int i3 = MobileQQ.sProcessId;
        if (i3 == 1) {
            return d(peekAppRuntime);
        }
        if (i3 == 7) {
            return b(peekAppRuntime);
        }
        QLog.i("ICGameCaptureContext", 1, "get AppInterface in " + MobileQQ.processName);
        return null;
    }

    private static AppInterface b(AppRuntime appRuntime) {
        AppRuntime appRuntime2 = appRuntime.getAppRuntime("icgame_live_tool");
        if (appRuntime2 instanceof AppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("ICGameCaptureContext", 2, "getAppInterface in tool process");
            }
            return (AppInterface) appRuntime2;
        }
        return null;
    }

    @Nullable
    public static String c() {
        if (MobileQQ.sProcessId == 7) {
            return "icgame_live_tool";
        }
        return null;
    }

    private static AppInterface d(AppRuntime appRuntime) {
        if (appRuntime instanceof AppInterface) {
            if (QLog.isColorLevel()) {
                QLog.d("ICGameCaptureContext", 2, "getAppInterface in main process");
            }
            return (AppInterface) appRuntime;
        }
        return null;
    }
}
