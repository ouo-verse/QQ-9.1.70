package yc0;

import com.tencent.biz.qqstory.model.g;
import hd0.c;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static ConcurrentHashMap<Class<?>, Class<?>> f450123a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public static ConcurrentHashMap<Class<?>, Class<?>> f450124b;

    static {
        ConcurrentHashMap<Class<?>, Class<?>> concurrentHashMap = new ConcurrentHashMap<>();
        f450124b = concurrentHashMap;
        concurrentHashMap.put(g.class, xc0.b.class);
    }

    public static <T> T a(Class<T> cls, Object... objArr) {
        if (xc0.a.class.isAssignableFrom(cls)) {
            try {
                Class<?> cls2 = f450124b.get(cls);
                if (cls2 != null) {
                    if (xc0.a.class.isAssignableFrom(cls2)) {
                        return (T) b.a(cls2, objArr);
                    }
                    throw new IllegalArgumentException("createExtendableObject class " + cls2.getName() + " should have a KeepConstructor interface");
                }
            } catch (Exception unused) {
                c.h("ExtensionFactoryImplement", "createImplement Error", new Throwable());
            }
            return (T) b.a(cls, objArr);
        }
        throw new IllegalArgumentException("createExtendableObject class " + cls.getName() + " should have a KeepConstructor interface");
    }
}
