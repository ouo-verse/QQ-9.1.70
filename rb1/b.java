package rb1;

import com.tencent.mobileqq.config.aj;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    public static <T extends a<Y>, Y> T a(Y y16, Class<T> cls) {
        T t16 = (T) aj.f(cls);
        try {
            t16.onParse(y16);
        } catch (Exception e16) {
            QLog.e("QStorage-File", 1, "error :" + e16.getMessage());
        }
        return t16;
    }
}
