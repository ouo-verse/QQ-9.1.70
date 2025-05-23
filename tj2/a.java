package tj2;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FlingAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Ltj2/a;", "", "", "velocityX", "startValue", "maxValue", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "listener", "", "b", "c", "Landroidx/dynamicanimation/animation/FlingAnimation;", "a", "Landroidx/dynamicanimation/animation/FlingAnimation;", "animation", UserInfo.SEX_FEMALE, "getFlingFactor", "()F", "(F)V", "flingFactor", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FlingAnimation animation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float flingFactor = 1.0f;

    public final void a(float f16) {
        this.flingFactor = f16;
    }

    public final void b(float velocityX, float startValue, float maxValue, @NotNull DynamicAnimation.OnAnimationUpdateListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        c();
        FlingAnimation flingAnimation = new FlingAnimation(new FloatValueHolder());
        flingAnimation.setStartVelocity(velocityX / this.flingFactor);
        flingAnimation.setStartValue(startValue);
        flingAnimation.setMinValue(0.0f);
        flingAnimation.setMaxValue(maxValue);
        flingAnimation.addUpdateListener(listener);
        flingAnimation.start();
        this.animation = flingAnimation;
    }

    public final void c() {
        FlingAnimation flingAnimation = this.animation;
        if (flingAnimation != null) {
            flingAnimation.cancel();
        }
    }
}
