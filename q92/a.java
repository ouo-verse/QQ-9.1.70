package q92;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {
    public static CharSequence a(CharSequence charSequence, int i3, int i16) {
        int length = charSequence.length();
        int i17 = 0;
        int i18 = i3;
        while (i18 < length) {
            i17 += charSequence.charAt(i18) < '\u0080' ? 1 : 2;
            if (i17 > i16) {
                if (i18 > 0 && Character.isHighSurrogate(charSequence.charAt(i18 - 1))) {
                    i18--;
                }
                return charSequence.subSequence(i3, i18);
            }
            i18++;
        }
        return charSequence;
    }

    public static String d(long j3) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(j3);
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(System.currentTimeMillis());
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) {
            return h(calendar.get(11), calendar.get(12));
        }
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) + 1 == calendar2.get(6)) {
            return HardCodeUtil.qqStr(R.string.kts);
        }
        if (calendar.get(1) == calendar2.get(1) && calendar.get(6) > calendar2.get(6) - 7) {
            switch (calendar.get(7)) {
                case 1:
                    return HardCodeUtil.qqStr(R.string.f171759ku0);
                case 2:
                    return HardCodeUtil.qqStr(R.string.ktx);
                case 3:
                    return HardCodeUtil.qqStr(R.string.ktw);
                case 4:
                    return HardCodeUtil.qqStr(R.string.f171760ku1);
                case 5:
                    return HardCodeUtil.qqStr(R.string.ktz);
                case 6:
                    return HardCodeUtil.qqStr(R.string.ktt);
                case 7:
                    return HardCodeUtil.qqStr(R.string.kty);
            }
        }
        return new SimpleDateFormat("yy/MM/dd").format(date);
    }

    private static String h(int i3, int i16) {
        String valueOf;
        String valueOf2;
        StringBuilder sb5 = new StringBuilder();
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = String.valueOf(i3);
        }
        sb5.append(valueOf);
        sb5.append(":");
        if (i16 < 10) {
            valueOf2 = "0" + i16;
        } else {
            valueOf2 = String.valueOf(i16);
        }
        sb5.append(valueOf2);
        return sb5.toString();
    }

    public static boolean i(char c16) {
        if (c16 < '\u00ff' && c16 >= 0) {
            return false;
        }
        return true;
    }

    public static void j(QQAppInterface qQAppInterface, String str) {
        k(qQAppInterface, str, "");
    }

    public static void l(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4, String str5, String str6) {
        k(qQAppInterface, str, "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + str6);
    }

    public static String m(long j3) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (currentTimeMillis < 3600000) {
            return (((currentTimeMillis / 60) / 1000) + 1) + HardCodeUtil.qqStr(R.string.ktv);
        }
        if (currentTimeMillis < 86400000) {
            return (((currentTimeMillis / 60) / 60) / 1000) + HardCodeUtil.qqStr(R.string.f171761ku2);
        }
        return ((((currentTimeMillis / 24) / 60) / 60) / 1000) + HardCodeUtil.qqStr(R.string.ktu);
    }

    public static String b(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            StringBuilder sb5 = new StringBuilder(bArr.length * 2);
            for (byte b16 : bArr) {
                sb5.append(String.format("%02x", Integer.valueOf(b16 & 255)));
            }
            return sb5.toString();
        }
        return "";
    }

    public static void k(QQAppInterface qQAppInterface, String str, String str2) {
        String str3;
        String str4;
        String str5;
        if (str == null || str.isEmpty()) {
            return;
        }
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + qQAppInterface.getCurrentAccountUin(), 4);
        if (sharedPreferences != null) {
            String valueOf = String.valueOf(sharedPreferences.getInt("charm_level", 0));
            String valueOf2 = String.valueOf(sharedPreferences.getInt("gender", 0));
            str5 = String.valueOf(sharedPreferences.getInt("age", 0));
            str3 = valueOf;
            str4 = valueOf2;
        } else {
            str3 = "";
            str4 = str3;
            str5 = str4;
        }
        ReportController.o(null, INowVideoReporter.TAG, "grp_lbs", "", "video", str, 0, 0, str3, str4, str5, str2);
    }

    public static int g(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        int length = charSequence.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += charSequence.charAt(i16) < '\u0080' ? 1 : 2;
        }
        return i3;
    }

    public static int f(String str) {
        if (str == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < str.length(); i16++) {
            i3 = i(str.charAt(i16)) ? i3 + 2 : i3 + 1;
        }
        return i3;
    }

    public static String c(long j3) {
        if (j3 < 10000) {
            return Long.toString(j3);
        }
        if (j3 > JsonGrayBusiId.UI_RESERVE_100000_110000) {
            return "9.9\u4e07+";
        }
        return String.format("%.1f\u4e07", Double.valueOf(j3 / 10000.0d));
    }

    public static String e(long j3) {
        if (j3 < 10000) {
            return Long.toString(j3);
        }
        if (j3 > 10000 && j3 < 10000000) {
            return String.format("%.1f\u4e07", Double.valueOf(j3 / 10000.0d));
        }
        return String.format("%d\u5343\u4e07", Long.valueOf(j3 / 10000000));
    }
}
