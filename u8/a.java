package u8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f438531a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f438532b = true;

    /* renamed from: c, reason: collision with root package name */
    private static Method f438533c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f438534d;

    public static void a(String str) {
        Method method;
        if (f438531a && (method = f438533c) != null) {
            try {
                method.invoke(null, 8L, str);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InvocationTargetException e17) {
                e17.printStackTrace();
            }
        }
    }

    public static void b() {
        Method method;
        if (f438531a && (method = f438534d) != null) {
            try {
                method.invoke(null, 1);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InvocationTargetException e17) {
                e17.printStackTrace();
            }
        }
    }

    static {
        try {
            Class<?> cls = Class.forName("android.os.Trace");
            Class<?> cls2 = Long.TYPE;
            f438533c = cls.getDeclaredMethod("traceBegin", cls2, String.class);
            f438534d = cls.getDeclaredMethod("traceEnd", cls2);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (NoSuchMethodException e17) {
            e17.printStackTrace();
        }
    }
}
