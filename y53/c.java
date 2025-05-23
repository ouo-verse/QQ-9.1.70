package y53;

import java.util.ArrayList;
import java.util.List;
import org.light.device.LightDeviceUtils;
import org.light.device.OfflineConfig;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static List<String> f449480a;

    static {
        ArrayList arrayList = new ArrayList();
        f449480a = arrayList;
        arrayList.add("pbem00");
    }

    public static int a() {
        return OfflineConfig.getPhonePerfLevel(com.tencent.mobileqq.wink.b.c());
    }

    public static <T> T b(T t16, T t17, T t18) {
        long totalRamMemory = LightDeviceUtils.getTotalRamMemory(com.tencent.mobileqq.wink.b.c());
        if (totalRamMemory <= 2147483648L) {
            return t16;
        }
        if (totalRamMemory <= 4294967296L) {
            return t17;
        }
        return t18;
    }
}
