package zn4;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J0\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lzn4/c;", "Landroid/widget/Scroller;", "", "startX", "startY", "dx", "dy", "", "startScroll", "duration", "a", "I", "getMDuration", "()I", "setMDuration", "(I)V", "mDuration", "Landroid/content/Context;", "context", "Landroid/view/animation/Interpolator;", "interpolator", "<init>", "(Landroid/content/Context;Landroid/view/animation/Interpolator;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c extends Scroller {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int mDuration;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull Context context, @NotNull Interpolator interpolator) {
        super(context, interpolator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.mDuration = 400;
    }

    @Override // android.widget.Scroller
    public void startScroll(int startX, int startY, int dx5, int dy5) {
        super.startScroll(startX, startY, dx5, dy5, this.mDuration);
    }

    @Override // android.widget.Scroller
    public void startScroll(int startX, int startY, int dx5, int dy5, int duration) {
        super.startScroll(startX, startY, dx5, dy5, this.mDuration);
    }
}
