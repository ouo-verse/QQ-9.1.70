package ya3;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uq3.c;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f449936b;

    /* renamed from: a, reason: collision with root package name */
    private Pattern f449937a = Pattern.compile("(\\d+)\\.(\\d+).(\\d+)_(\\d+)");

    a() {
    }

    public static a d() {
        if (f449936b == null) {
            synchronized (a.class) {
                if (f449936b == null) {
                    f449936b = new a();
                }
            }
        }
        return f449936b;
    }

    public int b(String str, String str2, int i3) {
        String c16 = c(str, str2);
        if (c16 == null) {
            return i3;
        }
        try {
            return Integer.valueOf(c16).intValue();
        } catch (Exception unused) {
            return i3;
        }
    }

    public String c(String str, String str2) {
        String a16 = c.a1(str, str2);
        if (a16 == null) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(a16);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString("configId");
                String optString2 = jSONObject.optString("value");
                Log.d("QzoneAlphaConfig", "configId=" + optString + " value=" + optString2);
                if (e(jSONObject)) {
                    return optString2;
                }
            }
            return null;
        } catch (JSONException unused) {
            QLog.e("QzoneAlphaConfig", 1, "failed parsing config:" + a16);
            return null;
        }
    }

    private int[] f(String str) {
        try {
            String[] split = str.split("_");
            if (split.length < 2) {
                return null;
            }
            String[] split2 = split[0].split("\\.");
            if (split2.length < 3) {
                return null;
            }
            int[] iArr = new int[4];
            for (int i3 = 0; i3 < 3; i3++) {
                iArr[i3] = Integer.parseInt(split2[i3]);
            }
            iArr[3] = Integer.parseInt(split[1]);
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] split = str.split(",");
            if (split.length < 2) {
                return false;
            }
            int[] f16 = f(split[0].trim());
            int[] f17 = f(split[1].trim());
            if (f16 != null && f17 != null && f16.length >= 4 && f17.length >= 4) {
                long j3 = (f16[0] << 32) + (f16[1] << 24) + (f16[2] << 16) + f16[3];
                try {
                    long j16 = (f17[0] << 32) + (f17[1] << 24) + (f17[2] << 16) + f17[3];
                    Matcher matcher = this.f449937a.matcher(QUA.getQUA3());
                    if (matcher.find()) {
                        long parseLong = (Long.parseLong(matcher.group(1)) << 32) + (Long.parseLong(matcher.group(2)) << 24) + (Long.parseLong(matcher.group(3)) << 16) + Long.parseLong(matcher.group(4));
                        if (parseLong < j3 || parseLong > j16) {
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }
            return false;
        } catch (Throwable unused2) {
            return false;
        }
    }

    private boolean e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        String optString = jSONObject.optString("appVersionRange");
        if (!TextUtils.isEmpty(optString) && !a(optString)) {
            return false;
        }
        String optString2 = jSONObject.optString("osVersionRange");
        if (!TextUtils.isEmpty(optString2)) {
            String[] split = optString2.split(",");
            int parseInt = Integer.parseInt(split[0].trim());
            int parseInt2 = Integer.parseInt(split[1].trim());
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < parseInt || i3 > parseInt2) {
                return false;
            }
        }
        String optString3 = jSONObject.optString("uinRange");
        if (!TextUtils.isEmpty(optString3)) {
            String[] split2 = optString3.split(",");
            if (split2[0].length() != split2[1].length()) {
                return false;
            }
            int parseInt3 = Integer.parseInt(split2[0]);
            int parseInt4 = Integer.parseInt(split2[1]);
            int parseLong = (int) (Long.parseLong(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()) % ((int) Math.pow(10.0d, r1)));
            if (parseLong < parseInt3 || parseLong > parseInt4) {
                return false;
            }
        }
        return true;
    }
}
