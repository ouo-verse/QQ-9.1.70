package pw2;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.VideoReportInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$SceneType;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.HashMap;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Context f427748a;

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Drawable> f427749b = new HashMap<>();

    public static String a() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return System.currentTimeMillis() + "__" + String.valueOf(Math.random());
        }
    }

    public static boolean b(Context context, String str) {
        return c(context, str, -1);
    }

    public static boolean c(Context context, String str, int i3) {
        boolean z16 = false;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 0);
            if (packageInfo != null && packageInfo.versionCode >= i3) {
                z16 = true;
            }
            if (z16) {
                n.g("AdCoreUtils", "packageName: " + packageInfo.packageName + ", versionCode: " + packageInfo.versionCode);
            }
        } catch (Exception e16) {
            n.g("AdCoreUtils", "" + e16);
        }
        return z16;
    }

    public static boolean d(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            return b(context, str);
        }
        return uv2.b.c(context, str2);
    }

    public static boolean e(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            n.e("AdCoreUtils", "openSchemeUrl, schemeUrl:" + str);
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtra("isOpenApp", true);
            intent.putExtra("big_brother_source_key", "biz_src_ads_xsj");
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void f(Context context, String str, VideoReportInfo videoReportInfo, @VRReportDefine$SceneType int i3) {
        try {
            n.g("AdCoreUtils", "startApp");
            boolean g16 = g(context, str);
            if (videoReportInfo != null) {
                QAdVrReport.k(videoReportInfo, g16, str, i3);
            }
        } catch (Exception e16) {
            n.g("AdCoreUtils", "" + e16);
        }
    }

    public static boolean g(Context context, String str) {
        try {
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                launchIntentForPackage.putExtra("big_brother_source_key", "biz_src_ads_xsj");
                context.startActivity(launchIntentForPackage);
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
