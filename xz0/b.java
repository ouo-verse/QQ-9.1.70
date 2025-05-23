package xz0;

import com.tencent.component.utils.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u00a8\u0006\u0007"}, d2 = {"", "message", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "a", "lib_record_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes7.dex */
public final class b {
    public static final void a(@NotNull String message, @Nullable Exception exc) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        if (exc != null) {
            LogUtil.e("stream_download_v2", message, exc);
        } else {
            LogUtil.i("stream_download_v2", message);
        }
    }

    public static /* synthetic */ void b(String str, Exception exc, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            exc = null;
        }
        a(str, exc);
    }
}
