package vf4;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.utils.l;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static AppRuntime a() {
        AppRuntime appRuntime;
        QBaseActivity b16 = b();
        if (b16 != null) {
            appRuntime = b16.getAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            try {
                appRuntime = MobileQQ.sMobileQQ.getAppRuntime(((ll4.a) mm4.b.b(ll4.a.class)).B());
                l.i("TimiGameActivityManager_", "appRuntime from sMobileQQ");
                return appRuntime;
            } catch (AccountNotMatchException e16) {
                l.f("TimiGameActivityManager_", "getAppRuntime failed", e16);
                return appRuntime;
            }
        }
        l.i("TimiGameActivityManager_", "appRuntime from topActivity");
        return appRuntime;
    }

    public static QBaseActivity b() {
        return QBaseActivity.sTopActivity;
    }

    public static TimiGameBaseActivity c() {
        QBaseActivity b16 = b();
        if (b16 instanceof TimiGameBaseActivity) {
            return (TimiGameBaseActivity) b16;
        }
        return null;
    }

    public static boolean d() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }
}
