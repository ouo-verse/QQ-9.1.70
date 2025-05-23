package sy3;

import android.app.ActivityManager;
import android.os.Debug;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static long f434973a;

    /* renamed from: b, reason: collision with root package name */
    private static b f434974b;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f434975a;

        /* renamed from: b, reason: collision with root package name */
        public long f434976b;
    }

    public static long a() {
        long j3 = f434973a;
        if (j3 > 0) {
            return j3;
        }
        long c16 = m.c();
        long X = ah.X();
        long j16 = ((3 * c16) + (7 * X)) / 10;
        long E = ah.E();
        if (j16 <= 157286400) {
            f434973a = Math.min(25165824L, E);
        } else if (j16 <= 262144000) {
            f434973a = Math.min(37748736L, E);
        } else if (j16 <= 419430400) {
            f434973a = Math.min(67108864L, E);
        } else if (j16 <= QZoneHelper.Constants.SUPPORT_MIX_MUSIC_DEFAULT) {
            f434973a = Math.min(134217728L, E);
        } else {
            f434973a = Math.min(VasBusiness.QWALLET, E);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.Memory.MemoryManager", 2, "getAvailClassSize, availClassSize=" + (f434973a / 1048576) + "M, totalMemSize=" + (c16 / 1048576) + "M, remainMemSize=" + (X / 1048576) + "M, availMemSize=" + (j16 / 1048576) + "M, classMemSize=" + (E / 1048576) + "M");
        }
        return f434973a;
    }

    public static b c() {
        if (f434974b == null) {
            synchronized ("Q.Memory.MemoryManager") {
                if (f434974b == null) {
                    f434974b = new b();
                }
            }
        }
        return f434974b;
    }

    public static long d(int i3) {
        try {
            Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{i3});
            if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                return processMemoryInfo[0].getTotalPss() * 1024;
            }
            return 62914560L;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.Memory.MemoryManager", 2, "getMemory ex pid=" + i3, e16);
                return 62914560L;
            }
            return 62914560L;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.Memory.MemoryManager", 2, "getMemory OutOfMemoryError pid=", Integer.valueOf(i3), e17);
                return 62914560L;
            }
            return 62914560L;
        }
    }

    public float b() {
        return (((float) Runtime.getRuntime().totalMemory()) * 1.0f) / ((float) Runtime.getRuntime().maxMemory());
    }
}
