package q;

import android.net.Uri;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b {
    public static boolean a(Uri uri) {
        if (b(uri) && !e(uri)) {
            return true;
        }
        return false;
    }

    public static boolean b(Uri uri) {
        if (uri != null && "content".equals(uri.getScheme()) && QAdVrReportParams.ParamKey.MEDIA.equals(uri.getAuthority())) {
            return true;
        }
        return false;
    }

    public static boolean c(Uri uri) {
        if (b(uri) && e(uri)) {
            return true;
        }
        return false;
    }

    public static boolean d(int i3, int i16) {
        if (i3 != Integer.MIN_VALUE && i16 != Integer.MIN_VALUE && i3 <= 512 && i16 <= 384) {
            return true;
        }
        return false;
    }

    private static boolean e(Uri uri) {
        return uri.getPathSegments().contains("video");
    }
}
