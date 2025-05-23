package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface e<R, T> {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type b(int i3, ParameterizedType parameterizedType) {
            return ae.g(i3, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> c(Type type) {
            return ae.h(type);
        }

        @Nullable
        public abstract e<?, ?> a(Type type, Annotation[] annotationArr, ac acVar);
    }

    Type a();

    T b(d<R> dVar);
}
