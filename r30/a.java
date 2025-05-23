package r30;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lr30/a;", "", "Landroid/view/View;", "parentView", "Landroid/view/MotionEvent;", "ev", "", "r7", "p2", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: r30.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C11111a {
        public static boolean a(@NotNull a aVar, @Nullable View view, @Nullable MotionEvent motionEvent) {
            return false;
        }
    }

    boolean p2(@Nullable View parentView, @Nullable MotionEvent ev5);

    boolean r7(@Nullable View parentView, @Nullable MotionEvent ev5);
}
