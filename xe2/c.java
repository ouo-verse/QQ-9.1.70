package xe2;

import android.content.Context;
import android.os.Bundle;
import com.tencent.ecommerce.base.pageopener.api.IECMediaSelector;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECCameraConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECCaptureAbility;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaMimeType;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaSelectorConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECTabType;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qqecommerce.base.pageopener.ECWinkOutputRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaMimeType;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QCircleInitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\n\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\f\u0010\f\u001a\u00020\u000b*\u00020\bH\u0002J\f\u0010\u000f\u001a\u00020\u000e*\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J(\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0014\u0010\u001c\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0014\u0010\u001d\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006\""}, d2 = {"Lxe2/c;", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector;", "Landroid/os/Bundle;", "", "d", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/a;", "cameraConfig", "c", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/d;", "mediaSelectorConfig", "e", "Lcom/tencent/mobileqq/wink/picker/Config;", "j", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/ECMediaMimeType;", "Lcom/tencent/mobileqq/wink/picker/MediaMimeType;", "k", "Landroid/content/Context;", "context", "preLoad", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "selectorResultCallback", "openCamera", DownloadInfo.spKey_Config, "openMediaSelector", "openCameraAndMediaSelector", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfoList", "f", h.F, "b", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c implements IECMediaSelector {

    /* renamed from: a, reason: collision with root package name */
    public static final c f447853a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes36.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f447855a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f447856b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f447857c;

        static {
            int[] iArr = new int[ECCaptureAbility.values().length];
            try {
                iArr[ECCaptureAbility.ALL_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ECCaptureAbility.ONLY_PHOTO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ECCaptureAbility.ONLY_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f447855a = iArr;
            int[] iArr2 = new int[ECTabType.values().length];
            try {
                iArr2[ECTabType.ALL_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ECTabType.ONLY_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ECTabType.ONLY_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f447856b = iArr2;
            int[] iArr3 = new int[ECMediaMimeType.values().length];
            try {
                iArr3[ECMediaMimeType.IMAGE_JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr3[ECMediaMimeType.IMAGE_GIF.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ECMediaMimeType.IMAGE_PNG.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ECMediaMimeType.IMAGE_HEIF.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[ECMediaMimeType.IMAGE_WEBP.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[ECMediaMimeType.VIDEO_MP4.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            f447857c = iArr3;
        }
    }

    c() {
    }

    private final void c(Bundle bundle, ECCameraConfig eCCameraConfig) {
        String str;
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putInt(PeakConstants.ARG_FORCE_CAMERA, 2);
        int i3 = a.f447855a[eCCameraConfig.getCaptureAbility().ordinal()];
        if (i3 == 1) {
            str = "all";
        } else if (i3 == 2) {
            bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_MUSIC, false);
            bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
            bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
            str = "photo";
        } else if (i3 == 3) {
            bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
            bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 0);
            str = "video";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        bundle.putString(QQWinkConstants.CAPTURE_ABILITY, str);
    }

    private final void d(Bundle bundle) {
        bundle.putString("app_key", "");
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "ECOMMERCE");
        bundle.putString("wink_output_route", ECWinkOutputRouter.ROUTE_PATH);
    }

    private final void e(Bundle bundle, ECMediaSelectorConfig eCMediaSelectorConfig) {
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, true);
        bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", j(eCMediaSelectorConfig));
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", new QCircleInitBean(false, false, null, 5, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(List mediaInfoList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(mediaInfoList, "$mediaInfoList");
        IECMediaSelector.ECMediaSelectorResultCallback eCMediaSelectorResultCallback = selectorResultCallback;
        if (eCMediaSelectorResultCallback != null) {
            List<LocalMediaInfo> list = mediaInfoList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo localMediaInfo : list) {
                String str = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str, "it.path");
                arrayList.add(new ECMediaInfo(str, localMediaInfo.fileSize));
            }
            eCMediaSelectorResultCallback.onCameraCaptureResultCallback(arrayList);
        }
        selectorResultCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(List mediaInfoList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(mediaInfoList, "$mediaInfoList");
        IECMediaSelector.ECMediaSelectorResultCallback eCMediaSelectorResultCallback = selectorResultCallback;
        if (eCMediaSelectorResultCallback != null) {
            List<LocalMediaInfo> list = mediaInfoList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (LocalMediaInfo localMediaInfo : list) {
                String str = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str, "it.path");
                arrayList.add(new ECMediaInfo(str, localMediaInfo.fileSize));
            }
            eCMediaSelectorResultCallback.onAlbumSelectedResultCallback(arrayList);
        }
        selectorResultCallback = null;
    }

    private final Config j(ECMediaSelectorConfig eCMediaSelectorConfig) {
        int collectionSizeOrDefault;
        TabType tabType;
        int collectionSizeOrDefault2;
        MediaFilter.a aVar = new MediaFilter.a();
        List<ECMediaMimeType> a16 = eCMediaSelectorConfig.getQueryMediaFilter().a();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = a16.iterator();
        while (it.hasNext()) {
            arrayList.add(f447853a.k((ECMediaMimeType) it.next()));
        }
        aVar.f(arrayList);
        Config.a aVar2 = new Config.a();
        int i3 = a.f447856b[eCMediaSelectorConfig.getMediaTabType().ordinal()];
        if (i3 == 1) {
            tabType = TabType.ALL_MEDIA;
        } else if (i3 == 2) {
            tabType = TabType.ONLY_IMAGE;
        } else if (i3 == 3) {
            tabType = TabType.ONLY_VIDEO;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        aVar2.i(tabType);
        aVar2.j(eCMediaSelectorConfig.getMaxSelectedMediaNum());
        aVar2.n(aVar.a());
        List<ECMediaInfo> a17 = eCMediaSelectorConfig.a();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(a17, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = a17.iterator();
        while (it5.hasNext()) {
            arrayList2.add(new MediaInfo(MediaType.LOCAL_ALL, null, 0, 0, ((ECMediaInfo) it5.next()).getMediaPath(), null, null, 0, 0, null, null, 0L, 4078, null));
        }
        aVar2.c(arrayList2);
        return aVar2.a();
    }

    private final MediaMimeType k(ECMediaMimeType eCMediaMimeType) {
        switch (a.f447857c[eCMediaMimeType.ordinal()]) {
            case 1:
                return MediaMimeType.IMAGE_JPEG;
            case 2:
                return MediaMimeType.IMAGE_GIF;
            case 3:
                return MediaMimeType.IMAGE_PNG;
            case 4:
                return MediaMimeType.IMAGE_HEIF;
            case 5:
                return MediaMimeType.IMAGE_WEBP;
            case 6:
                return MediaMimeType.VIDEO_MP4;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void f(final List<? extends LocalMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        com.tencent.qav.thread.a.b(new Runnable() { // from class: xe2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.g(mediaInfoList);
            }
        });
    }

    public final void h(final List<? extends LocalMediaInfo> mediaInfoList) {
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        com.tencent.qav.thread.a.b(new Runnable() { // from class: xe2.a
            @Override // java.lang.Runnable
            public final void run() {
                c.i(mediaInfoList);
            }
        });
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openCamera(Context context, ECCameraConfig cameraConfig, IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        Intrinsics.checkNotNullParameter(selectorResultCallback2, "selectorResultCallback");
        selectorResultCallback = selectorResultCallback2;
        Bundle bundle = new Bundle();
        c cVar = f447853a;
        cVar.d(bundle);
        cVar.c(bundle, cameraConfig);
        bundle.putLong("wink_output_point", 2L);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(context, bundle);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openCameraAndMediaSelector(Context context, ECCameraConfig cameraConfig, ECMediaSelectorConfig mediaSelectorConfig, IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cameraConfig, "cameraConfig");
        Intrinsics.checkNotNullParameter(mediaSelectorConfig, "mediaSelectorConfig");
        Intrinsics.checkNotNullParameter(selectorResultCallback2, "selectorResultCallback");
        selectorResultCallback = selectorResultCallback2;
        Bundle bundle = new Bundle();
        c cVar = f447853a;
        cVar.d(bundle);
        cVar.c(bundle, cameraConfig);
        cVar.e(bundle, mediaSelectorConfig);
        bundle.putLong("wink_output_point", 3L);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(context, bundle);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void openMediaSelector(Context context, ECMediaSelectorConfig config, IECMediaSelector.ECMediaSelectorResultCallback selectorResultCallback2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(selectorResultCallback2, "selectorResultCallback");
        selectorResultCallback = selectorResultCallback2;
        Bundle bundle = new Bundle();
        c cVar = f447853a;
        cVar.d(bundle);
        cVar.e(bundle, config);
        bundle.putLong("wink_output_point", 1L);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(context, bundle);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector
    public void preLoad(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).preloadQQWink(context);
    }
}
