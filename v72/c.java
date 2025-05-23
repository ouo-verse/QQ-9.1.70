package v72;

import android.os.Build;
import android.os.Trace;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0000\u001a\u0006\u0010\u0007\u001a\u00020\u0002\u001a\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0000\u001a\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0000\u001a\f\u0010\u000b\u001a\u00020\u0000*\u00020\u0000H\u0002\"\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000e\"\u0014\u0010\u0013\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0015\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"", "methodName", "", h.F, "d", "method", "b", "e", "name", "a", "c", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "actions", "", "g", "()Z", "enableTrace", "f", "enableMeasure", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f441214a = new ConcurrentHashMap<>();

    public static final void a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (g() && Build.VERSION.SDK_INT >= 29) {
            Trace.beginAsyncSection(i("MatchFriend#" + name), 11);
        }
    }

    public static final void b(String method) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (g()) {
            Trace.beginSection(i("MatchFriend#" + method));
        }
    }

    public static final void c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (g() && Build.VERSION.SDK_INT >= 29) {
            Trace.endAsyncSection(i("MatchFriend#" + name), 11);
        }
    }

    public static final void d(String methodName) {
        Long remove;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (f() && (remove = f441214a.remove(methodName)) != null) {
            QLog.w("MatchFriend#", 2, methodName + " spend " + (System.currentTimeMillis() - remove.longValue()));
        }
    }

    public static final void e() {
        if (g()) {
            Trace.endSection();
        }
    }

    private static final boolean f() {
        return false;
    }

    private static final boolean g() {
        return false;
    }

    public static final void h(String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        if (f()) {
            f441214a.put(methodName, Long.valueOf(System.currentTimeMillis()));
        }
    }

    private static final String i(String str) {
        return str.length() > 127 ? str.subSequence(0, 50).toString() : str;
    }
}
