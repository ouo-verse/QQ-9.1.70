package xc2;

import com.tencent.mobileqq.opr.model.RequestParam;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J;\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005H\u0017J\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lxc2/c;", "", "", "lloc", "uin", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "callback", "a", "Lcom/tencent/mobileqq/opr/model/RequestParam;", "param", "", "b", "(Lcom/tencent/mobileqq/opr/model/RequestParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public interface c {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        @Deprecated(message = "\u4f7f\u7528requestCmd\u901a\u7528\u901a\u9053")
        public static void a(@NotNull c cVar, @NotNull String lloc, @NotNull String uin, @NotNull Function1<? super String, Unit> callback) {
            Intrinsics.checkNotNullParameter(cVar, "this");
            Intrinsics.checkNotNullParameter(lloc, "lloc");
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    @Deprecated(message = "\u4f7f\u7528requestCmd\u901a\u7528\u901a\u9053")
    void a(@NotNull String lloc, @NotNull String uin, @NotNull Function1<? super String, Unit> callback);

    @Nullable
    Object b(@NotNull RequestParam requestParam, @NotNull Continuation<? super byte[]> continuation);
}
