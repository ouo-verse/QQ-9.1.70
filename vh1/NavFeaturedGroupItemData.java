package vh1;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\n\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\n8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006 "}, d2 = {"Lvh1/f;", "Lvh1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "guildAvatarUrlList", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "title", "I", "()I", "confId", "Z", "isLittleWorldCreate", "()Z", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProRecommendItem;", "e", "featuredGuilds", "<init>", "(Ljava/util/List;Ljava/lang/String;IZLjava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vh1.f, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class NavFeaturedGroupItemData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> guildAvatarUrlList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int confId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isLittleWorldCreate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<IGProRecommendItem> featuredGuilds;

    /* JADX WARN: Multi-variable type inference failed */
    public NavFeaturedGroupItemData(@NotNull List<String> guildAvatarUrlList, @NotNull String title, int i3, boolean z16, @NotNull List<? extends IGProRecommendItem> featuredGuilds) {
        Intrinsics.checkNotNullParameter(guildAvatarUrlList, "guildAvatarUrlList");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(featuredGuilds, "featuredGuilds");
        this.guildAvatarUrlList = guildAvatarUrlList;
        this.title = title;
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
    public final List<String> c() {
        return this.guildAvatarUrlList;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavFeaturedGroupItemData)) {
            return false;
        }
        NavFeaturedGroupItemData navFeaturedGroupItemData = (NavFeaturedGroupItemData) other;
        if (Intrinsics.areEqual(this.guildAvatarUrlList, navFeaturedGroupItemData.guildAvatarUrlList) && Intrinsics.areEqual(this.title, navFeaturedGroupItemData.title) && this.confId == navFeaturedGroupItemData.confId && this.isLittleWorldCreate == navFeaturedGroupItemData.isLittleWorldCreate && Intrinsics.areEqual(this.featuredGuilds, navFeaturedGroupItemData.featuredGuilds)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.guildAvatarUrlList.hashCode() * 31) + this.title.hashCode()) * 31) + this.confId) * 31;
        boolean z16 = this.isLittleWorldCreate;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.featuredGuilds.hashCode();
    }

    @NotNull
    public String toString() {
        return "NavFeaturedGroupItemData(guildAvatarUrlList=" + this.guildAvatarUrlList + ", title=" + this.title + ", confId=" + this.confId + ", isLittleWorldCreate=" + this.isLittleWorldCreate + ", featuredGuilds=" + this.featuredGuilds + ")";
    }
}
