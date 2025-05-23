package yq2;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public static String f450985b;

    /* renamed from: p, reason: collision with root package name */
    private static String f450999p;

    /* renamed from: q, reason: collision with root package name */
    private static String f451000q;

    /* renamed from: r, reason: collision with root package name */
    private static String f451001r;

    /* renamed from: s, reason: collision with root package name */
    private static String f451002s;

    /* renamed from: t, reason: collision with root package name */
    private static String f451003t;

    /* renamed from: a, reason: collision with root package name */
    public static Context f450984a = VideoEnvironment.getContext();

    /* renamed from: c, reason: collision with root package name */
    public static long f450986c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f450987d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static int f450988e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static int f450989f = 640;

    /* renamed from: g, reason: collision with root package name */
    public static int f450990g = 480;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f450991h = {960, 640};

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f450992i = {720, 480};

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f450993j = {720, 540, 640, 480, 480, 360, 320, 240};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f450994k = {1, 1, 0};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f450995l = {1, 0, 0};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f450996m = {1, 1, 0};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f450997n = {1280, 800};

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f450998o = {720, 480};

    public static void a() {
        try {
            AudioManager audioManager = (AudioManager) VideoEnvironment.getContext().getSystemService("audio");
            int requestAudioFocus = audioManager.requestAudioFocus(null, 3, 2);
            if (requestAudioFocus == 0) {
                requestAudioFocus = audioManager.requestAudioFocus(null, 3, 1);
            }
            if (requestAudioFocus == 0) {
                audioManager.requestAudioFocus(null, 3, 3);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static String b() {
        return f451000q;
    }

    public static boolean c(long j3, Context context, int i3, int i16) {
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.e("GloableValue", 2, "GloableValue[init]context=" + context);
            }
            return false;
        }
        long j16 = f450986c;
        if (j16 > 0 && (j3 <= 0 || j16 == j3)) {
            if (QLog.isColorLevel()) {
                QLog.e("GloableValue", 2, "GloableValue[init]sUin=" + f450986c + "uin=" + j3);
            }
            return true;
        }
        f450986c = j3;
        if (d(j3, context)) {
            if (e(j3 + "", context, i3, i16)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(long j3, Context context) {
        if (j3 <= 0) {
            return false;
        }
        String str = er2.a.c().f397063c;
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
            f450985b = sb5.toString();
            File file2 = new File(f450985b);
            boolean mkdirs = file2.mkdirs();
            boolean isDirectory = file2.isDirectory();
            if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + mkdirs + " isdir=" + isDirectory);
            }
            if (!mkdirs && !isDirectory) {
                return false;
            }
            f451002s = str + "/Product";
            f451001r = str + "/Material";
            f451003t = f451001r + "/ProcessedMaterial";
            f450999p = str + "/log.txt";
            f451000q = str + str2 + "Source";
            File file3 = new File(f451000q);
            boolean mkdirs2 = file3.mkdirs();
            boolean isDirectory2 = file3.isDirectory();
            if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + mkdirs2 + " isdir=" + isDirectory2);
            }
            if (!mkdirs2 && !isDirectory2) {
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00ff, code lost:
    
        if (r2 == null) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00f5, code lost:
    
        if (r2 == null) goto L110;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(String str, Context context, int i3, int i16) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Throwable th5;
        FileOutputStream fileOutputStream2;
        Throwable th6;
        InputStream inputStream2;
        byte[] bArr;
        byte[] bArr2;
        String str2 = er2.a.c().f397063c;
        MessageStruct messageStruct = new MessageStruct(6);
        messageStruct.mObj0 = "{\"uin\":\"" + str + "\",\"maxVideoMainPath\":\"" + str2 + "\",\"logFilePath\":\"" + f450999p + "\",\"avSourceFilesDirPath\":\"" + f451000q + "\",\"avProductFilesDirPath\":\"" + f451002s + "\",\"materialFilesDirPath\":\"" + f451001r + "\",\"processedMaterialDirPath\":\"" + f451003t + "\",\"maxDuration\":" + CodecParam.RECORD_MAX_TIME + ",\"defaultFPS\":" + CodecParam.VIDEO_FPS + ",\"videoWidth\":" + i3 + ",\"videoHeight\":" + i16 + ",\"avBatchVersion\":0,\"isUseOpenGLDraw\":true}";
        InputStream inputStream3 = null;
        GlobalInit.nativeSyncProcessMsg(messageStruct, null, null);
        try {
            inputStream = context.getResources().openRawResource(R.raw.f169437a4);
        } catch (FileNotFoundException unused) {
            inputStream = null;
            fileOutputStream = null;
        } catch (IOException unused2) {
            inputStream = null;
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
            fileOutputStream = null;
        }
        try {
            bArr2 = new byte[inputStream.available()];
            inputStream.read(bArr2);
            fileOutputStream = new FileOutputStream(new File(str2 + "/videoplayer_vp.vp"));
        } catch (FileNotFoundException unused3) {
            fileOutputStream = null;
        } catch (IOException unused4) {
            fileOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            fileOutputStream = null;
            th5 = th;
            if (inputStream != null) {
            }
            if (fileOutputStream == null) {
            }
        }
        try {
            fileOutputStream.write(bArr2);
            try {
                inputStream.close();
            } catch (IOException unused5) {
            }
        } catch (FileNotFoundException unused6) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused7) {
                }
            }
        } catch (IOException unused8) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused9) {
                }
            }
        } catch (Throwable th9) {
            th5 = th9;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused10) {
                }
            }
            if (fileOutputStream == null) {
                try {
                    fileOutputStream.close();
                    throw th5;
                } catch (IOException unused11) {
                    throw th5;
                }
            }
            throw th5;
        }
        try {
            fileOutputStream.close();
        } catch (IOException unused12) {
            try {
                inputStream2 = context.getResources().openRawResource(R.raw.f169436a3);
                try {
                    bArr = new byte[inputStream2.available()];
                    inputStream2.read(bArr);
                    fileOutputStream2 = new FileOutputStream(new File(str2 + "/videoplayer_fp.fp"));
                } catch (FileNotFoundException unused13) {
                    fileOutputStream2 = null;
                } catch (IOException unused14) {
                    fileOutputStream2 = null;
                } catch (Throwable th10) {
                    fileOutputStream2 = null;
                    th6 = th10;
                }
            } catch (FileNotFoundException unused15) {
                fileOutputStream2 = null;
            } catch (IOException unused16) {
                fileOutputStream2 = null;
            } catch (Throwable th11) {
                fileOutputStream2 = null;
                th6 = th11;
                inputStream2 = null;
            }
            try {
                fileOutputStream2.write(bArr);
                try {
                    inputStream2.close();
                } catch (IOException unused17) {
                }
            } catch (FileNotFoundException unused18) {
                inputStream3 = inputStream2;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException unused19) {
                    }
                }
                if (fileOutputStream2 == null) {
                    return true;
                }
                fileOutputStream2.close();
            } catch (IOException unused20) {
                inputStream3 = inputStream2;
                if (inputStream3 != null) {
                    try {
                        inputStream3.close();
                    } catch (IOException unused21) {
                    }
                }
                if (fileOutputStream2 == null) {
                    return true;
                }
                fileOutputStream2.close();
            } catch (Throwable th12) {
                th6 = th12;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException unused22) {
                    }
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                        throw th6;
                    } catch (IOException unused23) {
                        throw th6;
                    }
                }
                throw th6;
            }
            try {
                fileOutputStream2.close();
            } catch (IOException unused24) {
                return true;
            }
        }
    }

    public static void f() {
        try {
            ((AudioManager) VideoEnvironment.getContext().getSystemService("audio")).abandonAudioFocus(null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void g() {
        GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
        f450986c = -1L;
    }
}
