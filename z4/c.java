package z4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.qzone.album.util.k;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.processor.ScaleProcessor;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends ImageProcessor {

    /* renamed from: c, reason: collision with root package name */
    private static Paint f451870c = new Paint();

    /* renamed from: a, reason: collision with root package name */
    private ScaleProcessor f451871a;

    /* renamed from: b, reason: collision with root package name */
    private float f451872b;

    public c(float f16) {
        this.f451871a = null;
        this.f451872b = f16;
        f451870c.setAntiAlias(true);
    }

    private BitmapReference a(Drawable drawable) {
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof SpecifiedBitmapDrawable) {
            return ((SpecifiedBitmapDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof BitmapRefDrawable) {
            return ((BitmapRefDrawable) drawable).getBitmapRef();
        }
        return null;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        if (drawable == null) {
            return drawable;
        }
        BitmapReference a16 = a(drawable);
        if (a16 == null) {
            return null;
        }
        int width = a16.getWidth();
        int height = a16.getHeight();
        try {
            BitmapReference bitmap = ImageManager.getInstance().getBitmap(a16.getWidth(), a16.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(bitmap.getBitmap()).drawBitmap(a16.getBitmap(), new Rect(1, 1, a16.getWidth() - 1, a16.getHeight() - 1), new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), f451870c);
            byte[] d16 = k.d(a16.getBitmap());
            if (!a16.isRecycled()) {
                a16.release();
            }
            Drawable bitmapRefDrawable = new BitmapRefDrawable(bitmap);
            ScaleProcessor scaleProcessor = this.f451871a;
            if (scaleProcessor != null) {
                bitmapRefDrawable = scaleProcessor.process(bitmapRefDrawable);
            }
            if (this.f451872b != 1.0f) {
                bitmapRefDrawable = new d((int) (width * this.f451872b), 0, true).process(bitmapRefDrawable);
            }
            boolean isNinePatchChunk = d16 != null ? NinePatch.isNinePatchChunk(d16) : false;
            BitmapReference a17 = a(bitmapRefDrawable);
            if (!isNinePatchChunk || a17 == null || a17.getBitmap() == null) {
                return bitmapRefDrawable;
            }
            byte[] f16 = k.f(d16, a17.getWidth() / width, a17.getHeight() / height);
            try {
                Bitmap bitmap2 = a17.getBitmap();
                Field declaredField = bitmap2.getClass().getDeclaredField("mNinePatchChunk");
                declaredField.setAccessible(true);
                declaredField.set(bitmap2, f16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            return k.c(a17);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return drawable;
        }
    }

    public c(int i3, int i16, boolean z16) {
        this.f451871a = null;
        this.f451872b = 1.0f;
        this.f451871a = new ScaleProcessor(i3, i16, z16);
        f451870c.setAntiAlias(true);
    }
}
