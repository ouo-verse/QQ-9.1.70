package x;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.load.engine.q;
import h0.j;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements q<T>, m {

    /* renamed from: d, reason: collision with root package name */
    protected final T f446808d;

    public b(T t16) {
        this.f446808d = (T) j.d(t16);
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f446808d.getConstantState();
        if (constantState == null) {
            return this.f446808d;
        }
        return (T) constantState.newDrawable();
    }

    @Override // com.bumptech.glide.load.engine.m
    public void initialize() {
        T t16 = this.f446808d;
        if (t16 instanceof BitmapDrawable) {
            ((BitmapDrawable) t16).getBitmap().prepareToDraw();
        } else if (t16 instanceof z.c) {
            ((z.c) t16).f().prepareToDraw();
        }
    }
}
