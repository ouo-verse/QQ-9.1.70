package x0;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private long f446825a;

    /* renamed from: b, reason: collision with root package name */
    private long f446826b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private TimeInterpolator f446827c;

    /* renamed from: d, reason: collision with root package name */
    private int f446828d;

    /* renamed from: e, reason: collision with root package name */
    private int f446829e;

    public i(long j3, long j16) {
        this.f446827c = null;
        this.f446828d = 0;
        this.f446829e = 1;
        this.f446825a = j3;
        this.f446826b = j16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static i b(@NonNull ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f446828d = valueAnimator.getRepeatCount();
        iVar.f446829e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return a.f446812c;
            }
            if (interpolator instanceof DecelerateInterpolator) {
                return a.f446813d;
            }
            return interpolator;
        }
        return a.f446811b;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f446825a;
    }

    public long d() {
        return this.f446826b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f446827c;
        if (timeInterpolator == null) {
            return a.f446811b;
        }
        return timeInterpolator;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() != iVar.c() || d() != iVar.d() || g() != iVar.g() || h() != iVar.h()) {
            return false;
        }
        return e().getClass().equals(iVar.e().getClass());
    }

    public int g() {
        return this.f446828d;
    }

    public int h() {
        return this.f446829e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j3, long j16, @NonNull TimeInterpolator timeInterpolator) {
        this.f446828d = 0;
        this.f446829e = 1;
        this.f446825a = j3;
        this.f446826b = j16;
        this.f446827c = timeInterpolator;
    }
}
