package yn4;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, SimpleDateFormat> f450695a = new HashMap<>(5);

    /* renamed from: b, reason: collision with root package name */
    private static long f450696b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static long f450697c = 0;

    @Deprecated
    public static String a(long j3, String str) {
        SimpleDateFormat simpleDateFormat = f450695a.get(str);
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(str);
            f450695a.put(str, simpleDateFormat);
        }
        return simpleDateFormat.format(new Date(j3));
    }

    public static String b(long j3) {
        String a16;
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(currentTimeMillis);
        long rawOffset = (calendar.getTimeZone().getRawOffset() + j3) / 86400000;
        long rawOffset2 = (calendar2.getTimeZone().getRawOffset() + currentTimeMillis) / 86400000;
        if (rawOffset == rawOffset2) {
            long j16 = (currentTimeMillis - j3) / 60000;
            if (j16 <= 2) {
                return "\u521a\u521a";
            }
            if (j16 <= 60) {
                return j16 + "\u5206\u949f\u524d";
            }
            if (j16 < 120) {
                return "\u4e00\u5c0f\u65f6\u524d";
            }
            a16 = "";
        } else if (calendar.get(1) != calendar2.get(1)) {
            a16 = a(j3, "yyyy-MM-dd ");
        } else {
            long j17 = rawOffset2 - rawOffset;
            if (j17 == 1) {
                a16 = "\u6628\u5929 ";
            } else if (j17 <= 7) {
                a16 = c(calendar.get(7)) + " ";
            } else {
                a16 = a(j3, "MM-dd ");
            }
        }
        return a16 + a(j3, DateUtil.DATE_FORMAT_HOUR);
    }

    public static String c(int i3) {
        switch (i3) {
            case 1:
                return "\u661f\u671f\u5929";
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

    public static long d() {
        return NetConnInfoCenter.getServerTimeMillis();
    }

    public static String e(int i3) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i3 >= 86400) {
            stringBuffer.append(i3 / 86400);
            stringBuffer.append("\u5929");
            i3 %= 86400;
        }
        if (i3 >= 3600) {
            stringBuffer.append(i3 / 3600);
            stringBuffer.append("\u5c0f\u65f6");
            i3 %= 3600;
        }
        if (i3 >= 60) {
            stringBuffer.append(i3 / 60);
            stringBuffer.append("\u5206\u949f");
        }
        return stringBuffer.toString();
    }

    public static long f() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static boolean g(long j3, long j16) {
        long rawOffset = Calendar.getInstance().getTimeZone().getRawOffset();
        if (Math.floor((j3 + rawOffset) / 86400000) == Math.floor((j16 + rawOffset) / 86400000)) {
            return true;
        }
        return false;
    }
}
