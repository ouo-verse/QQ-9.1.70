package w64;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import w64.j;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J&\u0010\u000f\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016\u00a8\u0006\u001a"}, d2 = {"Lw64/d;", "Lw64/j;", "T", "", "Landroid/view/View;", "viewOfBehavior", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "g", "Lw64/e;", "dialogContext", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "Lml3/b;", "emitterService", "", "c", "Lw64/o;", "dialog", "d", "f", "b", "a", "", "needAnim", "e", tl.h.F, "robot-core-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface d<T extends j> {
    void a();

    void b();

    void c(@NotNull e<T> dialogContext, @NotNull com.tencent.mvi.runtime.strategy.b strategyService, @NotNull ml3.b emitterService);

    void d(@NotNull o dialog);

    void e(boolean needAnim);

    void f();

    @NotNull
    CoordinatorLayout.Behavior<?> g(@NotNull View viewOfBehavior);

    void h();
}
