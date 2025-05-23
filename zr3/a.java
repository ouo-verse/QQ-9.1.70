package zr3;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static String a(String str) {
        if (b(str)) {
            return "";
        }
        return str.replace('.', '/');
    }

    public static boolean b(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() != 0) {
            return false;
        }
        return true;
    }
}
