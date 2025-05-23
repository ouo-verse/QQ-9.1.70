package wx3;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lwx3/a;", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: wx3.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C11520a {
        public static void a(@NotNull a aVar, @NotNull String source, @NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull String schema, @Nullable Object[] objArr) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            Intrinsics.checkNotNullParameter(schema, "schema");
            QLog.d("IRobotCommandActionCompatApi.DefaultImpl", 4, "[doSchemaAction]: schema=" + schema + ", source=" + source);
        }
    }
}
