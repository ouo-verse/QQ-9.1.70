package x23;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0013"}, d2 = {"Lx23/d;", "", "", "serviceName", "", "version", "", "Lx23/e;", "interceptor", "Lx23/b;", "getReportImpl", "Lx23/a;", "getLogProxy", "a", "connectChain", "", WadlProxyConsts.PARAM_TIME_OUT, "Lx23/f;", "sample", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface d {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull d dVar) {
            return "";
        }

        @NotNull
        public static x23.a b(@NotNull d dVar) {
            return new w23.b();
        }

        @NotNull
        public static b c(@NotNull d dVar) {
            return new w23.a();
        }

        @Nullable
        public static List<e> d(@NotNull d dVar) {
            return null;
        }
    }

    @NotNull
    String a();

    @NotNull
    String connectChain();

    @NotNull
    x23.a getLogProxy();

    @NotNull
    b getReportImpl();

    @Nullable
    List<e> interceptor();

    @NotNull
    f sample();

    @NotNull
    String serviceName();

    long timeOut();

    int version();
}
