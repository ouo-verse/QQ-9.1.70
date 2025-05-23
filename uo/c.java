package uo;

import android.graphics.Bitmap;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import org.jf.dexlib2.analysis.RegisterType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes36.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private static final short[] f439297a = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f439298b = {9, 11, 12, 13, 13, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_LO, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_HI, RegisterType.DOUBLE_HI, RegisterType.UNINIT_REF, RegisterType.UNINIT_REF, RegisterType.UNINIT_REF, RegisterType.UNINIT_REF, 17, 17, 17, 17, 17, 17, 17, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.REFERENCE, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, RegisterType.CONFLICTED, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_CAMERA, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_OPEN_IMAGE_PICKER, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    /* compiled from: P */
    /* loaded from: classes36.dex */
    private static class a implements Callable<Void> {
        private final int C;

        /* renamed from: d, reason: collision with root package name */
        private final int[] f439299d;

        /* renamed from: e, reason: collision with root package name */
        private final int f439300e;

        /* renamed from: f, reason: collision with root package name */
        private final int f439301f;

        /* renamed from: h, reason: collision with root package name */
        private final int f439302h;

        /* renamed from: i, reason: collision with root package name */
        private final int f439303i;

        /* renamed from: m, reason: collision with root package name */
        private final int f439304m;

        public a(int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26) {
            this.f439299d = iArr;
            this.f439300e = i3;
            this.f439301f = i16;
            this.f439302h = i17;
            this.f439303i = i18;
            this.f439304m = i19;
            this.C = i26;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            c.b(this.f439299d, this.f439300e, this.f439301f, this.f439302h, this.f439303i, this.f439304m, this.C);
            return null;
        }
    }

    @Override // uo.b
    public Bitmap blur(Bitmap bitmap, float f16) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i3 = d.f439305d;
        ExecutorService newFixedThreadPool = ProxyExecutors.newFixedThreadPool(i3);
        ArrayList arrayList = new ArrayList(i3);
        ArrayList arrayList2 = new ArrayList(i3);
        int i16 = 0;
        while (i16 < i3) {
            int i17 = (int) f16;
            int i18 = i16;
            arrayList.add(new a(iArr, width, height, i17, i3, i18, 1));
            arrayList2.add(new a(iArr, width, height, i17, i3, i18, 2));
            i16++;
            newFixedThreadPool = newFixedThreadPool;
        }
        ExecutorService executorService = newFixedThreadPool;
        try {
            executorService.invokeAll(arrayList);
            executorService.invokeAll(arrayList2);
            executorService.shutdownNow();
            return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
        } catch (InterruptedException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27 = i3;
        int i28 = i16;
        int i29 = i17;
        int i36 = i27 - 1;
        int i37 = i28 - 1;
        int i38 = (i29 * 2) + 1;
        short s16 = f439297a[i29];
        byte b16 = f439298b[i29];
        int[] iArr2 = new int[i38];
        if (i26 == 1) {
            int i39 = (i19 * i28) / i18;
            int i46 = ((i19 + 1) * i28) / i18;
            while (i39 < i46) {
                int i47 = i27 * i39;
                int i48 = 0;
                long j3 = 0;
                long j16 = 0;
                long j17 = 0;
                long j18 = 0;
                long j19 = 0;
                long j26 = 0;
                while (i48 <= i29) {
                    iArr2[i48] = iArr[i47];
                    int i49 = iArr[i47];
                    i48++;
                    j3 += ((i49 >>> 16) & 255) * i48;
                    j16 += ((i49 >>> 8) & 255) * i48;
                    j17 += (i49 & 255) * i48;
                    j18 += (i49 >>> 16) & 255;
                    j19 += (i49 >>> 8) & 255;
                    j26 += i49 & 255;
                }
                int i56 = i47;
                int i57 = 1;
                long j27 = 0;
                long j28 = 0;
                long j29 = 0;
                while (i57 <= i29) {
                    if (i57 <= i36) {
                        i56++;
                    }
                    iArr2[i57 + i29] = iArr[i56];
                    int i58 = iArr[i56];
                    int i59 = (i29 + 1) - i57;
                    j3 += ((i58 >>> 16) & 255) * i59;
                    j16 += ((i58 >>> 8) & 255) * i59;
                    j17 += (i58 & 255) * i59;
                    j29 += (i58 >>> 16) & 255;
                    j28 += (i58 >>> 8) & 255;
                    j27 += i58 & 255;
                    i57++;
                    i56 = i56;
                }
                int i65 = i29 > i36 ? i36 : i29;
                int i66 = i65 + i47;
                int i67 = i29;
                int i68 = 0;
                while (i68 < i27) {
                    int i69 = i46;
                    long j36 = j27;
                    int i75 = i68;
                    int i76 = i39;
                    int i77 = i36;
                    long j37 = s16;
                    iArr[i47] = (int) ((((j37 * j17) >>> b16) & 255) | (iArr[i47] & (-16777216)) | ((((j3 * j37) >>> b16) & 255) << 16) | ((((j16 * j37) >>> b16) & 255) << 8));
                    int i78 = i47 + 1;
                    long j38 = j3 - j18;
                    long j39 = j16 - j19;
                    long j46 = j17 - j26;
                    int i79 = (i67 + i38) - i29;
                    if (i79 >= i38) {
                        i79 -= i38;
                    }
                    int i85 = iArr2[i79];
                    long j47 = j18 - ((i85 >>> 16) & 255);
                    long j48 = j19 - ((i85 >>> 8) & 255);
                    long j49 = j26 - (i85 & 255);
                    i36 = i77;
                    if (i65 < i36) {
                        i66++;
                        i65++;
                    }
                    iArr2[i79] = iArr[i66];
                    int i86 = iArr[i66];
                    long j56 = j29 + ((i86 >>> 16) & 255);
                    long j57 = j28 + ((i86 >>> 8) & 255);
                    long j58 = j36 + (i86 & 255);
                    j3 = j38 + j56;
                    j16 = j39 + j57;
                    j17 = j46 + j58;
                    i67++;
                    if (i67 >= i38) {
                        i67 = 0;
                    }
                    int i87 = iArr2[i67];
                    int i88 = i38;
                    j18 = j47 + ((i87 >>> 16) & 255);
                    j19 = j48 + ((i87 >>> 8) & 255);
                    j26 = j49 + (i87 & 255);
                    j29 = j56 - ((i87 >>> 16) & 255);
                    j28 = j57 - ((i87 >>> 8) & 255);
                    long j59 = j58 - (i87 & 255);
                    i68 = i75 + 1;
                    i47 = i78;
                    i39 = i76;
                    j27 = j59;
                    i38 = i88;
                    i46 = i69;
                    i65 = i65;
                }
                i39++;
                i46 = i46;
            }
            return;
        }
        int i89 = i38;
        if (i26 == 2) {
            int i95 = (i19 * i27) / i18;
            int i96 = ((i19 + 1) * i27) / i18;
            while (i95 < i96) {
                int i97 = 0;
                long j65 = 0;
                long j66 = 0;
                long j67 = 0;
                long j68 = 0;
                long j69 = 0;
                long j75 = 0;
                while (i97 <= i29) {
                    iArr2[i97] = iArr[i95];
                    int i98 = iArr[i95];
                    i97++;
                    j65 += ((i98 >>> 16) & 255) * i97;
                    j66 += ((i98 >>> 8) & 255) * i97;
                    j67 += (i98 & 255) * i97;
                    j68 += (i98 >>> 16) & 255;
                    j69 += (i98 >>> 8) & 255;
                    j75 += i98 & 255;
                    s16 = s16;
                    b16 = b16;
                }
                short s17 = s16;
                byte b17 = b16;
                int i99 = i95;
                int i100 = 1;
                long j76 = 0;
                long j77 = 0;
                long j78 = 0;
                while (i100 <= i29) {
                    if (i100 <= i37) {
                        i99 += i27;
                    }
                    iArr2[i100 + i29] = iArr[i99];
                    int i101 = iArr[i99];
                    int i102 = (i29 + 1) - i100;
                    j65 += ((i101 >>> 16) & 255) * i102;
                    j66 += ((i101 >>> 8) & 255) * i102;
                    j67 += (i101 & 255) * i102;
                    j78 += (i101 >>> 16) & 255;
                    j77 += (i101 >>> 8) & 255;
                    j76 += i101 & 255;
                    i100++;
                    i96 = i96;
                    i99 = i99;
                }
                int i103 = i96;
                int i104 = i29 > i37 ? i37 : i29;
                int i105 = (i104 * i27) + i95;
                int i106 = i29;
                int i107 = i95;
                int i108 = 0;
                while (i108 < i28) {
                    long j79 = j76;
                    int i109 = i108;
                    int i110 = i104;
                    short s18 = s17;
                    int i111 = i95;
                    long j85 = s18;
                    iArr[i107] = (int) ((((j85 * j67) >>> b17) & 255) | (iArr[i107] & (-16777216)) | ((((j65 * j85) >>> b17) & 255) << 16) | ((((j66 * j85) >>> b17) & 255) << 8));
                    i107 += i27;
                    long j86 = j65 - j68;
                    long j87 = j66 - j69;
                    long j88 = j67 - j75;
                    int i112 = (i106 + i89) - i29;
                    int i113 = i89;
                    if (i112 >= i113) {
                        i112 -= i113;
                    }
                    int i114 = iArr2[i112];
                    long j89 = j68 - ((i114 >>> 16) & 255);
                    long j95 = j69 - ((i114 >>> 8) & 255);
                    long j96 = j75 - (i114 & 255);
                    int i115 = i110;
                    if (i115 < i37) {
                        i105 += i27;
                        i115++;
                    }
                    iArr2[i112] = iArr[i105];
                    int i116 = iArr[i105];
                    long j97 = j78 + ((i116 >>> 16) & 255);
                    long j98 = j77 + ((i116 >>> 8) & 255);
                    long j99 = (i116 & 255) + j79;
                    j65 = j86 + j97;
                    j66 = j87 + j98;
                    j67 = j88 + j99;
                    int i117 = i106 + 1;
                    i106 = i117 >= i113 ? 0 : i117;
                    int i118 = iArr2[i106];
                    int i119 = i115;
                    j68 = j89 + ((i118 >>> 16) & 255);
                    j69 = j95 + ((i118 >>> 8) & 255);
                    j75 = j96 + (i118 & 255);
                    j78 = j97 - ((i118 >>> 16) & 255);
                    j77 = j98 - ((i118 >>> 8) & 255);
                    long j100 = j99 - (i118 & 255);
                    i108 = i109 + 1;
                    i29 = i17;
                    j76 = j100;
                    i95 = i111;
                    s17 = s18;
                    i27 = i3;
                    i28 = i16;
                    i89 = i113;
                    i104 = i119;
                }
                i95++;
                i27 = i3;
                i28 = i16;
                i29 = i17;
                i96 = i103;
                b16 = b17;
                s16 = s17;
                i89 = i89;
            }
        }
    }
}
