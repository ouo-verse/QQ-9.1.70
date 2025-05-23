package vn3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.od.res.VoiceGameRes;
import java.lang.ref.WeakReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Logger f442088a = LoggerFactory.getLogger("ImageUtils");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: vn3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C11431a extends SimpleImageLoadingListener {
        C11431a() {
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
            a.f442088a.warn("displayResImage onLoadingCancelled {}", str);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            super.onLoadingComplete(str, view, bitmap);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            Logger logger = a.f442088a;
            if (failReason != null) {
                str2 = failReason.getType().name();
            } else {
                str2 = "UNKNOWN";
            }
            logger.error("displayResImage onLoadingFailed {}", str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends SimpleImageLoadingListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f442089a;

        b(View view) {
            this.f442089a = view;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingCancelled(String str, View view) {
            a.f442088a.warn("setBackground onLoadingCancelled {}", str);
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            if (bitmap == null) {
                return;
            }
            this.f442089a.setBackground(new BitmapDrawable(this.f442089a.getContext().getResources(), bitmap));
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingFailed(String str, View view, FailReason failReason) {
            String str2;
            Logger logger = a.f442088a;
            if (failReason != null) {
                str2 = failReason.getType().name();
            } else {
                str2 = "UNKNOWN";
            }
            logger.error("setBackground onLoadingFailed {}", str2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class c extends NonViewAware {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<View> f442090a;

        public c(View view, String str) {
            this(view, str, a(view.getContext()), ViewScaleType.CROP);
        }

        private static ImageSize a(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new ImageSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
        }

        @Override // com.nostra13.universalimageloader.core.imageaware.NonViewAware, com.nostra13.universalimageloader.core.imageaware.ImageAware
        public int getId() {
            View view = this.f442090a.get();
            if (view == null) {
                return super.getId();
            }
            return sn3.a.a(view, VasProfileTemplatePreloadHelper.BACKGROUND);
        }

        public c(View view, String str, ImageSize imageSize, ViewScaleType viewScaleType) {
            super(str, imageSize, viewScaleType);
            this.f442090a = new WeakReference<>(view);
        }
    }

    public static void b(ImageView imageView, VoiceGameRes voiceGameRes) {
        c(imageView, voiceGameRes.b());
    }

    public static void c(ImageView imageView, String str) {
        ImageLoader.getInstance().displayImage(str, imageView, un3.a.f439281b, new C11431a());
    }

    public static void d(View view, String str) {
        ImageLoader.getInstance().displayImage(str, new c(view, str), un3.a.f439281b, new b(view));
    }
}
