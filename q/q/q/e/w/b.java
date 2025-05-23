package q.q.q.e.w;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f428115a = "";

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class a {
        public static void a(Context context) {
            String g16 = g(context);
            if (TextUtils.isEmpty(g16)) {
                return;
            }
            e.c("ILogX", "deleteOldLogFiles File", true);
            File file = new File(g16);
            if (file.exists() && file.isDirectory()) {
                b(file);
            }
        }

        private static void b(File file) {
            if (file == null) {
                e.c("ILogX", "deleteDirInnerPicFileDir == null", true);
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                if ((file2.getName().contains("apphnid.txt") || file2.getName().contains("apphnid.txt.bak") || file2.getName().contains("honorid_advanced_log.txt")) && !file2.delete()) {
                    Log.i("deleteDirInnerPicFile", "delete file fail");
                }
            }
        }

        private static boolean c() {
            if (!"mounted".equals(Environment.getExternalStorageState()) && e()) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static String d(Context context) {
            String str = f(context) + "/Log/";
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            return str;
        }

        @TargetApi(9)
        private static boolean e() {
            return Environment.isExternalStorageRemovable();
        }

        private static String f(Context context) {
            try {
                return context.getFilesDir().getCanonicalPath();
            } catch (IOException unused) {
                e.c("ILogX", "getCanonicalPath is IOException", true);
                return null;
            }
        }

        static String g(Context context) {
            String str = h(context) + "/Log/";
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            return str;
        }

        private static String h(Context context) {
            File externalFilesDir;
            if (c() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                try {
                    return externalFilesDir.getCanonicalPath();
                } catch (IOException unused) {
                    e.c("ILogX", "Exception", true);
                }
            }
            return null;
        }
    }

    public static String a() {
        return f428115a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        String str;
        if (context != null && h45.e.a(context).b().equals(context.getPackageName())) {
            try {
                str = "HONORID_APK_log[" + InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName + "]:";
            } catch (PackageManager.NameNotFoundException e16) {
                Log.e("honorid", "getVersionTag error" + e16.getClass().getSimpleName());
            }
            if (!TextUtils.isEmpty(str)) {
                return "HonorID_openSDK_log[8.0.1.351]";
            }
            return str;
        }
        str = "";
        if (!TextUtils.isEmpty(str)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(String str, String str2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(String str, String str2);
}
