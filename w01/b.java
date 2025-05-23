package w01;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\r\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lw01/b;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setSuccessIpv4Address", "(Ljava/lang/String;)V", "successIpv4Address", "c", "setSuccessNetworkState", "successNetworkState", "setHostname", "hostname", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "libra-core_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String successIpv4Address;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String successNetworkState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String hostname;

    public b() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getHostname() {
        return this.hostname;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getSuccessIpv4Address() {
        return this.successIpv4Address;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getSuccessNetworkState() {
        return this.successNetworkState;
    }

    public b(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.successIpv4Address = str;
        this.successNetworkState = str2;
        this.hostname = str3;
    }

    public /* synthetic */ b(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
    }
}
