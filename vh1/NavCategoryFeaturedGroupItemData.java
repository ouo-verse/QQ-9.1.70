package vh1;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lvh1/c;", "Lvh1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/util/List;", "b", "()Ljava/util/List;", "guildAvatarUrlList", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "I", "()I", "confId", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vh1.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class NavCategoryFeaturedGroupItemData extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> guildAvatarUrlList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int confId;

    public NavCategoryFeaturedGroupItemData(@NotNull List<String> guildAvatarUrlList, @NotNull String title, int i3) {
        Intrinsics.checkNotNullParameter(guildAvatarUrlList, "guildAvatarUrlList");
        Intrinsics.checkNotNullParameter(title, "title");
        this.guildAvatarUrlList = guildAvatarUrlList;
        this.title = title;
        this.confId = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getConfId() {
        return this.confId;
    }

    @NotNull
    public final List<String> b() {
        return this.guildAvatarUrlList;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NavCategoryFeaturedGroupItemData)) {
            return false;
        }
        NavCategoryFeaturedGroupItemData navCategoryFeaturedGroupItemData = (NavCategoryFeaturedGroupItemData) other;
        if (Intrinsics.areEqual(this.guildAvatarUrlList, navCategoryFeaturedGroupItemData.guildAvatarUrlList) && Intrinsics.areEqual(this.title, navCategoryFeaturedGroupItemData.title) && this.confId == navCategoryFeaturedGroupItemData.confId) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.guildAvatarUrlList.hashCode() * 31) + this.title.hashCode()) * 31) + this.confId;
    }

    @NotNull
    public String toString() {
        return "NavCategoryFeaturedGroupItemData(guildAvatarUrlList=" + this.guildAvatarUrlList + ", title=" + this.title + ", confId=" + this.confId + ")";
    }
}
