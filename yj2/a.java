package yj2;

import common.config.service.QzoneConfig;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final DateFormat f450499a = new SimpleDateFormat("mm:ss", Locale.CHINA);

    public static long a(long j3) {
        return Math.max(j3, 0L);
    }

    public static String b(long j3) {
        double d16 = ((float) j3) / 1000.0f;
        long j16 = (int) d16;
        if (j16 == 0) {
            j16 = Math.round(d16);
        }
        return String.format("%ss", Long.valueOf(j16));
    }

    public static String c(long j3) {
        String str;
        String str2;
        String str3;
        if (j3 == 0) {
            return QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT;
        }
        long a16 = a(j3);
        int i3 = (int) (a16 / 3600000);
        long j16 = a16 % 3600000;
        int i16 = ((int) j16) / 60000;
        double d16 = ((float) (j16 % 60000)) / 1000.0f;
        int i17 = (int) d16;
        if (i3 == 0 && i16 == 0 && i17 == 0) {
            i17 = (int) Math.round(d16);
        }
        int i18 = 0;
        if (i17 == 60) {
            i16++;
            i17 = 0;
        }
        if (i16 == 60) {
            i3++;
        } else {
            i18 = i16;
        }
        String str4 = "";
        if (i17 < 10) {
            str = "0" + i17;
        } else {
            str = "" + i17;
        }
        if (i18 < 10) {
            str2 = "0" + i18;
        } else {
            str2 = "" + i18;
        }
        if (i3 < 10) {
            str3 = "0" + i3;
        } else {
            str3 = "" + i3;
        }
        if (i3 > 0) {
            str4 = str3 + ":";
        }
        return str4 + str2 + ":" + str;
    }

    public static long d(long j3) {
        return Math.round((((float) j3) / 1000.0f) / 1000.0f);
    }
}
