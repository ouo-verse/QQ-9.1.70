package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f431295a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final Object f431296b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f431297c;

    /* renamed from: d, reason: collision with root package name */
    private final List<?> f431298d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Class<?> cls, @Nullable Object obj, Method method, List<?> list) {
        this.f431295a = cls;
        this.f431296b = obj;
        this.f431297c = method;
        this.f431298d = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f431297c;
    }

    public Class<?> b() {
        return this.f431295a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f431295a.getName(), this.f431297c.getName(), this.f431298d);
    }
}
