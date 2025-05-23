package retrofit2;

import android.annotation.TargetApi;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.h;

/* compiled from: P */
@TargetApi(24)
@IgnoreJRERequirement
/* loaded from: classes29.dex */
public final class s extends h.a {

    /* compiled from: P */
    @IgnoreJRERequirement
    /* loaded from: classes29.dex */
    static final class a<T> implements h<ResponseBody, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        private final h<ResponseBody, T> f431313a;

        a(h<ResponseBody, T> hVar) {
            this.f431313a = hVar;
        }

        @Override // retrofit2.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            Optional<T> ofNullable;
            ofNullable = Optional.ofNullable(this.f431313a.convert(responseBody));
            return ofNullable;
        }
    }

    @Override // retrofit2.h.a
    @Nullable
    public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, ac acVar) {
        if (h.a.b(type) != Optional.class) {
            return null;
        }
        return new a(acVar.h(h.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
