package py3;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.nativememorymonitor.library.IFileMonitor;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.ForegroundUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements IFileMonitor {

    /* renamed from: c, reason: collision with root package name */
    private static Set<String> f428072c = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    Context f428073a;

    /* renamed from: b, reason: collision with root package name */
    String f428074b;

    private boolean a(String str) {
        if (this.f428074b == null || TextUtils.isEmpty(str) || !str.startsWith(com.tencent.qqperf.monitor.file.a.f363247f) || str.startsWith(this.f428074b)) {
            return true;
        }
        a aVar = (a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102279");
        if (aVar != null) {
            Iterator<String> it = aVar.f428068d.iterator();
            while (it.hasNext()) {
                if (str.startsWith(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean b() {
        Context context = this.f428073a;
        if (context != null && context.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && this.f428073a.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    private static String c(boolean z16) {
        if (z16) {
            return "1";
        }
        return "0";
    }

    public static String d(Throwable th5) {
        StackTraceElement[] stackTrace = th5.getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement);
        }
        return sb5.toString();
    }

    public static int e(ContentResolver contentResolver, Uri uri, String str, String[] strArr) {
        if (uri != null) {
            try {
                if (uri.toString().contains(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) || uri.toString().contains(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
                    Throwable th5 = new Throwable("Media delete.uri:" + uri);
                    QLog.e("ExternalDirFileOperationMonitor", 1, "Media delete.uri:" + uri + " where:" + str + " selectionArgs:" + Arrays.toString(strArr), th5);
                    j("1", uri.toString(), true, ForegroundUtil.isAppOnForeground(), d(th5), "0");
                }
            } catch (Exception e16) {
                QLog.e("ExternalDirFileOperationMonitor", 1, "delete report error.", e16);
            }
        }
        return contentResolver.delete(uri, str, strArr);
    }

    private String f(String str) {
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (lastIndexOf <= 0) {
            return "";
        }
        return str.substring(0, lastIndexOf);
    }

    private boolean g(String str) {
        String n3 = n(str);
        if (n3.startsWith("DCIM") || n3.startsWith("Movies")) {
            return true;
        }
        return n3.startsWith("Pictures");
    }

    private boolean h(String str) {
        if (!str.startsWith(com.tencent.qqperf.monitor.file.a.f363247f) || this.f428074b == null || TextUtils.isEmpty(str) || str.startsWith(this.f428074b)) {
            return false;
        }
        if (g(str)) {
            return true;
        }
        String f16 = f(str);
        if (f428072c.contains(f16)) {
            return false;
        }
        f428072c.add(f16);
        return true;
    }

    public static void j(String str, String str2, boolean z16, boolean z17, String str3, String str4) {
        String str5;
        TreeMap treeMap = new TreeMap();
        treeMap.put("key_hook_type", str);
        treeMap.put("key_open_file_path", str2);
        treeMap.put("key_is_photo", c(z16));
        treeMap.put("key_is_foreground", c(z17));
        treeMap.put("key_stack", str3);
        treeMap.put("key_operate_type", str4);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str5 = peekAppRuntime.getCurrentUin();
        } else {
            str5 = "0";
        }
        QLog.d("ExternalDirFileOperationMonitor", 1, "reportBeacon param:" + treeMap);
        if (z16) {
            QQBeaconReport.report(str5, "external_media_file_delete", treeMap);
        } else {
            QQBeaconReport.report(str5, "external_dir_file_Operation", treeMap);
        }
    }

    private void k(String str, String str2, String str3, boolean z16, String str4) {
        j(str, str3, z16, ForegroundUtil.isAppOnForeground(), d(new Throwable(str2 + str3)), str4);
    }

    private void l(String str, String str2) {
        String str3;
        if (!AppSetting.isPublicVersion() || AppSetting.isGrayVersion()) {
            TreeMap treeMap = new TreeMap();
            boolean isAppOnForeground = ForegroundUtil.isAppOnForeground();
            boolean b16 = b();
            Throwable th5 = new Throwable(str2);
            treeMap.put("key_open_file_path", str);
            treeMap.put("key_is_foreground", c(isAppOnForeground));
            treeMap.put("key_storage_permission", c(b16));
            treeMap.put("key_stack", d(th5));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str3 = peekAppRuntime.getCurrentUin();
            } else {
                str3 = "0";
            }
            QLog.d("ExternalDirFileOperationMonitor", 1, "reportBeacon param:" + treeMap);
            QQBeaconReport.report(str3, "external_dir_file_Open", treeMap);
        }
    }

    private void m(String str, int i3, int i16) {
        if (!h(str)) {
            return;
        }
        String format = String.format(Locale.getDefault(), "external file open %s, flags %d, mode %d", str, Integer.valueOf(i3), Integer.valueOf(i16));
        QLog.d("ExternalDirFileOperationMonitor", 1, format);
        try {
            l(str, format);
        } catch (Exception e16) {
            QLog.e("ExternalDirFileOperationMonitor", 1, "reportFileOpen error", e16);
        }
    }

    @NonNull
    private String n(String str) {
        int length = com.tencent.qqperf.monitor.file.a.f363247f.length();
        int lastIndexOf = str.lastIndexOf(File.separator);
        if (length >= lastIndexOf) {
            return "";
        }
        return str.substring(length, lastIndexOf);
    }

    void i(String str, String str2, String str3) {
        String format;
        if (a(str)) {
            return;
        }
        if (str2 == null) {
            format = String.format("external file deleted %s", str);
        } else {
            format = String.format("external file rename from %s to %s", str, str2);
        }
        String str4 = format;
        QLog.e("ExternalDirFileOperationMonitor", 1, str4);
        if (g(str)) {
            k(str4, "EXTERNAL_FILE_DELETE_DIR:", n(str), true, str3);
        } else {
            if (!AppSetting.isPublicVersion()) {
                return;
            }
            k(str4, "EXTERNAL_FILE_DELETE_DIR:", n(str), false, str3);
        }
    }

    @Override // com.tencent.mobileqq.nativememorymonitor.library.IFileMonitor
    public void onFileOpen(String str, int i3, int i16) {
        m(str, i3, i16);
    }

    @Override // com.tencent.mobileqq.nativememorymonitor.library.IFileMonitor
    public void onFileRemove(String str) {
        i(str, null, "0");
    }

    @Override // com.tencent.mobileqq.nativememorymonitor.library.IFileMonitor
    public void onFileRename(String str, String str2) {
        i(str, str2, "1");
    }
}
