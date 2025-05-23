package zi2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.matrix.backtrace.WeChatBacktrace;
import com.tencent.matrix.hook.HookManager;
import com.tencent.matrix.hook.pthread.PthreadHook;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqmatrix.threadleak.ThreadLeakMonitorRunnable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.UploadQualityReportBuilder;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements BusinessObserver, Application.ActivityLifecycleCallbacks {

    /* renamed from: d, reason: collision with root package name */
    private ThreadLeakMonitorRunnable f452594d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f452595e = false;

    public synchronized boolean a() {
        if (this.f452595e) {
            return true;
        }
        try {
            WeChatBacktrace.k().e(MobileQQ.sMobileQQ).b(WeChatBacktrace.Mode.Fp).a();
            PthreadHook pthreadHook = PthreadHook.f151479i;
            pthreadHook.f(".*").k(true).j(true).i(false);
            pthreadHook.h(false);
            HookManager.f151453e.a(pthreadHook).b();
            this.f452595e = true;
            return true;
        } catch (Exception e16) {
            QLog.e("QQThreadLeakMonitor", 1, "Init Matrix Hook components Error:" + e16);
            return false;
        }
    }

    public boolean b() {
        return this.f452595e;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        QLog.d("QQThreadLeakMonitor", 1, "onActivityStopped: " + activity.getClass().getName());
        synchronized (this) {
            ThreadLeakMonitorRunnable threadLeakMonitorRunnable = this.f452594d;
            if (threadLeakMonitorRunnable != null) {
                ThreadManagerV2.excute(threadLeakMonitorRunnable, 192, null, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 == 0) {
            QLog.d("QQThreadLeakMonitor", 1, UploadQualityReportBuilder.STATE_UPLOAD_SUCCESS);
            com.tencent.mobileqq.qqmatrix.threadleak.a.p();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
