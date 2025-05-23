package wx3;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lwx3/b;", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class a {
        public static void a(@NotNull b bVar, @NotNull Context context, long j3, long j16, @NotNull String robotName, @NotNull List<? extends Object> templateIds, @NotNull Function1<? super Integer, Unit> callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(robotName, "robotName");
            Intrinsics.checkNotNullParameter(templateIds, "templateIds");
            Intrinsics.checkNotNullParameter(callback, "callback");
            QLog.d("IRobotCommandActionCompatApi.DefaultImpl", 4, "[showTicketRequestDialog]: ");
        }
    }
}
