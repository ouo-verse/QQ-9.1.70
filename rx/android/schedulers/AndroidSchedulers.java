package rx.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AndroidSchedulers {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class MainThreadSchedulerHolder {
        static final Scheduler MAIN_THREAD_SCHEDULER = new HandlerScheduler(new Handler(Looper.getMainLooper()));

        MainThreadSchedulerHolder() {
        }
    }

    AndroidSchedulers() {
        throw new AssertionError("No instances");
    }

    public static Scheduler mainThread() {
        Scheduler mainThreadScheduler = RxAndroidPlugins.getInstance().getSchedulersHook().getMainThreadScheduler();
        if (mainThreadScheduler == null) {
            return MainThreadSchedulerHolder.MAIN_THREAD_SCHEDULER;
        }
        return mainThreadScheduler;
    }
}
