package yc0;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import hd0.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Set<Class<?>> f450125a = Collections.synchronizedSet(new HashSet());

    /* JADX WARN: Removed duplicated region for block: B:66:0x003a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0073 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> T a(Class<T> cls, Object[] objArr) {
        int length;
        int length2;
        Constructor<?> constructor;
        boolean z16;
        Class<?>[] b16 = b(objArr);
        if (b16 == null) {
            length = 0;
        } else {
            length = b16.length;
        }
        try {
            constructor = cls.getConstructor(b16);
        } catch (NoSuchMethodException e16) {
            Constructor<?>[] constructors = cls.getConstructors();
            if (constructors == null) {
                length2 = 0;
            } else {
                length2 = constructors.length;
            }
            int i3 = 0;
            while (true) {
                if (i3 < length2) {
                    Constructor<?> constructor2 = constructors[i3];
                    Class<?>[] parameterTypes = constructor2.getParameterTypes();
                    if (length == parameterTypes.length) {
                        for (int i16 = 0; i16 < length; i16++) {
                            if (b16[i16] == null) {
                                if (parameterTypes[i16].isPrimitive()) {
                                    z16 = false;
                                    break;
                                }
                            } else {
                                if (parameterTypes[i16].isPrimitive()) {
                                    Class<?> cls2 = b16[i16];
                                    if (cls2 != null) {
                                        try {
                                        } catch (IllegalAccessException e17) {
                                            e17.printStackTrace();
                                            if (!parameterTypes[i16].isAssignableFrom(b16[i16])) {
                                            }
                                        } catch (NoSuchFieldException e18) {
                                            e18.printStackTrace();
                                            if (!parameterTypes[i16].isAssignableFrom(b16[i16])) {
                                            }
                                        }
                                        if (parameterTypes[i16].equals((Class) cls2.getField("TYPE").get(null))) {
                                        }
                                    }
                                    z16 = false;
                                    break;
                                }
                                if (!parameterTypes[i16].isAssignableFrom(b16[i16])) {
                                    z16 = false;
                                    break;
                                }
                            }
                        }
                        z16 = true;
                        if (z16) {
                            constructor = constructor2;
                            break;
                        }
                    }
                    i3++;
                } else {
                    constructor = null;
                    break;
                }
            }
            if (constructor != null) {
                c.g("NullableObjectFactoryImplement", "\u867d\u7136\u4e0d\u662f\u76f4\u63a5\u5339\u914d, \u4f46\u662f\u8fd8\u662f\u627e\u5230\u4e86" + cls.getName() + "(" + Arrays.toString(b16) + ")\u7684\u6784\u9020\u51fd\u6570");
            } else {
                throw new IllegalStateException(HardCodeUtil.qqStr(R.string.otz) + cls.getName() + "(" + Arrays.toString(b16) + HardCodeUtil.qqStr(R.string.f172251ou2), e16);
            }
        }
        try {
            return cls.cast(constructor.newInstance(objArr));
        } catch (IllegalAccessException e19) {
            throw new IllegalStateException(cls.getName() + "(" + Arrays.toString(b16) + HardCodeUtil.qqStr(R.string.f172250ou1), e19);
        } catch (InstantiationException e26) {
            throw new IllegalStateException(cls.getName() + "(" + Arrays.toString(b16) + HardCodeUtil.qqStr(R.string.f172249ou0), e26);
        } catch (InvocationTargetException e27) {
            throw new IllegalArgumentException(cls.getName() + "(" + Arrays.toString(b16) + ") InvocationTargetException", e27);
        }
    }

    public static Class<?>[] b(Object[] objArr) {
        Class<?> cls;
        if (objArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            clsArr[i3] = cls;
        }
        return clsArr;
    }
}
