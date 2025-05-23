package q11;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.http.cookie.Cookie;
import com.tencent.mobileqq.text.EmotcationConstants;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b implements q11.a {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<DateFormat> f428197a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f428198b;

    /* renamed from: c, reason: collision with root package name */
    private static final BitSet f428199c;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat;
        }
    }

    static {
        a aVar = new a();
        f428197a = aVar;
        f428198b = aVar.get().format(new Date(10000L));
        f428199c = new BitSet(128);
        for (char c16 = '0'; c16 <= '9'; c16 = (char) (c16 + 1)) {
            f428199c.set(c16);
        }
        for (char c17 = 'a'; c17 <= 'z'; c17 = (char) (c17 + 1)) {
            f428199c.set(c17);
        }
        for (char c18 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; c18 <= 'Z'; c18 = (char) (c18 + 1)) {
            f428199c.set(c18);
        }
        BitSet bitSet = f428199c;
        bitSet.set(46);
        bitSet.set(45);
    }

    private void b(String str) {
        int i3;
        int length = str.length();
        if (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') {
            length--;
            i3 = 1;
        } else {
            i3 = 0;
        }
        char[] charArray = str.toCharArray();
        while (i3 < length) {
            char c16 = charArray[i3];
            if (c16 >= '!' && c16 != '\"' && c16 != ',' && c16 != ';' && c16 != '\\' && c16 != '\u007f') {
                i3++;
            } else {
                throw new IllegalArgumentException(String.format("The cookie's value [%1$s] is invalid.", str));
            }
        }
    }

    private void c(String str) {
        char[] charArray = str.toCharArray();
        int i3 = 0;
        char c16 = '\uffff';
        while (i3 < charArray.length) {
            char c17 = charArray[i3];
            if (f428199c.get(c17)) {
                if ((c16 != '.' && c16 != '\uffff') || (c17 != '.' && c17 != '-')) {
                    if (c16 == '-' && c17 == '.') {
                        throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", str));
                    }
                    i3++;
                    c16 = c17;
                } else {
                    throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", str));
                }
            } else {
                throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", str));
            }
        }
        if (c16 != '.' && c16 != '-') {
        } else {
            throw new IllegalArgumentException(String.format("The cookie's domain [%1$s] is invalid.", str));
        }
    }

    private void d(String str) {
        for (char c16 : str.toCharArray()) {
            if (c16 < ' ' || c16 > '~' || c16 == ';') {
                throw new IllegalArgumentException(String.format("The cookie's path [%1$s] is invalid.", str));
            }
        }
    }

    @Override // q11.a
    @NonNull
    public String a(@NonNull Cookie cookie) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cookie.getName());
        stringBuffer.append('=');
        String value = cookie.getValue();
        if (!TextUtils.isEmpty(value)) {
            b(value);
            stringBuffer.append(value);
        }
        int maxAge = cookie.getMaxAge();
        if (maxAge > -1) {
            stringBuffer.append("; Max-Age=");
            stringBuffer.append(maxAge);
            stringBuffer.append("; Expires=");
            if (maxAge == 0) {
                stringBuffer.append(f428198b);
            } else {
                f428197a.get().format(new Date(System.currentTimeMillis() + (maxAge * 1000)), stringBuffer, new FieldPosition(0));
            }
        }
        String domain = cookie.getDomain();
        if (domain != null && domain.length() > 0) {
            c(domain);
            stringBuffer.append("; Domain=");
            stringBuffer.append(domain);
        }
        String path = cookie.getPath();
        if (path != null && path.length() > 0) {
            d(path);
            stringBuffer.append("; Path=");
            stringBuffer.append(path);
        }
        if (cookie.getSecure()) {
            stringBuffer.append("; Secure");
        }
        if (cookie.isHttpOnly()) {
            stringBuffer.append("; HttpOnly");
        }
        return stringBuffer.toString();
    }
}
