package qy3;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.perf.tool.QQPerfHandlerThreadManager;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import com.tencent.qqperf.tools.e;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static volatile a f430309i;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.qqperf.monitor.filedescriptor.a f430313d;

    /* renamed from: a, reason: collision with root package name */
    private int f430310a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f430311b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f430312c = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f430314e = MiniBoxNoticeInfo.MIN_5;

    /* renamed from: f, reason: collision with root package name */
    private volatile Handler f430315f = new Handler(QQPerfHandlerThreadManager.c().getLooper(), new C11103a());

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.perf.tracker.callback.a f430316g = new b();

    /* renamed from: h, reason: collision with root package name */
    private volatile Integer f430317h = null;

    /* compiled from: P */
    /* renamed from: qy3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    class C11103a implements Handler.Callback {
        C11103a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what == 10240) {
                a.this.e();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class b extends com.tencent.mobileqq.perf.tracker.callback.a {
        b() {
        }

        @Override // com.tencent.mobileqq.perf.tracker.callback.a, mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            a.this.f430311b = 0;
            a.this.f430315f.removeMessages(10240);
            long decodeLong = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeLong("fd_normal_last_tick_time", 0L);
            long uptimeMillis = SystemClock.uptimeMillis() - decodeLong;
            if (uptimeMillis < a.this.f430314e && uptimeMillis > 0) {
                a.this.f430315f.sendEmptyMessageAtTime(10240, decodeLong + a.this.f430314e);
            } else {
                a.this.f430315f.sendEmptyMessageDelayed(10240, 10000L);
            }
        }
    }

    a() {
        this.f430313d = null;
        this.f430313d = com.tencent.qqperf.monitor.filedescriptor.a.c();
        if (Math.random() < this.f430313d.d()) {
            SceneTracker.f258213d.l(this.f430316g);
            h();
        } else if (QLog.isColorLevel()) {
            QLog.d("FileDescriptorMonitor", 2, "FileDescriptorMonitor not init, monitorConfig is " + this.f430313d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (QLog.isColorLevel()) {
            QLog.d("FileDescriptorMonitor", 2, "doNormalReport start");
        }
        if (!SceneTracker.e().equalsIgnoreCase(MobileQQ.processName)) {
            if (QLog.isColorLevel()) {
                QLog.w("FileDescriptorMonitor", 2, "doNormalReport jump for no process: " + SceneTracker.e() + "|" + MobileQQ.processName);
                return;
            }
            return;
        }
        QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeLong("fd_normal_last_tick_time", SystemClock.uptimeMillis());
        if (!SceneTracker.j()) {
            if (QLog.isColorLevel()) {
                QLog.d("FileDescriptorMonitor", 2, "get background fdInfo, backGroundReportCount is $backGroundReportCount");
            }
            if (this.f430311b < this.f430313d.a()) {
                this.f430311b++;
                this.f430315f.sendEmptyMessageDelayed(10240, this.f430314e);
            }
        } else {
            this.f430315f.sendEmptyMessageDelayed(10240, this.f430314e);
        }
        if (i()) {
            j();
            this.f430310a++;
            this.f430312c++;
            QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("fd_normal_report_count", this.f430312c);
        }
    }

    public static synchronized a g() {
        a aVar;
        synchronized (a.class) {
            if (f430309i == null) {
                f430309i = new a();
            }
            aVar = f430309i;
        }
        return aVar;
    }

    private void h() {
        this.f430310a = 0;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        long decodeLong = from.decodeLong("fd_normal_report_yesterday_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (decodeLong - currentTimeMillis > 86400000) {
            from.encodeLong("fd_normal_report_yesterday_time", currentTimeMillis);
            from.encodeInt("fd_normal_report_count", 0);
        } else {
            this.f430312c = from.decodeInt("fd_normal_report_count", 0);
        }
    }

    private boolean i() {
        if (Math.random() < this.f430313d.d() && (this.f430312c < this.f430313d.b() || this.f430310a < this.f430313d.e())) {
            return true;
        }
        return false;
    }

    private void j() {
        String str;
        int f16 = f();
        int a16 = e.a();
        String e16 = SceneTracker.e();
        boolean z16 = !SceneTracker.j();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = "null";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reportUin", str);
        hashMap.put("fdLimit", f16 + "");
        hashMap.put("fdCount", a16 + "");
        hashMap.put("processName", e16);
        hashMap.put("isBackground", z16 + "");
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(QQCrashReportManager.f363157a, "fd_monitor_normal_report", true, 0L, 0L, hashMap, "", false);
        if (QLog.isColorLevel()) {
            QLog.i("FileDescriptorMonitor", 2, "realReportNormalInfo currentFDCount=" + a16 + " |isBackground=" + z16);
        }
    }

    public int f() {
        int i3;
        if (this.f430317h == null) {
            if (Build.VERSION.SDK_INT < 28) {
                i3 = 1024;
            } else {
                i3 = 32768;
            }
            int c16 = e.c();
            if (c16 != 0) {
                i3 = c16;
            }
            this.f430317h = Integer.valueOf(i3);
        }
        return this.f430317h.intValue();
    }

    public void k() {
        if (Math.random() < this.f430313d.d()) {
            this.f430315f.sendEmptyMessageDelayed(10240, 10000L);
        } else if (QLog.isColorLevel()) {
            QLog.d("FileDescriptorMonitor", 2, "startFileDescriptorNormalMonitorReport jump, monitorConfig is " + this.f430313d);
        }
    }
}
