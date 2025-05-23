package s42;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Landroid/view/View;", "Landroid/app/Activity;", "a", "(Landroid/view/View;)Landroid/app/Activity;", "hostActivity", "ic-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    @Nullable
    public static final Activity a(@NotNull View view) {
        ViewGroup viewGroup;
        Context context;
        FrameLayout frameLayout;
        View childAt;
        Intrinsics.checkNotNullParameter(view, "<this>");
        View rootView = view.getRootView();
        if (rootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) rootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null && (frameLayout = (FrameLayout) viewGroup.findViewById(R.id.content)) != null && (childAt = frameLayout.getChildAt(0)) != null) {
            context = childAt.getContext();
        } else {
            context = null;
        }
        if (!(context instanceof Activity)) {
            return null;
        }
        return (Activity) context;
    }
}
