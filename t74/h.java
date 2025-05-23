package t74;

import android.os.Looper;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0006\u0010\t\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lt74/h;", "", "", "b", "", "process", "c", "e", "a", "d", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f435542a = new h();

    h() {
    }

    @JvmStatic
    public static final boolean a(String process) {
        boolean endsWith$default;
        if (!MobileQQ.processName.equals(process)) {
            if (TextUtils.isEmpty(process)) {
                return false;
            }
            String processName = MobileQQ.processName;
            Intrinsics.checkNotNullExpressionValue(processName, "processName");
            Intrinsics.checkNotNull(process);
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(processName, process, false, 2, null);
            if (!endsWith$default) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean b() {
        return MobileQQ.sProcessId == 1;
    }

    @JvmStatic
    public static final boolean c(String process) {
        Intrinsics.checkNotNullParameter(process, "process");
        return MobileQQ.PACKAGE_NAME.equals(process);
    }

    @JvmStatic
    public static final boolean e() {
        return a("com.tencent.mobileqq:zplan");
    }

    public final boolean d() {
        return Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
    }
}
