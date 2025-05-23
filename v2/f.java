package v2;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f440792a = "InstanceLoader";

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f440793b;

    /* renamed from: c, reason: collision with root package name */
    public static Map<Class<?>, Object> f440794c = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        f440793b = hashMap;
        hashMap.put(b.class, c.class);
    }

    public static Object a(Class<?> cls) {
        Class<?> cls2 = f440793b.get(cls);
        if (cls2 == null) {
            Log.w(f440792a, "not find class");
            return null;
        }
        Object obj = f440794c.get(cls2);
        if (obj != null) {
            return obj;
        }
        try {
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            Object newInstance = declaredConstructor.newInstance(new Object[0]);
            f440794c.put(cls2, newInstance);
            return newInstance;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            Log.w(f440792a, "getInstance failed for class" + cls.getSimpleName());
            return null;
        }
    }
}
