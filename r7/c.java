package r7;

import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {
    public static String a(int i3) {
        if (i3 == 0) {
            return "";
        }
        if (i3 == 1700) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFileNotExist", "\u6587\u4ef6\u4e0d\u5b58\u5728,\u8bf7\u68c0\u67e5\u6587\u4ef6");
        }
        if (i3 == 10000) {
            return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "QcircleUploadGenerateVideoFail", "\u89c6\u9891\u5408\u6210\u5931\u8d25");
        }
        if (i3 != 10001) {
            switch (i3) {
                case FSUploadConst.ERR_LOGIN_STATUS_EMPTY /* 1702 */:
                    return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadLoginError", "\u767b\u5f55\u6001\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u540e\u91cd\u8bd5");
                case FSUploadConst.ERR_LOGIN_UIN_ILLEGAL /* 1703 */:
                    return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadLoginError", "\u767b\u5f55\u6001\u5f02\u5e38\uff0c\u8bf7\u91cd\u65b0\u767b\u5f55\u540e\u91cd\u8bd5");
                case FSUploadConst.ERR_UPLOAD_RESULT_ILLEGAL /* 1704 */:
                    return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadResultError", "\u4e0a\u4f20\u8fd4\u56de\u7ed3\u679c\u5931\u8d25");
                case FSUploadConst.ERR_NO_LOGIN /* 1705 */:
                    return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadNotLogin", "\u767b\u5f55\u672a\u5b8c\u6210\uff0c\u8bf7\u7a0d\u5019\u91cd\u8bd5");
                case FSUploadConst.ERR_COMPRESS_ENV_UNPREPAERD /* 1706 */:
                    return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadVideoComposeFail", "\u89c6\u9891\u5408\u6210\u5931\u8d25");
                case FSUploadConst.ERR_GENERATE_VIDEO_COVER_FAIL /* 1707 */:
                    return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadGenerateVideoCoverFail", "\u4f20\u89c6\u9891\u5c01\u9762\u5931\u8d25(\u6587\u4ef6\u4e0d\u5b58\u5728)");
                default:
                    return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "UploadFail", "\u4e0a\u4f20\u5931\u8d25");
            }
        }
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "QcircleUploadGenerateVideoTimeOutFail", "\u89c6\u9891\u5408\u6210\u8d85\u65f6");
    }
}
