package t74;

import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.RequestRoute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \u0006*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u000f\u0006B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\f\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u001f\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010R&\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lt74/e;", "T", "", "", "key", "Lt74/e$b;", "b", "Ljava/lang/Class;", "clazz", "", "c", "obj", "d", "params", "", "a", "(Ljava/lang/String;Ljava/lang/Object;)Z", "", "Ljava/util/Map;", "mRoutes", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, b<T>> mRoutes = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lt74/e$b;", "T", "", "params", "", "a", "(Ljava/lang/Object;)V", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "getMethod", "()Ljava/lang/reflect/Method;", "setMethod", "(Ljava/lang/reflect/Method;)V", "method", "b", "Ljava/lang/Object;", "getObject", "()Ljava/lang/Object;", "setObject", "object", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class b<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private Method method;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private Object object;

        public b(Method method, Object object) {
            Intrinsics.checkNotNullParameter(method, "method");
            Intrinsics.checkNotNullParameter(object, "object");
            this.method = method;
            this.object = object;
        }

        public final void a(T params) {
            try {
                this.method.invoke(this.object, params);
            } catch (Exception e16) {
                if (e16 instanceof InvocationTargetException) {
                    InvocationTargetException invocationTargetException = (InvocationTargetException) e16;
                    QLog.e("Dispatcher", 1, "apply exception : " + invocationTargetException.getTargetException() + " stack :" + MsfSdkUtils.getStackTraceString(invocationTargetException.getTargetException()));
                    return;
                }
                QLog.e("Dispatcher", 1, "apply exception : " + e16);
            }
        }
    }

    private final b<T> b(String key) {
        return this.mRoutes.get(key);
    }

    public final boolean a(String key, T params) {
        b<T> b16 = b(key);
        if (b16 == null) {
            return false;
        }
        b16.a(params);
        return true;
    }

    public final void c(Class<?> clazz) {
        Object obj;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            obj = clazz.newInstance();
        } catch (Exception e16) {
            QLog.e("Dispatcher", 1, "registerRoute new instance error: " + e16);
            obj = null;
        }
        d(obj);
    }

    public final void d(Object obj) {
        Method[] declaredMethods;
        RequestRoute requestRoute;
        if (obj == null || (declaredMethods = obj.getClass().getDeclaredMethods()) == null) {
            return;
        }
        for (Method m3 : declaredMethods) {
            if (m3.isAnnotationPresent(RequestRoute.class) && (requestRoute = (RequestRoute) m3.getAnnotation(RequestRoute.class)) != null) {
                m3.setAccessible(true);
                if (this.mRoutes.containsKey(requestRoute.value())) {
                    QLog.e("Dispatcher", 1, "registerRoute already has method with key: " + requestRoute.value() + " ");
                } else {
                    Map<String, b<T>> map = this.mRoutes;
                    String value = requestRoute.value();
                    Intrinsics.checkNotNullExpressionValue(m3, "m");
                    map.put(value, new b<>(m3, obj));
                }
            }
        }
    }
}
