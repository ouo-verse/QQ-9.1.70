package rx.internal.util;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes29.dex */
public final class PlatformDependent {
    private static final int ANDROID_API_VERSION;
    public static final int ANDROID_API_VERSION_IS_NOT_ANDROID = 0;
    private static final boolean IS_ANDROID;

    static {
        boolean z16;
        int resolveAndroidApiVersion = resolveAndroidApiVersion();
        ANDROID_API_VERSION = resolveAndroidApiVersion;
        if (resolveAndroidApiVersion != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        IS_ANDROID = z16;
    }

    PlatformDependent() {
        throw new IllegalStateException("No instances!");
    }

    public static int getAndroidApiVersion() {
        return ANDROID_API_VERSION;
    }

    static ClassLoader getSystemClassLoader() {
        if (System.getSecurityManager() == null) {
            return ClassLoader.getSystemClassLoader();
        }
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() { // from class: rx.internal.util.PlatformDependent.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }

    public static boolean isAndroid() {
        return IS_ANDROID;
    }

    private static int resolveAndroidApiVersion() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION", true, getSystemClassLoader()).getField("SDK_INT").get(null)).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }
}
