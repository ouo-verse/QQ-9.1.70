package ty1;

import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.cg;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {
    public static SpannableString a(Context context, String str, int i3) {
        SpannableString spannableString = new SpannableString(str);
        Pattern compile = Pattern.compile(cg.f307524c.pattern() + "|" + cg.f307525d.pattern(), 2);
        if (!cg.f307523b.matcher(str).find()) {
            return spannableString;
        }
        Matcher matcher = compile.matcher(str);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String substring = str.substring(start, end);
            if (cg.f307524c.matcher(substring).find()) {
                spannableString.setSpan(new b(context, substring, i3), start, end, 33);
            } else if (cg.f307525d.matcher(substring).find()) {
                spannableString.setSpan(new b(context, substring, i3), start, end, 33);
            }
        }
        return spannableString;
    }

    public static String b(long j3, long j16, long j17) {
        if (j16 - System.currentTimeMillis() < 0) {
            return QQGuildUIUtil.r(R.string.f155261h1);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        int i3 = calendar.get(6);
        int i16 = calendar.get(1);
        int i17 = calendar.get(11);
        int i18 = calendar.get(12);
        Locale locale = Locale.US;
        String format = String.format(locale, "%02d:%02d", Integer.valueOf(i17), Integer.valueOf(i18));
        calendar.setTimeInMillis(j16);
        int i19 = calendar.get(6);
        int i26 = calendar.get(1);
        String format2 = String.format(locale, "%02d:%02d", Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)));
        calendar.setTimeInMillis(j17);
        int i27 = calendar.get(6);
        if (i3 == i19 && i16 == i26) {
            return QQGuildUIUtil.s(R.string.f155321h7, format, format2);
        }
        if (i27 == i3) {
            return QQGuildUIUtil.s(R.string.f155311h6, format);
        }
        if (i27 == i19) {
            return QQGuildUIUtil.s(R.string.f155301h5, format2);
        }
        return QQGuildUIUtil.r(R.string.f155291h4);
    }

    public static String c(long j3) {
        LocalDate now;
        if (j3 <= ny1.c.J) {
            j3 *= 1000;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (Build.VERSION.SDK_INT >= 26) {
            now = LocalDate.now();
            now.atTime(0, 0, 0);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(serverTimeMillis);
        int i3 = calendar.get(1);
        int i16 = calendar.get(2);
        int i17 = calendar.get(5);
        int i18 = calendar2.get(1);
        int i19 = calendar2.get(2);
        int i26 = calendar2.get(5);
        if (i3 == i18 && i16 == i19 && i17 == i26) {
            return "\u4eca\u5929";
        }
        if (calendar.get(1) == calendar2.get(1)) {
            return new SimpleDateFormat("M\u6708d\u65e5").format(calendar.getTime()) + " " + ny1.c.y0(calendar);
        }
        return new SimpleDateFormat("yyyy\u5e74M\u6708d\u65e5").format(calendar.getTime()) + " " + ny1.c.y0(calendar);
    }
}
