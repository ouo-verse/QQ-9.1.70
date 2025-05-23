package yo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.common.account.LoginData;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.util.QZLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f {
    private static String a(String str) {
        try {
            Uri parse = Uri.parse(str);
            return parse.getQueryParameter("clicktime") == null ? parse.buildUpon().appendQueryParameter("clicktime", String.valueOf(System.currentTimeMillis())).toString() : str;
        } catch (Exception e16) {
            QLog.e("addSchemeClickTime", 1, "addSchemaClickTime error" + e16);
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        r0 = r0.length() + r1;
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
    
        if (r3 >= r7.length()) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
    
        r5 = r7.charAt(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r5 == '&') goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        if (r5 != '#') goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
    
        if (r8.equals("_wv") == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        if (r1 <= r7.indexOf(35)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:?, code lost:
    
        return android.net.Uri.parse(r7).buildUpon().appendQueryParameter(r8, r9).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return r7.substring(0, r0) + r9 + r7.substring(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(String str, String str2, String str3) {
        char charAt;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = str2 + '=';
        int indexOf = str.indexOf(str4);
        while (indexOf != -1 && (indexOf == 0 || ((charAt = str.charAt(indexOf - 1)) != '?' && charAt != '#' && charAt != '&'))) {
            indexOf = str.indexOf(str4, indexOf + str4.length());
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).toString();
    }

    public static String c(String str, long j3, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (Uri.parse(str).getQueryParameter("_wv") == null) {
                return b(str, "_wv", String.valueOf(j3));
            }
            return z16 ? b(str, "_wv", String.valueOf(j3 | Integer.valueOf(r1).intValue())) : str;
        } catch (Exception e16) {
            QZLog.w(e16);
            return str;
        }
    }

    public static void d(Context context, String str, boolean... zArr) {
        StringBuffer stringBuffer = new StringBuffer("https://www.urlshare.cn/mqz_url_check?url=");
        stringBuffer.append(Uri.encode(str));
        stringBuffer.append("&srctype=touch");
        int i3 = 0;
        if (zArr != null && zArr.length > 0 && zArr[0]) {
            i3 = 2;
        }
        if (zArr != null && zArr.length > 1 && zArr[1]) {
            i3 += 4;
        }
        stringBuffer.append("&_wv=" + i3);
        d.d(stringBuffer.toString(), context, null);
    }

    public static Bundle e(String str) {
        int indexOf;
        int i3;
        String[] split;
        Bundle bundle = new Bundle();
        if (str != null && (indexOf = str.indexOf(63)) >= 0 && (i3 = indexOf + 1) < str.length()) {
            String substring = str.substring(i3);
            if (!TextUtils.isEmpty(substring) && (split = substring.split(ContainerUtils.FIELD_DELIMITER)) != null) {
                for (String str2 : split) {
                    String[] split2 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2 != null && split2.length == 2) {
                        try {
                            bundle.putString(split2[0], URLDecoder.decode(split2[1], "UTF-8"));
                        } catch (UnsupportedEncodingException e16) {
                            e16.printStackTrace();
                        } catch (IllegalArgumentException e17) {
                            QZLog.e("parseUrlParams", "", e17);
                        }
                    }
                }
            }
        }
        return bundle;
    }

    public static String f(String str, String str2) {
        String substring;
        String str3;
        int length;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                StringBuilder sb5 = new StringBuilder();
                int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                int indexOf2 = str.indexOf("#");
                if (indexOf < 0) {
                    return str;
                }
                if (indexOf2 < 0) {
                    str3 = str.substring(indexOf + 1);
                    substring = null;
                } else {
                    if (indexOf2 <= indexOf) {
                        return str;
                    }
                    String substring2 = str.substring(indexOf + 1, indexOf2);
                    substring = str.substring(indexOf2 + 1);
                    str3 = substring2;
                }
                StringBuilder sb6 = new StringBuilder(str.substring(0, indexOf));
                if (str3 != null && str3.trim().length() != 0) {
                    String[] split = str3.split(ContainerUtils.FIELD_DELIMITER);
                    if (split != null && split.length > 0) {
                        for (String str4 : split) {
                            if (str4.indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER) != 0) {
                                sb5.append(str4);
                                sb5.append(ContainerUtils.FIELD_DELIMITER);
                            }
                        }
                    }
                    String sb7 = sb5.toString();
                    if (sb7 != null && (length = sb7.length()) > 0) {
                        sb7 = sb7.substring(0, length - 1);
                    }
                    if (sb7 != null && sb7.trim().length() != 0) {
                        sb6.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                        sb6.append(sb7);
                    }
                    if (substring != null) {
                        sb6.append("#");
                        sb6.append(substring);
                    }
                    return sb6.toString();
                }
            } catch (Throwable th5) {
                QZLog.w(th5);
            }
        }
        return str;
    }

    public static String g(String str, long j3) {
        return j(j(str, "{friendUin}", String.valueOf(j3)), "{FRIENDUIN}", String.valueOf(j3));
    }

    public static String h(String str) {
        return p(s(r(t(v(u(str))))));
    }

    public static String i(String str, String str2, long j3) {
        return j(str, str2, String.valueOf(j3));
    }

    private static String l(String str, String str2, String str3, boolean z16) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return str;
        }
        if (z16) {
            try {
                str3 = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        if (str.contains(str2)) {
            return str.replace(str2, str3);
        }
        return str.replace(str2.toUpperCase(), str3);
    }

    private static String m(String str, String str2, String str3, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        } else if (z16) {
            try {
                str3 = URLEncoder.encode(str3, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
        if (str.contains(str2)) {
            return str.replace(str2, str3);
        }
        return str.replace(str2.toUpperCase(), str3);
    }

    public static String n(String str, String str2, long j3) {
        return l(str, str2, String.valueOf(j3), false);
    }

    private static String p(String str) {
        return a(i(str, "{clicktime}", System.currentTimeMillis()));
    }

    public static String q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.contains(str2)) {
            return str.replace(str2, "");
        }
        return str.replace(str2.toUpperCase(), "");
    }

    private static String r(String str) {
        return q(str, "{idlist}");
    }

    private static String s(String str) {
        return i(str, "{pb}", 0L);
    }

    public static String t(String str) {
        return j(j(str, "{qua}", QUA.getQUA3()), "{QUA}", QUA.getQUA3());
    }

    private static String v(String str) {
        return j(j(str, "{uin}", String.valueOf(LoginData.getInstance().getUin())), "{UIN}", String.valueOf(LoginData.getInstance().getUin()));
    }

    public static String w(String str, long j3) {
        return j(j(str, "{uin}", String.valueOf(j3)), "{UIN}", String.valueOf(j3));
    }

    public static String j(String str, String str2, String str3) {
        return l(str, str2, str3, true);
    }

    public static String k(String str, String str2, String str3) {
        return m(str, str2, str3, true);
    }

    public static String o(String str, String str2, String str3) {
        return l(str, str2, str3, false);
    }

    public static String u(String str) {
        return str;
    }
}
