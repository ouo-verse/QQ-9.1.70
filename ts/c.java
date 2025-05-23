package ts;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "Lts/b;", "a", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class c {
    @Nullable
    public static final b a(@NotNull com.tencent.aio.api.runtime.a getAssistanceService) {
        Intrinsics.checkNotNullParameter(getAssistanceService, "$this$getAssistanceService");
        return com.tencent.aio.runtime.a.a(getAssistanceService).o().getService();
    }
}
