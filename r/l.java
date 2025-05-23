package r;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes.dex */
interface l {
    String a(int i3, int i16, Bitmap.Config config);

    String b(Bitmap bitmap);

    int c(Bitmap bitmap);

    @Nullable
    Bitmap get(int i3, int i16, Bitmap.Config config);

    void put(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
