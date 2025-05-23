package sn;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends a implements Animatable, ValueAnimator.AnimatorUpdateListener {

    /* renamed from: i, reason: collision with root package name */
    protected ValueAnimator f433991i;

    /* renamed from: e, reason: collision with root package name */
    protected int f433988e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected int f433989f = 0;

    /* renamed from: h, reason: collision with root package name */
    protected int f433990h = 0;

    /* renamed from: m, reason: collision with root package name */
    protected Path f433992m = new Path();

    public d() {
        ValueAnimator ofInt = ValueAnimator.ofInt(30, 3600);
        this.f433991i = ofInt;
        ofInt.setDuration(10000L);
        this.f433991i.setInterpolator(null);
        this.f433991i.setRepeatCount(-1);
        this.f433991i.setRepeatMode(1);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        float f16 = width;
        float max = Math.max(1.0f, f16 / 22.0f);
        if (this.f433988e != width || this.f433989f != height) {
            this.f433992m.reset();
            float f17 = f16 - max;
            float f18 = height / 2.0f;
            this.f433992m.addCircle(f17, f18, max, Path.Direction.CW);
            float f19 = f16 - (5.0f * max);
            this.f433992m.addRect(f19, f18 - max, f17, f18 + max, Path.Direction.CW);
            this.f433992m.addCircle(f19, f18, max, Path.Direction.CW);
            this.f433988e = width;
            this.f433989f = height;
        }
        canvas.save();
        float f26 = f16 / 2.0f;
        float f27 = height / 2.0f;
        canvas.rotate(this.f433990h, f26, f27);
        for (int i3 = 0; i3 < 12; i3++) {
            this.f433982d.setAlpha((i3 + 5) * 17);
            canvas.rotate(30.0f, f26, f27);
            canvas.drawPath(this.f433992m, this.f433982d);
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f433991i.isRunning();
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f433990h = (((Integer) valueAnimator.getAnimatedValue()).intValue() / 30) * 30;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f433991i.isRunning()) {
            return;
        }
        this.f433991i.addUpdateListener(this);
        this.f433991i.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f433991i.isRunning()) {
            this.f433991i.removeAllListeners();
            this.f433991i.removeAllUpdateListeners();
            this.f433991i.cancel();
        }
    }
}
