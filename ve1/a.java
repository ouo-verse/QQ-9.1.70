package ve1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class a {
    public static Animator a(View view, float f16, float f17) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, f16, f17);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, f16, f17);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }
}
