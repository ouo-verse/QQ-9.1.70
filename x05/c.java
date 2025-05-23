package x05;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes28.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f446845a = Pattern.compile("<TITLE=\"([^>]+)\",URL=\"([^<]+)\">", 2);

    /* renamed from: b, reason: collision with root package name */
    private static long f446846b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static DecimalFormat f446847c;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ InterfaceC11524c f446848d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f446849e;

        a(InterfaceC11524c interfaceC11524c, String str) {
            this.f446848d = interfaceC11524c;
            this.f446849e = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.f446848d.onClickUrl(this.f446849e);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f446850d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ InterfaceC11524c f446851e;

        b(String str, InterfaceC11524c interfaceC11524c) {
            this.f446850d = str;
            this.f446851e = interfaceC11524c;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            QLog.i("QwUtils", 2, "span click url = " + this.f446850d);
            this.f446851e.onClickUrl(this.f446850d);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    /* renamed from: x05.c$c, reason: collision with other inner class name */
    /* loaded from: classes28.dex */
    public interface InterfaceC11524c {
        void onClickUrl(String str);
    }

    static {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        f446847c = decimalFormat;
        decimalFormat.setDecimalFormatSymbols(new DecimalFormatSymbols(Locale.US));
    }

    public static String a(String str, Map<String, String> map, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (QLog.isColorLevel()) {
                QLog.i("QwUtils", 2, "appendKV2Schema key: " + str2 + " value: " + str3);
            }
            if (z16) {
                try {
                    str3 = URLEncoder.encode(str3);
                } catch (Exception unused) {
                    QLog.i("QwUtils", 2, "error encode key: " + str2 + " value: " + str3);
                }
            }
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
            stringBuffer.append(String.format("%s=%s", str2, str3));
        }
        return stringBuffer.toString();
    }

    public static String b(String str, String str2, int i3, boolean z16) throws Exception {
        if (i3 < 0) {
            return "0";
        }
        BigDecimal bigDecimal = new BigDecimal(str);
        BigDecimal bigDecimal2 = new BigDecimal(str2);
        if (z16) {
            return new DecimalFormat("#0.00").format(bigDecimal.divide(bigDecimal2, i3, 4).doubleValue());
        }
        return new DecimalFormat("#0.##").format(bigDecimal.divide(bigDecimal2, i3, 4).doubleValue());
    }

    public static String c(String str) throws Exception {
        boolean z16;
        if (str != null && str.matches("\\-?[0-9]+")) {
            if (str.charAt(0) == '-') {
                str = str.substring(1);
                z16 = true;
            } else {
                z16 = false;
            }
            while (str.startsWith("0") && str.length() > 1) {
                str = str.substring(1);
            }
            StringBuffer stringBuffer = new StringBuffer();
            if (str.length() == 1) {
                stringBuffer.append("0.0");
                stringBuffer.append(str);
            } else if (str.length() == 2) {
                stringBuffer.append("0.");
                stringBuffer.append(str);
            } else {
                stringBuffer.append(str.substring(0, str.length() - 2));
                stringBuffer.append(".");
                stringBuffer.append(str.substring(str.length() - 2));
            }
            if (z16) {
                return "-" + stringBuffer.toString();
            }
            return stringBuffer.toString();
        }
        throw new Exception("\u91d1\u989d\u683c\u5f0f\u6709\u8bef");
    }

    public static CharSequence d(String str, InterfaceC11524c interfaceC11524c) {
        if (!TextUtils.isEmpty(str) && interfaceC11524c != null) {
            try {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
                Matcher matcher = f446845a.matcher(str);
                boolean z16 = false;
                while (matcher.find()) {
                    String substring = str.substring(matcher.start(1), matcher.end(1));
                    String substring2 = str.substring(matcher.start(2), matcher.end(2));
                    SpannableString spannableString = new SpannableString(substring);
                    spannableString.setSpan(new b(substring2, interfaceC11524c), 0, substring.length(), 33);
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0099FF")), 0, substring.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    spannableStringBuilder.append((CharSequence) "\n");
                    z16 = true;
                }
                if (z16) {
                    return spannableStringBuilder;
                }
                return str;
            } catch (Throwable th5) {
                QLog.e("QwUtils", 1, "error msg in qqpay-api module: ", th5);
                return null;
            }
        }
        return str;
    }

    public static CharSequence e(String str, InterfaceC11524c interfaceC11524c) {
        if (!TextUtils.isEmpty(str) && interfaceC11524c != null) {
            try {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
                Matcher matcher = f446845a.matcher(str);
                boolean z16 = false;
                int i3 = 0;
                while (true) {
                    int i16 = i3;
                    if (!matcher.find()) {
                        break;
                    }
                    int start = matcher.start(0);
                    i3 = matcher.end(0);
                    String substring = str.substring(matcher.start(1), matcher.end(1));
                    String substring2 = str.substring(matcher.start(2), matcher.end(2));
                    if (i16 != start) {
                        spannableStringBuilder.append((CharSequence) str.substring(i16, start));
                    }
                    SpannableString spannableString = new SpannableString(substring);
                    spannableString.setSpan(new a(interfaceC11524c, substring2), 0, substring.length(), 33);
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0099FF")), 0, substring.length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableString);
                    z16 = true;
                }
                if (z16) {
                    spannableStringBuilder.append((CharSequence) str.substring(i3));
                    return spannableStringBuilder;
                }
                return str;
            } catch (Throwable th5) {
                QLog.e("QwUtils", 1, "error msg in qqpay-api module: ", th5);
                return null;
            }
        }
        return str;
    }

    public static boolean f() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f446846b + 1000 > currentTimeMillis) {
            return true;
        }
        f446846b = currentTimeMillis;
        return false;
    }

    public static String g(String str, String str2) {
        try {
            return f446847c.format(new BigDecimal(str).multiply(new BigDecimal(str2)).doubleValue());
        } catch (Exception unused) {
            return "0";
        }
    }

    public static void h(Context context, String str) {
        if (QLog.isColorLevel()) {
            QLog.i("QwUtils", 2, "startQQBrowserActivity url=" + str);
        }
        Intent intent = new Intent();
        intent.putExtra("url", str);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("hide_more_button", true);
        RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    public static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e16) {
            QLog.e("QwUtils", 1, "error msg in qqpay-api module: ", e16);
            return 0.0f;
        }
    }

    public static int j(Object obj, int i3) {
        String str = obj + "";
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(str).intValue();
            } catch (Exception e16) {
                QLog.e("QwUtils", 1, "error msg in qqpay-api module: ", e16);
            }
        }
        return i3;
    }

    public static String k(String str, int i3, boolean z16) {
        try {
            if (i3 == 0) {
                try {
                    return b(str, "100", 2, z16);
                } catch (Exception e16) {
                    QLog.e("QwUtils", 1, "error msg in qqpay-api module: ", e16);
                    try {
                        return c(str);
                    } catch (Exception e17) {
                        QLog.e("QwUtils", 1, "transformToMoney: ", e17);
                        return "0";
                    }
                }
            }
            if (i3 == 1) {
                return new DecimalFormat("#0.00").format(str);
            }
            return "";
        } catch (Exception e18) {
            QLog.e("QwUtils", 1, "error msg in qqpay-api module: ", e18);
            return null;
        }
    }

    public static String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Long.toString((long) Double.valueOf(g(str, "100")).doubleValue());
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
