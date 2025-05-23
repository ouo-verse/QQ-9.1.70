package zb3;

import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010#\u001a\u00020\t\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\n\u0010\u0012R\"\u0010\u001f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b \u0010\u001eR\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u000b\u001a\u0004\b\u001c\u0010\r\"\u0004\b\"\u0010\u001e\u00a8\u0006&"}, d2 = {"Lzb3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", tl.h.F, "()J", "uin", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "materialUrl", "getCompressUrl", "compressUrl", "d", ZPlanPublishSource.FROM_SCHEME, "e", "headMontagePath", "f", "bodyMontagePath", "g", "j", "(J)V", "todayVotedCount", "i", "todayVailableVotedCount", "k", "totalVoted", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class FriendsDressUpData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long uin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String materialUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String compressUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String scheme;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String headMontagePath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String bodyMontagePath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long todayVotedCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long todayVailableVotedCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private long totalVoted;

    public FriendsDressUpData(long j3, @NotNull String materialUrl, @NotNull String compressUrl, @NotNull String scheme, @NotNull String headMontagePath, @NotNull String bodyMontagePath, long j16, long j17, long j18) {
        Intrinsics.checkNotNullParameter(materialUrl, "materialUrl");
        Intrinsics.checkNotNullParameter(compressUrl, "compressUrl");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(headMontagePath, "headMontagePath");
        Intrinsics.checkNotNullParameter(bodyMontagePath, "bodyMontagePath");
        this.uin = j3;
        this.materialUrl = materialUrl;
        this.compressUrl = compressUrl;
        this.scheme = scheme;
        this.headMontagePath = headMontagePath;
        this.bodyMontagePath = bodyMontagePath;
        this.todayVotedCount = j16;
        this.todayVailableVotedCount = j17;
        this.totalVoted = j18;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBodyMontagePath() {
        return this.bodyMontagePath;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getHeadMontagePath() {
        return this.headMontagePath;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMaterialUrl() {
        return this.materialUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* renamed from: e, reason: from getter */
    public final long getTodayVailableVotedCount() {
        return this.todayVailableVotedCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendsDressUpData)) {
            return false;
        }
        FriendsDressUpData friendsDressUpData = (FriendsDressUpData) other;
        if (this.uin == friendsDressUpData.uin && Intrinsics.areEqual(this.materialUrl, friendsDressUpData.materialUrl) && Intrinsics.areEqual(this.compressUrl, friendsDressUpData.compressUrl) && Intrinsics.areEqual(this.scheme, friendsDressUpData.scheme) && Intrinsics.areEqual(this.headMontagePath, friendsDressUpData.headMontagePath) && Intrinsics.areEqual(this.bodyMontagePath, friendsDressUpData.bodyMontagePath) && this.todayVotedCount == friendsDressUpData.todayVotedCount && this.todayVailableVotedCount == friendsDressUpData.todayVailableVotedCount && this.totalVoted == friendsDressUpData.totalVoted) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final long getTodayVotedCount() {
        return this.todayVotedCount;
    }

    /* renamed from: g, reason: from getter */
    public final long getTotalVoted() {
        return this.totalVoted;
    }

    /* renamed from: h, reason: from getter */
    public final long getUin() {
        return this.uin;
    }

    public int hashCode() {
        return (((((((((((((((androidx.fragment.app.a.a(this.uin) * 31) + this.materialUrl.hashCode()) * 31) + this.compressUrl.hashCode()) * 31) + this.scheme.hashCode()) * 31) + this.headMontagePath.hashCode()) * 31) + this.bodyMontagePath.hashCode()) * 31) + androidx.fragment.app.a.a(this.todayVotedCount)) * 31) + androidx.fragment.app.a.a(this.todayVailableVotedCount)) * 31) + androidx.fragment.app.a.a(this.totalVoted);
    }

    public final void i(long j3) {
        this.todayVailableVotedCount = j3;
    }

    public final void j(long j3) {
        this.todayVotedCount = j3;
    }

    public final void k(long j3) {
        this.totalVoted = j3;
    }

    @NotNull
    public String toString() {
        return "FriendsDressUpData(uin=" + this.uin + ", materialUrl=" + this.materialUrl + ", compressUrl=" + this.compressUrl + ", scheme=" + this.scheme + ", headMontagePath=" + this.headMontagePath + ", bodyMontagePath=" + this.bodyMontagePath + ", todayVotedCount=" + this.todayVotedCount + ", todayVailableVotedCount=" + this.todayVailableVotedCount + ", totalVoted=" + this.totalVoted + ')';
    }
}
