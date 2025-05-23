package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
abstract class ad<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ad<T> b(ac acVar, Class<?> cls, Method method) {
        aa b16 = aa.b(acVar, cls, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!ae.j(genericReturnType)) {
            if (genericReturnType != Void.TYPE) {
                return p.f(acVar, method, b16);
            }
            throw ae.n(method, "Service methods cannot return void.", new Object[0]);
        }
        throw ae.n(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public abstract T a(Object obj, Object[] objArr);
}
