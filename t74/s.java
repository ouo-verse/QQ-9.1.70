package t74;

import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lt74/s;", "", "", "a", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "callback", "", "b", "c", "<init>", "()V", "superqqshow-base-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public static final s f435588a = new s();

    s() {
    }

    public final boolean a() {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            return guardManager.isApplicationForeground();
        }
        return false;
    }

    public final void b(IGuardInterface callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.registerCallBack(callback);
        }
    }

    public final void c(IGuardInterface callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager != null) {
            guardManager.unregisterCallback(callback);
        }
    }
}
