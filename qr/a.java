package qr;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static String f429320b;

    /* renamed from: p, reason: collision with root package name */
    private static String f429334p;

    /* renamed from: q, reason: collision with root package name */
    private static String f429335q;

    /* renamed from: r, reason: collision with root package name */
    private static String f429336r;

    /* renamed from: s, reason: collision with root package name */
    private static String f429337s;

    /* renamed from: t, reason: collision with root package name */
    private static String f429338t;

    /* renamed from: a, reason: collision with root package name */
    public static Context f429319a = VideoEnvironment.getContext();

    /* renamed from: c, reason: collision with root package name */
    public static long f429321c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f429322d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static int f429323e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static int f429324f = 640;

    /* renamed from: g, reason: collision with root package name */
    public static int f429325g = 480;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f429326h = {960, 640};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f429327i = {720, 480};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f429328j = {720, 540, 640, 480, 480, 360, 320, 240};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f429329k = {1, 1, 0};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f429330l = {1, 0, 0};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f429331m = {1, 1, 0};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f429332n = {1280, 800};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f429333o = {720, 480};

    public static boolean a() {
        boolean hasSDCardAndWritable = FileUtils.hasSDCardAndWritable();
        if (!hasSDCardAndWritable) {
            if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
            }
            return hasSDCardAndWritable;
        }
        String str = rr.a.b().f431975c;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "sdcardDirPath = empty");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "sdcardDirPath:storeVideoPath=" + str);
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory() && file.canWrite()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str2 = File.separator;
            sb5.append(str2);
            sb5.append("trimvideo");
            f429320b = sb5.toString();
            File file2 = new File(f429320b);
            boolean mkdirs = file2.mkdirs();
            boolean isDirectory = file2.isDirectory();
            if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + mkdirs + " isdir=" + isDirectory);
            }
            if (!mkdirs && !isDirectory) {
                return false;
            }
            f429337s = str + "/Product";
            f429336r = str + "/Material";
            f429338t = f429336r + "/ProcessedMaterial";
            f429334p = str + "/log.txt";
            f429335q = str + str2 + "Source";
            File file3 = new File(f429335q);
            boolean mkdirs2 = file3.mkdirs();
            boolean isDirectory2 = file3.isDirectory();
            if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + mkdirs2 + " isdir=" + isDirectory2);
            }
            return mkdirs2 || isDirectory2;
        }
        if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
        }
        return false;
    }
}
