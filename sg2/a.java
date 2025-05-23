package sg2;

import android.util.Log;
import com.tencent.mobileqq.qqexpand.manager.IExpandClassManager;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    public static String a() {
        try {
            return ((IExpandClassManager) QRoute.api(IExpandClassManager.class)).getExpandHandlerClassName();
        } catch (Throwable th5) {
            Log.e("ExpandTempleManager", "[getExpandHandlerClassName]", th5);
            return null;
        }
    }

    public static Class b() {
        try {
            return ((IExpandClassManager) QRoute.api(IExpandClassManager.class)).getExpandLimitChatManagerClass();
        } catch (Throwable th5) {
            Log.e("ExpandTempleManager", "[getExpandLimitChatManagerClass]", th5);
            return null;
        }
    }

    public static Class c() {
        try {
            return ((IExpandClassManager) QRoute.api(IExpandClassManager.class)).getExpandManagerClass();
        } catch (Throwable th5) {
            Log.e("ExpandTempleManager", "[getExpandManager]", th5);
            return null;
        }
    }
}
