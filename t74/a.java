package t74;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f435528a;

    /* renamed from: b, reason: collision with root package name */
    public static final double f435529b;

    /* renamed from: c, reason: collision with root package name */
    private static final double f435530c;

    /* renamed from: d, reason: collision with root package name */
    private static final double f435531d;

    static {
        int baseNumber = (int) FileUtils.getBaseNumber();
        f435528a = baseNumber;
        double d16 = baseNumber;
        f435529b = d16;
        double d17 = baseNumber * d16;
        f435530c = d17;
        f435531d = baseNumber * d17;
    }

    public static String b(long j3, boolean z16) {
        double d16;
        String str = "";
        double d17 = j3;
        try {
            d16 = f435529b;
        } catch (ArithmeticException unused) {
            QLog.e("ByteUnitConvertUtils", 4, " DecimalFormat \u6570\u5b57\u8f6c\u6362\u5b57\u7b26\u4e32 error ");
        }
        if (d17 < d16) {
            return j3 + "B";
        }
        DecimalFormat decimalFormat = new DecimalFormat("##0");
        double d18 = f435530c;
        if (d17 < d18) {
            str = decimalFormat.format(Math.round(d17 / d16)) + "KB";
            if (str.equals(f435528a + "KB")) {
                return "1MB";
            }
            return str;
        }
        double d19 = f435531d;
        if (d17 >= d19) {
            DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
            decimalFormat2.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat2.format(d17 / d19) + "GB";
        }
        if (z16) {
            DecimalFormat decimalFormat3 = new DecimalFormat("#.#");
            decimalFormat3.setRoundingMode(RoundingMode.HALF_UP);
            return decimalFormat3.format(d17 / d18) + "MB";
        }
        return decimalFormat.format(Math.round(d17 / d18)) + "MB";
    }

    public static String a(long j3) {
        return b(j3, false);
    }
}
