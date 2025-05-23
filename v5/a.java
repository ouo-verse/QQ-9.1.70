package v5;

import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.winkpublish.util.ImageQualityPreference;
import common.config.service.QzoneConfig;
import u5.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f440975a;

    a() {
    }

    public static a a() {
        if (f440975a == null) {
            synchronized (a.class) {
                if (f440975a == null) {
                    f440975a = new a();
                }
            }
        }
        return f440975a;
    }

    public int b() {
        int config = QzoneConfig.getInstance().getConfig("PhotoUpload", "UploadQuality", 0);
        if (config < 0 || config > 3) {
            return 0;
        }
        return config;
    }

    public int c() {
        int config = QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_UPLOAD_ALL_PIC_QUALITY, 2);
        if (config < 0 || config > 3) {
            return 2;
        }
        return config;
    }

    public int d(String str) {
        if (str.equals(ImageQualityPreference.TYPE_SHUOSHUO_ALL_PIC)) {
            if (f()) {
                return b.L(str, 0, LoginData.getInstance().getUin());
            }
            return c();
        }
        if (e()) {
            return b.L(str, 0, LoginData.getInstance().getUin());
        }
        return b();
    }

    public boolean e() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_USE_LOCAL_QUALITY, 1) != 0;
    }

    public boolean f() {
        return QzoneConfig.getInstance().getConfig("PhotoUpload", QzoneConfig.SECONDARY_PHOTO_USE_LOCAL_QUALITY_FOR_SHUOSHUO, 0) != 0;
    }
}
