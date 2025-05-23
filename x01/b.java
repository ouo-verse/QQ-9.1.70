package x01;

import java.net.InetAddress;
import java.net.Socket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lx01/b;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "<init>", "()V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b implements Interceptor {
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Socket socket;
        Socket socket2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        InetAddress inetAddress = null;
        if (chain.call() instanceof RealCall) {
            Call call = chain.call();
            if (call != null) {
                if (((RealCall) call).getConnection() != null) {
                    Call call2 = chain.call();
                    if (call2 != null) {
                        RealConnection connection = ((RealCall) call2).getConnection();
                        if (connection != null && (socket2 = connection.socket()) != null) {
                            inetAddress = socket2.getInetAddress();
                        }
                        Response proceed = chain.proceed(chain.request());
                        Response.Builder newBuilder = proceed.newBuilder();
                        ResponseBody body = proceed.body();
                        Intrinsics.checkNotNull(body);
                        return newBuilder.body(new a(body, inetAddress)).build();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.connection.RealCall");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.connection.RealCall");
            }
        }
        Connection connection2 = chain.connection();
        if (connection2 != null && (socket = connection2.socket()) != null) {
            inetAddress = socket.getInetAddress();
        }
        Response proceed2 = chain.proceed(chain.request());
        Response.Builder newBuilder2 = proceed2.newBuilder();
        ResponseBody body2 = proceed2.body();
        Intrinsics.checkNotNull(body2);
        return newBuilder2.body(new a(body2, inetAddress)).build();
    }
}
