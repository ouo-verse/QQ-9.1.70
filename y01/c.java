package y01;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\"\u000eB\u0011\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b,\u0010-J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001e\u0010\"\u001a\u00020\b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u001f2\u0006\u0010!\u001a\u00020\u0002H\u0016R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010%R,\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050#0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R,\u0010)\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050#0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010%\u00a8\u0006."}, d2 = {"Ly01/c;", "Ly01/a;", "", "domain", "ip", "Ly01/c$b;", "k", "ipStandardInfo", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "i", "b", "Lokhttp3/Call;", "call", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "g", h.F, "Ljava/io/IOException;", "exception", "f", "Ljava/net/InetAddress;", "inetAddress", "", "totalBytes", "", "totalTime", "e", "", "addressList", "hostName", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "okHttpCallMap", "preferredIpMap", "obsoleteIpMap", "ipStandardInfoMap", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "businessStrategy", "<init>", "(Lcom/tencent/libra/strategy/ILibraBaseStrategy;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, Long> okHttpCallMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, String> preferredIpMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, IpStandardInfo>> obsoleteIpMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, IpStandardInfo>> ipStandardInfoMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\"\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Ly01/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "b", "()J", "d", "(J)V", "tcpConsumingTimeInMs", "c", "downloadSpeedInKb", "<init>", "(JJ)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: y01.c$b, reason: from toString */
    /* loaded from: classes7.dex */
    public static final /* data */ class IpStandardInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private long tcpConsumingTimeInMs;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long downloadSpeedInKb;

        public IpStandardInfo() {
            this(0L, 0L, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final long getDownloadSpeedInKb() {
            return this.downloadSpeedInKb;
        }

        /* renamed from: b, reason: from getter */
        public final long getTcpConsumingTimeInMs() {
            return this.tcpConsumingTimeInMs;
        }

        public final void c(long j3) {
            this.downloadSpeedInKb = j3;
        }

        public final void d(long j3) {
            this.tcpConsumingTimeInMs = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof IpStandardInfo) {
                    IpStandardInfo ipStandardInfo = (IpStandardInfo) other;
                    if (this.tcpConsumingTimeInMs != ipStandardInfo.tcpConsumingTimeInMs || this.downloadSpeedInKb != ipStandardInfo.downloadSpeedInKb) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (androidx.fragment.app.a.a(this.tcpConsumingTimeInMs) * 31) + androidx.fragment.app.a.a(this.downloadSpeedInKb);
        }

        @NotNull
        public String toString() {
            return "IpStandardInfo(tcpConsumingTimeInMs=" + this.tcpConsumingTimeInMs + ", downloadSpeedInKb=" + this.downloadSpeedInKb + ")";
        }

        public IpStandardInfo(long j3, long j16) {
            this.tcpConsumingTimeInMs = j3;
            this.downloadSpeedInKb = j16;
        }

        public /* synthetic */ IpStandardInfo(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? -1L : j3, (i3 & 2) != 0 ? -1L : j16);
        }
    }

    public c(@Nullable ILibraBaseStrategy iLibraBaseStrategy) {
        super(iLibraBaseStrategy);
        this.okHttpCallMap = new ConcurrentHashMap<>();
        this.preferredIpMap = new ConcurrentHashMap<>();
        this.obsoleteIpMap = new ConcurrentHashMap<>();
        this.ipStandardInfoMap = new ConcurrentHashMap<>();
    }

    private final boolean j(String ip5, IpStandardInfo ipStandardInfo) {
        int i3;
        int i16;
        w01.a libraIpStrategyBean;
        w01.a libraIpStrategyBean2;
        ILibraBaseStrategy businessStrategy = getBusinessStrategy();
        if (businessStrategy != null && (libraIpStrategyBean2 = businessStrategy.getLibraIpStrategyBean()) != null) {
            i3 = libraIpStrategyBean2.getMaxTcpConsumingTimeInMs();
        } else {
            i3 = 300;
        }
        ILibraBaseStrategy businessStrategy2 = getBusinessStrategy();
        if (businessStrategy2 != null && (libraIpStrategyBean = businessStrategy2.getLibraIpStrategyBean()) != null) {
            i16 = libraIpStrategyBean.getMinDownloadSpeedStandardInKb();
        } else {
            i16 = 800;
        }
        RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "ip is " + ip5 + ", tcp connection time is " + ipStandardInfo.getTcpConsumingTimeInMs() + ", download speed is " + ipStandardInfo.getDownloadSpeedInKb());
        if (ipStandardInfo.getTcpConsumingTimeInMs() < i3 && ipStandardInfo.getDownloadSpeedInKb() > i16) {
            return true;
        }
        return false;
    }

    private final IpStandardInfo k(String domain, String ip5) {
        boolean z16;
        IpStandardInfo putIfAbsent;
        ConcurrentHashMap<String, IpStandardInfo> putIfAbsent2;
        boolean z17 = true;
        if (domain.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (ip5.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                ConcurrentHashMap<String, ConcurrentHashMap<String, IpStandardInfo>> concurrentHashMap = this.ipStandardInfoMap;
                ConcurrentHashMap<String, IpStandardInfo> concurrentHashMap2 = concurrentHashMap.get(domain);
                if (concurrentHashMap2 == null && (putIfAbsent2 = concurrentHashMap.putIfAbsent(domain, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
                    concurrentHashMap2 = putIfAbsent2;
                }
                ConcurrentHashMap<String, IpStandardInfo> downloadInfoMapByDomain = concurrentHashMap2;
                Intrinsics.checkNotNullExpressionValue(downloadInfoMapByDomain, "downloadInfoMapByDomain");
                IpStandardInfo ipStandardInfo = downloadInfoMapByDomain.get(ip5);
                if (ipStandardInfo == null && (putIfAbsent = downloadInfoMapByDomain.putIfAbsent(ip5, (ipStandardInfo = new IpStandardInfo(0L, 0L)))) != null) {
                    ipStandardInfo = putIfAbsent;
                }
                return ipStandardInfo;
            }
            return null;
        }
        return null;
    }

    private final void l(String domain, String ip5, IpStandardInfo ipStandardInfo) {
        boolean z16;
        ConcurrentHashMap<String, IpStandardInfo> putIfAbsent;
        boolean z17 = true;
        if (domain.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (ip5.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                ConcurrentHashMap<String, ConcurrentHashMap<String, IpStandardInfo>> concurrentHashMap = this.obsoleteIpMap;
                ConcurrentHashMap<String, IpStandardInfo> concurrentHashMap2 = concurrentHashMap.get(domain);
                if (concurrentHashMap2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(domain, (concurrentHashMap2 = new ConcurrentHashMap<>()))) != null) {
                    concurrentHashMap2 = putIfAbsent;
                }
                ConcurrentHashMap<String, IpStandardInfo> obsoleteIpMapByDomain = concurrentHashMap2;
                Intrinsics.checkNotNullExpressionValue(obsoleteIpMapByDomain, "obsoleteIpMapByDomain");
                obsoleteIpMapByDomain.put(ip5, ipStandardInfo);
            }
        }
    }

    private final void m(IpStandardInfo ipStandardInfo) {
        ipStandardInfo.c(-1L);
        ipStandardInfo.d(-1L);
    }

    @Override // y01.a
    public void a(@NotNull List<InetAddress> addressList, @NotNull String hostName) {
        boolean z16;
        InetAddress next;
        String hostAddress;
        Intrinsics.checkNotNullParameter(addressList, "addressList");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        Iterator it = addressList.iterator();
        while (it.hasNext()) {
            sb5.append(((InetAddress) it.next()).getHostAddress());
            sb5.append(", ");
        }
        RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "ipStringBeforeStrategy is " + sb5.toString());
        String str = this.preferredIpMap.get(hostName);
        ConcurrentHashMap<String, IpStandardInfo> concurrentHashMap = this.obsoleteIpMap.get(hostName);
        if (!addressList.isEmpty()) {
            boolean z17 = false;
            if (hostName.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && str != null) {
                Iterator<InetAddress> it5 = addressList.iterator();
                int i3 = 0;
                while (true) {
                    if (it5.hasNext()) {
                        if (Intrinsics.areEqual(it5.next().getHostAddress(), str)) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 != -1) {
                    RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "preferred ip is " + str);
                    addressList.add(0, addressList.remove(i3));
                    Iterator it6 = addressList.iterator();
                    while (it6.hasNext()) {
                        sb6.append(((InetAddress) it6.next()).getHostAddress());
                        sb6.append(", ");
                    }
                    RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "ipStringAfterStrategy is " + sb6.toString());
                    return;
                }
                if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                    z17 = true;
                }
                if (z17) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<InetAddress> it7 = addressList.iterator();
                while (it7.hasNext() && (hostAddress = (next = it7.next()).getHostAddress()) != null && concurrentHashMap.containsKey(hostAddress)) {
                    it7.remove();
                    arrayList.add(next);
                }
                addressList.addAll(arrayList);
                Iterator it8 = addressList.iterator();
                while (it8.hasNext()) {
                    sb6.append(((InetAddress) it8.next()).getHostAddress());
                    sb6.append(", ");
                }
                RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "ipStringAfterStrategy is " + sb6.toString());
            }
        }
    }

    @Override // y01.a
    public void b() {
        this.okHttpCallMap.clear();
        this.preferredIpMap.clear();
        this.ipStandardInfoMap.clear();
        this.obsoleteIpMap.clear();
    }

    @Override // y01.a
    public void e(@NotNull InetAddress inetAddress, long totalBytes, float totalTime) {
        Intrinsics.checkNotNullParameter(inetAddress, "inetAddress");
        try {
            String hostAddress = inetAddress.getHostAddress();
            if (hostAddress == null) {
                hostAddress = "";
            }
            String domain = inetAddress.getHostName();
            if (!TextUtils.isEmpty(hostAddress) && totalBytes > 0 && totalTime > ((float) 0)) {
                long j3 = (((float) totalBytes) / totalTime) / 1024;
                RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "[BytesReadDone] | remote ip is " + hostAddress + ", total bytes is " + totalBytes + ", total time is " + totalTime + ", average download speed is " + j3);
                Intrinsics.checkNotNullExpressionValue(domain, "domain");
                IpStandardInfo k3 = k(domain, hostAddress);
                if (k3 != null) {
                    k3.c(j3);
                    if (j(hostAddress, k3)) {
                        this.preferredIpMap.put(domain, hostAddress);
                        RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "ip meets the standard, domain is " + domain + ", ip is " + hostAddress);
                        return;
                    }
                    if (TextUtils.equals(this.preferredIpMap.get(domain), hostAddress)) {
                        this.preferredIpMap.remove(domain);
                    }
                    l(domain, hostAddress, k3);
                    RFWLog.i("LibraPicIpRaceStrategy", RFWLog.USR, "ip does not meet the standard, domain is " + domain + ", ip is " + hostAddress);
                    return;
                }
                return;
            }
            RFWLog.e("LibraPicIpRaceStrategy", RFWLog.CLR, "[BytesReadException] | remote ip is " + hostAddress + ", total bytes is " + totalBytes + ", total time is " + totalTime);
        } catch (Exception e16) {
            RFWLog.e("LibraPicIpRaceStrategy", RFWLog.USR, "exception is " + e16);
        }
    }

    @Override // y01.a
    public void f(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull IOException exception) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(exception, "exception");
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "inetSocketAddress.address");
        String hostName = address.getHostName();
        String str = "";
        if (hostName == null) {
            hostName = "";
        }
        InetAddress address2 = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "inetSocketAddress.address");
        String hostAddress = address2.getHostAddress();
        if (hostAddress != null) {
            str = hostAddress;
        }
        boolean z16 = true;
        RFWLog.e("LibraPicIpRaceStrategy", RFWLog.CLR, "[handleOkHttpConnectFail] | domain is " + hostName + ", ip is " + str);
        IpStandardInfo k3 = k(hostName, str);
        if (k3 != null) {
            m(k3);
        }
        String str2 = this.preferredIpMap.get(hostName);
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        }
        if (!z16 && TextUtils.equals(this.preferredIpMap.get(hostName), str)) {
            this.preferredIpMap.remove(hostName);
        }
    }

    @Override // y01.a
    public void g(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        String valueOf = String.valueOf(call.hashCode());
        this.okHttpCallMap.put(valueOf, Long.valueOf(System.nanoTime()));
        RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "[connectStart] | call hashCode is " + valueOf + ", start time is " + this.okHttpCallMap.get(valueOf));
    }

    @Override // y01.a
    public void h(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        String valueOf = String.valueOf(call.hashCode());
        long nanoTime = System.nanoTime();
        Long l3 = this.okHttpCallMap.get(valueOf);
        if (l3 == null) {
            RFWLog.e("LibraPicIpRaceStrategy", RFWLog.CLR, "call hashCode is " + valueOf);
            return;
        }
        this.okHttpCallMap.remove(valueOf);
        RFWLog.i("LibraPicIpRaceStrategy", RFWLog.DEV, "[connectEnd] | call hashCode is " + valueOf + ", start time is " + l3 + ", end time is " + nanoTime);
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "inetSocketAddress.address");
        String hostName = address.getHostName();
        String str = "";
        if (hostName == null) {
            hostName = "";
        }
        InetAddress address2 = inetSocketAddress.getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "inetSocketAddress.address");
        String hostAddress = address2.getHostAddress();
        if (hostAddress != null) {
            str = hostAddress;
        }
        IpStandardInfo k3 = k(hostName, str);
        if (k3 != null) {
            k3.d(TimeUnit.NANOSECONDS.toMillis(nanoTime - l3.longValue()));
        }
    }

    @Override // y01.a
    public boolean i() {
        ILibraBaseStrategy businessStrategy;
        w01.a libraIpStrategyBean;
        if (LibraConfigUtil.INSTANCE.enableIpRaceStrategy() && (businessStrategy = getBusinessStrategy()) != null && (libraIpStrategyBean = businessStrategy.getLibraIpStrategyBean()) != null && libraIpStrategyBean.getIsSupportIpRaceStrategy()) {
            return true;
        }
        return false;
    }
}
