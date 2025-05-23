package se4;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.tbs.reader.tool.TbsToolEntrance;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import re4.b;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    private static String a(Uri uri, String str, String str2, String str3, String str4, String str5, String str6) {
        return "qb://filesdk/reader?feature=" + str + "&pullnew=true&callFrom=tbs&pkg=" + str2 + "&fileUri=" + uri.toString() + "&filePath=" + str3 + "&fileName=" + str4 + "&fileSize=" + str5 + "&fileExt=" + str6;
    }

    private static Uri b(Context context, File file) {
        String[] strArr = {context.getApplicationContext().getPackageName() + ".tbsfileprovider", c(context, "android.support.v4.content.FileProvider"), c(context, "androidx.core.content.FileProvider")};
        for (int i3 = 0; i3 < 3; i3++) {
            String str = strArr[i3];
            if (!TextUtils.isEmpty(str)) {
                return FileProvider.getUriForFile(context, str, file);
            }
            continue;
        }
        return null;
    }

    private static String c(Context context, String str) {
        try {
            ProviderInfo providerInfo = context.getPackageManager().getProviderInfo(new ComponentName(context.getApplicationContext().getPackageName(), str), 0);
            if (providerInfo != null) {
                return providerInfo.authority;
            }
            return null;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static String d(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() - 1) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    private static Intent e(String str, String str2, String str3, Boolean[] boolArr, Uri uri) {
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.putExtra("ChannelID", "com.tencent.mobileqq");
        intent.putExtra("PosID", str2);
        if (boolArr[0].booleanValue()) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uri, str3);
        intent.setPackage(TbsConfig.APP_QB);
        intent.setComponent(new ComponentName(TbsConfig.APP_QB, "com.tencent.mtt.external.reader.thirdcall.ThirdCallAllFileReaderActivity"));
        intent.addFlags(268435456);
        intent.addFlags(67108864);
        return intent;
    }

    private static Uri f(Context context, File file, Boolean[] boolArr) {
        Log.d("setDataAndType", "setDataAndType:");
        Uri uri = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                uri = b(context, file);
                if (uri != null) {
                    boolArr[0] = Boolean.TRUE;
                    Log.d("setDataAndType", "setDataAndType uri is " + uri);
                }
            } catch (Throwable th5) {
                Log.d("setDataAndType", "setDataAndType stack is " + Log.getStackTraceString(th5));
            }
        }
        if (uri == null) {
            Uri fromFile = Uri.fromFile(file);
            Log.d("setDataAndType", "setDataAndType22");
            return fromFile;
        }
        return uri;
    }

    private static String g(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
            if (!TextUtils.isEmpty(mimeTypeFromExtension)) {
                return mimeTypeFromExtension;
            }
            return str2;
        }
        return str2;
    }

    private static Intent h(String str, Boolean[] boolArr, Uri uri, String str2) {
        String str3 = "mtt/" + str2;
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        intent.putExtra("ChannelID", "com.tencent.mobileqq");
        intent.putExtra("PosID", str);
        if (boolArr[0].booleanValue()) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uri, str3);
        intent.setPackage(TbsConfig.APP_QB);
        intent.addFlags(268435456);
        return intent;
    }

    private static PackageInfo i(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), TbsConfig.APP_QB, 0);
            b.d("TbsOpenQBUtils", "QB version: " + packageInfo.versionCode + " version name: " + packageInfo.versionName);
            return packageInfo;
        } catch (Exception e16) {
            e16.printStackTrace();
            return packageInfo;
        }
    }

    private static String j(String str) {
        if ("chm".equals(str)) {
            return "text/plain";
        }
        if ("epub".equals(str)) {
            return "application/epub";
        }
        return "*/*";
    }

    private static boolean k(Context context, String str) {
        if (InstalledAppListMonitor.getPackageInfo(context.getApplicationContext().getPackageManager(), str, 0) == null) {
            return false;
        }
        return true;
    }

    private static void l(Uri uri, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String a16 = a(uri, str, str2, str3, str4, str5, str6);
        try {
            a16 = URLEncoder.encode(a16, "UTF-8");
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        String str9 = "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html?from=qqpreview&text=" + str7 + "&channel=com.tencent.mobileqq&callback_url=" + a16 + "&refer_url=qqpreview&auto=true&qb_down_ch=" + str8;
        if (TbsToolEntrance.getInstance().getToolHost() != null) {
            TbsToolEntrance.getInstance().getToolHost().openWebPage(str9);
        }
    }

    public static void m(Context context, File file, String str, String str2, String str3) {
        int i3;
        Intent e16;
        if (context != null && file != null && str != null && str2 != null && str3 != null) {
            String packageName = context.getApplicationContext().getPackageName();
            b.d("TbsOpenQBUtils", "openQQBrowser srcFile: " + file + " text: " + str + " channelId: " + str2 + " PosId: " + str3);
            String absolutePath = file.getAbsolutePath();
            String d16 = d(absolutePath);
            String name = file.getName();
            String valueOf = String.valueOf(file.length());
            String g16 = g(d16, "*/*");
            if ("*/*".equals(g16)) {
                g16 = j(d16);
            }
            Boolean[] boolArr = {Boolean.FALSE};
            Uri f16 = f(context, file, boolArr);
            PackageInfo i16 = i(context);
            if (i16 != null) {
                i3 = i16.versionCode;
            } else {
                i3 = -1;
            }
            if (k(context, TbsConfig.APP_QB)) {
                if (i3 < 15110500) {
                    b.d("TbsOpenQBUtils", "openQQBrowserFileTab, earlier version of QB, version: " + i3);
                    e16 = h(str3, boolArr, f16, d16);
                } else {
                    e16 = e(str2, str3, g16, boolArr, f16);
                }
                context.startActivity(e16);
                return;
            }
            l(f16, "", packageName, absolutePath, name, valueOf, d16, str, str2);
            return;
        }
        b.b("TbsOpenQBUtils", "openQQBrowser parameter should not be null");
    }
}
