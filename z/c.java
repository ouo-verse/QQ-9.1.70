package z;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import z.g;

/* compiled from: P */
/* loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable, Animatable2Compat {
    private int C;
    private boolean D;
    private Paint E;
    private Rect F;
    private List<Animatable2Compat.AnimationCallback> G;

    /* renamed from: d, reason: collision with root package name */
    private final a f451663d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f451664e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f451665f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f451666h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f451667i;

    /* renamed from: m, reason: collision with root package name */
    private int f451668m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        final g f451669a;

        a(g gVar) {
            this.f451669a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, GifDecoder gifDecoder, com.bumptech.glide.load.h<Bitmap> hVar, int i3, int i16, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.b.c(context), gifDecoder, i3, i16, hVar, bitmap)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect e() {
        if (this.F == null) {
            this.F = new Rect();
        }
        return this.F;
    }

    private Paint h() {
        if (this.E == null) {
            this.E = new Paint(2);
        }
        return this.E;
    }

    private void k() {
        List<Animatable2Compat.AnimationCallback> list = this.G;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.G.get(i3).onAnimationEnd(this);
            }
        }
    }

    private void m() {
        this.f451668m = 0;
    }

    private void o() {
        h0.j.a(!this.f451666h, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f451663d.f451669a.f() == 1) {
            invalidateSelf();
        } else if (!this.f451664e) {
            this.f451664e = true;
            this.f451663d.f451669a.r(this);
            invalidateSelf();
        }
    }

    private void p() {
        this.f451664e = false;
        this.f451663d.f451669a.s(this);
    }

    @Override // z.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == getFrameCount() - 1) {
            this.f451668m++;
        }
        int i3 = this.C;
        if (i3 != -1 && this.f451668m >= i3) {
            k();
            stop();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void clearAnimationCallbacks() {
        List<Animatable2Compat.AnimationCallback> list = this.G;
        if (list != null) {
            list.clear();
        }
    }

    public ByteBuffer d() {
        return this.f451663d.f451669a.b();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f451666h) {
            return;
        }
        if (this.D) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), e());
            this.D = false;
        }
        canvas.drawBitmap(this.f451663d.f451669a.c(), (Rect) null, e(), h());
    }

    public Bitmap f() {
        return this.f451663d.f451669a.e();
    }

    public int g() {
        return this.f451663d.f451669a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f451663d;
    }

    public int getFrameCount() {
        return this.f451663d.f451669a.f();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f451663d.f451669a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f451663d.f451669a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f451664e;
    }

    public int j() {
        return this.f451663d.f451669a.j();
    }

    public void n(com.bumptech.glide.load.h<Bitmap> hVar, Bitmap bitmap) {
        this.f451663d.f451669a.o(hVar, bitmap);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.D = true;
    }

    public void recycle() {
        this.f451666h = true;
        this.f451663d.f451669a.a();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        if (animationCallback == null) {
            return;
        }
        if (this.G == null) {
            this.G = new ArrayList();
        }
        this.G.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        h().setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        h0.j.a(!this.f451666h, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f451667i = z16;
        if (!z16) {
            p();
        } else if (this.f451665f) {
            o();
        }
        return super.setVisible(z16, z17);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f451665f = true;
        m();
        if (this.f451667i) {
            o();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f451665f = false;
        p();
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        List<Animatable2Compat.AnimationCallback> list = this.G;
        if (list != null && animationCallback != null) {
            return list.remove(animationCallback);
        }
        return false;
    }

    c(a aVar) {
        this.f451667i = true;
        this.C = -1;
        this.f451663d = (a) h0.j.d(aVar);
    }
}
