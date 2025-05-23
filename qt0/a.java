package qt0;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    private static String a(String str, long j3) {
        return str + j3;
    }

    public static MMKVOptionEntity b() {
        return QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
    }

    public static int c(String str, int i3) {
        return b().decodeInt(str, i3);
    }

    public static long d(String str, long j3) {
        String a16 = a(str, j3);
        MMKVOptionEntity b16 = b();
        if (!b16.containsKey(a16)) {
            return 0L;
        }
        return b16.decodeLong(a16, 0L);
    }

    public static void e(String str, int i3) {
        b().encodeInt(str, i3);
    }

    public static void f(String str, long j3, long j16) {
        b().encodeLong(a(str, j3), j16).commitAsync();
    }
}
