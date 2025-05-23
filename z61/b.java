package z61;

import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    public static String a(long j3) {
        Date date = new Date(j3);
        return String.format("%02d:%02d", Integer.valueOf(date.getHours()), Integer.valueOf(date.getMinutes()));
    }

    public static String b(long j3, boolean z16, boolean z17, boolean z18) {
        String str;
        String str2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        StringBuilder sb5 = new StringBuilder();
        String str3 = "";
        if (!z16) {
            str = "";
        } else {
            str = calendar.get(1) + "-";
        }
        sb5.append(str);
        if (!z17) {
            str2 = "";
        } else {
            str2 = String.format("%02d-", Integer.valueOf(calendar.get(2) + 1));
        }
        sb5.append(str2);
        if (z18) {
            str3 = String.format("%02d", Integer.valueOf(calendar.get(5)));
        }
        sb5.append(str3);
        return sb5.toString();
    }

    public static String c(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        String a16 = a(j3);
        return b(j3, !f(j3, currentTimeMillis), true, true) + " " + a16;
    }

    public static String d(int i3) {
        switch (i3) {
            case 1:
                return "\u661f\u671f\u65e5";
            case 2:
                return "\u661f\u671f\u4e00";
            case 3:
                return "\u661f\u671f\u4e8c";
            case 4:
                return "\u661f\u671f\u4e09";
            case 5:
                return "\u661f\u671f\u56db";
            case 6:
                return "\u661f\u671f\u4e94";
            case 7:
                return "\u661f\u671f\u516d";
            default:
                return "";
        }
    }

    public static boolean e(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        if (calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5)) {
            return true;
        }
        return false;
    }

    public static boolean f(long j3, long j16) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(j16);
        if (calendar.get(1) == calendar2.get(1)) {
            return true;
        }
        return false;
    }
}
