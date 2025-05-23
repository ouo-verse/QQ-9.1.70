package u93;

import com.tencent.image.URLDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/image/URLDrawable;", "", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class k {
    public static final boolean a(@NotNull URLDrawable uRLDrawable) {
        Intrinsics.checkNotNullParameter(uRLDrawable, "<this>");
        if (uRLDrawable.getStatus() == 1) {
            return true;
        }
        return false;
    }
}
