package xl3;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f448130a = 5242880;

    static {
        LogUtil.i("ImageTask", "image loader memory cache is 5242880B,cacheUnit=1", new Object[0]);
    }

    private static boolean a(Context context) {
        if ((context.getApplicationInfo().flags & 1048576) != 0) {
            return true;
        }
        return false;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (ImageLoader.getInstance().isInited() && u0.a.h().isInited()) {
                return;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            int memoryClass = activityManager.getMemoryClass();
            if (a(context)) {
                memoryClass = activityManager.getLargeMemoryClass();
            }
            int i3 = (memoryClass * 1048576) / 8;
            int i16 = f448130a;
            if (i3 > i16) {
                i3 = i16;
            }
            UnlimitedDiskCache unlimitedDiskCache = new UnlimitedDiskCache(context.getCacheDir());
            ImageLoaderConfiguration.Builder threadPriority = new ImageLoaderConfiguration.Builder(context).memoryCacheExtraOptions(480, 800).threadPoolSize(3).threadPriority(3);
            QueueProcessingType queueProcessingType = QueueProcessingType.LIFO;
            ImageLoader.getInstance().init(threadPriority.tasksProcessingOrder(queueProcessingType).diskCache(unlimitedDiskCache).imageDownloader(new BaseImageDownloader(context)).defaultDisplayImageOptions(DisplayImageOptions.createSimple()).memoryCache(new LruMemoryCache(i3)).build());
            DisplayImageOptions build = new DisplayImageOptions.Builder().cacheInMemory(false).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();
            ImageLoaderConfiguration build2 = new ImageLoaderConfiguration.Builder(context).memoryCacheExtraOptions(480, 800).threadPoolSize(3).threadPriority(3).tasksProcessingOrder(queueProcessingType).diskCache(unlimitedDiskCache).imageDownloader(new BaseImageDownloader(context)).memoryCache(new LruMemoryCache(i3)).defaultDisplayImageOptions(build).build();
            u0.a.h().i(context, new ImageLoaderConfiguration.Builder(context).memoryCacheExtraOptions(480, 800).threadPoolSize(3).threadPriority(3).tasksProcessingOrder(queueProcessingType).diskCache(unlimitedDiskCache).imageDownloader(new BaseImageDownloader(context)).memoryCache(new LruMemoryCache(i3)).defaultDisplayImageOptions(build).build(), build2);
        }
    }
}
