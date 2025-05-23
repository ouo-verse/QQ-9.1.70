package x0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class b {
    public static void a(@NonNull AnimatorSet animatorSet, @NonNull List<Animator> list) {
        int size = list.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            Animator animator = list.get(i3);
            j3 = Math.max(j3, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j3);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
