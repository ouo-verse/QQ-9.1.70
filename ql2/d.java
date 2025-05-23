package ql2;

import android.os.SystemClock;
import com.tencent.mobileqq.qwallet.utils.f;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "vacdReporter\u5df2\u4e0b\u67b6\uff0c\u540e\u7eed\u6709\u7a7a\u8bf7\u6539\u9020")
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\"\u00020\u0001\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lql2/d;", "", "", "a", "", "action", "", "steps", "", "b", "(Ljava/lang/String;[Ljava/lang/Object;)V", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f429062a = new d();

    d() {
    }

    @JvmStatic
    public static final long a() {
        return SystemClock.uptimeMillis();
    }

    public final void b(@NotNull String action, @NotNull Object... steps) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(steps, "steps");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("reportStepsInOrder: action ");
        sb5.append(action);
        sb5.append(", params ");
        String arrays = Arrays.toString(steps);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        sb5.append(arrays);
        f.b("QWalletPerformanceReporter", sb5.toString());
    }
}
