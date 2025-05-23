package ty3;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.monitor.NetworkMonitorCallback;
import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements NetworkMonitorCallback {

    /* renamed from: b, reason: collision with root package name */
    private static a f437910b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<b> f437911a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ty3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public class C11313a implements EIPCResultCallback {
        C11313a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            if (QLog.isColorLevel()) {
                QLog.d(NetworkMonitor.TAG, 2, "eipcResult=", Integer.valueOf(eIPCResult.code), eIPCResult.data);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        String f437913a;

        /* renamed from: b, reason: collision with root package name */
        long f437914b = System.currentTimeMillis();

        b(String str) {
            this.f437913a = str;
        }

        public String a() {
            return this.f437913a;
        }
    }

    public a() {
        if (BaseApplication.networkMonitorCallback == null) {
            BaseApplication.networkMonitorCallback = this;
            if (QLog.isColorLevel()) {
                QLog.d(NetworkMonitor.TAG, 2, "NetworkMonitor init Success! Current ProcessID=", Integer.valueOf(MobileQQ.sProcessId));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(NetworkMonitor.TAG, 2, "BaseApplication.mNetworkMonitorCallback!=null");
        }
    }

    private void a(MonitorHttpInfo monitorHttpInfo, String str, String str2) {
        int i3;
        String str3 = monitorHttpInfo.getHost() + ":" + monitorHttpInfo.getPort() + "/" + monitorHttpInfo.getUrl();
        if (d(str3)) {
            return;
        }
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = this.f437911a;
        if (concurrentLinkedQueue != null) {
            for (Object obj : concurrentLinkedQueue.toArray()) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    try {
                        i3 = e(str3, bVar.a());
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d(NetworkMonitor.TAG, 2, "Exception", th5);
                        }
                        i3 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(NetworkMonitor.TAG, 2, "url=", str3, " bean's url=", bVar.a(), " lcs length=", Integer.valueOf(i3));
                    }
                    if (i3 >= 10) {
                        g(BaseApplication.context, monitorHttpInfo, true, str, str2);
                        return;
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(NetworkMonitor.TAG, 2, "class=", obj.getClass().getSimpleName());
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(NetworkMonitor.TAG, 2, "needDoReport!", monitorHttpInfo.getHost(), monitorHttpInfo.getUrl());
        }
        g(BaseApplication.context, monitorHttpInfo, false, str, str2);
    }

    private static boolean d(String str) {
        if (!TextUtils.isEmpty(str) && (str.endsWith("patch") || str.contains("QQpeizhiwenjian") || str.contains("/qun/configs/") || str.contains("qzonestyle") || str.contains("gxh.vip.qq.com") || str.contains("/tmp_video/quic") || str.contains("groupgift") || str.contains("vac.gtimg.cn") || str.contains("sqimg.qq.com") || str.contains("imgcache.qq.com") || str.contains("imgcache.gtimg.cn") || str.contains("i.gtimg.cn") || str.contains("cmshow.gtimg.cn") || str.contains("myapp/qq_desk") || str.contains("myapp/qqteam") || str.contains("myapp/qqt") || str.contains("plugin") || str.contains("Plugin") || str.contains("cgi-bin/httpconn") || str.contains("mobileqq/FT") || str.contains("ftn_handler") || str.contains("comp_bsdiff") || str.contains("qqpitu/jsons") || str.contains("hudongzip-1251316161.file.myqcloud.com") || str.contains("sngapp/app/update") || str.contains("qqpitu/materials/") || str.contains("hotfiles") || str.contains("2Q2W") || str.contains("soft.tbs.imtt") || str.contains("AndroidQQPlugin"))) {
            return true;
        }
        return false;
    }

    private int e(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length, length2);
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            for (int i17 = 0; i17 < length2; i17++) {
                if (str.charAt(i16) == str2.charAt(i17)) {
                    if (i16 != 0 && i17 != 0) {
                        iArr[i16][i17] = iArr[i16 - 1][i17 - 1] + 1;
                    } else {
                        iArr[i16][i17] = 1;
                    }
                    int i18 = iArr[i16][i17];
                    if (i3 < i18) {
                        i3 = i18;
                    }
                }
            }
        }
        return i3;
    }

    public static a f() {
        a aVar;
        a aVar2 = f437910b;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (a.class) {
            if (f437910b == null) {
                f437910b = new a();
            }
            aVar = f437910b;
        }
        return aVar;
    }

    public static void g(Context context, MonitorHttpInfo monitorHttpInfo, boolean z16, String str, String str2) {
        String str3;
        String str4;
        if (monitorHttpInfo != null && context != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("url", monitorHttpInfo.getHost() + ":" + monitorHttpInfo.getPort() + "/" + monitorHttpInfo.getUrl());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(monitorHttpInfo.getResponseLength());
            sb5.append("");
            hashMap.put("fileSize", sb5.toString());
            hashMap.put("mimeType", monitorHttpInfo.getMimeType());
            hashMap.put("method", monitorHttpInfo.getMethod());
            hashMap.put("ResponseBodyHex", monitorHttpInfo.getResponseBodyHex());
            hashMap.put("type", monitorHttpInfo.getType());
            hashMap.put("ResponseCode", monitorHttpInfo.getResponseCode());
            hashMap.put("processName", str);
            if (str2 == null) {
                str3 = "null";
            } else {
                str3 = str2;
            }
            hashMap.put("CurrentActivity", str3);
            hashMap.put("reportVia", "4");
            if (z16) {
                StatisticCollector.getInstance(context).collectPerformance(null, "MonitorApkDownload", true, 0L, 0L, hashMap, "");
            } else {
                StatisticCollector.getInstance(context).collectPerformance(null, "UnMonitorApkDownload", true, 0L, 0L, hashMap, "");
            }
            if (QLog.isColorLevel()) {
                if (z16) {
                    str4 = "MonitorApkDownload{";
                } else {
                    str4 = "UnMonitorApkDownload{";
                }
                StringBuilder sb6 = new StringBuilder(str4);
                sb6.append(" ProcessName=");
                sb6.append(str);
                sb6.append(" ");
                for (String str5 : hashMap.keySet()) {
                    sb6.append(str5);
                    sb6.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb6.append(hashMap.get(str5));
                    sb6.append("\n");
                }
                QLog.d(NetworkMonitor.TAG, 2, sb6.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(NetworkMonitor.TAG, 2, "httpInfo is null");
        }
    }

    @Override // com.tencent.mobileqq.monitor.NetworkMonitorCallback
    public void addDownloadURL(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(NetworkMonitor.TAG, 2, "addDownloadURL=", str);
        }
        if (1 != MobileQQ.sProcessId) {
            Bundle bundle = new Bundle();
            bundle.putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_URL", str);
            QIPCClientHelper.getInstance().callServer("NetworkMonitorIPCModule", "ACTION_REPORT_DOWNLOAD_URL", bundle, new C11313a());
            return;
        }
        b(str);
    }

    @Override // com.tencent.mobileqq.monitor.NetworkMonitorCallback
    public void addHttpInfo(MonitorHttpInfo monitorHttpInfo) {
        if (monitorHttpInfo == null) {
            return;
        }
        String str = null;
        try {
            if (Foreground.getTopActivity() != null) {
                str = Foreground.getTopActivity().getClass().getName();
            }
        } catch (Throwable unused) {
        }
        if (1 != MobileQQ.sProcessId) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("BUNDLE_KEY_REPORT_HTTP_INFO_INFO", monitorHttpInfo);
            bundle.putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_PROCESS_NAME", MobileQQ.processName);
            if (str == null) {
                str = "Null";
            }
            bundle.putString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_TOP_ACTIVITY", str);
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "NetworkMonitorIPCModule", "ACTION_REPORT_HTTPINFO", bundle);
            return;
        }
        if (str == null) {
            str = "Null";
        }
        try {
            c(monitorHttpInfo, "com.tencent.mobileqq", str);
        } catch (Throwable unused2) {
        }
    }

    public void b(String str) {
        b peek;
        if (this.f437911a == null) {
            this.f437911a = new ConcurrentLinkedQueue<>();
        }
        b bVar = new b(str);
        this.f437911a.add(bVar);
        if (QLog.isColorLevel()) {
            QLog.d(NetworkMonitor.TAG, 2, "doRealAddDownloadURL=", str);
        }
        while (!this.f437911a.isEmpty() && (peek = this.f437911a.peek()) != null && peek.f437914b - bVar.f437914b > 600000) {
            this.f437911a.poll();
        }
    }

    public void c(MonitorHttpInfo monitorHttpInfo, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(NetworkMonitor.TAG, 2, "doRealAddHttpInfo=", monitorHttpInfo);
        }
        if (monitorHttpInfo.getFileType() == 1 || monitorHttpInfo.getFileType() == 2) {
            a(monitorHttpInfo, str, str2);
        }
    }
}
