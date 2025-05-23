package x0;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e extends Property<Drawable, Integer> {

    /* renamed from: b, reason: collision with root package name */
    public static final Property<Drawable, Integer> f446817b = new e();

    /* renamed from: a, reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f446818a;

    e() {
        super(Integer.class, "drawableAlphaCompat");
        this.f446818a = new WeakHashMap<>();
    }

    @Override // android.util.Property
    @Nullable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer get(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
