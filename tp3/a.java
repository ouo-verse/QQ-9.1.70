package tp3;

import android.content.SharedPreferences;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static int a(String str, int i3, long j3) {
        return c(j3).getInt(str, i3);
    }

    public static SharedPreferences b() {
        return BaseApplication.getContext().getSharedPreferences("OPENSDK_setting", 4);
    }

    public static SharedPreferences c(long j3) {
        if (j3 == 0) {
            return b();
        }
        return BaseApplication.getContext().getSharedPreferences(MD5Utils.encodeHexStr(String.valueOf(j3)) + "_preference", 0);
    }

    public static void d(String str, int i3, long j3) {
        SharedPreferences.Editor edit = c(j3).edit();
        edit.putInt(str, i3);
        edit.commit();
    }
}
