package q04;

import android.content.SharedPreferences;
import com.tencent.bugly.common.sp.SharedPreferencesProvider;
import com.tencent.bugly.common.utils.ContextUtil;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {
    public static SharedPreferences.Editor a() {
        SharedPreferences b16 = b();
        if (b16 != null) {
            return b16.edit();
        }
        return null;
    }

    public static SharedPreferences b() {
        return SharedPreferencesProvider.getInstance().getMultiProcessSP(ContextUtil.getGlobalContext());
    }
}
