package yn4;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("#")) {
            return true;
        }
        return false;
    }
}
