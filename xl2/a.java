package xl2;

import android.text.TextUtils;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Pattern f448127a;

    /* renamed from: b, reason: collision with root package name */
    private static Pattern f448128b;

    /* renamed from: c, reason: collision with root package name */
    private static Pattern f448129c;

    static {
        try {
            f448127a = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$", 2);
            f448128b = Pattern.compile("^([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}$", 2);
            f448129c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$", 2);
        } catch (PatternSyntaxException unused) {
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f448128b.matcher(str).matches() || f448129c.matcher(str).matches();
    }

    public static String b(String str) {
        if (!a(str)) {
            return str;
        }
        return "[" + str + "]";
    }
}
