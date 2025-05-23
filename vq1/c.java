package vq1;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {
    public static String a(long j3, String str) {
        if (b(j3)) {
            return "msf_timeout_" + str;
        }
        return str;
    }

    public static boolean b(long j3) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (currentTimeMillis >= 15000 && currentTimeMillis < 30000) {
            return true;
        }
        return false;
    }
}
