package retrofit2;

import android.annotation.TargetApi;
import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: P */
/* loaded from: classes29.dex */
class w {

    /* compiled from: P */
    @TargetApi(24)
    @IgnoreJRERequirement
    /* loaded from: classes29.dex */
    static final class a extends w {
        @Override // retrofit2.w
        Object b(Method method, Class<?> cls, Object obj, @Nullable Object[] objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return o.a(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }

        @Override // retrofit2.w
        boolean c(Method method) {
            boolean isDefault;
            isDefault = method.isDefault();
            return isDefault;
        }
    }

    /* compiled from: P */
    @IgnoreJRERequirement
    /* loaded from: classes29.dex */
    static class b extends w {
        @Override // retrofit2.w
        String a(Method method, int i3) {
            Parameter[] parameters;
            boolean isNamePresent;
            String name;
            parameters = method.getParameters();
            Parameter parameter = parameters[i3];
            isNamePresent = parameter.isNamePresent();
            if (isNamePresent) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("parameter '");
                name = parameter.getName();
                sb5.append(name);
                sb5.append('\'');
                return sb5.toString();
            }
            return super.a(method, i3);
        }

        @Override // retrofit2.w
        Object b(Method method, Class<?> cls, Object obj, @Nullable Object[] objArr) throws Throwable {
            return o.a(method, cls, obj, objArr);
        }

        @Override // retrofit2.w
        boolean c(Method method) {
            boolean isDefault;
            isDefault = method.isDefault();
            return isDefault;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Method method, int i3) {
        return "parameter #" + (i3 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Object b(Method method, Class<?> cls, Object obj, @Nullable Object[] objArr) throws Throwable {
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Method method) {
        return false;
    }
}
