package y01;

import com.tencent.libra.strategy.ILibraBaseStrategy;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.List;
import kotlin.Metadata;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 #2\u00020\u0001:\u0001\u001aB\u0011\u0012\b\u0010%\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH&J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H&J\u001e\u0010\u001a\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00162\u0006\u0010\u0019\u001a\u00020\u0018H&R\"\u0010 \u001a\u00020\u00188\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0019\u0010%\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Ly01/a;", "", "", "i", "", "b", "Lokhttp3/Call;", "call", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "g", h.F, "Ljava/io/IOException;", "exception", "f", "Ljava/net/InetAddress;", "inetAddress", "", "totalBytes", "", "totalTime", "e", "", "addressList", "", "hostName", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setCurrentNetworkStateType", "(Ljava/lang/String;)V", "currentNetworkStateType", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "c", "()Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "businessStrategy", "<init>", "(Lcom/tencent/libra/strategy/ILibraBaseStrategy;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentNetworkStateType = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ILibraBaseStrategy businessStrategy;

    public a(@Nullable ILibraBaseStrategy iLibraBaseStrategy) {
        this.businessStrategy = iLibraBaseStrategy;
    }

    public abstract void a(@NotNull List<InetAddress> addressList, @NotNull String hostName);

    public abstract void b();

    @Nullable
    /* renamed from: c, reason: from getter */
    public final ILibraBaseStrategy getBusinessStrategy() {
        return this.businessStrategy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCurrentNetworkStateType() {
        return this.currentNetworkStateType;
    }

    public abstract void e(@NotNull InetAddress inetAddress, long totalBytes, float totalTime);

    public abstract void f(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull IOException exception);

    public abstract void g(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress);

    public abstract void h(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress);

    public abstract boolean i();
}
