package ss;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.image.URLDrawable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f434420a = new c();

    c() {
    }

    public static c a() {
        return f434420a;
    }

    public URLDrawable b(String str, int i3, int i16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        if (i3 > 0 && i16 > 0) {
            obtain.mRequestWidth = i3;
            obtain.mRequestHeight = i16;
        }
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mUseAutoScaleParams = false;
        return URLDrawable.getDrawable(str, obtain);
    }

    public void c(ImageView imageView, String str, int i3, int i16, boolean z16) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            URLDrawable b16 = b(str, i3, i16);
            if (!z16) {
                b16 = null;
            }
            imageView.setImageDrawable(b16);
            return;
        }
        hd0.c.g(ImageLoader.TAG, "ImageView or uri is null.");
    }
}
