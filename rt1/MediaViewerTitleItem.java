package rt1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001a\u0010\u000e\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lrt1/k;", "Lrt1/a;", "", "other", "", "equals", "", "hashCode", "", "toString", "b", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "itemId", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rt1.k, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MediaViewerTitleItem extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String itemId;

    public MediaViewerTitleItem() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // rt1.a
    @NotNull
    /* renamed from: a, reason: from getter */
    public String getItemId() {
        return this.itemId;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(MediaViewerTitleItem.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.user.model.MediaViewerTitleItem");
        return false;
    }

    public int hashCode() {
        return getItemId().hashCode();
    }

    @NotNull
    public String toString() {
        return "MediaViewerTitleItem(itemId=" + getItemId() + ")";
    }

    public /* synthetic */ MediaViewerTitleItem(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "MediaViewerTitleItem" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaViewerTitleItem(@NotNull String itemId) {
        super(itemId, null);
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.itemId = itemId;
    }
}
