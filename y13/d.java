package y13;

import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\b"}, d2 = {"Ljava/lang/Runnable;", TencentLocation.RUN_MODE, "", "c", "b", "", "delay", "a", "vas_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d {
    public static final void a(long j3, @NotNull Runnable run) {
        Intrinsics.checkNotNullParameter(run, "run");
        ThreadManagerV2.executeDelay(run, 16, null, false, j3);
    }

    public static final void b(@NotNull Runnable run) {
        Intrinsics.checkNotNullParameter(run, "run");
        ThreadManagerV2.excute(run, 16, null, false);
    }

    public static final void c(@NotNull Runnable run) {
        Intrinsics.checkNotNullParameter(run, "run");
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            run.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(run);
        }
    }
}
