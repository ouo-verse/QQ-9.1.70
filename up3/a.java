package up3;

import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static long a(String str) {
        return BaseApplication.getContext().getSharedPreferences("opensdk_virtual_account_last_chosen_vid", 0).getLong(str, 0L);
    }

    public static void b(String str, long j3) {
        BaseApplication.getContext().getSharedPreferences("opensdk_virtual_account_last_chosen_vid", 0).edit().putLong(str, j3).commit();
    }
}
