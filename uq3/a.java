package uq3;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f439794a;

    public static String a() {
        if (!TextUtils.isEmpty(f439794a)) {
            return f439794a;
        }
        try {
            Application application = RFWApplication.getApplication();
            f439794a = InstalledAppListMonitor.getPackageInfo(application.getPackageManager(), application.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            f439794a = "getVersionException";
        }
        return f439794a;
    }
}
