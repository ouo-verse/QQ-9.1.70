package vh1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\n\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0016\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lvh1/d;", "Lvh1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "guildAvatarUrl", "d", "guildName", "I", "()I", "confId", "e", "joinGuildSig", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vh1.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class NavCategoryFeaturedItemData extends a {

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
    private final int confId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String joinGuildSig;

    public NavCategoryFeaturedItemData(@NotNull String guildId, @NotNull String guildAvatarUrl, @NotNull String guildName, int i3, @NotNull String joinGuildSig) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildAvatarUrl, "guildAvatarUrl");
        Intrinsics.checkNotNullParameter(guildName, "guildName");
        Intrinsics.checkNotNullParameter(joinGuildSig, "joinGuildSig");
        this.guildId = guildId;
        this.guildAvatarUrl = guildAvatarUrl;
        this.guildName = guildName;
        this.confId = i3;
        this.joinGuildSig = joinGuildSig;
    }

    /* renamed from: a, reason: from getter */
    public final int getConfId() {
        return this.confId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildAvatarUrl() {
        return this.guildAvatarUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavCategoryFeaturedItemData)) {
            return false;
        }
        NavCategoryFeaturedItemData navCategoryFeaturedItemData = (NavCategoryFeaturedItemData) other;
        if (Intrinsics.areEqual(this.guildId, navCategoryFeaturedItemData.guildId) && Intrinsics.areEqual(this.guildAvatarUrl, navCategoryFeaturedItemData.guildAvatarUrl) && Intrinsics.areEqual(this.guildName, navCategoryFeaturedItemData.guildName) && this.confId == navCategoryFeaturedItemData.confId && Intrinsics.areEqual(this.joinGuildSig, navCategoryFeaturedItemData.joinGuildSig)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.guildId.hashCode() * 31) + this.guildAvatarUrl.hashCode()) * 31) + this.guildName.hashCode()) * 31) + this.confId) * 31) + this.joinGuildSig.hashCode();
    }

    @NotNull
    public String toString() {
        return "NavCategoryFeaturedItemData(guildId=" + this.guildId + ", guildAvatarUrl=" + this.guildAvatarUrl + ", guildName=" + this.guildName + ", confId=" + this.confId + ", joinGuildSig=" + this.joinGuildSig + ")";
    }
}
