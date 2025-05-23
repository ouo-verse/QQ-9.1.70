package pw2;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes19.dex */
public class y {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("__CNT__")) {
            String format = String.format(Locale.getDefault(), "%02d", Integer.valueOf(zv2.a.a()));
            String replace = str.replace("__CNT__", format);
            n.e("Utils", "buildClickId clickCount " + format + " clickid " + str + " re=" + replace);
            return replace;
        }
        return str;
    }

    public static void b(Map<String, Object> map, Map<String, Object> map2) {
        if (!i(map2) && map != null) {
            map.putAll(map2);
        }
    }

    public static String c(Map<String, String> map) {
        if (i(map)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                try {
                    value = URLEncoder.encode(value, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
                if (sb5.length() > 0) {
                    sb5.append(ContainerUtils.FIELD_DELIMITER);
                    sb5.append(key);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(value);
                } else {
                    sb5.append(key);
                    sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb5.append(value);
                }
            }
        }
        return sb5.toString();
    }

    public static <E> E d(List<E> list, int i3) {
        if (i3 >= 0 && n(list) > i3) {
            return list.get(i3);
        }
        return null;
    }

    public static String e(Context context, String str) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getResources().getAssets().open(str);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                String str2 = new String(bArr, "UTF-8");
                try {
                    inputStream.close();
                    return str2;
                } catch (IOException e16) {
                    e16.printStackTrace();
                    return str2;
                }
            } catch (Exception e17) {
                e17.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                return "";
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public static String f(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static int g(Context context) {
        try {
            return context.getResources().getConfiguration().orientation;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    public static boolean h(Collection<?> collection) {
        if (collection != null && collection.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean i(Map map) {
        if (map != null && map.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean j(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            return false;
        }
        return true;
    }

    public static boolean k(Context context) {
        if (g(context) == 2) {
            return true;
        }
        return false;
    }

    public static boolean l(Map<?, ?> map) {
        if (map == null) {
            return true;
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null) {
                return true;
            }
        }
        return false;
    }

    public static int m(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return i3;
        }
    }

    public static int n(Collection<? extends Object> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }
}
