package s04;

import android.text.TextUtils;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    @NotNull
    public static String a(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() > 1024) {
            return str.substring(0, 1024);
        }
        return str;
    }

    public static boolean b(String[] strArr, String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }
}
