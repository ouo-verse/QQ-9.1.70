package yz4;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.xingin.xhssharesdk.core.XhsShareSdk;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public Method f451651a;

    @Override // yz4.d
    public final Uri a(@NonNull Context context, @NonNull String str, @NonNull File file) {
        Method method = this.f451651a;
        if (method == null) {
            return null;
        }
        try {
            return (Uri) method.invoke(null, context, str, file);
        } catch (Throwable th5) {
            XhsShareSdk.d("XhsShare_AndroidSupportFileProvider", "getUriForFile error.", th5);
            return null;
        }
    }
}
