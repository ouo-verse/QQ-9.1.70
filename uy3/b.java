package uy3;

import android.os.Build;
import android.os.Environment;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {
    /* JADX WARN: Removed duplicated region for block: B:55:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(ClassLoader classLoader) {
        int i3;
        boolean z16;
        Object obj;
        Object[] objArr;
        File file;
        Field declaredField;
        int i16 = 0;
        if (Build.VERSION.SDK_INT >= 24) {
            return 0;
        }
        try {
            Field declaredField2 = DexClassLoader.class.getSuperclass().getDeclaredField("pathList");
            z16 = true;
            declaredField2.setAccessible(true);
            obj = declaredField2.get(classLoader);
            Field declaredField3 = obj.getClass().getDeclaredField("dexElements");
            declaredField3.setAccessible(true);
            objArr = (Object[]) declaredField3.get(obj);
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(Environment.getExternalStorageDirectory().getPath());
                sb5.append("/tencent/MobileQQ/");
                String str = MobileQQ.PACKAGE_NAME;
                String str2 = File.separator;
                sb5.append(str.replace(".", str2));
                sb5.append(str2);
                String sb6 = sb5.toString();
                String str3 = sb6 + "myZip.zip";
                b(str3, sb6 + "info.txt");
                file = new File(str3);
            } catch (Exception e16) {
                e16.printStackTrace();
                file = null;
            }
        } catch (Exception e17) {
            e = e17;
            e.printStackTrace();
            i3 = i16;
            if (QLog.isColorLevel()) {
            }
            return i3;
        }
        if (file != null) {
            try {
            } catch (Exception e18) {
                e = e18;
                i16 = 0;
            }
            if (file.exists()) {
                i3 = 0;
                for (Object obj2 : objArr) {
                    try {
                        Field declaredField4 = obj2.getClass().getDeclaredField("zipFile");
                        declaredField4.setAccessible(true);
                        ZipFile zipFile = (ZipFile) declaredField4.get(obj2);
                        if (zipFile != null) {
                            if (zipFile instanceof c) {
                                if (!((c) zipFile).a()) {
                                }
                                i3++;
                            } else {
                                String name = zipFile.getName();
                                if (name.contains("com.tencent.mobileqq") && name.contains("base.apk")) {
                                    try {
                                        declaredField = obj2.getClass().getDeclaredField("zip");
                                    } catch (NoSuchFieldException unused) {
                                        declaredField = obj2.getClass().getDeclaredField("file");
                                    }
                                    declaredField.setAccessible(true);
                                    File file2 = (File) declaredField.get(obj2);
                                    if (file2 != null) {
                                        c cVar = new c(file, file2, zipFile);
                                        declaredField4.set(obj2, cVar);
                                        cVar.a();
                                        i3++;
                                    }
                                }
                            }
                        }
                    } catch (Exception e19) {
                        e = e19;
                        i16 = i3;
                        e.printStackTrace();
                        i3 = i16;
                        if (QLog.isColorLevel()) {
                        }
                        return i3;
                    }
                }
                if (Build.VERSION.SDK_INT == 23) {
                    Field declaredField5 = obj.getClass().getDeclaredField("nativeLibraryPathElements");
                    declaredField5.setAccessible(true);
                    Object[] objArr2 = (Object[]) declaredField5.get(obj);
                    int length = objArr2.length;
                    int i17 = 0;
                    while (i17 < length) {
                        Object obj3 = objArr2[i17];
                        Field declaredField6 = obj3.getClass().getDeclaredField("zipFile");
                        declaredField6.setAccessible(z16);
                        ZipFile zipFile2 = (ZipFile) declaredField6.get(obj3);
                        if (zipFile2 != null && !(zipFile2 instanceof c)) {
                            String name2 = zipFile2.getName();
                            if (name2.contains("com.tencent.mobileqq") && name2.contains("base.apk")) {
                                Field declaredField7 = obj3.getClass().getDeclaredField("zip");
                                declaredField7.setAccessible(z16);
                                File file3 = (File) declaredField7.get(obj3);
                                if (file3 != null) {
                                    c cVar2 = new c(file, file3, zipFile2);
                                    declaredField6.set(obj3, cVar2);
                                    cVar2.d();
                                }
                            }
                        }
                        i17++;
                        z16 = true;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DexPathListHook", 2, "ClearDexPathListZipFile clearCount " + i3);
                }
                return i3;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("DexPathListHook", 2, "ClearDexPathListZipFile zipFile generate false");
            return 0;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0098, code lost:
    
        if (r4 != null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        Exception e16;
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            if (QLog.isColorLevel()) {
                QLog.d("DexPathListHook", 2, "generateZipFile myZipFile is exists");
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        File file2 = new File(str2);
        if (file2.exists() && file2.isFile() && file2.length() > 0) {
            arrayList.add(file2.getAbsolutePath());
            c(arrayList, str);
            return;
        }
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        arrayList.add(file2.getAbsolutePath());
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            file2.createNewFile();
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        } catch (Exception e17) {
            bufferedOutputStream = null;
            e16 = e17;
        } catch (Throwable th5) {
            th = th5;
            if (bufferedOutputStream2 != null) {
            }
            throw th;
        }
        try {
            try {
                bufferedOutputStream.write("generate zipFile one.".getBytes());
                bufferedOutputStream.flush();
            } catch (Throwable th6) {
                th = th6;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e18) {
            e16 = e18;
            if (QLog.isColorLevel()) {
                QLog.d("DexPathListHook", 2, "", e16);
            }
        }
        try {
            bufferedOutputStream.close();
        } catch (Exception unused2) {
            c(arrayList, str);
        }
    }

    public static void c(List<String> list, String str) {
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        ZipOutputStream zipOutputStream = null;
        FileInputStream fileInputStream2 = null;
        zipOutputStream = null;
        zipOutputStream = null;
        zipOutputStream = null;
        zipOutputStream = null;
        zipOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(str));
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    try {
                        ZipOutputStream zipOutputStream2 = new ZipOutputStream(bufferedOutputStream);
                        try {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                File file = new File(it.next());
                                if (file.exists()) {
                                    zipOutputStream2.putNextEntry(new ZipEntry(file.getName()));
                                    zipOutputStream2.setLevel(9);
                                    try {
                                        fileInputStream = new FileInputStream(file);
                                    } catch (Throwable th5) {
                                        th = th5;
                                    }
                                    try {
                                        byte[] bArr = new byte[20480];
                                        while (true) {
                                            int read = fileInputStream.read(bArr, 0, 20480);
                                            if (read == -1) {
                                                break;
                                            } else {
                                                zipOutputStream2.write(bArr, 0, read);
                                            }
                                        }
                                        fileInputStream.close();
                                        zipOutputStream2.flush();
                                        zipOutputStream2.closeEntry();
                                    } catch (Throwable th6) {
                                        th = th6;
                                        fileInputStream2 = fileInputStream;
                                        if (fileInputStream2 != null) {
                                            fileInputStream2.close();
                                        }
                                        zipOutputStream2.flush();
                                        zipOutputStream2.closeEntry();
                                        throw th;
                                    }
                                }
                            }
                            try {
                                zipOutputStream2.close();
                            } catch (IOException e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e16);
                                }
                            }
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e17);
                                }
                            }
                            try {
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                e = e18;
                                if (!QLog.isColorLevel()) {
                                    return;
                                }
                                QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e);
                            }
                        } catch (Exception e19) {
                            e = e19;
                            zipOutputStream = zipOutputStream2;
                            if (QLog.isColorLevel()) {
                                QLog.e("DexPathListHook", 2, "magnifier zipFiles exception: ", e);
                            }
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e26) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e26);
                                    }
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e27) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e27);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e28) {
                                    e = e28;
                                    if (!QLog.isColorLevel()) {
                                        return;
                                    }
                                    QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e);
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            zipOutputStream = zipOutputStream2;
                            if (zipOutputStream != null) {
                                try {
                                    zipOutputStream.close();
                                } catch (IOException e29) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e29);
                                    }
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e36) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e36);
                                    }
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e37) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e("DexPathListHook", 2, "zipFiles close exception: ", e37);
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                } catch (Exception e38) {
                    e = e38;
                }
            } catch (Exception e39) {
                e = e39;
                bufferedOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                bufferedOutputStream = null;
            }
        } catch (Exception e46) {
            e = e46;
            bufferedOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th = th10;
            bufferedOutputStream = null;
            fileOutputStream = null;
        }
    }
}
