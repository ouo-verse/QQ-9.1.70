package xq1;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGlobalBanner;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lxq1/a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGlobalBanner;", "globalBanner", "", "d", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGlobalBanner;", "c", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGlobalBanner;", "channelId", "bannerId", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGlobalBanner;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xq1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class Announcement {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IGProGlobalBanner globalBanner;

    public Announcement(@NotNull String guildId, @Nullable IGProGlobalBanner iGProGlobalBanner) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.globalBanner = iGProGlobalBanner;
    }

    private final String d(IGProGlobalBanner globalBanner) {
        if (globalBanner == null) {
            return "";
        }
        return "bannerId: " + globalBanner.getBannerId() + ", bizId: " + globalBanner.getBizId() + ", opTime: " + globalBanner.getOperateTime() + ", opTinyId: " + globalBanner.getOperatorTinyId() + ", gameDownloadInfo: " + globalBanner.getBannerGameDownloadeInfo();
    }

    @NotNull
    public final String a() {
        String str;
        IGProGlobalBanner iGProGlobalBanner = this.globalBanner;
        if (iGProGlobalBanner != null) {
            str = iGProGlobalBanner.getBannerId();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String b() {
        Long l3;
        IGProGuildBannerBizId bizId;
        IGProGlobalBanner iGProGlobalBanner = this.globalBanner;
        if (iGProGlobalBanner != null && (bizId = iGProGlobalBanner.getBizId()) != null) {
            l3 = Long.valueOf(bizId.getChannelId());
        } else {
            l3 = null;
        }
        return String.valueOf(l3);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final IGProGlobalBanner getGlobalBanner() {
        return this.globalBanner;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Announcement)) {
            return false;
        }
        Announcement announcement = (Announcement) other;
        if (Intrinsics.areEqual(this.guildId, announcement.guildId) && Intrinsics.areEqual(this.globalBanner, announcement.globalBanner)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.guildId.hashCode() * 31;
        IGProGlobalBanner iGProGlobalBanner = this.globalBanner;
        if (iGProGlobalBanner == null) {
            hashCode = 0;
        } else {
            hashCode = iGProGlobalBanner.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "Announcement(guildId='" + this.guildId + "', globalBanner=" + d(this.globalBanner) + ", channelId='" + b() + "', bannerId='" + a() + "')";
    }
}
