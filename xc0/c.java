package xc0;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    public static <T> T a(Class<T> cls, Object... objArr) {
        return (T) yc0.a.a(cls, objArr);
    }

    public static int b(int i3) {
        try {
            return BaseApplicationImpl.getApplication().getResources().getInteger(i3);
        } catch (Throwable th5) {
            QLog.e("StoryApi", 1, "getInteger error!", th5);
            return 0;
        }
    }

    public static String c(int i3) {
        return BaseApplicationImpl.getApplication().getResources().getString(i3);
    }

    public static String d(String str) {
        return str;
    }
}
