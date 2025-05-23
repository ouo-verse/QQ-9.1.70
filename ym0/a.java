package ym0;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    private static MMKVOptionEntity a() {
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
    }

    public static int b(String str, String str2, int i3) {
        return a().decodeInt("Gdt_" + str + str2, i3);
    }

    public static long c(String str, String str2, long j3) {
        return a().decodeLong("Gdt_" + str + str2, j3);
    }

    public static String d(String str, String str2, String str3) {
        return a().decodeString("Gdt_" + str + str2, str3);
    }

    public static Set<String> e(String str, String str2, Set<String> set) {
        return a().decodeStringSet("Gdt_" + str + str2, set);
    }

    public static void f(String str, String str2, int i3) {
        a().encodeInt("Gdt_" + str + str2, i3);
    }

    public static void g(String str, String str2, long j3) {
        a().encodeLong("Gdt_" + str + str2, j3);
    }

    public static void h(String str, String str2, String str3) {
        a().encodeString("Gdt_" + str + str2, str3);
    }

    public static void i(String str, String str2, Set<String> set) {
        a().encodeStringSet("Gdt_" + str + str2, set);
    }

    public static void j(String str, String str2) {
        a().removeKey("Gdt_" + str + str2);
    }
}
