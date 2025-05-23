package xu1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lxu1/g;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "title", "b", "desc", "imageUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xu1.g, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MissionPresentItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String desc;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String imageUrl;

    public MissionPresentItem(@NotNull String title, @NotNull String desc, @NotNull String imageUrl) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.title = title;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
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
        if (!(other instanceof MissionPresentItem)) {
            return false;
        }
        MissionPresentItem missionPresentItem = (MissionPresentItem) other;
        if (Intrinsics.areEqual(this.title, missionPresentItem.title) && Intrinsics.areEqual(this.desc, missionPresentItem.desc) && Intrinsics.areEqual(this.imageUrl, missionPresentItem.imageUrl)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.desc.hashCode()) * 31) + this.imageUrl.hashCode();
    }

    @NotNull
    public String toString() {
        return "MissionPresentItem(title=" + this.title + ", desc=" + this.desc + ", imageUrl=" + this.imageUrl + ")";
    }
}
