package xc4;

import android.util.Log;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J \u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0013"}, d2 = {"Lxc4/a;", "", "", "fromPath", "toPath", "", "b", "path", "Ljava/io/File;", "c", "src", "dst", "logEnabled", "a", "dirStr", "", "d", "<init>", "()V", "square_debugger_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f447783a = new a();

    a() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean a(File src, File dst, boolean logEnabled) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(dst, "dst");
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (dst.exists()) {
                    dst.delete();
                }
                if (dst.getParentFile() != null && !dst.getParentFile().exists()) {
                    dst.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream2 = new FileOutputStream((File) dst);
                try {
                    dst = new BufferedInputStream(new FileInputStream(src));
                    try {
                        try {
                            bArr = new byte[RFixConstants.MD5_FILE_BUF_LENGTH];
                        } catch (IOException e16) {
                            e = e16;
                            fileOutputStream = fileOutputStream2;
                            bufferedInputStream2 = dst;
                            if (logEnabled) {
                                Log.e("FileUtil", "copyFile error, ", e);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e17) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e17);
                                    }
                                }
                            }
                            if (bufferedInputStream2 == null) {
                                return false;
                            }
                            try {
                                bufferedInputStream2.close();
                                return false;
                            } catch (IOException e18) {
                                e = e18;
                                if (!logEnabled) {
                                    return false;
                                }
                                Log.e("FileUtil", "copyFile error, ", e);
                                return false;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e19) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e19);
                                    }
                                }
                            }
                            if (dst != 0) {
                                try {
                                    dst.close();
                                } catch (IOException e26) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e26);
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (OutOfMemoryError unused) {
                        try {
                            bArr = new byte[4096];
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            fileOutputStream = fileOutputStream2;
                            bufferedInputStream = dst;
                            if (logEnabled) {
                                Log.e("FileUtil", "copyFile error, ", e);
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e28) {
                                    if (logEnabled) {
                                        Log.e("FileUtil", "copyFile error, ", e28);
                                    }
                                }
                            }
                            if (bufferedInputStream == null) {
                                return false;
                            }
                            try {
                                bufferedInputStream.close();
                                return false;
                            } catch (IOException e29) {
                                e = e29;
                                if (!logEnabled) {
                                    return false;
                                }
                                Log.e("FileUtil", "copyFile error, ", e);
                                return false;
                            }
                        }
                    }
                    while (true) {
                        int read = dst.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                            fileOutputStream2.flush();
                        } else {
                            try {
                                break;
                            } catch (IOException e36) {
                                if (logEnabled) {
                                    Log.e("FileUtil", "copyFile error, ", e36);
                                }
                            }
                        }
                    }
                    fileOutputStream2.close();
                    try {
                        dst.close();
                    } catch (IOException e37) {
                        if (logEnabled) {
                            Log.e("FileUtil", "copyFile error, ", e37);
                        }
                    }
                    return true;
                } catch (IOException e38) {
                    e = e38;
                    dst = 0;
                } catch (OutOfMemoryError e39) {
                    e = e39;
                    dst = 0;
                } catch (Throwable th6) {
                    th = th6;
                    dst = 0;
                }
            } catch (IOException e46) {
                e = e46;
                bufferedInputStream2 = null;
            } catch (OutOfMemoryError e47) {
                e = e47;
                bufferedInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                dst = 0;
            }
        } catch (Throwable th8) {
            th = th8;
        }
    }

    public final boolean b(String fromPath, String toPath) {
        File file = new File(fromPath);
        if (file.exists()) {
            try {
                return a(file, c(toPath), true);
            } catch (IOException unused) {
                Log.d("FileUtil", "copy fail error ");
            }
        }
        return false;
    }

    public final File c(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                if (file.getParentFile().mkdirs()) {
                    file.createNewFile();
                }
            } else {
                file.createNewFile();
            }
        }
        return file;
    }

    public final void d(String dirStr) {
        if (dirStr != null) {
            int length = dirStr.length() - 1;
            int i3 = 0;
            boolean z16 = false;
            while (i3 <= length) {
                boolean z17 = Intrinsics.compare((int) dirStr.charAt(!z16 ? i3 : length), 32) <= 0;
                if (z16) {
                    if (!z17) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z17) {
                    i3++;
                } else {
                    z16 = true;
                }
            }
            if (dirStr.subSequence(i3, length + 1).toString().length() == 0) {
                return;
            }
            File file = new File(dirStr);
            if (file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    if (true ^ (listFiles.length == 0)) {
                        int length2 = listFiles.length;
                        for (int i16 = 0; i16 < length2; i16++) {
                            File file2 = listFiles[i16];
                            Intrinsics.checkNotNullExpressionValue(file2, "childDirList[i]");
                            if (file2.isDirectory()) {
                                File file3 = listFiles[i16];
                                Intrinsics.checkNotNullExpressionValue(file3, "childDirList[i]");
                                d(file3.getAbsolutePath());
                            } else {
                                listFiles[i16].delete();
                            }
                        }
                    }
                }
                file.delete();
            }
        }
    }
}
