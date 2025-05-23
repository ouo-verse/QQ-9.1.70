package th4;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lth4/q;", "", "Landroid/view/View;", "view", "Landroid/view/MotionEvent;", "ev", "", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f436374a = new q();

    q() {
    }

    public final boolean a(@NotNull View view, @NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        return new Rect(i3, iArr[1], view.getWidth() + i3, iArr[1] + view.getHeight()).contains((int) ev5.getRawX(), (int) ev5.getRawY());
    }
}
