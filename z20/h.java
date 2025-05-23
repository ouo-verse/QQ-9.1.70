package z20;

import com.tencent.qphone.base.util.QLog;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h {
    private static boolean a() {
        return o.p1();
    }

    public static boolean b() {
        try {
            return a();
        } catch (Throwable th5) {
            QLog.e("QFSLoadMoreOptimizeExp9120", 1, "[isHitExp] ex: ", th5);
            return false;
        }
    }

    public static boolean c() {
        try {
            return a();
        } catch (Throwable th5) {
            QLog.e("QFSLoadMoreOptimizeExp9120", 1, "[isStorageHitExp] ex: ", th5);
            return false;
        }
    }
}
