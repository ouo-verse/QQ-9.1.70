package w01;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lw01/c;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "setFailIpv6Address", "(Ljava/lang/String;)V", "failIpv6Address", "b", "setFailNetworkState", "failNetworkState", "c", "setHostname", "hostname", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String failIpv6Address;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String failNetworkState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String hostname;

    public c() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getFailIpv6Address() {
        return this.failIpv6Address;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getFailNetworkState() {
        return this.failNetworkState;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getHostname() {
        return this.hostname;
    }

    public c(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.failIpv6Address = str;
        this.failNetworkState = str2;
        this.hostname = str3;
    }

    public /* synthetic */ c(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
    }
}
