package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface h<F, T> {

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type a(int i3, ParameterizedType parameterizedType) {
            return ae.g(i3, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> b(Type type) {
            return ae.h(type);
        }

        @Nullable
        public h<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, ac acVar) {
            return null;
        }

        @Nullable
        public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, ac acVar) {
            return null;
        }

        @Nullable
        public h<?, String> e(Type type, Annotation[] annotationArr, ac acVar) {
            return null;
        }
    }

    @Nullable
    T convert(F f16) throws IOException;
}
