package xc4;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lxc4/d;", "", "", "dp", "Landroid/content/Context;", "context", "a", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f447786a = new d();

    d() {
    }

    public final int a(int dp5, Context context) {
        int roundToInt;
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
        roundToInt = MathKt__MathJVMKt.roundToInt(dp5 * displayMetrics.density);
        return roundToInt;
    }
}
