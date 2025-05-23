package u0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a extends ImageLoader {

    /* renamed from: b, reason: collision with root package name */
    private static a f437989b = new a();

    /* renamed from: c, reason: collision with root package name */
    private static Logger f437990c = LoggerFactory.getLogger("ApngImageLoader");

    /* renamed from: a, reason: collision with root package name */
    private Context f437991a;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f437998a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f437999b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f438000c;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f438001d;

        public c(int i3, boolean z16, boolean z17) {
            this.f437998a = i3;
            this.f437999b = z16;
            this.f438000c = z17;
        }
    }

    protected a() {
    }

    private ApngOptions b(c cVar) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(cVar.f437998a);
        apngOptions.setUseCache(true);
        apngOptions.setLoadingDrawable(cVar.f438001d);
        return apngOptions;
    }

    private ImageLoaderConfiguration f(Context context) {
        return new ImageLoaderConfiguration.Builder(context).memoryCache(new LruMemoryCache(2097152)).memoryCacheSize(2097152).diskCacheSize(52428800).diskCacheFileCount(100).imageDownloader(new BaseImageDownloader(context)).defaultDisplayImageOptions(new DisplayImageOptions.Builder().cacheInMemory(false).cacheOnDisk(true).build()).build();
    }

    private ImageLoaderConfiguration g() {
        return new ImageLoaderConfiguration.Builder(this.f437991a).memoryCache(new LruMemoryCache(8388608)).memoryCacheSize(8388608).diskCacheSize(52428800).diskCacheFileCount(100).build();
    }

    public static a h() {
        return f437989b;
    }

    private boolean j(String str) {
        if (!str.startsWith("https://") && !str.startsWith("http://")) {
            return false;
        }
        return true;
    }

    public void c(String str, ImageView imageView, c cVar) {
        d(str, imageView, cVar, null);
    }

    public void d(String str, ImageView imageView, c cVar, @Nullable ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        URLDrawable apngURLDrawable;
        f437990c.info("displayApng,uri:" + str);
        ApngOptions b16 = b(cVar);
        b16.setLoadListener(new C11317a(str, onPlayRepeatListener));
        if (j(str)) {
            apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(ImageLoader.TAG, str, b16);
        } else {
            apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(str, b16, str);
        }
        imageView.setImageDrawable(apngURLDrawable);
    }

    public void e(String str, ImageView imageView, c cVar, v0.a aVar) {
        IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
        String str2 = ImageLoader.TAG;
        URLDrawable apngURLDrawable = iVasApngFactory.getApngURLDrawable(str2, str, b(cVar));
        if (apngURLDrawable == null) {
            QLog.w(str2, 1, "getApngURLDrawable is null!!");
            return;
        }
        File fileInLocal = apngURLDrawable.getFileInLocal();
        if (fileInLocal != null && fileInLocal.exists()) {
            aVar.a(apngURLDrawable);
        } else {
            apngURLDrawable.setURLDrawableListener(new b(aVar, apngURLDrawable));
        }
        imageView.setImageDrawable(apngURLDrawable);
    }

    public void i(Context context, ImageLoaderConfiguration imageLoaderConfiguration, ImageLoaderConfiguration imageLoaderConfiguration2) {
        this.f437991a = context.getApplicationContext();
        if (imageLoaderConfiguration == null) {
            g();
        }
        if (imageLoaderConfiguration2 == null) {
            imageLoaderConfiguration2 = f(this.f437991a);
        }
        super.init(imageLoaderConfiguration2);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ v0.a f437995d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f437996e;

        b(v0.a aVar, URLDrawable uRLDrawable) {
            this.f437995d = aVar;
            this.f437996e = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            this.f437995d.a(this.f437996e);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: u0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C11317a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f437992d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ApngDrawable.OnPlayRepeatListener f437993e;

        C11317a(String str, ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
            this.f437992d = str;
            this.f437993e = onPlayRepeatListener;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            a.f437990c.info("onLoadCanceled,uri:" + this.f437992d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            a.f437990c.error("onLoadFialed,uri:" + this.f437992d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            a.f437990c.info("onLoadSuccessed,uri:" + this.f437992d);
            Drawable currDrawable = uRLDrawable.getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).setOnPlayRepeatListener(this.f437993e);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
