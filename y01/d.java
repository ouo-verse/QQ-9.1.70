package y01;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.strategy.ILibraBaseStrategy;
import com.tencent.libra.util.LibraConfigUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u00018B\u0011\u0012\b\u0010?\u001a\u0004\u0018\u00010>\u00a2\u0006\u0004\b@\u0010AJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u0010\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u001d\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\"\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010!\u001a\u00020\u0004H\u0002J:\u0010%\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010&\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\u0006H\u0016J\u0018\u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J\u0018\u0010.\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J \u00101\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u00100\u001a\u00020/H\u0016J \u00107\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u001f2\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u000205H\u0016J\u001e\u00108\u001a\u00020\u00062\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0018098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010;\u00a8\u0006B"}, d2 = {"Ly01/d;", "Ly01/a;", "Ljava/net/Inet4Address;", "ipv4Address", "", "hostName", "", "k", "Ljava/net/Inet6Address;", "ipv6Address", "j", "", "inet4AddressList", "", ReportConstant.COSTREPORT_PREFIX, "inet6AddressList", "t", "currentHostAddress", "networkState", "ipAddress", "logMessage", "o", "failOrSuccessHostName", DomainData.DOMAIN_NAME, "Lw01/c;", "ipv6FailInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lw01/b;", "ipv4SuccessInfo", "p", "", "Ljava/net/InetAddress;", "addressList", "hostname", "r", "ipv6AddressList", "ipv4AddressList", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "b", "Lokhttp3/Call;", "call", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "g", h.F, "Ljava/io/IOException;", "exception", "f", "inetAddress", "", "totalBytes", "", "totalTime", "e", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "ipv6FailDomainMap", "ipv4SuccessDomainMap", "Lcom/tencent/libra/strategy/ILibraBaseStrategy;", "businessStrategy", "<init>", "(Lcom/tencent/libra/strategy/ILibraBaseStrategy;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class d extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, w01.c> ipv6FailDomainMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, w01.b> ipv4SuccessDomainMap;

    public d(@Nullable ILibraBaseStrategy iLibraBaseStrategy) {
        super(iLibraBaseStrategy);
        this.ipv6FailDomainMap = new ConcurrentHashMap<>();
        this.ipv4SuccessDomainMap = new ConcurrentHashMap<>();
    }

    private final void j(Inet6Address ipv6Address, String hostName) {
        if (TextUtils.isEmpty(getCurrentNetworkStateType())) {
            return;
        }
        if (TextUtils.isEmpty(ipv6Address.getHostAddress())) {
            RFWLog.e("LibraPicIpv6AndIpv4InterweaveStrategy", RFWLog.CLR, "ipv6 host address is empty");
            return;
        }
        if (!LibraConfigUtil.INSTANCE.enableDnsNotTryIpv6AfterFail()) {
            return;
        }
        w01.c cVar = new w01.c(ipv6Address.getHostAddress(), getCurrentNetworkStateType(), hostName);
        ConcurrentHashMap<String, w01.c> concurrentHashMap = this.ipv6FailDomainMap;
        String hostAddress = ipv6Address.getHostAddress();
        Intrinsics.checkNotNull(hostAddress);
        concurrentHashMap.put(hostAddress, cVar);
    }

    private final void k(Inet4Address ipv4Address, String hostName) {
        if (TextUtils.isEmpty(getCurrentNetworkStateType())) {
            return;
        }
        if (TextUtils.isEmpty(ipv4Address.getHostAddress())) {
            RFWLog.e("LibraPicIpv6AndIpv4InterweaveStrategy", RFWLog.CLR, "ipv4 host address is empty");
            return;
        }
        w01.b bVar = new w01.b(ipv4Address.getHostAddress(), getCurrentNetworkStateType(), hostName);
        ConcurrentHashMap<String, w01.b> concurrentHashMap = this.ipv4SuccessDomainMap;
        String hostAddress = ipv4Address.getHostAddress();
        Intrinsics.checkNotNull(hostAddress);
        concurrentHashMap.put(hostAddress, bVar);
    }

    private final boolean l(List<InetAddress> addressList, List<Inet6Address> ipv6AddressList, List<Inet4Address> ipv4AddressList, String hostName) {
        if (!LibraConfigUtil.INSTANCE.enableDnsNotTryIpv6AfterFail() || ipv6AddressList.isEmpty() || ipv4AddressList.isEmpty() || !q(ipv6AddressList, ipv4AddressList, hostName)) {
            return false;
        }
        addressList.clear();
        addressList.addAll(ipv4AddressList);
        addressList.addAll(ipv6AddressList);
        return true;
    }

    private final boolean m(String currentHostAddress, w01.c ipv6FailInfo, String hostName) {
        String str = "ipv6 address is " + ipv6FailInfo.getFailIpv6Address() + ", fail network state is " + ipv6FailInfo.getFailNetworkState() + ", current network state is " + getCurrentNetworkStateType() + ", current host address is " + currentHostAddress + ", host name is " + hostName;
        if (n(hostName, ipv6FailInfo.getHostname()) && o(currentHostAddress, ipv6FailInfo.getFailNetworkState(), ipv6FailInfo.getFailIpv6Address(), str)) {
            return true;
        }
        return false;
    }

    private final boolean n(String hostName, String failOrSuccessHostName) {
        if (!RFWConfig.getConfigValue("enable_ipv4_first_policy_with_hostname_check", true) || TextUtils.equals(hostName, failOrSuccessHostName)) {
            return true;
        }
        return false;
    }

    private final boolean o(String currentHostAddress, String networkState, String ipAddress, String logMessage) {
        if (TextUtils.isEmpty(getCurrentNetworkStateType()) || TextUtils.isEmpty(networkState) || TextUtils.isEmpty(ipAddress) || TextUtils.isEmpty(currentHostAddress) || !TextUtils.equals(ipAddress, currentHostAddress)) {
            return false;
        }
        RFWLog.i("LibraPicIpv6AndIpv4InterweaveStrategy", RFWLog.CLR, logMessage);
        return TextUtils.equals(networkState, getCurrentNetworkStateType());
    }

    private final boolean p(String currentHostAddress, w01.b ipv4SuccessInfo, String hostName) {
        String str = "ipv4 address is " + ipv4SuccessInfo.getSuccessIpv4Address() + ", success network state is " + ipv4SuccessInfo.getSuccessNetworkState() + ", current network state is " + getCurrentNetworkStateType() + ", current host address is " + currentHostAddress + ", host name is " + hostName;
        if (n(hostName, ipv4SuccessInfo.getHostname()) && o(currentHostAddress, ipv4SuccessInfo.getSuccessNetworkState(), ipv4SuccessInfo.getSuccessIpv4Address(), str)) {
            return true;
        }
        return false;
    }

    private final boolean q(List<Inet6Address> ipv6AddressList, List<Inet4Address> ipv4AddressList, String hostName) {
        if (t(ipv6AddressList, hostName) && s(ipv4AddressList, hostName)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(List<InetAddress> addressList, String hostname) {
        List<InetAddress> list = addressList;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof Inet6Address) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (obj2 instanceof Inet4Address) {
                arrayList2.add(obj2);
            }
        }
        if (l(addressList, arrayList, arrayList2, hostname)) {
            RFWLog.i("LibraPicIpv6AndIpv4InterweaveStrategy", RFWLog.CLR, "use ipv4 first policy");
            return;
        }
        addressList.clear();
        Iterator it = arrayList.iterator();
        Iterator it5 = arrayList2.iterator();
        if (it.hasNext()) {
            addressList.add(it.next());
        }
        while (true) {
            if (!it.hasNext() && !it5.hasNext()) {
                return;
            }
            if (it5.hasNext()) {
                addressList.add(it5.next());
            }
            if (it.hasNext()) {
                addressList.add(it.next());
            }
        }
    }

    private final boolean s(List<Inet4Address> inet4AddressList, String hostName) {
        if (TextUtils.isEmpty(getCurrentNetworkStateType()) || this.ipv4SuccessDomainMap.isEmpty() || inet4AddressList.isEmpty()) {
            return false;
        }
        Iterator<Inet4Address> it = inet4AddressList.iterator();
        while (it.hasNext()) {
            String hostAddress = it.next().getHostAddress();
            if (TextUtils.isEmpty(hostAddress)) {
                RFWLog.e("LibraPicIpv6AndIpv4InterweaveStrategy", RFWLog.USR, "host address is empty");
            } else {
                Iterator<Map.Entry<String, w01.b>> it5 = this.ipv4SuccessDomainMap.entrySet().iterator();
                while (it5.hasNext()) {
                    w01.b value = it5.next().getValue();
                    Intrinsics.checkNotNull(hostAddress);
                    if (p(hostAddress, value, hostName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final boolean t(List<Inet6Address> inet6AddressList, String hostName) {
        if (TextUtils.isEmpty(getCurrentNetworkStateType()) || this.ipv6FailDomainMap.isEmpty() || inet6AddressList.isEmpty()) {
            return false;
        }
        Iterator<Inet6Address> it = inet6AddressList.iterator();
        while (it.hasNext()) {
            String hostAddress = it.next().getHostAddress();
            if (TextUtils.isEmpty(hostAddress)) {
                RFWLog.e("LibraPicIpv6AndIpv4InterweaveStrategy", RFWLog.USR, "host address is empty");
            } else {
                Iterator<Map.Entry<String, w01.c>> it5 = this.ipv6FailDomainMap.entrySet().iterator();
                while (it5.hasNext()) {
                    w01.c value = it5.next().getValue();
                    Intrinsics.checkNotNull(hostAddress);
                    if (m(hostAddress, value, hostName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // y01.a
    public void a(@NotNull List<InetAddress> addressList, @NotNull String hostName) {
        Intrinsics.checkNotNullParameter(addressList, "addressList");
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        r(addressList, hostName);
    }

    @Override // y01.a
    public void b() {
        this.ipv6FailDomainMap.clear();
        this.ipv4SuccessDomainMap.clear();
    }

    @Override // y01.a
    public void e(@NotNull InetAddress inetAddress, long totalBytes, float totalTime) {
        Intrinsics.checkNotNullParameter(inetAddress, "inetAddress");
    }

    @Override // y01.a
    public void f(@NotNull Call call, @NotNull InetSocketAddress inetSocketAddress, @NotNull IOException exception) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(exception, "exception");
        if ((exception instanceof SocketException) || (exception instanceof SocketTimeoutException)) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address instanceof Inet6Address) {
                j((Inet6Address) address, call.request().url().host());
            }
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
        if (address instanceof Inet4Address) {
            k((Inet4Address) address, call.request().url().host());
        }
    }

    @Override // y01.a
    public boolean i() {
        ILibraBaseStrategy businessStrategy;
        w01.a libraIpStrategyBean;
        if (LibraConfigUtil.INSTANCE.isSortByInetPhotoAlternately() && (businessStrategy = getBusinessStrategy()) != null && (libraIpStrategyBean = businessStrategy.getLibraIpStrategyBean()) != null && libraIpStrategyBean.getIsSupportIpv6AndIpv4Interweave()) {
            return true;
        }
        return false;
    }
}
