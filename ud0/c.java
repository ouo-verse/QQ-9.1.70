package ud0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Object> f438805a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f438806b = new ConcurrentHashMap();

    public static <T> T a(Class<T> cls) {
        T t16 = (T) f438805a.get(cls);
        if (t16 != null) {
            return t16;
        }
        Class<?> cls2 = f438806b.get(cls);
        if (cls2 != null) {
            try {
                return (T) cls2.newInstance();
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
                return null;
            } catch (InstantiationException e17) {
                e17.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static <T> void b(Class<T> cls, T t16) {
        f438805a.put(cls, t16);
    }
}
