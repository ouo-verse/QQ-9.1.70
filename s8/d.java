package s8;

import com.qzone.proxy.feedcomponent.model.User;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static Map<Long, Long> f433424a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public static long f433425b = 86400000;

    public static void a(User user) {
        String str;
        if (f433424a == null) {
            f433424a = new HashMap();
        }
        if (user.isFamousWhite == 3) {
            f433424a.put(Long.valueOf(user.uin), Long.valueOf(System.currentTimeMillis()));
        } else if (f433424a.containsKey(Long.valueOf(user.uin)) && System.currentTimeMillis() - f433424a.get(Long.valueOf(user.uin)).longValue() > f433425b) {
            f433424a.remove(Long.valueOf(user.uin));
        }
        if (35 != user.actiontype || (str = user.actionurl) == null || str.length() <= 0) {
            return;
        }
        vo.d.b().g(user.uin, user.actionurl);
    }
}
