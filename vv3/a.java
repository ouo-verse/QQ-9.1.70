package vv3;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0000\u00a8\u0006\u0005"}, d2 = {"", "tag", "msg", "", "a", "avatar_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    public static final void a(@NotNull String tag, @NotNull String msg2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (QLog.isColorLevel()) {
            QLog.i("NTAvatar:" + tag, 2, msg2);
        }
    }
}
