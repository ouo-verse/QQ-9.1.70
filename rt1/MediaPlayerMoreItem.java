package rt1;

import com.tencent.mobileqq.guild.media.core.data.p;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lrt1/f;", "Lrt1/a;", "", "other", "", "equals", "", "hashCode", "", "toString", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "b", "Ljava/util/List;", "()Ljava/util/List;", "userList", "<init>", "(Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rt1.f, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class MediaPlayerMoreItem extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<p> userList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MediaPlayerMoreItem(@NotNull List<? extends p> userList) {
        super("MediaPlayerMoreItem", null);
        Intrinsics.checkNotNullParameter(userList, "userList");
        this.userList = userList;
    }

    @NotNull
    public final List<p> b() {
        return this.userList;
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
        if (!Intrinsics.areEqual(MediaPlayerMoreItem.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.widget.user.model.MediaPlayerMoreItem");
        return false;
    }

    public int hashCode() {
        return (this.userList.hashCode() * 31) + getItemId().hashCode();
    }

    @NotNull
    public String toString() {
        return "MediaPlayerMoreItem(userList=" + this.userList + ")";
    }
}
