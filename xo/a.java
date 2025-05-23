package xo;

import com.qzone.util.x;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneVideoCommonUtils;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f448213a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static long f448214b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static int f448215c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f448216d = false;

    private static void a() {
        if (f448216d) {
            return;
        }
        f448216d = true;
        f448215c = x.b();
        f448213a = QZoneVideoCommonUtils.getCpuFrequency();
        f448214b = x.c();
    }

    public static boolean b() {
        boolean z16 = false;
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_EDITOR, QzoneConfig.SECONDARY_PASTER_BLACK_LIST, 0) == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("PasterUtil", 2, "hit black");
            }
            return false;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_EDITOR, QzoneConfig.SECONDARY_PASTER_WHITE_LIST, 0) == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("PasterUtil", 2, "hit white");
            }
            return true;
        }
        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_EDITOR, QzoneConfig.SECONDARY_PASTER_ENABLE_PERFORMANCE_TEST, 0) != 1) {
            return true;
        }
        a();
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_EDITOR, QzoneConfig.SECONDARY_PASTER_STANDARD_CPU_CORE, 1);
        int config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_EDITOR, QzoneConfig.SECONDARY_PASTER_STANDARD_CPU_FREQUENCY, 1100);
        int config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_EDITOR, QzoneConfig.SECONDARY_PASTER_STANDARD_RAM_SIZE, 1000);
        if (QLog.isColorLevel()) {
            QLog.d("PasterUtil", 2, "performanceTest, local, cpu core=" + f448215c + ", cpu frequency=" + f448213a + ", ram size=" + f448214b);
            QLog.d("PasterUtil", 2, "performanceTest, server, cpu core=" + config + ", cpu frequency=" + config2 + ", ram size=" + config3);
        }
        int i3 = f448215c;
        long j3 = f448213a;
        boolean z17 = ((long) i3) * j3 <= 0 || j3 * ((long) i3) > ((long) (config * config2));
        long j16 = f448214b;
        if (j16 <= 0) {
            return z17;
        }
        if (z17 && j16 > config3) {
            z16 = true;
        }
        return z16;
    }
}
