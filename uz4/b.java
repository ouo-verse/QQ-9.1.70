package uz4;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class b implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        if (request.body() != null && request.header("Content-Encoding") == null) {
            return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), new a(request.body())).build());
        }
        return chain.proceed(request);
    }
}
