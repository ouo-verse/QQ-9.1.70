package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import rx.internal.util.SuppressAnimalSniffer;
import sun.misc.Unsafe;

/* compiled from: P */
@SuppressAnimalSniffer
/* loaded from: classes29.dex */
public final class UnsafeAccess {
    private static final boolean DISABLED_BY_USER;
    public static final Unsafe UNSAFE;

    static {
        boolean z16;
        if (System.getProperty("rx.unsafe-disable") != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        DISABLED_BY_USER = z16;
        Unsafe unsafe = null;
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            unsafe = (Unsafe) declaredField.get(null);
        } catch (Throwable unused) {
        }
        UNSAFE = unsafe;
    }

    UnsafeAccess() {
        throw new IllegalStateException("No instances!");
    }

    public static long addressOf(Class<?> cls, String str) {
        try {
            return UNSAFE.objectFieldOffset(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e16) {
            InternalError internalError = new InternalError();
            internalError.initCause(e16);
            throw internalError;
        }
    }

    public static boolean compareAndSwapInt(Object obj, long j3, int i3, int i16) {
        return UNSAFE.compareAndSwapInt(obj, j3, i3, i16);
    }

    public static int getAndAddInt(Object obj, long j3, int i3) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j3);
        } while (!unsafe.compareAndSwapInt(obj, j3, intVolatile, intVolatile + i3));
        return intVolatile;
    }

    public static int getAndIncrementInt(Object obj, long j3) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j3);
        } while (!unsafe.compareAndSwapInt(obj, j3, intVolatile, intVolatile + 1));
        return intVolatile;
    }

    public static int getAndSetInt(Object obj, long j3, int i3) {
        Unsafe unsafe;
        int intVolatile;
        do {
            unsafe = UNSAFE;
            intVolatile = unsafe.getIntVolatile(obj, j3);
        } while (!unsafe.compareAndSwapInt(obj, j3, intVolatile, i3));
        return intVolatile;
    }

    public static boolean isUnsafeAvailable() {
        if (UNSAFE != null && !DISABLED_BY_USER) {
            return true;
        }
        return false;
    }
}
