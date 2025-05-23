package wy2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class f {
    private static Class<?>[] a(Object[] objArr) {
        if (objArr != null) {
            Class<?>[] clsArr = new Class[objArr.length];
            int length = objArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = objArr[i3];
                if (obj != null) {
                    clsArr[i3] = obj.getClass();
                } else {
                    clsArr[i3] = String.class;
                }
                Class<?> cls = clsArr[i3];
                if (cls == Integer.class) {
                    clsArr[i3] = Integer.TYPE;
                } else if (cls == Boolean.class) {
                    clsArr[i3] = Boolean.TYPE;
                }
            }
            return clsArr;
        }
        return null;
    }

    public static Object b(String str, Object obj, String str2) throws Exception {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object c(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws Exception {
        Method method = obj.getClass().getMethod(str, clsArr);
        method.setAccessible(true);
        return method.invoke(obj, objArr);
    }

    public static Object d(Object obj, String str, Object[] objArr) throws Exception {
        return c(obj, str, a(objArr), objArr);
    }

    public static Object e(String str, String str2) throws Exception {
        return f(str, str2, null);
    }

    public static Object f(String str, String str2, Object[] objArr) throws Exception {
        return g(str, str2, objArr, a(objArr));
    }

    public static Object g(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getDeclaredMethod(str2, clsArr).invoke(cls, objArr);
    }
}
