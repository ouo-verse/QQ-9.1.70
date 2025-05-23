package ys1;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\r"}, d2 = {"Landroid/view/View;", "view", "", "startAlpha", "endAlpha", "", "duration", "", "b", "a", "c", "e", "d", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "GuildFloatWindowUtils")
/* loaded from: classes14.dex */
public final class c {
    public static final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        b(view, 0.0f, 1.0f, 1000L);
        view.setEnabled(true);
    }

    public static final void b(@NotNull View view, float f16, float f17, long j3) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getVisibility() == 0) {
            return;
        }
        view.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f16, f17);
        alphaAnimation.setDuration(j3);
        view.startAnimation(alphaAnimation);
    }

    public static final void c(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getVisibility() != 0) {
            return;
        }
        view.setEnabled(false);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        view.startAnimation(alphaAnimation);
        view.setVisibility(8);
    }

    public static final void d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setDuration(MiniGamePAHippyBaseFragment.LOAD_HIPPY_TIME_OUT);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(rotateAnimation);
    }

    public static final void e(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        float f16 = QQGuildUIUtil.f(3.0f);
        TranslateAnimation translateAnimation = new TranslateAnimation(-0.0f, 0.0f, f16, -f16);
        translateAnimation.setDuration(2000L);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(2);
        view.startAnimation(translateAnimation);
    }
}
