package vh1;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\n\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001f\u001a\u0004\b\u000f\u0010 \u00a8\u0006$"}, d2 = {"Lvh1/g;", "Lvh1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "guildId", "b", "c", "guildAvatarUrl", "e", "guildName", "f", "joinGuildSig", "I", "()I", "confId", "Z", "g", "()Z", "isLittleWorldCreate", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "Ljava/util/List;", "()Ljava/util/List;", "featuredGuilds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vh1.g, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class NavFeaturedItemData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildAvatarUrl;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String joinGuildSig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int confId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isLittleWorldCreate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProRecommendItem> featuredGuilds;

    /* JADX WARN: Multi-variable type inference failed */
    public NavFeaturedItemData(@NotNull String guildId, @NotNull String guildAvatarUrl, @NotNull String guildName, @NotNull String joinGuildSig, int i3, boolean z16, @NotNull List<? extends IGProRecommendItem> featuredGuilds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildAvatarUrl, "guildAvatarUrl");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        Intrinsics.checkNotNullParameter(featuredGuilds, "featuredGuilds");
        this.guildId = guildId;
        this.guildAvatarUrl = guildAvatarUrl;
        this.guildName = guildName;
        this.joinGuildSig = joinGuildSig;
        this.confId = i3;
        this.isLittleWorldCreate = z16;
        this.featuredGuilds = featuredGuilds;
    }

    /* renamed from: a, reason: from getter */
    public final int getConfId() {
        return this.confId;
    }

    @NotNull
    public final List<IGProRecommendItem> b() {
        return this.featuredGuilds;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildAvatarUrl() {
        return this.guildAvatarUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavFeaturedItemData)) {
            return false;
        }
        NavFeaturedItemData navFeaturedItemData = (NavFeaturedItemData) other;
        if (Intrinsics.areEqual(this.guildId, navFeaturedItemData.guildId) && Intrinsics.areEqual(this.guildAvatarUrl, navFeaturedItemData.guildAvatarUrl) && Intrinsics.areEqual(this.guildName, navFeaturedItemData.guildName) && Intrinsics.areEqual(this.joinGuildSig, navFeaturedItemData.joinGuildSig) && this.confId == navFeaturedItemData.confId && this.isLittleWorldCreate == navFeaturedItemData.isLittleWorldCreate && Intrinsics.areEqual(this.featuredGuilds, navFeaturedItemData.featuredGuilds)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsLittleWorldCreate() {
        return this.isLittleWorldCreate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.guildId.hashCode() * 31) + this.guildAvatarUrl.hashCode()) * 31) + this.guildName.hashCode()) * 31) + this.joinGuildSig.hashCode()) * 31) + this.confId) * 31;
        boolean z16 = this.isLittleWorldCreate;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.featuredGuilds.hashCode();
    }

    @NotNull
    public String toString() {
        return "NavFeaturedItemData(guildId=" + this.guildId + ", guildAvatarUrl=" + this.guildAvatarUrl + ", guildName=" + this.guildName + ", joinGuildSig=" + this.joinGuildSig + ", confId=" + this.confId + ", isLittleWorldCreate=" + this.isLittleWorldCreate + ", featuredGuilds=" + this.featuredGuilds + ")";
    }
}
