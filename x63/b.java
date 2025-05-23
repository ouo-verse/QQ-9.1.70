package x63;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {
    public static void a(Bitmap bitmap, int i3) {
        int[] iArr = new int[i3 * i3];
        int height = bitmap.getHeight() / i3;
        int width = bitmap.getWidth() / i3;
        int height2 = bitmap.getHeight() % i3;
        int width2 = bitmap.getWidth() % i3;
        int i16 = 0;
        while (i16 < height) {
            int i17 = 0;
            while (i17 < width) {
                int i18 = i16 * i3;
                int i19 = i17 * i3;
                int i26 = i17;
                int i27 = i16;
                bitmap.getPixels(iArr, 0, i3, i19, i18, i3, i3);
                int i28 = 0;
                int i29 = 0;
                int i36 = 0;
                for (int i37 = 0; i37 < i3; i37++) {
                    for (int i38 = 0; i38 < i3; i38++) {
                        int i39 = iArr[(i37 * i3) + i38];
                        i28 += (i39 >> 16) & 255;
                        i29 += (i39 >> 8) & 255;
                        i36 += i39 & 255;
                    }
                }
                int i46 = (i28 / i3) / i3;
                int i47 = (i29 / i3) / i3;
                int i48 = (i36 / i3) / i3;
                for (int i49 = 0; i49 < i3; i49++) {
                    for (int i56 = 0; i56 < i3; i56++) {
                        iArr[(i49 * i3) + i56] = (i46 << 16) | (-16777216) | (i47 << 8) | i48;
                    }
                }
                bitmap.setPixels(iArr, 0, i3, i19, i18, i3, i3);
                i17 = i26 + 1;
                i16 = i27;
            }
            i16++;
        }
        if (width2 > 0) {
            for (int i57 = 0; i57 < height; i57++) {
                int i58 = i57 * i3;
                int i59 = width * i3;
                int i65 = 0;
                int i66 = 0;
                int i67 = 0;
                for (int i68 = 0; i68 < i3; i68++) {
                    for (int i69 = 0; i69 < width2; i69++) {
                        int pixel = bitmap.getPixel(i59 + i69, i58 + i68);
                        i65 += (pixel >> 16) & 255;
                        i66 += (pixel >> 8) & 255;
                        i67 += pixel & 255;
                    }
                }
                int i75 = (i65 / i3) / width2;
                int i76 = (i66 / i3) / width2;
                int i77 = (i67 / i3) / width2;
                for (int i78 = 0; i78 < i3; i78++) {
                    int i79 = 0;
                    while (i79 < width2) {
                        bitmap.setPixel(i59 + i79, i58 + i78, (i75 << 16) | (-16777216) | (i76 << 8) | i77);
                        i79++;
                        i58 = i58;
                    }
                }
            }
        }
        if (height2 > 0) {
            for (int i85 = 0; i85 < width; i85++) {
                int i86 = height * i3;
                int i87 = i85 * i3;
                int i88 = 0;
                int i89 = 0;
                int i95 = 0;
                for (int i96 = 0; i96 < height2; i96++) {
                    for (int i97 = 0; i97 < i3; i97++) {
                        int pixel2 = bitmap.getPixel(i87 + i97, i86 + i96);
                        i88 += (pixel2 >> 16) & 255;
                        i89 += (pixel2 >> 8) & 255;
                        i95 += pixel2 & 255;
                    }
                }
                int i98 = (i88 / i3) / height2;
                int i99 = (i89 / i3) / height2;
                int i100 = (i95 / i3) / height2;
                for (int i101 = 0; i101 < height2; i101++) {
                    for (int i102 = 0; i102 < i3; i102++) {
                        bitmap.setPixel(i87 + i102, i86 + i101, (i98 << 16) | (-16777216) | (i99 << 8) | i100);
                    }
                }
            }
        }
    }
}
