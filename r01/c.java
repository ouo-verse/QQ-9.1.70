package r01;

import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface c extends Animatable2Compat {
    void c(boolean z16);

    Drawable getDrawable();

    int getDuration();

    int getFrameCount();

    void i(int i3);

    int l();

    void r(@NonNull d dVar);

    void recycle();

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    void setLoopCount(@IntRange(from = 0, to = 65535) int i3);

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback);
}
