package r;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public interface d {
    void a();

    @NonNull
    Bitmap b(int i3, int i16, Bitmap.Config config);

    @NonNull
    Bitmap get(int i3, int i16, Bitmap.Config config);

    void put(Bitmap bitmap);

    void trimMemory(int i3);
}
