package wq;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static int a() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_camerakit_log_switch", false);
        ms.a.f("WnsConfig", "cameraKitLogLevel " + isSwitchOn);
        return !isSwitchOn ? 1 : 2;
    }

    public static boolean b() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_camera_codec_switch", false);
    }

    public static String c() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_camera_codec_url", "https://downv6.qq.com/shadow_qqcamera/Android/res/switchConfig_8888.json");
    }

    public static boolean d() {
        boolean z16 = false;
        try {
            z16 = QzoneConfig.checkWinkEditOptimizeOpenByUid(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), "qqcircle_aekit_bundle_can_preload", 0);
            ms.a.f("WnsConfig", "isAEKitNeedDownload \uff1a " + z16);
            return z16;
        } catch (Exception e16) {
            ms.a.c("WnsConfig", "isAEKitNeedDownload has exception " + e16.getMessage());
            return z16;
        }
    }

    public static boolean e() {
        boolean z16 = false;
        try {
            z16 = QzoneConfig.checkWinkEditOptimizeOpenByUid(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), "qqcircle_aekit_qnn_switch", 10);
            ms.a.f("WnsConfig", "isAEKitNeedQNN \uff1a " + z16);
            return z16;
        } catch (Exception e16) {
            ms.a.c("WnsConfig", "isAEKitNeedQNN has exception " + e16.getMessage());
            return z16;
        }
    }

    public static boolean f() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "close_no_status_download", true);
    }

    public static boolean g() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_image_center_lightsdk_gzip_switch", true);
    }

    public static boolean h() {
        boolean z16 = false;
        try {
            z16 = QzoneConfig.checkWinkEditOptimizeOpenByUid(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), "qqcircle_aekit_need_version_limit", 0);
            ms.a.f("WnsConfig", "version fix isNeedVersionLimit \uff1a " + z16);
            return z16;
        } catch (Exception e16) {
            ms.a.c("WnsConfig", "version fix isNeedVersionLimit has exception " + e16.getMessage());
            return z16;
        }
    }

    public static boolean i() {
        return QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_pag_hook_switch", true);
    }
}
