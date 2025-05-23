package zn3;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    private b f452815b;

    /* renamed from: c, reason: collision with root package name */
    private a f452816c;

    /* renamed from: d, reason: collision with root package name */
    private Logger f452817d = LoggerFactory.getLogger("ScoreGrowthAnimation");

    /* renamed from: a, reason: collision with root package name */
    private ValueAnimator f452814a = ValueAnimator.ofFloat(0.0f, 1.0f);

    public d(@NonNull c cVar) {
        this.f452815b = new b(cVar);
        this.f452816c = new a(cVar);
        this.f452814a.addUpdateListener(this.f452815b);
        this.f452814a.addListener(this.f452816c);
    }

    public void a() {
        this.f452814a.removeAllListeners();
        this.f452814a.removeAllUpdateListeners();
    }

    public void b(float f16, float f17) {
        this.f452815b.b(f16, f17);
    }

    public void c(long j3, long j16) {
        this.f452815b.a(j3, j16);
    }

    public boolean d() {
        if (this.f452814a.isRunning()) {
            this.f452817d.info("animation is running, should cancel.");
            this.f452814a.cancel();
        }
        this.f452814a.setDuration(1000L);
        this.f452814a.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f452814a.setRepeatCount(0);
        this.f452814a.start();
        return true;
    }
}
