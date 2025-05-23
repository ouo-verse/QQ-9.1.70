package uo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends ImageProcessor {

    /* renamed from: a, reason: collision with root package name */
    private final int f439296a;

    public a(int i3) {
        this.f439296a = i3;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        Bitmap bitmap;
        ImageProcessor imageProcessor = this.mPreProcessor;
        if (imageProcessor != null) {
            drawable = imageProcessor.process(drawable);
        }
        if (drawable instanceof SpecifiedBitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof ImageDrawable) {
            bitmap = ((ImageDrawable) drawable).getBitmapRef().getBitmap();
        } else {
            if (!(drawable instanceof BitmapRefDrawable)) {
                return null;
            }
            bitmap = ((BitmapRefDrawable) drawable).getBitmapRef().getBitmap();
        }
        try {
            bitmap = new d(bitmap).a(this.f439296a);
        } catch (OutOfMemoryError e16) {
            QZLog.e(QZLog.TO_DEVICE_TAG, "Bitmap Blur Effect: OutofMemory!!!", e16);
        }
        return new ImageDrawable(BitmapReference.getBitmapReference(bitmap));
    }
}
