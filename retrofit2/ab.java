package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ab<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Response f431230a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private final T f431231b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final ResponseBody f431232c;

    ab(Response response, @Nullable T t16, @Nullable ResponseBody responseBody) {
        this.f431230a = response;
        this.f431231b = t16;
        this.f431232c = responseBody;
    }

    public static <T> ab<T> c(ResponseBody responseBody, Response response) {
        Objects.requireNonNull(responseBody, "body == null");
        Objects.requireNonNull(response, "rawResponse == null");
        if (!response.isSuccessful()) {
            return new ab<>(response, null, responseBody);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> ab<T> f(@Nullable T t16, Response response) {
        Objects.requireNonNull(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new ab<>(response, t16, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.f431231b;
    }

    public int b() {
        return this.f431230a.code();
    }

    public boolean d() {
        return this.f431230a.isSuccessful();
    }

    public String e() {
        return this.f431230a.message();
    }

    public String toString() {
        return this.f431230a.toString();
    }
}
