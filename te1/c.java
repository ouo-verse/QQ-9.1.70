package te1;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "", "duration", "", "b", "e", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c {
    public static final void b(@NotNull final View view, long j3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() == 8) {
            return;
        }
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(j3).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new Runnable() { // from class: te1.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(view);
            }
        });
    }

    public static /* synthetic */ void c(View view, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 300;
        }
        b(view, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View this_hideWithShrink) {
        Intrinsics.checkNotNullParameter(this_hideWithShrink, "$this_hideWithShrink");
        this_hideWithShrink.setVisibility(8);
        this_hideWithShrink.setScaleX(1.0f);
        this_hideWithShrink.setScaleY(1.0f);
    }

    public static final void e(@NotNull View view, long j3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getVisibility() == 0) {
            return;
        }
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.setVisibility(0);
        view.animate().cancel();
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(j3).setInterpolator(new AccelerateDecelerateInterpolator());
    }

    public static /* synthetic */ void f(View view, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 300;
        }
        e(view, j3);
    }
}
