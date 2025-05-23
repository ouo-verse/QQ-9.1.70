package vl2;

import android.text.TextUtils;
import android.util.Log;
import com.qzone.proxy.feedcomponent.manager.QZoneVideoLoader;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends PlayerUtils {
    public static void a() {
        try {
            int i3 = QZoneVideoLoader.F;
            QZoneVideoLoader.class.getDeclaredMethod("initVideoSDK", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e16) {
            Log.e("PlayerUtils", "initVideoSDKReflectFailed not in mobileqq env? " + e16.toString());
        }
    }

    public static boolean b(String str) {
        List<String> tcVideoPathList = PlayerConfig.g().getTcVideoPathList();
        if (tcVideoPathList == null || tcVideoPathList.size() == 0) {
            tcVideoPathList = new ArrayList<>(Arrays.asList("video.tc.qq.com", "vkp.tc.qq.com"));
        }
        if (TextUtils.isEmpty(str) || tcVideoPathList.size() <= 0) {
            return false;
        }
        Iterator<String> it = tcVideoPathList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<String> hostLastPathVideoList = PlayerConfig.g().getHostLastPathVideoList();
        if (hostLastPathVideoList != null && hostLastPathVideoList.size() > 0) {
            for (String str2 : hostLastPathVideoList) {
                if (str.contains(str2)) {
                    return str2;
                }
            }
        }
        if (TextUtils.isEmpty(str) || !str.contains("tcdn.qq.com")) {
            return null;
        }
        return "tcdn.qq.com";
    }

    public static boolean d(String str) {
        List<String> normalVideoPathList = PlayerConfig.g().getNormalVideoPathList();
        if (normalVideoPathList == null || normalVideoPathList.size() == 0) {
            normalVideoPathList = new ArrayList<>(Arrays.asList("vwecam.tc.qq.com", "vliveachy.tc.qq.com", "vqzone.tc.qq.com", "video.mtv.qq.com"));
        }
        if (TextUtils.isEmpty(str) || normalVideoPathList.size() <= 0) {
            return false;
        }
        Iterator<String> it = normalVideoPathList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(String str) {
        List<String> weiShiUgcVideoPathList = PlayerConfig.g().getWeiShiUgcVideoPathList();
        if (weiShiUgcVideoPathList == null || weiShiUgcVideoPathList.size() == 0) {
            weiShiUgcVideoPathList = new ArrayList<>(Arrays.asList("vcloud.tc.qq.com/"));
        }
        if (TextUtils.isEmpty(str) || weiShiUgcVideoPathList.size() <= 0) {
            return false;
        }
        Iterator<String> it = weiShiUgcVideoPathList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(String str) {
        List<String> weiShiVideoPathList = PlayerConfig.g().getWeiShiVideoPathList();
        if (weiShiVideoPathList == null || weiShiVideoPathList.size() == 0) {
            weiShiVideoPathList = new ArrayList<>(Arrays.asList("video.qzone.qq.com/", "sv.qzone.qq.com/"));
        }
        if (TextUtils.isEmpty(str) || weiShiVideoPathList.size() <= 0) {
            return false;
        }
        Iterator<String> it = weiShiVideoPathList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
