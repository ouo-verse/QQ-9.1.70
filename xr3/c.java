package xr3;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Class<?>> f448446a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String[] f448447a;

        /* renamed from: b, reason: collision with root package name */
        private String f448448b;

        public String[] b() {
            return this.f448447a;
        }

        public void c(String[] strArr) {
            this.f448447a = strArr;
        }

        public void d(String str) {
            this.f448448b = str;
        }

        @NonNull
        public String toString() {
            return "MethodSpec{paramIdentifiers=" + Arrays.toString(this.f448447a) + ", returnIdentifier='" + this.f448448b + "'}";
        }
    }

    static {
        HashMap hashMap = new HashMap(17);
        f448446a = hashMap;
        hashMap.put("V", Void.TYPE);
        hashMap.put("Z", Boolean.TYPE);
        hashMap.put("B", Byte.TYPE);
        hashMap.put(BdhLogUtil.LogTag.Tag_Conn, Character.TYPE);
        hashMap.put(ExifInterface.LATITUDE_SOUTH, Short.TYPE);
        hashMap.put("I", Integer.TYPE);
        hashMap.put("J", Long.TYPE);
        hashMap.put(UserInfo.SEX_FEMALE, Float.TYPE);
        hashMap.put("D", Double.TYPE);
        hashMap.put("[Z", boolean[].class);
        hashMap.put("[B", byte[].class);
        hashMap.put("[C", char[].class);
        hashMap.put("[S", short[].class);
        hashMap.put("[I", int[].class);
        hashMap.put("[J", long[].class);
        hashMap.put("[F", float[].class);
        hashMap.put("[D", double[].class);
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        if (str.charAt(0) == 'L' && str.charAt(length - 1) == ';') {
            return g(str, "L", ";");
        }
        return str;
    }

    public static boolean b(Class<?>[] clsArr, String str) throws ClassNotFoundException {
        Class<?>[] d16 = d(str);
        if (d16.length != clsArr.length) {
            return false;
        }
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            if (!clsArr[i3].equals(d16[i3])) {
                return false;
            }
        }
        return true;
    }

    public static a c(String str) {
        a aVar = new a();
        String g16 = g(str, "(", ")");
        if (TextUtils.isEmpty(str)) {
            aVar.c(new String[0]);
        } else {
            ArrayList arrayList = new ArrayList();
            char[] charArray = g16.toCharArray();
            StringBuilder sb5 = new StringBuilder();
            boolean z16 = false;
            for (char c16 : charArray) {
                if (c16 != ';') {
                    if (c16 != 'F') {
                        if (c16 != 'L') {
                            if (c16 != 'S' && c16 != 'Z' && c16 != 'I' && c16 != 'J') {
                                switch (c16) {
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                        break;
                                    default:
                                        sb5.append(c16);
                                        break;
                                }
                            }
                        } else {
                            sb5.append(c16);
                            z16 = true;
                        }
                    }
                    sb5.append(c16);
                    if (!z16) {
                        arrayList.add(sb5.toString());
                        sb5.setLength(0);
                    }
                } else {
                    sb5.append(c16);
                    arrayList.add(sb5.toString());
                    sb5.setLength(0);
                    if (z16) {
                        z16 = false;
                    }
                }
            }
            aVar.c((String[]) arrayList.toArray(new String[0]));
        }
        aVar.d(f(str, ")"));
        return aVar;
    }

    public static Class<?>[] d(String str) throws ClassNotFoundException {
        a c16 = c(str);
        Class<?>[] clsArr = new Class[c16.b().length];
        for (int i3 = 0; i3 < c16.f448447a.length; i3++) {
            String str2 = c16.f448447a[i3];
            Class<?> cls = f448446a.get(str2);
            if (cls != null) {
                clsArr[i3] = cls;
            } else {
                clsArr[i3] = Class.forName(e(a(str2)));
            }
        }
        return clsArr;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace('/', '.');
    }

    public static String f(String str, String str2) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str2 == null || (indexOf = str.indexOf(str2)) == -1) {
            return "";
        }
        return str.substring(indexOf + str2.length());
    }

    public static String g(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str != null && str2 != null && str3 != null && (indexOf = str.indexOf(str2)) != -1 && (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) != -1) {
            return str.substring(indexOf + str2.length(), indexOf2);
        }
        return null;
    }
}
