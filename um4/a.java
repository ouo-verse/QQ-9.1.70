package um4;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lum4/a;", "", "", "url", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "option", "Lcom/tencent/image/URLDrawable;", "a", "path", "", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f439223a = new a();

    a() {
    }

    @Nullable
    public final URLDrawable a(@NotNull String url, @Nullable URLDrawable.URLDrawableOptions option) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            if (QLog.isColorLevel()) {
                QLog.d("GiftDataUtil_", 2, "getDrawable url:" + url);
            }
            if (b(url)) {
                return URLDrawable.getDrawable(url, option);
            }
            return URLDrawable.getFileDrawable(url, option);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final boolean b(@NotNull String path) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(path, "path");
        if (!TextUtils.isEmpty(path)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "https://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(path, "http://", false, 2, null);
                if (!startsWith$default2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
