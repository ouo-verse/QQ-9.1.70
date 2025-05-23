package y81;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.ar.model.ArVideoResourceInfo;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.util.Pair;
import java.io.File;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ISPlayerPreDownloader f449553a;

    public static String a(String str) {
        try {
            return b() + MD5Utils.toMD5(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AROnlineVideoUtil", 2, "getStorageDir, Exception");
                e16.printStackTrace();
                return null;
            }
            return null;
        }
    }

    private static String b() {
        if (cu.e()) {
            return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "iar" + File.separator);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplicationImpl.getApplication().getFilesDir());
        String str = File.separator;
        sb5.append(str);
        sb5.append("iar");
        sb5.append(str);
        return sb5.toString();
    }

    private static boolean c(String str) {
        File file = new File(str);
        if (file.exists() && file.length() > 0) {
            return true;
        }
        return false;
    }

    public static Pair<Long, String> d(String str) {
        String[] split;
        long j3;
        if (QLog.isColorLevel()) {
            QLog.d("AROnlineVideoUtil", 2, "parseFileSize, str=" + str);
        }
        if (TextUtils.isEmpty(str) || (split = str.split("\\|")) == null || split.length != 2) {
            return null;
        }
        try {
            j3 = Long.parseLong(split[0]);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                e16.printStackTrace();
            }
            j3 = -1;
        }
        if (j3 == -1) {
            return null;
        }
        return new Pair<>(Long.valueOf(j3), split[1]);
    }

    public static void e(Context context, ArVideoResourceInfo arVideoResourceInfo) {
        if (arVideoResourceInfo != null && !TextUtils.isEmpty(arVideoResourceInfo.E) && arVideoResourceInfo.D == 4) {
            boolean z16 = true;
            if (NetworkUtil.getNetworkType(BaseApplication.getContext()) != 1) {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AROnlineVideoUtil", 2, "preload for multi, isWifi=" + z16);
            }
            if (!z16) {
                return;
            }
            if (f449553a == null) {
                f449553a = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getApplication(), 108);
            }
            if (!TextUtils.isEmpty(arVideoResourceInfo.E)) {
                String str = arVideoResourceInfo.E;
                String a16 = a(str);
                boolean c16 = c(a16);
                if (QLog.isColorLevel()) {
                    QLog.d("AROnlineVideoUtil", 2, "preload for multi, url=" + str + ", videoPath=" + a16 + ", isCached=" + c16);
                }
                SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(str, 101, MD5Utils.toMD5(str));
                if (arVideoResourceInfo.f198427e > 4) {
                    f449553a.startPreDownload(createVideoInfoForUrl, arVideoResourceInfo.f198427e / 4);
                }
            }
        }
    }

    public static void f() {
        if (f449553a != null) {
            f449553a.destory();
            f449553a = null;
        }
    }
}
