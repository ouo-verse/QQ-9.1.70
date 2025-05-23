package zd2;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.utils.ci;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    public static boolean a(com.tencent.mobileqq.tianshu.observer.b bVar) {
        if (bVar == null) {
            return false;
        }
        String a16 = bVar.a();
        if (TextUtils.isEmpty(a16)) {
            return false;
        }
        Iterator<String> it = ci.f92747a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next(), a16)) {
                return true;
            }
        }
        return false;
    }
}
