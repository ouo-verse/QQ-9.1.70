package qz4;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.xingin.xhssharesdk.callback.XhsShareCallback;

/* compiled from: P */
/* loaded from: classes28.dex */
public final /* synthetic */ class a {
    @MainThread
    public static void a(XhsShareCallback xhsShareCallback, @NonNull String str, int i3, @Deprecated int i16, @NonNull String str2, @Nullable Throwable th5) {
        xhsShareCallback.onError(str, i16, str2, th5);
    }
}
