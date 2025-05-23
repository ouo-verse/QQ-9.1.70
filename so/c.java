package so;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.common.DownloadReceiverQZoneProcess;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static Object f434016c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static c f434017d;

    /* renamed from: b, reason: collision with root package name */
    private DownloadReceiverQZoneProcess f434019b = new DownloadReceiverQZoneProcess();

    /* renamed from: a, reason: collision with root package name */
    private Context f434018a = BaseApplication.getContext();

    c() {
    }

    public static c a() {
        if (f434017d == null) {
            synchronized (f434016c) {
                if (f434017d == null) {
                    f434017d = new c();
                }
            }
        }
        return f434017d;
    }

    public void b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.open.download.start");
        intentFilter.addAction("com.tencent.open.download.complete");
        intentFilter.addAction("com.tencent.open.download.open");
        intentFilter.addAction("com.tencent.open.download.yyb");
        intentFilter.addAction("com.tencent.open.download.restart");
        intentFilter.addAction("com.tencent.open.download.pause");
        this.f434018a.registerReceiver(this.f434019b, intentFilter);
    }

    public void c() {
        try {
            DownloadApi.b("_appid");
        } catch (Throwable th5) {
            QZLog.w(th5);
        }
        this.f434018a.unregisterReceiver(this.f434019b);
    }
}
