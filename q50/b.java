package q50;

import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.manager.d;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.decode.LibraRequestKey;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import uq3.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f428379a = null;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f428380b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f428381c = false;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f428382d = false;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f428383e = false;

    public b() {
        f428380b = j();
        f428381c = l();
    }

    private void a(Option option) {
        if (option == null) {
            return;
        }
        option.setResultBitMap(null);
        option.setFailDrawable(null);
        option.setLoadingDrawable(null);
        QCircleFeedPicLoader.g().removeCache(option);
    }

    public static b e() {
        if (f428379a == null) {
            synchronized (b.class) {
                if (f428379a == null) {
                    f428379a = new b();
                }
            }
        }
        return f428379a;
    }

    private boolean i() {
        if (QCircleDeviceInfoUtils.getSystemTotalMemory() <= c.h1()) {
            return true;
        }
        return false;
    }

    private boolean j() {
        return QCircleDeviceInfoUtils.isLowDevice();
    }

    private boolean k() {
        if (RFWApplication.isDebug() || QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_enabled_low_level_device_bitmap_scale", 1) == 1) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (RFWApplication.isDebug() || QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_enabled_low_level_device_memory_optimize", 1) == 1) {
            return true;
        }
        return false;
    }

    private boolean m() {
        if (RFWApplication.isDebug() || QzoneConfig.getInstance().getConfig("qqcircle", "qcircle_video_cover_memory_optimize", 1) == 1) {
            return true;
        }
        return false;
    }

    private void p(Option option, boolean z16) {
        if (z16) {
            return;
        }
        option.setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565);
    }

    public void b(Option option) {
        if (option == null || !f()) {
            return;
        }
        ImageView targetView = option.getTargetView();
        if (!(targetView instanceof ImageView)) {
            return;
        }
        if (targetView != null) {
            targetView.setImageDrawable(null);
        }
        QLog.d("QFSMemoryOptimizeManager", 1, "[clearImageMemory] image view: " + targetView + " | option: " + option.getSeq());
        a(option);
    }

    public void c(Option option) {
        LibraRequestKey cacheKey;
        if (!i() || !c.T6()) {
            return;
        }
        if (option == null) {
            cacheKey = null;
        } else {
            cacheKey = option.getCacheKey();
        }
        QLog.d("QFSMemoryOptimizeManager", 1, "[clearLowMemoryForImage] clear low memory image, cacheKey: " + cacheKey);
        b(option);
    }

    public void d() {
        if (!h()) {
            return;
        }
        d.c().m();
    }

    public boolean f() {
        boolean m3 = m();
        if (f428383e != m3) {
            QLog.d("QFSMemoryOptimizeManager", 1, "[isEnabledCoverMemoryOptimize] isWnsVideoCoverMemoryOptimize: " + m3);
            f428383e = m3;
        }
        return f428383e;
    }

    public boolean g() {
        boolean h16 = h();
        boolean k3 = k();
        if (k3 != f428382d) {
            QLog.d("QFSMemoryOptimizeManager", 1, "[isEnabledLowLevelDeviceBitmapScale] isWnsEnabledLowLevelDeviceBitmapScale: " + k3);
            f428382d = k3;
        }
        if (h16 && f428382d) {
            return true;
        }
        return false;
    }

    public boolean h() {
        boolean j3 = j();
        boolean l3 = l();
        if (f428380b != j3 || l3 != f428381c) {
            QLog.d("QFSMemoryOptimizeManager", 1, "[isEnabledLowSideMemoryOptimize] isLowSideDevice: " + j3 + " | isWnsEnabledLowLevelDeviceMemoryOptimize: " + l3);
            f428380b = j3;
            f428381c = l3;
        }
        if (f428380b && f428381c) {
            return true;
        }
        return false;
    }

    public void n(Option option) {
        if (!f() || option == null || option.getResultBitMap() != null) {
            return;
        }
        QCircleFeedPicLoader.g().loadImage(option);
    }

    public void o(Option option) {
        LibraRequestKey cacheKey;
        if (!i() || !c.T6()) {
            return;
        }
        if (option == null) {
            cacheKey = null;
        } else {
            cacheKey = option.getCacheKey();
        }
        QLog.d("QFSMemoryOptimizeManager", 1, "[restoreLowMemoryForImage] restore low memory image, cacheKey: " + cacheKey);
        n(option);
    }

    public void q(Option option, boolean z16) {
        if (option == null) {
            QLog.e("QFSMemoryOptimizeManager", 1, "[updateLowSlideBitmapOption] option should not be null.");
        } else if (!g()) {
            p(option, z16);
        } else {
            p(option, z16);
        }
    }
}
