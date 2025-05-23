package q3;

import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;
import r3.h;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface f {
    f a(boolean z16);

    f b(@NonNull d dVar);

    f c(r3.f fVar);

    f d(@FloatRange(from = 0.0d, to = 10.0d) float f16);

    @Nullable
    d e();

    f f(@NonNull Interpolator interpolator);

    f finishRefresh();

    f g(@FloatRange(from = 0.0d, to = 1.0d) float f16);

    @NonNull
    ViewGroup getLayout();

    @NonNull
    RefreshState getState();

    boolean h(int i3, int i16, float f16, boolean z16);

    f i(boolean z16);

    f j(@FloatRange(from = 1.0d, to = 10.0d) float f16);

    f k();

    f l(h hVar);

    f m(float f16);

    f setEnableLoadMore(boolean z16);

    f setEnableOverScrollDrag(boolean z16);
}
