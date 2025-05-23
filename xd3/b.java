package xd3;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0015\u00a8\u0006\f"}, d2 = {"Lxd3/b;", "Landroid/view/animation/LayoutAnimationController;", "Landroid/view/View;", "view", "", "getDelayForView", "Landroid/content/Context;", "context", "Landroid/view/animation/Animation;", "animation", "<init>", "(Landroid/content/Context;Landroid/view/animation/Animation;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b extends LayoutAnimationController {
    public b(Context context, Animation animation) {
        super(animation);
    }

    @Override // android.view.animation.LayoutAnimationController
    protected long getDelayForView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return 10L;
    }
}
