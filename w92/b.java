package w92;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static int a(Context context) {
        int networkType = NetworkUtil.getNetworkType(context);
        if (networkType == 1) {
            return 2;
        }
        if (networkType == 2) {
            return 3;
        }
        return networkType == 3 ? 4 : 1;
    }
}
