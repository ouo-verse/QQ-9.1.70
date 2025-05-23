package pu;

import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class e {
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        if (QLog.isColorLevel()) {
            QLog.d("MediaCodecFileUitils", 2, "loadMediaCodecConfigFromFile. dir = " + str + ", filename = " + str2);
        }
        String str3 = null;
        if (str != null && !str.equals("") && str2 != null && !str2.equals("")) {
            File file = new File(str, str2);
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = null;
                    bufferedInputStream = null;
                }
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    bufferedInputStream.read(bArr);
                    String str4 = new String(bArr, "UTF-8");
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e16) {
                        e16.printStackTrace();
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                    str3 = str4;
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        file.delete();
                        if (QLog.isColorLevel()) {
                            QLog.e("MediaCodecFileUitils", 2, "ReadFileException:" + th);
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (QLog.isColorLevel()) {
                        }
                        return str3;
                    } finally {
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MediaCodecFileUitils", 2, "loadConfigFromFile= " + str3);
                }
            }
        }
        return str3;
    }
}
