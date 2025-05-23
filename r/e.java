package r;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public class e implements d {
    @Override // r.d
    @NonNull
    public Bitmap b(int i3, int i16, Bitmap.Config config) {
        return get(i3, i16, config);
    }

    @Override // r.d
    @NonNull
    public Bitmap get(int i3, int i16, Bitmap.Config config) {
        return Bitmap.createBitmap(i3, i16, config);
    }

    @Override // r.d
    public void put(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // r.d
    public void a() {
    }

    @Override // r.d
    public void trimMemory(int i3) {
    }
}
