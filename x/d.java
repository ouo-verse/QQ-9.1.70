package x;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.q;

/* compiled from: P */
/* loaded from: classes.dex */
final class d extends b<Drawable> {
    d(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static q<Drawable> b(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.q
    @NonNull
    public Class<Drawable> getResourceClass() {
        return this.f446808d.getClass();
    }

    @Override // com.bumptech.glide.load.engine.q
    public int getSize() {
        return Math.max(1, this.f446808d.getIntrinsicWidth() * this.f446808d.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.q
    public void recycle() {
    }
}
