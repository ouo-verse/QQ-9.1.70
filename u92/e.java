package u92;

import com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {
    public static boolean a(String str) {
        return ((IMiniCardManagerUtils) QRoute.api(IMiniCardManagerUtils.class)).containsKey(str);
    }

    public static Object b(String str) {
        return ((IMiniCardManagerUtils) QRoute.api(IMiniCardManagerUtils.class)).getMiniCard(str);
    }
}
