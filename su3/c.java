package su3;

import com.tencent.aio.data.AIOParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0015\u0010\b\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0015\u0010\f\u001a\u00020\t*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/aio/data/AIOParam;", "", "c", "(Lcom/tencent/aio/data/AIOParam;)I", "uinType", "", "a", "(Lcom/tencent/aio/data/AIOParam;)J", "peerUin", "", "b", "(Lcom/tencent/aio/data/AIOParam;)Ljava/lang/String;", "peerUinStr", "aio_adapter_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    public static final long a(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return aIOParam.l().getLong("key_peerUin");
    }

    @NotNull
    public static final String b(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        return String.valueOf(aIOParam.l().getLong("key_peerUin"));
    }

    public static final int c(@NotNull AIOParam aIOParam) {
        Intrinsics.checkNotNullParameter(aIOParam, "<this>");
        int e16 = aIOParam.r().c().e();
        if (e16 == 1) {
            return 0;
        }
        if (e16 == 2) {
            return 1;
        }
        if (e16 != 100) {
            if (e16 != 101) {
                if (e16 != 104) {
                    return 0;
                }
                return 1046;
            }
            return 1022;
        }
        return 1000;
    }
}
