package rl2;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\n\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lrl2/e;", "", "", "path", "", "c", "", "d", "", "a", "b", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class e {
    private final long c(String path) {
        boolean z16;
        File file = new File(path);
        if (file.isFile()) {
            return file.length();
        }
        Stack stack = new Stack();
        stack.push(path);
        long j3 = 0;
        while (!stack.isEmpty()) {
            File file2 = new File((String) stack.pop());
            j3 += file2.length();
            String[] list = file2.list();
            if (list != null) {
                if (list.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    for (String str : list) {
                        File file3 = new File(file2, str);
                        if (file3.isDirectory()) {
                            stack.push(file3.getAbsolutePath());
                        } else {
                            j3 += file3.length();
                        }
                    }
                }
            }
        }
        return j3;
    }

    public void a() {
        Iterator<T> it = d().iterator();
        while (it.hasNext()) {
            try {
                d.f431658a.b(new File((String) it.next()));
            } catch (Exception e16) {
                QLog.e("StorageManagement", 1, "clearPreloadFile error", e16);
            }
        }
    }

    public final long b() {
        long j3 = 0;
        for (String str : d()) {
            try {
                if (!new File(str).exists()) {
                    QLog.i("StorageManagement", 2, str + " not exist");
                } else {
                    long c16 = c(str);
                    QLog.i("StorageManagement", 1, str + " cacheSize=" + c16);
                    Unit unit = Unit.INSTANCE;
                    j3 += c16;
                }
            } catch (Exception e16) {
                QLog.e("StorageManagement", 1, "getCacheSize error", e16);
            }
        }
        return j3;
    }

    @NotNull
    public abstract List<String> d();
}
