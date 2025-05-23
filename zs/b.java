package zs;

import com.tencent.aio.base.thread.DisplayListDispatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", "Lzs/a;", "a", "(Lkotlinx/coroutines/Dispatchers;)Lzs/a;", "DisplayList", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class b {
    @NotNull
    public static final a a(@NotNull Dispatchers DisplayList) {
        Intrinsics.checkNotNullParameter(DisplayList, "$this$DisplayList");
        return DisplayListDispatcher.f69214f;
    }
}
