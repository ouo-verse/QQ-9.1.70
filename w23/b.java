package w23;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lw23/b;", "Lx23/a;", "", "a", "msg", "", "i", "e", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b implements x23.a {
    @NotNull
    public String a() {
        return "VasReportQLogProxy";
    }

    @Override // x23.a
    public void e(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.e(a(), 1, msg2);
    }

    @Override // x23.a
    public void i(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i(a(), 1, msg2);
    }
}
