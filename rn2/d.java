package rn2;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f431755a = "";

    /* renamed from: b, reason: collision with root package name */
    private static int f431756b;

    /* renamed from: c, reason: collision with root package name */
    private static Map<Integer, Integer> f431757c = new HashMap();

    public static synchronized void a() {
        synchronized (d.class) {
            f431755a = "";
            f431756b = 0;
            f431757c.clear();
        }
    }

    public static int b(int i3) {
        Integer num = f431757c.get(Integer.valueOf(i3));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static String c() {
        return f431755a;
    }

    public static synchronized void d(int i3) {
        synchronized (d.class) {
            switch (i3) {
                case 20:
                case 30:
                case 40:
                case 50:
                case 60:
                case 70:
                case 80:
                case 90:
                case 100:
                case 110:
                case 120:
                    f431756b++;
                    f431755a += i3 + "|";
                    f431757c.put(Integer.valueOf(i3), Integer.valueOf(f431756b));
                    break;
            }
        }
    }
}
