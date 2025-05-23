package yb2;

import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile OkHttpClient f450020a;

    /* renamed from: b, reason: collision with root package name */
    private static final ConnectionPool f450021b = new ConnectionPool(10, 60, TimeUnit.SECONDS);

    /* renamed from: c, reason: collision with root package name */
    private static final Dispatcher f450022c;

    static {
        Dispatcher dispatcher = new Dispatcher();
        f450022c = dispatcher;
        dispatcher.setMaxRequests(64);
        dispatcher.setMaxRequestsPerHost(8);
        c(30000L);
    }

    private static OkHttpClient.Builder a(long j3, boolean z16) {
        List<? extends Protocol> asList;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (z16) {
            asList = Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1);
        } else {
            asList = Arrays.asList(Protocol.HTTP_1_1);
        }
        OkHttpClient.Builder protocols = builder.protocols(asList);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return protocols.connectTimeout(j3, timeUnit).readTimeout(j3, timeUnit).writeTimeout(j3, timeUnit).connectionPool(f450021b).dispatcher(f450022c);
    }

    public static OkHttpClient b() {
        if (f450020a == null) {
            c(30000L);
        }
        return f450020a;
    }

    private static void c(long j3) {
        f450020a = a(j3, ((IMiniAppService) QRoute.api(IMiniAppService.class)).enableHttp2()).build();
    }
}
