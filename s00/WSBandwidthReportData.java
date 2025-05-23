package s00;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001a\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0019\u0010\u0012R\"\u0010\u001c\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u001b\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Ls00/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "host", "", "b", "J", "()J", "f", "(J)V", "httpBw", "c", "e", "i", "pcdnBw", "d", "g", "p2pBw", h.F, "p2pUploadBw", "<init>", "(Ljava/lang/String;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: s00.d, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class WSBandwidthReportData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String host;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long httpBw;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long pcdnBw;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long p2pBw;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long p2pUploadBw;

    public WSBandwidthReportData(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
    }

    /* renamed from: a, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: b, reason: from getter */
    public final long getHttpBw() {
        return this.httpBw;
    }

    /* renamed from: c, reason: from getter */
    public final long getP2pBw() {
        return this.p2pBw;
    }

    /* renamed from: d, reason: from getter */
    public final long getP2pUploadBw() {
        return this.p2pUploadBw;
    }

    /* renamed from: e, reason: from getter */
    public final long getPcdnBw() {
        return this.pcdnBw;
    }

    public final void f(long j3) {
        this.httpBw = j3;
    }

    public final void g(long j3) {
        this.p2pBw = j3;
    }

    public final void h(long j3) {
        this.p2pUploadBw = j3;
    }

    public int hashCode() {
        return this.host.hashCode();
    }

    public final void i(long j3) {
        this.pcdnBw = j3;
    }

    public String toString() {
        return "WSBandwidthReportData(host=" + this.host + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof WSBandwidthReportData) && Intrinsics.areEqual(this.host, ((WSBandwidthReportData) other).host);
    }
}
