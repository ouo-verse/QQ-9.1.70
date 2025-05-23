package y01;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import com.tencent.libra.util.LibraConfigUtil;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u001e\u0010\u001c\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R&\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Ly01/b;", "Ly01/a;", "", "hostName", "ip", "", "j", "i", "", "b", "Lokhttp3/Call;", "call", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "g", h.F, "Ljava/io/IOException;", "exception", "f", "Ljava/net/InetAddress;", "inetAddress", "", "totalBytes", "", "totalTime", "e", "", "addressList", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "ipFailBlackListMap", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "businessStrategy", "<init>", "(Lcom/tencent/libra/strategy/ILibraBaseStrategy;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> ipFailBlackListMap;

    public b(@Nullable ILibraBaseStrategy iLibraBaseStrategy) {
        super(iLibraBaseStrategy);
        this.ipFailBlackListMap = new ConcurrentHashMap<>();
    }

    private final boolean j(String hostName, String ip5) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (!TextUtils.isEmpty(ip5) && (copyOnWriteArrayList = this.ipFailBlackListMap.get(hostName)) != null && copyOnWriteArrayList.contains(ip5)) {
            return true;
        }
        return false;
    }

    @Override // y01.a
    public void a(@NotNull List<InetAddress> addressList, @NotNull String hostName) {
        boolean z16;
        Intrinsics.checkNotNullParameter(addressList, "addressList");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        if (!addressList.isEmpty()) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = this.ipFailBlackListMap.get(hostName);
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                Iterator<InetAddress> it = addressList.iterator();
                ArrayList arrayList = new ArrayList();
                while (it.hasNext()) {
                    InetAddress next = it.next();
                    if (j(hostName, next.getHostAddress())) {
                        it.remove();
                        arrayList.add(next);
                    }
                }
                if (addressList.isEmpty()) {
                    RFWLog.e("LibraPicIpBlackListStrategy", RFWLog.CLR, "all ips are in black list, clear map");
                    this.ipFailBlackListMap.remove(hostName);
                }
                addressList.addAll(arrayList);
            }
        }
    }

    @Override // y01.a
    public void b() {
        this.ipFailBlackListMap.clear();
    }

    @Override // y01.a
    public void e(@NotNull InetAddress inetAddress, long totalBytes, float totalTime) {
        Intrinsics.checkNotNullParameter(inetAddress, "inetAddress");
    }

    @Override // y01.a
    public void f(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull IOException exception) {
        boolean z16;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(exception, "exception");
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "inetSocketAddress.address");
        String hostAddress = address.getHostAddress();
        if (hostAddress != null) {
            String host = call.request().url().host();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = this.ipFailBlackListMap.get(host);
            if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = this.ipFailBlackListMap.get(host);
                Intrinsics.checkNotNull(copyOnWriteArrayList2);
                if (!copyOnWriteArrayList2.contains(hostAddress)) {
                    CopyOnWriteArrayList<String> copyOnWriteArrayList3 = this.ipFailBlackListMap.get(host);
                    Intrinsics.checkNotNull(copyOnWriteArrayList3);
                    copyOnWriteArrayList3.add(hostAddress);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap = this.ipFailBlackListMap;
            CopyOnWriteArrayList<String> copyOnWriteArrayList4 = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList4.add(hostAddress);
            Unit unit = Unit.INSTANCE;
            concurrentHashMap.put(host, copyOnWriteArrayList4);
        }
    }

    @Override // y01.a
    public void g(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
    }

    @Override // y01.a
    public void h(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "inetSocketAddress.address");
        String hostAddress = address.getHostAddress();
        if (hostAddress != null) {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = this.ipFailBlackListMap.get(call.request().url().host());
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(hostAddress);
            }
        }
    }

    @Override // y01.a
    public boolean i() {
        ILibraBaseStrategy businessStrategy;
        w01.a libraIpStrategyBean;
        if (LibraConfigUtil.INSTANCE.enableIpFailBlacklist() && (businessStrategy = getBusinessStrategy()) != null && (libraIpStrategyBean = businessStrategy.getLibraIpStrategyBean()) != null && libraIpStrategyBean.getIsSupportIpBlacklist()) {
            return true;
        }
        return false;
    }
}
