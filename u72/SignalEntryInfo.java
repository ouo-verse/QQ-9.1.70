package u72;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.mobileqq.matchfriend.aio.foreground.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\n\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lu72/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getPartnerId", "()J", "partnerId", "b", "Ljava/lang/String;", "getPartnerName", "()Ljava/lang/String;", "partnerName", "c", "getTtl", RemoteMessageConst.TTL, "d", "Z", "getShowAnim", "()Z", "(Z)V", "showAnim", "<init>", "(JLjava/lang/String;JZ)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u72.c, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class SignalEntryInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long partnerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String partnerName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long ttl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean showAnim;

    public SignalEntryInfo() {
        this(0L, null, 0L, false, 15, null);
    }

    public final void a(boolean z16) {
        this.showAnim = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a16 = ((((g.a(this.partnerId) * 31) + this.partnerName.hashCode()) * 31) + g.a(this.ttl)) * 31;
        boolean z16 = this.showAnim;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return a16 + i3;
    }

    public String toString() {
        return "SignalEntryInfo(partnerId=" + this.partnerId + ", partnerName=" + this.partnerName + ", ttl=" + this.ttl + ", showAnim=" + this.showAnim + ")";
    }

    public SignalEntryInfo(long j3, String partnerName, long j16, boolean z16) {
        Intrinsics.checkNotNullParameter(partnerName, "partnerName");
        this.partnerId = j3;
        this.partnerName = partnerName;
        this.ttl = j16;
        this.showAnim = z16;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignalEntryInfo)) {
            return false;
        }
        SignalEntryInfo signalEntryInfo = (SignalEntryInfo) other;
        return this.partnerId == signalEntryInfo.partnerId && Intrinsics.areEqual(this.partnerName, signalEntryInfo.partnerName) && this.ttl == signalEntryInfo.ttl && this.showAnim == signalEntryInfo.showAnim;
    }

    public /* synthetic */ SignalEntryInfo(long j3, String str, long j16, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "" : str, (i3 & 4) == 0 ? j16 : 0L, (i3 & 8) != 0 ? false : z16);
    }
}
