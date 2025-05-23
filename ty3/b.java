package ty3;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private static b f437916d;

    b(String str) {
        super(str);
    }

    public static b b() {
        if (f437916d == null) {
            synchronized (b.class) {
                if (f437916d == null) {
                    f437916d = new b("NetworkMonitorIPCModule");
                }
            }
        }
        return f437916d;
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("NetworkMonitorIPCModule", 2, "NetworkMonitorIPCModule : " + str + ", " + bundle.toString(), ", " + i3);
        }
        if ("ACTION_REPORT_DOWNLOAD_URL".equalsIgnoreCase(str)) {
            a.f().b(bundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_URL", ""));
        } else if ("ACTION_REPORT_HTTPINFO".equalsIgnoreCase(str)) {
            try {
                MonitorHttpInfo monitorHttpInfo = (MonitorHttpInfo) bundle.getSerializable("BUNDLE_KEY_REPORT_HTTP_INFO_INFO");
                String string = bundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_PROCESS_NAME", "");
                String string2 = bundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_TOP_ACTIVITY", "");
                if (monitorHttpInfo != null) {
                    try {
                        a.f().c(monitorHttpInfo, string, string2);
                    } catch (Throwable unused) {
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("NetworkMonitorIPCModule", 2, "MonitorHttpInfo == null");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("NetworkMonitorIPCModule", 2, "ClassCastException", e16.toString());
                }
            }
        }
        return new EIPCResult();
    }
}
