package uh1;

import androidx.annotation.MainThread;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.DevelopInfoUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\rR\u0016\u0010\u000f\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Luh1/a;", "", "", "step", "", "d", "b", "c", "", "a", "", "Z", "enable", "J", "beginTime", "traceTime", "e", "Ljava/lang/String;", "currStep", "", "f", "I", "inc", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f438959a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean enable = true;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long beginTime = System.currentTimeMillis();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long traceTime = System.currentTimeMillis();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String currStep = "begin";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int inc;

    static {
        QLog.i("MVPFeedsTrace", 1, "init appVersion:" + AppSetting.f99554n + " branch:" + DevelopInfoUtils.getBranchName(true));
    }

    a() {
    }

    public final long a() {
        return System.currentTimeMillis() - beginTime;
    }

    @MainThread
    public final void d(@NotNull String step) {
        Intrinsics.checkNotNullParameter(step, "step");
        if (!enable) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - traceTime;
        long j16 = currentTimeMillis - beginTime;
        int i3 = inc + 1;
        inc = i3;
        QLog.i("MVPFeedsTrace", 1, "step_" + i3 + ":" + currStep + " --> " + step + "  currStepCost: " + j3 + "ms all_cost: " + j16 + "ms");
        currStep = step;
        traceTime = System.currentTimeMillis();
        if (j16 > 10000) {
            QLog.i("MVPFeedsTrace", 1, "step:" + currStep + " --> " + step + "  currStepCost: " + j3 + "ms all_cost: " + j16 + "ms");
            enable = false;
        }
    }

    public final void b() {
    }

    public final void c() {
    }
}
