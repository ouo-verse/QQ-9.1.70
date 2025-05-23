package z4;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends ImageProcessor {
    private BitmapReference a(Drawable drawable) {
        if (drawable instanceof BitmapImageDrawable) {
            return ((BitmapImageDrawable) drawable).getBitmapRef();
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
        BitmapReference a16;
        if (drawable == null || (a16 = a(drawable)) == null) {
            return drawable;
        }
        a16.getBitmap().setDensity(320);
        if (drawable instanceof BitmapImageDrawable) {
            ((BitmapImageDrawable) drawable).setTargetDensity((int) ViewUtils.getDensityDpi());
        } else if (drawable instanceof SpecifiedBitmapDrawable) {
            ((SpecifiedBitmapDrawable) drawable).setTargetDensity((int) ViewUtils.getDensityDpi());
        } else if (drawable instanceof BitmapRefDrawable) {
            ((BitmapRefDrawable) drawable).setTargetDensity((int) ViewUtils.getDensityDpi());
        }
        return drawable;
    }
}
