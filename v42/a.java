package v42;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "a", "ic-game-widget-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"v42/a$a", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: v42.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final class C11392a extends LinearSmoothScroller {
        C11392a(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(@NotNull DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 300.0f / displayMetrics.densityDpi;
        }
    }

    @NotNull
    public static final LinearSmoothScroller a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new C11392a(context);
    }
}
