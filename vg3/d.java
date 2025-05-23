package vg3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010\u000e\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J*\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u001c\u0010\u0017\u001a\u00020\u00162\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J2\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ&\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lvg3/d;", "", "", "selfUin", "friendUin", "", "uinType", "j", "bgViewWidth", "bgViewHeight", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "cacheFilePath", "d", h.F, "Landroid/graphics/drawable/Drawable;", "lastBgDrawable", "f", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "url", "g", "", "k", "targetWidth", "targetHeight", "e", "bgPicUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "b", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "BACKGROUND_DECODER", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f441627a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final DownloadParams.DecodeHandler BACKGROUND_DECODER = new DownloadParams.DecodeHandler() { // from class: vg3.b
        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            Bitmap c16;
            c16 = d.c(downloadParams, bitmap);
            return c16;
        }
    };

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f441629a;

        static {
            int[] iArr = new int[CoupleAvatarSubScene.values().length];
            try {
                iArr[CoupleAvatarSubScene.AIO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoupleAvatarSubScene.IntimateInfo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f441629a = iArr;
        }
    }

    d() {
    }

    private final String g(CoupleAvatarSubScene subScene, int bgViewWidth, int bgViewHeight, String url) {
        boolean contains$default;
        String substringAfterLast$default;
        String substringBeforeLast$default;
        if (!(url.length() == 0)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) "http", false, 2, (Object) null);
            if (contains$default) {
                File c16 = di3.b.f393984a.c("zplan/couple/background/");
                substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(url, '/', (String) null, 2, (Object) null);
                substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(substringAfterLast$default, '.', (String) null, 2, (Object) null);
                return c16 + "/" + (subScene.name() + "_" + bgViewWidth + "_" + bgViewHeight + "_" + substringBeforeLast$default);
            }
        }
        QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "getCacheFilePath, url invalid.");
        return null;
    }

    private final String j(String selfUin, String friendUin, int uinType) {
        return "ZPLAN_AIO_BG_PIC_" + selfUin + "_" + friendUin + "_" + uinType;
    }

    private final void k(final String cacheFilePath, final Bitmap bitmap) {
        ThreadManagerV2.excute(new Runnable() { // from class: vg3.c
            @Override // java.lang.Runnable
            public final void run() {
                d.l(cacheFilePath, bitmap);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String str, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        Throwable th5;
        if (!(str == null || str.length() == 0) && bitmap != null && !bitmap.isRecycled()) {
            File file = new File(str);
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th6) {
                    fileOutputStream = null;
                    th5 = th6;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    fileOutputStream.close();
                    bitmap.recycle();
                    return;
                } catch (Throwable th7) {
                    th5 = th7;
                    try {
                        QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "saveBitmapToCache failed.", th5);
                        if (file.exists()) {
                            file.delete();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        bitmap.recycle();
                        return;
                    } catch (Throwable th8) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable th9) {
                                QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "outputStream close failed.", th9);
                                throw th8;
                            }
                        }
                        bitmap.recycle();
                        throw th8;
                    }
                }
            } catch (Throwable th10) {
                QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "outputStream close failed.", th10);
                return;
            }
        }
        QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "saveBitmapToCache failed, cacheFilePath or bitmap invalid.");
    }

    public final Drawable e(CoupleAvatarSubScene subScene, int targetWidth, int targetHeight, String url, Drawable lastBgDrawable) {
        Intrinsics.checkNotNullParameter(subScene, "subScene");
        Intrinsics.checkNotNullParameter(url, "url");
        if (!(url.length() == 0) && targetWidth > 0 && targetHeight > 0) {
            String g16 = g(subScene, targetWidth, targetHeight, url);
            QLog.i("ZPlanCoupleAIOBackgroundHelper", 1, "getBackgroundDrawable, subScene: " + subScene + ", targetWidth: " + targetWidth + ", targetHeight: " + targetHeight + ", url:" + url + ", cacheFilePath: " + g16);
            Drawable f16 = f(g16, lastBgDrawable);
            if (f16 != null) {
                QLog.i("ZPlanCoupleAIOBackgroundHelper", 1, "getBackgroundDrawable hit cache, cachePath: " + g16);
                return f16;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = lastBgDrawable == null ? com.tencent.mobileqq.urldrawable.b.f306350a : lastBgDrawable;
            if (lastBgDrawable == null) {
                lastBgDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            }
            obtain.mFailedDrawable = lastBgDrawable;
            obtain.mUseUnFinishCache = false;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            drawable.setTag(new DrawableTag(subScene, targetWidth, targetHeight, g16));
            drawable.setDecodeHandler(BACKGROUND_DECODER);
            return drawable;
        }
        QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "getBackgroundDrawable failed, params invalid.");
        return null;
    }

    public final String i(String selfUin, String friendUin, int uinType) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        String string = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(j(selfUin, friendUin, uinType), "");
        QLog.i("ZPlanCoupleAIOBackgroundHelper", 1, "getZPlanChatBackgroundFromMMKV, picPath: " + string);
        if (string.length() == 0) {
            return null;
        }
        return string;
    }

    public final void m(String selfUin, String friendUin, String bgPicUrl, int uinType) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(bgPicUrl, "bgPicUrl");
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(j(selfUin, friendUin, uinType), bgPicUrl);
    }

    private final Bitmap d(int bgViewWidth, int bgViewHeight, Bitmap bitmap, String cacheFilePath) {
        Bitmap createBitmap;
        float f16 = bgViewWidth;
        int height = (int) (bitmap.getHeight() * (f16 / bitmap.getWidth()));
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bgViewWidth, height, true);
        Bitmap bitmap2 = null;
        if (height >= bgViewHeight) {
            createBitmap = Bitmap.createBitmap(createScaledBitmap, 0, height - bgViewHeight, bgViewWidth, bgViewHeight);
            createBitmap.setDensity(createScaledBitmap.getDensity());
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(scaledBitma\u2026map.density\n            }");
        } else {
            createBitmap = Bitmap.createBitmap(bgViewWidth, bgViewHeight, bitmap.getConfig());
            createBitmap.setDensity(createScaledBitmap.getDensity());
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bgViewWidth\u2026map.density\n            }");
            Canvas canvas = new Canvas(createBitmap);
            int pixel = bitmap.getPixel(0, 0);
            Paint paint = new Paint();
            paint.setColor(pixel);
            float f17 = bgViewHeight - height;
            canvas.drawRect(0.0f, 0.0f, f16, f17, paint);
            canvas.drawBitmap(createScaledBitmap, 0.0f, f17, (Paint) null);
        }
        bitmap.recycle();
        createScaledBitmap.recycle();
        try {
            bitmap2 = createBitmap.copy(createBitmap.getConfig(), false);
        } catch (Throwable th5) {
            QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "getAIOBackgroundBitmap, copy bitmap failed.", th5);
        }
        k(cacheFilePath, bitmap2);
        return createBitmap;
    }

    private final Bitmap h(int bgViewWidth, int bgViewHeight, Bitmap bitmap, String cacheFilePath) {
        Bitmap createBitmap;
        float f16 = bgViewWidth;
        int height = (int) (bitmap.getHeight() * (f16 / bitmap.getWidth()));
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bgViewWidth, height, true);
        Bitmap bitmap2 = null;
        if (height >= bgViewHeight) {
            createBitmap = Bitmap.createBitmap(createScaledBitmap, 0, 0, bgViewWidth, bgViewHeight);
            createBitmap.setDensity(createScaledBitmap.getDensity());
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(scaledBitma\u2026map.density\n            }");
        } else {
            int pixel = bitmap.getPixel(bitmap.getWidth() - 1, bitmap.getHeight() - 1);
            createBitmap = Bitmap.createBitmap(bgViewWidth, bgViewHeight, bitmap.getConfig());
            createBitmap.setDensity(createScaledBitmap.getDensity());
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bgViewWidth\u2026map.density\n            }");
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, (Paint) null);
            Paint paint = new Paint();
            paint.setColor(pixel);
            canvas.drawRect(0.0f, height, f16, bgViewHeight, paint);
        }
        bitmap.recycle();
        createScaledBitmap.recycle();
        try {
            bitmap2 = createBitmap.copy(createBitmap.getConfig(), false);
        } catch (Throwable th5) {
            QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "getIntimateBackgroundBitmap, copy bitmap failed.", th5);
        }
        k(cacheFilePath, bitmap2);
        return createBitmap;
    }

    private final Drawable f(String cacheFilePath, Drawable lastBgDrawable) {
        if (cacheFilePath == null || cacheFilePath.length() == 0) {
            QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "getCacheDrawable failed, cacheFilePath invalid.");
            return null;
        }
        File file = new File(cacheFilePath);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = lastBgDrawable == null ? com.tencent.mobileqq.urldrawable.b.f306350a : lastBgDrawable;
        if (lastBgDrawable == null) {
            lastBgDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        }
        obtain.mFailedDrawable = lastBgDrawable;
        return URLDrawable.getFileDrawable(cacheFilePath, obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap c(DownloadParams downloadParams, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("ZPlanCoupleAIOBackgroundHelper", 4, "BACKGROUND_DECODER");
        }
        Object obj = downloadParams.tag;
        if (!(obj instanceof DrawableTag)) {
            QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "BACKGROUND_DECODER, decode fail, tag invalid.");
            return null;
        }
        DrawableTag drawableTag = (DrawableTag) obj;
        CoupleAvatarSubScene subScene = drawableTag.getSubScene();
        int targetWidth = drawableTag.getTargetWidth();
        int targetHeight = drawableTag.getTargetHeight();
        String cacheFilePath = drawableTag.getCacheFilePath();
        if (targetWidth > 0 && targetHeight > 0) {
            int i3 = a.f441629a[subScene.ordinal()];
            if (i3 == 1) {
                return f441627a.d(targetWidth, targetHeight, bitmap, cacheFilePath);
            }
            if (i3 != 2) {
                return null;
            }
            return f441627a.h(targetWidth, targetHeight, bitmap, cacheFilePath);
        }
        QLog.e("ZPlanCoupleAIOBackgroundHelper", 1, "BACKGROUND_DECODER, decode fail, params in tag invalid.");
        return null;
    }
}
