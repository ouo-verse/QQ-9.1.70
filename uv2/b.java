package uv2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import ev2.e;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    public static boolean a(Context context, Intent intent, String str) {
        ComponentName resolveActivity;
        if (!e.e() || context == null || intent == null || (resolveActivity = intent.resolveActivity(context.getPackageManager())) == null || resolveActivity.getPackageName() == null || !resolveActivity.getPackageName().equals(str)) {
            return false;
        }
        return true;
    }

    public static String b(Context context, String str) {
        if (e.e() && context != null && str != null) {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            PackageManager packageManager = context.getPackageManager();
            ComponentName resolveActivity = intent.resolveActivity(packageManager);
            if (resolveActivity != null) {
                try {
                    return packageManager.getApplicationLabel(packageManager.getApplicationInfo(resolveActivity.getPackageName(), 0)).toString();
                } catch (PackageManager.NameNotFoundException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return "";
    }

    public static boolean c(Context context, String str) {
        ComponentName resolveActivity;
        if (!e.e() || context == null || str == null || (resolveActivity = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str)).resolveActivity(context.getPackageManager())) == null || TextUtils.isEmpty(resolveActivity.getPackageName())) {
            return false;
        }
        return true;
    }

    public static boolean d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            n.e("OpenAppUtil", "openSchemeUrl, schemeUrl:" + str);
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
            intent.setFlags(268435456);
            intent.putExtra("callingPackageName", context.getPackageName());
            intent.putExtra("isOpenApp", true);
            intent.putExtra("big_brother_source_key", "biz_src_ads_xsj");
            context.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
