package wy3;

import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqperftool.crashdefend.f;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f446771a = new AtomicBoolean(false);

    /* compiled from: P */
    /* renamed from: wy3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    private static class C11521a {

        /* renamed from: a, reason: collision with root package name */
        static a f446772a = new a();
    }

    public static a f() {
        return C11521a.f446772a;
    }

    public boolean a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (this.f446771a.get()) {
            Log.i("PerfToolBridge", "addConfigCrashDefender name:" + str);
            return com.tencent.mobileqq.qqperftool.a.a(str, str2, str3);
        }
        return false;
    }

    public boolean b(com.tencent.mobileqq.qqperftool.crash.d dVar) {
        if (this.f446771a.get()) {
            return com.tencent.mobileqq.qqperftool.a.b(dVar);
        }
        return false;
    }

    public boolean c(f.a aVar) {
        if (this.f446771a.get() && aVar != null) {
            com.tencent.mobileqq.qqperftool.a.g(aVar);
            Log.i("PerfToolBridge", "beginStartStepCrashDefend isRegisterToSystem = " + com.tencent.mobileqq.qqperftool.a.h());
            return true;
        }
        return false;
    }

    public boolean d(String str) {
        if (this.f446771a.get()) {
            Log.i("PerfToolBridge", "containCrashDefender name:" + str);
            return com.tencent.mobileqq.qqperftool.a.c(str);
        }
        return false;
    }

    public boolean e() {
        if (this.f446771a.get()) {
            com.tencent.mobileqq.qqperftool.a.d();
            return true;
        }
        return false;
    }

    public List<com.tencent.mobileqq.qqperftool.crash.b> g() {
        if (!this.f446771a.get()) {
            return null;
        }
        return com.tencent.mobileqq.qqperftool.a.e();
    }

    public void h(boolean z16, boolean z17) {
        if (this.f446771a.compareAndSet(false, true)) {
            com.tencent.mobileqq.qqperftool.a.f(z16, z17);
        }
    }

    public void i(@NonNull Thread thread, @NonNull Throwable th5) {
        if (this.f446771a.get()) {
            com.tencent.mobileqq.qqperftool.a.i(thread, th5);
        }
    }

    public void j(boolean z16) {
        if (this.f446771a.get()) {
            com.tencent.mobileqq.qqperftool.a.j(z16);
        }
    }

    public boolean k(@NonNull String str) {
        if (this.f446771a.get()) {
            return com.tencent.mobileqq.qqperftool.a.l(str);
        }
        return false;
    }

    public boolean l(com.tencent.mobileqq.qqperftool.crash.d dVar) {
        if (this.f446771a.get()) {
            com.tencent.mobileqq.qqperftool.a.k(dVar);
            return true;
        }
        return false;
    }

    public boolean m(com.tencent.mobileqq.qqperftool.common.d dVar) {
        if (this.f446771a.get()) {
            Log.i("PerfToolBridge", "setLoger");
            com.tencent.mobileqq.qqperftool.a.m(dVar);
            dVar.d("PerfToolBridge", "setLoger end test");
            return true;
        }
        return false;
    }

    public void n() {
        if (this.f446771a.get()) {
            com.tencent.mobileqq.qqperftool.a.n();
        }
    }
}
