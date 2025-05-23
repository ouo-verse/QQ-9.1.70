package yz4;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.io.File;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b implements d {
    @Override // yz4.d
    public final Uri a(@NonNull Context context, @NonNull String str, @NonNull File file) {
        try {
            return FileProvider.getUriForFile(context, str, file);
        } catch (Throwable th5) {
            XhsShareSdk.d("XhsShare_AndroidXFileProvider", "getUriForFile error.", th5);
            return null;
        }
    }
}
