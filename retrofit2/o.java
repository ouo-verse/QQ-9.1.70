package retrofit2;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: P */
/* loaded from: classes29.dex */
final class o {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static Constructor<MethodHandles.Lookup> f431286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    @IgnoreJRERequirement
    public static Object a(Method method, Class<?> cls, Object obj, @Nullable Object[] objArr) throws Throwable {
        MethodHandle unreflectSpecial;
        MethodHandle bindTo;
        Object invokeWithArguments;
        Constructor<MethodHandles.Lookup> constructor = f431286a;
        if (constructor == null) {
            constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            constructor.setAccessible(true);
            f431286a = constructor;
        }
        unreflectSpecial = constructor.newInstance(cls, -1).unreflectSpecial(method, cls);
        bindTo = unreflectSpecial.bindTo(obj);
        invokeWithArguments = bindTo.invokeWithArguments(objArr);
        return invokeWithArguments;
    }
}
