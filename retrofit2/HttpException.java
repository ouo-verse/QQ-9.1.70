package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class HttpException extends RuntimeException {
    private final int code;

    /* renamed from: d, reason: collision with root package name */
    private final transient ab<?> f431185d;
    private final String message;

    public HttpException(ab<?> abVar) {
        super(a(abVar));
        this.code = abVar.b();
        this.message = abVar.e();
        this.f431185d = abVar;
    }

    private static String a(ab<?> abVar) {
        Objects.requireNonNull(abVar, "response == null");
        return "HTTP " + abVar.b() + " " + abVar.e();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public ab<?> response() {
        return this.f431185d;
    }
}
