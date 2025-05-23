package uq3;

import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes22.dex */
public class n {
    public static String a(long j3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j3));
    }

    public static boolean b(long j3, long j16, int i3) {
        if (Math.abs(j3 - j16) / 86400000 < i3) {
            return false;
        }
        return true;
    }

    public static boolean c(long j3, long j16) {
        Date date = new Date(j3);
        Date date2 = new Date(j16);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(date2));
    }

    private static boolean d(long j3, String str) {
        Date date = new Date(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.SIMPLIFIED_CHINESE);
        return simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date(System.currentTimeMillis())));
    }

    public static boolean e(long j3) {
        return d(j3, "MM-dd");
    }
}
