package wy2;

import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f446766a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f446767b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f446768c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f446769d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f446770e;

    static {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            f446766a = cls;
            f446767b = cls.getDeclaredMethod("getService", String.class);
            f446768c = f446766a.getDeclaredMethod("addService", String.class, IBinder.class);
            f446769d = f446766a.getDeclaredMethod("checkService", String.class);
            f446770e = f446766a.getDeclaredMethod("listServices", new Class[0]);
        } catch (ClassNotFoundException e16) {
            e16.printStackTrace();
        } catch (NoSuchMethodException e17) {
            e17.printStackTrace();
        } catch (SecurityException e18) {
            e18.printStackTrace();
        }
    }

    public static IBinder a(String str) {
        return (IBinder) b(f446767b, str);
    }

    private static Object b(Method method, Object... objArr) {
        try {
            return method.invoke(null, objArr);
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
            return null;
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
            return null;
        } catch (InvocationTargetException e18) {
            e18.printStackTrace();
            return null;
        }
    }
}
