package uq3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Set;

/* compiled from: P */
@Deprecated
/* loaded from: classes22.dex */
public class g {
    public static SharedPreferences a(String str, boolean z16, boolean z17) {
        return b(str, z16, true, z17);
    }

    public static SharedPreferences b(String str, boolean z16, boolean z17, boolean z18) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (z16 && z17) {
            str = str + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        }
        if (z18) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        return j.c(str, i3, z16);
    }

    public static SharedPreferences c(boolean z16, boolean z17) {
        return a("sp_qqcircle", z16, z17);
    }

    public static Object d(String str, Object obj) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = c(true, true);
        } catch (Throwable th5) {
            th5.printStackTrace();
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (!(obj instanceof Set)) {
            return null;
        }
        return sharedPreferences.getStringSet(str, (Set) obj);
    }

    public static void e(String str, Object obj) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = c(true, true);
        } catch (Exception e16) {
            e16.printStackTrace();
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Set) {
            edit.putStringSet(str, (Set) obj);
        }
        edit.apply();
    }
}
