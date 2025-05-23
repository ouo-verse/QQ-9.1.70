package x2;

import android.util.Log;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f447073a = "TimeFormatUtil";

    public static long a(long j3) {
        try {
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).parse(new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(j3))).getTime();
        } catch (ParseException unused) {
            Log.e(f447073a, "parse date failed");
            return 0L;
        }
    }

    public static long b(long j3) {
        return j3 - (j3 % 60000);
    }
}
