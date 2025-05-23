package t42;

import android.os.Looper;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    public static void a(String str, String str2) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a(str, str2);
        }
    }
}
