package y13;

import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\"\u0010\u0010\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\b\u00a8\u0006\u0013"}, d2 = {"Ly13/c;", "", "Ljava/io/File;", "file", "", "", "", "CRCMap", "", "a", "dirPath", "", "c", "", "zipPath", "fileCheckForAndroidN", "b", "<init>", "()V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f449273a = new c();

    c() {
    }

    private final boolean a(File file, Map<Long, Integer> CRCMap) {
        Integer num;
        long a16 = b.f449272a.a(file);
        int i3 = 0;
        if (CRCMap.containsKey(Long.valueOf(a16)) && (num = CRCMap.get(Long.valueOf(a16))) != null) {
            i3 = num.intValue();
        }
        CRCMap.put(Long.valueOf(a16), Integer.valueOf(i3 - 1));
        return true;
    }

    private final void c(File dirPath, Map<Long, Integer> CRCMap) {
        File[] listFiles;
        if (!dirPath.exists()) {
            return;
        }
        if (dirPath.isFile()) {
            a(dirPath, CRCMap);
            return;
        }
        if (dirPath.isDirectory() && (listFiles = dirPath.listFiles()) != null) {
            for (File it : listFiles) {
                c cVar = f449273a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cVar.c(it, CRCMap);
            }
        }
    }

    public final boolean b(@Nullable String dirPath, @Nullable String zipPath, boolean fileCheckForAndroidN) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        Integer num;
        if (!fileCheckForAndroidN && Build.VERSION.SDK_INT <= 25) {
            return true;
        }
        if (dirPath != null && zipPath != null) {
            if (dirPath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (zipPath.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    ZipFile zipFile = null;
                    try {
                        try {
                            ZipFile zipFile2 = new ZipFile(zipPath);
                            try {
                                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                                while (entries.hasMoreElements()) {
                                    ZipEntry nextElement = entries.nextElement();
                                    if (nextElement.getCrc() != 0) {
                                        if (linkedHashMap.containsKey(Long.valueOf(nextElement.getCrc())) && (num = linkedHashMap.get(Long.valueOf(nextElement.getCrc()))) != null) {
                                            i3 = num.intValue();
                                        } else {
                                            i3 = 0;
                                        }
                                        linkedHashMap.put(Long.valueOf(nextElement.getCrc()), Integer.valueOf(i3 + 1));
                                    }
                                }
                                try {
                                    zipFile2.close();
                                } catch (Exception e16) {
                                    QLog.e("FileCheckUtil", 1, e16, new Object[0]);
                                }
                                if (linkedHashMap.isEmpty()) {
                                    QLog.e("FileCheckUtil", 1, dirPath + " file is null");
                                    return false;
                                }
                                c(new File(dirPath), linkedHashMap);
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                for (Map.Entry<Long, Integer> entry : linkedHashMap.entrySet()) {
                                    if (entry.getValue().intValue() > 0) {
                                        z18 = true;
                                    } else {
                                        z18 = false;
                                    }
                                    if (z18) {
                                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                                    }
                                }
                                return linkedHashMap2.isEmpty();
                            } catch (Exception e17) {
                                e = e17;
                                zipFile = zipFile2;
                                if (QLog.isColorLevel()) {
                                    QLog.e("FileCheckUtil", 1, e, new Object[0]);
                                }
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (Exception e18) {
                                        QLog.e("FileCheckUtil", 1, e18, new Object[0]);
                                    }
                                }
                                return true;
                            } catch (Throwable th5) {
                                th = th5;
                                zipFile = zipFile2;
                                if (zipFile != null) {
                                    try {
                                        zipFile.close();
                                    } catch (Exception e19) {
                                        QLog.e("FileCheckUtil", 1, e19, new Object[0]);
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e26) {
                            e = e26;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                }
            }
        }
        QLog.e("FileCheckUtil", 1, "filepath is null");
        return false;
    }
}
