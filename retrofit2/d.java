package retrofit2;

import java.io.IOException;
import okhttp3.Request;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface d<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    d<T> mo2228clone();

    ab<T> execute() throws IOException;

    void g(f<T> fVar);

    boolean isCanceled();

    Request request();
}
