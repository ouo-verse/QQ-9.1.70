package t74;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a(\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a,\u0010\u000b\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a(\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/image/URLImageView;", "", "url", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "options", "Lcom/tencent/image/URLDrawableDownListener;", "listener", "Lcom/tencent/image/URLDrawable;", "d", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "c", "", "defaultDrawableResId", "b", "resId", "a", "superqqshow-base-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class n {
    public static final Drawable a(int i3) {
        Drawable drawable = BaseApplication.getContext().getResources().getDrawable(i3);
        Intrinsics.checkNotNullExpressionValue(drawable, "getContext().getResources().getDrawable(resId)");
        return drawable;
    }

    public static final URLDrawable b(URLImageView uRLImageView, String url, int i3, URLDrawableDownListener uRLDrawableDownListener) {
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        return c(uRLImageView, url, a(i3), uRLDrawableDownListener);
    }

    public static final URLDrawable c(URLImageView uRLImageView, String url, Drawable drawable, URLDrawableDownListener uRLDrawableDownListener) {
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        URLDrawable.URLDrawableOptions option = URLDrawable.URLDrawableOptions.obtain();
        if (drawable != null) {
            option.mLoadingDrawable = drawable;
            option.mFailedDrawable = drawable;
        }
        Intrinsics.checkNotNullExpressionValue(option, "option");
        return d(uRLImageView, url, option, uRLDrawableDownListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final URLDrawable d(URLImageView uRLImageView, String url, URLDrawable.URLDrawableOptions options, URLDrawableDownListener uRLDrawableDownListener) {
        URLDrawable uRLDrawable;
        Intrinsics.checkNotNullParameter(uRLImageView, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(options, "options");
        if (url.length() > 0) {
            if (uRLDrawableDownListener != null) {
                try {
                    uRLImageView.setURLDrawableDownListener(uRLDrawableDownListener);
                } catch (Exception e16) {
                    e = e16;
                    uRLDrawable = null;
                    QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                    if (uRLDrawableDownListener != null) {
                    }
                    uRLImageView.setImageDrawable(options.mFailedDrawable);
                    return uRLDrawable;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    uRLDrawable = null;
                    QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                    if (uRLDrawableDownListener != null) {
                    }
                    uRLImageView.setImageDrawable(options.mFailedDrawable);
                    return uRLDrawable;
                }
            }
            URLDrawable drawable = URLDrawable.getDrawable(url, options);
            try {
                uRLImageView.setImageDrawable(drawable);
                if (drawable.getStatus() == 1) {
                    if (uRLDrawableDownListener != null) {
                        uRLDrawableDownListener.onLoadSuccessed(uRLImageView, drawable);
                    }
                } else if (drawable.getStatus() == 2) {
                    drawable.restartDownload();
                }
                return drawable;
            } catch (Exception e18) {
                uRLDrawable = drawable;
                e = e18;
                QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                if (uRLDrawableDownListener != null) {
                    uRLDrawableDownListener.onLoadFailed(uRLImageView, null, e);
                }
                uRLImageView.setImageDrawable(options.mFailedDrawable);
                return uRLDrawable;
            } catch (OutOfMemoryError e19) {
                uRLDrawable = drawable;
                e = e19;
                QLog.e("URLImageView", 1, "setUrlSafety failed, url:" + url, e);
                if (uRLDrawableDownListener != null) {
                    uRLDrawableDownListener.onLoadFailed(uRLImageView, null, e);
                }
                uRLImageView.setImageDrawable(options.mFailedDrawable);
                return uRLDrawable;
            }
        }
        if (uRLDrawableDownListener != null) {
            uRLDrawableDownListener.onLoadFailed(uRLImageView, null, null);
        }
        uRLImageView.setImageDrawable(options.mFailedDrawable);
        return null;
    }

    public static /* synthetic */ URLDrawable e(URLImageView uRLImageView, String str, int i3, URLDrawableDownListener uRLDrawableDownListener, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            uRLDrawableDownListener = null;
        }
        return b(uRLImageView, str, i3, uRLDrawableDownListener);
    }

    public static /* synthetic */ URLDrawable f(URLImageView uRLImageView, String str, Drawable drawable, URLDrawableDownListener uRLDrawableDownListener, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            drawable = null;
        }
        if ((i3 & 4) != 0) {
            uRLDrawableDownListener = null;
        }
        return c(uRLImageView, str, drawable, uRLDrawableDownListener);
    }
}
