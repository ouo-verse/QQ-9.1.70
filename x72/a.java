package x72;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "a", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final Drawable a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return LoadingUtil.getLoadingDrawable(context, 2);
    }
}
