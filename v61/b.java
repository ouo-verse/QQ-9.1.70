package v61;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements Application.ActivityLifecycleCallbacks {

    /* renamed from: h, reason: collision with root package name */
    private static b f441183h = new b();

    /* renamed from: d, reason: collision with root package name */
    private Stack<a> f441184d = new Stack<>();

    /* renamed from: e, reason: collision with root package name */
    private boolean f441185e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f441186f = 0;

    b() {
    }

    public static b a() {
        return f441183h;
    }

    private void f(@NonNull Activity activity) {
        if (activity.hashCode() == this.f441186f) {
            QLog.i("AIOTaskStack", 1, "stopRecordTask: " + activity + " hashCode is " + this.f441186f);
            if (!this.f441184d.empty()) {
                this.f441184d.clear();
            }
            this.f441185e = false;
            BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    public a b() {
        if (this.f441184d.empty()) {
            return new a();
        }
        return this.f441184d.peek().b();
    }

    public void d(a aVar) {
        if (!this.f441185e) {
            return;
        }
        int i3 = aVar.f441181c;
        if (i3 != 1 && i3 != 2) {
            return;
        }
        this.f441184d.push(aVar);
        QLog.i("AIOTaskStack", 1, "record, size is " + this.f441184d.size() + " task is " + aVar.toString());
    }

    public void e(Activity activity) {
        if (activity == null) {
            return;
        }
        this.f441186f = activity.hashCode();
        QLog.i("AIOTaskStack", 1, "startRecordAIOTask: " + activity + " hashCode is " + this.f441186f);
        if (this.f441185e) {
            if (!this.f441184d.empty()) {
                this.f441184d.clear();
            }
        } else {
            this.f441185e = true;
            BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        f(activity);
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
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }
}
