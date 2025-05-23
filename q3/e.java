package q3;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import com.qqnt.widget.smartrefreshlayout.layout.constant.RefreshState;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface e {
    e a(@NonNull a aVar, int i3);

    ValueAnimator animSpinner(int i3);

    e b(@NonNull RefreshState refreshState);

    e c(int i3);

    e d(boolean z16);

    e e(@NonNull a aVar, boolean z16);

    e f(boolean z16, Animator.AnimatorListener animatorListener);

    e finishTwoLevel();

    e g(float f16);

    @NonNull
    f getRefreshLayout();

    e moveSpinner(int i3, boolean z16);
}
