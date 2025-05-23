package r7;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.uploader.QZoneImageSizeStrategy;
import com.qzone.reborn.configx.g;
import com.qzone.util.image.c;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.UploadSdkConst;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import com.tencent.upload.uinterface.data.UppUploadTask;
import com.tencent.upload.uinterface.data.UpsImageUploadTask;
import com.tencent.upload.utils.Const;
import common.config.service.QzoneConfig;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.UploadEnv;
import java.io.File;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements IUploadConfig {
    private int a(String str, int i3) {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", str, i3);
    }

    private String b(String str, String str2) {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", str, str2);
    }

    public boolean c(int i3) {
        int compressToWebpFlag = getCompressToWebpFlag();
        if (i3 == 2 && (compressToWebpFlag & 16) == 16) {
            return true;
        }
        return (i3 == 2 || i3 == 3 || (compressToWebpFlag & 1) != 1) ? false : true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean canHoldSystemLock() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_KEY_CAN_HOLD_SYSTEM_LOCK, 0) == 1;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean checkApnChangeForInit() {
        return g.f53821a.j().j();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean enableBitmapNativeAlloc() {
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getAppId() {
        return 1000027;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getChangeRouteRetCodes() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_CHANGEROUTE_RETCODE, QzoneConfig.DEFAULT_UPLOAD_CHANGEROUTE_RETCODE);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getCompressToWebpFlag() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_COMPRESS_TO_WEBP, 0);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getConnectTimeout() {
        return a(QzoneConfig.SECONDARY_UPLOAD_CONNECT_TIMEOUT, 20);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getCurrentUin() {
        return LoginData.getInstance().getUin();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getDataTimeout() {
        return a(QzoneConfig.SECONDARY_UPLOAD_DATA_TIMEOUT, 60);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getDeviceInfo() {
        return PlatformInfor.g().getDeviceInfor();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getDoNotFragment() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_WNSSETTINGS, QzoneConfig.SECONDARY_IP_NO_PMTU_DISC, 1);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getExifTagCode(String str) {
        return com.qzone.util.image.a.a(str);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMaxSegmentSizeArray() {
        return null;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMobileLogUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_NEWTYPE_UPLOAD_MOBILE_LOG_HOST, UploadSdkConst.DEFAULT_LOG_HOST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getMobileLogUrlV6() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_LOG_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getNetworkUnavailableRetCodes() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_UPLOAD, QzoneConfig.SECONDARY_UPLOAD_NETWORK_UNAVAILABLE_RETCODE, QzoneConfig.DEFAULT_UPLOAD_NETWORK_UNAVAILABLE_RETCODE);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherBakUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherHostUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_HOST_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherOptUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getOtherOptUrlV6() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_OTHER_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoBakUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoHostUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoHostUrlV6() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_HOST_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoOptUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getPhotoOptUrlV6() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_IMAGE_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public float getPictureQuality(String str) {
        return 0.0f;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getQUA3() {
        return QUA.getQUA3();
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getRecentRouteExpire() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_RECENT_ROUTE_EXPIRE, 7200000L);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getTimeoutRetryCount() {
        return a(QzoneConfig.SECONDARY_UPLOAD_TIMEOUT_RETRY_COUNT, 3);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public IUploadConfig.UploadImageSize getUploadImageSize(IUploadConfig.UploadImageSize uploadImageSize, int i3, AbstractUploadTask abstractUploadTask) {
        if ((abstractUploadTask instanceof UpsImageUploadTask) && ((UpsImageUploadTask) abstractUploadTask).dataType == 2) {
            return QZoneImageSizeStrategy.getCoverUploadSize();
        }
        if (abstractUploadTask instanceof PhotoWallUploadTask) {
            return QZoneImageSizeStrategy.getPhotoWallTargetSize(new c.a(uploadImageSize.width, uploadImageSize.height), 80);
        }
        if (abstractUploadTask instanceof UppUploadTask) {
            return new IUploadConfig.UploadImageSize(uploadImageSize.width, uploadImageSize.height, QZoneImageSizeStrategy.getNetQuality(2, false));
        }
        TaskTypeConfig uploadTaskType = abstractUploadTask.getUploadTaskType();
        IUploadConfig.UploadImageSize targetSize = QZoneImageSizeStrategy.getTargetSize(new c.a(uploadImageSize.width, uploadImageSize.height), i3, uploadTaskType != null && uploadTaskType.uploadType == 0 ? c(i3) : false);
        if (targetSize == null) {
            return new IUploadConfig.UploadImageSize(0, 0, 0);
        }
        return i3 == 3 ? new IUploadConfig.UploadImageSize(uploadImageSize.width, uploadImageSize.height, 100) : targetSize;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getUploadPort() {
        return b(QzoneConfig.SECONDARY_SERVER_PORT_LIST, QzoneConfig.DefaultValue.SERVER_PORT_LIST);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoBakUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_BAK_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoHostUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_HOST_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoHostUrlV6() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_HOST_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoOptUrl() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_OPT_IP);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String getVideoOptUrlV6() {
        return QzoneConfig.getInstance().getConfig("PhotoSvrList", QzoneConfig.SECONDARY_VIDEO_UPLOAD_OPT_IP_V6);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getWifiOperator() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_EXTRA_CONFIG, QzoneConfig.SECONDARY_WIFI_OPERATOR_CRARRY, 0);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public long getWtAppId() {
        return 0L;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isNeedReleasePool() {
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isPictureNeedToCompress(String str) {
        int i3;
        int i16;
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            return true;
        }
        String[] split = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_COMPRESS_SIZE_LIMIT, QzoneConfig.DefaultValue.UPLOAD_PICTURE_COMPRESS_SIZE_LIMIT).split(",");
        if (split.length == 2) {
            i3 = Integer.parseInt(split[0]);
            i16 = Integer.parseInt(split[1]);
        } else {
            i3 = 200;
            i16 = 300;
        }
        int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_COMPRESS_QUALITY_LIMIT, 70);
        long length = new File(str).length();
        if (length <= i3 * 1024) {
            return false;
        }
        if (length <= i16 * 1024) {
            try {
                if (FileUtils.estimateFileType(str).equals("jpg")) {
                    if (JpegCompressor.getJpegQuality(str) <= config) {
                        return false;
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isReleaseMode() {
        return true;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean isSwitchOn(String str) {
        if (TextUtils.equals(str, Const.SwitchConfigKey.UPLOAD_PIC_VIDEO_CONNECT_TYPE_USE_EPOLL)) {
            return g.f53821a.j().m();
        }
        if (TextUtils.equals(str, Const.SwitchConfigKey.UPLOAD_PIC_COMPRESS_USE_NEW_STRATEGY)) {
            return g.f53821a.j().l();
        }
        if (TextUtils.equals(str, Const.SwitchConfigKey.UPS_USE_NEW_STRATEGY)) {
            return VasNormalToggle.BUG_DIY_UPLOAD.isEnable(true);
        }
        if (Const.SwitchConfigKey.QQCIRCLE_CHANGE_ROUTE_FOR_IPV6.equals(str)) {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, true);
        }
        if (Const.SwitchConfigKey.QQCIRCLE_ENABLE_NEW_CHANGE_STACKTYPE.equals(str)) {
            return g.f53821a.j().k();
        }
        return false;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public String loadAsString(String str, String str2) {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(str, str2);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean useNewCopyExif() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", "use_new_pic_compress", 1) == 1;
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public boolean enableV6Route() {
        return UploadEnv.enableV6Switch(0);
    }

    @Override // com.tencent.upload.uinterface.IUploadConfig
    public int getGifUploadLimit(int i3) {
        if (i3 == 1) {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_WIFI, 5242880);
        }
        if (i3 == 2) {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_3G, 2097152);
        }
        if (i3 == 3) {
            return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_2G, 819200);
        }
        if (i3 != 6) {
            return 0;
        }
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_GIF_UPLOAD_LIMIT_4G, 5242880);
    }
}
