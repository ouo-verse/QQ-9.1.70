package rv2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.cache.QAdVideoCacheGenerate;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import pw2.n;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static final String f432562a = File.separator;

    /* renamed from: b, reason: collision with root package name */
    private static String f432563b = null;

    public static String a() {
        String str = f432563b;
        if (str != null) {
            return str;
        }
        if (qv2.b.a() == null) {
            return null;
        }
        try {
            File externalFilesDir = qv2.b.a().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(externalFilesDir.getAbsoluteFile());
                String str2 = f432562a;
                sb5.append(str2);
                sb5.append("ad");
                sb5.append(str2);
                sb5.append("video");
                sb5.append(str2);
                f432563b = sb5.toString();
                File file = new File(f432563b);
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
        } catch (Throwable th5) {
            n.c("QAdVideoCache", th5);
        }
        return f432563b;
    }

    public static String b(String str, String str2, int i3) {
        String[] strArr = {"fhd", "shd", "hd", "sd", "msd"};
        int i16 = 0;
        while (true) {
            if (i16 < 5) {
                if (strArr[i16].equalsIgnoreCase(str2)) {
                    break;
                }
                i16++;
            } else {
                i16 = -1;
                break;
            }
        }
        String str3 = null;
        if (i16 > -1) {
            boolean z16 = false;
            for (int i17 = 0; i17 < 5; i17++) {
                String d16 = d(str, strArr[i17], i3);
                if (e(d16)) {
                    if (!z16 && i17 <= i16) {
                        z16 = true;
                        str3 = d16;
                    } else if (z16) {
                        File file = new File(d16);
                        n.a("QAdVideoCache", "file deleted: " + file.getName());
                        file.delete();
                    }
                }
            }
            return str3;
        }
        String d17 = d(str, str2, i3);
        if (!e(d17)) {
            return null;
        }
        return d17;
    }

    public static ArrayList<File> c(String str) {
        if (str == null) {
            return null;
        }
        File file = new File(str);
        ArrayList<File> arrayList = new ArrayList<>();
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null) {
                        String name = file2.getName();
                        if (name.endsWith(".mp4") && !name.endsWith(".ol.mp4")) {
                            arrayList.add(file2);
                        }
                    }
                }
            }
            if (!y.h(arrayList)) {
                f(arrayList);
            }
        }
        return arrayList;
    }

    public static String d(String str, String str2, int i3) {
        a a16 = QAdVideoCacheGenerate.a(i3);
        String b16 = a16.b();
        String a17 = a16.a();
        if (a17 == null) {
            return null;
        }
        return a17 + str + "_" + str2 + b16;
    }

    public static boolean e(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        if (file.length() <= 0) {
            n.a("QAdVideoCache", "file is empty: " + str);
            return false;
        }
        file.setLastModified(System.currentTimeMillis());
        n.a("QAdVideoCache", "file cached: " + str);
        return true;
    }

    private static void f(ArrayList<File> arrayList) {
        if (arrayList != null && arrayList.size() >= 2) {
            int size = arrayList.size();
            long[] jArr = new long[size];
            Iterator<File> it = arrayList.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                jArr[i3] = it.next().lastModified();
                i3++;
            }
            ArrayList arrayList2 = new ArrayList(size);
            boolean[] zArr = new boolean[size];
            while (arrayList2.size() < size) {
                int i16 = 0;
                for (int i17 = 0; i17 < size && zArr[i17]; i17++) {
                    i16++;
                }
                long j3 = jArr[i16];
                for (int i18 = i16 + 1; i18 < size; i18++) {
                    if (!zArr[i18]) {
                        long j16 = jArr[i18];
                        if (j16 < j3) {
                            i16 = i18;
                            j3 = j16;
                        }
                    }
                }
                zArr[i16] = true;
                arrayList2.add(arrayList.get(i16));
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
    }
}
