package wy3;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static d f446776a = new d();
    }

    private boolean a(File file) {
        if (file.exists()) {
            return true;
        }
        if (a(file.getParentFile())) {
            return file.mkdir();
        }
        return false;
    }

    public static d c() {
        return a.f446776a;
    }

    public File b(@NonNull Context context, @NonNull String str) {
        File file = new File(d(context) + str);
        try {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    file.delete();
                    file.mkdir();
                }
            } else {
                a(file);
            }
            return file;
        } catch (Throwable th5) {
            try {
                c.h("PerfToolSaveHelper", "getDir failed! dirPath = " + str, th5);
            } catch (Throwable unused) {
            }
            return null;
        }
    }

    public String d(@NonNull Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        return absolutePath + "PToolFile/";
    }
}
